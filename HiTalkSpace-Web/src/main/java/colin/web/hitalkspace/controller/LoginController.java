package colin.web.hitalkspace.controller;

import colin.web.hitalkspace.business.inter.IUserService;
import colin.web.hitalkspace.controller.base.BaseController;
import colin.web.hitalkspace.pojo.User;
import colin.web.hitalkspace.utils.AESUtil;
import colin.web.hitalkspace.utils.LoggerUtils;
import colin.web.hitalkspace.wrapper.UserWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;

/**
 * @author LinQiang on 2016/12/16.
 * @reviewer
 */
@Controller
public class LoginController extends BaseController {

    //最大过期时间
    private final int COOKIE_MAXAGE=60*60;
    @Resource
    private LoggerUtils loggerUtils;
    @Resource
    private IUserService userService;
    /**
     * 显示登录页面
     *
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String showLogin() {
        return "signin";
    }

    /**
     * 用户登录
     *
     * @param wrapper
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String userLogin(UserWrapper wrapper) {
        if (null==wrapper|| StringUtils.isEmpty(wrapper.getUsername())||StringUtils.isEmpty(wrapper.getPassword())){
            return "signin";
        }
        //登录校验
        User userInfo=userService.userLoginService(wrapper.getUsername(),wrapper.getPassword());
        if (null==userInfo){
            return "signin";
        }else{
            //添加session
            super.getSession().setAttribute(wrapper.getUsername(),userInfo);
            Cookie userCookie=new Cookie("username",wrapper.getUsername());
            Cookie userPswCookid=null;
            try {
                userPswCookid =new Cookie("psw", AESUtil.encrypt(userInfo.getPassword()));
            } catch (Exception e) {
                loggerUtils.error("【用户登录】用户"+wrapper.getUsername()+"密码AES加密异常"+e.getMessage(),LoginController.class);
            }
            //统一配置cookie过期时间,1个小时
            userCookie.setMaxAge(COOKIE_MAXAGE);
            userPswCookid.setMaxAge(COOKIE_MAXAGE);
            super.getResponse().addCookie(userCookie);
            super.getResponse().addCookie(userPswCookid);
            return "index";
        }

    }
}
