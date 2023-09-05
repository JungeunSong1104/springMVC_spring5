package ch04_pjt_02_quiz.ems.member.service;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import ch04_pjt_02_quiz.ems.member.Member;

public class PrintMemberInformationService {
	AllMemberInquire allMemberInquire;
	
	public PrintMemberInformationService(AllMemberInquire allMemberInquire) {
		this.allMemberInquire  = allMemberInquire;
	}
	
	public void printMembersInfo() {
		Map<String, Member> allMember = allMemberInquire.allSelect();
		Set<String> keys = allMember.keySet();//hashset으로 바꿔서 학생 정보를 나열
		Iterator<String> iterator = keys.iterator();
		//Iterator : 해쉬셋을 이용해서 안에 있는걸 봅아온..다?
		System.out.println("STUDENTS LIST STARTS ------------------");
		
		while(iterator.hasNext()) {
			String key = iterator.next();
			Member member  = allMember.get(key);
			System.out.println("sNum : "+ member.getmNum() + "/t");
			System.out.println("| sId : "+ member.getmId() + "/t");
			System.out.println("| sPw : "+ member.getmPw() + "/t");
			System.out.println("| sName : "+ member.getmTel() + "/t");
			System.out.println("| sAge : "+ member.getmEmail() + "/t");
			System.out.println("| sGender : "+ member.getrDate() + "/t");
			System.out.println("| sMajor : "+ member.getuDate() + "/t");
		}
		System.out.println("END ------------------------------------");
	}

}
