package com.wistron.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: springCloud
 * @description:
 * @author: Cool
 * @create: 2021-01-14 09:11
 **/
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMain3366 {
     public static void main(String[] args) {
         SpringApplication.run(ConfigClientMain3366.class,args);
     }
}
