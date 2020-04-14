package com.ianji.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 用户前端接口层
 * @author index
 */
@RestController
public class AuthController {

    @Resource
    private RestTemplate restTemplate;

    @HystrixCommand(defaultFallback = "")
    @GetMapping(value = "getUser")
    public String getUser(){
        return "this is  AAA";
    }
}
