package ch04_pjt_02_quiz.ems;

import org.springframework.context.support.GenericXmlApplicationContext;

import ch04_pjt_02_quiz.ems.member.Member;
import ch04_pjt_02_quiz.ems.member.service.MemberDeleteService;
import ch04_pjt_02_quiz.ems.member.service.MemberModifyService;
import ch04_pjt_02_quiz.ems.member.service.NewMemberRegisterService;
import ch04_pjt_02_quiz.ems.member.service.PrintMemberInformationService;
import ch04_pjt_02_quiz.ems.member.service.SelectedMemberService;
import ch04_pjt_02_quiz.ems.utils.InitSampleData;


public class MainClass {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		InitSampleData initSampleData = ctx.getBean("initSampleData", InitSampleData.class);
		String[] mNums = initSampleData.getmNums();
		String[] mIds = initSampleData.getmIds();
		String[] mPws = initSampleData.getmPws();
		String[] mTels = initSampleData.getmTels();
		String[] mEmails = initSampleData.getmEmails();
		String[] rDates = initSampleData.getrDates();
		String[] uDates = initSampleData.getuDates();

		NewMemberRegisterService registerService = ctx.getBean("newMemberRegisterService", NewMemberRegisterService.class);

		for (int i = 0; i < mNums.length; i++) {
			registerService.register(new Member(mNums[i], mIds[i], mPws[i], mTels[i], mEmails[i], rDates[i], uDates[i]));
		}

		PrintMemberInformationService printMemberInformationService = ctx.getBean("printMemberInformationService",
				PrintMemberInformationService.class);

		printMemberInformationService.printMembersInfo();

		registerService = ctx.getBean("newMemberRegisterService", NewMemberRegisterService.class);
		registerService.register(new Member("M0001", "ID01", "password01", "010-1111-1111", "email1@email.com", "2023-01-01", "2023-01-18"));

		printMemberInformationService.printMembersInfo();

		SelectedMemberService selectedMemberInquire = ctx.getBean("selectedMemberInquire", SelectedMemberService.class);
		Member selectedMember = selectedMemberInquire.select("hbs006");

		System.out.println("STUDENT START ---------------------");
		System.out.println("sNum : " + selectedMember.getmNum() + "/t");
		System.out.println("| sId : " + selectedMember.getmId() + "/t");
		System.out.println("| sPw : " + selectedMember.getmPw() + "/t");
		System.out.println("| sName : " + selectedMember.getmTel() + "/t");
		System.out.println("| sAge : " + selectedMember.getmEmail() + "/t");
		System.out.println("| sGender : " + selectedMember.getrDate() + "/t");
		System.out.println("| sMajor : " + selectedMember.getuDate() + "/t");

		MemberModifyService modifyService = ctx.getBean("memberModifyService", MemberModifyService.class);
		modifyService.modify(new Member("M0001", "ID01", "password011", "010-1234-5678", "email1@gmail.com", "2023-01-01", "2023-01-28"));

		MemberDeleteService deleteService = ctx.getBean("memberDeleteService", MemberDeleteService.class);
		printMemberInformationService.printMembersInfo();

//		EMSInformationService emsInformationService = ctx.getBean("EMSInformationService", EMSInformationService.class);
//		emsInformationService.printEMSInformation();

		ctx.close();
		
	}

}
