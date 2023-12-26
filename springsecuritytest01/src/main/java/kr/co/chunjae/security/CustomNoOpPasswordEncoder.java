package kr.co.chunjae.security;

import lombok.extern.log4j.Log4j;
import org.springframework.security.crypto.password.PasswordEncoder;

@Log4j
public class CustomNoOpPasswordEncoder implements PasswordEncoder {

  public String encode(CharSequence rawPassword){

    return rawPassword.toString();
  }

  public boolean matches(CharSequence rawPassword , String encodedPassword){

    log.warn("matches : "+ rawPassword + " : " + encodedPassword);

    //문자열로 변환된 rawPassword가 encoding 된 password와 일치한다면 ? ( toString 은 문자열로 변환)
    return rawPassword.toString().equals(encodedPassword);
  }
}
