package com.wistron.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: springCloud
 * @description:
 * @author: Cool
 * @create: 2021-01-13 10:11
 **/
@SpringBootApplication
@EnableEurekaClient
public class GatewayMain9527 {
     public static void main(String[] args) {
         SpringApplication.run(GatewayMain9527.class,args);
     }
}
