package com.ziyoo.dubboconsumer.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ziyoo.dubboapi.defaultservices.DefaultServices;

@RestController
public class DefaultController {

    @Reference(version = "0.0.1")
    private DefaultServices defaultServices1;

    /*@Reference(version = "0.0.2")
    private DefaultServices defaultServices2;*/

    @GetMapping("/1")
    public void test(){
        System.out.println(defaultServices1.sayHello());
    }

    /*@GetMapping("/2")
    public void asyncTest(){
        long time = System.currentTimeMillis();
        defaultServices2.asyncWorkFlow(String.valueOf(time));
    }*/

}
