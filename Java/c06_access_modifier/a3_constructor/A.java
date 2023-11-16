package Java.c06_access_modifier.a3_constructor;

public class A {
	
	A a = new A(); // public
	
	A a1 = new A(10); // default
	
	A a2 = new A(":"); // private
	
	public A() {
		System.out.println("public 생성자");
	}
	
	A(int a) {
		System.out.println(a +"default 생성자");
	}
	
	private A(String a) {
		System.out.println(a +"private 생성자");
	}
}

