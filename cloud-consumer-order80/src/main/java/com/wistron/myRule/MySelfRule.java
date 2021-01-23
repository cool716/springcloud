package com.wistron.myRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: springCloud
 * @description:
 * @author: Cool
 * @create: 2021-01-09 10:45
 **/
@Configuration
public class MySelfRule {
    @Bean
    public IRule getRule(){
        return  new RandomRule();//负载均衡规则定义为随机
    }

}
