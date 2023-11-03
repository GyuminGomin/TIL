package Java.c02_operators.operator;

public class Operator01EqualsTest {
    public static void main(String[] args) {
		// 크기 비교 연산자
		// 동등 비교 연산자
		// 논리 비교 연산자
		
		int num1 = 10, num2 = 20;
		boolean result = num1 > num2;
		System.out.println("result : " + result);
		result = num1 == num2;
		System.out.println("result : " + result);
		result = num1 != num2;
		System.out.println("result : " + result);
		
		num1 = 10;
		num2 = 22;
		int op = num1 & num2;
		System.out.println(op);
		op = num1 | num2;
		System.out.println(op);
		op = num1 ^ num2;
		System.out.println(op);
		
		boolean boolResult = (num1 < 0) && (num2++ > 0);
		System.out.println(boolResult);
		System.out.println(num1);
		System.out.println(num2);
		
		num1 = num2 = 0;
		result = (++num1 > 0) || (num2++ > 0);
		System.out.println(result);
		System.out.println(num1);
		System.out.println(num2);
		
		byte num = 5;
		int resultShift = (num >> 2);
		System.out.println(resultShift);
		// 오른쪽 비트는 사라지고왼쪽에 새로운 비트가 생성
		resultShift = (num << 2);
		System.out.println(resultShift);
	}
}
