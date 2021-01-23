package com.wistron.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wistron.springcloud.entities.Payment;
import com.wistron.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: springCloud
 * @description:
 * @author: Cool
 * @create: 2021-01-11 09:11
 **/
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentOk(@PathVariable("id") Integer id){
        String result=paymentHystrixService.paymentOk(id);
        return  result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutFallbackMethod",commandProperties = {
//            //设置峰值，超过 3 秒，就会调用兜底方法，这个时间也可以由feign控制
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand
    public String paymentTimeOut(@PathVariable("id") Integer id){
        int age=10/0;
        String result=paymentHystrixService.paymentTimeOut(id);
        return  result;
    }

    public String paymentInfo_timeoutFallbackMethod(@PathVariable("id") Integer id){
        return  "我是消费方80，对方支付系统繁忙，请10秒以后重试，或者自己运行出错请检查自己/(ㄒoㄒ)/~~";
    }
    //全局fallback
    public String payment_Global_FallbackMethod(){
        return  "Global  异常处理信息，请稍后重试   /(ㄒoㄒ)/~~";
    }

}

