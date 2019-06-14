package cn.cllover.myblog.common.Manager;

import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.util.StringUtils;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

public class MySessionManager extends DefaultWebSessionManager {
    /**
     * 获取请求头中key为“Authorization”的value == sessionId
     */
    private static final String TOKEN = "Authorization";
    private static final String REFERENCED_SESSION_ID_SOURCE = "cookie";
    public MySessionManager() {
        super();
    }
    /**
     *  @Description shiro框架 自定义session获取方式<br/>
     *  可自定义session获取规则。这里采用ajax请求头 {@link AUTHORIZATION}携带sessionId的方式
     */

    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        String id = WebUtils.toHttp(request).getHeader(TOKEN);
        //如果请求头中有 token 则其值为sessionId
        if (!StringUtils.isEmpty(id)) {
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, REFERENCED_SESSION_ID_SOURCE);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, id);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
            return id;
        } else {
            //按默认规则从cookie取sessionId
            return super.getSessionId(request, response);
        }
    }

}
