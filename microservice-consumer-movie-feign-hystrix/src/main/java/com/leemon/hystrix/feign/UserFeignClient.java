package com.leemon.hystrix.feign;


import com.leemon.hystrix.entity.User;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient(name = "microservice-provider-user", fallbackFactory = UserFeignClientFallBackFactory.class)
public interface UserFeignClient {

    @GetMapping("/users/{id}")
    User findById(@PathVariable("id") Long id);
}

@Component
@Slf4j
class UserFeignClientFallBackFactory implements FallbackFactory<UserFeignClient> {
    @Override
    public UserFeignClient create(Throwable throwable) {
        return id -> {
            log.error("进入回退逻辑", throwable);
            return new User(id, "默认用户", "默认用户", 0, new BigDecimal(1));
        };
    }

}