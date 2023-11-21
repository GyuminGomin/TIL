package Java.c09_API_class.a_object.finalize;

import java.util.Scanner;

public class FinalizeExample {
	public static void main(String[] args) {
		Counter counter = null;
		for (int i =0; i <= 50; i++) {
			counter = new Counter(i); // 찾아서 접근할 수 없는 의미없는 데이터 공간 생성 (garbage collector가 소멸)
			System.gc(); // 시스템에 가비지 컬렉터로 정리해라고 알려주는 명령어 (그치만 맘대로 행동함)
		}
		System.out.println("입력대기");
		Scanner sc = new Scanner(System.in);
		String result = sc.next();
		System.out.println(result); // 메모리 공간을 바로 없애버리지 않게 프로그램 가동시키기
	}
}
