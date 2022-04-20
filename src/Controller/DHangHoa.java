package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Model.HangHoa;

public class DHangHoa {
	private Connection conn;
	
	public DHangHoa() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String dbUrl = "jdbc:sqlserver://DESKTOP-AT03SVL\\SQLEXPRESS:1433;DatabaseName=QLKHO;encrypt=true;trustServerCertificate=true;";	
			String username = "sa"; String password= "123456";
			conn=DriverManager.getConnection(dbUrl, username, password);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public ArrayList<HangHoa> getListHH(){
		ArrayList<HangHoa> list = new ArrayList<>();
		String sql = "select MaHang, TenHang, LoaiHang, TenNhaCC, Gia, SoLuong from HangHoa, NhaCungCap Where HangHoa.MaNCC = NhaCungCap.MaNCC";
		try {
			PreparedStatement ps =conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				HangHoa hh = new HangHoa();
				hh.setMaHang(rs.getInt("MaHang"));
				hh.setTenHang(rs.getString("TenHang"));
				hh.setLoaiHang(rs.getString("LoaiHang"));
				hh.setTenNhaCC(rs.getString("TenNhaCC"));
				hh.setGia(rs.getInt("Gia"));
				hh.setSoLuong(rs.getInt("SoLuong"));
				list.add(hh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String[] args) {
		new DHangHoa();
	}

}
