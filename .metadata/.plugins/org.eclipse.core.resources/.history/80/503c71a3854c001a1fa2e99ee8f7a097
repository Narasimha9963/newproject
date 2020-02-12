package com.capgemini.storemanagement.service;

import java.util.List;

import com.capgemini.storemanagement.dao.DealerDAO;
import com.capgemini.storemanagement.dto.Orders;
import com.capgemini.storemanagement.dto.Products;
import com.capgemini.storemanagement.dto.StoreUnit;
import com.capgemini.storemanagement.dto.Users;

public class DealerServiceImpl  implements DealerService{

	
	private DealerDAO dao; 

		
		@Override
		public List<String> loginDealer(String userId, String password) {
			return dao.loginDealer(userId, password);
		}


		@Override
		public boolean makeOrder(Orders order) {
			return dao.makeOrder(order);
		}


		@Override
		public boolean deleteOrder(Integer orderId) {
			return dao.deleteOrder(orderId);
		}


		@Override
		public List<String> showAllproducts() {
			return dao.showAllproducts();
		}


		@Override
		public List<Integer> viewMyStore(Integer storeId) {
			return dao.viewMyStore(storeId);
		}


		@Override
		public List<String> viewMyOrders(String userId) {
			return dao.viewMyOrders(userId);
		}
	
	

}
