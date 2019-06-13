package com.leemon.hystrix.controller;

import com.leemon.hystrix.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

/**
 * @author limenglong
 * @create 2019-06-13 18:06
 * @desc
 **/
@Slf4j
@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "findByIdFallBack")
    @GetMapping("/users/{id}")
    public User findById(@PathVariable("id") Long id) {
        return restTemplate.getForObject("http://microservice-provider-user/users/{id}", User.class, id);
    }


    public User findByIdFallBack(Long id,Throwable throwable) {
        log.error("进入回退方法",throwable);
        return new User(id, "默认用户", "默认用户", 0, new BigDecimal(1));
    }
}
