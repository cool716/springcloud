package com.wistron.springcloud.service.impl;

import com.wistron.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;


/**
 * @program: springCloud
 * @description:
 * @author: Cool
 * @create: 2021-01-16 18:44
 **/
@EnableBinding(Source.class)  //定义消息的推送管道
public class IMessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;   //消息发送管道

    public String send() {
        String serial= UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("**********serial"+serial);
        return null;
    }
}
