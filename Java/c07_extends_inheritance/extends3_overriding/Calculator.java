package Java.c07_extends_inheritance.extends3_overriding;

public class Calculator // extends Object
{
	public int sum(int a, int b) {
		return a + b;
	}
	
	public double circleArea(double radius) {
		System.out.println("calculator circleArea 호출");
		return radius * radius * 3.14;
	}
	
	@Override
	public String toString() {
		return "Calculator";
	}
}

