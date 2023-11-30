package Java.c12_collection_framework.c2_set;

public class Member {

	private String name;
	private int age;
	
	public Member(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	
	// hashcode랑 equals를 주석처리하고 실행한 후, 주석해제 후 실행
	@Override
	public int hashCode() {
		System.out.println("hashCode 호출 : " + this.age);
		return this.age;
	}



	@Override
	public boolean equals(Object obj) {
		System.out.println("equals 호출");
		if(obj instanceof Member) {
			Member m = (Member)obj;
			if(m.name != null && m.name.equals(this.name)) {
				System.out.println("this.name : " + this.name);
				System.out.println("param name : " + m.name);
				return true;
			}
		}
		return false;
	}



	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + "]";
	}
	
	
}