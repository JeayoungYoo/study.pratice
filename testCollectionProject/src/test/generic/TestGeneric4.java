package test.generic;

import java.security.KeyStore.Entry;
import java.util.*;

public class TestGeneric4 {
			
	public static void main(String[] args) {
		// Map generic test
		Map<Integer, String> map = new HashMap<Integer, String>();
		putMap(map);
		printMap(map);

	}

	private static void printMap(Map<Integer, String> map) {
		Set<Integer> keys = map.keySet();
		Iterator<Integer> keyIter = keys.iterator();
		
		while(keyIter.hasNext()){
			Integer key = keyIter.next();
			String value = map.get(key);
			System.out.println(value);
		}
		
		Set<Map.Entry<Integer, String>> entrys = map.entrySet();
		Iterator<Map.Entry<Integer, String>> entryIter = entrys.iterator();
		
		while(entryIter.hasNext()){
			Map.Entry<Integer, String> entry = entryIter.next();
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
	}

	private static void putMap(Map<Integer, String> map) {
		map.put(12, "¿À·»Áö");
		map.put(1, "»ç°ú");
		map.put(35, "Æ÷µµ");
		map.put(99, "Á×¼ø");
		
	}

}
