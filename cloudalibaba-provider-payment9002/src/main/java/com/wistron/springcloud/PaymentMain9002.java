package com.wistron.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: springCloud
 * @description:
 * @author: Cool
 * @create: 2021-01-21 18:57
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain9002 {
     public static void main(String[] args) {
         SpringApplication.run(PaymentMain9002.class,args);
     }
}
