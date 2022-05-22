package BUS;

import java.util.List;

import DAO.DXuatKho;
import DTO.XuatKho;

public class BXuatKho {
	DXuatKho Dxkho = new DXuatKho();
	public List<XuatKho> listXuatKho(){
		return Dxkho.getListXK();		
	}
	public boolean XuatKho(XuatKho xk) {
		return Dxkho.xuatKho(xk);
	}
}
