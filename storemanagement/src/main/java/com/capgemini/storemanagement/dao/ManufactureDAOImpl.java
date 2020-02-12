package com.capgemini.storemanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.storemanagement.dto.Orders;
import com.capgemini.storemanagement.dto.Products;
import com.capgemini.storemanagement.dto.StoreUnit;
import com.capgemini.storemanagement.dto.Users;

public class ManufactureDAOImpl implements ManufactureDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Statement stmt = null;

	

	public boolean addDealer(Users dealer) {
		boolean isAdded = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/storemanagement?user=root&password=root";
			con = DriverManager.getConnection(dburl);
			String qry = " insert into  users_info  values (?,?,?,?,?,?)";
			pstmt = con.prepareStatement(qry);
			pstmt.setString(1, dealer.getUserId());
			pstmt.setString(2, dealer.getEmail());
			pstmt.setString(3, dealer.getLocation());
			pstmt.setString(4, dealer.getPassword());
			pstmt.setString(5, dealer.getRole());
			pstmt.setString(6, dealer.getUserName());
			int r = pstmt.executeUpdate();
			System.out.println(r);

			if (r != 0) {
				isAdded = true;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return isAdded;
	}

	public boolean modifyDealer(String userId,Users user) {
		boolean isModified=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/storemanagement?user=root&password=root";
			Connection con = DriverManager.getConnection(dburl);

			String qry =  "update users_info set userName=?,location=?,password=? where userId='" + userId + "' ";
			pstmt = con.prepareStatement(qry);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			int n=pstmt.executeUpdate();
			if(n!=0)
				isModified=true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isModified;
	}

	public boolean removeDealer(String dealerId) {
          boolean  isRemoved=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/storemanagement?user=root&password=root";
			con = DriverManager.getConnection(dburl);
			String qry = "delete from users_info where userId=?";
			pstmt = con.prepareStatement(qry);
			pstmt.setString(1, dealerId);
			int n = pstmt.executeUpdate();
			
			if(n!=0)
				isRemoved=true;
			
		} catch (Exception e) {

			e.getMessage();
		}
		return isRemoved;
	}

	public List<String> viewAllDealers(String role) {
		List<String> manufactures = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/storemanagement?user=root&password=root";
			Connection con = DriverManager.getConnection(dburl);
			String qry = "select * from users_info where role='" + role + "' ";
			pstmt = con.prepareStatement(qry);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				manufactures.add(rs.getString("userName"));

			}
		} catch (Exception e) {

			e.getMessage();
		}

		return manufactures;

	}

	public boolean addProduct(Products product) {
		boolean isAdded = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/storemanagement?user=root&password=root";
			con = DriverManager.getConnection(dburl);
			String qry = " insert into  product_details  values (?,?,?,?,?)";
			pstmt = con.prepareStatement(qry);
			pstmt.setInt(1, product.getProductId());
			pstmt.setString(2, product.getBrand());
			pstmt.setDouble(3, product.getPrice());
			pstmt.setInt(4, product.getStocks());
			pstmt.setString(5, product.getWarranty());

			int r = pstmt.executeUpdate();
			System.out.println(r);

			if (r != 0) {
				isAdded = true;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return isAdded;

	}

	public boolean modifyProduct(int productId,Products product) {
		boolean isUpdate=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/storemanagement?user=root&password=root";
			Connection con = DriverManager.getConnection(dburl);

			String qry =  "update product_details set price=?,warranty=? where productId='" + productId + "' ";
			pstmt = con.prepareStatement(qry);
			pstmt.setDouble(1, product.getPrice());
			pstmt.setString(2, product.getWarranty());
			
			int n=pstmt.executeUpdate();
			if(n!=0)
				isUpdate=true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isUpdate;
	}

	public boolean removeProduct(Integer productId) {
		boolean isDeleted=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/storemanagement?user=root&password=root";
			con = DriverManager.getConnection(dburl);
			String qry = "delete from product_details where productId=?";
			pstmt=con.prepareStatement(qry);
			pstmt.setInt(1, productId);
			int n=pstmt.executeUpdate();
			if(n!=0)
				isDeleted=true;
		} catch (Exception e) {

			e.getMessage();
		}
		return isDeleted;

	}

	public List<String> viewAllProducts() {
		List<String> productlist = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/storemanagement?user=root&password=root";
			Connection con = DriverManager.getConnection(dburl);

			String qry = "select * from product_details";
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(qry);

			while (rs.next()) {
				productlist.add(rs.getString("brand"));
			}
		} catch (Exception e) {

			e.getMessage();
		}
		return productlist;

	}

	public List<String> viewAllOrders() {
		List<String> productlist = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/storemanagement?user=root&password=root";
			Connection con = DriverManager.getConnection(dburl);

			String qry = "select * from order_details";
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(qry);

			while (rs.next()) {
				productlist.add(rs.getString("userId"));
				productlist.add(rs.getString("referenceId"));
				productlist.add(rs.getString("location"));

			}
		} catch (Exception e) {

			e.getMessage();
		}
		return productlist;

	}

	public List<String> viewStore() {

		List<String> productlist = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/storemanagement?user=root&password=root";
			Connection con = DriverManager.getConnection(dburl);

			String qry = "select * from storeunit";
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(qry);

			while (rs.next()) {
				productlist.add(rs.getString("storeId"));
				productlist.add(rs.getString("minimumStockMantain"));
				productlist.add(rs.getString("no_of_items"));

			}
		} catch (Exception e) {

			e.getMessage();
		}
		return productlist;

	}

}
