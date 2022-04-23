package Controller;

import java.sql.*;

//test kết nối database, không có dùng file này
public class ConnectDB {
	private Connection conn;

	public ConnectDB() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String dbUrl = "jdbc:sqlserver://DESKTOP-AT03SVL\\SQLEXPRESS:1433;DatabaseName=QLKHO;encrypt=true;trustServerCertificate=true;";
			String username = "sa";
			String password = "123456";
			conn = DriverManager.getConnection(dbUrl, username, password);

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select MaHang, TenHang, LoaiHang, TenNhaCC, Gia, SoLuong from HangHoa, NhaCungCap Where HangHoa.MaNCC = NhaCungCap.MaNCC");
			while (rs.next())
				System.out.println("mã hàng: " + rs.getInt("MaHang") + " Tên hàng: " + rs.getString("TenNhaCC")
						+ " Loại: " + rs.getString(3));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		new ConnectDB();
	}

}