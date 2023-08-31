package ch02_pjt_01;

public class CalAdd implements ICalculator{
//implements를 이용해서 ICalculator 인터페이스 구현중
//CalAdd(모든 Cal클래스들) doOperation을 구현해주고있음
//같은 이름의 메서드를 다르게구현중?
//실제로 할당되는 클래스 같은경우 전부 다른애 클래스를 할당해주고있음
//CalAdd(다른클래스들) 각각 메소드에 있는 칼큐레이터는 전부 다른애들
	@Override
	public int doOperation(int firstNum, int secondNum) {
		return firstNum + secondNum;
	}
}
