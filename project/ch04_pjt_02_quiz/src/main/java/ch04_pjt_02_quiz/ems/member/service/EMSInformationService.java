package ch04_pjt_02_quiz.ems.member.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class EMSInformationService {
	private String info;
	private String copyRight;
	private String ver;
	private int sYear;
	private int sMonth;
	private int sDay;
	private int eYear;
	private int eMonth;
	private int eDay;
	private List<String> developers;
	private Map<String, String> administrators;
	private Map<String, DBConnectionInfo> dbInfos;
	
	public void printEMSInformation() {
		System.out.println("EMS INFORMATION PRINTING STARTS ------------------");
		String devPeriod = sYear + "/" + sMonth + "/" + sDay + "~" +
		eYear + "/" + eMonth + "/" + eDay;
		System.out.println(info +"(" + devPeriod + ")");
		System.out.println(copyRight);
		System.out.println(ver);
		System.out.println("Developers : "+ developers);
		System.out.println("Administrator : " + administrators);
		printDBInfo();
		System.out.println("END -----------------------------------");
	}
	
	private void printDBInfo() {
		Set<String> keys  = dbInfos.keySet();
		Iterator<String> iterator = keys.iterator();
		
		while(iterator.hasNext()) {
			String key = iterator.next();
			DBConnectionInfo info = dbInfos.get(key);
			System.out.println("["+key+"DB]");
			System.out.println("url : "+info.getUrl()+"\t");
			System.out.println("userId : "+ info.getUserId()+"\t");
			System.out.println("userPw : "+ info.getUserPw()+"\t");
		}
	}
}
