package ch05_pjt_01.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class AutoWiredEx {
	@Autowired
	public AutoWiredEx(@Qualifier("usedBean") FirstBean fBean, SecondBean sbean){//생성자 생성
		System.out.println("fBean : "+fBean);
		System.out.println("sbean : "+sbean);
	}
	
	@Autowired
	public void autoWiredMethod(ThirdBean tbean, @Qualifier("usedBean") FourthBean fBean) {
		System.out.println("tBean : "+tbean);
		System.out.println("fBean : "+fBean);
	}
}
