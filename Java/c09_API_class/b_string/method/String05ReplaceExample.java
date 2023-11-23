package Java.c09_API_class.b_string.method;

public class String05ReplaceExample {
	
	public static void main(String[] args) {
		String oldStr = "자바는 어렵다! 자바는 그래도 해야한다. 자바!";
		String newStr = oldStr.replace("자바", "JAVA");
		System.out.println("oldStr : " + oldStr); // 기존의 데이터를 그대로 갖고 있음
		System.out.println("newStr : " + newStr);
	}
}
