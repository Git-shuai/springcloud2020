package com.tian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author tian
 * @date 2020/7/24
 */
@SpringBootApplication
@EnableFeignClients
public class OrderHystrixMain80 {
     public static void main(String[] args) {
             SpringApplication.run(OrderHystrixMain80.class,args);
         }
}
