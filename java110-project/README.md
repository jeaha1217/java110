# java110-project

수업 관리 시스템 만들기

## v4.6

- 쿠키 적용하기
- 작업
    - 

## v4.5

- 포워드, 인클루드 적용하기
- 작업
    - 여러 서블릿에서 공통으로 수행하는 작업을 별도의 서블릿으로 분리한다.
    - 그 서블릿으로 포워드를 수행한다.
    - 예1) ErrorServlet 클래스 생성하고, forword를 적용.
    - 예2) HeaderServlet, FooterServlet 클래스를 생성하고 인클루드를 적용한다.

## v4.4

- refresh, redirect 적용
- 작업
    - 등록 삭제한 후에 목록 페이지를 자동으로 요청하도록 refresh적용.

## v4.3

- HTMl 출력하기
- 작업
    - 서블릿의 출력 콘텐트를 일반 텍스트에서 html로 바꾼다.

## v4.2

- 리스너를 활용하여 공용 자원 준비하기
- 작업
    - ContextLoaderLitener 클래스 생성
    - 리스너에서 DAO준비하기

## v4.1

- 서블릿의 loadOnStartup 배치 속성을 이용하여 공용 자원을 준비하기
- ServletContext를 이용하여 공용자원을 공유하기
- 작업
    - InitServlet 클래스 생성 
    - InitServlet에서 DAO와 DataSource 준비하기
    - ServletContext에 DAO 보관하기

## v4.0

- 서블릿 기술을 적용하여 서버 애플리케이션 만들기
- 작업
    - 클라이언트 요청을 처리하는 컨트롤러를 서블릿으로 전환한다.

## v3.1

- 웹 중계 서버로 사용하기
- 서블릿 컨테이너 적용
    - 톰켓 서버 설치
    - build.gradle 에 servlet-api 라이브러리 추가  

## v3.0

- 웹 브라우저를 클라이언트로 사용하기.
- 서버에 HTTP 프로토콜을 처리하는 기능 추가
- ServerApp믈래스를 HTTP 프로토콜 요청과 응답을 처리하는 방식으로 변경한다.

## v2.9

- Command 패턴으로 분활된 케서드를 한 클래스로 합치기.
- 관련된 컨트롤러 클래스를 한 클래스로 만든다.
    - list, add, detail, delete 클래스를 ManagerController 클래스로 합친다.
    - 각각의 컨트롤러가 크지 않을 때는 한 클래스로 합치기도 한다.

## v2.8

- 멀티 쓰레드 Connection-Oriented에서 Stateless방식으로

## v2.7

- 멀티 쓰레드 적용하기.(Connection-Oriented에서 Stateful방식으로 요청처리.)
- 별도의 thread를 만들어 client 요청을 처리하게 만든다.
- 즉 동시에 여서 client의 요청을 처리한다.

## v2.6

- client/Server 구조로 변경.
- 소켓 프로그래밍 구현.
- 멀티 쓰레딩 구현.
- 프로토콜 개념 이해


gradle build
/Users/Sorrowkissed/git/java110/java110-project/build/libs
java110-project.jar 생성.


gradle clean
gradle build

dir에서 ./java110-project

## v2.5

- Spring IoC 컨테이너 도입.
- 기존에 만들었던 ApplicationContext 대신에 Spring 프레임 워크에서 제공하는 ApplicationContext 사용하기.
- 작업
    -   Spring IoC 컨테이너 라이브러리 추가(build.gradle 파일 편집)
    -   "spring context" 로 mvnrepository.com에서 검색한다.
    -   project dir : gradle eclipse
    -   refresh
    -   
    -  ... 


## v2.4

- DB Connection 공유하기.

## v2.3

- DAO에 JDBC 적용

## v2.2

- 예외 처리 적용
- 예외 처리 문법이 없던 시절
    - return 값 (rtval)로 예외상황을 호출자에게 알렸음.
    - 특정 타입의 값을 리턴 하는 경우 이 방법을 쓰기 곤란해졌음.
- 예외처리 문법 등장.
    - 리턴 값이 아닌 별도의 경로로 예외 상황을 호출자에게 알린다.
    - 이전 방식에 비해 매소드의 리턴타입에 영향을 받지 않는다.
    - 예외 상황을 자세하게 호출자에게 알릴 수 있다.

## v2.1

- 객체 Serialize / Deserialixe 적용
- java.io.Serializable 인터페이스 적용
- transient modifier 사용법

## v2.0.2

- 인터페이스와 구형체를 별도의 패키지로 분리하기

## v2.0

