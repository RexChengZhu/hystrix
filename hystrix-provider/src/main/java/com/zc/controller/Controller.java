package com.zc.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/test01")
    public String test01(){
        int i = 1/0;
        return "test01";
    }


    @HystrixCommand(fallbackMethod = "back",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    @GetMapping("/test02")
    public String test02(){
        try {
            Thread.sleep(3000);
        }catch (Exception e){

        }
        return "test02";
    }
    public String back(){
        return "牛逼";
    }



    @GetMapping("/test03")
    @HystrixCommand(fallbackMethod = "fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    public String test03(Integer value){
        System.out.println("被调用");
        if (value>10){
            int i = 10/0;
        }

        return "test03";
    }

    public String fallback(Integer value){
        return "熔断后返回的友好提示";
    }
}
