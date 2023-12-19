package com.springmvc.chap05;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
//@RequestMapping("/home")
public class Example05Controller {

    @RequestMapping("/exam05")
    public String requestMethod(Model model) {
        model.addAttribute("data", "Model 예제입니다.");
        model.addAttribute("data2", "웹 요청 URL은 /home/exam05 입니다.");
        return "webpage05";
    }


}
