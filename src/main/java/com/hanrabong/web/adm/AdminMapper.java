package com.hanrabong.web.adm;

import java.util.HashMap;

public interface AdminMapper {

	void insertAdmin(Admin param);

	Admin selectAdminByIdpw(Admin param);
	Admin selectAdmin(HashMap<?, ?> param);
	

}
