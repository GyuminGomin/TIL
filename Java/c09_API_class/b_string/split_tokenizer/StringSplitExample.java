package Java.c09_API_class.b_string.split_tokenizer;

public class StringSplitExample {
	
	public static void main(String[] args) {
		// 회원 목록을 출력 (김유신, 이순신, 세종대왕, 이황, 이이, ...)
		String text = "김유신&이순신,세종대왕\\이황-이이";
		// 구분자를 표현하는 패턴 - 정규표현식
		String[] names = text.split("&|,|\\\\|-");
		for (String s : names) {
			System.out.println(s);
		}
	}
}
