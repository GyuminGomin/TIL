package practice_01_03;


public class Practice_03 {

	public static void main(String[] args) {
		// code 작성
		int[] array = new int[10];

		// 값 삽입
		for (int i=0; i<array.length;i++) {
			int number = (int)(Math.random()*100) + 1;
			array[i] = number;
		}


		System.out.print("최초의 리스트 : ");
		for (int i : array) {
			System.out.print(i+ " ");
		}

		System.out.println();
		// 내림차순 정렬
		for (int i=0; i<array.length;i++) {
			for (int j=i+1; j<array.length; j++) {
				if (array[i] < array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		
		System.out.print("정렬된 리스트 : ");
		for (int i : array) {
			System.out.print(i+ " ");
		}

	}
}
