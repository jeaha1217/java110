package bitcamp.java110.cms.domain;

//  super클래스에서 인터페이스 상속받으면 하위클래스는 자동 상속.
@SuppressWarnings("serial")
public class Manager extends Member{
    
    protected String position;
    protected String tel;

    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
}
