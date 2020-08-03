package com.tian.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author tian
 * @date 2020/8/1
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String payment_OK(Integer id) {
        return "-------PaymentFallbackService fall back payment_OK,┭┮﹏┭┮";
    }

    @Override
    public String payment_TimeOut(Integer id) {
        return "-------PaymentFallbackService fall back payment_TimeOut，┭┮﹏┭┮";
    }
}
