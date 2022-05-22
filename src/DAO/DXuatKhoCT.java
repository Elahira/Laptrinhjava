package DAO;

import java.sql.PreparedStatement;

import DTO.XuatKhoCT;

public class DXuatKhoCT {
	ConnectDB connectDB = new ConnectDB();
	public boolean xuatKhoCT(XuatKhoCT xkct) {
		String sql = "insert into XuatKhoCT (MaXK, MaHang, SoLuong, Tien) values (?,?,?,?)";
		try {
			PreparedStatement ps = connectDB.conn.prepareStatement(sql);
			ps.setInt(1, xkct.getMaXK());
			ps.setInt(2, xkct.getMaHang());
			ps.setInt(3, xkct.getSoLuong());
			ps.setInt(4, xkct.getTien());
			ps.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
