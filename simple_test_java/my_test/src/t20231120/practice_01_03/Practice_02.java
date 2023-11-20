package practice_01_03;


public class Practice_02 {

	public static void main(String[] args) {

		int[] lotto = new int[6];
		int count = 0; // 몇번 반복하는지 확인

		// 코드 수정 및 작성 - 같은 값 비교
		for (int i=0; i<lotto.length; i++) {
			count += 1;
			int number = (int) (Math.random() * 45 + 1);
			if (i==0) { // 첫번째는 그냥 대입
				lotto[i] = number;
			} else { // 두번째 부터는 값 비교
				for (int j=0; j<i; j++) {
					if (lotto[j] == number) {
						i--; // 값이 같은 것이 있으면 다시 시작
						break;
					} else {
						lotto[i] = number;
					}
				}
			}
		}
		// 오름차순 정렬 -> 가장 낮은 값을 왼쪽에 두는 정렬
		for (int i=0; i<lotto.length; i++) {
			for (int j=i+1; j<lotto.length; j++) {
				if (lotto[i] > lotto[j]) {
					int temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		}
		
		// 결과 출력 코드 수정 x
		System.out.println("[ 결과 ]");
		System.out.println("count : " + count);
		for (int i : lotto) {
			System.out.print("[" +i+ "]");
		}
	}
}
