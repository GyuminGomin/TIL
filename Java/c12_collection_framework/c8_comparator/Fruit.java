package Java.c12_collection_framework.c8_comparator;

public class Fruit {
	
	private String name;
	private int price;
	
	public Fruit(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Fruit [name=" + name + ", price=" + price + "]";
	}
	
}
