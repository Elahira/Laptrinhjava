package DAO;

import java.awt.desktop.AboutHandler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.HangHoa;

public class DHangHoa {
	
	ConnectDB connectDB = new ConnectDB();

	// load data hàng hóa
	public ArrayList<HangHoa> getListHH() {
		ArrayList<HangHoa> list = new ArrayList<>();
		String sql = "select MaHang, TenHang, LoaiHang, TenNhaCC, Gia from HangHoa, NhaCungCap Where HangHoa.MaNCC = NhaCungCap.MaNCC";
		try {
			PreparedStatement ps = connectDB.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				HangHoa hh = new HangHoa();
				hh.setMaHang(rs.getInt("MaHang"));
				hh.setTenHang(rs.getString("TenHang"));
				hh.setLoaiHang(rs.getString("LoaiHang"));
				hh.setTenNhaCC(rs.getString("TenNhaCC"));
				hh.setGia(rs.getInt("Gia"));
				list.add(hh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// thêm hàng hóa
	public boolean themHH(HangHoa hh) {
		String sql = "insert into HangHoa (TenHang, LoaiHang, MaNCC, Gia) values (?,?,?,?)";
		try {
			PreparedStatement ps = connectDB.conn.prepareStatement(sql);
			ps.setString(1, hh.getTenHang());
			ps.setString(2, hh.getLoaiHang());
			ps.setInt(3, hh.getMaNCC());
			ps.setInt(4, hh.getGia());
			ps.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// xóa hàng hóa
	public boolean xoaHH(int mahh) {
		String sql = "delete from HangHoa where MaHang=?";
		try {
			PreparedStatement ps = connectDB.conn.prepareCall(sql);
			ps.setInt(1, mahh);
			ps.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// sửa hàng hóa
	public boolean suaHH(HangHoa hh) {
		String sql = "update HangHoa set TenHang = ?, LoaiHang = ?, MaNCC = ?, Gia = ? where MaHang = ?";
		try {
			PreparedStatement ps = connectDB.conn.prepareStatement(sql);
			ps.setString(1, hh.getTenHang());
			ps.setString(2, hh.getLoaiHang());
			ps.setInt(3, hh.getMaNCC());
			ps.setInt(4, hh.getGia());
			ps.setInt(5, hh.getMaHang());
			ps.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
