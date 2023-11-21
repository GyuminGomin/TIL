package Java.c09_API_class.a_object.toString;

class Person {
	
	String name;
	int height;
	double weight;
	
	public Person(String name, int height, double weight) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	
	// alt + s + s + s
	@Override
	public String toString() {
		return "Person [name=" + name + ", height=" + height + ", weight=" + weight + "]";
	}
	
	
}

public class ToStringExample {
	public static void main(String[] args) {
		Object obj = new Object();
		String result = obj.toString();
		System.out.println(result);
		System.out.println(obj);
		
		Person p = new Person("김규민", 172, 70);
		System.out.println(p);
	}
}