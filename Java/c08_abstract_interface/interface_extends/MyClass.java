package Java.c08_abstract_interface.interface_extends;

public class MyClass implements C {

	@Override
	public void methodA() {
		System.out.println("MyClass의 methodA");
	}

	@Override
	public void methodC() {
		System.out.println("MyClass의 methodC");
	}

	public static void main(String[] args) {
		MyClass myClass = new MyClass();
		myClass.methodA();
		myClass.methodB();
		myClass.methodC();
		A.methodC(); // 정적메소드 접근 가능
	}
}