package Java.c01_variable_primitive;

public class VariableTest {
    /**
	 * 문서 주석
	 * 이 클래스는 기본 타입의 변수 사용법을 알아봅니다.
	 * @since 2023-11-02
	 */
	/*
	 	프로그램 동작의 시작과 끝은
		main method 에서 이루어 진다.
	*/
	public static void main(String[] args) {
		// TODO check variable again
		// 선언부
		// 주석은 틀린 문장
		int num;
//		num = "dd";
//		System.out.println(num);
		byte bNum = 0b00001010;
		System.out.println("bNum : " + bNum);
		byte oNum = 012;
		System.out.println("oNum : " + oNum);
		byte xNum = 0x3F;
		System.out.println("xNum : " + xNum);
		
		byte b1 = -128;
		b1 = 127;
//		b1 = -129;
		
		char c = '가';
//		c = 'AB';
//		c = "A";
		c = 65;
		c = 65535;
//		c = -1
		System.out.println("c : " + c);
		
		short s = -30000;
		int i = 2100000000;
		long l = 10000000000L; // 100억
		// 정수형 상수 리터럴은 4byte의 int 타입으로 저장되므로, Long 타입은 L을 넣어서 8바이트라는 것을 알려줘야 한다.
		
		char c1 = 'A';
		System.out.println(c1 + 1);
//		char c2 = c1 + 1; // 연산결과가 int 타입이 됨 (초기화하는 과정에서 산술연산을 사용할 수 없음)
		char c2 = (char)(c1 + 1);
		System.out.println(c2);
		System.out.println(10/3);
		
		double d = 3.141592;
		float f = 3.141592f;
		// 실수형 상수 리터럴은 8byte의 double 타입으로 저장되므로, float 타입은 f을 넣어서 4바이트라는 것을 알려줘야 함.
		double result = 3.141592 * 10 * 10;
		System.out.println(3.141592 * 10 * 10);
		// 실수 하나라도 있으면, double 타입의 8byte로 연산을 해줌
		System.out.println(10.0/3);
		
		boolean isTrue = true;
		isTrue = (3e+5 == 300000);
		System.out.println(isTrue);
		isTrue = (3e-5 == 0.00003);
		System.out.println(isTrue);
		
		String str = "문자열을 저장하는 녀석";
		System.out.println(str);
	}
}
