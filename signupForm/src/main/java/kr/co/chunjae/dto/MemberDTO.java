package kr.co.chunjae.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
public class MemberDTO {

    private int memberIdx; // 회원 index
    private String memberId; // 회원 id
    private String memberName; // 회원 이름
    private String memberNickname; // 회원 닉네임
    private String memberGender; // 회원 성별
    private Date memberRegdate;  // 회원가입 날짜
    private String memberEmail; // 회원 이메일
    private String memberPhonenumber; // 회원 핸드폰번호
    private String memberDivision; // 회원 구분
    private String memberGrade; // 회원 학년
    private String memberSchool; // 회원 학교
    private String memberSigugun; // 회원 지역
    private String memberInterest; // 회원 관심과목
}
