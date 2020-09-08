package com.zc.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zc.feign.ProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


    @Autowired
    private ProviderClient providerClient;

    @GetMapping("/test01")
    public String test(){
        return providerClient.test01();
    }

    @GetMapping("/test02")

    public String test02(Integer value){
        return providerClient.test03(value);
    }





}
