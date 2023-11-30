package Java.c12_collection_framework.c7_comparable;

public class Person implements Comparable<Person>{
	
	private String name;
	private int age;
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Person o) {
		int result = this.age - o.age; // o.age는 기존에 존재하는 , this.age는 새롭게 추가하는
		System.out.println(this.age+ "-" + o.age + "=" + result);
		return result;
	}

}

