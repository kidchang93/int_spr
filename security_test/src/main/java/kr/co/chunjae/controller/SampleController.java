package kr.co.chunjae.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample")
@Log4j2
public class SampleController {
  @GetMapping("/all")
  public void doAll(){
    log.info("do all can access everybody");
  }

  @GetMapping("/member")
  public void doMember(){
    log.info("logined member");
  }

  @GetMapping("/admin")
  public void doAdmin(){
    log.info("admin only");
  }

}
