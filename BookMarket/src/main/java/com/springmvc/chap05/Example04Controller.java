package com.springmvc.chap05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
//@RequestMapping("/home")
public class Example04Controller {

    @RequestMapping("/exam04")
    public void requestMethod() {
        System.out.println("@RequestMapping 예제입니다.");
        System.out.println("엡 요청 URL은 /home/exam04입니다.");
    }


}
