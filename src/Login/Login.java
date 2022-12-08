package Login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.mysql.cj.protocol.Resultset;

public class Login extends RegisterForm {
	String Email;
	String PassNew;

	public void getLoginDetail() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Email: ");
		Email = sc.next();
		System.out.println("Enter Your Password: ");
		Pass = sc.next();
		try {
			main mn = new main();
			con = mn.getConnection();
			prs = con.prepareStatement("select * from LoginForm where Email=? and Pass=?");
			prs.setString(1, Email);
			prs.setString(2, Pass);
			ResultSet rs = prs.executeQuery();
			if (rs.next()) {
				rs.getString("Email");
				rs.getString("Pass");
				System.out.println("Login Successful...!");
			} else {
				System.out.println("Sorry!..Wrong Email and Password..!");
				
			}
			con.close();
			prs.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		RegisterForm reg = new RegisterForm();
		      reg.RegisterForm();
		Login login = new Login();
		login.getLoginDetail();
	}

}
