###SpringCloud项目
 
推荐系列文章  
[跟我学Spring Cloud（Finchley版）](http://www.itmuch.com/spring-cloud/spring-cloud-index/)
 
####Java8 新特性  
1. [Optional类](https://www.cnblogs.com/xingzc/p/5778090.html)  
2. [Stream](https://blog.csdn.net/Young4Dream/article/details/76794659)

####Spring 5
1. `RestTemplate`被`WebClient`替代，性能更强，吞吐更好


####服务发现组件 Eureka
- 从`springCloud`的`Dalston`版本(不包含该版本)之后,  
`@EnableEurekaClient`注解可以省略掉

- `*.yml`配置文件支持使用三个短横线分割文档块
    ```yml
    server:
      port: 8082
    spring:
      profiles:
        active: dev
    ---
    spring:
      profiles: dev
    server:
      port: 8083
    ---
    spring:
      profiles: prod
    server:
      port: 8084
    ---
    ```

`eureka`通过心跳检查、客户端缓存等机制，  
提高了系统的灵活性、可靠性、伸缩性