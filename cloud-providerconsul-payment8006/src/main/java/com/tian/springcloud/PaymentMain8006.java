package com.tian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author tian
 * @date 2020/7/23
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8006 {
     public static void main(String[] args) {
             SpringApplication.run(PaymentMain8006.class,args);
         }
}
