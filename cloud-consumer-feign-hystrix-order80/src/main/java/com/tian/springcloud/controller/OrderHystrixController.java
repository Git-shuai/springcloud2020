package com.tian.springcloud.controller;

import com.tian.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tian
 * @date 2020/7/24
 */
@RestController
@Slf4j
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String payment_OK(@PathVariable("id") Integer id){
        String result=paymentHystrixService.payment_OK(id);

        log.info("payment_OK result==>"+result);
        return result;
    }

    @GetMapping("/consumer/payment/timeout/ok/{id}")
    public String payment_TimeOut(@PathVariable("id") Integer id){
        String result=paymentHystrixService.payment_TimeOut(id);

        log.info("payment_TimeOut result==>"+result);
        return result;
    }

}
