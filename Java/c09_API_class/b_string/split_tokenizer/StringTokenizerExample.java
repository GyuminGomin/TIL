package Java.c09_API_class.b_string.split_tokenizer;

import java.util.StringTokenizer;

public class StringTokenizerExample {
	
	public static void main(String[] args) {
		String text = "이나영/김희선/박보영/원빈/장동건/현빈";
		StringTokenizer st = new StringTokenizer(text, "/");
		int countTokens = st.countTokens();
		System.out.println(countTokens);
		
		for (int i = 0; i <countTokens; i++) {
			String token = st.nextToken();
			System.out.println(token);
		}
		
		System.out.println("========================================");
		text = "홍길동|이황,김유신,이순신&세종대왕";
//		st = new StringTokenizer(text, "|,&");
		st = new StringTokenizer(text);
		// 꺼내올 Token이 존재하면 True, 없으면 false
		while(st.hasMoreTokens()) {
//			String token = st.nextToken();
			String token = st.nextToken("|,&"); // 생성한 후, 짜르는 방식
			System.out.println(token);
		}
	}
}