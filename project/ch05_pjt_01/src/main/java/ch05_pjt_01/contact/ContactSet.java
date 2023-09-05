package ch05_pjt_01.contact;

public class ContactSet {//연락처정보를담고있는 클래스
	private String name;
	private String phoneNumber;
	
	public ContactSet(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
