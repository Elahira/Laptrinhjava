package BUS;

import java.util.List;
import DAO.*;
import DTO.NhapKho;

public class BNhapKho {
	DNhapKho Dnkho = new DNhapKho();
	
	public List<NhapKho> listNhapKho(){
		return Dnkho.getListNK();		
	}
}
