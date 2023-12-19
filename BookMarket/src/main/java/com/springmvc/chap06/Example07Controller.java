package com.springmvc.chap06;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@Controller
//@RequestMapping("/home")
public class Example07Controller {

    @RequestMapping("/exam07")
    public ModelAndView requestMethod(ModelMap model) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("data", "ModelAndView 예제입니다.");
        mav.addObject("data2", "웹 요청 URL은 /home/exam07입니다.");
        mav.setViewName("webpage05"); // webpage05.jsp에 출력함.

        return mav; // 리턴할 때 경로를 알 수 없음.
    }


}
