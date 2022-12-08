package com.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Login.main;

public class Products {
	PreparedStatement prs = null;
	Connection con = null;
	String Quantity;
	int Products_id;

//---------------------------------------------------------------------------	
	public void viewProduct() {
		try {
			main mn = new main();
			con = mn.getConnection();
			System.out.println();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Products_id :");
			Products_id = sc.nextInt();
			prs = con.prepareStatement("select Products_Quantity from Products where Product_id=?");
			prs.setInt(1, Products_id);
			ResultSet rs = prs.executeQuery();
			if (rs.next()) {
				System.out.println("Products_Quantity: " + rs.getString("Products_Quantity"));
			} else {
				System.out.println("not");
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	public static void main(String[] args) {
		Products pd = new Products();
		pd.viewProduct();
	}
}