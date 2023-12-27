package kr.co.chunjae.security;

import kr.co.chunjae.mapper.MemberMapper;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Log4j
public class CustomUserDetailsService implements UserDetailsService {

  @Autowired
  private MemberMapper memberMapper;
  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

    log.warn("load User By UserName : + " + userName);

    return null;
  }
}
