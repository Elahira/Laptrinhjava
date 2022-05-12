package BUS;

import java.util.List;

import DAO.DKhoHang;
import DTO.KhoHang;

public class BKhoHang {
	DKhoHang Dkho = new DKhoHang();
	
	public List<KhoHang> listKho() {
		return Dkho.getListKho();
	}
	
	public boolean themKho(KhoHang kho) {
		return Dkho.themKho(kho);
	}
	
	public boolean xoaKho(int makho) {
		return Dkho.xoaKho(makho);
	}
	
	public boolean suaKho(KhoHang kho) {
		return Dkho.suaKho(kho);
	}
	public int getMaKho(String tenKho) {
		return Dkho.getmaKho(tenKho);
	}
}
