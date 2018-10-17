//	 객체 생성하기 : Spring IoC Container 사용.
package ex01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test04 {
	public static void main(String[] args) {

		/*	객체의 생성과 소멸과 의존객체 주입을 관리하는
				bean container(=IoC Container) 생성하기. 
					+					[Inversion of ]
				Dependency Injection(의존객체 주입)
			
			bean	<- 역할,값 상관없이 객체에 대한 자바용어.
			 ||
			object	<- 역할을 강조.
			 ||
			instance <- 값을 강조.
		*/
		ClassPathXmlApplicationContext iocContainer = 
				new ClassPathXmlApplicationContext("ex01/app-context.xml"); 
				
		//	IoC Container에서 객체 꺼내기.
		Car obj = (Car) iocContainer.getBean("c1");
				
		System.out.println(obj);
		
		iocContainer.close();
	}
}
