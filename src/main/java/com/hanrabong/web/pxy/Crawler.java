package com.hanrabong.web.pxy;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {
	public static void main(String[] args) {
		
		//String url = "http://www.oliveyoung.co.kr/store/display/getMCategoryList.do?dispCatNo=100000100020001&fltDispCatNo=&prdSort=01&pageIdx="+i+"&rowsPerPage=24&searchTypeSort=btn_thumb&plusButtonFlag=N&isLoginCnt=5&aShowCnt=0&bShowCnt=0&cShowCnt=0";
		
	
		try {
			Elements name = null;
			Elements price = null;
			List<String> nameList = new ArrayList<>();
			List<String> priceList = new ArrayList<>();
			for(int i = 1; i < 16 ; i++) {
				Document rawdata = Jsoup.connect("http://www.oliveyoung.co.kr/store/display/getMCategoryList.do?dispCatNo=100000100020001&fltDispCatNo=&prdSort=01&pageIdx="+i+"")
                        .timeout(10*1000).get();
				name = rawdata.select("p[class=tx_name]");
				price = rawdata.select("span[class=tx_cur]");
				//System.out.println(name.toString());
				for(Element e : name) {
					nameList.add(e.text());
					
					
				}
				for(Element e : price) {
					priceList.add(e.text());
					
					
				}
			
			}
			
			
			System.out.println(nameList);
			System.out.println(priceList);
			System.out.println(nameList.size());
			System.out.println(priceList.size());
			
			
			//Document document = response.parse();
			//String html = document.html();
			//String text = document.text();
			//String text = document.text();
		
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
	
	

	}

}
