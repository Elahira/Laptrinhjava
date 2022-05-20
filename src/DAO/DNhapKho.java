package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.NhapKho;
import DTO.NhapKhoCT;

public class DNhapKho {
	public static int temp;
	ConnectDB connectDB = new ConnectDB();
	
	public ArrayList<NhapKho> getListNK() {
		ArrayList<NhapKho> list = new ArrayList<>();
		String sql = "select MaNK, NgayNhap, TongTien, MaKho from NhapKho";
		try {
			PreparedStatement ps = connectDB.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				NhapKho nk = new NhapKho();
				nk.setMaNK(rs.getInt("MaNK"));
				temp = nk.getMaNK();
				nk.setNgayNhap(rs.getString("NgayNhap"));
				nk.setTongTien(rs.getInt("TongTien"));
				nk.setMaKho(rs.getInt("MaKho"));
				list.add(nk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public boolean nhapKho(NhapKho nk) {
		String sql = "insert into NhapKho ( NgayNhap, TongTien, MaKho) values (?,?,?)";
		try {
			PreparedStatement ps = connectDB.conn.prepareStatement(sql);
			ps.setString(1, nk.getNgayNhap());
			ps.setInt(2, nk.getTongTien());
			ps.setInt(3, nk.getMaKho());			
			ps.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	public boolean xoaNKho(int manhapkho) {
		String sql = "delete from NhapKho where MaNK=?";
		try {
			PreparedStatement ps = connectDB.conn.prepareCall(sql);
			ps.setInt(1, manhapkho);
			ps.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
