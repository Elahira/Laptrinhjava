package BUS;

import java.util.List;

import DAO.*;
import DTO.HangHoa;

public class BHangHoa {
	DHangHoa Dhh = new DHangHoa();
	
	public List<HangHoa> listHangHoa() {
		return Dhh.getListHH();
	}
	
	public boolean themHanghoa(HangHoa hh) {
		return Dhh.themHH(hh);
	}
	
	public boolean xoaHanghoa(int mahh) {
		return Dhh.xoaHH(mahh);
	}
	
	public boolean suaHanghoa(HangHoa hh) {
		return Dhh.suaHH(hh);
	}
	
}
