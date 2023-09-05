package ch04_pjt_exercise.view;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import ch04_pjt_exercise.dao.MemberDO;

public class MemberViewer {
//단순하게 뷰 역할만함 출력만해준다는뜻 따라서 생성자도 필요벗고데이터를 저장ㅇ할 멤버변수도 필ㄹ요없음 그저 콜솔로 출력만해줄뿐
	public void showMessage(String line) {//매개변수로 문자열을 받아 출력해줌
		System.out.println(line);
	}
	public void showMember(MemberDO member) {//매개ㅕㄴ수로 MemberDO를 받아서
		this.showMessage(member.getId());//멤버가 가지고있는 getId
		this.showMessage(member.getPassword());
		this.showMessage(member.getContact());
		this.showMessage(member.getEmail());
		this.showMessage(member.getRegisteredDate());
		this.showMessage(member.getModifiedDate());
	}
	
	public void showAllMembers(Map<String, MemberDO> members) {
		Set<String> keys = members.keySet();
		Iterator<String> iterator = keys.iterator();
		System.out.println("Member LIST STARTS -----------------");
		System.out.println("STUDENT START ---------------------");
		
		while(iterator.hasNext()) {
			String key = iterator.next();
			MemberDO member = members.get(key);
			System.out.println("| sId : " + member.getId() + "/t");
			System.out.println("| sPw : " + member.getPassword() + "/t");
			System.out.println("| sName : " + member.getContact() + "/t");
			System.out.println("| sAge : " + member.getEmail() + "/t");
			System.out.println("| sGender : " + member.getRegisteredDate() + "/t");
			System.out.println("| sMajor : " + member.getModifiedDate() + "/t");
		}
		
	}
}
