package Java.c07_extends_inheritance.extends3_overriding;

public class Computer extends Calculator {
	
	// annotation 자바 소스코드에 추가하여 사용할 수 있는 meta data의 일종
	@Override // 부가적인 기능 명시 -> annotation
	public double circleArea(double radius) { // 접근제한자 범위는 부모보다 넓은 범위만 사용 가능
		System.out.println("Computer에 존재하는 circleArea");
		return radius * radius * Math.PI;
	}
}
