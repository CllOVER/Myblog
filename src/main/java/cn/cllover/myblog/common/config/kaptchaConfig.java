package cn.cllover.myblog.common.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import java.util.Properties;

/*
* kaptcha验证码组件
* */

@Component
public class kaptchaConfig {

    //自定义配置kaptcha
    @Bean
    public DefaultKaptcha getDefaultKaptcha(){

        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        //读写配置信息
        Properties properties = new Properties();
        //图片边框
        properties.setProperty("kaptcha.border","yes");
        //    边框颜色
        properties.setProperty("kaptcha.border.color","black");
        //图片宽
        properties.setProperty("kaptcha.image.width","120");
        //图片高
        properties.setProperty("kaptcha.image.height","40");
        //字体大小
        properties.setProperty("kaptcha.textproducer.font.size","30");
        //字体
        properties.setProperty("kaptcha.textproducer.font.names","微软雅黑");
        //验证码长度
        properties.setProperty("kaptcha.textproducer.char.length","4");
        //session key
        properties.setProperty("kaptcha.session.key","code");

        Config config = new Config(properties);
        //设置自定义参数配置
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}
