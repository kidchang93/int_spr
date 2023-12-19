package com.springmvc.chap06;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class Example04Controller {

    @RequestMapping("/exam04/{bookId}/category/{category}")
    public String requestMethod(@MatrixVariable(value = "publisher" , pathVar = "bookId") String q1,
                              @MatrixVariable(value = "publisher" , pathVar = "category") String q2,
                              Model model) {
        System.out.println("출판사1 : " + q1);
        System.out.println("출판사2 : " + q2);
        model.addAttribute("data" , "출판사1 : " + q1 + "<br>" + "출판사2 : " + q2);
        return "webpage06";
    }

    //http://localhost:8092/home/exam04/ISBN1234;publisher=길벗/category/IT전문서;publisher=이지톡
}
