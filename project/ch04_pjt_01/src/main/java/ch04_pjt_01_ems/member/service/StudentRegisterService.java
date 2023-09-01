package ch04_pjt_01_ems.member.service;

import ch04_pjt_01_ems.member.Student;
import ch04_pjt_01_ems.member.dao.StudentDAO;

public class StudentRegisterService {
	private StudentDAO studentDao;
	
	public StudentRegisterService(StudentDAO studentDao) {
	//StudentDAO를 받아오는 주체는 스프링 스프링이 해줌
		this.studentDao = studentDao;
	}
	
	public void register(Student student) {
	/* 학생등록하는 메서드가 실행될때 학생객체를 매개변수로 받고 매개변수로 받은 객체를 
	등록하기전에 학생객체가 가진 학번을 가지고 기존의 객체와 비교를 하는데 사용 */
		if(verify(student.getsNum())) {
			studentDao.insert(student);
		}else {
			System.out.println("The student has already been registered");
		}
	}
	
	public boolean verify(String sNum) {
		Student student = studentDao.select(sNum);
		return student == null ? true : false;
	}
}
