package Java.c06_access_modifier.singleton;

/*
 * Singleton Pattern
 * 객체 인스턴스가 여러개 일 필요가 없을 때
 * 하나의 인스턴스를 공유하기 위한 기법
 * 
 * 프린터기는 사무실에 사용자 별로 하나씩 있을 필요가 없고
 * 필요할 때 공유할 수 있도록 하나만 존재하면 됨
 */

public class Printer {
	
	private static Printer printer; // 정적 멤버로 선언
	
	// printer 기는 프린터 내부에서만 생성가능
	private Printer() {}
	
	public static Printer getInstance() {
		if (printer == null) {
			printer = new Printer();
		}
		return printer;
	}
	
	public void print(String document) {
		System.out.println(document);
	}
}
