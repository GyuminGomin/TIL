package Java.c06_access_modifier.a7_encapsulation;

public class Car {
	// alt + s + r(GETTER SETTER), alt + s + s + s(ToString)
	private String model;
	private String color;
	
	private int speed;
	
	private boolean oil;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public boolean isOil() {
		return oil;
	}

	public void setOil(boolean oil) {
		this.oil = oil;
	}

	@Override
	public String toString() {
		return "Car [model=" + model + ", color=" + color + ", speed=" + speed + ", oil=" + oil + "]";
	}
	
}