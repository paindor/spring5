package com.hanrabong.web.test;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Crawler {
	public static void main(String[] args) {
		String url = "http://google.co.kr/";
		
		try {
			Connection.Response response = Jsoup.connect(url)
											.method(Connection.Method.GET)
											.execute();
			Document document = response.parse();
			String text = document.text();
			//text = document.html();
			System.out.println(text);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
