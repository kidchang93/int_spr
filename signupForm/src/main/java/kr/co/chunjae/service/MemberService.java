package kr.co.chunjae.service;

import kr.co.chunjae.repository.MemberRepository;
import kr.co.chunjae.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void save(MemberDTO memberDTO) {
        memberRepository.save(memberDTO);
    }


}
