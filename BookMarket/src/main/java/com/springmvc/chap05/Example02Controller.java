package com.springmvc.chap05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// @Controller
@RequestMapping(value="/spring") //, method= RequestMethod.GET) // 생략 가능
public class Example02Controller {

    @RequestMapping(value = "/exam02")
    public void requestMethod(){
        System.out.println("RequestMapping 예제입니다.");
        System.out.println("웹 요청 URL은 /exam02 입니다.");
    }
}
// url : http://localhost:8092/BookMarket/spring/exam02