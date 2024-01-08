package kr.co.chunjae;

import lombok.Data;
import lombok.Value;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Product {
  @NotNull
  @Size (min=4 , max=10)
  
  private String name;
  
  @Min(value = 0)
  private int price;
}
