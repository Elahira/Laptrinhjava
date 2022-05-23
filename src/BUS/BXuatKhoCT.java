package BUS;

import java.util.List;

import DAO.DNhapKhoCT;
import DAO.DXuatKhoCT;
import DTO.NhapKhoCT;
import DTO.XuatKhoCT;

public class BXuatKhoCT {
	DXuatKhoCT Dxkct=new DXuatKhoCT();
	public boolean xuatkhoChiTiet(XuatKhoCT xkct) {
		return Dxkct.xuatKhoCT(xkct);
	}
	public List<XuatKhoCT> getListHangXuat(int maxuat) {
		return Dxkct.getListHX(maxuat);		
	}
}
