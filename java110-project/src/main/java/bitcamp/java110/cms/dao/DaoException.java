package bitcamp.java110.cms.dao;

public class DaoException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public DaoException() {
        super();
    }

    public DaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
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