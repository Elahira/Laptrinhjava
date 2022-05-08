package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.KhoHangCT;

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

}
