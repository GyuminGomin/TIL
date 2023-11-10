package Java.c04_class.f_object_array;

public class KoreanExample {

	public static void main(String[] args) {
		Korean[] koreans = new Korean[3];
		// [null] [null] [null]
		for(Korean korean : koreans) {
			System.out.println(korean);
		}
		
		for (int i=0; i<koreans.length;i++) {
			koreans[i] = new Korean();
		}
		koreans[0].name = "Test1";
		koreans[1].name = "Test2";
		
		for(Korean korean : koreans) {
			if (korean != null) {
				System.out.println(korean.name);
				return;
			}
			System.out.println(korean.name);
		}
		
		
	}
}