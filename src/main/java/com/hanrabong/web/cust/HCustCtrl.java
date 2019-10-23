package com.hanrabong.web.cust;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hanrabong.web.utl.Printer;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/hcust")
public class HCustCtrl {
	@Autowired Printer printer;
	@Autowired HCust hcust;
	

	@PostMapping("/")
	public Map<?, ?> join(@RequestBody HCust param) {
		
	//	logger.info("ajax 가 보낸아이디 와 비번 {}" , param.getCid() + ","+ param.getCpw());
		HashMap<String, String> map = new HashMap<>();
		printer.accept("람다 프린터가 출력한값"+param.getCid() );
		
		
		map.put("cid",param.getCid() );
		map.put("cpw",param.getCpw());
		map.put("cnum", param.getCnum());
		//custService.join(param);
		
		
		//logger.info("map의 아이디 비번{}" , map.get("cid") + "," + map.get("cpw"));
		
		//int count = empService.countEmp();
		
		//model.addAttribute("count" , count);
		
		return map;
		
		
	}
	@PostMapping("/login")
	public HCust login(@RequestBody HCust param) {
		
		//logger.info("ajax 가 보낸아이디 와 비번 {}" , param.getCid() + ","+ param.getCpw());
		//ashMap<String, String> map = new HashMap<>();
		
	//	cust.setCid(param.getCid());
		//cust.setCpw(param.getCpw());
		

		
		
		//int count = empService.countEmp();
		
		//model.addAttribute("count" , count);
		
	//	logger.info("user의 사용자 정보{}" ,cust.toString());
		return null;//custService.login(param);
			
		
	}
	


}
