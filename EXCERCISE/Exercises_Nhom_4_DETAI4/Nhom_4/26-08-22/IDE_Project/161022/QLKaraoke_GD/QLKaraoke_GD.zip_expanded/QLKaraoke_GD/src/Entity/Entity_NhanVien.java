package Entity;

import java.util.Objects;

public class Entity_NhanVien extends Entity_TaiKhoan{
	private String maNV;
	private String tenNV;
	private String soDienThoai;
	private String gioiTinh;
	private String chucVu;
	private Entity_TaiKhoan taiKhoan;
	
	public Entity_NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Entity_NhanVien(String maNV) {
		this.maNV = maNV;
	}

	public Entity_NhanVien(String maNV, String tenNV, String soDienThoai, String gioiTinh, String chucVu, Entity_TaiKhoan taiKhoan) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.soDienThoai = soDienThoai;
		this.gioiTinh = gioiTinh;
		this.chucVu = chucVu;
		this.taiKhoan = taiKhoan;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public Entity_TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(Entity_TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	
	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maNV);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entity_NhanVien other = (Entity_NhanVien) obj;
		return Objects.equals(maNV, other.maNV);
	}

	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", soDienThoai=" + soDienThoai + ", gioiTinh=" + gioiTinh
				+ ", chucVu=" + chucVu + ", taiKhoan=" + taiKhoan + "]";
	}


}
