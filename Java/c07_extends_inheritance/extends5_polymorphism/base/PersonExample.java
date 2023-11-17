package Java.c07_extends_inheritance.extends5_polymorphism.base;

public class PersonExample {
	
	public static void main(String[] args) {
		Person h = new Person("김규민",26,71,172);
		String str = h.toString();
		System.out.println(str);
		System.out.println(h);
		
		Student stu = new Student("홍길동", 100, 40, 100, "A반", "0번", "10학년" );
		System.out.println(stu);
		
		Person stu1 = new Student("국모",30,40,160,"A반","1번","10학년");
		System.out.println(stu1);
		
		// 자동 타입 변환 (Person 생략)
		Person teacher = new Teacher("제임스고슬링", 65, 80, 193, "EAD-134", "JAVA", "4학년");
		System.out.println(teacher);
//		teacher.teach();
		
		// 강제 타입 변환 (Person안에 Teacher, Student 뭐가 올지 모르니까)
		Teacher t1 = (Teacher)teacher;
		t1.teach();
		
		// 객체 직속관계를 제외해서는 사용할 수 없다.
//		Person p = new String("aa");
		Object p = new String("aa");
		Object o = new Person();
		
		Person p1 = stu1;
		if(p1 instanceof Teacher) {
			Teacher t2 = (Teacher)p1;
			System.out.println("teacher 타입입니다.");
			t2.teach();
		} else {
			System.out.println("teacher 타입이 아닙니다.");
		}
	}
}
