package Entity;

import java.time.LocalDate;

public class HoaDonBanHang {
	private LocalDate ngayL;
	private String maHD;
	private KhachHang maKH;
	private NhanVien maNV;

	public HoaDonBanHang(String maHD) {
		super();
		this.maHD = maHD;
	}

	public HoaDonBanHang() {
		super();
	}

	public HoaDonBanHang(LocalDate ngayL, String maHD, KhachHang maKH, NhanVien maNV) {
		super();
		this.ngayL = ngayL;
		this.maHD = maHD;
		this.maKH = maKH;
		this.maNV = maNV;
	}

	public LocalDate getNgayL() {
		return ngayL;
	}

	public void setNgayL(LocalDate ngayL) {
		this.ngayL = ngayL;
	}

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public KhachHang getMaKH() {
		return maKH;
	}

	public void setMaKH(KhachHang maKH) {
		this.maKH = maKH;
	}

	public NhanVien getMaNV() {
		return maNV;
	}

	public void setMaNV(NhanVien maNV) {
		this.maNV = maNV;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maKH == null) ? 0 : maKH.hashCode());
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
		HoaDonBanHang other = (HoaDonBanHang) obj;
		if (maKH == null) {
			if (other.maKH != null)
				return false;
		} else if (!maKH.equals(other.maKH))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HoaDonBanHang [ngayL=" + ngayL + ", maHD=" + maHD + ", maKH=" + maKH + ", maNV=" + maNV + "]";
	}

}
