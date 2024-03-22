package Entity;

public class Entity_DatPhong {
	String maKH;
	String tenKH;
	String sdt;
	String cmnd;
	String diaChi;
	
	public Entity_DatPhong() {
		// TODO Auto-generated constructor stub
	}
	public Entity_DatPhong(String maKH) {
		this(maKH,"","","","");
	}
	public Entity_DatPhong(String maKH, String tenKH, String sdt, String cmnd, String diaChi) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.sdt = sdt;
		this.cmnd = cmnd;
		this.diaChi = diaChi;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	@Override
	public String toString() {
		return "Entity_DatPhong [maKH=" + maKH + ", tenKH=" + tenKH + ", sdt=" + sdt + ", cmnd=" + cmnd + ", diaChi="
				+ diaChi + "]";
	}
}