package Entity;

import java.util.Objects;

public class Entity_TaiKhoan {
	private String taikhoanNv;
	private String matKhau;
	
	public Entity_TaiKhoan() {
		super();
	}
	
	public Entity_TaiKhoan(String taikhoanNv) {
		this.taikhoanNv = taikhoanNv;
		this.matKhau = matKhau;
	}
	
	public Entity_TaiKhoan(String taikhoanNv, String matKhau) {
		this.taikhoanNv = taikhoanNv;
		this.matKhau = matKhau;
	}

	public String getTaikhoanNv() {
		return taikhoanNv;
	}

	public void setTaikhoanNv(String taikhoanNv) {
		this.taikhoanNv = taikhoanNv;
	}

	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(taikhoanNv);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entity_TaiKhoan other = (Entity_TaiKhoan) obj;
		return Objects.equals(taikhoanNv, other.taikhoanNv);
	}

	@Override
	public String toString() {
		return "TaiKhoan [taiKhoan=" + taikhoanNv + ", matKhau=" + matKhau + "]";
	}


}
