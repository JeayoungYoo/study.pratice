package practice4;

import java.io.*;
import java.util.*;

public class TestProperties {
	

	public static void main(String[] args) {
		TestProperties tp = new TestProperties();
		tp.printConsole(readFile());
	}

	public static Student[] readFile() {
		HashMap hm = new HashMap();
		FileReader fr;
		Properties prop = new Properties();
		try {
			prop.load(fr = new FileReader("score.txt"));

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Student[] st = new Student[prop.size()];
		Iterator iter = prop.keySet().iterator();
		while (iter.hasNext()) {
			hm.put(iter.next(), prop.getProperty((String)iter.next()));
			String[] inputValue = prop.getProperty((String)iter.next()).split(",");

			int i = 0;
			st[i] = new Student();
			st[i].setSno(Integer.parseInt(key));
			while (true) {
				int j = 1;
				st[i].setSname(inputValue[j++]);
				st[i].setKor(Integer.parseInt(inputValue[j++]));
				st[i].setEng(Integer.parseInt(inputValue[j++]));
				st[i].setMat(Integer.parseInt(inputValue[j]));
				st[i].setTot(st[i].getKor() + st[i].getEng() + st[i].getMat());
				st[i].setAvg(st[i++].getTot() / 3);
				break;
			}
		}
		return st;

	}

	public void printConsole(Student[] sr) {
		int kTot=0, eTot=0, mTot=0;
		for (int i=0; i<sr.length; i++){
			System.out.println(sr[i]);
			kTot += sr[i].getKor();
			eTot += sr[i].getEng();
			mTot += sr[i].getMat();
		}
		System.out.println("국어점수 합계 : " + kTot + "\t평균 점수 : " + kTot/sr.length);
		System.out.println("영어점수 합계 : " + eTot + "\t평균 점수 : " + eTot/sr.length);
		System.out.println("수학점수 합계 : " + mTot + "\t평균 점수 : " + mTot/sr.length);
		
		
	}

	public void saveXMLFile(Student[] sr) {
		Properties prop = new Properties();
		try {
			prop.storeToXML(new FileOutputStream("student.xml"), "score.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
