package test.properties;

import java.util.*;

import test.list.Person;

import java.io.*;

public class TestProperties3 {

	public static void main(String[] args) {
		// person.txt 파일을 읽어 처리 테스트
		Properties prop = new Properties();
		
		try {
			prop.load(new FileReader("person.txt"));
			prop.list(System.out);
			
			System.out.println("갯수 : " + prop.size());
			
			Enumeration<String> keys= (Enumeration<String>) prop.propertyNames();
			Iterator<Object> keyIter = prop.keySet().iterator();
			Collection<Object> values = prop.values();
			
			Person[] parr = new Person[prop.size()];
			for (int i=0; keyIter.hasNext(); i++){
				
				String key = (String) keyIter.next();
				String value = prop.getProperty(key);
				String[] fields = value.split(",");
				parr[i] = new Person(fields[0], Integer.parseInt(fields[1]),Double.parseDouble(fields[2]));
			}
			
			for(Person p : parr)
				System.out.println(p);
				
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
