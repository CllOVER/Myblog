package cn.cllover.myblog.common.Realm;

import cn.cllover.myblog.front.pojo.User;
import cn.cllover.myblog.front.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

@Autowired
private UserService userService;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        // 将AuthenticationToken强转为AuthenticationToken对象
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        // 获得从表单传过来的用户名
        String userName = upToken.getUsername();
        //丛数据库中获取
        User user = userService.selectBypassword(userName);

        if (user == null){
            throw new UnknownAccountException("用户名不存在，请注册");
        }
        if (user.getUserStatus() == 0){
            throw new LockedAccountException("账户被锁定！");
        }
        ByteSource salts = ByteSource.Util.bytes(user.getUserName());
        // 创建SimpleAuthenticationInfo对象，并且把username和password等信息封装到里面
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getUserPass(),salts,getName());
        //获取session 默认超时时间1800000
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("USER_SESSION",user);
        return info;

    }



}
