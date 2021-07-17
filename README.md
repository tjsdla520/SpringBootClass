# SpringBootClass
 스프링부트강의1
7/17

1.https://start.spring.io/ 활용

2. 스플링에서 버전을 설정하고 필요한라이브러리를 가져오고 관리하는 방식
   gradle, maven

3. 인텔리제이 다운로드 및 환경 구축
   (1) identify and stop the process that's listening on port 8080 or configure this application to listen on another port.
    - 관리자권한으로 cmd창을 열어서  netstat -ano로 충돌포트 확인, taskkill /pid 4124 /f 로 강제종료
   (2) gradle로 들어가서 gradle을 통해 자바를 불러오는것이 아니라 인텔리제이가 바로 불러오게 설정
    - Gradle > IntelliJ IDEA

4. 라이브러리 살펴보기
   (1) spring-boot-starter-web만 가져와도 그에 필요한 모든 의존된 라이브러리를 가져온다.(톰캣,스프링코어,junit,logback 등등)
