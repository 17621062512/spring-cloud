package com.leemon.cloud.controller;

import com.leemon.cloud.entity.User;
import com.leemon.cloud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping(value = "/{id}", produces = "application/json;charset=UTF-8")
    public Optional<User> findById(@PathVariable("id") Long id) {
        return userRepository.findById(id);
    }
}
