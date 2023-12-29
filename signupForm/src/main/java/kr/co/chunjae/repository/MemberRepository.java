package kr.co.chunjae.repository;

import kr.co.chunjae.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final SqlSessionTemplate sql;
    public void save(MemberDTO memberDTO) {
        System.out.println("memberDTO = " + memberDTO);

        sql.insert("Member.save",memberDTO);
    }


}
