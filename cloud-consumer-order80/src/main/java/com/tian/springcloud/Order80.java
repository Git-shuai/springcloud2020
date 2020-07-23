package com.tian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author tian
 * @date 2020/7/18
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration= MySelfRule.class)
public class Order80 {
    public static void main(String[] args) {
        SpringApplication.run(Order80.class, args);
    }
}
