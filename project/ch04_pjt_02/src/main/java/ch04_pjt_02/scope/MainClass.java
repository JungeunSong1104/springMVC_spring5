package ch04_pjt_02.scope;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		//일반적으로 뉴키워드를 사용해서 객체를 생성하면 dependencyBean_01에 덜어간데이터와 dependencyBean_02에 들어간 데이터는 달라야하는데
		
		DependencyBean dependencyBean_01 = ctx.getBean("dependencyBean", DependencyBean.class);
		//객체를 새로생성해서 가져오는게 아니고 ioc에는 이미 빈객체가 존재하고 여기에서는 
		//걍 getBean을 이용해서 ioc에 잇는 빈을 가져오는것뿐
		DependencyBean dependencyBean_02 = ctx.getBean("dependencyBean", DependencyBean.class);
		//dependencyBean_01과 dependencyBean_02는 동일한 객체를 참조하고 있어서 동일한 객체가 계속해서 사용되는것
		//이게바로 싱글턴
		if(dependencyBean_01.equals(dependencyBean_02)) {
			System.out.println("dependencyBean_01 == dependencyBean_02");
		}else {
			System.out.println("dependencyBean_01 != dependencyBean_02");
		}
		
		ctx.close();
		

	}

}
