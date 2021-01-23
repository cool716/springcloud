package com.wistron.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @program: springCloud
 * @description:
 * @author: Cool
 * @create: 2021-01-22 17:44
 **/
@RestController
@Slf4j
@RequestMapping("/cunsmer")
public class OrderNacosController {
    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String  serverUrl;

    @GetMapping("/payment/nacos/{id}")
    public String  paymentInfo(@PathVariable("id") Integer id){
        return  restTemplate.getForObject(serverUrl+"/payment/nocas/"+id,String.class);
    }

}
