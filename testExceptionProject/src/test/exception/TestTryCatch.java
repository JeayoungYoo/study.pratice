package test.exception;

import java.io.*;
import java.sql.*;

public class TestTryCatch {
	
	public void testMethod(){
//		BufferedReader br = null;
		try(BufferedReader br = new BufferedReader(new FileReader("sample.txt"));) {
//			br = new BufferedReader(new FileReader("Sample.txt"));
			System.out.println("예외발생 ...");
			DriverManager.getConnection("");
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}/* catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/ 
		catch(IOException | SQLException e){
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}/* finally {
			System.out.println("반드시 실행됨 ...");
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
		
	}

	public static void main(String[] args) {
		// 
		
		new TestTryCatch().testMethod();

	}

}
