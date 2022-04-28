package Controller;

import java.sql.*;

public class ConnectDB {
	public static Connection conn;

	public static void connectDB() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String dbUrl = "jdbc:sqlserver://DESKTOP-AT03SVL\\SQLEXPRESS:1433;DatabaseName=QLKHO;encrypt=true;trustServerCertificate=true;";
			String username = "sa";
			String password = "123456";
			conn = DriverManager.getConnection(dbUrl, username, password);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		new ConnectDB();
	}

}