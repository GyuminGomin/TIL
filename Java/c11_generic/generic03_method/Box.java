package Java.c11_generic.generic03_method;

public class Box<T> {
	
	private T type;
	
	public T getType() {
		return type;
	}
	
	public void setType(T type) {
		this.type = type;
	}
	
}

