package com.tian.springcloud.controller;


import com.tian.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author tian
 * @date 2020/7/18
 */
@RestController
@Slf4j
public class OrderZkController {


    //public static final String PAYMENT_URL="http://localhost:8001";

    public static final String PAYMENT_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;


    @GetMapping("/consumer/payment/zk")
    public String zk(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/zk",String.class);
    }

}
