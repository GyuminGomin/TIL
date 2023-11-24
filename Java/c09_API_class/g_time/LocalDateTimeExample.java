package Java.c09_API_class.g_time;

import java.time.LocalDate;
import java.time.LocalTime;

public class LocalDateTimeExample {

	public static void main(String[] args) {
		// @since 1.8
		// 시간 정보를 쉽게 다룰 수 있도록 추가된 class
		// LocalDate, LocalTime, LocalDateTime
		LocalDate today = LocalDate.now();
		LocalTime present = LocalTime.now();
		System.out.println(today);
		System.out.println(present); // 여기는 나노seconds로 계산
		
		LocalDate birthday = LocalDate.of(99, 01, 07); // of는 int타입으로 전달한 시간 정보를 갖고 년월일 제공
		System.out.println(birthday);
		birthday = LocalDate.of(1999, 01, 07); // 정확한 년도 지정 필요
		System.out.println(birthday);
		
		LocalTime birthTime = LocalTime.of(05, 02, 10); // 시분초 제공
		birthTime = LocalTime.of(02, 02, 10, 1000000); // 시분초나노초 제공
		System.out.println(birthTime);
		
		System.out.println(today.getYear());
		System.out.println(today.getMonthValue());
		System.out.println(today.getDayOfMonth()); // 월중 날짜 ( 1~ 12로 잘 표현 )
		System.out.println(today.getDayOfWeek()); // 주중 날짜 (요일)
		System.out.println(today.getDayOfYear()); // 년중 날짜
		
		System.out.println(present.getHour() + ":" + present.getMinute()+ ":" + present.getSecond()+"."+present.getNano());
		
	}
}