package bitcamp.java110.cms.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//다른 annotation과 구분을 위해 @Target을 붙임.
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR})

//  의존 객체를 주입하기 위해 호출 되어야 하는 메소드에 대해
//  이 Annotation을 붙일것임.
//  IoC Container는 이 Annotation이 붙은 메소드를 호출하여 의존 객체를 주입한다.
@Retention(RetentionPolicy.RUNTIME)
public @interface Autowired {
//  지금은 setter에만 붙이지만, 생성자에도 붙이고 필드에도 붙일 수 있는녀석임.

    boolean required() default true;
}
