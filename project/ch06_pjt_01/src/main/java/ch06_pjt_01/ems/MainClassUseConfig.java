package ch06_pjt_01.ems;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import ch06_pjt_01.ems.configuration.MemberConfig;
import ch06_pjt_01.ems.configuration.MemberConfig1;
import ch06_pjt_01.ems.configuration.MemberConfig2;
import ch06_pjt_01.ems.configuration.MemberConfig3;
import ch06_pjt_01.ems.configuration.MemberConfigImport;
import ch06_pjt_01.ems.member.Student;
import ch06_pjt_01.ems.member.service.EMSInformationService;
import ch06_pjt_01.ems.member.service.PrintStudentInformationService;
import ch06_pjt_01.ems.member.service.StudentDeleteService;
import ch06_pjt_01.ems.member.service.StudentModifyService;
import ch06_pjt_01.ems.member.service.StudentRegisterService;
import ch06_pjt_01.ems.member.service.StudentSelectService;
import ch06_pjt_01.ems.utils.InitSampleData;

public class MainClassUseConfig {

	public static void main(String[] args) {

		String[] appCtxs = { "classpath:appCtx1.xml", "classpath:appCtx2.xml", "classpath:appCtx3.xml" };
		// GenericXmlApplicationContext ctx = new
		// GenericXmlApplicationContext("classpath:appCtx1.xml",
		// "classpath:appCtx2.xml", "classpath:appCtx3.xml");
		// 3개의 파일을 읽어올수있도록 분리해주자 => "classpath:appCtx1.xml", "classpath:appCtx2.xml",
		// "classpath:appCtx3.xml"
		// 하지만 이렇게 클래스패스가 늘어날수록 가독성이 떨어지니까 배열로 만들어줌
		// 만든 배열을 호출해주기만하면됨 => new GenericXmlApplicationContext(appCtxs);
		// 또 다른 방법 : 클래스에서 작성하는게 아니고 xml 파일이 서로 import하게하면됨
		//appCtxImport xml 파일 생성해줌
		//GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(appCtxs);
		
		AnnotationConfigApplicationContext ctx = 
				//new AnnotationConfigApplicationContext(MemberConfig1.class, MemberConfig2.class, MemberConfig3.class);
				new AnnotationConfigApplicationContext(MemberConfigImport.class);

		// 샘플데이터만들어주자
		InitSampleData initSampleData = ctx.getBean("initSampleData", InitSampleData.class);
		String[] sNums = initSampleData.getsNums();
		String[] sIds = initSampleData.getsIds();
		String[] sPws = initSampleData.getsPws();
		String[] sNames = initSampleData.getsNames();
		int[] sAges = initSampleData.getsAges();
		char[] sGenders = initSampleData.getsGenders();
		String[] sMajors = initSampleData.getsMajors();

		StudentRegisterService registerService = ctx.getBean("studentRegisterService", StudentRegisterService.class);

		for (int i = 0; i < sNums.length; i++) {
			registerService.register(new Student(sNums[i], sIds[i], sPws[i], sNames[i], sAges[i], sGenders[i], sMajors[i]));
		}

		PrintStudentInformationService printStudentInformationService = ctx.getBean("printStudentInformationService",
				PrintStudentInformationService.class);

		printStudentInformationService.printStudentsInfo();

		registerService = ctx.getBean("studentRegisterService", StudentRegisterService.class);
		registerService.register(new Student("hbs006", "deer", "p0006", "mellisa", 26, 'w', "Music"));

		printStudentInformationService.printStudentsInfo();

		StudentSelectService selectService = ctx.getBean("studentSelectService", StudentSelectService.class);
		Student selectedStudent = selectService.select("hbs006");

		System.out.println("STUDENT START ---------------------");
		System.out.println("sNum : " + selectedStudent.getsNum() + "/t");
		System.out.println("| sId : " + selectedStudent.getsId() + "/t");
		System.out.println("| sPw : " + selectedStudent.getsPw() + "/t");
		System.out.println("| sName : " + selectedStudent.getsName() + "/t");
		System.out.println("| sAge : " + selectedStudent.getsAge() + "/t");
		System.out.println("| sGender : " + selectedStudent.getsGender() + "/t");
		System.out.println("| sMajor : " + selectedStudent.getsMajor() + "/t");

		StudentModifyService modifyService = ctx.getBean("studentModifyService", StudentModifyService.class);
		modifyService.modify(new Student("hb006", "pig", "p0066", "mellisa", 27, 'w', "Computer"));

		StudentDeleteService deleteService = ctx.getBean("studentDeleteService", StudentDeleteService.class);
		printStudentInformationService.printStudentsInfo();

		EMSInformationService emsInformationService =
		        ctx.getBean("emsInformationService", EMSInformationService.class);
		    emsInformationService.printEMSInformation();

		ctx.close();

	}

}
