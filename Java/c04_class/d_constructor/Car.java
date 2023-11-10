package Java.c04_class.d_constructor;

public class Car {
	// Ctrl + s + a -> Generate Constructor
	String company;
	String model;
	String color;
	
	int maxSpeed;
	
	int speed;
	
	// 생성자를 정의하지 않으면
	Car() {
		System.out.println("Car 기본 생성자 호출");
	} // 자동으로 추가됨
	
	Car(String company, String model, String color) {
		// this == 생성된 인스턴스의 주소 (자신의 생성자 호출)
		this.company = company;
		this.model = model;
		this.color = color;
	}

	public Car(String company, String model, String color, int maxSpeed, int speed) {
//		super();
		this(company, model, color);
//		this.company = company;
//		this.model = model;
//		this.color = color;
		this.maxSpeed = maxSpeed;
		this.speed = speed;
	}	
}