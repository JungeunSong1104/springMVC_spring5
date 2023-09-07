package ch06_pjt_01.ems.configuration;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch06_pjt_01.ems.member.dao.StudentDAO;
import ch06_pjt_01.ems.member.service.PrintStudentInformationService;
import ch06_pjt_01.ems.member.service.StudentAllSelectService;
import ch06_pjt_01.ems.member.service.StudentDeleteService;
import ch06_pjt_01.ems.member.service.StudentModifyService;
import ch06_pjt_01.ems.member.service.StudentRegisterService;
import ch06_pjt_01.ems.member.service.StudentSelectService;
import ch06_pjt_01.ems.utils.InitSampleData;

@Configuration // @Configuration거 달아주면 이 자바파일 자체를 스프링에 대한 설정파일로 인식하기시작
public class MemberConfig1 {// xml파일내용을 xml을 이용하지않고 전부 자바파일로 만들어서 아노테이션이용하기
//xml에서는 주로 빈을 만듦

	@Bean // 밑에는 빈을 정의해주는 자바메서드를 만들어줌
	public StudentDAO studentDAO() {
		return new StudentDAO();// 리턴하는 객체가 실질적인 빈 이라고 생각하면됨
		// StudentDAO를 빈으로 설정하고 싶으면 임포트해줘야함
	}

	@Bean
	public StudentRegisterService studentRegisterService() {
		return new StudentRegisterService(studentDAO());
	}
	
	@Bean
	public StudentModifyService studentModifyService() {

		return new StudentModifyService(studentDAO());
	}

	@Bean
	public StudentDeleteService studentDeleteService() {
		return new StudentDeleteService(studentDAO());
	}

	@Bean
	public StudentSelectService studentSelectService() {
		return new StudentSelectService(studentDAO());
	}

	@Bean
	public StudentAllSelectService studentAllSelectService() {
		return new StudentAllSelectService(studentDAO());
	}

	@Bean
	public PrintStudentInformationService printStudentInformationService() {
		return new PrintStudentInformationService(studentAllSelectService());
	}
	//하나의 xml파일에 모든 빈객체를 넣는건 지양 기능단위로 분리하는 게 좋음
	//자바로 컨피그파일 제작할때도 xml처럼 마찬가지로 파일을 분리할수있음

	@Bean
	public InitSampleData initSampleData() {
		InitSampleData initSampleData = new InitSampleData();

		String[] sNums = { "hbs001", "hbs002", "hbs003", "hbs004", "hbs005" };
		initSampleData.setsNums(sNums);

		String[] sIds = { "rabbit", "hippo", "raccoon", "elephant", "lion" };
		initSampleData.setsIds(sIds);

		String[] sPws = { "P000T", "P0002", "p0003", "p00Q4", "p00O5" };
		initSampleData.setsPws(sPws);

		String[] sNames = { "agatha", "barbara", "chris", "doris", "elva" };
		initSampleData.setsNames(sNames);

		int[] sAges = { 19, 22, 20, 27, 19 };
		initSampleData.setsAges(sAges);

		char[] sGenders = { 'M', 'W', 'W', 'M', 'M' };
		initSampleData.setsGenders(sGenders);

		String[] sMajors = { "English", "Korean", "French", "Philosophy", "History" };
		initSampleData.setsMajors(sMajors);

		return initSampleData;
	}

	
}
