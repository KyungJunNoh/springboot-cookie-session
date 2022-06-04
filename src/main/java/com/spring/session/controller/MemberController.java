package com.spring.session.controller;

import com.spring.session.dto.SignInRequestDto;
import com.spring.session.dto.SignUpRequestDto;
import com.spring.session.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 자바에서 지원하는 HttpSession interface 로 간단한 회원가입,로그인,현재세션 조회, 로그아웃 구현
 */
@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signUp")
    public void signUp(@RequestBody SignUpRequestDto signUpRequestDto){
        memberService.signUp(signUpRequestDto);
    }

    @PostMapping("/signIn")
    public void signIn(@RequestBody SignInRequestDto signInRequestDto, HttpServletRequest httpServletRequest){
        memberService.signIn(signInRequestDto, httpServletRequest);
    }

    @GetMapping("/mySession")
    public void mySession(HttpServletRequest httpServletRequest){
        memberService.mySession(httpServletRequest);
    }

    @DeleteMapping("/logout")
    public void logout(HttpServletRequest httpServletRequest){
        memberService.logout(httpServletRequest);
    }

}
