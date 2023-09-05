package ch05_pjt_01.contact.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;

import ch05_pjt_01.contact.ContactSet;
import ch05_pjt_01.contact.dao.ContactDAO;

public class ContactSearchService {
	//@Autowired
	//@Qualifier("usedDAO")
	@Inject
	@Named("contactDAO")
	private ContactDAO contactDAO;
	
//	@Autowired
//	public ContactSearchService(ContactDAO contactDao) {
//		System.out.println("contactDAO : "+contactDao);
//		this.contactDao = contactDao;
//	}
	
	@Inject
	@Named("contactDAO")
	public ContactSearchService(ContactDAO contactDAO) {
		this.contactDAO = contactDAO;
	}
	
	public ContactSet searchContact (String name) {
		if(verify(name)) {//있으면 true 없으면 false
			return contactDAO.select(name);
		}else {
			System.out.println("Contact information is no available");
		}
		return null;
	}
	
	public boolean verify(String name) {
		ContactSet contactSet = contactDAO.select(name);
		return contactSet != null ? true : false;
	}
	
	
	//@Autowired
	@Inject
	@Named("contactDAO")
	public void setContactDAO(ContactDAO contactDao) {
		this.contactDAO = contactDao;
	}
}
