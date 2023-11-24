package Java.c09_API_class.f_format;

import java.text.DecimalFormat;

public class DecimalFormatExample {

	public static void main(String[] args) {
		
		double num = 1234567.849;
		// 0 or #
		DecimalFormat df = new DecimalFormat("0");
		String str = df.format(num);
		System.out.println("0 : " +str); // 소수점 첫째자리에서 반올림한 값
		
		df = new DecimalFormat("0.0");
		str = df.format(num);
		System.out.println("0.0 : " + str); // 소수점 둘째자리에서 반올림한 값
		df.applyPattern("0.00");
		str = df.format(num);
		System.out.println("0.00 : " + str); // 소수점 셋째자리에서 반올림한 값
		
		df.applyPattern("0000000000000000000000.00");
		str = df.format(num);
		System.out.println("0000000000000000000000.00 : "+ str); // 남은자리를 0으로 채움
		
		df.applyPattern("######################.##");
		str = df.format(num);
		System.out.println("######################.## : " + str); // 남은자리르 0으로 채우지 않음
		
		df.applyPattern("#,###.#");
		str = df.format(num);
		System.out.println("#,###.# : " + str); // 3자리수 마다 ,로 채움
	}
}
