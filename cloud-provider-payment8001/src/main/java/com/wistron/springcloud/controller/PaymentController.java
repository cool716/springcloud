package com.wistron.springcloud.controller;

import com.wistron.springcloud.entities.CommonResult;
import com.wistron.springcloud.entities.Payment;
import com.wistron.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.InterruptedIOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @program: springCloud
 * @description: 订单
 * @author: Cool
 * @create: 2021-01-02 15:07
 **/
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;


    @PostMapping("/payment/insert")
    public CommonResult<Payment> insert(@RequestBody Payment payment){
       int result= paymentService.create(payment);
       log.info("***********插入结果："+result);
       if (result>0){
           return new CommonResult(200,"插入成功！！serverPort="+serverPort,result);
       }else{
           return new CommonResult(500,"插入数据库失败！！");
       }
    }

    @GetMapping("/payment/getPayment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment=paymentService.getByPrimaryKey(id);
        if (payment !=null){
            return new CommonResult(200,"查询成功！！serverPort="+serverPort,payment);
        }else {
            return new CommonResult(400,"没有对应数据！！，查询ID:"+id);
        }
    }

   @GetMapping("/payment/discovery")
    public Object discovery(){
       List<String> services = discoveryClient.getServices();
       for(String service: services){
           log.info("*****service: " + service);
       }
       List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVER");
       for(ServiceInstance serviceInstance:instances){
           log.info(serviceInstance.getServiceId() + "\t" + serviceInstance.getHost()
                   + "\t" + serviceInstance.getPort() + "\t" + serviceInstance.getUri());
       }
       return this.discoveryClient;
    }

    @GetMapping("/payment/lb")
    public  String getServerPort(){
        return  serverPort;
    }

    @GetMapping("/payment/feign/timeout")
    public  String paymentFeignTimeOut()  {
        //暂停三秒
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return  serverPort;
    }

    @GetMapping("/payment/zipkin")
    public  String paymentZipkin(){
        return  "hello I am is paymentZipkin server fall back O(∩_∩)O哈哈~";
    }
}
