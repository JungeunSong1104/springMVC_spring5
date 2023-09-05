package ch04_pjt_02_quiz.ems.member.service;

import ch04_pjt_02_quiz.ems.member.Member;
import ch04_pjt_02_quiz.ems.member.dao.MemberDAO;

public class NewMemberRegisterService {
	private MemberDAO memberDao;

	public NewMemberRegisterService(MemberDAO memberDao) {
	//StudentDAO를 받아오는 주체는 스프링 스프링이 해줌
		this.memberDao = memberDao;
	}

	public void register(Member member) {
		/*
		 * 학생등록하는 메서드가 실행될때 학생객체를 매개변수로 받고 매개변수로 받은 객체를 등록하기전에 학생객체가 가진 학번을 가지고 기존의 객체와
		 * 비교를 하는데 사용
		 */
		if (verify(member.getmNum())) {
			memberDao.insert(member);
		} else {
			System.out.println("The student has already been registered");
		}
	}

	public boolean verify(String mNum) {
		Member student = memberDao.select(mNum);
		return student == null ? true : false;
	}

}
