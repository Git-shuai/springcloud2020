package com.tian.springcloud.service;

import com.tian.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author tian
 * @date 2020/7/18
 */

public interface PaymentService {
    /**
     * 创建
     * @param payment
     * @return
     */
    public int create(Payment payment);

    /**
     * 查找
     * @param id
     * @return
     */
    public Payment getPaymentById(@Param("id") Long id);
}
