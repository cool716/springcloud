package com.wistron.springcloud.controller;

import com.wistron.springcloud.entities.CommonResult;
import com.wistron.springcloud.entities.Payment;
import com.wistron.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @program: springCloud
 * @description:
 * @author: Cool
 * @create: 2021-01-02 16:33
 **/
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {
    //    public static final String PAYMENT_URL="http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVER";

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/payment/insert")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/insert", payment, CommonResult.class);
        //return  restTemplate.postForEntity(PAYMENT_URL + "/payment/insert", payment, CommonResult.class).getBody();
    }

    @GetMapping("/payment/getPayment/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/getPayment/" + id, CommonResult.class);

    }

    @GetMapping("/payment/getPayment/getForEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/getPayment/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            System.out.println("-----------"+
                    entity.getStatusCode()+"/t"+entity.getHeaders()+"/t"+entity.getBody());
            return  entity.getBody();
        }else{
            return  new CommonResult<Payment>(400,"操作失败");
        }
    }
    @GetMapping("/payment/lb")
    public String  getPaymentLb() {
        // 获取CLOUD-PAYMENT-SERVER 所有的service
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVER");
        if (instances==null || instances.size()==0){
            return  null;
        }
        ServiceInstance serviceInstance = loadBalancer.instance(instances);
        URI uri=serviceInstance.getUri();
        return  restTemplate.getForObject(uri+"/payment/lb",String.class);
    }

    @GetMapping("/payment/zipkin")
    public String paymentzipkin() {
        return restTemplate.getForObject("http://localhost:8001" + "/payment/zipkin/", String.class);
    }

}
