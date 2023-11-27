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

    public ArrayTest(int len) {
        array = (E[])new Object[len];
        this.capacity = len;
    }

    public void add(E e) {
        length += 1;
        if (capacity < length) {
            array = Arrays.copyOf(array, length);
            capacity = length;
        }
        array[length-1] = e;
    }

    public void remove(E e) {
        for(int i=0; i<capacity; i++) {
            if (array[i].equals(e)) {
                for (int j = i; j>0; j--) {
                    E tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                } // 인덱스를 가장 앞으로 보낸 후, 
                array = Arrays.copyOfRange(array, 1, length);
                break;
            }
        }
        length--;
        capacity = length;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public int size() {
        return length;
    }
}


