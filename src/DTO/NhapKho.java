package DTO;

public class NhapKho {
	private int MaNK;
	private String NgayNhap;
	private int TongTien;
	private int MaKho;
	private String TenKho;
	
	public String getTenKho() {
		return TenKho;
	}

	public void setTenKho(String tenKho) {
		TenKho = tenKho;
	}

	public int getMaNK() {
		return MaNK;
	}
	
	public void setMaNK(int maNK) {
		MaNK = maNK;
	}
	
	public String getNgayNhap() {
		return NgayNhap;
	}
	
	public void setNgayNhap(String ngayNhap) {
		NgayNhap = ngayNhap;
	}
	
	public int getTongTien() {
		return TongTien;
	}
	
	public void setTongTien(int tongTien) {
		TongTien = tongTien;
	}
	
	public int getMaKho() {
		return MaKho;
	}
	
	public void setMaKho(int maKho) {
		MaKho = maKho;
	}
	
}
