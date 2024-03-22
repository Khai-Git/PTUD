package Entity;

import java.util.Objects;

public class Entity_ChiTietPhieuDatPhong {
	private String maCTPDP;
	private Entity_Phong phong;
	private String ngayHen;
	private String gioHen;
	
	public Entity_ChiTietPhieuDatPhong() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Entity_ChiTietPhieuDatPhong(String maCTPDP) {
		this.maCTPDP = maCTPDP;
	}

	public Entity_ChiTietPhieuDatPhong(String maLoai, String tenLoai, int donGia, String maPhong, Entity_LoaiPhong loaiPhong,
			String tenPhong, String trangThai, int sucChua, String maCTPDP, Entity_Phong phong, String ngayHen,
			String gioHen) {
		this.maCTPDP = maCTPDP;
		this.phong = phong;
		this.ngayHen = ngayHen;
		this.gioHen = gioHen;
	}

	public String getMaCTPDP() {
		return maCTPDP;
	}

	public void setMaCTPDP(String maCTPDP) {
		this.maCTPDP = maCTPDP;
	}

	public Entity_Phong getPhong() {
		return phong;
	}

	public void setPhong(Entity_Phong phong) {
		this.phong = phong;
	}

	public String getNgayHen() {
		return ngayHen;
	}

	public void setNgayHen(String ngayHen) {
		this.ngayHen = ngayHen;
	}

	public String getGioHen() {
		return gioHen;
	}

	public void setGioHen(String gioHen) {
		this.gioHen = gioHen;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(maCTPDP);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entity_ChiTietPhieuDatPhong other = (Entity_ChiTietPhieuDatPhong) obj;
		return Objects.equals(maCTPDP, other.maCTPDP);
	}

	@Override
	public String toString() {
		return "ChiTietPhieuDatPhong [maCTPDP=" + maCTPDP + ", phong=" + phong + ", ngayHen=" + ngayHen + ", gioHen="
				+ gioHen + "]";
	}
	
}
