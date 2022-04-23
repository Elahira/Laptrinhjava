package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.KhoHang;
import Model.NhaCungCap;

public class DKhoHang {
	private Connection conn;

	public DKhoHang() {
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

	// load data kho hàng
	public ArrayList<KhoHang> getListKho() {
		ArrayList<KhoHang> list = new ArrayList<>();
		String sql = "select MaKho, TenKho, STT from KhoHang";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				KhoHang kho = new KhoHang();
				kho.setMaKho(rs.getInt("MaKho"));
				kho.setTenKho(rs.getString("TenKho"));
				kho.setSTT(rs.getInt("STT"));
				list.add(kho);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// thêm kho hàng
	public boolean themKho(KhoHang kho) {
		String sql = "insert into KhoHang (TenKho, STT) values (?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, kho.getTenKho());
			ps.setInt(2, kho.getSTT());
			ps.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// xóa kho hàng
	public boolean xoaKho(int makho) {
		String sql = "delete from KhoHang where MaKho=?";
		try {
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setInt(1, makho);
			ps.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// sửa kho hàng
	public boolean suaKho(KhoHang kho) {
		String sql = "update KhoHang set TenKho = ?, STT = ? where MaKho = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, kho.getTenKho());
			ps.setInt(2, kho.getSTT());
			ps.setInt(3, kho.getMaKho());
			ps.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
