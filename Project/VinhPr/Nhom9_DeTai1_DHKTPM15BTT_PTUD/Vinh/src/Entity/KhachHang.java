package Entity;

import java.time.LocalDate;

public class KhachHang {
	private String maKhachHang;
	private String tenKhachHang;
	private String soDienThoai;
	private String diaChi;
	private String gioiTinh;
	private LocalDate ngaySinh;

	public KhachHang() {
		super();
	}

	public KhachHang(String soDienThoai) {
		super();
		this.soDienThoai = soDienThoai;
	}

	public KhachHang(String maKhachHang, String tenKhachHang, String soDienThoai, String diaChi, String gioiTinh,
			LocalDate ngaySinh) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((soDienThoai == null) ? 0 : soDienThoai.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		if (soDienThoai == null) {
			if (other.soDienThoai != null)
				return false;
		} else if (!soDienThoai.equals(other.soDienThoai))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", tenKhachHang=" + tenKhachHang + ", soDienThoai="
				+ soDienThoai + ", diaChi=" + diaChi + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + "]";
	}

}
