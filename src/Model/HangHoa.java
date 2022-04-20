package Model;

public class HangHoa {
	private int MaHang;
	private String TenHang;
	private String LoaiHang;
	private int Gia;
	private int SoLuong;
	private int MaNCC;
	
	public HangHoa(int MaHang, String TenHang, String LoaiHang, int Gia, int SoLuong, int MaNCC) {
		this.MaHang=MaHang;
		this.TenHang=TenHang;
		this.LoaiHang=LoaiHang;
		this.Gia=Gia;
		this.SoLuong=SoLuong;
		this.MaNCC=MaNCC;
	}
	
	public int getMaHang() {
		return MaHang;
	}

	public void setMaHang(int maHang) {
		MaHang = maHang;
	}

	public String getTenHang() {
		return TenHang;
	}

	public void setTenHang(String tenHang) {
		TenHang = tenHang;
	}

	public String getLoaiHang() {
		return LoaiHang;
	}

	public void setLoaiHang(String loaiHang) {
		LoaiHang = loaiHang;
	}

	public int getGia() {
		return Gia;
	}

	public void setGia(int gia) {
		Gia = gia;
	}

	public int getSoLuong() {
		return SoLuong;
	}

	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}

	public int getMaNCC() {
		return MaNCC;
	}

	public void setMaNCC(int maNCC) {
		MaNCC = maNCC;
	}

}
