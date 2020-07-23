package com.tian.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tian
 * @date 2020/7/23
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule getIRule(){
        return new RandomRule();  //随机规则
    }
}
