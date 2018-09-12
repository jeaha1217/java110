package bitcamp.java110.cms.domain;

import java.io.Serializable;

public class Member implements Serializable{
    private static final long serialVersionUID = 1L;
    //  Serialize default로 serialize 안하면 에러남.
    
    protected String name;
    protected String email;
    //  Transient field = Serialize 대상에서 제외. (직렬화? 말이 좀 애매모호한 표현이되서 쓰지 말자.)
    protected transient String password;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}