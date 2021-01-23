package com.wistron.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springCloud
 * @description:
 * @author: Cool
 * @create: 2021-01-22 18:47
 **/

@RestController
@RefreshScope    //支持Nacos的动态刷新功能
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public  String  getConfigInfo(){
        return  configInfo;
    }

}
