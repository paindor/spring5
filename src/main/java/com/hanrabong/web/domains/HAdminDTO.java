package com.hanrabong.web.domains;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;


@Data @Component
public class HAdminDTO implements Serializable{
	private static final long serialVersionUID= 1L;
	
	private String anum, aid, apw, aname, authority, part;
	
	
}
