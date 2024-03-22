package Entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SanPham {
	private String maSanPham;
	private String tenSanPham;
	private String mau;
	private String loai;
	private int soLuongTon;
	private String size;
	private String hang;
	private String loHang;
	private LocalDate ngayNhap;
	private BigDecimal giaNhap;
	private BigDecimal giaBan;
	private NhaCungCap maNCC;
	private NhaCungCap tenNCC;

	public SanPham() {
		super();
	}



	public SanPham(String maSanPham, int soLuongTon) {
		super();
		this.maSanPham = maSanPham;
		this.soLuongTon = soLuongTon;
	}



	public SanPham(String maSanPham) {
		super();
		this.maSanPham = maSanPham;
	}

	public SanPham(String maSanPham, String tenSanPham, String mau, String loai, int soLuongTon, String size,
			String hang, String loHang, LocalDate ngayNhap, BigDecimal giaNhap, BigDecimal giaBan, NhaCungCap maNCC,
			NhaCungCap tenNCC) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.mau = mau;
		this.loai = loai;
		this.soLuongTon = soLuongTon;
		this.size = size;
		this.hang = hang;
		this.loHang = loHang;
		this.ngayNhap = ngayNhap;
		this.giaNhap = giaNhap;
		this.giaBan = giaBan;
		this.maNCC = maNCC;
		this.tenNCC = tenNCC;
	}

	public String getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public String getMau() {
		return mau;
	}

	public void setMau(String mau) {
		this.mau = mau;
	}

	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

	public int getSoLuongTon() {
		return soLuongTon;
	}

	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getHang() {
		return hang;
	}

	public void setHang(String hang) {
		this.hang = hang;
	}

	public String getLoHang() {
		return loHang;
	}

	public void setLoHang(String loHang) {
		this.loHang = loHang;
	}

	public LocalDate getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(LocalDate ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public BigDecimal getGiaNhap() {
		return giaNhap;
	}

	public void setGiaNhap(BigDecimal giaNhap) {
		this.giaNhap = giaNhap;
	}

	public BigDecimal getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(BigDecimal giaBan) {
		this.giaBan = giaBan;
	}

	public NhaCungCap getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(NhaCungCap maNCC) {
		this.maNCC = maNCC;
	}

	public NhaCungCap getTenNCC() {
		return tenNCC;
	}

	public void setTenNCC(NhaCungCap tenNCC) {
		this.tenNCC = tenNCC;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maSanPham == null) ? 0 : maSanPham.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SanPham other = (SanPham) obj;
		if (maSanPham == null) {
			if (other.maSanPham != null)
				return false;
		} else if (!maSanPham.equals(other.maSanPham))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SanPham [maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", mau=" + mau + ", loai=" + loai
				+ ", soLuongTon=" + soLuongTon + ", size=" + size + ", hang=" + hang + ", loHang=" + loHang
				+ ", ngayNhap=" + ngayNhap + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + "]";
	}

}
