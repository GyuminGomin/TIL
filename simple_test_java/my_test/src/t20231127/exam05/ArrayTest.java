package simple_test_java.my_test.src.t20231127.exam05;

import java.util.Arrays;

/**
 *  ArrayTest class를 완성하시오.
 */
public class ArrayTest<E>{
	private int capacity;
    private E[] array;
    private int length;

    public ArrayTest() {}

    public ArrayTest(int length) {
        this.length = length;
    }

    public <E> void add(E e) {
        Arrays.fill(array, e);
    }

    public <E> void remove(E e) {
        // TODO
        Arrays.binarySearch(array, e);
    }

    @Override
    public String toString() {
        return "ArrayTest [capacity=" + capacity + ", array=" + Arrays.toString(array) + ", length=" + length + "]";
    }

    public int size() {
        return array.length;
    }

    

    
}


