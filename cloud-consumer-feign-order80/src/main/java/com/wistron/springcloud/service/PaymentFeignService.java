package com.wistron.springcloud.service;

import com.wistron.springcloud.entities.CommonResult;
import com.wistron.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVER")
public interface PaymentFeignService {

    @GetMapping("/payment/getPayment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/feign/timeout")
    public  String paymentFeignTimeOut();

}
