package Java.c03_type_cast_arry.array;

import java.util.Scanner;

/*
 * 1등이 6개 일치
 * 2등이 5개 일치 + bonus 숫자 일치
 * 3등이 5개 일치
 * 4등이 4개 일치
 * 5등이 3개 일치
 */

public class LottoExample {

	public static void main(String[] args) {
		// 당첨 변호를 저장할 배열
		int[] lotto = new int[6];
		for(int i=0;i<lotto.length;i++) {
			lotto[i] = (int)(Math.random() *45)+1;
			for(int j=0; j<i;j++) {
				if(lotto[i] == lotto[j]) {
					i--;
					break; // 내부 반복문 제거
				}
			}
		}
		
		// 정렬
		int temp = 0;
		for (int i=0; i<lotto.length;i++) {
			for(int j=i+1;j<lotto.length;j++) {
				if(lotto[i] > lotto[j]) {
					temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		}
		
		// 행운 번호
		int bonus =(int)(Math.random()*45) + 1;
		for(int i=0; i<lotto.length; i++) {
			if(bonus == lotto[i]) {
				bonus = (int)(Math.random()*45) + 1;
				// i의 값을 -1로 할당 하여 0번째 인덱스부터 다시 비교
				i = -1;
			}
		}
		// 내 로또 번호
		int[] myLotto = new int[6];
		boolean isRun = true;
		Scanner sc = new Scanner(System.in);
		
		while(isRun) {
			System.out.println("================================");
			System.out.println("1.로또구입|2.번호확인|3.당첨확인|4.종료");
			System.out.println("================================");
			System.out.println("선택할 항목의 번호를 입력하세요 > ");
			int selectNo = sc.nextInt();
			if(selectNo == 1) {
				a :
				for(int i = 0; i < myLotto.length; i++) {
					System.out.print((i+1)+"번째 번호 입력 > ");
					int num = sc.nextInt();
					if (num < 1 || num > 45) {
						System.out.println("1~45 까지의 번호만 입력");
						i--;
						continue;
					}
					
					// 중복 확인
					for(int j=0; j<i; j++) {
						if(num == myLotto[j]) {
							System.out.println("이미 등록된 번호입니다.");
							i--;
							continue a;
						}
					}
					
					myLotto[i] = num;
				}
			} else if(selectNo == 2) {
				System.out.println("번호 확인!");
				for (int i : myLotto) {
					System.out.print("["+i+"]");
				}
			} else if(selectNo == 3) {
				System.out.println("당첨 확인");
				System.out.print("당첨번호:");
				for (int i : lotto) {
					System.out.printf("[%d]", i);
				}
				System.out.println(" 보너스 번호 : ["+bonus+"]");
				System.out.print("나의번호:");
				for(int i : myLotto) {
					System.out.printf("[%d]",i);
				}
				System.out.println();
				
				// 일치하는 번호 개수 확인
				int cnt = 0; // 일치하는 번호의 개수를 저장할 변수
				boolean isBonus = false;
				for(int i=0; i<myLotto.length; i++) {
					for(int j=0; j<lotto.length;j++) {
						if(myLotto[i] == bonus) {
							isBonus = true;
						}
						if(myLotto[i] == lotto[j]) {
							cnt++;
						}
					}
				}
				System.out.println("일치하는 번호 개수는 :" + cnt);
				if(cnt == 6) {
					System.out.println("1등입니다.");
				} else if(cnt == 5) {
					if (isBonus == true) {
						System.out.println("2등");
					} else {
						System.out.println("3등");
					}
				} else if(cnt == 4) {
					System.out.println("4등");
				} else if(cnt == 3) {
					System.out.println("5등");
				} else {
					System.out.println("꽝");
				}
				
			} else {
				System.out.println("종료");
				isRun = false;
			}
		}
		
//		for (int i : lotto) {
//			System.out.print(i + " ");
//		}
//		System.out.println("");
	}

}
