package bitcamp.java110.cms.context;

/*  이 규칙은
    IoC Container(ApplicationContext)가 객체들을 생성한 후에
    마무리 작업을 수행하는 객체에 대해 호출시킴.
    따라서 마무리 작업을 수행하는 클래스를 만들 때는
    반드시 다음 규칙을 준수해야함.
*/
public interface BeanPostProcessor {
    void postProcess(ApplicationContext beanContainer);
}
