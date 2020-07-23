package com.tian.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
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


    @GetMapping("/consumer/payment/consul")
    public String zk(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/consul",String.class);
    }

}
