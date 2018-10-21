//	 객체 생성하기 : factory method 패턴 적용.
package ex01;

public class test02 {

    public static void main(String[] args) {
        Car c1 = CarFactory1.create("아반떼");

        System.out.println(c1);
    }
}
