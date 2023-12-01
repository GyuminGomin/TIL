package simple_test_java.my_test.src.t20231130.practice3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class navigation {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Location> navi = new HashMap<>();

        System.out.println("도시, 경도, 위도를 한번에 입력하세요.( q는 입력완료 )");
        while (true) {
            System.out.print(">> ");
            String[] input = sc.nextLine().split(",");
            if (input[0].equals("q")) {
                break;
            }
            if (input.length != 3) {
                System.out.println("도시, 경도, 위도 3개를 입력해주셔야 합니다.");
                continue;
            }
            //if (input[1] instanceof Number) {

            //}
            double latitude = Double.parseDouble(input[1]);
            double longitude = Double.parseDouble(input[2]);
            navi.put(input[0], new Location(latitude, longitude));
        }
        System.out.println("----------------------------");
        Set<String> s = navi.keySet();
        for (String cou : s) {
            System.out.println(cou + " " + navi.get(cou));
        }
        System.out.println("----------------------------");
        Loop1 :
        while (true) {
            System.out.print("도시 이름 ( q는 종료 )>> ");
            String input = sc.nextLine();
            if (input.equals("q")) {
                System.out.println("시스템 종료");
                break;
            }
            for (String cou : s) {
                if (input.equals(cou)) {
                    System.out.println(cou+ " " + navi.get(cou));
                    continue Loop1;
                }
            }
            System.out.println(input+"는 없습니다.");
        }
        
    }
}
