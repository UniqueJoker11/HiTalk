package colin.web.hitalkspace.controller;

import colin.web.hitalkspace.annotation.UserParam;
import colin.web.hitalkspace.business.inter.IUserService;
import colin.web.hitalkspace.constant.Constant;
import colin.web.hitalkspace.controller.extend.ExtendController;
import colin.web.hitalkspace.model.UserMenu;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 创建人 LinQiang
 * 创建日期 2016/3/14
 * 项目名称 MiniBlog
 * 当前包名 colin.miniblog.controller
 */
@Controller
@RequestMapping("hi")
public class DashboardController extends ExtendController {


    @Autowired
    private IUserService userService;

    /**
     * @param username
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "menu_info", method = RequestMethod.POST)
    public Object getDashboardMenuInfo(@UserParam String username) {
        if (StringUtils.isBlank(username)) {
            return super.returnErrorResponseInfo(Constant.ERROR.PARAMS_EMPTY_ERROR, "【获取面板菜单】用户信息为空！");
        }
        List<UserMenu> userMenuList = userService.getUserMenusInfo(username);
        return userMenuList;
    }
}
