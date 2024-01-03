package kr.co.chunjae.security;

import kr.co.chunjae.domain.CustomUser;
import kr.co.chunjae.domain.MemberVO;
import kr.co.chunjae.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Log4j2

public class CustomUserDetailsService implements UserDetailsService {

  @Autowired
  private MemberMapper memberMapper;
  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

    log.warn("load User By UserName : + " + userName);

    // userName means userid
    MemberVO vo = memberMapper.read(userName);

    log.warn("queried by member mapper : " + vo);


    return vo == null ? null : new CustomUser(vo);
  }
}
