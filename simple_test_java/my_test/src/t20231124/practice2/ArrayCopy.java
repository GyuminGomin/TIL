package simple_test_java.my_test.src.t20231124.practice2;

import java.util.Arrays;

public class ArrayCopy {
    public static void main(String[] args) {
        int[] array1 = {10,20,30,40,50};
        int[] array2 = Arrays.copyOfRange(array1, 1, 3);
        System.out.println(Arrays.toString(array2));
    }    
}
