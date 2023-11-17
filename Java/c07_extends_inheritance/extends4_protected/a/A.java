package Java.c07_extends_inheritance.extends4_protected.a;

public class A {
	
	public int a;
	protected int b;
	int c;
	private int d;
	
	public A() {
		this.d = 10;
	}
	
	protected void methodA() {
		System.out.println("A class의 methodA");
	}
	
	protected final void methodB() { // 오버라이딩이 안되는 메소드 (final) -> 내용 수정 불가
		System.out.println("A class의 methodB");
	}
}
