package com.tian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author tian
 * @date 2020/8/3
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigMain3355 {
     public static void main(String[] args) {
             SpringApplication.run(ConfigMain3355.class,args);
         }
}
