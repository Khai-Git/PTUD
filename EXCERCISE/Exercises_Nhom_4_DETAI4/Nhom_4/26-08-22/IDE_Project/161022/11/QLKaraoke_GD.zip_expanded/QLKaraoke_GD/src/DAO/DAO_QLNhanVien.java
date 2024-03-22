package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.ConnectDB;
import Entity.Entity_NhanVien;
import Entity.Entity_TaiKhoan;



public class DAO_QLNhanVien {
	ArrayList<Entity_NhanVien> dsnv;
	Entity_NhanVien nhanvien;
	
	public DAO_QLNhanVien() {
		// TODO Auto-generated constructor stub
		dsnv = new ArrayList<Entity_NhanVien>();
		nhanvien = new Entity_NhanVien();

	}
	public ArrayList<Entity_NhanVien> getallNhanVien(){
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select  NhanVien.maNv, NhanVien.tenNV, NhanVien.sdt, NhanVien.gioiTinh, NhanVien.chucVu, NhanVien.taiKhoan , TaiKhoan.taiKhoan, TaiKhoan.matKhau \r\n"
					+ "from NhanVien, TaiKhoan\r\n"
					+ "where NhanVien.taiKhoan=TaiKhoan.taiKhoan";
			java.sql.Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				String maNV = rs.getString(1);
				String tenNV = rs.getString(2);
				String soDienThoai = rs.getString(3);
				String gioiTinh = rs.getString(4);
				String chucVu = rs.getString(5);
				Entity_TaiKhoan taikhoan = new Entity_TaiKhoan(rs.getString(7),rs.getString(8));
				Entity_NhanVien nv = new Entity_NhanVien(maNV, tenNV, soDienThoai, gioiTinh, chucVu, taikhoan);
				dsnv.add(nv);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsnv;
	}
	public boolean createNhanVien(Entity_NhanVien nv) {
		ConnectDB.getConnection();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null;
		int n = 0;
		int n1= 0;
		try {
			stmt = con.prepareStatement("insert into TaiKhoan values( ?, ?)");
			stmt1 = con.prepareStatement("insert into NhanVien values( ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, nv.getTaiKhoan().getTaikhoanNv());
			stmt.setString(2, nv.getTaiKhoan().getMatKhau());	
			stmt1.setString(1, nv.getMaNV());
			stmt1.setString(2, nv.getTenNV());
			stmt1.setString(3, nv.getSoDienThoai());
			stmt1.setString(4, nv.getGioiTinh());
			stmt1.setString(5, nv.getChucVu());
			stmt1.setString(6, nv.getTaiKhoan().getTaikhoanNv());
			n = stmt.executeUpdate();
			n1 = stmt1.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0 && n1 > 0;
	}
	public boolean delete(String maNV) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from NhanVien where maNV =  ?");
			stmt.setString(1, maNV);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}
	// update
	public boolean update(Entity_NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(" update TaiKhoan set matKhau =  ? where taiKhoan =  ?\r\n "
					+ " update NhanVien set tenNV =  ?, sdt =  ?, gioiTinh =  ?, chucVu =  ?, taiKhoan =  ? where maNV =  ?\r\n ");
			stmt.setString(1, nv.getTaiKhoan().getMatKhau());
			stmt.setString(2, nv.getTaiKhoan().getTaikhoanNv());
			stmt.setString(3, nv.getTenNV());
			stmt.setString(4, nv.getSoDienThoai());
			stmt.setString(5, nv.getGioiTinh());
			stmt.setString(6, nv.getChucVu());
			stmt.setString(7, nv.getTaiKhoan().getTaikhoanNv());
			stmt.setString(8, nv.getMaNV());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public ArrayList<Entity_NhanVien> getNhanVienTheoSDT(String sdt) {
		ArrayList<Entity_NhanVien> dsnv = new ArrayList<Entity_NhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Select * from NhanVien where sdt = ?";
			statement.setString(1, sdt);
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maNV = rs.getString(3);
				String tenNV = rs.getString(2);
				String soDienThoai = rs.getString(1);
				String gioiTinh = rs.getString(4);
				String chucVu = rs.getString(5);
				Entity_TaiKhoan taikhoan = new Entity_TaiKhoan(rs.getString(6),rs.getString(7));
				Entity_NhanVien nv = new Entity_NhanVien(maNV, tenNV, soDienThoai, gioiTinh, chucVu, taikhoan);
				dsnv.add(nv);
			}
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		return dsnv;
	}

	
}
