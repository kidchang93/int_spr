package kr.co.chunjae.dto;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PageDTO {
  private int page;
  private int maxPage;
  private int startPage;
  private int endPage;
}
