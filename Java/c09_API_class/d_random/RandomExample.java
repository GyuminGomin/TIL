package Java.c09_API_class.d_random;

import java.util.Random;

public class RandomExample {

	public static void main(String[] args) {
		// Random Class
		// int, double, boolean의 무작위 값을 출력하는 class
		// 객체 생성 시 생성자의 매개변수로 seed값이 결정되며, seed 값이 일치하면 동일한 패턴으로 난수가 발생된다.
		
		// 1 / 1000 초
		long millisTime = System.currentTimeMillis();
		System.out.println(millisTime);
		
		// 10억분의 1초 나노 second(1/1000000000);
		long startTime = System.nanoTime(); // 연산의 퍼포먼스를 확인할 때, 자주 사용
//		Random random = new Random(); // nanotime을 이용해 난수 발생
		Random random = new Random(5); // seed값 5를 이용해 난수 발생
		for (int i = 0; i<6; i++) {
			// 0 ~ 45미만의 값을 난수로 발생 ( 0 <= result < 45 )
			int result = random.nextInt(45) + 1;
			System.out.print(result + " ");
		}
		
		random = new Random(System.nanoTime()); // new Random()과 같다.
		for (int i = 0; i< 10; i++) {
			System.out.println("========================================");
			// true or false
			System.out.println(random.nextBoolean());
			// -21억 ~ 21억 (Integer.MIN_VALUE ~ Integer.MAX_VALUE)
			System.out.println(random.nextInt());
			// 0 <= x < n
			System.out.println(random.nextInt(45));
			// 0.0 <= x < 1.0
			System.out.println(random.nextDouble());
		}
		
		long endTime = System.nanoTime();
		double seconds = (endTime - startTime);
		System.out.println("nanoseconds : " + seconds);
		System.out.println("seconds : " + (seconds/1000000000.0));
	}
}
