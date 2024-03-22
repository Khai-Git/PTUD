package Entity;

import java.time.LocalDate;

public class HoaDonNhapHang {
	private String maHD;
	private LocalDate ngayL;
	private NhanVien maNV;
	private NhaCungCap maNCC;

	public HoaDonNhapHang() {
		super();
	}

	public HoaDonNhapHang(String maHD) {
		super();
		this.maHD = maHD;
	}

	public HoaDonNhapHang(String maHD, LocalDate ngayL, NhanVien maNV, NhaCungCap maNCC) {
		super();
		this.maHD = maHD;
		this.ngayL = ngayL;
		this.maNV = maNV;
		this.maNCC = maNCC;
	}

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public LocalDate getNgayL() {
		return ngayL;
	}

	public void setNgayL(LocalDate ngayL) {
		this.ngayL = ngayL;
	}

	public NhanVien getMaNV() {
		return maNV;
	}

	public void setMaNV(NhanVien maNV) {
		this.maNV = maNV;
	}

	public NhaCungCap getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(NhaCungCap maNCC) {
		this.maNCC = maNCC;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maHD == null) ? 0 : maHD.hashCode());
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
		HoaDonNhapHang other = (HoaDonNhapHang) obj;
		if (maHD == null) {
			if (other.maHD != null)
				return false;
		} else if (!maHD.equals(other.maHD))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HoaDonNhanHang [maHD=" + maHD + ", ngayL=" + ngayL + ", maNV=" + maNV + ", maNCC=" + maNCC + "]";
	}

}
