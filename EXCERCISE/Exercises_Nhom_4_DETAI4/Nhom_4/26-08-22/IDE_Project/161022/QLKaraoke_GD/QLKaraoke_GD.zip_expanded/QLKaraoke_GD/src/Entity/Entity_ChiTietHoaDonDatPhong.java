package Entity;

import java.util.Objects;

public class Entity_ChiTietHoaDonDatPhong{
	private String maCTHDDP;
	private Entity_Phong phong;
	private int soLuong;
	private int donGiaDatPhong;
	
	public Entity_ChiTietHoaDonDatPhong() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Entity_ChiTietHoaDonDatPhong(String maCTHDDP) {
		this.maCTHDDP = maCTHDDP;
	}
	public Entity_ChiTietHoaDonDatPhong(String maCTHDDP, Entity_Phong phong, int soLuong, int donGiaDatPhong) {
		super();
		this.maCTHDDP = maCTHDDP;
		this.phong = phong;
		this.soLuong = soLuong;
		this.donGiaDatPhong = donGiaDatPhong;
	}

	public String getMaCTHDDP() {
		return maCTHDDP;
	}
	public void setMaCTHDDP(String maCTHDDP) {
		this.maCTHDDP = maCTHDDP;
	}
	public Entity_Phong getPhong() {
		return phong;
	}
	public void setPhong(Entity_Phong phong) {
		this.phong = phong;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public int getDonGiaDatPhong() {
		return donGiaDatPhong;
	}
	public void setDonGiaDatPhong(int donGiaDatPhong) {
		this.donGiaDatPhong = donGiaDatPhong;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(maCTHDDP);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entity_ChiTietHoaDonDatPhong other = (Entity_ChiTietHoaDonDatPhong) obj;
		return Objects.equals(maCTHDDP, other.maCTHDDP);
	}

	@Override
	public String toString() {
		return "ChiTietHoaDonDatPhong [maCTHDDP=" + maCTHDDP + ", phong=" + phong + ", soLuong=" + soLuong
				+ ", tongGioDatPhong=" + ", donGiaDatPhong=" + donGiaDatPhong + "]";
	}
	
	

}
