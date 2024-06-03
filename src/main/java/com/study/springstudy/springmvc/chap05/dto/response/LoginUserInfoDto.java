package com.study.springstudy.springmvc.chap05.dto.response;

import com.study.springstudy.springmvc.chap05.entity.Member;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginUserInfoDto {

    private static final Logger log = LoggerFactory.getLogger(LoginUserInfoDto.class);
    // 클라이언트에 보낼 정보
    private String account;
    private String nickName;
    private String email;
    private String auth;

    public LoginUserInfoDto(Member member) {
        this.account = member.getAccount();
        this.email = member.getEmail();
        this.nickName = member.getName();
        this.auth = member.getAuth().name();
    }
}