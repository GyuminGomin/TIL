package Java.c09_API_class.b_string.method;

public class String03SubstringExample {
	
	public static void main(String[] args) {
		String ssn = "880815-1234567";
		int index = ssn.indexOf("-");
		// 0 번째 인덱스 부터 index 이전까지 잘라내 새로운 문자열 반환
		String birthDay = ssn.substring(0, index);
		System.out.println("생년월일은 : " + birthDay);
		
		// 전달받은 인덱스 부터 뒤에 있는 모든 문자열을 잘라내어 새로운 문자열 반환
		String last = ssn.substring(index+1);
		System.out.println(last);
		
		String fileName = "my.home.cat.png";
		index = fileName.lastIndexOf(".");
		String ext = fileName.substring(index+1);
		System.out.println(ext);
		
		ext = ext.toLowerCase(); // 소문자 변환
		System.out.println(ext);
		if (ext.equals("png")) {
			System.out.println("png 이미지 파일입니다.");
		}
		
		if(ext.equalsIgnoreCase("png")) { // 대소문자 무시하고 비교
			System.out.println("png 이미지 파일입니다.");
		}
		
		ext = ext.toUpperCase(); // 대문자 변환
		if (ext.equals("PNG")) {
			System.out.println("png 이미지 파일입니다.");
		}
		
	}
}
