package com.it18zhang.eshop.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *主页控制器
 */
@Controller()
public class HomeController {

    public HomeController(){
        System.out.println("hello world");
    }

    /**
     *到主页
     */
    @RequestMapping(value = "/home",method =RequestMethod.GET)
    public String toHome(){
        System.out.println("hello world!!");
        // /jsps/index.jsp
        return "index" ;
    }

    @RequestMapping(value="/home2",method = RequestMethod.GET)
    public String toHome2(){
        System.out.println("how are you??");
        return "hello";
    }
}
