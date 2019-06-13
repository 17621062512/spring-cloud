package com.leemon.feign.controller;

import com.leemon.feign.entity.User;
import com.leemon.feign.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author limenglong
 * @create 2019-06-13 16:26
 * @desc
 **/
@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/users/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userFeignClient.findById(id);
    }

}
