package com.ssai.config;

import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {
    @Bean//将当前方法的返回值对象交给IOC容器管理，成为IOC容器bean
    //通过@Bean 注解的name/value属性指定bean名称，如果未指定，默认是方法名
    public SAXReader saxReader(){
        return new SAXReader();
    }
}
