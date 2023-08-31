package ch02_pjt_01;

public class MainClass {

	public static void main(String[] args) {
		MyCalculator calculator = new MyCalculator();
		//메개변수 두개씩 전달중 하짐나 수정한 마칼클은 매개변수 세개받고 있으니까 수정해줘야함
		/* 여기서 생성자 생성해줌? */
//		calculator.calAdd(10,5, new CalAdd());
//		calculator.calSub(10,5, new CalSub());
//		calculator.calMul(10,5, new CalMul());
//		calculator.calDiv(10,5, new CalDiv());
		
		//이렇게 수정해줌
		calculator.calculate(10,5, new CalAdd());
		calculator.calculate(10,5, new CalSub());
		calculator.calculate(10,5, new CalMul());
		calculator.calculate(10,5, new CalDiv());
		
		
		
		
	}
}
