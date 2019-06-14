package cn.cllover.myblog.common.fifter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter
public class CORSFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(CORSFilter.class);
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //强转为浏览器可识别
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        //指定域
        httpServletResponse.setHeader("Access-Control-Allow-Origin","http://127.0.0.1");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        chain.doFilter(request, response);

    }

    public void init(FilterConfig filterConfig) {
        // something init
    }

    public void destroy() {
        // destroy something
    }
}
