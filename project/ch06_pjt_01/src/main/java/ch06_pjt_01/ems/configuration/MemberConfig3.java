package ch06_pjt_01.ems.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch06_pjt_01.ems.member.DBConnectionInfo;
import ch06_pjt_01.ems.member.service.EMSInformationService;

@Configuration // @Configuration거 달아주면 이 자바파일 자체를 스프링에 대한 설정파일로 인식하기시작
public class MemberConfig3 {// xml파일내용을 xml을 이용하지않고 전부 자바파일로 만들어서 아노테이션이용하기
//xml에서는 주로 빈을 만듦

	  @Autowired
	  DBConnectionInfo dev_DBConnectionInfoDev;
	  
	  @Autowired
	  DBConnectionInfo real_DBConnectionInfo;
	
	
	
	@Bean
	public EMSInformationService emsInformationService() {
		EMSInformationService emsInformationService = new EMSInformationService();
		emsInformationService.setInfo("Education Management System program was developed in 2022.");
		emsInformationService.setCopyRight(
				"COPYRIGHT(C) 2022 EMS CO., LTD. ALL RIGHT RESERVED. CONTACT MASTER FOR MORE INFORMATION.");
		emsInformationService.setVer("The version is 1.0");
		emsInformationService.setsMonth(3);
		emsInformationService.setsMonth(1);
		emsInformationService.setsMonth(2022);
		emsInformationService.setsMonth(4);
		emsInformationService.setsMonth(30);

		List<String> developers = new ArrayList<String>();
		developers.add("Cheney.");
		developers.add("Eloy.");
		developers.add("Jasper.");
		developers.add("Dillon.");
		developers.add("Kian.");
		emsInformationService.setDevelopers(developers);

		Map<String, String> administrators = new HashMap<String, String>();
		administrators.put("Cheney", "cheney@springPjt.org");
		administrators.put("Jasper", "jasper@springPjt.org");
		emsInformationService.setAdministrators(administrators);

		Map<String, DBConnectionInfo> dbInfos = new HashMap<String, DBConnectionInfo>();
		dbInfos.put("dev", dev_DBConnectionInfoDev);//db관련정보는 2번에 몰아넣었기 때문에 현재 빨간줄뜸
		//메서드호출부분 수정해줌
		
		dbInfos.put("real", real_DBConnectionInfo);
		emsInformationService.setDbInfos(dbInfos);

		return emsInformationService;
	}
}
