package bitcamp.java110.cms.domain;
    //  여러 속성의 값을 관리하기 쉽도록 사용자 정의 데이터 타입을 만들어 사용한다.
public class Member{
    protected String name;
    protected String email;
    protected String password;

    //  인스턴스의 메모리를 다루는 operator == accessor == property
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}