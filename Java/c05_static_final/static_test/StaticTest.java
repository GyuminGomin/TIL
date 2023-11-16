package Java.c05_static_final.static_test;

public class StaticTest {

	public static void main(String[] args) {
		Student.school = "부산IT아카데미";
		System.out.println(Student.school);
		
		Student stu1 = new Student();
		stu1.name = "김규민";
		stu1.age = 18;
		stu1.grade = "3";
		stu1.school = "부산직업전문학교"; // 접근은 가능하다. 실제 인스턴스에는 공간이 없어 메소드영역으로 찾아서 가져온다. (2번 작업)
		
		Student stu2 = new Student();
		System.out.println(stu2.school);
		
		int result = Student.sum(1, 2);
		System.out.println(result);
		
		stu1.setAge(26);
	}

}

