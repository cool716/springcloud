package com.wistron.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: springCloud   自定义负载均衡算法    轮询
 * @description:
 * @author: Cool
 * @create: 2021-01-09 11:29
 **/
@Component
public class Mylb implements  LoadBalancer {

    private AtomicInteger atomicInteger= new AtomicInteger(0);

    public  final  int getAndIncrement(){
        int current;
        int next;
        do {
            current=this.atomicInteger.get();
            next=current >= 2147483647 ? 0 : current+1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("第"+next+"次访问："+next);
        return  next;
    }

    //负载均衡算法 rest接口的第几次请求数  %  服务器集群总数量  = 实际调用服务器位置下标，
    // 每次服务器启动后rest接口请求次数从1 开始
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int  index=getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
