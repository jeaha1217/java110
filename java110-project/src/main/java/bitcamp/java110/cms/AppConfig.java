package bitcamp.java110.cms;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@ComponentScan(basePackages="bitcamp.java110.cms")
@PropertySource("classpath:/bitcamp/java110/cms/conf/jdbc.properties")
//  Mybatis에서 자동으로 DAO를 생성할때 사용할 인터페이스가 들어 있는 패키지 설정.
@MapperScan("bitcamp.java110.cms.dao")   //  패키지 경로(.)
public class AppConfig {
    
    @Autowired
    Environment env;
    
    public AppConfig() {
        System.out.println("AppConfig()");
    }

    @Bean(destroyMethod="close")
    public DataSource dataSource() {

        System.out.println(env);

        System.out.println("dataSRC 객체 생성.");
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(env.getProperty("jdbc.driver"));
        ds.setUrl(env.getProperty("jdbc.url"));
        ds.setUsername(env.getProperty("jdbc.username"));
        ds.setPassword(env.getProperty("jdbc.password"));
        //  jdbc. 붙이는 이유 ; 기존 환경 변수들과의 충돌을 막기 위해 
        
        ds.setDefaultAutoCommit(false);

        return ds;
    }

    @Bean
    public SqlSessionFactory sqlSessionFacrtory(
            DataSource dataSource,
            ApplicationContext appCtx
            ) {
        System.out.println("sqlSession객체 생성.");
        System.out.println(dataSource);
        System.out.println(appCtx);
        try {
            SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
            //  이 클래스 만든 개발자놈이 댕청인가, factory를 만드는 factory임.

            //  DB 커넥션 풀을 관리해주는 객체를 꼽는다.
            factory.setDataSource(this.dataSource());

            //  SQL 맵퍼 파일에서 도메인 객체의 별명을 사용 하려면
            //  도메인 객체가 들어 있는 패키지를 지정해야 한다.
            //  그러면 Mybatis가 해당 패키지의 모든 클래스애 대해 별명을 자동으로 생성할 것이다.
            factory.setTypeAliasesPackage("bitcamp.java110.cms.domain");

            //  SQL 맵퍼 파일의 경로를 등록한다.
            factory.setMapperLocations(
                    appCtx.getResources(
                            "classpath:/bitcamp/java110/cms/mapper/**/*Dao.xml"));
            //  **  : wildcard
            //  *   : 
            return factory.getObject();

        }   catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
/*
    //    테스트용 메인.  
    public static void main(String[] args) {

        //  JAVA Config를 사용할 때는 다음 IoC Container 를 사용한다.
        ApplicationContext iocContainer = 
                new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("-----------------");

        // 컨테이너에 들어있는 객체의 개수와 이름 알아내기.
        int count = iocContainer.getBeanDefinitionCount();
        System.out.printf("Bean 갯수 : %d\n", count);

        String[] names = iocContainer.getBeanDefinitionNames();
        for (String name : names) {
            System.out.printf("=> %s : %s\n", name, iocContainer.getType(name).getName());
        }
        System.out.println("-----------------");

        //  단위 테스트를 해보자.

        ManagerService s =
                (ManagerService) iocContainer.getBean(ManagerService.class);
        System.out.println(s.list(1, 5));

        System.out.println("-----------------");

        AppConfig appConfig = (AppConfig) iocContainer.getBean(AppConfig.class);

        System.out.println(appConfig.env);

        System.out.println("-----------------");

        Properties props = System.getProperties();
        Set<Entry<Object,Object>> entrySet = props.entrySet();
        for (Entry entry : entrySet) {

        }
    }
*/
}
