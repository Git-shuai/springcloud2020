package com.tian.springcloud.controller;

import com.tian.springcloud.entities.CommonResult;
import com.tian.springcloud.entities.Payment;
import com.tian.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author tian
 * @date 2020/7/18
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("****结果是:{}", result);
        if (result > 0) {
            return new CommonResult<Payment>(200, "插入数据库成功"+serverPort, payment);
        } else {
            return new CommonResult<Payment>(444, "插入数据库失败"+serverPort, null);
        }
    }


    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("****结果是:{}O(∩_∩)O哈哈", payment);
        if (payment != null) {
            return new CommonResult<Payment>(200, "查询成功"+serverPort, payment);
        } else {
            return new CommonResult<Payment>(444, "没有对应记录"+serverPort, null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service==>"+service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"   "+instance.getHost()+"     "+instance.getPort()+"  "+instance.getUri());
        }
        return discoveryClient;

    }

    @GetMapping("/payment/lb")
    public String getServerPort(){
        return serverPort;
    }


    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
