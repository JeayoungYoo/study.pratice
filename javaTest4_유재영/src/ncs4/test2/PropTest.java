package ncs4.test2;

import java.io.*;
import java.util.*;

public class PropTest {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("1", "apple,1200,3");
		prop.setProperty("2", "banana,2500,2");
		prop.setProperty("3", "grape,4500,5");
		prop.setProperty("4", "orange,800,10");
		prop.setProperty("5", "melon,5000,2");
		
		PropTest pt = new PropTest();
		
		pt.fileSave(prop);
		
		pt.fileOpen(prop);

	}
	
	public void fileSave(Properties p) {
		
		
		try {
			
			p.storeToXML(new FileOutputStream("data.xml"), "data.xml");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fileOpen(Properties p) {
	      try {
	         p.loadFromXML(new FileInputStream("data.xml"));
	         
	         //Enumeration<String> keys = (Enumeration<String>) p.propertyNames();
	         ArrayList<Object> a = new ArrayList<>();
	         a.addAll(p.keySet());
	         //Collection<Object> values = p.values();
	         Collections.reverse(a);
	         Fruit[] fruit = new Fruit[p.size()];
	         int i = 0;
	         for (Object s : a) {
	            String value = p.getProperty(s.toString());
	            String[] fields = value.split(",");
	            fruit[i++] = new Fruit(fields[0], Integer.parseInt(fields[1]), Integer.parseInt(fields[2]));
	         }
	         
	         /*for (int i=0; keyIter.hasNext(); i++){
	            String key = (String) keyIter.next();
	            String value = p.getProperty(key);
	            String[] fields = value.split(",");
	            fruit[i] = new Fruit(fields[0], Integer.parseInt(fields[1]), Integer.parseInt(fields[2]));
	            
	         }*/
	         int j=1;
	         for (Fruit f : fruit) 
	            System.out.println(j++ + " = " + f);
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
}
