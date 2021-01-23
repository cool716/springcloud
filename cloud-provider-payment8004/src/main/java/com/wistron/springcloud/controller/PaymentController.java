package com.wistron.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @program: springCloud
 * @description:
 * @author: Cool
 * @create: 2021-01-06 15:58
 **/
@RestController
@Slf4j
public class PaymentController {


    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/zk")
    public  String paymentZk(){
        return "springcloud with Zookeeper: "+serverPort+"/t"+ UUID.randomUUID().toString();
    }

}
