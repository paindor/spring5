package com.hanrabong.web.aop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TxService {
	@Autowired TxMapper txMapper;
	@Autowired Proxy proxy;
	//@Autowired List<String> serviceList;

	
	
	
	@SuppressWarnings("unchecked")
	public List<?> crawling(Map<?,?> paramMap){
		List<String> serviceList = new ArrayList<>();
		
		serviceList.clear();
	
		serviceList = (List<String>)proxy.crawl(paramMap);
		return serviceList;
	}
}
