package ch03_pjt_03;

public class MyCalculator {
	public void calculate(int fNum, int sNum, ICalculator calculator) {
		int value = calculator.doOperation(fNum, sNum);
		//doOperation을 이용해서 연산실행
		System.out.println("result : " + value);
		//calculator 이 메소드는 필요할 때 ICalculator라는 인터페이스르 매개변수로 받기 때문에
	}
}
