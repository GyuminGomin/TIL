package Java.c09_API_class.i_arrays;

import java.util.Arrays;

public class ArraysCopyExample {
	
	public static void main(String[] args) {
		// 학생 한명이 늘어났다고 가정 (배열은 크기가 변경되지 않으므로)
		int[] scores = {100, 60, 70, 80, 90};
		System.out.println(Arrays.toString(scores));
		int[] scores2 = new int[scores.length + 1];
		for (int i =0; i<scores.length; i++) {
			scores2[i] = scores[i];
		}
		System.out.println(Arrays.toString(scores2));
		
		char[] arr1 = {'J','A','V','A'};
		System.out.println(Arrays.toString(arr1));
		
		// Arrays.copyOf(원본 배열, 복사할 길이)
		char[] arr2 = Arrays.copyOf(arr1, 5);
		System.out.println(Arrays.toString(arr2));
		char[] arr3 = Arrays.copyOf(arr1, arr1.length + 1);
		System.out.println(Arrays.toString(arr3));
		char[] arr4 = Arrays.copyOf(arr1, arr1.length - 1);
		System.out.println(Arrays.toString(arr4));
		
		// Arrays.copyOfRange(원본배열, 시작인덱스, 마지막인덱스-1)
		char[] arr5 = Arrays.copyOfRange(arr1, 1, 3);
		System.out.println(Arrays.toString(arr5));
		
		// System.arraycopy(원본배열, 시작인덱스, 복제배열, 시작인덱스, 복사할길이)
		char[] arr6 = new char[arr1.length+1]; // 복제할 배열이 존재해야함
		System.arraycopy(arr1, 0, arr6, 0, arr1.length);
		System.out.println(Arrays.toString(arr6));
		arr6 = new char[arr1.length+1];
		System.arraycopy(arr1, 0, arr6, 1, arr1.length);
		System.out.println(Arrays.toString(arr6));
	}
}