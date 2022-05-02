package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.XuatKho;

public class DXuatKho {
	ConnectDB connectDB = new ConnectDB();
	public ArrayList<XuatKho> getListXK() {
		ArrayList<XuatKho> list = new ArrayList<>();
		String sql = "select MaNK, NgayXuat, TongTien, MaKho from XuatKho";
		try {
			PreparedStatement ps = connectDB.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				XuatKho xk = new XuatKho();
				xk.setMaXK(rs.getInt("MaNK"));
				xk.setNgayXuat(rs.getString("NgayXuat"));
				xk.setTongTien(rs.getInt("TongTien"));
				xk.setMaKho(rs.getInt("MaKho"));
				
				list.add(xk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
