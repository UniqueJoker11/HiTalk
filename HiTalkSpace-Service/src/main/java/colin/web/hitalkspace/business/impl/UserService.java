package colin.web.hitalkspace.business.impl;


import colin.web.hitalkspace.core.dao.UserDao;
import colin.web.hitalkspace.pojo.User;
import colin.web.hitalkspace.business.inter.IUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
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

    /**
     * 驗證用戶登錄
     *
     * @param username
     * @param password
     * @return
     */
    @Cacheable(value = "userCache",key = "#username")
    @Override
    public User userLoginService(String username, String password) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("username", username);
        User user = userDao.getUserInfo(params);
        if (null==user||!user.getPassword().equals(DigestUtils.md5Hex(password))){
            return null;
        }else{
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

}
