package ncs.test5;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class PhoneMapTest {

	public static void main(String[] args) {
		Map<String, Phone> map = new HashMap<String, Phone>();
		map.put("galaxy S7", new Phone("galaxy S7", 563500, "삼성", 7));
		map.put("iphone 6s", new Phone("iphone 6s", 840000, "애플", 3));
		map.put("G5", new Phone("G5", 563500, "LG", 5));
		
		System.out.println("맵에 저장된 정보는 다음과 같습니다.");
		for (Map.Entry<String, Phone> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		Properties prop = new Properties();
		for (Entry<String, Phone> entry : map.entrySet())
			prop.setProperty(entry.getKey(), entry.getValue().toString());
		
		try {
			prop.storeToXML(new FileOutputStream("phone.xml"), "phone");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
