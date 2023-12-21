package kr.co.chunjae.controller;

import kr.co.chunjae.dto.MemberDTO;
import kr.co.chunjae.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
@Log4j2
public class MemberController {

  private final MemberService memberService;
  @GetMapping("/save")
  public String saveForm(){
    return "save";
  }

  @PostMapping("/save")
  public String save(@ModelAttribute MemberDTO memberDTO){
    int saveResult = memberService.save(memberDTO);
    if (saveResult > 0) {
      return "login";
    } else {
      return "save";
    }
  }

  @GetMapping("/login")
  public String loginForm(){
    return "login";
  }

  @PostMapping("/login")
  public String login(@ModelAttribute MemberDTO memberDTO , HttpSession session){
    boolean loginResult = memberService.login(memberDTO);
    if (loginResult){
      session.setAttribute("loginEmail", memberDTO.getMemberEmail());
      return "main";
    } else {
      return "login";
    }
  }

  @GetMapping("/")
  public String findAll(Model model){
    List<MemberDTO> memberDTOList = memberService.findAll();
    model.addAttribute("memberList",memberDTOList);
    return "list";
  }

  // /member?id=1294
  @GetMapping
  public String findById(@RequestParam ("id") Long id , Model model){
    log.info(id);
    MemberDTO memberDTO = memberService.findById(id);
    model.addAttribute("member",memberDTO);
    return "detail";
  }

  @GetMapping("/delete")
  public String deleteById(@RequestParam ("id") Long id){
    int deleteResult = memberService.deleteById(id);
    if (deleteResult > 0){
      return "redirect:/member/";
    } else {
      return "redirect:index";
    }
  }
}
