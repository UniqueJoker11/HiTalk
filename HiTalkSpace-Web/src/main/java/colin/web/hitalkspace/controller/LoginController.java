package colin.web.hitalkspace.controller;

import colin.web.hitalkspace.controller.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author LinQiang on 2016/12/16.
 * @reviewer
 */
@Controller
public class LoginController extends BaseController {
    /**
     * 显示登录页面
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String showLogin(){
        return "signin";
    }
}
