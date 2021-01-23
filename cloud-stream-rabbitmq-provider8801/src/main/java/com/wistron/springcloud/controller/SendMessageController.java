package com.wistron.springcloud.controller;

import com.wistron.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: springCloud
 * @description:
 * @author: Cool
 * @create: 2021-01-16 18:54
 **/
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public  String sendMessage(){
        return  messageProvider.send();
    }



}
