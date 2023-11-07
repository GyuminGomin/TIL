package Java.c03_type_cast_arry.array;

public class ArrayRefExample {
    public static void main(String[] args) {
		int[] scores = {70,60,50,40,60,60};
		
		int[] scores2 = scores;
		scores[0] = 80;
		System.out.println(scores2[0]);
		// 주소값을 scores2에 저장
		
		int a = 10;
		int b = a;
		a = 20;
		System.out.println(b);
		// 값을 저장하므로 영향이 없음
		
		char chars[] = new char[26];
		char c = 'A';
		for (int i = 0;i<chars.length;i++, c++) {
			chars[i] = c;
		}
		
		for (int i=0;i<chars.length;i++) {
			System.out.print(chars[i]+" ");
		}
		System.out.println("");
		
		// 향상된 for문
		for(char ch : chars) {
			System.out.print("["+ch+"]");
		}
		System.out.println("");
		
		// String 예시
		String[] strs = new String[3];
		strs[1] = "java";
		for(String s : strs) {
			System.out.println(s);
		}
		System.out.println(strs);
		
		// 2차원 배열
		int[] arrays[] = new int[3][];
		// [null] [null] [null] -> null 안에 배열이 들어가는 것
		arrays[0] = new int[4];
		arrays[1] = new int[3];
		arrays[2] = new int[3];
		int num = arrays[0][0];
		/*
			arrays[0] - [] [] [] []
			arrays[1] - [] [] []
			arrays[2] - [] [] []
 		*/
		
		int[][] arrays2 = new int[2][3];
		/*
			arrays2[0] - [] [] []
			arrays2[1] - [] [] []
		 */
		int arrays3[][] = new int[3][2];
		/*
			arrays3[0] - [] []
			arrays3[1] - [] []
			arrays2[2] - [] []
		 */
		
		int[][] scoresArrays = new int[][] {
			{10,20,30},
			{70,80,90,100}
		};
		
		for(int i=0; i<scoresArrays.length;i++) {
			for (int j=0; j<scoresArrays[i].length;j++) {
				System.out.print(scoresArrays[i][j] + " ");
			}
			System.out.println(" ");
		}
		
		for(int[] scoresArray : scoresArrays) {
			for(int score : scoresArray) {
				System.out.print(score+ " ");
			}
			System.out.println(" ");
		}
		
	}
}
