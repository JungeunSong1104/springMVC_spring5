package ch04_pjt_01.ems.member.dao;

import java.util.HashMap;
import java.util.Map;

import ch04_pjt_01.ems.member.Student;

public class StudentDAO {
	private Map<String, Student> studentDB = new HashMap<String, Student>();
	
	/*얘넨 직접 db에 접근하는게 아니고 map클래스를만들어서*/
	public void insert(Student student) {
		studentDB.put(student.getsNum(), student);
	}
	public Student select(String sNum) {
		return studentDB.get(sNum);
	}
	public void update (Student student) {
		studentDB.put(student.getsNum(), student);
	}
	public void delete(String sNum) {
		studentDB.remove(sNum);
	}
	public Map<String, Student> getStudentDB(){
		return studentDB;
	}
	
}
