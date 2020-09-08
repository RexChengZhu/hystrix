package com.zc.feign;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zc.feign.impl.ProviderClientImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "provider", fallback = ProviderClientImpl.class)
public interface ProviderClient {
    @GetMapping("/test01")
    String test01();


    @GetMapping("/test03")

    String test03(@RequestParam("value") Integer value);



}
