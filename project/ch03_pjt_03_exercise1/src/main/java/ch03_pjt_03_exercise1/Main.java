package ch03_pjt_03_exercise1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		//ctx는 등록된 bean의 정보를 다 바꾸게됨?
		Greeting gr = ctx.getBean("gr", Greeting.class);
		//new가 아닌 ctx를 이용해서 getBean 메서드를 사용

		gr.message();

		ctx.close();

	}

}
