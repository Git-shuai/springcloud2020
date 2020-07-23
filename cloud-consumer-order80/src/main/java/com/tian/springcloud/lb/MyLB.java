package com.tian.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tian
 * @date 2020/7/23
 */
@Component
public class MyLB implements ILoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("*******next==>" + next);
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {

        if (serviceInstances==null ||serviceInstances.size()<=0){
            return null;
        }
        int index = getAndIncrement() % serviceInstances.size();

        return serviceInstances.get(index);
    }
}
