package com.tian.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author tian
 * @date 2020/7/24
 */
@Service
public class PaymentService {

    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    public String payment_OK(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " payment_OK ,id:  " + id + " O(∩_∩)O哈哈";
    }

    public String payment_TimeOut(Integer id) {
        int timeout = 3;
        try {

            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "线程池：" + Thread.currentThread().getName() + " payment_TimeOut ,id:  " + id + "┭┮﹏┭┮呜呜 耗时"+timeout+"秒钟";
    }
}
