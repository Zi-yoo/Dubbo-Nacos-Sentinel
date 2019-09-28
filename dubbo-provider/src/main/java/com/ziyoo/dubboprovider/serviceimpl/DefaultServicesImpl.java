package com.ziyoo.dubboprovider.serviceimpl;
import com.ziyoo.dubboapi.defaultservices.DefaultServices;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "0.0.1")
public class DefaultServicesImpl implements DefaultServices {
    @Override
    public String sayHello() {
        return "Hello DUBBO!";
    }

    @Override
    public void asyncWorkFlow(String workTime) {
    }
}
