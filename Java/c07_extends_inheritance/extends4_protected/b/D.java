package Java.c07_extends_inheritance.extends4_protected.b;

import Java.c07_extends_inheritance.extends4_protected.a.A;

public class D extends A{
	
	A a1 = new A();
	
	public D() {
		a1.a = 100; // public
//		a1.b = 200; // protected
		super.b = 300; // protected
	}
	
	// alt + s + v 오버라이드 shortcut
	@Override
	public void methodA() { // 넓게 접근제한자 정의 가능
		System.out.println("D class의 methodA");
	}
	
	/*
	 * final 키워드는 재정의 불가
	@Override
	protected void methodB() {
		super.methodB();
	}
	*/
	
	
	public static void main(String[] args) {
		D d = new D();
		System.out.println(d.b);
		d.methodA();
		d.methodB();
//		d.c = 100; //default
	}

	
}
