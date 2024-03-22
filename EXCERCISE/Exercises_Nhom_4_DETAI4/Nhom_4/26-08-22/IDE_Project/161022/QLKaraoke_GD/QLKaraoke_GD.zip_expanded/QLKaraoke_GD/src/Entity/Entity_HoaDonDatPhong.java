package Entity;

import java.util.Objects;

public class Entity_HoaDonDatPhong {
	private String maHD;
	private Entity_NhanVien nhanVien;
	private Entity_KhachHang khachHang;
	private Entity_ChiTietHoaDonDatPhong chiTietHoaDon;
	private String ngayDatPhong;
	private String gioVao;
	private String gioRa;
	private double tongGioDatPhong;
	private double tongTien;
	
	public Entity_HoaDonDatPhong() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Entity_HoaDonDatPhong(String maHD) {
		this.maHD = maHD;
	}
	public Entity_HoaDonDatPhong(String maHD, Entity_NhanVien nhanVien, Entity_KhachHang khachHang,
			Entity_ChiTietHoaDonDatPhong chiTietHoaDon, String ngayDatPhong, String gioVao, String gioRa,
			double tongGioDatPhong, double tongTien) {
		super();
		this.maHD = maHD;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.chiTietHoaDon = chiTietHoaDon;
		this.ngayDatPhong = ngayDatPhong;
		this.gioVao = gioVao;
		this.gioRa = gioRa;
		this.tongGioDatPhong = tongGioDatPhong;
		this.tongTien = tongTien;
	}

	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public Entity_NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(Entity_NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public Entity_KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(Entity_KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public Entity_ChiTietHoaDonDatPhong getChiTietHoaDon() {
		return chiTietHoaDon;
	}
	public void setChiTietHoaDon(Entity_ChiTietHoaDonDatPhong chiTietHoaDon) {
		this.chiTietHoaDon = chiTietHoaDon;
	}
	public String getNgayDatPhong() {
		return ngayDatPhong;
	}

	public void setNgayDatPhong(String ngayDatPhong) {
		this.ngayDatPhong = ngayDatPhong;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public String getGioVao() {
		return gioVao;
	}

	public void setGioVao(String gioVao) {
		this.gioVao = gioVao;
	}

	public String getGioRa() {
		return gioRa;
	}

	public void setGioRa(String gioRa) {
		this.gioRa = gioRa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maHD);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entity_HoaDonDatPhong other = (Entity_HoaDonDatPhong) obj;
		return Objects.equals(maHD, other.maHD);
	}

	@Override
	public String toString() {
		return "HoaDonDatPhong [maHD=" + maHD + ", nhanVien=" + nhanVien + ", khachHang=" + khachHang
				+ ", chiTietHoaDon=" + chiTietHoaDon + ", ngayDatPhong=" + ngayDatPhong + ", gioVao=" + gioVao
				+ ", gioRa=" + gioRa + ", tongGioDatPhong=" + tongGioDatPhong + ", tongTien=" + tongTien + "]";
	}
	
	 public double TongGioDatPhong() {
			
		return 0;
		
	}
		
	 public double TinhTongTien() {
		
		return 0;
		
	}
}
