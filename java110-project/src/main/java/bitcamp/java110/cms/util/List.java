package bitcamp.java110.cms.util;

public interface List<T> {
    void add(T obj);
    T get(int index);
    T remove(int index);
    int size();
    
    default void insert(int index, T obj) { }
    /*  default method의 목적
        ->  규칙을 추가하면 기존에 있던 클래스들이 영향을 받음.
            즉, 기존 클래스들은 새로 추가된 메소드를 반드시 구현해야함.
            이런 문제를 해결하기(기존 클래스들에 영향을 주지 않기) 위해 등장한 문법.
        default method
            Interface의 method는 규칙임.
            하위 호환을 위해서 method를 추가하고 구현하더라도
            실제 많은 작업을 처리하게 구현해서는 안됨.
            구현 클래스들에 영향을 끼치지 않게 하는 정도로만 코드를 작성 해야함.
        
     */

}
