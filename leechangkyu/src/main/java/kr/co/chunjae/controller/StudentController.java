package kr.co.chunjae.controller;

import kr.co.chunjae.dto.StudentDTO;
import kr.co.chunjae.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/student")
@RequiredArgsConstructor
@Log4j2
public class StudentController {

  private final StudentService studentService;

  @GetMapping("save")
  public String saveForm(){
    return "saveForm";
  }
  @PostMapping("save")
  public String save(@ModelAttribute StudentDTO studentDTO){

    studentService.save(studentDTO);
    return "redirect:/student/studentList";
  }

  @GetMapping("studentList")
  public String studentList(StudentDTO studentDTO , Model model){

    List<StudentDTO> list = studentService.findAll(studentDTO);
    model.addAttribute("studentList" , list);
    return "studentList";

  }

  @GetMapping("login")
  public String loginForm(){
    return "loginForm";
  }
  @PostMapping("login")
  public String login(@RequestParam("memberId") String memberId , HttpSession session , StudentDTO studentDTO){

    Boolean loginSuccess = studentService.findByMemId(studentDTO);
    if (loginSuccess){
      session.setAttribute("memberId" , memberId);
      log.info("loginSuccess........" + loginSuccess);
      return "redirect:/student/studentList";
    } else {
      log.info("loginFailed ......." + !loginSuccess);
      return "loginForm";
    }
  }

  @GetMapping("update")
  public String updateForm(@RequestParam("studentId") String studentId, Model model){
    StudentDTO studentDTO = studentService.findByStudentId(studentId);
    model.addAttribute("student",studentDTO);
    return "updateForm";
  }

  @PostMapping("update")
  public String update(@ModelAttribute StudentDTO studentDTO){
      boolean result = studentService.update(studentDTO);
      if (result) {
        return "redirect:/student/studentList";
      } else {
        return "loginForm";
      }
  }

  @GetMapping("delete")
  public String delete(@RequestParam("studentId") String studentId) {
    studentService.delete(studentId);
    return "redirect:/student/studentList";
  }

}
