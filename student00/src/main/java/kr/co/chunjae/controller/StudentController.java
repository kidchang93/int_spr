package kr.co.chunjae.controller;

import kr.co.chunjae.dto.MemberDTO;
import kr.co.chunjae.dto.StudentDTO;
import kr.co.chunjae.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

  private final StudentService studentService;
  @GetMapping("save")
  public String saveForm(){

    return "saveForm";
    // http://localhost:8092/student/save
  }

  @PostMapping("save")
  public String save(@ModelAttribute StudentDTO studentDTO){
    int saveResult = studentService.save(studentDTO);
    if( saveResult > 0 ) {
      return "studentList";
    }
    return "saveForm";
  }

  @GetMapping("studentList")
  public String FindAll(Model model){
    List<StudentDTO> list = studentService.findAll();
    model.addAttribute("studentList",list);
    return "studentList";
  }

  @GetMapping("login")
  public String loginForm(){
    return "loginForm";
  }

  @PostMapping("login")
  public String login(@RequestParam("memberId") String memberId , MemberDTO memberDTO){


    return "redirect:/student/studentList";
  }
}
