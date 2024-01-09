package kr.co.chunjae;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/exam01")
public class Example01Controller {

  @Autowired
  private PersonValidator personValidator;

  @GetMapping
  public String showForm(Model model){

    model.addAttribute("person", new Person());
    return "webpage13_01";

  }
  @PostMapping
  public String submit(@Valid @ModelAttribute Person person , BindingResult result){

    if (result.hasErrors())
      return "webpage13_01";

    return "webpage13_result";
  }

  @InitBinder
  protected void initBinder(WebDataBinder binder){
    binder.setValidator(personValidator);

  }
}
