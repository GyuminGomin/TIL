package Java.c09_API_class.a_object.hashcode;

import java.util.HashSet;

public class KeyExample {
	public static void main(String[] args) {
		
		Key key1 = new Key(1);
		Key key2 = new Key(2);
		Key key3 = new Key(1);
		
		System.out.println("key1 : " + key1.hashCode());
		System.out.println("key2 : " + key2.hashCode());
		System.out.println("key3 : " + key3.hashCode());
		
		HashSet<Key> set = new HashSet<>();
		set.add(key1);
		set.add(key2);
		set.add(key3);
		
		System.out.println(set); // hashcode는 같아도 equals에서도 비교한다.
	}
}

