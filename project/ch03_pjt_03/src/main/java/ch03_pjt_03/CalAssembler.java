package ch03_pjt_03;

public class CalAssembler {
	MyCalculator calculator;
	CalAdd calAdd;
	CalSub calSub;
	CalMul calMul;
	CalDiv calDiv;
	
	public CalAssembler(MyCalculator calculator, CalAdd calAdd, CalSub calSub, CalMul calMul, CalDiv calDiv) {
		this.calculator = calculator;
		this.calAdd = calAdd;
		this.calSub = calSub;
		this.calMul = calMul;
		this.calDiv = calDiv;
		//생성자를 이용해서 CalAssembler객체가 생길때 매개변수로 MyCalculator, 칼애드 등등을 매개변수로 받게 설정해둠
		//자기자신이 받게해둠
	}
	
	public void assemble() {
		calculator.calculate(10, 5, calAdd);
		calculator.calculate(10, 5, calSub);
		calculator.calculate(10, 5, calMul);
		calculator.calculate(10, 5, calDiv);
	}
}
