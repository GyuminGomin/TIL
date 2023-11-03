package Java.c02_operators.conditional_statement;

import java.util.Scanner;

public class If_SwitchExample {
    public static void main(String[] args) {
		// Ctrl + Shift + o -> 빨간줄 있는 객체 자동 임포트
		Scanner sc = new Scanner(System.in);
		/*
		 	사용자에게 점수를 입력해 주세요 > 
		 	라고 출력한 뒤 정수값을 입력받는다.
		 	변수 선언 및 정수값 입력
		 	
		 	90 ~ 100 점은 "A"
		 	80 ~ 89 점은 "B"
		 	70 ~ 79 점은 "C"
		 	60 ~ 69 점은 "D"
		 	0 ~ 100점이 아니거나 59점 이하면 나머지는 "F"
		 	출력
		 */
		
		System.out.print("점수를 입력해 주세요. : ");
		boolean eq = sc.hasNextInt();
		if (eq == true) {
			int score = sc.nextInt();
			if (score >= 90 && score <= 100) {
				System.out.println("A");
			} else if (score >=80 && score < 90) {
				System.out.println("B");
			} else if (score >=70 && score < 80) {
				System.out.println("C");
			} else if (score >=60 && score < 70) {
				System.out.println("D");
			} else {
				System.out.println("F");
			}
			

			switch (score / 10) {
				case 10 : case 9 :
					System.out.println("A");
					break;
				case 8 :
					System.out.println("B");
					break;
				case 7 :
					System.out.println("C");
					break;
				case 6 :
					System.out.println("D");
					break;
				default :
					System.out.println("F");
			}
		} else {
			System.out.println("다시 입력해 주세요.");
		}
		
		char c = '@'; //64
		System.out.print("한 개의 문자를 입력해 주세요. > ");
		c = sc.next().charAt(0);
		switch(c) {
			case 64 :
				System.out.println("64 : " + c);
				break;
			case 'A' :
				System.out.println("65 : " + c);
				break;
			case 'B' :
				System.out.println("66 : " + c);
				break;
			default :
				System.out.println("만족 하는 녀석이 없습니다." + c);
		}
		
		String rank = "Gold";
		switch(rank) {
			case "Gold" :
				System.out.println("금메달 입니다.");
				break;
			case "Silver" :
				System.out.println("은메달 입니다.");
				break;
			case "Bronze" :
				System.out.println("동메달 입니다.");
				break;
			default :
				System.out.println("획득한 메달이 없습니다.");
		}
}
