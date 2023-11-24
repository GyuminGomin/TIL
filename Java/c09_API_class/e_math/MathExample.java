package Java.c09_API_class.e_math;

/*
 	Math
 	수학 계산에 사용할 수 있는 정적 메소드를 제공하는 class
*/
public class MathExample {
	
	public static void main(String[] args) {
		
		
		// abs() : 절댓값
		int v1 = Math.abs(-5);
		double v2 = Math.abs(-3.14);
		System.out.println("v1 : " + v1); // 5
		System.out.println("v2 : " + v2); // 3.14
		
		// 내림
		double v3 = Math.floor(5.3);
		double v4 = Math.floor(-5.3);
		System.out.println("v3 : " + v3);
		System.out.println("v4 : " + v4);
		
		// 올림
		double v5 = Math.ceil(5.3);
		double v6 = Math.ceil(-5.3);
		System.out.println("v5 : " + v5);
		System.out.println("v6 : " + v6);
		
		// 두개의 값을 매개변수로 넘겨받아 둘 중 큰 수를 반환
		int v7 = Math.max(10, 12);
		double v8 = Math.max(10.1, 10.4);
		System.out.println("v7 : " + v7);
		System.out.println("v8 : " + v8);
		// 두개의 값을 매개변수로 넘겨받아 둘 중 작은 수를 반환
		int v9 = Math.min(10, 12);
		double v10 = Math.min(10.1, 10.4);
		System.out.println("v9 : " + v9);
		System.out.println("v10 : " + v10);
		
		// 반올림 - 소수점 첫째자리에서 반올림하고 값을 double type으로 반환
		double v11 = Math.rint(5.311);
		double v12 = Math.rint(5.511);
		System.out.println("v11 : " + v11); // 5.0
		System.out.println("v12 : " + v12); // 6.0
		
		// 반올림 하고 나서 long 타입의 정수값으로 결과 반환
		long v13 = Math.round(5.451352);
		System.out.println("v13 : " + v13); // 5
		
		// 0 <= x < 1 난수 발생
		double random = Math.random();
		System.out.println("random : " + random);
		
		// pow(a,b) - 거듭제곱
		double v14 = Math.pow(2, 10);
		System.out.println("v14 : " + v14);
		
		// sqrt() - 제곱근
		double v15 = Math.sqrt(9);
		System.out.println("v15 : " + v15);
		
		// 두수의 값의 차이를 정수로 반환
		int v16 = Math.subtractExact(11, -6);
		System.out.println("v16 : " + v16);
		
		// 삼각함수
		System.out.println(Math.cos(20));
		System.out.println(Math.sin(20));
		System.out.println(Math.tan(20));
	}
}
