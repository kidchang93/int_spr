package com.springmvc.controller;

import com.springmvc.domain.DataBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
  @GetMapping("/test1")
  public String test1(DataBean bean, Model model) {

    String [] data_list1 = {"옵션1","옵션2","옵션3","옵션4","옵션5","옵션6","옵션7","옵션8"};
    model.addAttribute("data_list1",data_list1);
    bean.setA1("옵션2");

    String [] check_list = {"옵션1","옵션8"};
    bean.setA3(check_list);
    bean.setA4(check_list);
    bean.setA5(check_list);

    String [] data_list2 = {"옵션1","옵션2","옵션3","옵션4","옵션5","옵션6","옵션7","옵션8"};
    model.addAttribute("data_list2",data_list2);

    bean.setA2("옵션3");

    return "test1";
  }
}