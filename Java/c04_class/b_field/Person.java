package Java.c04_class.b_field;
/*
 * 추상화 - 필요한 부분만을 표현하고 불필요한 부분을 제거하여 간결하고 이해하기 쉽게 만드는 작업
 * 객체 모델링 - 추상화
 * 프로그래밍에 필요한 속성 및 동작을 추출하는 과정
 * 공통의 속성이나 기능을 묶어서 이름을 붙이는 것
 */
public class Person {
	
	String job;
	int age;
	String name;
	double height;
	double weight;
	char gender;
	boolean isMarried;
}

class Student {
	int studentID;
	String name;
	int grade;
	String[] subject; // 수강 과목들
	
}
