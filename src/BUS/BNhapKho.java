package BUS;

import java.util.List;
import DAO.*;
import DTO.HangHoa;
import DTO.NhapKho;

public class BNhapKho {
	DNhapKho Dnkho = new DNhapKho();
	
	public List<NhapKho> listNhapKho(){
		return Dnkho.getListNK();		
	}
	public boolean NhapKho(NhapKho nk) {
		return Dnkho.nhapKho(nk);
	}
	public boolean XoaNhapKho(int manhapkho) {
		return Dnkho.xoaNKho(manhapkho);
	}
}
