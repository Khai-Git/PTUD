package Entity;

import java.math.BigDecimal;

public class ChiTietHDNH {
	private HoaDonNhapHang maHD;
	private SanPham maSP;
	private String lH;
	private int sL;
	private BigDecimal tt;

	public ChiTietHDNH() {
		super();
	}

	public ChiTietHDNH(HoaDonNhapHang maHD, SanPham maSP, String lH, int sL, BigDecimal tt) {
		super();
		this.maHD = maHD;
		this.maSP = maSP;
		this.lH = lH;
		this.sL = sL;
		this.tt = tt;
	}

	public HoaDonNhapHang getMaHD() {
		return maHD;
	}

	public void setMaHD(HoaDonNhapHang maHD) {
		this.maHD = maHD;
	}

	public SanPham getMaSP() {
		return maSP;
	}

	public void setMaSP(SanPham maSP) {
		this.maSP = maSP;
	}

	public String getlH() {
		return lH;
	}

	public void setlH(String lH) {
		this.lH = lH;
	}

	public int getsL() {
		return sL;
	}

	public void setsL(int sL) {
		this.sL = sL;
	}

	public BigDecimal getTt() {
		return tt;
	}

	public void setTt(BigDecimal tt) {
		this.tt = tt;
	}

	@Override
	public String toString() {
		return "ChiTienHDNH [maHD=" + maHD + ", maSP=" + maSP + "]";
	}

}
