package bitcamp.java110.cms.dao;

public class DaoException extends Exception{
    private static final long serialVersionUID = 1L;

    public DaoException() {
        super();
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);  //  이거 주석처리하면 super(); 가 호출됨.
    }

    public DaoException(String message) {
        super(message);
    }

}
/*
super();
상위 클래스의 생성자를 호출한다.

a(){
    b();
}

b(){
    c();
}

c(){

}

sysou로 직접 실행해 봐라.
호출은 올라가고 실행은 내려온다.
*/