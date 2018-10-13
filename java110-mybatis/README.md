# Mybatis persistence framework

## 라이브러리 준비
- mvnrepository에서 'mybatis' 검색
- build.gradle에서 mybatis의존 라이브러리 추가
- 콘솔에서 gradle eclipse
- eclipse에서 refresh

## mybatis 적용   
- SqlSessionFactory 객체 준비
    - 'getting started' : http://www.mybatis.org/mybatis-3/getting-started.html
    - 'getting started' 문서에서 코드 발췌하여 자바 소스 파일에 둔다.
        String resource = "org/mybatis/example/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
        new SqlSessionFactoryBuilder().build(inputStream);

- Mybatis 설정 파일 준비
    - 'getting started' 문서에서 코드 발췌.
    - mybatis-config.xml(이름 변경 가능) 설정파일에 붙여 넣는다.
    
- SQL 맵퍼 파일 준비
    - 'getting started' 문서를 참조해서 SQL 맵퍼 파일을 만든다.
- DAO에 적용