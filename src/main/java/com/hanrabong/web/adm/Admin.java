package com.hanrabong.web.adm;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.hanrabong.web.cust.HCust;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Admin{
	
	private String anum, aid, apw, aname, authority, part;
	
	
}
