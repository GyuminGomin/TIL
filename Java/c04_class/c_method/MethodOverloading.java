package Java.c04_class.c_method;

/*
 * 전산학에서의 Overloading
 */

public class MethodOverloading {

	void methodA() {
		System.out.println("Method A 호출");
	}
	
	void methodA(int a) {
		
	}
	
	void methodA(double d) {
		
	}
	
	void methodA(double d, double d2) {
		
	}
	
	void methodA(int a, double b) {
		
	}
	
	void methodA(double a, int b) {
		
	}
	public static void main(String[] args) {
		MethodOverloading m = new MethodOverloading();
		m.methodA();
		m.methodA(10);
		m.methodA(10.0);
		m.methodA(10.0, 20.0);
		
		AreaCalculator ac = new AreaCalculator();
		int result = ac.areaRectangle(10);
		System.out.println(result);
		double result1 = ac.areaRectangle(10.0,  5.0);
		System.out.println(result1);
		
		ac.divide(10, 5);
		
		ac.divide(10, 0);
	}

}