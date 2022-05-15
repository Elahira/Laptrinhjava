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
	public boolean isChecked(KhoHangCT khct) {
		return khoct.isCheck(khct);
	}
}
