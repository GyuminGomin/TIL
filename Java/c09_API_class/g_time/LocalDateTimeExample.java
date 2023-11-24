package Java.c09_API_class.g_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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

        // 1년 전
        LocalDate target = today.minusYears(1);
        System.out.println(target);
        // 10년 후
        target = today.plusYears(10);
        System.out.println(target);
        // 5달 전
        target = today.minusMonths(5);
        System.out.println(target);
        // 20일 전
        target = today.minusDays(20);
        System.out.println(target);
        
        // 10시간 전
        LocalTime targetTime = present.minusHours(10);
        System.out.println(targetTime);
        // 5시간 후
        targetTime = present.plusHours(5);
        System.out.println(targetTime);
        // 10분 전
        targetTime = present.minusMinutes(10);
        System.out.println(targetTime);
        // 30초 후
        targetTime = present.plusSeconds(30);
        System.out.println(targetTime);
        
        // 현재 날짜와 시간
        LocalDateTime targetDateTime = LocalDateTime.now();
        System.out.println(targetDateTime);
        
        targetDateTime = LocalDateTime.of(target, targetTime); // LocalDate, LocalTime
        targetDateTime = LocalDateTime.of(2023, 11, 24, 12, 11, 23);
        System.out.println(targetDateTime);
        
        // 지정된 시간을 가지고 객체 생성(수정)
        targetDateTime = targetDateTime.withYear(2024).withMonth(10).withDayOfMonth(5).withHour(13).withMinute(30).withSecond(20);
        System.out.println(targetDateTime);
        
        // 지정된 패턴을 이용하여 문자열 생성
        // 패턴 지정 클래스
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy년MM월dd일 E요일 a KK시mm분ss초");
        String time = targetDateTime.format(pattern); // 지정해준 패턴으로 변환
        System.out.println(time);
        
        // 문자열을 시간 정보로 변환 -> 따로 패턴을 지정하지 않으면 기본 타입으로 전달해야 함.
        targetDateTime = LocalDateTime.parse("1999-01-07T05:00:10");
        System.out.println(targetDateTime);
        
        // 사용자가 "2023-10-10" 입력하면 패턴을 지정해줘야 함
        LocalDate date = LocalDate.parse("2023-10-10",DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(date);
        date = LocalDate.parse("2023년10월10일",DateTimeFormatter.ofPattern("yyyy년MM월dd일"));
        System.out.println(date);
        // 데이터 타입이 다 들어갈 수 있어야 함
        date = LocalDate.parse("2023년11월24일 12시27분30초", DateTimeFormatter.ofPattern("yyyy년MM월dd일 HH시mm분ss초"));
        System.out.println(date);
        LocalDateTime dateTime = LocalDateTime.parse("2023년11월24일 12시27분30초", DateTimeFormatter.ofPattern("yyyy년MM월dd일 HH시mm분ss초"));
        System.out.println(dateTime);
        /*
        // 계산할 수 없음 이렇게 하려면, LocalDate를 써야함 아니면, 의미없더라도 패턴을 시분초를 넣어둬야 함
        dateTime = LocalDateTime.parse("2023년11월24일", DateTimeFormatter.ofPattern("yyyy년MM월dd일"));
        System.out.println(dateTime);
        */
		
	}
}