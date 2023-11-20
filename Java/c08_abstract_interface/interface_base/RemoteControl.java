package Java.c08_abstract_interface.interface_base;

public interface RemoteControl { // 무조건 중괄호(몸통)이 없는 메서드로 생성해줘야 함
	
	public static final int MAX_VALUE = 10;
	
	int MIN_VALUE = 0; // public static final이 자동으로 붙는다.
	
	public abstract void turnOff(); 
	
	void turnOn(); // public abstarct가 자동으로 붙는다.
	
	void setValue(int value);
}

