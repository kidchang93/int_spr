package kr.co.chunjae;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class Example03Exception extends RuntimeException{
    private String errMsg;

  public Example03Exception() {
    super();
    this.errMsg = "Example03Exception 메시지 입니다.";
  }

  public String getErrMsg() {
    return errMsg;
  }

  public void setErrMsg(String errMsg) {
    this.errMsg = errMsg;
  }
}
