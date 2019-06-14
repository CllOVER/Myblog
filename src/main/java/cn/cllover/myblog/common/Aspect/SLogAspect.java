package cn.cllover.myblog.common.Aspect;

import cn.cllover.myblog.common.controller.BaseController;
import cn.cllover.myblog.common.util.DateUtil;
import cn.cllover.myblog.common.util.IPUtil;
import cn.cllover.myblog.front.pojo.SLog;
import cn.cllover.myblog.front.pojo.User;
import cn.cllover.myblog.front.service.SLogService;
import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.xdevapi.JsonArray;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

@Aspect
@Component
public class SLogAspect  extends BaseController{

    private final static Logger logger = org.slf4j.LoggerFactory.getLogger(SLogAspect.class);

    @Autowired
    private SLogService sLogService;


    //自定义注解使用
    @Pointcut("@annotation(cn.cllover.myblog.common.annotion.SLog)")
    public void pointcut(){
    }

    @Around("pointcut()")
    public Object Around(ProceedingJoinPoint joinPoint){

        Object result = null;
        //获取
        long beginTime = System.currentTimeMillis();
        try{
            logger.info("目标方法在执行:---:" + joinPoint.getSignature().getName());
            result = joinPoint.proceed();
            long endTime = System.currentTimeMillis();
            saveLog(joinPoint,endTime-beginTime);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }

    private void saveLog(ProceedingJoinPoint joinPoint, long time) {
        //获取署名信息对象和相关方法名。
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取方法名

        Method method = signature.getMethod();
        SLog sLog = new SLog();

        //设置耗时
        sLog.setLogTime(time);
        //获取当前注解的属性
        cn.cllover.myblog.common.annotion.SLog annotation = method.getAnnotation(cn.cllover.myblog.common.annotion.SLog.class);
        if (annotation != null){
            sLog.setLogDesc(annotation.value());
        }
        // 请求的类名
        String logClass = joinPoint.getTarget().getClass().getName();
        sLog.setLogClass(logClass);
        // 请求的方法名
        String logMethod = signature.getName();
        sLog.setLogMethod(logMethod);
        // 请求的方法参数值
        String logParams = Arrays.toString(joinPoint.getArgs());
        sLog.setLogParams(logParams);
        //当前日期
        sLog.setLogDate(new Date());

        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //请求地址
        String requestURI = request.getRequestURI();
        sLog.setLogUrl(requestURI);
        //获取请求ip
        String ipAddress = IPUtil.getIpAddress(request);
        sLog.setLogIp(ipAddress);
        //获取当前用户
        User user = super.getCurrentUser();
        sLog.setLogUserId(user.getUserId());
        sLogService.saveAll(sLog);
        logger.info("当前请求用户id:{}；当前请求地址:{}；当前类名:{}",user.getUserId(),requestURI,logClass);
        logger.info("当前方法名:{}；当前方法参数值:{}",logMethod,logParams);


    }
}
