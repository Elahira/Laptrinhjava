package BUS;

import DAO.DNhapKhoCT;
import DTO.NhapKhoCT;

public class BNhapKhoCT {
	DNhapKhoCT Dnkct=new DNhapKhoCT();
	public boolean nhapKhoChiTiet(NhapKhoCT nkct) {
		return Dnkct.nhapKhoCT(nkct);
	}
}
