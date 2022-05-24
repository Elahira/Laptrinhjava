package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.NhapKho;
import DTO.XuatKho;

public class DXuatKho {
	public static int temp;
	ConnectDB connectDB = new ConnectDB();
	public ArrayList<XuatKho> getListXK() {
		ArrayList<XuatKho> list = new ArrayList<>();
		String sql = "select MaXK, NgayXuat, TongTien, TenKH,TenKho from XuatKho,KhoHang,KhachHang where XuatKho.MaKho=KhoHang.MaKho and XuatKho.MaKH = KhachHang.MaKH";
		try {
			PreparedStatement ps = connectDB.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				XuatKho xk = new XuatKho();
				xk.setMaXK(rs.getInt("MaXK"));
				temp = xk.getMaXK();
				xk.setNgayXuat(rs.getString("NgayXuat"));
				xk.setTongTien(rs.getInt("TongTien"));
				xk.setTenKH(rs.getString("TenKH"));
				xk.setTenKho(rs.getString("TenKho"));
				
				list.add(xk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public boolean xuatKho(XuatKho xk) {
		String sql = "insert into XuatKho ( NgayXuat, TongTien, MaKH, MaKho) values (?,?,?,?)";
		try {
			PreparedStatement ps = connectDB.conn.prepareStatement(sql);
			ps.setString(1, xk.getNgayXuat());
			ps.setInt(2, xk.getTongTien());
			ps.setInt(3, xk.getMaKH());
			ps.setInt(4, xk.getMaKho());			
			ps.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
