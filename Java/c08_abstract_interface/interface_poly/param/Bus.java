package Java.c08_abstract_interface.interface_poly.param;

public class Bus implements Runnable{
	
	@Override
	public void run() { // interface는 전부다 앞에 public abstract가 생략되어 있음
		System.out.println("버스를 운전합니다.");
	}
}
