package Entity;

import java.util.Objects;

public class Entity_ChiTietHoaDonSanPham {
	private String maCTHDSP;
	private Entity_Phong phong;
	private Entity_KhachHang kh;
	private String ngayLap;
	
	
	public Entity_ChiTietHoaDonSanPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Entity_ChiTietHoaDonSanPham(String maCTHDSP) {
		this.maCTHDSP = maCTHDSP;
	}
	
	public Entity_ChiTietHoaDonSanPham(String maCTHDSP, Entity_Phong phong, Entity_KhachHang kh, String ngayLap) {
		super();
		this.maCTHDSP = maCTHDSP;
		this.phong = phong;
		this.kh = kh;
		this.ngayLap = ngayLap;
	}
	

	public String getMaCTHDSP() {
		return maCTHDSP;
	}

	public void setMaCTHDSP(String maCTHDSP) {
		this.maCTHDSP = maCTHDSP;
	}

	public Entity_Phong getPhong() {
		return phong;
	}

	public void setPhong(Entity_Phong phong) {
		this.phong = phong;
	}

	public Entity_KhachHang getKh() {
		return kh;
	}

	public void setKh(Entity_KhachHang kh) {
		this.kh = kh;
	}

	public String getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(String ngayLap) {
		this.ngayLap = ngayLap;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maCTHDSP);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entity_ChiTietHoaDonSanPham other = (Entity_ChiTietHoaDonSanPham) obj;
		return Objects.equals(maCTHDSP, other.maCTHDSP);
	}

	@Override
	public String toString() {
		return "Entity_ChiTietHoaDonSanPham [maCTHDSP=" + maCTHDSP + ", phong=" + phong + ", kh=" + kh + ", ngayLap="
				+ ngayLap + "]";
	}
	
	/* Tính tổng sản phẩm
	 * public double TinhTongSP() {
	 		
		return ;
	}*/
	
	
	
}
