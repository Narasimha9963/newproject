package com.capgemini.storemanagement.service;

import java.util.List;

import com.capgemini.storemanagement.dto.Orders;
import com.capgemini.storemanagement.dto.Products;
import com.capgemini.storemanagement.dto.StoreUnit;
import com.capgemini.storemanagement.dto.Users;

public interface ManufactureService {

	
	public boolean addDealer(Users dealer);
	public boolean modifyDealer(String userId,Users user);
	public boolean removeDealer(String dealerId);
	public List<String> viewAllDealers(String role);
	
	public boolean addProduct(Products product);
	public boolean modifyProduct(int productId,Products product);
	public boolean removeProduct(Integer productId);
	public List<String> viewAllProducts();
	
	public List<String> viewAllOrders();
	public List<String> viewStore(); 
	

}
