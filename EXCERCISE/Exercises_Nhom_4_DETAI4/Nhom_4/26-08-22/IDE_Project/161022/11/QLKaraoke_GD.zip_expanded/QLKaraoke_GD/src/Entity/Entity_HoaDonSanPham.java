package Entity;

import java.util.Objects;

public class Entity_HoaDonSanPham{
	private Entity_ChiTietHoaDonSanPham maCTHDSP;
	private Entity_NhanVien nhanVien;
	private Entity_SanPham sanPham;
	private int soLuong;
	private double donGia;
	private double tongTienHD;
	
	public Entity_HoaDonSanPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Entity_HoaDonSanPham(Entity_ChiTietHoaDonSanPham maCTHDSP) {
		this.maCTHDSP = maCTHDSP;
	}
	
	public Entity_HoaDonSanPham(Entity_ChiTietHoaDonSanPham maCTHDSP, Entity_NhanVien nhanVien, Entity_SanPham sanPham, int soLuong, double donGia,
			double tongTienHD) {
		super();
		this.maCTHDSP = maCTHDSP;
		this.nhanVien = nhanVien;
		this.sanPham = sanPham;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.tongTienHD = tongTienHD;
	}
	
	public Entity_ChiTietHoaDonSanPham getMaCTHDSP() {
		return maCTHDSP;
	}

	public void setMaCTHDSP(Entity_ChiTietHoaDonSanPham maCTHDSP) {
		this.maCTHDSP = maCTHDSP;
	}

	public Entity_NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(Entity_NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}



	public Entity_SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(Entity_SanPham sanPham) {
		this.sanPham = sanPham;
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

	public double getTongTienHD() {
		return tongTienHD;
	}

	public void setTongTienHD(double tongTienHD) {
		this.tongTienHD = tongTienHD;
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
		Entity_HoaDonSanPham other = (Entity_HoaDonSanPham) obj;
		return Objects.equals(maCTHDSP, other.maCTHDSP);
	}

	@Override
	public String toString() {
		return "Entity_HoaDonSanPham [maCTHDSP=" + maCTHDSP + ", nhanVien=" + nhanVien + ", maSP=" + sanPham + ", soLuong="
				+ soLuong + ", donGia=" + donGia + ", tongTienHD=" + tongTienHD + "]";
	}
	
	/*Tính tổng tiền hóa đơn sản phẩm
	public double TinhTongTien() {
		
	}
	*/
	
}
