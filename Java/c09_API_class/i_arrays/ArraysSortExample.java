package Java.c09_API_class.i_arrays;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysSortExample {
	
	public static void main(String[] args) {
		int[] scores = {100,99,98,60,97};
		
		// Arrays.sort() 오름차순
		Arrays.sort(scores, 2, 4); // 인덱스 2 <= x < 4 안에서만 정렬
		System.out.println(Arrays.toString(scores));
		Arrays.sort(scores);
		System.out.println(Arrays.toString(scores));
		
		String[] names = {"김유신", "이황", "이이", "세종대왕", "왕건"};
		System.out.println(Arrays.toString(names));
		Arrays.sort(names);
		System.out.println(Arrays.toString(names));
		
		// 역순 정렬 내림차순
		Arrays.sort(names, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		System.out.println(Arrays.toString(names));
		
		// fill - 1<= x <3 인덱스 매개변수로 전달된 문자로 채우기
		Arrays.fill(names, 1,3,"김규민");
		System.out.println(Arrays.toString(names));
		// 모든 항목을 null로 채우기
		Arrays.fill(names, null);
		System.out.println(Arrays.toString(names));
	}
}
