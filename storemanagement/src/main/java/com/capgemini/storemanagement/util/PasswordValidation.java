package com.capgemini.storemanagement.util;

import java.util.Scanner;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordValidation {
	public static boolean passwordValidation(String password,String hashedPassword) {
		return BCrypt.checkpw(password, hashedPassword);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter password");
		String plainpassword=sc.nextLine();
		String hashedpassword=PasswordEncoder.passwordEncoder(plainpassword);
		System.out.println(hashedpassword);
		System.out.println("enter the password to be matched");
		String password=sc.nextLine();
		if(passwordValidation(password,hashedpassword)) {
			System.out.println("password matches");
			
		}else {
			System.out.println("invalid");
		}
		sc.close();
		
	}

}
