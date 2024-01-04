package kr.co.chunjae;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class Example01Controller {	

	@GetMapping("webpage16_01")
	public String showForm1() {
		return "webpage16_01";
	}

	@GetMapping("webpage16_02")
	public String showForm2() {
		return "webpage16_02";
	}
}
