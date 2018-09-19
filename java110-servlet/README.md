# 자바서블릿 프로그래밍

##  톰켓 서버 디렉토리 구조.
```
bin     -   톰켓 서버 실행/종료 관련파일.
conf    -   톰켓 서버 설정 파일.
logs    -   톰켓 서버 상황을 기록한 파일.
lib     -   톰켓 서버 실행과 관련된 자바 라이브러리 파일.
temp    -   톰켓 서버를 실행 하는 중에 임시로 저장하는 파일
webapp  -   웹 애플리케이션 배포
work    -   JSP를 자바 소스파일로 변환한 파일
```

### 이클립스에서 톰켓 서버 연동.

- 이클립스에서 톰켓 서버를 실행/동료할 수 있음.
- 웹 프로젝트를 테스트 하기 위해 별도의 테스트 환경을 구축함.
- 따라서 원본 톰켓 서버의 실행환경을 손대지 않음.
- 원본 톰켓 서버에서 설정 파일을 복사해서 사용함.


### 이클립스에서 톱켓 서버 테스트 환경 구축하기.
- "Servers" view 에서 우클릭.  "New > Server" 클릭.
- 서버 유형 목록에서 이미 이클립스에 등록되어있는 톰켓 서버 버전을 선택한다.
- 적당한 서버 이름을 지정한 후 "FINISH"
- 이클립스 웤스페이스에 "Servers"라는 프로젝트 폴더가 생성된다.
    - 지정한 서버 이름으로 폴더가 생성된다. 예)servlet test-config
    -  이 폴더에는 톰캣 서버 폴더에서 복사해온 설정 파일들이 들어있음.
    - 톰캣 서버의 원본 설정 파일을 손대지 않고, 별도로 복사해서 사용하는것임.
    - 개발하는 동안에는 이렇게 복사해 온 설정 파일을 사용해서 톰캣서버를 실행. 
    - 테스트 환경을 바꿔 보고싶을땐 이곳에서 바꿔야함.
- 이클립스에서 톰캣 서버 테스트 환경을 실행한다.
    - 원본 톰캣 서버와는 별개로 테스트를 위한 별도의 폴더를 구축한다.
    - 이유? 각 웹 애플리케이션 별로 다양한 조건의 테스트를 수행하기 위해서.
    - 톰캣 서버 테스트 환경을 실행하면 이클립스 웤스페이스 폴더에 톰켓 서버 테스트 환경 디렉토리가(temp) 구축된다.


톰켓 테스트 환경 디렉토리 구조

```
(톰캣 서버 테스트 환경을 생성한 후 서버를 한 번 실행 해야 폴더가 생성된다.)
[이클립스 작업폴더] 예) /Users/Sorrowkissed/workspace
.metadata\
    .plugin\
        org.eclipse.wst.server.core\
            tmp0\           -   톰캣 테스트 환경.(생성된 순서대로 0,1,2,3 순으로 부여됨.)
                conf\       -   이클립스 "Servers/테스트 환경 폴더"에 별도로 편집된 설정 파일을 복사해 옴..
                logs\       -   테스트 환경에서 톰캣 서버를 실행하는 중에 출력된 로그파일.
                temp\       -   테스트 환경에서 톰캣 서버를 실행하는 중에 임시 작업 파일.
                webapp\     -   테스트 환경에서 톰캣 서버를 실행할 때는 이 폴더를 사용하지 않는다.
                work\       -   테스트 환경에서 톰캣 서버를 실행할 때 JSP변환 파일.
                wtpwebapps  -   테스트 환경에서 톰캣 서버를 실행할 때 웨 어플리케이션을 배치 (war)
            tmp1\
            tmp2\
            ...
```
            
##  톰캣 서버 테스트 환경으로 애플리케이션 배포하고 실행하기.

### 애플리케이션 배포

- 톰캣 서버 테스트 환경(Servers뷰에 등록한 테스트 환경) 메뉴 에서 "Add and Remove" 선택
- 왼쪽에 나열된 프로젝트 중에서 테스트할 프로젝트를 선택한 후 "Add" 클릭
- 톰캣 서버 테스트 환경에서 "Publish" 메뉴를 선택.
- 또는 "Start" 메뉴를 선택한다.
    - 선택한 프로젝트에서 배포할 파일들이 테스트 환경의 배포 폴더에 자동으로 복사된다.
