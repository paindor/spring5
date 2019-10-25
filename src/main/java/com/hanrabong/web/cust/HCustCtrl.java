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
import com.hanrabong.web.cmm.IPredicate;
import com.hanrabong.web.utl.Printer;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/hcust")
public class HCustCtrl {
	@Autowired Printer printer;
	@Autowired HCust hcust;
	@Autowired HCustMapper hcustMapper;
	@Autowired Map<String, Object> map;
	
	@GetMapping("/{cid}/exist")
	public Map<?,?> exsistId(@PathVariable String cid){
		printer.accept("in the exist ");
		IFunction<String, Integer>p = o-> hcustMapper.existId(cid);
		
		map.put("msg",  (p.apply(cid)== 0)? "success" : "fail");
		printer.accept("exist " + cid);
		return map;
		
	}
	
	

	@PostMapping("/")
	public Map<?, ?> join(@RequestBody HCust param) {
		
		printer.accept("in the join");

		printer.accept("param  " + param.getCid());

		IConsumer<HCust> ic = o -> hcustMapper.insertUser(param);

		map.clear();
		map.put("msg", "success");
		ic.accept(param);
		printer.accept("param  " + param.getCid());

		return map;

	}
	@PostMapping("/{cid}")
	public HCust login(@PathVariable String cid, @RequestBody HCust param) {



		printer.accept("in the login");
		
		IFunction<HCust, HCust> f =  o ->hcustMapper.selectCustById(param);
		
		printer.accept("login " +param.getCid());
		hcust = f.apply(param);
		printer.accept(hcust.getCid());
		return hcust;
		
		
		
		
	}
	@GetMapping("/{cid}")
	public HCust searchUser(@PathVariable String uid,@RequestBody HCust param) {
		IFunction<HCust, HCust> f = t->hcustMapper.selectCustById(param);
		return f.apply(param);
		
	}
	@PutMapping("/{cid}")
	public String updateUser(@PathVariable String uid,@RequestBody HCust param) {
		return null;
		
	}
	@DeleteMapping("/{uid}")
	public String removeUser(@PathVariable String uid,@RequestBody HCust param) {
		return null;
		
	}
	
	
	
	
		 
		
		 
		 
	

}
