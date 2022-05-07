package BUS;

import java.util.List;

import DAO.DNhaCungCap;
import DTO.NhaCungCap;

public class BNhaCungCap {
	DNhaCungCap Dncc = new DNhaCungCap();
	
	public List<NhaCungCap> listNcc(){
		return Dncc.getListNCC();
	}
	
	public boolean themNhaCungCap(NhaCungCap ncc) {
		return Dncc.themNCC(ncc);
	}
	
	public boolean xoaNhaCungCap(int mancc) {
		return Dncc.xoaNCC(mancc);
	}
	
	public boolean suaNhaCungCap(NhaCungCap ncc) {
		return Dncc.suaNCC(ncc);
	}
	
	public int getMancc(String tenNcc) {
		return Dncc.getmaNCC(tenNcc);
	}

}
