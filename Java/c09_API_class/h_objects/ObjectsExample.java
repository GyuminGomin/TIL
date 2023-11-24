package Java.c09_API_class.h_objects;

import java.util.Objects;

public class ObjectsExample {

	public static void main(String[] args) {
		// Object 기능을 도와주는 유틸리티 클래스 - Objects
		
		String a = null;
		String a1 = null;
		
		// a는 null 인가? ture : false;
		boolean isChecked = Objects.isNull(a);
		System.out.println(isChecked);
		System.out.println("1------------------------");
		
		// a는 null이 아닌가? true : false;
		isChecked = Objects.nonNull(a1);
		System.out.println(isChecked);
		System.out.println("2------------------------");
		
//		isChecked = a.equals(a1); // NullPointerException
		isChecked = Objects.equals(a, a1);
		System.out.println(isChecked);
		System.out.println("3------------------------");
		
		String c = new String("김규민");
		String d = new String("김규민");
		System.out.println(c == d);
		System.out.println("4------------------------");
		
		isChecked = Objects.equals(a, c);
		System.out.println(isChecked);
		System.out.println("5------------------------");
		
		isChecked = Objects.equals(c, d);
		System.out.println(isChecked);
		System.out.println("6------------------------");
		
		int[] arr1 = {1,2,3,4,5};
		int[] arr2 = {1,2,3,4,5};
		// 주소값을 비교 arr1 == arr2와 동일
		isChecked = Objects.equals(arr1, arr2);
		System.out.println(isChecked);
		System.out.println("7------------------------");
		// 배열에 저장되어 있는 항목의 값을 비교
		isChecked = Objects.deepEquals(arr1, arr2);
		System.out.println(isChecked);
		System.out.println("8------------------------");
		
//		System.out.println(a.toString()); // NullPointerException 발생
		System.out.println(Objects.toString(a));
		System.out.println(Objects.toString(a1, "a1은 참조하는 값이 없습니다."));
		
		int code = Objects.hash(arr2);
		System.out.println(code);
		System.out.println(arr2.hashCode());
		System.out.println(a);
		System.out.println(Objects.hashCode(a)); // Objects의 null hashcode는 0을 반환
		
	}
}
