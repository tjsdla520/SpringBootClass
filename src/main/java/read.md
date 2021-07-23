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
        
7/20

1. 웹 애플리케이션 계층 구조
 - 컨트롤러 : 웹 MVC의 컨트롤러 역할
 - 서비스 : 핵심 비지니스 로직 구현 ex) 중복 회원 가입 방지
 - 레퍼지토리 : 데이터베이스의 접근, 도메인 객체를 DB에 저장하고 관리 
 - 도메인 : 비지니스 도메인 객체 ex)회원, 주문, 쿠폰 등으 주로 데이터베이스에 저장하고 관리됨

2. 클래스 의존관계
 - 아직 데이터 저장소가 선정되지 않아서, 우선 인터페이스로 구현 클래스를 변경할 수 있도록 설계
 - 데이터 저장소는 RDB, NoSQL 등등 다양한 저장소를 고민중인 상황으로 가정
 - 개발을 진행하기 위해서 초기 개발단계에서는 구현체로 가벼운 메모리 기반의 데이터 저장소 사용

3. 테스트 케이스 작성
 - 개발한 기능을 실행해서 테스트 할 때 자바의 main 메소드를 통해서 실행하거나 웹 애플리케이션의 컨트롤러를 통해서 해당 기능을 실행한다.
   이러한 방법은 준비하고 실행하는데 오래 걸리고, 반복 실행하기 어려워 여러 테스트를 한번에 실행하기 어렵다.
   그래서 자바는 JUnit이라는 프레임워크로 테스트를 실행해서 이러한 문제를 해결한다.
 - @AfterEach : 한번에 여러 테스트를 실행하면 메모리 DB에 직전 테스트의 결과가 남을 수 있다. 그럼 다음 테스트에서 실패하게 된다.
                이떄 @AfterEach를 사용하게되면 각 테스트 가 종료 될때 마다 실행된다. 이때 메모리 DB에 저장된 데이터를 삭제한다.
   
7/23
1. 회원 서비스 개발 및 테스트하여 확인
 - 테스트할때는 //given //when //then 으로 나누어 테스트하는것을 추천
 - DI = dependency injection 개념 약간
 - @BeforeEach : 각테스트 실행 전에 호출된다. 테스트가 서로 영향이 없도록 항상 새로운 객체를 생성하고 의존관계도 새로 맺어준다.