- DAO에 파일 입출력 도입
- DAO에 인터페이스 적용
- 작업
    - DAO데이터에 파일 IO 기능 추가.


## v1.9

- IoC Container가 객체생성 후에 수행하는 작업을 별도의 클래스로 분리한다.
- 향후 객체 생성 후에 또 다른 작업을 추가하기 쉽도록.
- 작업
    - 객체 생성후에 수행할 작업을 별도의 클래스로 분리.

## v1.8

- 의존 객체 주입하기
- 미니 IoC개선.
- 작업 
    - 의존객체를 주입 받을 수 있도록 setter를 준비한다.
    - IoC Container가 자동으로 setter를 호출하도록 Annotation으로 표시한다.

## v1.7

- DAO 도입하기.

## v1.6

- Command 디자인 패턴 적용
- 컨트롤러 구조 변경
- 작업
    - 컨트롤러에서 명령을 처리하는 각각의 메서드를 별도의 클래스로 분리한다.

## v1.5

- 리플렉션 API활용 II
- 애노테이션 활용
- 미니 IoC 컨테이너 개선

## v1.4

- 리플랙션 API 활용
- File 클래스로 디렉토리 및 파일 다루기
- 미니 IoC 컨테이너 작성

## v1.3

- 인터페이스 활용
- App클래스와 Controller들 사이의 호출 규칙(사용규칙)을 인터페이스로 정의한다.

## v1.2

- 자바 컬렉션 API 사용
- 직접 제작한 List, ArrayList, LinkedList 대신 자바에서 제공하는 CollectionApi를 사용.

## v1.1

- 인터페이스 적용
- 의존객체 주입(Dependency Injection ; DI) 적용
- 데이터 목록을 다룰 때 호출 하는 메서드의 규칙을 정의 한다.
    - 다양한 방법으로 구현한 객체를 사용할 수 있다.
    - 즉, 규칙을 따르기만 한다면 어떤 객체라도 대체할 수 있다.
- 인터페이스의 default 메서드 활용.

## v1.0

- LinkedList 구동 원리 및 적용

## tag: v0.9

- 제네릭 활용법
- ArrayList에 제네릭 적용하기.

## tag: v0.8

- 목록을 다루는 클래스들을 리팩토링하기
- 다형적 변수의 활용법
- 클래스 멤버(변수, 메소드, 블록)와 인스턴스 멤버의 차이점
- 생성자 사용
- StudentList, ManagerList, TeacherList 클래스들을 한클래스로 합치기.
- 다형적 변수를 사용하여 Student, Manager, Teacher 객체를 모두를 저장할 수 있게 한다.

## tag: v0.7

- 목록 다루기
- 배열에 항목을 추가하고 삭제하는 기능을 추가한다.
- 배열의 값 목록을 다루는 기능을 별도의 클래스로 분리한다.

## tag: v0.6

- 패키지 활용 및 클래스의 접근 범위

## tag: v0.5

- 조건문, 반복문, 메서드 활용
- 강사, 학생, 매니저를 구분하여 입력받고 출력한다.

## v0.4

- 여러 속성의 값을 다루기 쉽도록 클래스를 이용하여 사용자 정의 데이터 타입을 만든다. 또한 그 데이터를 다룰 연산자를 정의한다.

## v0.3

- 관련된 명령들을 재사용하기 쉽도록 메서드 블록으로 묶는다.

## v0.2

- 배열을 이용하여 여러 회원의 정보를 저장하기

## v0.1

- 반복문을 이용하여 여러 회원의 정보를 입력 받아 출력하기
- 작업
    - App.java 변경

## Initial Commit 

- 자바 프로젝트 디렉토리 구성하기

```
1) github - repository 생성
2 - 3) terminal - dir에서 git Clone [url]
        cd dir 들어가기
        mkdir 작업 폴더 만들기
        cd 작업 폴더 들어가기
        $ gradle init --type java-application
4) VisualStudioCode(이하 VS) 에서 gradle 설정파일 (build.gradle)에
        id 'eclipse' 플러그인 추가 + mavenCentral() 옵션
        .gitignore 파일 생성
            .gradle/ .setting/ bin/ build/ .classpath .project
5) terminal : 작업 폴더에서 이클립스 설정파일 생성
             $ gradle eclipse
6) 이클립스에서 프로젝트 임포트.

    이렇게 하는 이유.
    gradle : 프로젝트를 형상화 해주는 빌드 도구. IDE에 종속되지 않도록 하는 개발.
    VS : 이클립스에서 할 수 없는 설정을 할 수 있음.
        
```