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
   
7/19

1. view환경설정

   welcome page만들기

   spring.io 에서 검색기능 사용가능

   thymeleaf 검색엔진

2. 프로젝트 생성
3. 라이브러리 살펴보기
4. 빌드하고 실행하기
   cmd창 단축키 -  cd: 파일 들어가기, cd..: 파일돌아가기, dir:폴더안 파이보기, tab:자동완성
   

5. 스프링 웹 개발 기초
   정적컨텐츠 : 파일을 그대로 웹브라우저에 내려주는것
   MVC와 템플릿 엔진 : 가장많이 하는 방식으로 jsp 등의 템플릿 엔진들 통해서 html을 동적으로 바꾸어 내려주는것. 
                     그것을 하기위해서 model,controller,템플릿엔진을 사용하는것. 정적컨텐츠와는 다르게 서버에서 변형하여 내려준다.
   API : 안드로이드or아이폰 개발시 json이라는 데이터 구조 포멧으로 내려주는것. view나 react, 서버끼리 통신할때 사용
      - @ResponseBody 를 사용
        HTTP의 BODY에 문자 내용을 직접 반환
        viewResolver 대신에 HttpMessageConverter 가 동작
        기본 문자처리: StringHttpMessageConverter
        기본 객체처리: MappingJackson2HttpMessageConverter(json방식)
        byte 처리 등등 기타 여러 HttpMessageConverter가 기본으로 등록되어 있음