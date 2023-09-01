package ch03_pjt_03_exercise2;

import java.util.Scanner;

public class Assembler {
	GreetingPrinter gp;
	Korea kr;
	English en;
	
	// 생성자를 받음
	// 여기서 생성자가 하는ㄴ일은 변수를 가진상태에서? 매개변수를 전달받음?
	public Assembler(GreetingPrinter gp, Korea kr, English en) {
		this.gp = gp;
		this.kr = kr;
		this.en = en;
	}
	
	public void print() {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    
	    if(n == 1) {
	      gp.printer(kr);
	    }else {
	      gp.printer(en);
	    }
	    
	    sc.close();
	  }
}


