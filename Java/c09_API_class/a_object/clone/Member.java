package Java.c09_API_class.a_object.clone;

import java.util.Arrays;

public class Member implements Cloneable{
	
	String name;
	int age;
	int[] scores;
	Car car;

	
	public Member() {}

	public Member(String name, int age, int[] scores, Car car) {
		this.name = name;
		this.age = age;
		this.scores = scores;
		this.car = car;
	}
	
	public Member getCloned() throws CloneNotSupportedException {
//		Member cloned = (Member)super.clone(); // Object 객체의 clone메서드
		Member cloned = (Member)this.clone(); // 오버라이딩 clone메서드
		return cloned;
	}
	
	
	// 재정의로 깊은 복제를 만들어 주기 위해 만든 clone 메서드
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Member cloned = (Member)super.clone(); // 먼저 얕은 복제
		// scores 새로운 공간 생성
		int[] scores = new int[cloned.scores.length];
		for(int i=0; i<cloned.scores.length; i++) {
			scores[i] = this.scores[i];
		}
		cloned.scores = scores;
		Car car = new Car(this.car.model);
		cloned.car = car;
		
		return cloned;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", scores=" + Arrays.toString(scores) + ", car=" + car + "]";
	}
	
	
}
