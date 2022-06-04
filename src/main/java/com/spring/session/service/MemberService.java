package com.spring.session.service;

import com.spring.session.dto.SignInRequestDto;
import com.spring.session.dto.SignUpRequestDto;
import com.spring.session.entity.Member;
import com.spring.session.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public void signUp(SignUpRequestDto signUpRequestDto){
        if(memberRepository.existsByLoginId(signUpRequestDto.getLoginId())) throw new IllegalArgumentException("이미 사용중인 아이디입니다.");

        memberRepository.save(signUpRequestDto.toMemberEntity());

        log.info("회원가입 완료");
    }

    public void signIn(SignInRequestDto signInRequestDto, HttpServletRequest httpServletRequest) {
        Member member = memberRepository.findByLoginId(signInRequestDto.getLoginId())
                .orElseThrow(() -> new IllegalArgumentException("아이디 혹은 비밀번호가 일치하지 않습니다."));

        if(member.passwordVerify(signInRequestDto.getPassword())) throw new IllegalArgumentException("아이디 혹은 비밀번호가 일치하지 않습니다.");

        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("loginId", signInRequestDto.getLoginId());

        log.info("로그인 완료");
    }

    public void mySession(HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();

        log.info("id : {}", session.getId()); // 세션이 생성될때 고유한 id 를 가져옴
        log.info("value : {}", session.getAttribute("loginId")); // 세션에 저장되어있는 value 를 가져오고싶을때 key 를 입력
        log.info("생성 시간 : {}", session.getCreationTime()); // 세션이 생성된 시간
        log.info("세션 유지 시간 : {}", session.getMaxInactiveInterval()); // 세션 유지 시간

        log.info("세션 확인 완료");
    }

    public void logout(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();

        session.invalidate();
        log.info("로그아웃 완료");
    }
}
