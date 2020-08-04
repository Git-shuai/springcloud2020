package com.tian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author tian
 * @date 2020/8/3
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigMain3344 {
     public static void main(String[] args) {
             SpringApplication.run(ConfigMain3344.class,args);
         }
}
