package com.hanrabong.web.adm;

import java.util.Map;

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
import com.hanrabong.web.utl.Printer;

@RestController
@RequestMapping("/admin")
public class AdminCtrl {
	@Autowired Admin admin;
	@Autowired Map<String, Object> map;
	@Autowired AdminMapper adminMapper;
	@Autowired Printer printer;
	
	
	@PostMapping("/")
	public Map<?, ?>register(@RequestBody Admin param) {
		printer.accept("reg 진입");
		IConsumer<Admin> c = t -> adminMapper.insertAdmin(param);
		c.accept(param);
		
		map.clear();
		map.put("msg", "success");
		return map;
		
	}
	
	@PostMapping("/{aid}")
	public Map<?, ?> access(@PathVariable String aid ,@RequestBody Admin param){
		printer.accept("access 진입");
		IFunction<Admin, Admin> f = t -> adminMapper.selectAdminByIdpw(param);
		
		map.clear();
		map.put("msg",(f.apply(param)!= null)? "success" : "fail" );
		return map;
		
		
	}
	
	@GetMapping("/{aid}")
	public String searchAdmin(@PathVariable String aid ,@RequestBody Admin param) {
		//
		return "";
		
	}
	@PutMapping("/{aid}")
	public String updateAdmin(@PathVariable String aid) {
		return null;
		
	}
	@DeleteMapping("/{aid}")
	public String deleteAdmin(@PathVariable String aid) {
		return null;
		
	}

}
