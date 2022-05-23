package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.NhapKhoCT;
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
public ArrayList<XuatKhoCT> getListHX(int maxuat){
		
		ArrayList<XuatKhoCT> list = new ArrayList<>();
		String sql = "select MaXKCT, MaXK, TenHang, LoaiHang ,SoLuong,Tien from XuatKhoCT,HangHoa where HangHoa.MaHang = XuatKhoCT.MaHang and MaXK = ?";
		try {
			PreparedStatement ps = connectDB.conn.prepareStatement(sql);
			ps.setInt(1, maxuat);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				XuatKhoCT xkct = new XuatKhoCT();
				xkct.setMaXKCT(rs.getInt("MaXKCT"));
				xkct.setMaXK(rs.getInt("MaXK"));
				xkct.setTenHang(rs.getString("TenHang"));
				xkct.setLoaiHang(rs.getString("LoaiHang"));
				xkct.setSoLuong(rs.getInt("SoLuong"));
				xkct.setTien(rs.getInt("Tien"));
				list.add(xkct);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
