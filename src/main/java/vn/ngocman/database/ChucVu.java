package vn.ngocman.database;

public class ChucVu {
	private String maChucVu;
	private String tenChucVu;
	public String getMaChucVu() {
		return maChucVu;
	}
	public void setMaChucVu(String maChucVu) {
		this.maChucVu = maChucVu;
	}
	public String getTenChucVu() {
		return tenChucVu;
	}
	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
	}
	@Override
	public String toString() {
		return tenChucVu;
	}
}
