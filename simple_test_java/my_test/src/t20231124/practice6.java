package simple_test_java.my_test.src.t20231124;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class practice6 {
    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.now();

        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy년MM월dd일 E요일 a KK시mm분ss초 입니다.");
        String time = ldt.format(pattern);
        System.out.println("지정된 시간은 : " + time);
    }
}
