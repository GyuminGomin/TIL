package simple_test_java.my_test.src.t20231130.practice3_answer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PracticeMap {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String,Location> manage = new HashMap<>();
		System.out.println("도시, 경도, 위도를 한번에 입력해주세요.(q는 입력완료)");
		
		// 코드 작성
		while (true) {
			System.out.print(">> ");
			String answer = sc.nextLine();
			if (answer.trim().equals("q")) {
				break;
			}

			String[] str = answer.split(",");

			if(str.length != 3) {
				System.out.println("잘못된 입력입니다.");
				continue;
			}

			System.out.println(Arrays.toString(str));

			String capital = str[0].trim(); // 도시 - key
			String lng = str[1].trim(); // 경도 - value
			String lat = str[2].trim(); // 위도 - value
	
			Location location = new Location(Double.parseDouble(lng), Double.parseDouble(lat));

			// 도시 경도 위도 정보 map에 추가
			manage.put(capital, location);

		} // end while
		System.out.println("------------------------------------");
		Set<String> keySet = manage.keySet();
		for (String key : keySet) {
			Location location = manage.get(key);
			String format = String.format("%s %.1f %.1f", key, location.getLongitude(), location.getLatitude());
			System.out.println(format);
		}
		System.out.println("------------------------------------");
		
		// 도시이름이 일치하는 맵의 entry를 찾아서 출력
		while (true) {
			System.out.print("도시 이름 ( q는 종료 ) >> ");
			String city = sc.next();
			if (city.trim().equals("q")) break;
			if (manage.containsKey(city)) {
				// 동일한 key 값의 도시이름이 존재
				Location loc = manage.get(city);
				System.out.println(city+" "+loc);
			} else {
				System.out.println(city + "는 없습니다.");
			}
		} // end while
		
		System.out.println("시스템 종료");
	}

}
