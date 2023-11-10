package Java.c04_class.d_constructor;

public class CarExample {
	
	public static void main(String[] args) {
		Car car = new Car();
		car.company = "Benz";
		car.model = "S Class";
		car.color = "BLACK";
		car.maxSpeed = 300;
		car.speed = 0;
		
		Car car2 = new Car("Benz", "S Class", "White");
		
		Car car3 = new Car("KIA", "k3", "white", 180, 0);
	}

}
