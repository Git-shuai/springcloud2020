package com.tian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author tian
 * @date 2020/8/2
 */
@SpringBootApplication
@EnableEurekaClient
public class GateWayMain9527 {
     public static void main(String[] args) {
             SpringApplication.run(GateWayMain9527.class,args);
         }
}
