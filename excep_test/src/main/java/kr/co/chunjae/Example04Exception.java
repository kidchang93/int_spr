package kr.co.chunjae;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice(basePackages = {"kr.co"})
public class Example04Exception {

  @ExceptionHandler(value = {RuntimeException.class})
  private ModelAndView handleErrorMethod(Exception ex){
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("errorMessage", "Example04Exception 메시지입니다.");
    modelAndView.addObject("exception" , ex);
    modelAndView.setViewName("webpage10_03");
    return modelAndView;
  }
}
