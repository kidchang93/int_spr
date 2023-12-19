package com.springmvc.chap06;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("/chap06")
// @RequestMapping("/chap06")
public class Example01Controller {

    @GetMapping("/exam01/{bookId}")
    public String requestMethod(@PathVariable String bookId, Model model){
        System.out.println("도서 ID : " + bookId);
        model.addAttribute("data", "도서 ID : " + bookId);
        return "webpage06"; // webpage06.jsp
    }
}
//@PatHVarible을 사용하면 쿼리스트링을 사용하지 않을 수 있다.
