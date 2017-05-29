package ncs4.test3;

import java.util.*;

public class MapTest {

	public static void main(String[] args) {
		Map<String, Inventory> map = new HashMap<String, Inventory>();
		map.put("�Ｚ ������S7", new Inventory("�Ｚ ������S7", new Date(2016, 03, 15), 30));
		map.put("LG G5", new Inventory("LG G5", new Date(2016, 02, 25), 20));
		map.put("���� �����е� Pro", new Inventory("���� �����е� Pro", new Date(2016, 01, 23), 15));
		
		System.out.println(map.entrySet());
		
		Iterator<String> keyIter = map.keySet().iterator();
		Iterator<Inventory> valueIter = map.values().iterator();
		
		Inventory[] inven = new Inventory[map.size()];
		
		int i=0;
		while (valueIter.hasNext()) {
			inven[i] = valueIter.next();
			inven[i].setGetDate(new Date());
			inven[i].setGetAmount(10);
		}
		
		for (Inventory in : inven)
			System.out.println(in);
		
		

	}

}
