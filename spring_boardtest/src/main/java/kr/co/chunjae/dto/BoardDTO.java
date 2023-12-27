package kr.co.chunjae.dto;

import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@ToString

public class BoardDTO {
  private Long id;
  private String boardWriter;
  private String boardPass;
  private String boardTitle;
  private String boardContents;
  private int boardHits;
  private Timestamp boardCreatedTime;
}
