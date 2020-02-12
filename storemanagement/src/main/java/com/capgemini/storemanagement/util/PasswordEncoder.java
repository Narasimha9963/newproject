package com.capgemini.storemanagement.util;

import java.util.Scanner;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncoder {
	
	public static String passwordEncoder(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}
	public static void main(String[] args) {
		
		Scanner scn=new Scanner(System.in);
		System.out.println("enter the passowrd encoded");
		String pass=scn.nextLine();
		String s=passwordEncoder(pass);
		System.out.println(s);
		scn.close();
		
	}

}
