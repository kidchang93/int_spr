package kr.co.chunjae.mapper;

import kr.co.chunjae.domain.MemberVO;

public interface MemberMapper {
  public MemberVO read(String userid);
}
