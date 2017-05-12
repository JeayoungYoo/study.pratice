package test.properties;

import java.io.*;
import java.util.*;

public class TestProperties {

	public static void main(String[] args) {
		// Properties test
		Properties prop = new Properties();
		
		prop.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
		prop.setProperty("url", "jdbc:oracle:thin:@localhost:1521:xe");
		prop.setProperty("user", "student");
		prop.setProperty("password", "student");
		
		System.out.println(prop);
		
		try {
			prop.store(new FileOutputStream("driver.dat"), "jdbc driver file");
			prop.store(new FileWriter("driver.txt"), "jdbc driver file");
			prop.storeToXML(new FileOutputStream("driver.xml"), "jdbc driver file");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
