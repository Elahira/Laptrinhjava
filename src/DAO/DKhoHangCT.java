package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.KhoHang;
import DTO.KhoHangCT;
import DTO.NhapKho;
import DTO.NhapKhoCT;

public class DKhoHangCT {
	public static int temp;
	ConnectDB connectDB = new ConnectDB();

	// load data kho hàng
	public ArrayList<KhoHangCT> getListKhoct(int makho) {
		ArrayList<KhoHangCT> list = new ArrayList<>();
		String sql = "select MaKhoCT, KhoHangCT.MaKho, KhoHangCT.MaHang, TenHang, LoaiHang, Gia, TenKho, SoLuong from KhoHangCT, KhoHang, HangHoa where KhoHangCT.MaKho = KhoHang.MaKho and KhoHangCT.MaHang = HangHoa.MaHang and KhoHangCT.MaKho = ?";
		try {
			PreparedStatement ps = connectDB.conn.prepareStatement(sql);
			ps.setInt(1, makho);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				KhoHangCT khoct = new KhoHangCT();
				khoct.setMaKhoCT(rs.getInt("MaKhoCT"));
				khoct.setMaKho(rs.getInt("MaKho"));
				khoct.setMaHang(rs.getInt("MaHang"));
				khoct.setSoLuong(rs.getInt("SoLuong"));
				khoct.setTenKho(rs.getString("TenKho"));
				khoct.setTenHang(rs.getString("TenHang"));
				khoct.setLoaiHang(rs.getString("LoaiHang"));
				khoct.setGia(rs.getInt("Gia"));
				list.add(khoct);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<KhoHangCT> getListUpTable() {
		ArrayList<KhoHangCT> list = new ArrayList<>();
		String sql = "select TenKho, KhoHangCT.MaHang, TenHang, LoaiHang, Gia,  SoLuong from KhoHangCT,  HangHoa,KhoHang where  KhoHangCT.MaHang = HangHoa.MaHang and KhoHangCT.MaKho = KhoHang.MaKho";
		try {
			PreparedStatement ps = connectDB.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				KhoHangCT khoct = new KhoHangCT();
				khoct.setTenKho(rs.getString("TenKho"));
				khoct.setMaHang(rs.getInt("MaHang"));
				khoct.setTenHang(rs.getString("TenHang"));
				khoct.setLoaiHang(rs.getString("LoaiHang"));
				khoct.setGia(rs.getInt("Gia"));
				khoct.setSoLuong(rs.getInt("SoLuong"));
				list.add(khoct);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public boolean nhapKho(KhoHangCT khct) {
		String sql = "insert into KhoHangCT (MaKho, MaHang, SoLuong) values (?,?,?)";
		try {
			PreparedStatement ps = connectDB.conn.prepareStatement(sql);
			ps.setInt(1, khct.getMaKho());
			ps.setInt(2, khct.getMaHang());
			ps.setInt(3, khct.getSoLuong());
			ps.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	public boolean nhapSL(KhoHangCT khct) {
		String sql = "update KhoHangCT set  SoLuong = ? where MaKho = ? and MaHang = ?";
		try {
			PreparedStatement ps = connectDB.conn.prepareStatement(sql);
			ps.setInt(1, khct.getSoLuong());
			ps.setInt(2, khct.getMaKho());
			ps.setInt(3, khct.getMaHang());
			ps.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	public boolean isCheck(int n, int m) {
		String sql = "select * from  KhoHangCT where MaKho = ? and MaHang =?";		
		try {
			PreparedStatement ps = connectDB.conn.prepareStatement(sql);
			ps.setInt(1, n);
			ps.setInt(2, m);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				KhoHangCT khct = new KhoHangCT();
				khct.setSoLuong(rs.getInt("SoLuong"));
				temp = khct.getSoLuong();
				return true;
			}else {
				return false;
			}			
		} catch (Exception e) {			
			return false;
		}		
	}
	public boolean xoaHTK(int mahang, int makho) {
		String sql = "delete from KhoHangCT where MaHang=? and MaKho = ?";
		try {
			PreparedStatement ps = connectDB.conn.prepareCall(sql);
			ps.setInt(1, mahang);
			ps.setInt(2, makho);
			ps.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
