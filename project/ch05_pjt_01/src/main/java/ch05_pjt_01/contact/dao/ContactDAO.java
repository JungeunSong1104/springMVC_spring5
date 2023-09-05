package ch05_pjt_01.contact.dao;

import java.util.HashMap;
import java.util.Map;

import ch05_pjt_01.contact.ContactSet;

public class ContactDAO {
//crud기능 컨트롤러에의해 호출되고 db와 연결되고 db에 직접접근하지 않고 hashmap을 이용해 데이터에 접근
	private Map<String, ContactSet> contactDB = new HashMap<String, ContactSet>();
	
	public void insert(ContactSet contactSet) {
		contactDB.put(contactSet.getName(), contactSet);//contactSet.getName()를 키값으로 사용, contactSet객체 자체를저장
	}
	
	public ContactSet select(String name) {
		return contactDB.get(name);
	}
	
	public Map<String, ContactSet> getContactDB(){
		return contactDB;
	}
}
