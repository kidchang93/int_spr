package kr.co.chunjae.controller;

import kr.co.chunjae.dto.MemberDTO;
import kr.co.chunjae.dto.StudentDTO;
import kr.co.chunjae.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
        // @RequiredArgsConstructor 를 이용하고 아래 파이널로 생성자 주입을 하면
        // 강한 연결이 이루어진다.
    private final StudentService studentService;

    // 학생 등록 폼
    @GetMapping("/saveStudent")
    public String saveStudentForm(){
        return "saveStudent";
    }
    // 학생 등록 요청 처리
    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute StudentDTO studentDTO){
        int saveResult = studentService.saveStudent(studentDTO);
        if (saveResult > 0) {
            return "redirect:/student/studentList";
        }else{
            return "saveStudent";
        }
    }

    @GetMapping("/studentList")
    public String findAllStudent(Model model){
        List<StudentDTO> studentDTOList = studentService.findAllStudent();
        model.addAttribute("studentList",studentDTOList);
        return "studentList";
    }

    @GetMapping
    public String findStudentById(@RequestParam("studentId") String studentId , Model model){
        StudentDTO studentDTO = studentService.findStudentById(studentId);
        model.addAttribute("student" , studentDTO);
        return "studentDetail";
    }

    @GetMapping("/studentUpdate")
    public String updateStudentForm (@RequestParam("studentId") String studentId , Model model){
        StudentDTO studentDTO = studentService.findStudentById(studentId);
        model.addAttribute("student",studentDTO);
        return "studentUpdate";
    }

    @PostMapping("/studentUpdate")
        public String updateStudent(@ModelAttribute StudentDTO studentDTO){
            boolean result = studentService.updateStudent(studentDTO);
            if (result){
                return "redirect:/student?studentId=" + studentDTO.getStudentId();
            } else {
                return "index";
            }

       }

    @GetMapping("/deleteStudent")
        public String deleteStudent(@RequestParam("studentId") String studentId){
            studentService.deleteStudent(studentId);
            return "redirect:/student/studentList";
    }
}
