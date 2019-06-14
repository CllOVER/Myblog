package cn.cllover.myblog;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import tk.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
@MapperScan("cn.cllover.myblog.front.dao")  //使用tk注解
public class MyblogApplication {


    public static void main(String[] args) {

       Logger logger = LoggerFactory.getLogger(MyblogApplication.class);

        SpringApplication.run(MyblogApplication.class, args);
        logger.info("====================cllover--INFO============");
    }

    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("128KB");
        factory.setMaxRequestSize("256KB");
        return factory.createMultipartConfig();
    }
}
