package com.wistron.springcloud.controller;

import com.wistron.springcloud.entities.CommonResult;
import com.wistron.springcloud.entities.Payment;
import com.wistron.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: springCloud
 * @description:
 * @author: Cool
 * @create: 2021-01-09 14:16
 **/
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/getPayment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
       return  paymentFeignService.getPaymentById(id);
    }
    @GetMapping("/consumer/payment/feign/timeout")
    public  String paymentFeignTimeOut()  {
        //openFeign-ribbon   客户端默认等待1秒
        return  paymentFeignService.paymentFeignTimeOut();
    }

}
