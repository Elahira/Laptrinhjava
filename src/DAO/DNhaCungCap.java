package DAO;

import java.sql.*;
import java.util.ArrayList;

import DTO.NhaCungCap;

public class DNhaCungCap {
	ConnectDB connectDB = new ConnectDB();

	// load data nhà cung cấp
	public ArrayList<NhaCungCap> getListNCC() {
		ArrayList<NhaCungCap> list = new ArrayList<>();
		String sql = "select MaNCC, TenNhaCC, SDT, DiaChi, Email from NhaCungCap";
		try {
			PreparedStatement ps = connectDB.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				NhaCungCap ncc = new NhaCungCap();
				ncc.setMaNCC(rs.getInt("MaNCC"));
				ncc.setTenNhaCC(rs.getString("TenNhaCC"));
				ncc.setSDT(rs.getString("SDT"));
				ncc.setDiaChi(rs.getString("DiaChi"));
				ncc.setEmail(rs.getString("Email"));
				list.add(ncc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// thêm nhà cung cấp
	public boolean themNCC(NhaCungCap ncc) {
		String sql = "insert into NhaCungCap (TenNhaCC, SDT, DiaChi, Email) values (?,?,?,?)";
		try {
			PreparedStatement ps = connectDB.conn.prepareStatement(sql);
			ps.setString(1, ncc.getTenNhaCC());
			ps.setString(2, ncc.getSDT());
			ps.setString(3, ncc.getDiaChi());
			ps.setString(4, ncc.getEmail());
			ps.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// xóa nhà cung cấp
	public boolean xoaNCC(int mancc) {
		String sql = "delete from NhaCungCap where MaNCC=?";
		try {
			PreparedStatement ps = connectDB.conn.prepareCall(sql);
			ps.setInt(1, mancc);
			ps.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// sửa nhà cung cấp
	public boolean suaNCC(NhaCungCap ncc) {
		String sql = "update NhaCungCap set TenNhaCC = ?, SDT = ?, Email = ?, DiaChi = ? where MaNCC = ?";
		try {
			PreparedStatement ps = connectDB.conn.prepareStatement(sql);
			ps.setString(1, ncc.getTenNhaCC());
			ps.setString(2, ncc.getSDT());
			ps.setString(3, ncc.getEmail());
			ps.setString(4, ncc.getDiaChi());
			ps.setInt(5, ncc.getMaNCC());
			ps.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// lấy id nhà cung cấp dựa vào tên nhà cung cấp
	public int getmaNCC(String tenncc) {
		int id = 0;
		String sql = "select MaNCC from NhaCungCap where TenNhaCC = ?";
		try {
			PreparedStatement ps = connectDB.conn.prepareStatement(sql);
			ps.setString(1, tenncc);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

}
