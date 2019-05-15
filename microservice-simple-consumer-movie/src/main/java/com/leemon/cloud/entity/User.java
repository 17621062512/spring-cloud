package com.leemon.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


/**
 * @author limenglong
 * @create 2019-05-15 14:06
 * @desc 用户实体类
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String username;
    private String name;
    private Integer age;
    private BigDecimal balance;
}
