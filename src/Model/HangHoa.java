package Model;

public class HangHoa {
	private int MaHang;
	private String TenHang;
	private String LoaiHang;
	private int Gia;
	private int MaNCC;
	private String TenNhaCC;

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

	public int getMaNCC() {
		return MaNCC;
	}

	public void setMaNCC(int maNCC) {
		MaNCC = maNCC;
	}

	public void setTenNhaCC(String tenNhaCC) {
		TenNhaCC = tenNhaCC;

	}

	public String getTenNhaCC() {
		return TenNhaCC;
	}

}
