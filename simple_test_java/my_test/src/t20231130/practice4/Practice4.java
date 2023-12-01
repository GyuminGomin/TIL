package simple_test_java.my_test.src.t20231130.practice4;

import java.util.Scanner;
import java.util.TreeSet;

public class Practice4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> treeSet = new TreeSet<>();

        System.out.println("정수(-1이 입력될 때까지)>>");
        while (true) {
            Integer inp = Integer.parseInt(sc.nextLine());
            if (inp == -1) {
                if (treeSet.size() == 0) {
                    System.out.println("수가 하나도 없음");
                    System.out.println("시스템 종료");
                    break;
                }
                System.out.println("가장 큰 수 는 : "+ treeSet.last());
                System.out.println("시스템 종료");
                break;
            }
            treeSet.add(inp);
        }
        
    }
}
