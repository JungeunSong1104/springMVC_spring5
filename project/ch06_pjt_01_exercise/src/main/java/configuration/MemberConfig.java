package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch06_pjt_01_exercise.controller.MemberController;
import ch06_pjt_01_exercise.dao.MemberDAO;
import ch06_pjt_01_exercise.utils.InitSampleData;
import ch06_pjt_01_exercise.view.MemberViewer;

@Configuration
public class MemberConfig {
  
  @Bean
  public MemberDAO memberDAO() {
    return new MemberDAO();
  }
  
  @Bean
  public MemberViewer memberViewer() {
    return new MemberViewer();
  }
  
  @Bean
  public MemberController memberController() {
    MemberController memberController = new MemberController(memberDAO(), memberViewer());
    return memberController;
  }
  
  @Bean
  public InitSampleData initSampleData() {
    InitSampleData initSampleData = new InitSampleData();
    String[] ids = { "hbs001", "hbs002", "hbs003" };
    initSampleData.setIds(ids);

    String[] passwords = { "hbs001", "hbs002", "hbs003" };
    String[] contacts = { "hbs001", "hbs002", "hbs003" };
    String[] emails = { "hbs001", "hbs002", "hbs003" };
    String[] registeredDates = { "hbs001", "hbs002", "hbs003" };
    String[] modifiedDates = { "hbs001", "hbs002", "hbs003" };
    initSampleData.setPasswords(passwords);
    initSampleData.setContacts(contacts);
    initSampleData.setEmails(emails);
    initSampleData.setRegisteredDates(registeredDates);
    initSampleData.setModifiedDates(modifiedDates);

    return initSampleData;// 리턴을 해줘야 빈객체가 생김
  }

}