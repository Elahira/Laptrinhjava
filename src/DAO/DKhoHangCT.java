package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.KhoHang;
import DTO.KhoHangCT;
import DTO.NhapKhoCT;

public class DKhoHangCT {
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
		String sql = "update KhoHangCT set  SoLuong = ? where MaKho = ?";
		try {
			PreparedStatement ps = connectDB.conn.prepareStatement(sql);
			ps.setInt(4, khct.getSoLuong());			
			ps.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	public boolean isCheck(KhoHangCT khct) {
		String sql = "select * from  KhoHangCT where MaHang = ? and MaKho =?";		
		try {
			PreparedStatement ps = connectDB.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			khct.setMaKho(rs.getInt("MaKho"));
			khct.setSoLuong(rs.getInt("SoLuong"));
			
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
