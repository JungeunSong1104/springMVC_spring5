package ch03_pjt_03;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		//GenericXmlApplicationContext 임포트해줌
		
		CalAssembler calAssembler = ctx.getBean("calAssembler", CalAssembler.class);
		//Bean 연결해줌
		
		calAssembler.assemble();
		
		ctx.close();
	}

}
