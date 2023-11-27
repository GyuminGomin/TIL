package simple_test_java.my_test.src.t20231127.exam04;

public class Util {

	/*
		getValue() method 작성	
	*/
	public static <K,V> V getValue(Pair<K,V> pair, K key) {
		if (key.equals(pair.getKey())) {
			return pair.getValue();
		}
		return null;
	}
	
}
 