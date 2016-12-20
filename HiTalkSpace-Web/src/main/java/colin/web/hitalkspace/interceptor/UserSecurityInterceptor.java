package colin.web.hitalkspace.interceptor;

import colin.web.hitalkspace.pojo.User;
import colin.web.hitalkspace.utils.AESUtil;
import colin.web.hitalkspace.utils.LoggerUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 处理用户信息安全校验
 *
 * @author LinQiang on 2016/12/16.
 * @reviewer
 */

public class UserSecurityInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private LoggerUtils loggerUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        Cookie[] userCookies = request.getCookies();
        String username = null, password = null;
        for (Cookie userCookie : userCookies) {
            //获取用户名
            if (userCookie.getName().equals("name")) {
                username = userCookie.getValue();
            } else if (userCookie.getName().equals("pwd")) {
                password = userCookie.getValue();
            } else {
                continue;
            }
        }
        //判断用户名和密码是否为空
        if (null != username && null != password) {
            //从session中获取用户的信息，对比数据
            //先查询用户名是否在session中，如果在在校验密码
            HttpSession httpSession = request.getSession();
            String psdInSession = ((User) httpSession.getAttribute(username)).getPassword();
            if (!StringUtils.isEmpty(psdInSession)) {
                if (psdInSession.equals(AESUtil.decrypt(password))) {
                    return true;
                }
            }
            //如果Session已经不存在则跳转登录页面,清空session
            redirectToLogin(true,userCookies,response);
            return false;
        } else {
            //跳转到登录页面
            redirectToLogin(false,null,response);
            return false;
        }
    }

    /**
     * 重定向到用户登陆页面
     * @param clearCookie
     * @param userCookies
     * @param response
     */
    public void redirectToLogin(boolean clearCookie,Cookie[] userCookies, HttpServletResponse response) {
        if (clearCookie){
            if (userCookies!=null&&userCookies.length>0){
                for (Cookie cookie : userCookies) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
        try {
            response.sendRedirect("hitalk/manage/login");
        } catch (IOException e) {
            loggerUtils.error("用户信息校验拦截器重定向到登录页边异常：" + e.getMessage(), UserSecurityInterceptor.class);
        }
    }
}
