package com.tian.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author tian
 * @date 2020/7/23
 */
public interface ILoadBalancer {

    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
