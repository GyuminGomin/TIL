package Java.c09_API_class.b_string.builder_buffer;

public class StringBuilderExample {
	
	public static void main(String[] args) {
		String str = "이순신";
		String str1 = "김유신";
		String str2 = "이순신김유신";
		String str3 = str + str1; // 새로운 공간에 값을 할당
		String str4 = "이순신"; // 리터럴을 그대로 가져와서 같다.
		System.out.println(str == str4);
		System.out.println(str2 == str3);
		System.out.println(str2.equals(str3));
		
		String a = "세종대왕";
		System.out.println(a.hashCode());
		String b = "세종대왕";
		System.out.println(b.hashCode());
		a += "천재";
		System.out.println(a.hashCode());
		a += "다";
		System.out.println(a.hashCode()); // 접합 연산자 사용하며 새로운 공간이 할당
		
		StringBuffer sbf = new StringBuffer("초기값 : ");
		StringBuilder sb = new StringBuilder("초기값 : ");
		
		// 기존 값 뒤에 매개변수로 넘겨받은 값을 추가
		sb.append("자바 ");
		sb.append("Programming Study!!");
		sb.append(1.8);
		System.out.println(sb);
		String result = sb.toString();
		System.out.println(result);
		System.out.println(sb.hashCode());
		
		// 저장된 문자열에서 4번째 인덱스에 두번째 매개변수 값을 삽입
		sb.insert(4, 2);
		System.out.println(sb.toString());
		System.out.println(sb.hashCode());
		
		// 해당 인덱스에 있는 문자를 두번째 매개변수 문자로 변경
		sb.setCharAt(4, '8');
		System.out.println(sb.toString());
		System.out.println(sb.hashCode());
		
		// delete(시작인덱스, 해당자리까지) 문자열 삭제
		sb.delete(4, 6);
		System.out.println(sb.toString());
		System.out.println(sb.hashCode());
		
		// 지정된 인덱스의 문자 삭제
		sb.deleteCharAt(4);
		System.out.println(sb.toString());
		System.out.println(sb.hashCode());
		
		// 역순정렬
		StringBuilder reverse = sb.reverse();
		System.out.println(reverse.toString());
		System.out.println(reverse.hashCode());
	}
}
