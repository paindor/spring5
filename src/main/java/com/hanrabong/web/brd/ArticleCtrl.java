package com.hanrabong.web.brd;

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
import com.hanrabong.web.cmm.ISupply;
import com.hanrabong.web.utl.Printer;

@RestController
@RequestMapping("/articles")
public class ArticleCtrl {
	private static final Logger logger = LoggerFactory.getLogger(ArticleCtrl.class);
	@Autowired Printer printer;
	@Autowired Map<String, Object>map;
	@Autowired Article article;
	@Autowired ArticleMapper articleMapper;
	@Autowired List<Article>list;
	
	
	

	@PostMapping("/")
	public Map<?,?> createArticle(@RequestBody Article param) {
		//private static final Logger logger = LoggerFactory.getLogger()
		printer.accept("in the create" + param.getCid());
		
		IConsumer<Article> c=p->articleMapper.insertArticle(param);
				
		c.accept(param);
		
		map.clear();
		map.put("msg", "success");
		ISupply<String> s =()-> articleMapper.selectCount();
		
		map.put("count", s.get());
		
		
		return map;
		
	}
	@GetMapping("/count")
	public Map<?, ?> countArticle() {
		printer.accept("count진입");
		
		ISupply<String> s =()-> articleMapper.selectCount();
		
		
		map.clear();
		map.put("count", s.get());
		 
			
		
		return map;
		
	}
	@GetMapping("/{brdNum}")
	public Article searchArticle(@PathVariable String brdNum ,
			@RequestBody Article param) {
		return null;
	}
	@GetMapping("/")
	public List<Article> list(){
		
		
		list.clear();
		ISupply<List<Article>> s =()-> articleMapper.selectAll();
		printer.accept("목록\n" + s.get());
		
		return s.get();
		
	}
	
	@PutMapping("/{brdNum}")
	public Map<?, ?> updateArticle(@PathVariable String brdNum, 
			@RequestBody Article param) {
		printer.accept("in the update");
		IConsumer<Article>c=s-> articleMapper.updateAtricle(param);
		c.accept(param);
		printer.accept(param.getBrdNum());
		printer.accept(param.getContent());
		map.clear();
		map.put("msg", "success");	
		return map;
		
		
	}
	@DeleteMapping("/{brdNum}")
	public Map<?, ?> deleteArticle(@PathVariable String brdNum, 
			@RequestBody Article param) {
		printer.accept("in the delete");

		IConsumer<Article> c = s-> articleMapper.deleteArticle(param);
		
		c.accept(param);
		
		map.clear();
		map.put("msg","success" );
		
		return map;
		
		
	}
	
}
