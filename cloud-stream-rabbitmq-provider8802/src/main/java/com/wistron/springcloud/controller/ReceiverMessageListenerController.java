package com.wistron.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springCloud
 * @description:
 * @author: Cool
 * @create: 2021-01-21 08:37
 **/
@Component
@EnableBinding(Sink.class)
public class ReceiverMessageListenerController {

    @Value("${serve.port}")
    private String servePort;


    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("消费者1号，---》收到的消息"+message.getPayload()+"\t    port:"+servePort);
    }



}
