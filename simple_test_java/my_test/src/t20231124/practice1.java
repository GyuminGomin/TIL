package simple_test_java.my_test.src.t20231124;

import java.util.Arrays;
import java.util.Random;

public class practice1 {
    public static void main(String[] args) {
        int[] array = new int[10];
        Random random = new Random();
        for (int i=0; i<array.length; i++) {
            array[i] = random.nextInt(100);
        }
        System.out.println("최초의 리스트 : " + Arrays.toString(array));
        Arrays.sort(array);
        System.out.println("정렬된 리스트 : " + Arrays.toString(array));
    }
}
