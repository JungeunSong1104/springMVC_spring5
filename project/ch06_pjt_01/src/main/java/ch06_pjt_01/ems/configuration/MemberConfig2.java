package ch06_pjt_01.ems.configuration;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch06_pjt_01.ems.member.DBConnectionInfo;

@Configuration // @Configuration거 달아주면 이 자바파일 자체를 스프링에 대한 설정파일로 인식하기시작
public class MemberConfig2 {// xml파일내용을 xml을 이용하지않고 전부 자바파일로 만들어서 아노테이션이용하기
//xml에서는 주로 빈을 만듦

	@Bean
	public DBConnectionInfo dev_DBConnectionInfoDev() {
		DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();
		dbConnectionInfo.setUrl("000.000.000.000");
		dbConnectionInfo.setUserId("admin");
		dbConnectionInfo.setUserPw("0000");

		return dbConnectionInfo;
	}

	@Bean
	public DBConnectionInfo real_DBConnectionInfo() {
		DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();
		dbConnectionInfo.setUrl("111.111.111.111");
		dbConnectionInfo.setUserId("master");
		dbConnectionInfo.setUserPw("1111");

		return dbConnectionInfo;
	}
}
