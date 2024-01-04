package kr.co.chunjae.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
  private String studentId;
  private String studentName;
  private int korean;
  private int english;
  private int math;
}
