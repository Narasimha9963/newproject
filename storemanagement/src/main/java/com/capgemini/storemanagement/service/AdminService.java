package com.capgemini.storemanagement.service;

import java.util.List;

import com.capgemini.storemanagement.dto.Users;

public interface AdminService {

	
	public boolean addManufactur(Users user);
	public boolean updateManufactur(String userId,Users user);
	public boolean deleteManufactur(String userId);
	public List<String> viewAllManufacturs();
	public String adminLogin(String uname, String password) throws Exception;

}
