package com.wistron.springcloud;

import cn.hutool.db.sql.Order;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: springCloud
 * @description:
 * @author: Cool
 * @create: 2021-01-21 19:39
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class OrderNacosMain83 {
     public static void main(String[] args) {
         SpringApplication.run(OrderNacosMain83.class,args);
     }
}
