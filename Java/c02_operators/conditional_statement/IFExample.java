package Java.c02_operators.conditional_statement;

import java.util.Scanner;

public class IFExample {
    public static void main(String[] args) {
		int num1 = 10;
		int num2 = 20;
		
		if (true) {
			System.out.println("무조건 실행");
		}
		
		if (num1 < num2) {
			System.out.println("num1이 num2보다 작습니다.");
		} else if (num1 > num2) {
			System.out.println("num1이 num2보다 큽니다.");
		} else {
			System.out.println("num1이 num2와 같습니다.");
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수값을 입력해 주세요 > ");
		int a = sc.nextInt();
		System.out.println(a);
		System.out.print("단어를 입력해 주세요 > ");
		String str = sc.next(); // console을 통해 한단어를 입력받아 반환
		System.out.println(str);
		System.out.print("실수를 입력해 주세요 > ");
		double r = sc.nextDouble();
		System.out.println(r);
		System.out.print("실행 여부를 작성해 주세요! true or false > ");
		boolean isRun = sc.nextBoolean();
		System.out.println(isRun);
		
		System.out.println("boolean 타입으로 값을 입력받아 저장");
		System.out.println("저장된 타입으로 값이 입력되었는지 여부를 boolean타입으로 반환");
		isRun = sc.hasNextBoolean();
		/*
		 	Scanner.hasNextBoolean();
		 	Scanner.hasNextInt();
		 	Scanner.hasNextDouble();
		 	Scanner.hasNext();
		 */
		if (isRun) {
			System.out.println("boolean 타입의 값이 정상적으로 입력");
			boolean isResult = sc.nextBoolean();
			System.out.println(isResult);
		} else {
			System.out.println("boolean 타입의 값이 아닙니다.");
			String dummy = sc.next();
			System.out.println("wrong value : " + dummy);
		}
	}
}
