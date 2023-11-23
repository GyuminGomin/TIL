package Java.c09_API_class.c_wrapper;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigClassExample {
	
	public static void main(String[] args) {
		System.out.println(Long.MAX_VALUE);
		BigInteger bi = new BigInteger("10000000000000000000000000000000000");
		
		System.out.println(bi.toString());
		System.out.println(bi.intValue());
		
		BigInteger bi2 = new BigInteger("123456789000");
		System.out.println(bi2);
		
		BigInteger result = new BigInteger("0");
		
		// 더하기
		result = bi.add(bi2);
		System.out.println("result : "+result);
		
		// 빼기
		result = bi.subtract(bi2);
		System.out.println("result : "+ result);
		
		// 곱하기
		result = bi.multiply(bi2);
		System.out.println("result : "+ result);
		
		// 나누기
		result = bi.divide(bi2);
		System.out.println("result : "+ result);
		
		double d = 3.1415926535111111111111111111111111111111111111;
		System.out.println(d);
		BigDecimal bd = new BigDecimal("3.1415926535111111111111111111111");
		
		BigDecimal bd2 = new BigDecimal("2.022222222222222222222222222222");
		System.out.println(bd.multiply(bd2));
	}
}
