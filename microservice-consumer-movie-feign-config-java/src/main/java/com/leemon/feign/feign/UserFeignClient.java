package com.leemon.feign.feign;

import com.leemon.feign.entity.User;
import feign.Logger;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservice-provider-user", configuration = UserFeignConfig.class)
public interface UserFeignClient {

    @GetMapping("/users/{id}")
    User findById(@PathVariable("id") Long id);

}

class UserFeignConfig {
    @Bean
    public Logger.Level logger() {
        return Logger.Level.FULL;
    }
}
