package com.tian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author tian
 * @date 2020/7/24
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class PaymentHystrixMain8001 {
     public static void main(String[] args) {
             SpringApplication.run(PaymentHystrixMain8001.class,args);
         }
}
