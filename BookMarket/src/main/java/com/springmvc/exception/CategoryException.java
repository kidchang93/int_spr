package com.springmvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


// 예외가 발생하면 웹 브라우저에 상태코드 404와 오류메세지를 출력합니다.
@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "요청한 도서 분야를 찾을 수 없습니다.")
public class CategoryException extends RuntimeException{

}
