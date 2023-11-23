package Java.c09_API_class.b_string.method;

public class String01CharAtExample {
	
	public static void main(String[] args) {
		String rrn = "010624-1230123";
		char gender = rrn.charAt(7);
		switch(gender) {
			case '1' : case '3' :
				System.out.println("남자");
				break;
			case '2' : case '4' :
				System.out.println("여자");
				break;
			case '5' : case '7' :
				System.out.println("외국 남자");
				break;
			case '6' : case '8' :
				System.out.println("외국 여자");
				break;
			default :
				// 0 여, 9 남
				System.out.println("1899년 이전 출생자");
		}
		
		rrn = "8206073216541";
		// length() == 저장된 문자의 길이
		int length = rrn.length();
		System.out.println("rrn의 길이 : " + length);
		if (length == 13) {
			System.out.println("주민번호 자릿수가 맞습니다.");
		} else {
			System.out.println("자릿수가 일치하지 않습니다.");
		}
	}
}
