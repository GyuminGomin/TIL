package Java.c08_abstract_interface.interface_extends;

public interface A {
	
	void methodA();
	
	default void methodB() {
		System.out.println("A interface methodB");
	}
	
	static void methodC() {
		System.out.println("interface 이름으로 접근하는 정적 멤버");
	}
}


interface B {
	void methodB();
}

interface C extends A, B { // 이름이 중복해 있는 메서드가 default로 정의되어 있으면, 꼭 default로 재정의
	void methodC();

	@Override
	default void methodB() {
		System.out.println("C interface methodB");
	}
	
	
}