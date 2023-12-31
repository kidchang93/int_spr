package kr.co.chunjae.controller;

import kr.co.chunjae.dto.MemberDTO;
import kr.co.chunjae.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
        // @RequiredArgsConstructor 를 이용하고 아래 파이널로 생성자 주입을 하면
        // 강한 연결이 이루어진다.
    private final MemberService memberService;

    @GetMapping("/save")
    public String saveForm(){
        return "save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Valid MemberDTO memberDTO, BindingResult bindingResult){
        /*int saveResult = memberService.save(memberDTO);
        if (saveResult > 0) {
            return "login";
        }else{
            return "save";
        }*/

        if( bindingResult.hasErrors() ) {

            // 에러를 List로 저장
            List<ObjectError> list = bindingResult.getAllErrors();
            for( ObjectError error : list ) {
                System.out.println(error);
            }
            return "/member/save";
        }

        memberService.save(memberDTO);
        return "redirect:/member/saveSucess";
    }


}
