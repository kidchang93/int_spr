package kr.co.chunjae;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

  public boolean supports(Class<?> clazz) {
    return Person.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    Person person = (Person) target;

    String name = person.getName();
    if (name == null || name.trim().isEmpty()){
      errors.rejectValue("name" , "name.not.empty");
    }

    String age = person.getAge();
    if (age == null || age.trim().isEmpty()){
      errors.rejectValue("age" , "age.not.inrange");
    }

    String email = person.getEmail();
    if (email == null || email.trim().isEmpty()){
      errors.rejectValue("email","email.not.correct");
    }
  }
}
