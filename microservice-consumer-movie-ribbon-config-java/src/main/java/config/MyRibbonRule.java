package config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import lombok.extern.java.Log;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author limenglong
 * @create 2019-05-31 18:11
 * @desc
 **/
@Configuration
@Log
public class MyRibbonRule {
    @Bean
    public IRule ribbonRule() {
        log.info("负载均衡器使用随机策略");
        return new RandomRule();
    }
}