- 주의!
    - 서버가 실행 중일때 배포를 하면 자동으로 프로젝트 폴더에서 배포 파일들이 복사됨.
    - 그러면 톰캣 서버는 배포한 웹 애플리 캐이션을 자동으로 로딩함.
    - 하지만, 가끔 자동 복사가 안될 때가 있음.
    - 그럴 경우 톰캣 서버를 멈추고, 배포프로젝트를 제거 한 후 위 과정을 다시 수행!!

```
    -- 작동이 잘 안되면
        [서버 스탑 - 리무브 - 빈 서버 스타트 - 스탑 - 프로젝트 애드 - 퍼블리쉬 - 
        workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ 이곳.
            예) java110-servlet/WEB-INF/classes/bitcamp/java110 와 같은 
        dir 여부 확인(안되면 다시 반복.) - 시작.]
```
- 톰캣 서버 테스트 환경에는 톰캣 서버 원본에 있던 웹 애플리케이션이 없기 때문에
    기본으로 출력하는 페이지가 없다.(톰캣 고양이 메인이 뜨지 않음.)
    
(배포하다 /= 배치하다)

### 애플리케이션 실행
톰캣 서버에 배치된 웹 애플리케이셩 실행할 때 다음의 규칙에 따라 요청하라!

```
http://localhost:portNo/ProjectName/Dir
ex)
http://localhost:8888/java110-servlet/index.html
```

### 애플리케이션 배치명 변경하기
- 애플리캐이션 배치 이름을 지정 하지 않으면 기본이 프로젝트 명임.
- setting.gradle 파일에서 애플리캐이션 이름을 변경.
        ```
        - rootProject.name = 'web01'
        ```
    - gradle eclipse 실행.
        Servers - test-config -server.xml 최하단에 path가 바뀜.
        server.xml은 직접 바꾸지 말고 gradle을 써야함.

배치폴더 (tmp0/wtpwebapps)에 프로젝트를 배치할 때 프로젝트 이름으로 배치되더라도
웹브라우저에서 요청할때는 프로젝트 명이 아니라 다음과 같이 배치 이름으로 실행 할 수 있다.
```
http://localhost:8888/web01/index.html
```

### 웹 애플리케이션을 root로 만들기

웹 애플리케이션을 실행할 때 웹 애플리캐이션 이름을 지정하기 싫다면,
다음과 같이 톰켓 서버에 설성하면 됨.

- 톰캣 서버 테스트 환경 목록에서 해당 서버를 더블클릭.(우클릭 open.)
- Modules tab에서
- 웹 애플리케이션을 선택한 후 "edit' 버튼 클릭.
- 'Path' 값을 "/"로 설정.
- 저장.
    - 실제는 server.xml파일의 배치 정보가 변경 됨.
- 톰캣 서버 재시작.

```
웹 브라우저에서 톰캣 서버에 요청할때 웹 애플리케이션 이름을 지정 하지 않아도 된다.
http://localhost:8888/index.html
```


## 웹 애플리케이션을 만드는 방법

### 웹 애플리캐이션의 구성요소
- 컴포넌트**
    - 서블릿, 필터, 리스너
    - 컴포넌트는 배치될 때 /WEB-INF/classes 폴더에 배치된다.
- 웸 애플리케이션 배치 정보 파일**
    - Deployment Descriptor 파일이라 부른다.
    - 줄여서 DO 파일이라 부른다.
    - /WEB-INF/web.xml 파일이다.
    - 이 파일에 웹 컴포넌트에 대한 실행 정보를 작성한다.
- 의존 라이브러리*
    - 웹 애플리케이션이 사용하는 외부 라이브러리이다.
    - 배치 폴더에서 /WEB-INF/lib 폴더에 배치된다.
- JSP 파일**
    - 배치폴더(/)에 그대로 복사된다.
