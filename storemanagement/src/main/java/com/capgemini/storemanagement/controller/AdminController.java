package com.capgemini.storemanagement.controller;


import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;

import com.capgemini.storemanagement.dao.AdminDAOImpl;
import com.capgemini.storemanagement.dto.Users;
import com.capgemini.storemanagement.factory.Factory;
import com.capgemini.storemanagement.service.AdminService;
import com.capgemini.storemanagement.service.AdminServiceImpl;

public class AdminController {
	static AdminService adminService = new AdminServiceImpl();
	AdminDAOImpl dao = new AdminDAOImpl();

	static Logger log = Logger.getLogger("store");
	static Scanner scan = new Scanner(System.in);

	public static String adminLogin() throws Exception {
		boolean isSuccess=false;
		log.info("UserName");
		String uname = scan.next();
		log.info("enter password");
		String password = scan.next();

		String user=adminService.adminLogin(uname, password);
		
		return user;
	
	}

	void adminTask() {
		int choice = 0;

		log.info("Welcome to Admin's Page");
		log.info("1.Add Manufactures");
		log.info("2.Update Manufactures");
		log.info("3.Delete Manufactures");
		log.info("4.Show Manufactures");
		log.info("5.Exit");

		do {

			log.info("************************");
			log.info("Enter Your Choice");
			log.info("************************");
			choice = scan.nextInt();
			switch (choice) {

			case 1:

				Users user = new Users();
				log.info("Enter the UserId");
				String userId = scan.next();
				user.setUserId(userId);

				log.info("Enter the Email");
				String Email = scan.next();
				user.setEmail(Email);

				log.info("Enter the Location");
				String Location = scan.next();
				user.setLocation(Location);

				log.info("Enter the Password");
				String password = scan.next();
				user.setPassword(password);

				log.info("Enter the Role");
				String role = scan.next();
				user.setRole(role);

				log.info("Enter the UserName");
				String uname = scan.next();
				user.setUserName(uname);

				// dao.addManufactur(user);
				boolean u = adminService.addManufactur(user);
				if (u)
					log.info("Insert Succesfully");
				break;

			case 2:
				Users user1 = new Users();
				log.info("Enter the User_ID You want to Update");
				String id = scan.next();

				log.info("Enter the Username");
				String name = scan.next();
				user1.setUserName(name);

				log.info("Enter the Password");
				String pass = scan.next();
				user1.setPassword(pass);

				log.info("Enter the email");
				String emailid = scan.next();
				user1.setEmail(emailid);

				// dao.updateManufactur(id,user1);
				boolean res = adminService.updateManufactur(id, user1);
				if (res)

					log.info("Record has been updated Successfully!!!");
				else
					log.info("Record has not updated");
				break;

			case 3:
				log.info("Enter the UserId(String) You want to Delete");
				String userid = scan.next();

				boolean d = adminService.deleteManufactur(userid);
				if (d)
					log.info("User_Id is deleted Succesfully");
				else
					log.info("UserID not found");
				break;

			case 4:
				log.info("--------------Manufacturer's Info----------------");
				List<String> li = adminService.viewAllManufacturs();

				log.info(li);
				break;

			default:
				System.out.println("Invalid Choice...");
				break;

			}

		} while (choice != 5);
	}

	public List<String> login() {

		return null;
	}

}
