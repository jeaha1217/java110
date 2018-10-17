//	 객체 생성하기 : Spring IoC Container 사용 II
package ex01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test05 {
	public static void main(String[] args) {

		/*	객체의 생성과 소멸과 의존객체 주입을 관리하는
				bean container(=IoC Container) 생성하기. 
		*/
		ClassPathXmlApplicationContext iocContainer = 
				new ClassPathXmlApplicationContext("ex01/app-context2.xml"); 
				
		//	IoC Container에서 객체 꺼내기.
		Car obj = (Car) iocContainer.getBean("c1");
				
		System.out.println(obj);
		
		iocContainer.close();
	}
}
