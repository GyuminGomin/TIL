package Java.c08_abstract_interface.abstract_base;

public class Zoo {
	
	static void animalSound(Animal animal) {
		animal.breath();
		animal.sound();
	}
	
	public static void main(String[] args) {
		// 실체화 되지 않은 기능을 가지고 있는 추상클래스는 추상 클래스만으로 객체 생성 불가
		// Animal animal = new Animal();
		
		Dog dog = new Dog();
		dog.breath();
		dog.kind = "Jindo";
		dog.sound();
		
		Cat cat = new Cat();
		cat.breath();
		cat.kind = "Siamese";
		cat.sound();
		
		animalSound(dog);
		animalSound(cat);
		
		// 익명 구현 객체(이름이 없는 객체)
		Animal tiger = new Animal() {
			String name="호랑이";
			
			public void sound() {
				System.out.println(name + " :크릉, 쾅 어흥");
			}
		};
		
//		tiger.name = "얼룩이"; // Animal이니까 animal 타입 필드만 접근 가능
		tiger.kind = "호랑이";
		animalSound(tiger);
		
	}
}