package Java.c03_type_cast_arry.array;

import java.util.Scanner;

public class StudentManagementTest {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean isRun = true;
		
		int[] scores = null;
		
		Loop1 :
		while(isRun) {
			System.out.println("========================================");
			System.out.println("1.학생수|2.점수입력|3.학생개인점수|4.분석|5.종료");
			System.out.println("========================================");
			System.out.print("선택하실 기능의 번호를 입력하세요 > ");
			
			int selectNo = sc.nextInt();
			System.out.println("선택하신 번호는 : " + selectNo);
			/*
				1. 학생 수를 입력 -> 입력받은 학생 수만큼의 점수를 저장할 배열 생성
				2. scores 배열의 크기만큼(학생 수) 점수를 입력받아 각 항목에 저장
				3. scores 배열에 저장된 학생들의 점수를 하나씩 출력
				4. 분석 - scores 배열에 저장된 점수의 전체총점, 평균점수, 최고점수, 최저점수 출력
				5. 프로그램 종료
			 */
			switch (selectNo) {
				case 1 :
					System.out.println("학생 수");
					System.out.println("========================================");
					System.out.print("학생 수를 입력하세요 > ");
					int stuNums = sc.nextInt();
					scores = new int[stuNums];
					break;
				case 2 :
					System.out.println("점수 입력");
					System.out.println("========================================");
					for (int i = 0; i<scores.length;i++) {
						System.out.print("학생"+(i+1)+"의 점수를 입력하세요. > ");
						scores[i] = sc.nextInt();
					}
					break;
				case 3 :
					System.out.println("학생 개인 점수");
					System.out.println("========================================");
					for (int i = 0; i<scores.length;i++) {
						System.out.println("학생 "+(i+1)+"의 점수 : "+scores[i]);
					}
					break;
				case 4 :
					System.out.println("분석");
					System.out.println("========================================");
					
					int totalScore = 0;
					for (int score : scores) {
						totalScore += score;
					}
					System.out.println("전체 총점 : "+totalScore);
					
					double meanScore = (double)totalScore/scores.length;
					System.out.println("평균 점수 : "+meanScore);
					
					int topScore = 0;
					for (int score : scores) {
						if (score >= topScore) {
							topScore = score;
						}
					}
					System.out.println("최고 점수 : "+topScore);
					
					int lowScore = 100;
					for (int score : scores) {
						if (score <= lowScore) {
							lowScore = score;
						}
					}
					System.out.println("최저 점수 : "+lowScore);
					break;
				case 5 :
					System.out.println("종료");
					System.out.println("========================================");
					break Loop1;
				default :
					System.out.println("다시 입력해주세요.");
					
			}
		} // end while
		System.out.println("프로그램 종료");
	}// end main
}
