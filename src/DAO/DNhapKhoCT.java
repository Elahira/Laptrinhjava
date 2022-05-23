package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.NhapKho;
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
	public ArrayList<NhapKhoCT> getListHN(int manhap){
		
		ArrayList<NhapKhoCT> list = new ArrayList<>();
		String sql = "select MaNKCT, MaNK, TenHang, LoaiHang ,SoLuong,Tien from NhapKhoCT,HangHoa where HangHoa.MaHang = NhapKhoCT.MaHang and MaNK = ?";
		try {
			PreparedStatement ps = connectDB.conn.prepareStatement(sql);
			ps.setInt(1, manhap);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				NhapKhoCT nkct = new NhapKhoCT();
				nkct.setMaNKCT(rs.getInt("MaNKCT"));
				nkct.setMaNK(rs.getInt("MaNK"));
				nkct.setTenHang(rs.getString("TenHang"));
				nkct.setLoaiHang(rs.getString("LoaiHang"));
				nkct.setSoLuong(rs.getInt("SoLuong"));
				nkct.setTien(rs.getInt("Tien"));
				list.add(nkct);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
