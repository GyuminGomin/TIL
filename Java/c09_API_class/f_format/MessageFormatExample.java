package Java.c09_API_class.f_format;

import java.text.MessageFormat;

public class MessageFormatExample {
	
	public static void main(String[] args) {
		String text = "회원 ID : {0} \n회원이름 : {1} \n전화번호 : {2}";
		String result = MessageFormat.format(text, "id001", "김규민", "010-6666-6666");
		System.out.println(result);
		
		String text2 = "학번은 {0}, 이름은 {1}, 전화번호는 {2}";
		Object[] arguments = {1, "김규민", "010-6666-6666"}; // 모든 타입을 다 표현할 수 있는 Object 객체로 해서 자동 wrapper 박싱
		String result2 = MessageFormat.format(text2, arguments);
		System.out.println(result2);
		
		MessageFormat format = new MessageFormat(text2); // 기본생성자는 없고 패턴을 넘겨받는 생성자만 있음
		String result3 = format.format(arguments);
		System.out.println(result3); // 이렇게 사용할 순 있지만, 메모리 공간을 차지하므로, 정적메소드를 활용
	}
}
