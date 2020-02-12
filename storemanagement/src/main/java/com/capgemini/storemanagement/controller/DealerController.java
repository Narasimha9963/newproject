package com.capgemini.storemanagement.controller;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.storemanagement.dao.DealerDAOImpl;
import com.capgemini.storemanagement.dto.Orders;

import com.capgemini.storemanagement.service.DealerService;
import com.capgemini.storemanagement.service.DealerServiceImpl;

public class DealerController {
	DealerService dealerService = new DealerServiceImpl();

	Logger log = Logger.getLogger("store");
	Scanner scan = new Scanner(System.in);

	void dealerTask() {

		int choice = 0;
		log.info("Welcome to Dealer's Page");
		log.info("1.Make Orders");
		log.info("2.Delete Orders");
		log.info("3.Show All Products");
		log.info("4.Show All Orders");
		log.info("5.Show My Store");
		log.info("6.Exit");

		do {
			log.info("************************");
			log.info("Enter Your Choice");
			log.info("************************");
			choice = scan.nextInt();
			switch (choice) {

			case 1:
				Orders od = new Orders();
				log.info("Enter reference id");
				int id = scan.nextInt();
				od.setOrderId(id);

				log.info("Enter location");
				String location = scan.next();
				od.setLocation(location);

				log.info("Enter orderId ");
				int orderId = scan.nextInt();
				od.setOrderId(orderId);

				log.info("Enter productId ");
				int pId = scan.nextInt();
				od.setProductId(pId);

				log.info("Enter Quantity ");
				int qty = scan.nextInt();
				od.setQuantity(qty);

				log.info("Enter UserId");
				String us = scan.next();
				od.setUserId(us);
				
				DealerDAOImpl dao = new DealerDAOImpl();
				boolean res = dealerService.makeOrder(od);
				if (res)
					log.info("Insert Succesfully");
				else
					log.info("Insertion Failed");
				break;

			case 2:
				log.info("Enter the orderId You want to Delete");
				int n = scan.nextInt();
				boolean resu = dealerService.deleteOrder(n);
				if (resu)
					log.info("OrderId is deleted Succesfully");
				else
					log.info("Deletion Failed");
				break;

			case 3:
				List<String> s = dealerService.showAllproducts();

				log.info(s);

				break;

			case 5:
				log.info("Enter the StoreId You want to See");

				int k = scan.nextInt();

				List<Integer> j = dealerService.viewMyStore(k);

				log.info(j);
				break;

			case 4:

				log.info("Enter the UserName for seeing Orders");

				String uname = scan.next();
				List<String> li = dealerService.viewMyOrders(uname);

				log.info(li);

				break;

			default:
				System.out.println("Invalid Choice...");
				break;

			}

		} while (choice != 4);
	}

}
