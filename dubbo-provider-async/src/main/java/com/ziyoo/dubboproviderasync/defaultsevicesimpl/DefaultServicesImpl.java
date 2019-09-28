package com.ziyoo.dubboproviderasync.defaultsevicesimpl;

import com.ziyoo.dubboapi.defaultservices.DefaultServices;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "0.0.2")
public class DefaultServicesImpl implements DefaultServices {
    @Override
    public String sayHello() {
        return "Hello DUBBO";
    }
    @Override
    public void asyncWorkFlow(String workTime) {

        System.out.println("Work NUM: " + workTime);
        //模拟等待
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Work NUM: " + workTime + "finish!");

    }
}
