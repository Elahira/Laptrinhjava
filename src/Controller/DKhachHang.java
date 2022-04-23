package Controller;

import java.sql.*;
import java.util.ArrayList;

import Model.KhachHang;
import Model.NhaCungCap;

public class DKhachHang {
	private Connection conn;

	public DKhachHang() {
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

	// load data khách hàng
	public ArrayList<KhachHang> getListKH() {
		ArrayList<KhachHang> list = new ArrayList<>();
		String sql = "select MaKH, TenKH, SDT, Email, DiaChi from KhachHang";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				KhachHang kh = new KhachHang();
				kh.setMaKH(rs.getInt("MaKH"));
				kh.setTenKH(rs.getString("TenKH"));
				kh.setSDT(rs.getString("SDT"));
				kh.setDiaChi(rs.getString("DiaChi"));
				kh.setEmail(rs.getString("Email"));
				list.add(kh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// thêm khách hàng
	public boolean themKH(KhachHang kh) {
		String sql = "insert into KhachHang (TenKH, SDT, DiaChi, Email) values (?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, kh.getTenKH());
			ps.setString(2, kh.getSDT());
			ps.setString(3, kh.getDiaChi());
			ps.setString(4, kh.getEmail());
			ps.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// xóa khách hàng
	public boolean xoaKH(int makh) {
		String sql = "delete from KhachHang where MaKH=?";
		try {
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setInt(1, makh);
			ps.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// sửa khách hàng
	public boolean suaKH(KhachHang kh) {
		String sql = "update KhachHang set TenKH = ?, SDT = ?, Email = ?, DiaChi = ? where MaKH = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, kh.getTenKH());
			ps.setString(2, kh.getSDT());
			ps.setString(3, kh.getEmail());
			ps.setString(4, kh.getDiaChi());
			ps.setInt(5, kh.getMaKH());
			ps.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
