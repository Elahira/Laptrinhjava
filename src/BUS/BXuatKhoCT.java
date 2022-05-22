package BUS;

import DAO.DNhapKhoCT;
import DAO.DXuatKhoCT;
import DTO.XuatKhoCT;

public class BXuatKhoCT {
	DXuatKhoCT Dxkct=new DXuatKhoCT();
	public boolean xuatkhoChiTiet(XuatKhoCT xkct) {
		return Dxkct.xuatKhoCT(xkct);
	}
}
