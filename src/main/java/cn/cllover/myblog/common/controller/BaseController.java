package cn.cllover.myblog.common.controller;

import cn.cllover.myblog.front.pojo.User;
import com.github.pagehelper.PageHelper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import java.util.Map;

public class BaseController {

    protected static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    protected User getCurrentUser() {
        return (User) getSubject().getPrincipal();
    }

    //当前session信息
    protected Session getSession(){
     return getSubject().getSession();
    }

    protected Session getSession(Boolean temp){
        return getSubject().getSession(temp);
    }

}
