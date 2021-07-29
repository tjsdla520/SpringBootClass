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

7/24
1. 스프링빈을 등록하는 방법
- 컴포넌트 스캔과 자동 의존관계 설정
- 자바 코드로 직접 스프링 빈 등록하기

2. 컴포넌트 스캔과 자동 의존관계 설정 
 - @Controller = 스프링시작과동시에 해당클래스에서 객체생성 = 스프링 컨테이너에서 스프링 빈이 관리된다.
 - @Autowired = controller와 service를 연결시켜줄때 사용
 - @Service
 - @Component 어노테이션이 있으면 스프링빈이 자동 등록된다.
 - @Controller, @Autowired, @Service 모두 @Component를 포함한다.

3. 자바코드로 직접 스프링 빈 등록하기
 - 회원 서비스와 회원 리포지토리의 @Service, @Repository, @Autowired 애노테이션을 제거하고 
    config 파일을 생성하여 처리
   
4. 회원관리  - 웹 MVC개발
 - 회원 웹 기능 : 홈화면 추가
 - 회원 웹 기능 : 등록
 - 회원 웹 기능 : 조회

5. H2 데이터베이스 설치

7/26
1. 애플리케이션에서의 H2 db와 연결(요즘은 boot에서 모두해준다. 이전방식 해보기)
 - build.gradle 에 implementation 'org.springframework.boot:spring-boot-starter-jdbc'
   runtimeOnly 'com.h2database:h2' 라이브러리 추가
 - application.properties에 spring.datasource.url= jdbc:h2:tcp://localhost/~/test
   spring.datasource.driver-class-name=org.h2.Driver 추가
   
7/28
1. Spring을 쓰는이유 : 객체지향적이 설계는 다형성을 활용하여 인터페이스를 두고 여러개의 구현체를 구현할수있다.
                        여기서 스프링은 스프링 컨테이너에서 자동으로 지원을 해줄뿐만 아니라 DI가 기존의 코드는 수정하지않고 설정해준다.

2.개방-폐쇄 원칙(OCP, Open-Closed Principle)
 - 확장에는 열려있고, 수정, 변경에는 닫혀있다

3. 스프링 컨테이너와 DB까지 연결한 통합 테스트
 - @SpringBootTest : 스프링 컨테이너와 테스트를 함께 실행한다.
 - @Transactional : 테스트 케이스에 이 애노테이션이 있으면, 테스트 시작 전에 트랜잭션을 시작하고,
   테스트 완료 후에 항상 롤백한다. 이렇게 하면 DB에 데이터가 남지 않으므로 다음 테스트에 영향을 주지
   않는다
   
4. 스프링 JdbcTemplate
 - 스프링 JdbcTemplate과 MyBatis 같은 라이브러리는 JDBC API에서 본 반복 코드를 대부분
   제거해준다. 하지만 SQL은 직접 작생해야 한다
   
7/29
1. JPA
 - JPA는 기존의 반복 코드는 물론이고, 기본적인 SQL도 JPA가 직접 만들어서 실행해준다.
 - JPA를 사용하면, SQL과 데이터 중심의 설계에서 객체 중심의 설계로 패러다임을 전환을 할 수 있다.
 - JPA를 사용하면 개발 생산성을 크게 높일 수 있다.
 - build.gradle에 라이브러리 추가 / application.properties에 설정 추가
 - @Entity jpa가 관리하는 entity / pk를 맵핑 / EntityManager를 DI를 통해 주입받아야한다.
 - org.springframework.transaction.annotation.Transactional 를 사용하자.
 - 스프링은 해당 클래스의 메서드를 실행할 때 트랜잭션을 시작하고, 메서드가 정상 종료되면 트랜잭션을
   커밋한다. 만약 런타임 예외가 발생하면 롤백한다.
 - JPA를 통한 모든 데이터 변경은 트랜잭션 안에서 실행해야 한다

2. 스프링 데이터 JPA
 - 기존 JPA에 스프링부트와 JPA만 사용해도 코드가 줄어드나 인터페이스만으로 개발을 완료 할수 있음
 - 반복적으로 구현하던 CRUD도 구현가능 중복을 줄임
 - 인터페이스에 JpaRepository를 extends 하면 구현체를 자동으로 생성해준다.

3. 스프링 데이터 JPA 제공기능
 - 인터페이스를 통한 기본적인 CRUD
 - findByName() , findByEmail() 처럼 메서드 이름 만으로 조회 기능 제공
 - 페이징 기능 자동 제공

7/30   
1. AOP가 필요한 상황
 - 사용하는 이유 : 모든 메소드의 호출 시간을 측정하고 싶을 때
 - 시간을 측정하는 로직은 공통 관심 사항이다. - 공통관심사항 (cross-cutting concern)
 - 시간을 측정하는 로직과 핵심 비즈니스의 로직이 섞여서 유지보수가 어렵다. - 핵심관심사항 (core concern)
 - 시간을 측정하는 로직을 별도의 공통 로직으로 만들기 매우 어렵다.
 - 시간을 측정하는 로직을 변경할 때 모든 로직을 찾아가면서 변경해야 한다

2. AOP
 - AOP: Aspect Oriented Programming
 - 공통 관심 사항(cross-cutting concern) vs 핵심 관심 사항(core concern)
 - 시간을 측정하는 별도의 로직을 공통으로 만들어서 원하는 적용대상을 정할 수 있고, 변경도 가능하다.
 - 스프링에서의 AOP 동작순서
    스프링 컨테이너 (controller -> 프록시 -> service)











