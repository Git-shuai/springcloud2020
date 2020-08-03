package com.tian.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
//@DefaultProperties(defaultFallback = "gabblePaymentTimeOutFallbackMethod")
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
//        int age=10/0;
        String result=paymentHystrixService.payment_TimeOut(id);
        log.info("payment_TimeOut result==>"+result);
        return result;
    }
//
//    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id){
//        return "我是80服务消费者，对方支付系统繁忙请稍后再试，┭┮﹏┭┮";
//    }
//
//    public String gabblePaymentTimeOutFallbackMethod(){
//        return "全局处理，我是80服务消费者，对方支付系统繁忙请稍后再试，┭┮﹏┭┮";
//    }
}
