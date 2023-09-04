package ch04_pjt_01.ems.member.service;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import ch04_pjt_01.ems.member.Student;

public class PrintStudentInformationService {
	StudentAllSelectService allSelectService;
	
	public PrintStudentInformationService(StudentAllSelectService allSelectService) {
		this.allSelectService  = allSelectService;
	}
	
	public void printStudentsInfo() {
		Map<String, Student> allStudent = allSelectService.allSelect();
		Set<String> keys = allStudent.keySet();//hashset으로 바꿔서 학생 정보를 나열
		Iterator<String> iterator = keys.iterator();
		//Iterator : 해쉬셋을 이용해서 안에 있는걸 봅아온..다?
		System.out.println("STUDENTS LIST STARTS ------------------");
		
		while(iterator.hasNext()) {
			String key = iterator.next();
			Student student  = allStudent.get(key);
			System.out.println("sNum : "+ student.getsNum() + "/t");
			System.out.println("| sId : "+ student.getsId() + "/t");
			System.out.println("| sPw : "+ student.getsPw() + "/t");
			System.out.println("| sName : "+ student.getsName() + "/t");
			System.out.println("| sAge : "+ student.getsAge() + "/t");
			System.out.println("| sGender : "+ student.getsGender() + "/t");
			System.out.println("| sMajor : "+ student.getsMajor() + "/t");
		}
		System.out.println("END ------------------------------------");
	}
	
}
