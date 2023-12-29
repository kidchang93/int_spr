package kr.co.chunjae.dto;

import lombok.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import java.util.Date;

@Getter
@Setter
@ToString
public class MemberDTO {

    private int memberIdx; // 회원 index

    @NotEmpty
    @Length(min=8, max=16)
    private String memberId; // 회원 id
    @NotEmpty
    @Pattern(regexp="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])(?=\\S+$).{8,}")
    private String memberPassword; // 회원 pw
    @NotEmpty
    @Length(min=2, max=16)
    private String memberName; // 회원 이름
    @NotEmpty
    @Length(min=2, max=16)
    private String memberNickname; // 회원 닉네임
    @NotEmpty
    private String memberGender; // 회원 성별
    private Date memberRegdate;  // 회원가입 날짜
    @NotEmpty
    @Email
    private String memberEmail; // 회원 이메일
    private String memberPhonenumber; // 회원 핸드폰번호
    private String memberDivision; // 회원 구분
    private String memberGrade; // 회원 학년
    private String memberSchool; // 회원 학교
    private String memberSigugun; // 회원 지역
    private String memberInterest; // 회원 관심과목
}
