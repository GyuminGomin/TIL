package Java.c08_abstract_interface.abstract_base;

public abstract class Car {
	
	protected abstract void drive();
	
	protected abstract void stop();
	
	private void startCar() {
		System.out.println("시동을 켭니다.");
	}
	
	private void turnOff() {
		System.out.println("시동을 끕니다.");
	}
	
	public final void run() {
		startCar();
		drive();
		stop();
		turnOff();
	}
}