package ch02_pjt_01;

public interface ICalculator {//인터페이스는 해당 인터페이스를 임플리먼트 해주는 클래스들한테 어떤 메소드를 구현해야하는지 알려주는 역할
	
	public int doOperation(int firstNum, int secondNum);
}
