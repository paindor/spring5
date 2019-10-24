package com.hanrabong.web.cust;

import org.springframework.stereotype.Repository;

@Repository
public interface HCustMapper {

	public HCust selectCustById(HCust param);
	public void insertUser(HCust param);
	public int existId(String cid);
	
	
}
