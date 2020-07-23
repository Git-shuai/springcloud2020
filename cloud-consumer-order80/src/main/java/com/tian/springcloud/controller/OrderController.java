package com.tian.springcloud.controller;

import com.tian.springcloud.entities.CommonResult;
import com.tian.springcloud.entities.Payment;
import com.tian.springcloud.lb.ILoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author tian
 * @date 2020/7/18
 */
@RestController
@Slf4j
public class OrderController {


    //public static final String PAYMENT_URL="http://localhost:8001";

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private ILoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;


    @PostMapping("/consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/getEntity/{id}")
    public CommonResult<Payment> getEntity(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else {
            return new CommonResult<>(444,"操作失败");
        }
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        if (instances==null||instances.size()<=0){
            return null;
        }

        ServiceInstance instance = loadBalancer.instance(instances);

        URI uri = instance.getUri();
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }
}
