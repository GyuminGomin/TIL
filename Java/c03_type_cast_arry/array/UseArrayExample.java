package Java.c03_type_cast_arry.array;

/*
 * 자료구조(Data Structure)란
 * 데이터를 효율적으로 저장하고 조작하기 위한 방법을 정의한 것.
 * 즉, 데이터를 저장하는 방법과 이를 조작하는 방법을 제공
 * 삽입, 삭제, 검색 등의 연산이 가능해야 함.
 * 효율적인 메모리 사용과 처리속도를 보장 해야 함.
 * 구현이 쉽고 이해하기 쉬운 인터페이스를 제공해야 함.
 * 
 * 배열(Array)은 데이터를 저장하는 자료구조의 일종.
 * 동일한 자료형의 데이터를 연속된 공간에 순차적으로 나열 한 것
 * 배열은 메모리상에서 연속된 공간에 데이터를 저장하며 각 데이터는
 * 인덱스(index)라는 숫자로 구분 된다.
 * 배열은 메모리에 저장될 때 크기가 결정되며 변경할 수 없다.
 */

public class UseArrayExample {

	public static void main(String[] args) {
		/*
			배열 생성 방법
		*/
		// 1. 배열에 저장할 값이 있을 시
		int[] array = new int[] {10, 20, 30, 40, 50};
		
		// 2. 선언과 동시에 값을 지정 (new 생략 가능)
		int[] array2 = {50, 60, 70, 80};
		
		// 3. 선언 이후에 배열 항목을 초기화 (new 생략 불가능)
		int[] array3;
		array3 = new int[]{10, 20, 30};
		
		// 4. 배열 생성 시 값이 정해지지 않을 때 (기본값으로 자동 초기화) (new 생략 불가능)
		int[] array4 = new int[5]; // [0] [0] [0] [0] [0] (정수,실수 = 0, boolean = false, 참조타입 = null)
		System.out.println(array4); // [I@(16진수 주소값) ----- [ : 배열, I : Integer, @ : 양 옆을 나누는 기준 -----
		array4[4] = 10;
		int num = array4[4];
		
		// 5. 배열에 저장될 항목의 크기가 결정되지 않았을 경우
		int[] array5 = null;
		
		final int value = 10; // javascript의 const와 같음
//		value = 100;
		
		array5 = new int[3];
		for(int i =0; i<=array5.length-1;i++) {
			System.out.println(array5[i]);
		}
		
		
		
	}

}