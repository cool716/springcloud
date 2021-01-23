package com.wistron.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: springCloud
 * @description:
 * @author: Cool
 * @create: 2021-01-22 18:45
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigClientMain3377 {
     public static void main(String[] args) {
         SpringApplication.run(NacosConfigClientMain3377.class,args);
     }

}
