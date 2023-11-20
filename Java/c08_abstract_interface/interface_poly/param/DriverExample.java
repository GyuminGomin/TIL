package Java.c08_abstract_interface.interface_poly.param;

public class DriverExample {
	public static void main(String[] args) {
		Driver driver = new Driver();
		
		Sedan sedan = new Sedan();
		driver.drive(sedan);
		
		Bus bus = new Bus();
		driver.drive(bus);
		
		MotorCycle motorCycle = new MotorCycle();
		driver.drive(motorCycle);
	}
}
