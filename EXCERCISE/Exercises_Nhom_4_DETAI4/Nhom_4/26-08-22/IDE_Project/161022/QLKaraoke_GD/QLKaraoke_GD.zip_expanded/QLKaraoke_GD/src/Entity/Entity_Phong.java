package Entity;

import java.util.Objects;

public class Entity_Phong{
	private String maPhong;
	private String tenPhong;
	private int sucChua;
	private String tenLoai;
	private double donGia;
	private String trangThai;
	
	public Entity_Phong() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Entity_Phong(String maPhong) {
		this.maPhong = maPhong;
	}
	

	public Entity_Phong(String maPhong, String tenPhong, int sucChua, String tenLoai, double donGia, String trangThai) {
		super();
		this.maPhong = maPhong;
		this.tenPhong = tenPhong;
		this.sucChua = sucChua;
		this.tenLoai = tenLoai;
		this.donGia = donGia;
		this.trangThai = trangThai;
	}

	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getTenPhong() {
		return tenPhong;
	}
	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public int getSucChua() {
		return sucChua;
	}
	public void setSucChua(int sucChua) {
		this.sucChua = sucChua;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(maPhong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entity_Phong other = (Entity_Phong) obj;
		return Objects.equals(maPhong, other.maPhong);
	}

	@Override
	public String toString() {
		return "Phong [maPhong=" + maPhong + ", tenPhong=" + tenPhong + ", trangThai=" + trangThai + ", sucChua="
				+ sucChua + ", tenLoai=" + tenLoai + ", donGia=" + donGia + "]";
	}

	
	
	
}
