package kr.co.chunjae;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exam04")
public class Example04Controller {
  @GetMapping
  public ResponseEntity<Person> submit(){
    Person person = new Person();
    person.setName("HongGilSon");
    person.setAge("20");
    person.setEmail("Hong@naver.com");
    System.out.println(person);
    return new ResponseEntity("person", HttpStatus.OK);
  }
}
