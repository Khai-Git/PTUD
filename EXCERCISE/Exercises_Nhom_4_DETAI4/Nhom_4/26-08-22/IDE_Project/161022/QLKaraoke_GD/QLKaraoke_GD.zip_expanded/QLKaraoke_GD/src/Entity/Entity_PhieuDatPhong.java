package Entity;

import java.util.Objects;

public class Entity_PhieuDatPhong{
	private String maPhieuDat;
	private Entity_KhachHang khachHang;
	private Entity_ChiTietPhieuDatPhong chiTietPhieuDatPhong;
	
	
	public Entity_PhieuDatPhong() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Entity_PhieuDatPhong(String maPhieuDat) {
		this.maPhieuDat = maPhieuDat;
	}
	public Entity_PhieuDatPhong(String maPhieuDat, Entity_KhachHang khachHang, Entity_ChiTietPhieuDatPhong chiTietPhieuDatPhong) {
		super();
		this.maPhieuDat = maPhieuDat;
		this.khachHang = khachHang;
		this.chiTietPhieuDatPhong = chiTietPhieuDatPhong;
	}

	public String getMaPhieuDat() {
		return maPhieuDat;
	}
	public void setMaPhieuDat(String maPhieuDat) {
		this.maPhieuDat = maPhieuDat;
	}
	public Entity_KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(Entity_KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public Entity_ChiTietPhieuDatPhong getChiTietPhieuDatPhong() {
		return chiTietPhieuDatPhong;
	}
	public void setChiTietPhieuDatPhong(Entity_ChiTietPhieuDatPhong chiTietPhieuDatPhong) {
		this.chiTietPhieuDatPhong = chiTietPhieuDatPhong;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(maPhieuDat);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entity_PhieuDatPhong other = (Entity_PhieuDatPhong) obj;
		return Objects.equals(maPhieuDat, other.maPhieuDat);
	}

	@Override
	public String toString() {
		return "PhieuDatPhong [maPhieuDat=" + maPhieuDat + ", khachHang=" + khachHang + ", chiTietPhieuDatPhong="
				+ chiTietPhieuDatPhong + "]";
	}	
}
