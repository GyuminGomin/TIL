package Java.c04_class.c_method;

/*
 * method : 객체의 동작 - 기능들을 정의
 * 
 */
public class Methods {
	
	void methodA() {
		System.out.println("반환하는 값 없고, 기능만 수행");
	}
	
	int methodB() {
		System.out.println("int type의 결과를 반환");
		return 0;
	}
	
	double methodC(int x, int y) {
		System.out.println("매개변수 포함");
		return x / y;
	}
	
	private double avg(int i, int j, double d) {
		double total = i + j + d;
		return total/3;
	}
	
	public static void main(String[] args) {
		Methods m = new Methods();
		m.methodA();
		
		int result = m.methodB();
		System.out.println(result);
		
		double r = m.methodC(10, 20);
		System.out.println(r);
		
		double avg = m.avg(10,20,30.0);
		System.out.println(avg);
	}

	
}