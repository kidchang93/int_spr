package kr.co.chunjae.mapper;


import kr.co.chunjae.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

  public MemberVO read(String userid);
}
