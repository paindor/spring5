package com.hanrabong.web.pxy;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.hanrabong.web.brd.Article;
import com.hanrabong.web.brd.ArticleMapper;
import com.hanrabong.web.cmm.IFunction;
import com.hanrabong.web.cmm.ISupply;
import com.hanrabong.web.utl.Printer;

import lombok.Data;

@Component @Data @Lazy
public class Proxy {
	private int startRow, endRow , totalCount,
				pageCount, pageNum, pageSize, startPage, endPage, 
				nextBlock , prevBlock ,blockCount, blockNum	;
	private String search;
	private final int BLOCK_SIZE = 5;
	private boolean existPrv ,  next;
	private String sibl ;
	@Autowired Printer p;
	@Autowired ArticleMapper articleMapper;
	
	
	@SuppressWarnings("unused")
	public void paging() {
		ISupply<String> s =()->articleMapper.selectCount() ;
		
		int totalCount = Integer.parseInt(s.get());
		int pageCount = (totalCount% pageSize ==0 )?
				(totalCount/pageSize)  
				:(totalCount/pageSize)+1  ;
		
		startRow = (pageNum-1) *pageSize;
		
		endRow = (pageNum == pageCount) ? 
				totalCount -1
				: startRow + pageSize -1;
		int blockNum = (pageNum-1) /BLOCK_SIZE;
		
		int blockCount = (pageCount%BLOCK_SIZE== 0)?
				pageCount/BLOCK_SIZE: 
					(pageCount/BLOCK_SIZE)+1;
		
		
		int startPage = (blockNum *BLOCK_SIZE)+1;
		int endPage = (blockNum +1 != blockCount)? 
				startPage+(BLOCK_SIZE -1) :pageCount; 
		boolean exsitPrev = (blockNum != 0 );//|| );
		boolean exsitNext = (blockNum+1) != blockCount;
	
		nextBlock = startPage +BLOCK_SIZE;
		prevBlock = startPage -BLOCK_SIZE;
		
		
		
		
		/*pages = (endRow%endPage==0)? 
				for(int i = 0 ;i < pageCount; i++)temp.add(blockNum*BLOCK_SIZE +1) :
					for(int i = 0; i< endRow%endPage; i++)Arrays.asList(blockNum*BLOCK_SIZE+1) ;*/
		
		
		
		
	}
	public int parseInt(String param) {
		Function<String, Integer> f = s->Integer.parseInt(s);
		return f.apply(param);
		
	}
	public List<?> crawl(Map<?,?> paramMap){
		String url = "http://"+paramMap.get("site")+"/";
		p.accept("넘어온 URL \n"+url);
		List<String> proxyList = new ArrayList<>();
		proxyList.clear();
		try {
			Connection.Response response = Jsoup.connect(url)
			                                    .method(Connection.Method.GET)
			                                    .execute();
			Document document = response.parse();
			String text = document.html();
			//String text = document.text();
			p.accept("크롤링한 텍스트 \n"+text);
			proxyList.add(text);
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		return proxyList;
	}

	public int random(int start , int end) {
		
		BiFunction<Integer, Integer, Integer> f = (i,j) -> (int)(Math.random() *(j-i)) +i; 		
	
		return f.apply(start, end);
		
	}
	

}
