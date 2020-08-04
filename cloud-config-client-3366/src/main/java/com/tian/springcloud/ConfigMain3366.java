package com.tian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author tian
 * @date 2020/8/4
 */

@SpringBootApplication
@EnableEurekaClient
public class ConfigMain3366 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigMain3366.class,args);
    }
}