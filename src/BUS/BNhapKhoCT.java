package BUS;

import java.util.List;

import DAO.DNhapKhoCT;
import DTO.NhapKhoCT;

public class BNhapKhoCT {
	DNhapKhoCT Dnkct=new DNhapKhoCT();
	public boolean nhapKhoChiTiet(NhapKhoCT nkct) {
		return Dnkct.nhapKhoCT(nkct);
	}
	public List<NhapKhoCT> getListHangNhap(int manhap) {
		return Dnkct.getListHN(manhap);		
	}
}
