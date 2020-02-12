package com.capgemini.storemanagement.factory;

import com.capgemini.storemanagement.dao.AdminDAO;
import com.capgemini.storemanagement.dao.AdminDAOImpl;
import com.capgemini.storemanagement.dto.Users;

public class Factory {
	
	private Factory() {
		
	}
	
	public static AdminDAO  getAdmDao() {
		
		AdminDAO sdao=new AdminDAOImpl();
		return sdao;
	}
	
	public static Users getUsers() {
		
		Users user=new Users();
		return user;
		
		
	}

}
