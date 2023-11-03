package Java.c02_operators.iteration_statement;

import java.util.Scanner;

public class WhileExample {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean isRun = true;
		
		while(isRun) {
			System.out.println("구구단 단수를 정수로 입력 > ");
			isRun = sc.hasNextInt();
			if (isRun) {
				// 사용자에게 입력받은 데이터가 정수형 데이터 일 경우, Scanner에 저장된 정수값을 꺼내온다.
				int num = sc.nextInt();
				System.out.println(num+"단 ");
				
				for(int j=1; j<=9; j++) {
					System.out.println(num + " * " + j + " = " + (num*j));
				}
			}
			
//			sc.next();
		} // end while
		System.out.println("while 종료");
	} // end main
} // end class
