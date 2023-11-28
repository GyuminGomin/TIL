package Java.c12_collection_framework.c2_set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class HashSetExample {

	public static void main(String[] args) {
		HashSet<String> s1 = new HashSet<>();
		s1.add("A");
//		s1.add(0, "B"); // 순서가 없으므로 인덱스번호도 없다.
		s1.add("D");
		s1.add("B");
		s1.add("C");
		
		boolean isAdd = s1.add("C");
		System.out.println(s1);
		System.out.println("isAdd : " + isAdd);
		
		// 반복자 내부에 저장하고 있는 데이터를 token 처럼 꺼내옴
		Iterator<String> iterator = s1.iterator();
		while(iterator.hasNext()) {
			String s = iterator.next();
			System.out.print(s + " ");
		}
		System.out.println();
		System.out.println(s1.contains("B"));
		
		Set<String> s2 = new HashSet<>();
		s2.add("A");
		s2.add("B");
		s2.add("E");
		System.out.println(s2);
		
		Set<String> s3 = new HashSet<>(s1);
		System.out.println(s3);
		System.out.println(s3 == s1);
		
		// s3 : A B C D
		// s2 : A B E
		// 중복을 제외한 합집합
		s3.addAll(s2);
		System.out.println(s3);
		
		Set<String> s4 = new HashSet<>(s1);
		// 교집합
		s4.retainAll(s2);
		System.out.println("s4 : " + s4);
		
		// 차집합
		boolean isDeleted = s1.remove("A");
		System.out.println("isDeleted : " + isDeleted);
		System.out.println(s1);
		
		/* 접근할 수 있는 항목의 크기가 변경되면 문제 발생
		for (String s : s1) {
			System.out.print(s + " ");
			if(s.equals("B")) {
			// java.util.ConcurrentModificationException
				s1.remove(s);
				s1.add("E");
			}
		}
		*/
		
		// 들어간 순서를 보장 x
		Set<String> hSet = new HashSet<>();
		hSet.add("apple");
		hSet.add("banana");
		hSet.add("kiwi");
		hSet.add("melon");
		System.out.println(hSet);
		
		// 들어간 순서를 보장하는 Set
		Set<String> linkedSet = new LinkedHashSet<>();
		linkedSet.add("apple");
		linkedSet.add("banana");
		linkedSet.add("kiwi");
		linkedSet.add("melon");
		System.out.println(linkedSet);
		
	} // end main
}
