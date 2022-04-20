package Controller;

import java.sql.*;

public class ConnectDB {
	private Connection conn;
	
	public ConnectDB() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String dbUrl = "jdbc:sqlserver://DESKTOP-AT03SVL\\SQLEXPRESS:1433;DatabaseName=QLKHO;encrypt=true;trustServerCertificate=true;";	
			String username = "sa"; String password= "123456";
			conn=DriverManager.getConnection(dbUrl, username, password);
			
			Statement stmt=conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM HangHoa");
			while(rs.next())
				System.out.println("mã hàng: " + rs.getInt(1) + " Tên hàng: " + rs.getString(2) + " Loại: " + rs.getString(3));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		new ConnectDB();
	}

}