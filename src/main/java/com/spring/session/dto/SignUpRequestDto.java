package com.spring.session.dto;

import com.spring.session.entity.Member;
import lombok.Getter;

@Getter
public class SignUpRequestDto {

    private String loginId;
    private String password;
    private String name;

    public Member toMemberEntity(){
        return Member.builder()
                .loginId(loginId)
                .password(password)
                .name(name)
                .build();
    }
}
