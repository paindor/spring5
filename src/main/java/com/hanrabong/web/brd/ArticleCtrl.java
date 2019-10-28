package com.hanrabong.web.brd;

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
import com.hanrabong.web.utl.Printer;

@RestController
@RequestMapping("/articles")
public class ArticleCtrl {
	private static final Logger logger = LoggerFactory.getLogger(ArticleCtrl.class);
	@Autowired Printer printer;
	@Autowired Map<String, Object>map;
	@Autowired Article article;
	@Autowired ArticleMapper articleMapper;
	
	

	@PostMapping("/")
	public Map<?,?> createArticle(@RequestBody Article param) {
		//private static final Logger logger = LoggerFactory.getLogger()
		printer.accept("in the create" + param.getCid());
		
		IConsumer<Article> c=p->articleMapper.insertArticle(param);
				
		c.accept(param);
		
		map.clear();
		map.put("msg", "success");
		
		
		return map;
		
	}
	@GetMapping("/{brdNum}")
	public Article updateArticle(@PathVariable String brdnum ,
			@RequestBody Article param) {
		return null;
	}
	
	@PutMapping("/{brdNum}")
	public String deleteArticle(@PathVariable String brdnum, 
			@RequestBody Article param) {
		return null;
		
		
	}
	@DeleteMapping("/{brdNum}")
	public String searchArticle(@PathVariable String brdnum, 
			@RequestBody Article param) {
		return null;
		
	}
	
}
