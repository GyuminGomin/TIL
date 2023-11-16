package Java.c05_static_final.static_test;

public class Student {
	
	static String school;
	
	String name;
	int age;
	String grade;
	
	static int sum(int x, int y) {
		return x + y;
	} // 학생에게 더하기 연산을 시켜서 제출하라고 한다고 가정
	
	void setAge(int age) {
		if(age < 1) {
			System.out.println("등록할 수 없는 나이입니다.");
		} else {
			this.age = age;
		}
	}
}
