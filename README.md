# java110

비트캠프 **자바 110기** 실습 프로젝트

## java110-project (tag: v5.0)

- jsp 액션태그 적용
- 작업
    - list.jsp, detail.jsp에 액션 태그를 적용한다.

## java110-project (tag: v4.9)

- JSP를 활용한 MVC 모델 1 타입 적용
- Servlet + JSP를 활용한 MVC 모델 2 타입 적용

## java110-project (tag: v4.8)

- filter를 이용하여 사용 권한 제어하기

## java110-project (tag: v4.7)

- session적용하기

## java110-project (tag: v4.6)

- 쿠키 적용하기

## java110-project (tag: v4.5)

- 포워드, 인클루드 적용하기

## java110-project (tag: v4.4)

- refresh, redirect 적용

## java110-project (tag: v4.3)

- HTML 출력하기.

## java110-project (tag: v4.2)

- 리스너를 활용하여 공용 자원 준비하기

## java110-project (tag: v4.1)

- 서블릿의 loadOnStartup 배치 속성을 이용하여 공용 자원을 준비하기.

## java110-project (tag: v4.0) 

- 서블릿 기술을 적용하여 서버 애플리케이션 만들기.

------------------------------------

## java110-project (v3.1)

- 웹서버를 중계 서버로 사용하기
- 서블릿 컨테이너 적용
    - 톰캣 서버 설치
    - build.gradle 에 servlet-api 라이브러리 추가

## java110-project (v3.0)

- 웹 브라우저를 클라이언트로 사용하기.
- 서버에 HTTP 프로토콜을 처리하는 기능 추가
- ServerApp믈래스를 HTTP 프로토콜 요청과 응답을 처리하는 방식으로 변경한다.

## java110-project (v2.9)

- Command 패턴으로 분활된 케서드를 한 클래스로 합치기.

## java110-project (v2.8)

- 멀티 쓰레드 Connection-Oriented에서 Stateless방식

## java110-project (v2.7)

- 멀티 쓰레드 적용하기.

## java110-project (v2.6)

- client/Server 구조로 변경.
- 소켓 프로그래밍 구현.
- 멀티 쓰레딩 구현.
- 프로토콜 개념 이해

## java110-project (v2.5)

- Spring IoC 컨테이너 도입.

## java110-project (v2.4)

- DB connection 공유하기.
- DB 연결 객체를 재 사용하여 garbage를 줄이고, 연결 실행 속도를 높이기 위함.

## java110-project (v2.3)

- DAO에 JDBC 적용
- 작업 
    - Data Modeling과 forward engineering 수행
    - 테이블 준비
    - JDBC API 활용
    - 트랜잭션 다루기

## java110-project (v2.2)

- DAO에 JDBC 적용

## java110-project (v2.1)

- 예외처리 적용

## java110-project (v2.0)

- DAO에 파일 입출력 도입
- DAO에 인터페이스 적용 

## java110-project (v1.9)

- IoC Container가 객체생성 후에 수행하는 작업을 별도의 클래스로 분리한다.
- 향후 객체 생성 후에 또 다른 작업을 추가하기 쉽도록.

## java110-project (v1.8)

- 의존 객체 주입하기
- 미니 IoC개선.

## java110-project (v1.7)

- DAO도입하기 (Data Access Object))
    - 데이터를 저장하는 방식이 바뀌더라도 기존 클래스에 졍향을 주지 않게 하려면,데이터를 다루는 부분을 List가 아닌 별도의 클래스로 정의 해야한다.
    - 즉, List를 통해 데이터를 메모리에 저장하는 대신에 파일이나 데이터베이스에 저장 한다면 기존 코드를 변경해야하는 불상사가 있다.
    - 이부분을 해결하기 위함이다.
- 작업
    - 학생 관리, 강사 관리, 매니져 관리 각각에 사용할 DAO 클래스를 정의한다.

## java110-project (v1.6)

- Command 디자인 패턴 적용
- 컨트롤러 구조 변경
- 작업
    - 컨트롤러에 명령을 처리하는 각각의 메서드를 별도의 클래스로 분리한다.

## java110-project (v1.5)

- 리플렉션 API활용 II
- 애노테이션 활용
- 미니 IoC 컨테이너 개선
- 작업
    - 자동으로 생성되어 할 객체에 붙일 애노테이션 정의
    - 컨트롤러 객체에 애노테이션 적용
    - 애노테이션이 붙은 클래스만 객체를 생성.

## java110-project (v1.4)

- 리플랙션 API 활용
- File 클래스로 디렉토리 및 파일 다루기
- 미니 IoC 컨테이너 작성

## java110-project (v1.3)

- 인터페이스 활용

## java110-project (v1.2)

- 자바 컬렉션 API 사용

## java110-project (v1.1)

- 인터페이스 적용
- 의존 객체 주입(Dependency Injectuib ; DI) 적용

## java110-project (v1.0)

- LinkedList 구동 원리 및 적용

## java110-project (v0.9)

- 제네릭 활용법

## java110-project (v0.8)

- 목록을 다루는 클래스들을 리팩토링하기
- 다형적 변수의 활용법
- 클래스 멤버(변수, 메서드, 블록)와 인스턴스 멤버의 차이점
- 생성자 사용

## java110-project (v0.7)

- 목록 다루기.
- 배열의 항목을 추가하고 삭제하는 기능을 추가한다
- 배열의 값 목록을 다루는 기믕을 별도의 클래스로 분리한다.

## java110-project (v0.6)

- 패키지 활용 및 클래스의 접근 범위

## java110-project (v0.5)

- 조건문 반복문 메소드 활용
- 강사, 학생 , 매니져를 구분하여

## java110-project-01 (v0.4)

- 여러 속성의 값을 다루기 쉽도록 클래스를 이용하여 사용자 정의 데이터타입을 만들고, 그 데이터를 다룰 연산자를 정의한다.

## java110-project-01 (v0.3)

- 관련 명령들을 재사용하기 쉽도록 메소드를 블럭으로 묶는다.

## java110-project-01 (v0.2)

- 배열을 이용하여 여러 회원의 정보를 저장하기

## java110-project-01 (v0.1)

- 자바 프로젝트 디렉토리 구성하기

```
1) 자바 프로젝트 디렉토리 구성하기
$ gradle init --type java-application

2) Gradle 설정 파일에 'eclipse' 플러그인 추가
build.gradle 파일에 id 'eclipse' 추가

3) 이클립스 설정 파일 생성
$ gradle eclipse

4) 이클립스에서 프로젝트를 임포트
```