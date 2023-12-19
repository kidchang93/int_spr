package com.springmvc.chap05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Controller
//@RequestMapping("/spring") : 충돌할 때 이렇게 이름 달아서 사용
public class Example01Controller {

    @RequestMapping(value="/exam01", method= RequestMethod.GET)
    public void requestMethod(){
        System.out.println("@Controller 예제입니다.");

    }
}
