package Java.c07_extends_inheritance.extends5_polymorphism.base;

public class Person {
    
    String name; // 이름
    int age; // 나이
    int weight; // 몸무게
    int height; // 키
    
    public Person() {
    	super();
    }

	public Person(String name, int age, int weight, int height) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.height = height;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", weight=" + weight + ", height=" + height + "]";
	}
    
    
    
}
