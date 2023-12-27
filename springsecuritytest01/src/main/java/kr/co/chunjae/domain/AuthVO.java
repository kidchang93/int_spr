package kr.co.chunjae.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/*객체로 접근 가능하게 만드는 VO 클래스*/

@Data

public class AuthVO {

private String userid;
private String auth;


}
