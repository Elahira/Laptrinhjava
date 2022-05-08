package BUS;

import java.util.List;

import DAO.DKhoHangCT;
import DTO.KhoHangCT;

public class BKhoHangCT {
	DKhoHangCT khoct = new DKhoHangCT();
	
	public List<KhoHangCT> listkhoct(int makho){
		return khoct.getListKhoct(makho);
	}

}
