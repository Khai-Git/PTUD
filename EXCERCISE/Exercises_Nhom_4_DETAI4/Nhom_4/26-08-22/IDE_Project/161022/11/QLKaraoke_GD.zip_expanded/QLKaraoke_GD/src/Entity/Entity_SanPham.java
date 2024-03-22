package Entity;

import java.util.Objects;

public class Entity_SanPham {
	private String maSP;
	private String tenSP;
	private int soLuong;
	private double donGia;
	
	public Entity_SanPham() {
		super();
	}
	
	public Entity_SanPham(String maSP) {
		this.maSP = maSP;
	}
	public Entity_SanPham(String maSP, String tenSP, int soLuong, double donGia) {
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(maSP);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entity_SanPham other = (Entity_SanPham) obj;
		return Objects.equals(maSP, other.maSP);
	}

	
	@Override
	public String toString() {
		return "SanPham [maSP=" + maSP + ", tenSP=" + tenSP + ", soLuong=" + soLuong + ", donGia=" + donGia + "]";
	}
	
	
}
