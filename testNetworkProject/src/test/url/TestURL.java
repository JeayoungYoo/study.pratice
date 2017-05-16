package test.url;

import java.net.*;

public class TestURL {

	public static void main(String[] args) throws MalformedURLException {
		// URL Test
		URL url = new URL ("http://newsstand.naver.com/?list=ct1&pcode=055");
		
		System.out.println("프로토콜 : " + url.getProtocol());
		System.out.println("포트번호 : " + url.getPort());
		System.out.println("호스트명 : " + url.getHost());
		System.out.println("파일경로 : " + url.getFile());
		System.out.println("전체경로 : " + url.toExternalForm());
		System.out.println("쿼리스트링 : " + url.getQuery());
		
	}

}
