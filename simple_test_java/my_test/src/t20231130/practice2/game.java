package simple_test_java.my_test.src.t20231130.practice2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Nation> nat = new ArrayList<>();
        nat.add(new Nation("한국", "서울"));
        nat.add(new Nation("프랑스", "파리"));
        nat.add(new Nation("그리스", "아테네"));
        nat.add(new Nation("중국", "베이징"));
        nat.add(new Nation("스페인", "마드리드"));
        nat.add(new Nation("영국", "런던"));
        nat.add(new Nation("독일", "베를린"));
        nat.add(new Nation("러시아", "모스크바"));


        System.out.println("**** 수도 맞추기 게임을 시작합니다.");
        Loop2 :
        while (true) {
            System.out.print("입력:1, 퀴즈:2, 종료:3>>");
            int selNum = sc.nextInt();
            switch (selNum) {
                case 1:
                    boolean isRun = true;
                    System.out.printf("현재 %d개 나라와 수도가 입력되어 있습니다.\n", nat.size());
                    Loop1 :
                    while (isRun) {
                        System.out.printf("국가 입력(현재:%d번째 국가 등록 / q는 종료)>>\n", nat.size()+1);
                        String cou = sc.next();
                        if (cou.equals("q")) {
                            System.out.println("입력을 종료합니다.");
                            break Loop1;
                        }
                        for (int i=0; i<nat.size();i++) {
                            if (nat.get(i).getCountry().equals(cou)) {
                                System.out.printf("%s는(은) 이미 있습니다!", cou);
                                continue Loop1;
                            }
                        }
                        System.out.println("수도 입력>>");
                        String cap = sc.next();
                        for (int i=0; i<nat.size();i++) {
                            if (nat.get(i).getCapital().equals(cap)) {
                                System.out.printf("%s는(은) 이미 있습니다!", cap);
                                continue Loop1;
                            }
                        }
                        nat.add(new Nation(cou, cap));
                        break;
                    }
                case 2 :
                    Collections.shuffle(nat);
                    System.out.print(nat.get(0).getCountry()+"의 수도는? ");
                    String inputCou = sc.next();
                    if (nat.get(0).getCapital().equals(inputCou)) {
                        System.out.println("정답!!");
                        break;
                    } else {
                        System.out.println("아닙니다!! "+nat.get(0).getCountry()+"의 수도는 "+nat.get(0).getCapital()+"입니다.");
                        break;
                    }
                default:
                    System.out.println("게임을 종료합니다.");
                    break Loop2;
            }
        }
        
    }
}
