package com.springmvc.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice   // 전역 예외처리를 위한 애너테이션을 선언.
public class CommonException {  // 모든 컨트롤러의 예외처리 클래스
    @ExceptionHandler(RuntimeException.class)   // 예외 클래스 설정
    private ModelAndView handleErrorCommon(Exception e){    // 컨트롤러에서 발생되는 예외처리 메서드.
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception",e);  // 모델 속성에 예외처리 클래스 RuntimeException 을 저장.
        modelAndView.setViewName("errorCommon");    // 뷰 이름 설정
        return modelAndView;
    }
}
