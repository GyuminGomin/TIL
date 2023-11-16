package Java.c06_access_modifier.a7_encapsulation;

public class Test {
	public static void main(String[] args) {
		// Test.main(null);
		System.out.println(args);
		for(String s : args) {
			System.out.println(s);
		}
		
		Student stu1 = new Student();
//		stu1.age = -20;
		stu1.setAge(-20);
//		stu1.grade = 16;
		stu1.setGrade(16);
		System.out.println(stu1.getAge());
		System.out.println(stu1.getGrade());
	}// end main
}