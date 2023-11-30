package Java.c12_collection_framework.c3_map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("김규민", 100);
		map.put("김규", Integer.valueOf(59));
		map.put("김", 97);
		map.put("규", 70);
		System.out.println(map);
		map.put("김", 89);
		System.out.println(map);
		
		int score = map.get("김");
		System.out.println("김 점수 : " + score);
		int size = map.size();
		System.out.println("저장된 entry 크기 : " + size);
		
//		score = map.get("민"); // 반환이 null -> 오류(int는 null이 없으므로)
		Integer score2 = map.get("민");
		System.out.println(score2);
		
		// 동일한 key값의 entry 삭제
		map.remove("김규");
		System.out.println(map.size());
		System.out.println(map);
		
		boolean isChecked = map.containsKey("김규	");
		System.out.println("key 존재 여부 : " + isChecked);
		
		isChecked = map.containsValue(100);
		System.out.println("value 존재 여부 : " + isChecked);
		
		// iterator로 내부의 값을 확인하기 위해 set으로 변경 (또는 향상된 for문)
		Set<Entry<String,Integer>> entrySet = map.entrySet();
		
		Iterator<Entry<String, Integer>> iterator = entrySet.iterator();
		
		while(iterator.hasNext()) { // 꺼내오다가 더이상 반복할게 없으면 false 반환
			Entry<String, Integer> entry = iterator.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key+":"+value);
		}
		
		System.out.println(map);
		System.out.println("================================");
		
		Set<String> keySet = map.keySet(); // 키 셋
		for(String key : keySet) {
			int value = map.get(key);
			System.out.printf("key : %s = value : %d    ", key, value);
		}
		System.out.println();
		
		Collection<Integer> values = map.values(); // 값 셋
		for(Integer value : values) {
			System.out.print(value + "     ");
		}
		System.out.println();
		
		
		map.clear(); // 전체 entry 삭제
		System.out.println(map.size());
		isChecked = map.isEmpty();
		System.out.println("isEmpty : " + isChecked);
		
		System.out.println("================================");
		Map<String, Integer> linkedMap = new LinkedHashMap<>();
		linkedMap.put("김규민", 100);
		linkedMap.put("김규", 99);
		linkedMap.put("김", 98);
		linkedMap.put("규", 99);
		linkedMap.put("민", 100);
		System.out.println(linkedMap);
	}
}
