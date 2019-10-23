package com.hanrabong.web.cust;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hanrabong.web.cmm.IConsumer;
import com.hanrabong.web.cmm.IFunction;
import com.hanrabong.web.utl.Printer;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/hcust")
public class HCustCtrl {
	@Autowired Printer printer;
	@Autowired HCust hcust;
	@Autowired HCustMapper custMapper;
	

	@PostMapping("/")
	public String join(@RequestBody HCust param) {
		
		//logger.info("ajax 가 보낸아이디 와 비번 {}");
		HashMap<String, String> map = new HashMap<>();
	/*	new IConsumer() {
			
			@Override
			public void accept(Object o) {
				custMapper.insertUser(param);
				
				
			}
		};*/

		IConsumer<HCust> ic = o ->custMapper.insertUser(param);
				
		ic.accept(param);
		
		
		
		
		return "success";
		
		
	}
	@PostMapping("/login")
	public HCust login(@RequestBody HCust param) {
		
		
		
		/*IFunction<HCust, HCust> f = new IFunction() {
			
			
			@Override
			public Object apply(Object o) {
				// TODO Auto-generated method stub
				
				return custMapper.selectCustById(param);
				
			}
		};*/
		
		

		IFunction<HCust, HCust> f =  o ->custMapper.selectCustById(param);
		
	
		return f.apply(param);
		
		
		
		
	}
		 
		
		 
		 
	

}
