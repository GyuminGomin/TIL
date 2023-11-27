package simple_test_java.my_test.src.t20231124;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class practice6 {
    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.now();
        LocalDateTime targetDateTime = LocalDateTime.of(2023, 12, 31, 23, 59, 59);
        targetDateTime = LocalDateTime.parse("2023-12-31T23:59:59");
        System.out.println(targetDateTime);
        targetDateTime = targetDateTime.withYear(1999).withMonth(12);
        System.out.println(targetDateTime);

        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy년MM월dd일 E요일 a HH시mm분ss초 입니다.");
        String time = ldt.format(pattern);
        time = targetDateTime.format(pattern);
        System.out.println("지정된 시간은 : " + time);
    }
}
