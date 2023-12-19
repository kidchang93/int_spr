//package com.springmvc.chap06;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//@RequestMapping("/home")
//public class Example07Controller {
//
//    @RequestMapping("/exam07")
//    public String requestMethod(@RequestParam String id , Model model) {
//        System.out.println("도서 ID : " + id);
//        model.addAttribute("data", "도서 ID : " + id);
//        return "webpage06";
//
//
//    } // http://localhost:8092/home/exam07?id=ISBN1234
//
//
//}
