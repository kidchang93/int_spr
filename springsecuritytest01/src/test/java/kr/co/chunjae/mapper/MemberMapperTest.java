package kr.co.chunjae.mapper;

import kr.co.chunjae.domain.MemberVO;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j2
public class MemberMapperTest {

  @Autowired
  private MemberMapper mapper;
  @Test
  public void testRead(){
    MemberVO vo = mapper.read("admin90");
    log.info(vo);
    vo.getAuthList().forEach(authVO -> log.info(authVO));
  }

}
