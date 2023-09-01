package exercise;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		// GenericXmlApplicationContext 임포트해줌

		Hello hello = ctx.getBean("hello", Hello.class);
		// Bean 연결해줌

		hello.sayHello();
		hello.selectHello();

		ctx.close();
	}

}
