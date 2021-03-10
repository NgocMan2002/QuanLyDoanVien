package vn.ngocman.database;

public class ChiDoan {
	private String tenChiDoan;
	private String maChiDoan;
	private String maKhoa;
	private String dienThoai;
	public String getTenChiDoan() {
		return tenChiDoan;
	}
	public void setTenChiDoan(String tenChiDoan) {
		this.tenChiDoan = tenChiDoan;
	}
	public String getMaChiDoan() {
		return maChiDoan;
	}
	public void setMaChiDoan(String maChiDoan) {
		this.maChiDoan = maChiDoan;
	}
	public String getMaKhoa() {
		return maKhoa;
	}
	public void setMaKhoa(String maKhoa) {
		this.maKhoa = maKhoa;
	}
	public String getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}
	@Override
	public String toString() {
		return tenChiDoan;
	}
}