- 정적 웹 리소스파일
    - .html, .css, .js, .jpeg, .png, .gif 등의 파일
    - 배치 폴더(/)에 그대로 복사된다.    

### 웹 애플리캐이션 서버(Web Application Server)

#### 개요

- JavaEE Spec. 에 따라 만든 서버.
- JavaEE 스펙에 따라 작성된 웹애플리캐이션이라면 을 실행할 수 있다.
- 보통 WAS로 줄여서 표현함. 가끔 'AS' 라고 하는 놈들도 있다.

#### 구성요소

- HTTP Server
    - HTTP 프로토콜을 기반으로 웹 브라우저의 요청을 받고 응답하는 서버
    - 보통 실무에서 운영 할 때는 웹 어플리케이션 서버에 내장된 HTTP Server를 사용하지 않고 **별도의_HTTP_Server(ex:Apache,nginX등)를_사용한다.**
- Servlet Container
    - JavaEE 스펙 중에서 웹 관련 스펙을 구현한 서버
    - 서블릿, 필터, 리스너, JSP 를 관리하고 실행하는 서버
- EJB Container
    - JavaEE 스펙 중에서 EJB 관련 스펙을 구현한 서버.
    - 현재는 달 사용하지 않음
    - ? POJO 기반의 Spring 프레임웤을 주로 사용하기 때문.    
- 대표제품
    - JavaEE의 모든 Spec을 준수하는 서버
        - Oracle's      WebLogic                (유료)
        - TmaxSoft's    JEUS                    (유료)
        - RedHat's      JBoss                   (유/무료)
        - IBM's         WebSphere               (유료)
        - Oracle's      GlassFish               (개발용 무료)
        - ApacheSoftwareFoundation's Geronemo   (무료)
    - JavaEE의 스펙중 웹 관련 스팩만 준수하는 서버
        - 보통 미니 HTTP Server와 Servlet Container를 갖추고 있음.
        - ASF's     Tomcat      (무료)
        - Caucho Technology's   Resin   (무료)
        - Eclipse's Jetty       (무료)

#### JAVA EE SPEC.

- Java Enterprise Edition의 약자.
- 자바로 기업용 Application을 제작하는데 필요한 기술을 정의한 명세임.
- 주요 기술
    - Web Application Technology
        : Servlet, JSP, JSF, Expression Language, WebSocket, JSTL등
    - 분산 컴포넌트 기술
        : EJB, message Service, Tranjection, JavaMail 등
    - 웹 서비스 기술
        : Jax-RS, Jax-RPC, JaxR 등
    - 관리 및 보안 기술.
- Java EE Implements(구현체)
    - Java EE 기술 명세에 따라서 동작하도록 만든 서버를 말함.
    - Oracle에서 Java EE 명세를 제대로 구현했는지 검사하고 인증서를 발급함.
    - 보통 WAS 라고 부르며, WebLogic, JBoss, JEUS 제품이 이에 해당됨.
    - Tomcat, Resin, Jetty는 Java EE 명세 중에서 웹 어플리케이션 기술만 구현한 서버임.
- Java EE Version
    - Java EE 는 여러 하위 기술로 구헝됨.
    - 하위 기술 각각에 대해서 버전이 부여되고 관리됨.
    - JAVA EE 버전별로 각 하위 기술들의 버전이 지정되어 있음.
    - Version EX) 
        - JAVA EE 8 : Servlet 4.0, JSP 2.3, JSTL 1.2, EJB 3.2 등
        - JAVA EE 7 : Servlet 3.1, JSP 2.3, JSTL 1.2, EJB 3.2 등
        - JAVA EE 6 : Servlet 3.0, JSP 2.2, JSTL 1.2, EJB 3.1 등
        - JAVA EE 5 : Servlet 2.5, JSP 2.1, JSTL 1.1, EJB 3.0 등
- WeqApp을 제작할 때 **주의** 할 사항!
    - WAS 제품의 버전을 확인.   (고객놈이 어떤 버전을 쓰는지에)
    - 그 제품의 Java EE 어떤 버전의 구현체인지 확인.
    - 그 버전에 맞춰서 Servlet/JSP 문법을 사용해야함.


