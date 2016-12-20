package colin.web.hitalkspace.controller.base;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author LinQiang on 2016/12/16.
 * @reviewer
 */
@RequestMapping("hitalk/manage")
public class BaseController {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;

    public HttpServletRequest getRequest() {
        return request;
    }

    @ModelAttribute
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    @ModelAttribute
    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public HttpSession getSession() {
        if (session == null) {
            session = request.getSession();
        }
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    /**
     * 获取远程客户端地址
     * @return
     */
    public String getCleintIp() {
        return this.getRequest().getRemoteAddr();
    }
}
