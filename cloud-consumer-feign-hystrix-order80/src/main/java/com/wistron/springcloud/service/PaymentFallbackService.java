package com.wistron.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @program: springCloud
 * @description:
 * @author: Cool
 * @create: 2021-01-11 09:56
 **/
@Component
public class PaymentFallbackService implements  PaymentHystrixService {

    public String paymentOk(Integer id) {
        return "---------PaymentFallbackService---fall back--------paymentOk  /(ㄒoㄒ)/~~";
    }

    public String paymentTimeOut(Integer id) {
        return "---------PaymentFallbackService---fall back--------paymentTimeOut  /(ㄒoㄒ)/~~";
    }
}
