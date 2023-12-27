package kr.co.chunjae.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Data

public class MemberVO {
  private String userid;
  private String userpw;
  private String userName;
  private Boolean enabled;
  private Date regDate;
  private Date updateDate;
  private List<AuthVO> authList;

}
