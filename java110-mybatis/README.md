# Mybatis persistence framework

## 라이브러리 준비
- mvnrepository에서 'mybatis' 검색
- build.gradle에서 mybatis의존 라이브러리 추가
- 콘솔에서 gradle eclipse
- eclipse에서 refresh

## mybatis 적용   
- SqlSessionFactory 객체 준비
    - 'getting started' : http://www.mybatis.org/mybatis-3/getting-started.html
    - 'getting started' 문서에서 코드 발췌하여 mybatis를 사용할 자바 소스 파일에 둔다.
    ```
        String resource = "org/mybatis/example/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
        new SqlSessionFactoryBuilder().build(inputStream);
    ```

- Mybatis 설정 파일 준비
    - 'getting started' 문서에서 Building SqlSessionFactory from XML 코드 발췌.
    - mybatis-config.xml(이름 변경 가능) 설정파일에 붙여 넣는다.
    ```
        <!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
        <configuration>
            <environments default="development">
                <environment id="development">
                <transactionManager type="JDBC"/>
                <dataSource type="POOLED">
                    <property name="driver" value="${driver}"/>
                    <property name="url" value="${url}"/>
                    <property name="username" value="${username}"/>
                    <property name="password" value="${password}"/>
                </dataSource>
                </environment>
            </environments>
            <mappers>
                <mapper resource="org/mybatis/example/BlogMapper.xml"/>
            </mappers>
        </configuration>
    ```

- SQL 맵퍼 파일 준비
    - 'getting started' 문서를 참조해서 SQL 맵퍼 파일을 만든다.
    - 'MemberDao.xml'
    - 이 파일 안에 SQL문을 작성.
    ```
    <!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
    <mapper namespace="org.mybatis.example.BlogMapper">
        <select id="selectBlog" resultType="Blog">
            select * from Blog where id = #{id}
        </select>
    </mapper>
    ```

- DAO에 적용