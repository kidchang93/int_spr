package kr.co.chunjae.repository;

import kr.co.chunjae.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Log4j2
public class MemberRepository {

  private final SqlSessionTemplate sql;
  public int save(MemberDTO memberDTO) {
    log.info("memberDTO =======");
    log.info(memberDTO);
    return sql.insert("Member.save", memberDTO);
  }


  public MemberDTO login(MemberDTO memberDTO) {
    return sql.selectOne("Member.login", memberDTO);
  }

  public List<MemberDTO> findAll() {
    return sql.selectList("Member.findAll");
  }

  public MemberDTO findById(Long id) {
    return sql.selectOne("Member.findById",id);
  }

  public int deleteById(Long id) {
    return sql.delete("Member.deleteById",id);
  }
}
