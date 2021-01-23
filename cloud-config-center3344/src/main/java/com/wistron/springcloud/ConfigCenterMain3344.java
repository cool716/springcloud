package com.wistron.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @program: springCloud
 * @description:
 * @author: Cool
 * @create: 2021-01-13 19:25
 **/
@SpringBootApplication
@EnableConfigServer
public class ConfigCenterMain3344 {
     public static void main(String[] args) {
         SpringApplication.run(ConfigCenterMain3344.class,args);
     }
}
