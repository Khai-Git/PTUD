package Entity;

import java.util.Objects;

public class Entity_LoaiPhong extends Entity_Phong{
	private String maLoai;
	private String tenLoai;
	private int donGia;
	
	public Entity_LoaiPhong() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Entity_LoaiPhong(String maLoai) {
		this(maLoai,"",0);
	}
	
	public Entity_LoaiPhong(String maLoai, String tenLoai, int donGia) {
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
		this.donGia = donGia;
	}

	public String getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
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

	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(maLoai);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entity_LoaiPhong other = (Entity_LoaiPhong) obj;
		return Objects.equals(maLoai, other.maLoai);
	}

	@Override
	public String toString() {
		return "LoaiPhong [maLoai=" + maLoai + ", tenLoai=" + tenLoai + ", donGia=" + donGia + "]";
	}
	
	
}
