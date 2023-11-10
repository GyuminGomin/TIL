package Java.c04_class.c_method;

// 탁상용 램프
public class DarkLamp {
	

	// 인스턴스의 멤버 변수 - field 정의
	// 켜짐이나 꺼짐과 같은 램프의 상태를 저장
	boolean isOnOff;
	
	void turnOn() {
		isOnOff = true;
	}
	
	void turnOff() {
		isOnOff = false;
	}
	
	public static void main(String[] args) {
		DarkLamp myLamp = new DarkLamp();
		myLamp.turnOn();
		System.out.println(myLamp.isOnOff);
		myLamp.turnOff();
		System.out.println(myLamp.isOnOff);
	}
}

