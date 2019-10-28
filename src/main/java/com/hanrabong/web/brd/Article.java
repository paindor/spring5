package com.hanrabong.web.brd;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Article {

	private String brdNum, title , cid, adate, content , comment;
	
}
