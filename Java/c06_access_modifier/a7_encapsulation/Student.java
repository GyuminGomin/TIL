package Java.c06_access_modifier.a7_encapsulation;

public class Student {
	
	public String name; // 이름
	private int age; // 나이
	private int grade; // 학년
	
	public static final int MIN_GRADE = 1;
	public static final int MAX_GRADE = 4;
	
	public void setAge(int age) {
		if(age < 1) {
			return;
		}
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setGrade(int grade) {
		if (grade < MIN_GRADE || grade > MAX_GRADE) {
			this.grade = MIN_GRADE;
			return;
		}
		this.grade = grade;
	}
	
	public int getGrade() {
		return this.grade;
	}
	
}
