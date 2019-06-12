package com.leemon.cloud.controller;

import com.leemon.cloud.entity.User;
import com.leemon.cloud.repository.UserRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author limenglong
 * @create 2019-05-15 10:02
 * @desc
 **/
@RestController
@RequestMapping("/users")
@Configuration
@Log
public class UserController {

    @Value("${server.port}")
    private String port;


    private final UserRepository userRepository;


    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping(value = "/{id}", produces = "application/json;charset=UTF-8")
    public Optional<User> findById(@PathVariable("id") Long id) {
        log.info("端口：" + port + " 的微服务执行了查询");
        return userRepository.findById(id);
    }
}
