package Java.c04_class.e_references;

public class CarExample {

	public static void main(String[] args) {
		Car car = new Car();
		
		Engine engine = new Engine();
		car.engine = engine;
		
		car.engine.maxSpeed = 280;
		car.engine.rpm = 2000;
		
		System.out.println(engine == car.engine);
		
		Car car2 = new Car();
		car2.engine = new Engine(); // JVM이 자동으로 쓰레기객체를 Garbage Collector 처리를 해줌
		car2.engine.maxSpeed = 180;
		car2.engine.rpm = 1000;
		
		Engine engine2 = new Engine();
		car2.engine = engine2;
	}

}
