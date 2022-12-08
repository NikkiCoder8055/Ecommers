package com.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import Login.main;

public class productDetails {
	PreparedStatement prs = null;
	Connection con = null;
//	String Quantity;
	int Product_id;
	String Products_Name;

	public void ShowProductDetails() {

		try {
			main mn = new main();
			con = mn.getConnection();
			System.out.println();
			Scanner sc = new Scanner(System.in);
			System.out.println(" Products_Details :" + "Press1");
//		     Products_id = sc.nextInt();
			prs = con.prepareStatement("select * from Products");
//		     prs.setInt(1, Products_id);
			ResultSet rs = prs.executeQuery();
			while (rs.next()) {
				System.out.print("Products_Name: " + rs.getString("Products_Name") + " || ");
				System.out.print("Products_Description: " + rs.getString("Products_Description") + " || ");
				System.out.println("Products_Price: " + rs.getString("Products_Price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	    public void purchaseProduct() {
		Scanner sc = new Scanner(System.in);
		 Product_id = sc.nextInt();
		 Products_Name = sc.next();
		try {
			main mn = new main();
			con = mn.getConnection();
			prs = con.prepareStatement("select * from Products where Product_id=?");
			prs.setInt(1, Product_id);
//			prs.setString(2, Products_Name);
			ResultSet rs = prs.executeQuery();
			if (rs.next()) {
				System.out.println(1);
				rs.getString("Products_Name");
//				rs.getString("Pass");
				System.out.println("Products_Name: "+rs.getString("Products_Name"));
				System.out.println("Products_Description: "+rs.getString("Products_Description"));
				System.out.println("Products_Price: "+rs.getString("Products_Price"));
				
			} else {
				System.out.println("Sorry!..Put");
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		productDetails productDetails = new productDetails();
		productDetails.ShowProductDetails();
		productDetails.purchaseProduct();
	}

}
