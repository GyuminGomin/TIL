package Java.c12_collection_framework.c4_tree;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) {
		TreeSet<Integer> treeSet = new TreeSet<>();
		treeSet.add(87);
		treeSet.add(75);
		treeSet.add(Integer.valueOf("90"));
		treeSet.add(80);
		treeSet.add(87);
		System.out.println(treeSet);
		
		int score = 0;
		// [75, 80, 87, 90]
		score = treeSet.first();
		System.out.println("treeSet의 첫번째 값 : " + score);
		score = treeSet.last();
		System.out.println("treeSet의 마지막 값 : " + score);
		
		score = treeSet.lower(87);
		System.out.println("87보다 낮은 수(바로 아래) : "+ score);
		
		score = treeSet.higher(87);
		System.out.println("87보다 높은 수(바로 위) : "+ score);
		
		score = treeSet.floor(85);
		System.out.println("85이거나 그 아래 수 : " + score);

		score = treeSet.ceiling(85);
		System.out.println("85이거나 그 위의 수 : " + score);
		
		score = treeSet.pollFirst();
		System.out.println("첫번째 값을 꺼내오고 set에서 삭제 : " + score);
		System.out.println(treeSet);
		
		score = treeSet.pollLast();
		System.out.println("마지막 값을 꺼내오고 set에서 삭제 : " + score);
		System.out.println(treeSet);
		
		treeSet.add(75);
		treeSet.add(90);
		System.out.println(treeSet);
		
		// 범위 검색
		Set<Integer> newSet = treeSet.headSet(81); // 81 이전의 값으로 새로운 set 생성
		System.out.println(newSet); 
		
		newSet = treeSet.tailSet(81); // 81 이후의 값으로 새로운 set 생성
		System.out.println(newSet);
		
		newSet = treeSet.subSet(81, 88); // 81 <= x < 88 범위셋 값으로 새로운 set 생성
		System.out.println(newSet);
		
		// 역순 정렬된 반복자 제공 Descending - 내림차순, Ascending - 오름차순
		Iterator<Integer> itr = treeSet.descendingIterator();
		while(itr.hasNext()) {
			int i = itr.next();
			System.out.print(i + " ");
		}
		System.out.println();
		
		// 역순 정렬된 set 반환
		Set<Integer> descSet = treeSet.descendingSet();
		System.out.println(descSet);
		
	}
}