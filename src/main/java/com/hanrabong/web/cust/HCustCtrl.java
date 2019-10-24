package com.hanrabong.web.cust;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	@Autowired HCustMapper hcustMapper;
	

	@PostMapping("/")
	public String join(@RequestBody HCust param) {
		


	IConsumer<HCust> ic = o ->hcustMapper.insertUser(param);
				
		ic.accept(param);
		
		
		
		
		return "success";
		
		
	}
	@PostMapping("/{uid}")
	public HCust login(@PathVariable String uid, @RequestBody HCust param) {



		IFunction<HCust, HCust> f =  o ->hcustMapper.selectCustById(param);
		
	
		return f.apply(param);
		
		
		
		
	}
	@GetMapping("/{uid}")
	public HCust searchUser(@PathVariable String uid,@RequestBody HCust param) {
		IFunction<HCust, HCust> f = t->hcustMapper.selectCustById(param);
		return f.apply(param);
		
	}
	@PutMapping("/{uid}")
	public String updateUser(@PathVariable String uid,@RequestBody HCust param) {
		return null;
		
	}
	@DeleteMapping("/{uid}")
	public String removeUser(@PathVariable String uid,@RequestBody HCust param) {
		return null;
		
	}
	
	
		 
		
		 
		 
	

}
