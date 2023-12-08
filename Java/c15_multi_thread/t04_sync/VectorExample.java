package Java.c15_multi_thread.t04_sync;

import java.lang.Thread.State;
import java.util.*;

public class VectorExample {

	public static void main(String[] args) {
		System.out.println("Main 시작");
//		List<String> array = new ArrayList<>(); // Vector와 비교
		List<String> array = new Vector<>(); // 데이터 손실이 없음 -> 다 동기화 메서드로 이루어져 있기 때문에
		Thread t1 = new Thread(() -> {
			// run method
			for(int i =0; i < 10000; i++) {
				array.add("김규민");
			}
			System.out.println("t1 종료");
		});
		t1.start();
		
		System.out.println("==========================================");
		
		Thread t2 = new Thread(() -> {
			for(int i=0; i < 10000; i++) {
				array.add("천재");
			}
			System.out.println("t2 종료");
		});
		t2.start();
		
		
		while(true) {
			if(t1.getState() == State.TERMINATED && t2.getState() == State.TERMINATED) {
				System.out.println("t1, t2 작업 완료");
				System.out.println("array size : "+array.size());
				break;
			}
		}
		
		System.out.println("Main 종료");
	}
}
