package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by chenyanhong on 2017/8/17.
 */
@RestController
@RequestMapping("/hello")
public class MyController {
    @Resource
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @RequestMapping("/sayHello")
    public String index(){
        return "homePage....";
    }

    @RequestMapping("/redis")
    public String testRedis(){
        stringRedisTemplate.opsForValue().set("name", "cyh");
        String name = stringRedisTemplate.opsForValue().get("name");
        System.out.println(name);
        return name;
    }
}
