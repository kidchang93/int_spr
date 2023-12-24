create table members(
                        member_idx              int AUTO_INCREMENT  not null comment '회원 index',
                        member_id               varchar(30) unique  not null comment '회원 id',
                        member_password         varchar(30)         not null comment '회원 비밀번호',
                        member_name				varchar(30)			not	null comment '회원 이름',
                        member_nickname         varchar(30) unique  not null comment '회원 닉네임',
                        member_gender			varchar(30)			not null comment '회원 성별',
                        member_regdate          date DEFAULT now()           comment '회원가입 날짜',
                        member_email            varchar(50) unique  not null comment '회원 이메일',
                        member_phonenumber      varchar(30) unique  not	null comment '회원 핸드폰번호',
                        member_division			varchar(30)		 	not null comment '회원 구분',
                        member_grade			varchar(30)				null comment '회원 학년',
                        member_school			varchar(30)				null comment '회원 학교',
                        member_sigugun          varchar(30)         not null comment '회원 지역',
                        member_interest			varchar(50)			not null comment '회원 관심과목',
                        PRIMARY KEY (member_idx)
);