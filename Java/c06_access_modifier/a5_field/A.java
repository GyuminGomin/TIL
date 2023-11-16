package Java.c06_access_modifier.a5_field;

public class A {
    public int field1;
	int field2;
	private int field3;
	
	public A() {
		field1 = 10;
		field2 = 20;
		field3 = 30;
		
		publicMethod();
		defaultMethod();
		privateMethod();
	}
	
	public int publicMethod() {
		return field3;
	}
	
	int defaultMethod() {
		return field3;
	}
	
	private int privateMethod() {
		return field1;
	}
}
