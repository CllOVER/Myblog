package cn.cllover.myblog.common.Manager;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/*
* 全局异常配置
* */
public class MyExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv = new ModelAndView();
        FastJsonJsonView view = new FastJsonJsonView();
        Map<String, Object> attributes = new HashMap<String, Object>();
        //触发异常执行函数
        if (ex instanceof UnauthenticatedException) {
            attributes.put("code", "501");
            attributes.put("msg", "token错误");
        } else if (ex instanceof UnauthorizedException) {
            attributes.put("code", "502");
            attributes.put("msg", "用户无权限");
        } else {
            attributes.put("code", "503");
            attributes.put("msg", ex.getMessage());
        }
        view.setAttributesMap(attributes);
        mv.setView(view);
        return mv;
    }

}
