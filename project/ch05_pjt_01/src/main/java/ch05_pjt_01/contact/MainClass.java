package ch05_pjt_01.contact;

import org.springframework.context.support.GenericXmlApplicationContext;

import ch05_pjt_01.contact.service.ContactRegisterService;
import ch05_pjt_01.contact.service.ContactSearchService;
import ch05_pjt_01.contact.utils.InitSampleData;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		
		AutoWiredEx autowiredEx = ctx.getBean("autowiredEx", AutoWiredEx.class);
		autowiredEx.autoWiredMethod(null, null);
		
		InitSampleData initSampleData = ctx.getBean("initSampleData", InitSampleData.class);
		
		String[] names = initSampleData.getNames();//이름과 전화번호르 배열로 저장
		String[] phoneNumbers = initSampleData.getPhoneNumbers();
		
		ContactRegisterService registerService = ctx.getBean("registerService", ContactRegisterService.class);
		for(int i=0; i<names.length; i++) {
			ContactSet contactSet = new ContactSet(names[i], phoneNumbers[i]);
			registerService.register(contactSet);
		}
		
		ContactSearchService searchService = ctx.getBean("searchService", ContactSearchService.class);
		
		ContactSet contactSet = searchService.searchContact("김아수라방구라");
		System.out.println("name : "+ contactSet.getName());
		System.out.println("phone number : "+ contactSet.getPhoneNumber());
		System.out.println("-----------------------------------------------");
		
		 contactSet = searchService.searchContact("김또네왕초");
		System.out.println("name : "+ contactSet.getName());
		System.out.println("phone number : "+ contactSet.getPhoneNumber());
		System.out.println("-----------------------------------------------");
		
		 contactSet = searchService.searchContact("송죽전프린세스");
		System.out.println("name : "+ contactSet.getName());
		System.out.println("phone number : "+ contactSet.getPhoneNumber());
		System.out.println("-----------------------------------------------");
		
		
		
		
		

	}

}
