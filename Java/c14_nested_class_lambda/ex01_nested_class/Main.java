package Java.c14_nested_class_lambda.ex01_nested_class;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// 실행 클래스
public class Main {

	public static void main(String[] args) {
		A a = new A();
		a.methodA();
		
		System.out.println("--------------------------");
		
		A.B b = a.new B();
		b.methodB();
		
		System.out.println("---------------------------");
		
		A.C c = new A.C();
		c.field1 = 3;
		c.methodC();
		
		A.C.field2 = 30;
		A.C.method2();
		
		
		System.out.println("-------------------------------");
		Map<String,Integer> map = new HashMap<>();
		Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
		
	}

}