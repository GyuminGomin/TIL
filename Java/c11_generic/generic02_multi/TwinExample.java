package Java.c11_generic.generic02_multi;

public class TwinExample {

	public static void main(String[] args) {
		Twin<Car, Tv> twin = new Twin<Car, Tv>(); // 자동으로 Generic 타입이 Object로 됨 <- generic 지정 안해주면
		twin.setKind(new Car());
		twin.setModel(new Tv());
		
		Twin<Tv, String> tvTwin = new Twin<>();
		Tv tv = new Tv();
		tvTwin.setKind(tv);
		tvTwin.setModel("LG 스마트 TV");
		System.out.println(tvTwin);
		
		Twin<Car, Integer> car = new Twin<Car, Integer>();
		car.setKind(new Car());
		car.setModel(520);
		System.out.println(car);
	}
}
