package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.KhoHang;
import DTO.NhaCungCap;

public class DKhoHang {
	ConnectDB connectDB = new ConnectDB();

	// load data kho hàng
	public ArrayList<KhoHang> getListKho() {
		ArrayList<KhoHang> list = new ArrayList<>();
		String sql = "select MaKho, TenKho, STT from KhoHang";
		try {
			PreparedStatement ps = connectDB.conn.prepareStatement(sql);
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
			PreparedStatement ps = connectDB.conn.prepareStatement(sql);
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
			PreparedStatement ps = connectDB.conn.prepareCall(sql);
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
			PreparedStatement ps = connectDB.conn.prepareStatement(sql);
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
