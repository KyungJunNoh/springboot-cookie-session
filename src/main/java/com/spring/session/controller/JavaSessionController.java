package com.spring.session.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 자바에서 지원하는 HttpSession interface 로 세션 사용하기
 * @apiNote https://docs.oracle.com/javaee/7/api/javax/servlet/http/HttpSession.html
 */
@Slf4j
@RestController
public class JavaSessionController {

    @PostMapping("/api/java/sessions")
    public void addSession(HttpServletRequest request) {
        HttpSession session = request.getSession(); // 서블릿 요청에서 session 을 가지고 옴. ( 세션이 없거나, 만료되었다면, 새로 생성 )

        session.setAttribute("test_key", "test_value"); // 세션에 값을 key : value 형태의 값을 저장
        session.setMaxInactiveInterval(60 * 30); // 세션이 유지되는 시간 default value : 30 분

        log.info("isNew : {}", session.isNew()); // 새로운 세션이라면 true, 생성되었던 세션이라면 false
    }

    @GetMapping("/api/java/sessions")
    public void getSession(HttpServletRequest request) {
        HttpSession session = request.getSession(); // 서블릿 요청에서 session 을 가지고 옴. ( 세션이 없거나, 만료되었다면, 새로 생성 )

        log.info("id : {}", session.getId()); // 세션이 생성될때 고유한 id 를 가져옴
        log.info("value : {}", session.getAttribute("test_key")); // 세션에 저장되어있는 value 를 가져오고싶을때 key 를 입력
        log.info("생성 시간 : {}", session.getCreationTime()); // 세션이 생성된 시간
        log.info("세션 유지 시간 : {}", session.getMaxInactiveInterval()); // 세션 유지 시간
    }

    @DeleteMapping("/api/java/sessions")
    public void invalidSession(HttpServletRequest request) {
        HttpSession session = request.getSession(); // 서블릿 요청에서 session 을 가지고 옴. ( 세션이 없거나, 만료되었다면, 새로 생성 )

        session.invalidate(); // 세션을 만료시킴
        log.info("세션 만료 요청 완료");
    }
}
