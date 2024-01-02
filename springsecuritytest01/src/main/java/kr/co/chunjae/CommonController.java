package kr.co.chunjae;


import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@Log4j2
public class CommonController {

  @GetMapping("/accessError")
  public void accessDenied(Authentication auth , Model model){
    log.info("access denied : " + auth);
    model.addAttribute("msg","접근권한이 없습니다. 올바른 페이지로 이동하세요.");

  }

  @GetMapping("/customLogin")
  public void loginInput(String error, String logout , Model model){
    log.info("error : "+ error);
    log.info("logout : "+ logout);
    log.info("model : "+ model);

    if (error != null){
      model.addAttribute("error" , "LoginError check your Access");
    }

    if (logout != null){
      model.addAttribute("logout" , "Logout!!");
    }

  }

  @GetMapping("/customLogout")
  public void logoutGET(){
    log.info("logoutGET ... ");
  }

}
