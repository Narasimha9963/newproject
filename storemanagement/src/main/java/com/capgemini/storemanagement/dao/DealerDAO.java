package com.capgemini.storemanagement.dao;

import java.util.List;

import com.capgemini.storemanagement.dto.Orders;
import com.capgemini.storemanagement.dto.Products;
import com.capgemini.storemanagement.dto.StoreUnit;
import com.capgemini.storemanagement.dto.Users;

public interface DealerDAO {
	

	
	public boolean makeOrder(Orders order);
	public boolean deleteOrder(Integer orderId);
	public List<String> showAllproducts();
	public List<Integer> viewMyStore(Integer storeId);
	public List<String> viewMyOrders(String userId);

}
