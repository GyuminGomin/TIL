package Java.c12_collection_framework.c7_comparable;

import java.util.TreeSet;

public class ComparableExample {
	
	public static void main(String[] args) {
		TreeSet<Integer> intSet = new TreeSet<>();
		intSet.add(50);
		intSet.add(70);
		intSet.add(60);
		intSet.add(50);
		System.out.println(intSet);
		
		System.out.println("===========================");
		// ClassCastException 발생 -> Person을 Comparable로 변경할 수 없다. -> Person 객체에 Comparable, compareTo 추가
		TreeSet<Person> set = new TreeSet<>();
		set.add(new Person("김규민", 26));
		System.out.println("---------------------------");
		set.add(new Person("김규", 30));
		System.out.println("---------------------------");
		set.add(new Person("김", 65));
		System.out.println("---------------------------");
		set.add(new Person("규", 28));
		System.out.println("---------------------------");
		System.out.println(set);
	}
	
	
}

    
}
