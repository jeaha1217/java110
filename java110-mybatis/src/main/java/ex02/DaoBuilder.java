package ex02;

import java.io.FileReader;
import java.util.Properties;

public class DaoBuilder {
    
    String settingFilename = "jdbc.properties";
    
    String driver;
    String url;
    String username;
    String password;
    
    public DaoBuilder() throws Exception {
        Properties props = new Properties();
        props.load(new FileReader(settingFilename));
        
        this.driver = props.getProperty("driver");
        this.url = props.getProperty("url");
        this.username = props.getProperty("username");
        this.password = props.getProperty("password");
    }
    
    /*
    public static void main(String[] args) throws Exception {
         DaoBuilder builder = new DaoBuilder();
         System.out.println(builder.driver);
         System.out.println(builder.url);
         System.out.println(builder.username);
         System.out.println(builder.password);
    }
    */
    
    public MemberDaoFactory build() throws Exception{
        
        DataSource dataSource = new DataSource(
                this.driver, this.url, this.username, this.password);
        
        MemberDaoFactory factory = new MemberDaoFactory();
        factory.setDataSource(dataSource);
        
        return factory;
    }
    
}