package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class main {
	Connection connection=null;
	  public Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = 
	DriverManager.getConnection("jdbc:mysql://localhost:3306/E_com", "root", "root");
			
				
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
         	}
		return connection;
	  }  
    public static void main(String[] args) {
    	
    }

}
