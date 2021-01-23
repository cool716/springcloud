package com.wistron.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @program: springCloud
 * @description:
 * @author: Cool
 * @create: 2021-01-08 08:51
 **/
@RestController
@Slf4j
public class OrderZkController {
    public static final String  INVOKE_URL="http://cloud-provider-service";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String paymentInfo(){
        String result=restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
        return  result;
    }

}
