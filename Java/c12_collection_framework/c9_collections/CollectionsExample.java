package Java.c12_collection_framework.c9_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsExample {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i=1; i <=45; i++) {
			list.add(i);
		}
		System.out.println(list);
		
		// 섞는다.
		Collections.shuffle(list);
		System.out.println(list);
		
		// 해당 리스트에서 필요한 부분만 빼오기
		List<Integer> lotto = list.subList(0, 6); // (시작인덱스, 개수)
		System.out.println("===========================");
		System.out.println("lotto : " + lotto);
		
		// 역순 정렬
		Collections.reverse(lotto);
		System.out.println("reverse : " + lotto);
		
		// 정렬 (오름차순)
		Collections.sort(lotto);
		System.out.println("ASCENDING : " + lotto);
		
		System.out.println(Collections.max(lotto));
		System.out.println(Collections.min(lotto));
	}
}
