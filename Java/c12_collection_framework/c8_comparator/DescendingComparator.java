package Java.c12_collection_framework.c8_comparator;

import java.util.Comparator;

public class DescendingComparator implements Comparator<Fruit>{

	@Override
	public int compare(Fruit o1, Fruit o2) {
		// o1 == 새로 추가되는 객체, o2 == 기존에 저장되어있던 객체
		// 음수일 땐 왼쪽
		// 양수일 땐 오른쪽
		// 0 일때는 중복
		System.out.println("compare : " + o2 + "-" + o1);
		return o2.getPrice() - o1.getPrice(); // 새로 추가된 과일의 가격이 크면 음수 (즉, 새로 추가된 과일이 크면 왼쪽)
	}
	
}