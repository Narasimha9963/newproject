package com.capgemini.storemanagement.util;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.storemanagement.controller.AdminController;

public class Validation {
	
	static Logger log=LogManager.getLogger("store");
	
	public static boolean passwordValidation(String userName,String password) {
		
		AdminController  admin=new AdminController();
		List<String> login=admin.login();
		String adminName=login.get(0);
		String password1=login.get(1);
		log.info(adminName);
		log.info(password);
		if(userName.equals(adminName)) {
			return true;
		}
		
		return false;
		
	}

}
