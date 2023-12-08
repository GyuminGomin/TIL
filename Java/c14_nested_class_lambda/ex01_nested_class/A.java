package Java.c14_nested_class_lambda.ex01_nested_class;

// 외부 클래스
public class A {
	
	A(){
		System.out.println("A 객체 생성");
	}
	
	void methodA() {
		System.out.println("A class의 methodA");
		
		// local class
		class D{
			D(){
				System.out.println("D 객체 생성");
			}
			int field1;
			
			// static int field2;
			
			void methodD(){
				System.out.println("D class method D");
			}
		} // end D
		
		D d = new D();
		d.field1 = 10;
		d.methodD();
		System.out.println(d.field1);
		
	} // end A class methodA
	
	// 인스턴스 멤버 클래스 B
	public class B {
		
		B(){
			System.out.println("B 객체 생성");
		}
		
		int filedB;
		
		void methodB() {
			System.out.println("B method");
			methodA();
		}
		
		// 일반 내부 클래스에서는 정적 멤버를 사용할 수 없음.
		// static void method2() {}
	} // end B
	
	
	// 정적 멤버 class
	static public class C{
		int field1;
		static int field2;
		
		C(){
			System.out.println("C 객체 생성");
		}
		
		void methodC() {
			System.out.println("method C 호출");
			// instance 멤버 사용 불가
			// method();
		}
		
		static void method2() {
			System.out.println("C class의 static method2");
		}
		
	} // end C

} // end A
