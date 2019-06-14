package cn.cllover.myblog.common.config;

import cn.cllover.myblog.common.Manager.MyExceptionHandler;
import cn.cllover.myblog.common.Realm.UserRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.util.LinkedHashMap;
import java.util.Map;

/*
* shiro配置
* */
@Configuration
public class ShiroConfig {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Bean
    public ShiroFilterFactoryBean shiroFilterFactory(DefaultWebSecurityManager securityManager) {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置webSecurityManager 为自定义配置
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //p配置拦截器信息
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap();
        //设置登录url
        shiroFilterFactoryBean.setLoginUrl("/login");
        //设置登录成功跳转界面
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //未授权的界面
        shiroFilterFactoryBean.setUnauthorizedUrl("/404");
        //放行
        filterChainDefinitionMap.put("/defaultKaptcha","anon");
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/static/**","anon");
        filterChainDefinitionMap.put("/**", "authc");
        filterChainDefinitionMap.put("/logout", "anon");
        //设置以上配置信息
            /*LinkedHashMap fifterMap = new LinkedHashMap();
            fifterMap.put("/logout", "logout");*/

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /*
     * 凭证匹配器
     * 交由Simple Info处理密码问题
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");// 散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(1024);// 散列的次数，
        return hashedCredentialsMatcher;
    }
    /**
     * 记住密码Cookie
     * @return
     */
    @Bean
    public SimpleCookie rememberMeCookie() {
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        simpleCookie.setHttpOnly(true);
        simpleCookie.setMaxAge(7 * 24 * 60 * 60);//7天
        return simpleCookie;
    }

    /*
    * 自定义Realm
    * @return
    * */

    @Bean
    public UserRealm userRealm() {
        UserRealm userRealm = new UserRealm();
        userRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return userRealm;
    }

    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 注入自定义的realm;
        securityManager.setRealm(userRealm());
        //用了redis缓存注入安全管理器， 实体类加入序列化操作
        securityManager.setCacheManager(cacheManager());
        //缓存共享
        securityManager.setSessionManager(SessionManager());
        return securityManager;
    }

    /*
     * 开启shiro aop注解支持
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(
            DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * DefaultAdvisorAutoProxyCreator，AOP代理。
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
        defaultAAP.setProxyTargetClass(true);
        return defaultAAP;
    }


    /*
     * redis缓存管理器
     * @return
     */
    @Bean
    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost("118.89.216.28");
        redisManager.setPort(6379);
        redisManager.setTimeout(18000);// 配置过期时间
        return redisManager;
    }

    /*
    * 需要注入对应的其它的实体类中-->shiro缓存管理器
    * @return
    * */
    @Bean
    public CacheManager cacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        return redisCacheManager;
    }


    /**
     * RedisSessionDAO shiro sessionDao层的实现 通过redis
     * @return
     */
    public RedisSessionDAO redisSessionDAO() {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
        return redisSessionDAO;
    }
    /**
     * shiro session管理
     * @return
     */
    public DefaultWebSessionManager SessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionDAO(redisSessionDAO());
        return sessionManager;
    }
    /**
     * 注册全局异常处理
     * @return
     */
    @Bean(name = "exceptionHandler")
    public HandlerExceptionResolver handlerExceptionResolver() {
        return new MyExceptionHandler();
    }



}
