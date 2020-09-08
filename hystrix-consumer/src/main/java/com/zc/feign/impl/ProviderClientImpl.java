package com.zc.feign.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zc.feign.ProviderClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class ProviderClientImpl implements ProviderClient {
    @Override
    public String test01() {
        return "服务降级了";
    }



    @Override
    public String test03(@RequestParam("value") Integer value){
        return "服务熔断了";
    }
}
