package com.main;

import java.util.Scanner;

import Login.Login;
import Login.RegisterForm;

public class mainMethodCalls {

	public void runItems() {
		System.out.println("Welcome to E_com");
		System.out.println("You Have To register First then: "+"Press1");
		System.out.println("You Have An Account then for Login:"+"Press 2");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			RegisterForm reg = new RegisterForm();
			reg.RegisterForm();
			break;
		case 2:
			Login login = new Login();
			login.getLoginDetail();
		}
	}

	public static void main(String[] args) {
		mainMethodCalls calls = new mainMethodCalls();
		calls.runItems();
		
	}

}
