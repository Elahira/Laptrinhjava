package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.NhapKho;

public class DNhapKho {
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
}
