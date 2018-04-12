package com.newkdd.admin.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Mike on 2018/4/11.
 */
@Controller
@Configuration
@EnableDiscoveryClient
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"com.newkdd.admin", "com.newkdd.framework"})
@MapperScan(basePackages = {"com.newkdd.admin.dao"})
public class AdminApplication extends WebMvcConfigurerAdapter {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }
}
