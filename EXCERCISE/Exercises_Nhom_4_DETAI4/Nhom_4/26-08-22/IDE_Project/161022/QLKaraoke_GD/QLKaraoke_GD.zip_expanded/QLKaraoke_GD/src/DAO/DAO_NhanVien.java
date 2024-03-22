package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.ConnectDB;
import ConnectDB.ConnectDB;
import Entity.Entity_NhanVien;
import Entity.Entity_TaiKhoan;



public class DAO_NhanVien {
	ArrayList<Entity_NhanVien> dsnv;
	Entity_NhanVien nhanvien;
	
	public DAO_NhanVien() {
		// TODO Auto-generated constructor stub
		dsnv = new ArrayList<Entity_NhanVien>();
		nhanvien = new Entity_NhanVien();

	}
	public ArrayList<Entity_NhanVien> getallNhanVien(){
//		ArrayList<NhanVien> dsnhanvien = new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select  NhanVien.maNv, NhanVien.tenNV, NhanVien.sdt, NhanVien.gioiTinh, NhanVien.chucVu , TaiKhoan.taiKhoan \r\n"
					+ "from NhanVien, TaiKhoan\r\n"
					+ "where NhanVien.maTK=TaiKhoan.id";
			java.sql.Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maNV = rs.getString(1);
				String tenNV = rs.getString(2);
				String soDienThoai = rs.getString(3);
				String gioiTinh = rs.getString(4);
				String chucVu = rs.getString(5);
				String taikhoanNV = rs.getString(6);
				Entity_TaiKhoan taikhoan = new Entity_TaiKhoan(taikhoanNV, "");
				System.out.println(taikhoan.toString());
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
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into NhanVien values(?,?,?,?,?,?,?)");
			stmt.setString(1, nv.getMaNV());
			stmt.setString(2, nv.getTenNV());
			stmt.setString(3, nv.getSoDienThoai());
			stmt.setString(4, nv.getGioiTinh());
			stmt.setString(5, nv.getChucVu());
			stmt.setString(6, nv.getTaiKhoan().getTaikhoanNv());
			stmt.setString(7, nv.getTaiKhoan().getMatKhau());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean delete(String maNV) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from NhanVien where maNV = ?");
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
			stmt = con.prepareStatement("update NhanVien set tenNV = ?, sdt = ?, gioiTinh = ?, chucVu = ?, taiKhoan = ?, matKhau=? where maNV = ?");
			stmt.setString(7, nv.getMaNV());
			stmt.setString(1, nv.getTenNV());
			stmt.setString(2, nv.getSoDienThoai());
			stmt.setString(3, nv.getGioiTinh());
			stmt.setString(4, nv.getChucVu());
			stmt.setString(5, nv.getTaiKhoan().getTaikhoanNv());
			stmt.setString(6, nv.getTaiKhoan().getMatKhau());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public ArrayList<Entity_NhanVien> getNhanVienTheoTaiKhoan(String id) {
		ArrayList<Entity_NhanVien> dsnv = new ArrayList<Entity_NhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Select * from NhanVien where maTK =?";
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maNV = rs.getString(1);
				String tenNV = rs.getString(2);
				String soDienThoai = rs.getString(3);
				String gioiTinh = rs.getString(4);
				String chucVu = rs.getString(5);
				Entity_TaiKhoan taikhoan = new Entity_TaiKhoan(rs.getString(6));
				Entity_NhanVien nv = new Entity_NhanVien(maNV, tenNV, soDienThoai, gioiTinh, chucVu, taikhoan);
				dsnv.add(nv);
			}
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		return dsnv;
	}
}
