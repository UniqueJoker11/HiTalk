package colin.web.hitalkspace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 创建人 LinQiang
 * 创建日期 2016/3/14
 * 项目名称 MiniBlog
 * 当前包名 colin.miniblog.controller
 */
@Controller
@RequestMapping("hi")
public class DashboardController {


  /**
   * 顯示後台登錄頁
   * @return
   */
  @RequestMapping(value = "login",method = RequestMethod.GET)
  public String showAdminLoginPage(){
    System.out.println("helkfweofrw");
    return "admin-login";
  }
  /**
   * 顯示後台管理主頁
   * @return
   */
  @RequestMapping(value = "dashboard", method = RequestMethod.GET)
  public String showDashboardPage() {
    return "dashboard";
  }

  @RequestMapping(value = "userLogin",method = RequestMethod.POST)
  @ResponseBody
  public String userLogin(String username,String password){
    return "{'user':'joker'}";
  }
}
