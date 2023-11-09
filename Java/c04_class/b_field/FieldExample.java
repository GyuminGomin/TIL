package Java.c04_class.b_field;

public class FieldExample {
    // main() 가 포함되는 실행 class
	public static void main(String[] args) {
		Field f = new Field();
		int field = f.intField;
		boolean bool = f.booleanField;
		double d = f.doubleField;
		String str = f.StringField;
		System.out.println(field);
		System.out.println(bool);
		System.out.println(d);
		System.out.println(str);
		
		Field f2 = new Field();
		f2.intField = 100;
		f2.doubleField = 3.14;
		f2.booleanField = true;
		f2.StringField = "휙휙";
	}
}
