package com.leemon.config.controller;

import com.leemon.config.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author limenglong
 * @create 2019-05-31 18:19
 * @desc
 **/
@RestController
@RequestMapping("/movies")
public class MovieController {
    private final RestTemplate restTemplate;

    @Autowired
    public MovieController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/users/{id}")
    public User findById(@PathVariable("id") Long id) {

        return restTemplate.getForObject("http://microservice-provider-user/users/{id}", User.class, id);
    }
}
