package com.hanrabong.web.brd;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hanrabong.web.cmm.IConsumer;
import com.hanrabong.web.cmm.IFunction;
import com.hanrabong.web.cmm.IPredicate;
import com.hanrabong.web.cmm.ISupply;
import com.hanrabong.web.pxy.Proxy;
import com.hanrabong.web.pxy.ProxyMap;
import com.hanrabong.web.utl.Printer;

@RestController
@RequestMapping("/articles")
public class ArticleCtrl {
	private static final Logger logger = LoggerFactory.getLogger(ArticleCtrl.class);
	@Autowired Printer printer;
	@Autowired Article article;
	@Autowired ArticleMapper articleMapper;
	@Autowired List<Article>list;
	@Autowired Proxy pxy;
	@Autowired ProxyMap map;
	
	

	@PostMapping("/")
	public Map<?,?> createArticle(@RequestBody Article param) {
		//private static final Logger logger = LoggerFactory.getLogger()
		printer.accept("in the create" + param.getCid());
		
		IConsumer<Article> c=p->articleMapper.insertArticle(param);
				
		c.accept(param);
		
		
		ISupply<String> s =()-> articleMapper.selectCount();
		map.accept(Arrays.asList("msg", "count"),
				Arrays.asList("success", s.get()));
		
		
		return map.get();
		
	}
	
	@GetMapping("/count")
	public Map<?, ?> countArticle() {
		printer.accept("count진입");
		
		ISupply<String> s =()-> articleMapper.selectCount();
		
		map.accept(Arrays.asList("count"), Arrays.asList(s.get()));
		
	
			
		
		return map.get();
		
	}
	
	
	
	@GetMapping("/page/{pageNo}/size/{pageSize}")
	public Map<?,?> list(@PathVariable String pageNo , @PathVariable String pageSize){
		
		printer.accept("in the list");
		pxy.setPageNum(pxy.parseInt(pageNo));
		pxy.setPageSize(pxy.parseInt(pageSize));
		pxy.setStartRow(0);
		pxy.paging();
		ISupply<List<Article>> s =()-> articleMapper.selectAll(pxy);
		printer.accept("목록\n" + s.get());
		map.accept(Arrays.asList("articles", "pages" ,"pxy"),
				Arrays.asList(s.get(), Arrays.asList(1,2,3,4,5),pxy));
		return map.get();
		
		
	}
	
	@PutMapping("/{brdNum}")
	public Map<?, ?> updateArticle(@PathVariable String brdNum, 
			@RequestBody Article param) {
		printer.accept("in the update");
		IConsumer<Article>c=s-> articleMapper.updateAtricle(param);
		c.accept(param);
		printer.accept(param.getBrdNum());
		printer.accept(param.getContent());
	/*	map.clear();
		map.put("msg", "success");	*/
		return null;
		
		
	}
	@DeleteMapping("/{brdNum}")
	public Map<?, ?> deleteArticle(@PathVariable String brdNum, 
			@RequestBody Article param) {
		printer.accept("in the delete");

		IConsumer<Article> c = s-> articleMapper.deleteArticle(param);
		
		c.accept(param);
		
		//map.clear();
		//map.put("msg","success" );
		
		return null;
		
		
	}
	
}
