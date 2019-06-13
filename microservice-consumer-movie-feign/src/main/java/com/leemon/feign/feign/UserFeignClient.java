package com.leemon.feign.feign;

import com.leemon.feign.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
//使用eureka的话，name会默认查找eureka server中的服务
@FeignClient(name = "microservice-provider-user")

//也可以使用url来指定请求的地址(name属性不可省略,否则无法启动)
//@FeignClient(name = "aaaaaa",url = "http://localhost:8000/")
public interface UserFeignClient {
    @GetMapping("/users/{id}")
    User findById(@PathVariable("id") Long id);
}
