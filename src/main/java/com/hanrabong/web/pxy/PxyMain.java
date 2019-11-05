package com.hanrabong.web.pxy;

import java.util.Scanner;

import javax.swing.JOptionPane;

import org.springframework.core.env.JOptCommandLinePropertySource;

public class PxyMain {

	public static void main(String[] args) {
		
		int pageSize= 0;
		int pageNum = 0;
		int totalCount =22;
		int pageCount = (totalCount% pageSize ==0 )?
				(totalCount/pageSize)  
				:(totalCount/pageSize)+1  ;
		
		int startRow = (pageNum-1) *pageSize;
		
		int endRow = (pageNum%10 ==4 || pageNum%10 ==9) ? 
				(pageNum * pageSize) -1
				: totalCount;
		System.out.println(endRow);
		System.out.println(startRow);

	}

}
