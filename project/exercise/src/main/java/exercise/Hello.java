package exercise;

import java.util.Scanner;



public class Hello {

	public void sayHello() {
		System.out.println("Hello maven procject");
	}

	public void selectHello() {
		System.out.println("Select language 1. korea 2. english");
		Scanner sc = new Scanner(System.in);
		int selectedNum = sc.nextInt();if(selectedNum==1)
		{
			System.out.println("안녕하세요");
		}else
		{
			System.out.println("Hello");
		}
		sc.close();
	}
}
