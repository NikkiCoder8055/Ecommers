package Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RegisterForm {
	PreparedStatement prs = null;
	Connection con = null;
	String CustomerName;
	String Email;
	String Pass;

	public void RegisterForm() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Customer Name: ");
		CustomerName = sc.next();
		System.out.println("Enter Your Email: ");
		Email = sc.next();
		System.out.println("Enter Your Password: ");
		Pass = sc.next();

		try {
			main mn = new main();
			con = mn.getConnection();

			prs = con.prepareStatement("insert into LoginForm (CustomerName,Email,Pass) values(?,?,?)");
			prs.setString(1, CustomerName);
			prs.setString(2, Email);
			prs.setString(3, Pass);

			int rs1 = prs.executeUpdate();
			System.out.println("Registered Successfully " + rs1);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
