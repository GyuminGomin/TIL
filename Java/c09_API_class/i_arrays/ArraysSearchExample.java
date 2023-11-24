package Java.c09_API_class.i_arrays;

import java.util.Arrays;

public class ArraysSearchExample {

	public static void main(String[] args) {
		// search - 지정된 값이 배열의 몇번째 index에 존재하는지 검색
		int[] scores = {1, 10, 5, 7, 9};
		//				0  1   2  3  4
		//				-1 -2 -3 -4 -5 -6
		// 비교할 대상을 양분하여 검색해서 찾을 수 없으면, 음수를 반환하는데 찾은 위치를 반환 
		int index = Arrays.binarySearch(scores, 10); // 이진 탐색 트리
		System.out.println("찾은 인덱스 : " + index); // -6 -> 2 찾고, 2+4/2=3 찾고, 2+4+3/2=4 찾고, 9보다 더 큰 값이므로 -6을 반환
		index = Arrays.binarySearch(scores, 8);
		System.out.println("찾은 인덱스 : " + index); // -5
		
		Arrays.sort(scores); // 오름차순으로 정렬이 되어있어야 값을 찾을 수 있음
		index = Arrays.binarySearch(scores, 10); // 이진 탐색 트리
		System.out.println("찾은 인덱스 : " + index); // 4
		index = Arrays.binarySearch(scores, 8);
		System.out.println("찾은 인덱스 : " + index); // -4
	}
}
