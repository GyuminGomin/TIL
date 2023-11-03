package Java.c02_operators.operator;

public class Operator00Arithmetic {
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("- main 프로그램 실행");
		
		int num1= 10;
		System.out.println(+num1);
		int num2 = 20;
		System.out.println(-num2);
		
		num2=-num2;
		System.out.println(num2);
		System.out.println(-num2);
		int result = num1 + num2;
		System.out.println("result : "+result);
		
		num1 = 10;
		num2 = 3;
		result = num1 / num2;
		System.out.println("정수 연산 : " + result);
		double dResult = num1 / num2;
		System.out.println("정수 연산 : " + dResult);
		double typeResult = num1 / dResult;
		System.out.println("typeResult : "+typeResult);
		
		String s= "김규민";
		String strResult = num1 + num2 + s;
		System.out.println(strResult);
//		strResult = num1 - num2 - s;
		strResult = ((s+num1) + num2);
		System.out.println(strResult);
		
		int a = 1;
		int b = a++;
		System.out.println(a);
		System.out.println(b);
		b = ++a;
		System.out.println(a);
		System.out.println(b);
		
		System.out.println("- main 프로그램 종료");
	}
}
