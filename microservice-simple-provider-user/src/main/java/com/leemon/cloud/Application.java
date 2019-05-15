package com.leemon.cloud;

import com.leemon.cloud.entity.User;
import com.leemon.cloud.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.stream.Stream;

//从springCloud Dalston版本（不包含该版本）之后@EnableEurekaClient注解可以省略掉
@EnableEurekaClient
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    ApplicationRunner init(UserRepository userRepository) {
        return args -> {
            User user1 = new User(1L, "account1", "张三", 22, new BigDecimal(18.88));
            User user2 = new User(2L, "account1", "李四", 28, new BigDecimal(38.88));
            User user3 = new User(3L, "account1", "王五", 17, new BigDecimal(11.88));

            Stream.of(user1, user2, user3).forEach(userRepository::save);
        };
    }
}
