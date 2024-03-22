package Entity;

import java.util.Objects;

public class Entity_KhachHang {
	private String maKH;
	private String tenKH;
	private String soDienThoai;
	private String diaChi;
	private String CMND;
	
	public Entity_KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Entity_KhachHang(String maKH) {
		this.maKH = maKH;
	}
	
	public Entity_KhachHang(String maKH, String tenKH, String soDienThoai, String diaChi, String cMND) {
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.CMND = cMND;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getCMND() {
		return CMND;
	}
	public void setCMND(String cMND) {
		CMND = cMND;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(maKH);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entity_KhachHang other = (Entity_KhachHang) obj;
		return Objects.equals(maKH, other.maKH);
	}
	
	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", tenKH=" + tenKH + ", diaChi=" + diaChi + ", soDienThoai=" + soDienThoai
				+ ", CMND=" + CMND + "]";
	}
	
	
}
