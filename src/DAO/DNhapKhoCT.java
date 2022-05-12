package DAO;

import java.sql.PreparedStatement;

import DTO.NhapKhoCT;

public class DNhapKhoCT {
	ConnectDB connectDB = new ConnectDB();
	public boolean nhapKhoCT(NhapKhoCT nkct) {
		String sql = "insert into NhapKhoCT (MaNK, MaHang, SoLuong, Tien) values (?,?,?,?)";
		try {
			PreparedStatement ps = connectDB.conn.prepareStatement(sql);
			ps.setInt(1, nkct.getMaNK());
			ps.setInt(2, nkct.getMaHang());
			ps.setInt(3, nkct.getSoLuong());
			ps.setInt(4, nkct.getTien());
			ps.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
