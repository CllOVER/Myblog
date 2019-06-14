package cn.cllover.myblog.front.controller;

import cn.cllover.myblog.common.annotion.SLog;
import cn.cllover.myblog.common.controller.BaseController;
import cn.cllover.myblog.common.util.IPUtil;
import cn.cllover.myblog.front.dao.CodeMapper;
import cn.cllover.myblog.front.dao.LoginCodeMapper;
import cn.cllover.myblog.front.pojo.Code;
import cn.cllover.myblog.front.pojo.LoginCode;
import cn.cllover.myblog.front.pojo.User;
import cn.cllover.myblog.front.service.UserService;
import com.alibaba.fastjson.JSONObject;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.authc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.SpelEvaluationException;
import org.springframework.expression.spel.SpelMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.net.CookieStore;
import java.util.Collection;
import java.util.Date;

@Controller
public class loginController  extends BaseController {

    @Autowired
    private CodeMapper codeMapper;
    @Autowired
    private LoginCodeMapper loginCodeMapper;
    @Autowired
    private DefaultKaptcha defaultKaptcha;
    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/login")
    public String loginPage(){
        return "login";
    }

    @RequestMapping("/defaultKaptcha")
    public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws Exception {

        String rightCode;
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            // 形成验证码并存入session
             rightCode = defaultKaptcha.createText();
            httpServletRequest.getSession().setAttribute("rightCode", rightCode);
            // 使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(rightCode);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //将验证码 ，ip写入数据库
        String ipAddress = IPUtil.getIpAddress(httpServletRequest);
        Code code = new Code();
        code.setCodeRightCode(rightCode);
        code.setCodeAddressIp(ipAddress);
        code.setCodeDate(new Date());
        System.out.println(code);
        codeMapper.insert(code);


        // 定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("images/jpeg");
        ServletOutputStream responseOutputStream = httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        //关闭流
        responseOutputStream.close();
    }

    @SLog("登录")
    @PostMapping("login")
    @ResponseBody
    public String login(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,
                        String userName ,String userPass ,String tryCode,boolean rememberMe){
        JSONObject jsonObject = new JSONObject();
        String rightCode = (String) httpServletRequest.getSession().getAttribute("rightCode");
        System.out.println("rightCode:"+rightCode+" ———— tryCode:"+tryCode);
        if (!StringUtils.isNotBlank(tryCode)){
            jsonObject.put("msg", "请输入验证码!");
        }else if (!rightCode.equals(tryCode)){
            jsonObject.put("msg", "验证码错误");
        }else {
            jsonObject.put("msg", "验证成功");
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName,userPass,rememberMe);
            Subject subject = SecurityUtils.getSubject();
            try {
                //登录
                subject.login(usernamePasswordToken);
                //获取当前sessionid
                    jsonObject.put("token",subject.getSession().getId());
                    jsonObject.put("msg", "登陆成功");
                    jsonObject.put("success","0");

                    LoginCode loginCode = new LoginCode();
                    loginCode.setLoginCodeUsername(userName);
                    loginCode.setLoginCodeRightcode(rightCode);
                    loginCode.setLoginCodeTrycode(tryCode);
                    loginCode.setLoginIp(httpServletRequest.getLocalAddr());
                    loginCode.setLoginDate(new Date());
                    loginCodeMapper.insert(loginCode);

            } catch (IncorrectCredentialsException e) {
                jsonObject.put("msg", "密码错误");
            } catch (LockedAccountException e) {
                jsonObject.put("msg", "账号被锁定");
            } catch (UnknownAccountException e) {
                jsonObject.put("msg", "账号不存在");
            } catch (NullPointerException e) {
                jsonObject.put("msg", "账号不存在");
            }
        }
        return jsonObject.toString();
    }


    @SLog("首页")
    @RequestMapping("index")
    public String index(Model model ,HttpSession session,HttpServletRequest httpServletRequest)  {
        User user =super.getCurrentUser();
        model.addAttribute("user",user);
        System.out.println("当前用户"+user);
        return "index";
    }

       @RequestMapping("/logout")
    public String logout(){
           Subject subject = SecurityUtils.getSubject();
           subject.logout();
           return "login";
       }
}
