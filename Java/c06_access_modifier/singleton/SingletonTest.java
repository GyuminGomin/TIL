package Java.c06_access_modifier.singleton;

public class SingletonTest {

	public static void main(String[] args) {
//		Printer printer = new Printer(); // 접근 불가
		
		Printer printerA = Printer.getInstance();
		System.out.println(printerA);
		
		Printer printerB = Printer.getInstance();
		System.out.println(printerB);
	}

}
