package colin.web.hitalkspace.business.impl;


import colin.web.hitalkspace.core.dao.RoleMenuDao;
import colin.web.hitalkspace.core.dao.UserDao;
import colin.web.hitalkspace.core.dao.UserRoleDao;
import colin.web.hitalkspace.model.UserMenu;
import colin.web.hitalkspace.pojo.*;
import colin.web.hitalkspace.business.inter.IUserService;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import netscape.javascript.JSObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 创建人 LinQiang
 * 创建日期 2016/3/14
 * 项目名称 MiniBlog
 * 当前包名 colin.miniblog.service.inter
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private RoleMenuDao roleMenuDao;

    /**
     * 驗證用戶登錄
     *
     * @param username
     * @param password
     * @return
     */
    @Cacheable(value = "userInfoCache", key = "#username")
    @Override
    public User userLoginService(String username, String password) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("username", username);
        User user = userDao.getUserInfo(params);
        if (null == user || !user.getPassword().equals(DigestUtils.md5Hex(password))) {
            return null;
        } else {
            return user;
        }
    }

    /**
     * 用戶註冊
     *
     * @param userInfo
     * @return
     */
    @Override
    public User userRegisterService(Map<String, Object> userInfo) {
        User user = new User();
    /*user.setUsername(username);
    user.setPassword(DigestUtils.md5Hex(password));*/
        return userDao.insertUser(user);
    }

    /**
     * 用戶信息更新
     *
     * @param userInfo
     * @return
     */
    @Override
    public int userUpdateService(Map<String, Object> userInfo) {
        return 0;
    }

    /**
     * 根據id刪除用戶
     *
     * @param id
     * @return
     */
    @Override
    public int userDeleteService(int id) {
        return 0;
    }

    /**
     * 获取用户的角色
     *
     * @param username
     * @return
     */
    @Cacheable(value = "userInfoCache", key = "#username+'_role'")
    @Override
    public List<Role> getUserRoles(String username) {
        List<Role> userRolesInfo = userRoleDao.selectUserRolesInfo(username);
        if (null == userRolesInfo || userRolesInfo.isEmpty()) {
            //用户的角色为空
            return null;
        } else {
            return userRolesInfo;
        }
    }

    /**
     * 获取用户的菜单
     *
     * @param username
     * @return
     */
    @Override
    public List<UserMenu> getUserMenusInfo(String username) {
        List<Integer> userRoleIds = userRoleDao.selectUserRoleId(username);
        if (null == userRoleIds || userRoleIds.isEmpty()) {
            return null;
        } else {
            //查询用户的菜单信息
            List<Menu> userMenuInfo = roleMenuDao.selectUserRoleMenuId(userRoleIds);
            List<Menu> userRootMenus = new ArrayList<Menu>();
            List<Menu> userSubMenus = new ArrayList<Menu>();
            //筛选跟路径
            for (Menu menu : userMenuInfo) {
                if (menu.getParentid() == 0) {
                    userRootMenus.add(menu);
                } else {
                    userSubMenus.add(menu);
                }
            }
            List<UserMenu> userMenusResult = this.combineSubUserMenu(userRootMenus, userSubMenus);
            return userMenusResult;
        }
    }

    /**
     * 组装用户的菜单(暂且按照二级菜单进行处理)
     *
     * @param userRootMenus
     * @param userSubMenus
     * @return
     */
    private List<UserMenu> combineSubUserMenu(List<Menu> userRootMenus, List<Menu> userSubMenus) {
        if (null == userRootMenus || null == userSubMenus || userRootMenus.isEmpty() || userSubMenus.isEmpty()) {
            return null;
        } else {
            List<UserMenu> userMenus = new ArrayList<>();
            for (Menu rootMenu : userRootMenus) {
                UserMenu rootUserMenu = this.wrapperSimpleUserMenu(rootMenu);
                List<UserMenu> subUserMenuList = new ArrayList<>();
                for (Menu subMenu : userSubMenus) {
                    if (rootMenu.getId() == subMenu.getParentid()) {
                        subUserMenuList.add(this.wrapperSimpleUserMenu(subMenu));
                    }
                }
                rootUserMenu.setSubUserMenu(subUserMenuList);
            }
            return userMenus;
        }
    }

    /**
     * 包装UserMenu
     *
     * @param menu
     * @return
     */
    private UserMenu wrapperSimpleUserMenu(Menu menu) {
        if (null == menu) {
            return null;
        }
        UserMenu userMenu = new UserMenu();
        userMenu.setName(menu.getName());
        userMenu.setLevel(menu.getLevel());
        userMenu.setSort(menu.getSort());
        userMenu.setType(menu.getType());
        userMenu.setUrl(menu.getUrl());
        userMenu.setUrlkey(menu.getUrlkey());
        return userMenu;
    }
}
