package Java.c05_static_final.final_test;

public class Car {
	
	// KIA -> KIN
	static String cmp; // 제조사 이름
	final String model; // 모델명
	final int maxSpeed; // 최대 속도
	
	int speed; // 현재 속도
	
	static final int MIN_SPEED = 0; // 최저 속도
	
	Car() {
		this.model = "K3";
		this.maxSpeed = 280;
	}
	
	Car(String model, int maxSpeed) {
		this.model = model;
		this.maxSpeed = maxSpeed;
	}
	// (객체 생성시에 null로 초기화될 수 있으므로 생성자로 값 할당 해주거나, 직접 지정)
	
	public static void main(String[] args) {
		
		int v = 100;
		v = 101;
		
		// read only
//		final int min_v;
//		min_v = 0; 메소드안에서는 에러표시 안뜸
		
//		max_v = 100; // 값을 변경할 수 없고 읽기만 가능
		
		Car.cmp= "KIN";
		Car k3 = new Car();
		System.out.println(k3.model);
		System.out.println(k3.maxSpeed);
		
		Car k5 = new Car("k5",320);
		System.out.println(k5.cmp);
		System.out.println(k5.model);
		System.out.println(k5.maxSpeed);
		
		System.out.println(Car.MIN_SPEED);
		System.out.println(Math.PI);
	}
}
