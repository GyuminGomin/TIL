class Car {
	
	String company;
	int maxSpeed;
	
	Car () {
		System.out.println("Car 기본 생성자 호출");
	}
	
	Car (String company) {
		this.company = company;
		System.out.println("Car Company를 넘겨 받는 생성자");
	}
	
	public String toString() {
		return "Car [company : "+this.company+", maxSpeed : "+this.maxSpeed+"]";
	}
} // class Car

class Taxi extends Car {
	Taxi() {
//		super(); // 생략되어있음 -> 부모가 먼저 생성 따라서 제일 위에 있을 수 밖에 없음
		System.out.println("Taxi 기본 생성자 호출");
	}
}

class Bus extends Car {
	Bus(String company) {
		super(company);
		System.out.println("Bus 생성자 호출");
	}
}

public class CarExample {	
	
	public static void main(String[] args) {
		Taxi taxi = new Taxi();
		taxi.company = "KIA";
		taxi.maxSpeed = 180;
		System.out.println(taxi.toString());
		
		Bus bus = new Bus("HYUNDAI");
		bus.maxSpeed = 200;
		String str = bus.toString();
		System.out.println(str);
	}

}