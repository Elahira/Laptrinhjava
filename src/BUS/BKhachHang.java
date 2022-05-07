package BUS;

import java.util.List;

import DAO.DKhachHang;
import DTO.KhachHang;

public class BKhachHang {
	DKhachHang Dkh = new DKhachHang();
	
	public List<KhachHang> listKhachHang() {
		return Dkh.getListKH();
	}
	
	public boolean themKhachHang(KhachHang kh) {
		return Dkh.themKH(kh);
	}
	
	public boolean xoaKhachHang(int makh) {
		return Dkh.xoaKH(makh);
	}
	
	public boolean suaKhachHang(KhachHang kh) {
		return Dkh.suaKH(kh);
	}

}
