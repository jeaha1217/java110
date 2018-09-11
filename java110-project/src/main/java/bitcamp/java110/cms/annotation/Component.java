package bitcamp.java110.cms.annotation;
//  일반 주석은 컴파일 하게되면 날아가버림
//  클래스 고유의 정보는 아니지만 클래스를 관리 or 설명 할 주석이 필요해짐.
//  부가 데이터, 데이터를 설명하거나 관리하기 위한 데이터 : metadata = tag = element.
//  controller class들의 public String name = "1, 2, 3";
//  html에서 h1~6태그.
//  주석 자체를 구조화 할 수 있음.

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*  애노테이션 유지정책
    CLASS   : 컴파일 한 후에도 .class파일에 남겨둔다, 단, 실행한 후에는 참조 할 수 없다.
              Reflection API로 클래스에서 애노테이션 정보를 추출할 수 없다.
              애노테이션 유지정책을 지정하지 않으면 CLASS가 기본 default 값이다.
    SOURCE  : 컴파일 할 때 제거 된다. 즉, .class파일에 남겨두지 않는다.
    RUNTIME : 컴파일 한 후에도 .class파일에 남겨둔다. 실행할 때도 참조 할 수 있다.
              Reflection API로 클래스에서 애노테이션 정보를 추출할 수 있다.
*/
/*  
    Retention에 value속성 하나만 넣을때에는 value는 생략 가능하다.
*/
@Target(ElementType.TYPE)
//@Retention(value = RetentionPolicy.SOURCE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
    String value() default "";
    //  field형식의 이름을 가진 property임?
    //  default ""; 를 붙이면 또 달라짐.
}
