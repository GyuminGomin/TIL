package Java.c08_abstract_interface.interface_poly.array;

public class NormalTire implements Tire {

	@Override
	public void roll() {
		System.out.println("일반 도로를 주행합니다.");
	}
}
