package com.wistron.springcloud.service;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.IdcardUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @program: springCloud
 * @description:
 * @author: Cool
 * @create: 2021-01-09 15:28
 **/
@Component
public class PaymentService {
    /**
     * 正常访问
     * @param id
     * @return
     */
    public String paymentInfo_ok(Integer id){
        return  "线程池 ："+Thread.currentThread().getName()+"paymentInfo_ok,id="+id+"\t"+"O(∩_∩)O哈哈~";
    }

    /**
     *    延时3秒
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler",commandProperties = {
            //设置峰值，超过 3 秒，就会调用兜底方法，这个时间也可以由feign控制
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_timeout(Integer id){
        //int age=10/0;
       //线程睡眠，单位毫秒 1000=1秒
       try {
           TimeUnit.MILLISECONDS.sleep(3000);
       }catch (InterruptedException e){
           e.printStackTrace();
       }
        return  "线程池 ："+Thread.currentThread().getName()+
                "paymentInfo_timeout,id="+id+"\t"+"O(∩_∩)O哈哈~   耗时"+"timeNumber"+"秒钟";
    }


    public String paymentInfo_timeoutHandler(Integer id){
        return  "线程池 ："+Thread.currentThread().getName()+
                "8001系统繁忙或运行报错,请稍后再试，id="+id+"\t"+"/(ㄒoㄒ)/~~";
    }

    //===========服务熔断

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled", value="true"),  // 是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value="10"),  //请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="10000"), // 时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value="60"),  // 失败率达到多少后跳闸
            //整体意思：10秒内 10次请求，有6次失败，就跳闸
    })
    public  String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id<0){
            throw  new RuntimeException("*************id不能为负数");
        }
        String  serialNumber= IdUtil.simpleUUID();//hutool工具包
        return  Thread.currentThread().getName()+"调用成功，流水号："+serialNumber;
    }
    public  String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id不能为负数，请稍后再试 o(╥﹏╥)o   id：  "+id;
    }

}
