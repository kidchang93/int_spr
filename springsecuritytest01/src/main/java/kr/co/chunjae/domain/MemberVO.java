package kr.co.chunjae.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MemberVO {
  private String userId;
  private String userPw;
  private String userName;
  private Boolean enabled;
  private Date regDate;
  private List<AuthVO> authList;

}
