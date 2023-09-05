package ch05_pjt_01.contact.service;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;

import ch05_pjt_01.contact.ContactSet;
import ch05_pjt_01.contact.dao.ContactDAO;

public class ContactRegisterService {//연락처 정보를 해쉬맵에 저장하는기능
	
	
	//@Autowired
	//@Resource//@Resource : 메소드위에다가도 추가 가능
	//@Qualifier("usedDAO")
	//@Autowired(required=false)//자동주입이 안될경우 정상적으로 의존성주입이안되더라도 에러발생안하게, but @Autowired(required=false): 사용지양
	@Inject
	@Named("contactDAO")
	private ContactDAO contactDAO;
	
	//@Resource 생성자에는 안됨
	//@Resource //생성자위에 넣으면 오류발생 실행안됨 생성자위에는 리소스사용불가
	@Inject
	@Named("contactDAO")
	public ContactRegisterService(ContactDAO contactDAO) {
		this.contactDAO = contactDAO;
	}
	
//	public ContactRegisterService(){//오버라이드아니고 오버로딩임
//		System.out.println("default constructor");
//	}//기본생성자추가
	
//	@Autowired//아노테이션
//	public ContactRegisterService(ContactDAO contactDao) {
//		System.out.println("contactDAO : "+contactDao);
//		this.contactDao = contactDao;//자기자신의 멤버변수로서 자장하고있음
//	}
	
	public void register(ContactSet contactSet) {
		String name = contactSet.getName();
		if(verify(name)) {
			contactDAO.insert(contactSet);
		}else {
			System.out.println("The name has already been registered");
		}
	}
	
	public boolean verify(String name) {
		ContactSet contactSet = contactDAO.select(name);
		return contactSet == null ? true : false;
	}
	public void setWordDao(ContactDAO contactDao) {
		this.contactDAO = contactDao;
	}
	
	//@Autowired
	@Resource
	public void setContactDAO(ContactDAO contactDao){//contactDao를 세팅하는 세터
		this.contactDAO = contactDAO;
	}
	
}
