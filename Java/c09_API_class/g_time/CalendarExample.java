package Java.c09_API_class.g_time;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarExample {

	public static void main(String[] args) {
		// @since 1.1
		Calendar now = Calendar.getInstance();
		Date date = now.getTime(); // 현재시간만 다룰 수 있음
		System.out.println(date);
		System.out.println(date.getTime()); // long 타입의 ms으로 알려줌
		
		// 년도
		int year = now.get(Calendar.YEAR);
		// 월 0 ~ 11 : 0 = 1월
		int month = now.get(Calendar.MONTH) + 1;
		// 월 중 날짜
		int day = now.get(Calendar.DAY_OF_MONTH);
		// 주중 날짜, 요일 (SUNDAY : 1, SATURDAY 7)
		int week = now.get(Calendar.DAY_OF_WEEK);
		System.out.println(Calendar.SUNDAY);
		System.out.println(Calendar.MONDAY);
		
		String strWeek = "";
		switch(week) {
			case Calendar.MONDAY :
				strWeek = "월";
				break;
			case Calendar.TUESDAY :
				strWeek = "화";
				break;
			case Calendar.WEDNESDAY :
				strWeek = "수";
				break;
			case Calendar.THURSDAY :
				strWeek = "목";
				break;
			case Calendar.FRIDAY :
				strWeek = "금";
				break;
			case Calendar.SATURDAY :
				strWeek = "토";
				break;
			case Calendar.SUNDAY :
				strWeek = "일";
				break;
			default :
				break;
		} // end 

		int hour = now.get(Calendar.HOUR); // 시
		int minute = now.get(Calendar.MINUTE); // 분
		int seconds = now.get(Calendar.SECOND); // 초
		int milliseconds = now.get(Calendar.MILLISECOND); // 밀리초
		
		String result = "{0}년 {1}월 {2}일 ({3})요일 {4}시 {5}분 {6}초 {7}밀리초";
		Object[] arguments = { year, month, day, strWeek, hour, minute, seconds, milliseconds };
		String str = MessageFormat.format(result, arguments);
		System.out.println(str);
	}
}
