package ch03_pjt_03_exercise2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		System.out.println("1. korea, 2, english");
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		//GenericXmlApplicationContext 임포트해줌
		
		Assembler as = ctx.getBean("as", Assembler.class);
		//Bean 연결해줌
		
		as.print();
		
		ctx.close();
	}
}
