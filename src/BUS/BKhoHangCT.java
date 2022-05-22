package BUS;

import java.util.List;

import DAO.DKhoHangCT;
import DTO.KhoHangCT;

public class BKhoHangCT {
	DKhoHangCT khoct = new DKhoHangCT();
	
	public List<KhoHangCT> listkhoct(int makho){
		return khoct.getListKhoct(makho);
	}
	public boolean nhapKhoHang(KhoHangCT khct) {
		return khoct.nhapKho(khct);		
	}
	public boolean nhapSL(KhoHangCT khct) {
		return khoct.nhapSL(khct);
	}
	public boolean isChecked(int a, int b) {		
		return khoct.isCheck(a, b);
	}
	
	public List<KhoHangCT> listuptable(){
		return khoct.getListUpTable();		
	}
	public boolean xoaHangTrongKho(int mahang,int makho) {
		return khoct.xoaHTK(mahang,makho);
	}
}
