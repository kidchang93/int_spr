package com.springmvc.chap07;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

  private int id;
  private String password;
  private String city;
  private String sex;
  private String[] hobby;
  private Date birth;

}
