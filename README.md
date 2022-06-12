# SpringBoot, Java 에서 Cookie 사용하고 Session 으로 로그인 구현하기

- 세션은 주로 로그인을 유지할 때 사용되는 기술입니다.
- 로그인을 유지하는 방법에는 jwt 를 이용하는 방법이 있는데 이 레포지토리의 주제는 세션이기 때문에 다루지 않겠습니다.
- 세션은 서버의 메모리(혹은 서드파티)에 생성되는 저장 공간입니다.

[TIL 의 Session 개념 확인하기](https://github.com/KyungJunNoh/TIL/blob/main/Backend/Certification/Session.md)


### 이 레포지토리는...
- java 로 `HttpSession 인터페이스 (내부 API)` 를 이용하여 Session 을 구현합니다.
- java 로 구현된 Session 을 `Spring Session` 으로 **마이그레이션** 중에 있습니다. ( 현재 session 은 java 로 구현되어있습니다.)


### Reference by
- [HttpRequest Docs](https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/HttpRequest.html)
- [HttpSession Docs](https://docs.oracle.com/javaee/7/api/javax/servlet/http/HttpSession.html)