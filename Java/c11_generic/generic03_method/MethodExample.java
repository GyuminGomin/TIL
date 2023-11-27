package Java.c11_generic.generic03_method;

public class MethodExample {

	public static <T> Box<T> boxing(T t) {
		Box<T> box = new Box<>();
		box.setType(t);
		return box;
	}
	
	public static void main(String[] args) {
		Box<String> box1 = MethodExample.<String>boxing("사과");
		
		Box<String> box2 = boxing("오렌지");
		
		Box<Integer> box3 = boxing(100); // Box<Integer> box3 = MethodExample.<Integer>boxing(100);
		int result = box3.getType();
		System.out.println(result);
	}
}
