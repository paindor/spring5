package com.hanrabong.web.brd;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface ArticleMapper {
	public void insertArticle(Article param);
	public String selectCount();
	public List<Article> selectAll();
	public void deleteArticle(Article param);
	public void updateAtricle(Article param);
	
	

}
