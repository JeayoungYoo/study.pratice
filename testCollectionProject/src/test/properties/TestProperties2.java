package test.properties;

import java.util.*;
import java.io.*;

public class TestProperties2 {

	public static void main(String[] args) {
		// Properties test 2 
		Properties prop1 = new Properties();
		Properties prop2 = new Properties();
		Properties prop3 = new Properties();
		
		try {
			prop1.load(new FileInputStream("driver.dat"));
			prop2.load(new FileReader("driver.txt"));
			prop3.loadFromXML(new FileInputStream("driver.xml"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(prop1);
		System.out.println(prop2);
		System.out.println(prop3);
		
		System.out.println(prop1.getProperty("driver"));
		System.out.println(prop1.getProperty("url"));
		System.out.println(prop1.getProperty("user"));
		System.out.println(prop1.getProperty("password"));
		
		prop3.list(System.out);

	}

}
