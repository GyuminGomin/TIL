package Java.c09_API_class.i_arrays;

import java.util.Arrays;

/*
 	java.util.Arrays (Utility Class)
 	배열을 쉽게 다룰 수 있도록 기능을 정의해놓은 class
*/
public class ArraysToStringExample {

	public static void main(String[] args) {
		int[] scores = {99,10,97,96,98};
		System.out.println(scores);
		for (int i : scores) {
			System.out.print(i +" ");
		}
		System.out.println();
		
		String result = Arrays.toString(scores);
		System.out.println(result);
	}
}
