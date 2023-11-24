package Java.c09_API_class.i_arrays;

import java.util.Arrays;

public class ArraysEqualsExample {

	public static void main(String[] args) {
		
		int[][] original = { {1,2}, {3,4} };
		int[][] copy = Arrays.copyOf(original, original.length);
		// 2차원 배열안의 Arrays.copyOf는 얕은 복제
		System.out.println("== 얕은 복제 ==");
		System.out.println(original.equals(copy)); // 객체가 아니므로 주소값을 비교
		original[0][0] = 10;
		System.out.println(Arrays.toString(original));
		System.out.println(Arrays.toString(original[0]));
		System.out.println(Arrays.toString(copy));
		System.out.println(Arrays.toString(copy[0]));
		System.out.println(Arrays.equals(original, copy)); // 배열안에 있는 항목을 비교
		
		System.out.println("== 깊은 복제 ==");
		copy[0] = Arrays.copyOf(original[0], original[0].length);
		copy[1] = Arrays.copyOf(original[1], original[1].length);
		System.out.println(Arrays.deepToString(original));
		System.out.println(Arrays.deepToString(copy));
		System.out.println(Arrays.deepEquals(original, copy));
		copy[0][1] = 30;
		System.out.println(Arrays.toString(original));
		System.out.println(Arrays.toString(copy));
		System.out.println(Arrays.deepToString(original));
		System.out.println(Arrays.deepToString(copy));
		System.out.println(Arrays.deepEquals(original, copy));
	}
}
