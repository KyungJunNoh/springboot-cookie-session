package com.spring.session.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
public class CookieController {

    /**
     * key : test_key, value : test_value 인 쿠키 생성
     * @param response
     */
    @PostMapping("/api/cookies")
    public void addCookies(HttpServletResponse response){
        log.info("요청받았습니다.");
        Cookie cookie = new Cookie("test_key", "test_value");
        cookie.setMaxAge(60 * 60 * 24);
        cookie.setPath("/");

        response.addCookie(cookie);
    }

    /**
     * 로컬스토리지에 보관된 쿠키 가져오기
     * @param request
     */
    @GetMapping("/api/cookies")
    public void getCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                log.info("name : {}, value : {}", cookie.getName(), cookie.getValue());
            }
        } else {
            log.info("cookie notfound");
        }
    }
}
