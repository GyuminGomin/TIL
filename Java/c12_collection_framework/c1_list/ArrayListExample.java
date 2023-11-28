package Java.c12_collection_framework.c1_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
	Collection Framework
	다수의 데이터를 쉽고 효과적으로 처리할 수 있도록 표준화 된 방법을 제공하는 class의 집합
	- 데이터를 저장하는 자료구조와 데이터를 처리하는 알고리즘을 구조화하여 class로 구현한 것
	
	List(리스트)
		순서가 있는 데이터들의 집합.
		동적으로 크기가 정해지며 데이터의 삽입 삭제가 배열에 비해 용이하고 메모리의 재사용성이 높다.
 */
public class ArrayListExample {

	public static void main(String[] args) {
		ArrayList array = new ArrayList();
		array.add("문자열");
		array.add(100);
		System.out.println(array);
		
		String str = (String)array.get(0);
		System.out.println(str);
		
		ArrayList<String> strs = new ArrayList<>(20);
//		strs.add(100);
		strs.add("java");
		strs.add("JDBC");
		strs.add(null);
		int size = strs.size();
		System.out.println("size : " + size);
		strs.add("MySQL");
		strs.add("mysql");
		String str2 = strs.get(0);
		System.out.println("0 : " + str2);
//		System.out.println(strs.get(5));
		for(int i=0; i<strs.size(); i++) {
			System.out.println(strs.get(i));
		}
		
		for(String s : strs) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		strs.add(2, "Servlet/JSP"); // 해당되는 인덱스에 새로운 녀석 추가
		System.out.println(strs);
		strs.add("JDBC");
		System.out.println(strs);
		
		// remove
		boolean isChecked = strs.remove("JDBC");
		System.out.println("isChecked : " + isChecked);
		System.out.println(strs);
		
		String result = strs.remove(2); // 해당되는 인덱스를 삭제
		System.out.println(result);
		System.out.println(strs);
		
		// list에 저장된 항목들 중 매개변수로 전달 받은 객체가 존재하면 true
		isChecked = strs.contains("mysql");
		System.out.println("isChecked contains : " + isChecked);
		
		// 해당 인덱스의 값을 변경하고 기존에 저장되어 있던 값을 반환
		result = strs.set(2, "Oracle");
		System.out.println("result : " + result);
		System.out.println(strs);
		
		/* NullPointerException
		List<String> strss = null;
		strss.isEmpty();
		*/
		// list 항목이 비어있으면 true
		isChecked = strs.isEmpty();
		System.out.println("isEmpty : " + isChecked);
		
		// list 안의 모든 항목 제거
		strs.clear();
		System.out.println(strs.size());
		System.out.println("isEmpty : " + strs.isEmpty());
		
		strs.add("JAVA");
		strs.add("Java");
		strs.add("JaVa");
		strs.add("java");
		System.out.println(strs);
		
		// List => array
		String[] ss = new String[strs.size()];
		strs.toArray(ss);
		System.out.println(Arrays.toString(ss));
		
		System.out.println("====================================");
		// array => List
		List<String> list = Arrays.asList(ss);
		System.out.println(list);
		
		
	}
}