package Java.c12_collection_framework.c8_comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class ComparatorExample {

	public static void main(String[] args) { // Fruit가 수정할 수 없는 클래스라고 가정
		// Fruit 과일을 정렬할 비교 기준을 정의한 클래스
		DescendingComparator com = new DescendingComparator();
		
		TreeSet<Fruit> treeSet = new TreeSet<>(com);
		
		System.out.println("==============================");
		treeSet.add(new Fruit("포도", 3000));
		System.out.println("------------------------------");
		treeSet.add(new Fruit("딸기", 1500));
		System.out.println("------------------------------");
		treeSet.add(new Fruit("수박", 10000));
		System.out.println("------------------------------");
		System.out.println(treeSet);
		
		Comparator<Fruit> compare = new Comparator<>() { // 익명함수 구현
			@Override
			public int compare(Fruit o1, Fruit o2) {
				return o1.getName().hashCode() - o2.getName().hashCode(); // String의 hashCode는 유니코드 비교
			}
		};
		
		TreeSet<Fruit> treeSet2 = new TreeSet<>(compare);
		treeSet2.add(new Fruit("포도", 3000));
		treeSet2.add(new Fruit("딸기", 1500));
		treeSet2.add(new Fruit("수박", 10000));
		System.out.println(treeSet2); // 이름 순으로 정렬
		
		Integer[] arrays = new Integer[] {10,70,90,80};
		Arrays.sort(arrays);
		System.out.println(Arrays.toString(arrays));
		
		Arrays.sort(arrays, new Comparator<Integer>() { // 두번째 매개변수는 정렬 방식 추가
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1; // 역순 정렬 (내림차순)
			}
		});
		System.out.println(Arrays.toString(arrays));
	}
}
