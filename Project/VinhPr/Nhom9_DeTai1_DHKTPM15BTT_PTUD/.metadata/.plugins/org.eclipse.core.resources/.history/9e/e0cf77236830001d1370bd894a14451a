package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;

import ConnectDB.ConnectDB;
import Entity.KhachHang;

public class KhachHang_DAO {
	// Tìm khách hàng theo sđt
	public ArrayList<KhachHang> getKHSDT(String soDT) {
		ArrayList<KhachHang> kh = new ArrayList<KhachHang>();
		ConnectDB.getInstance();
		java.sql.Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from KhachHang where SoDienThoai = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, soDT);
			rs = stmt.executeQuery();
			if (rs.next()) {
				String maKH = rs.getString("MaKhachHang");
				String tenKH = rs.getString("TenKhachHang");
				String soDienThoai = rs.getString("SoDienThoai");
				String diaChi = rs.getString("DiaChi");
				String gioiTinh = rs.getString("GioiTinh");
				LocalDate ngaySinh = rs.getDate("NgaySinh").toLocalDate();
				KhachHang kh1 = new KhachHang(maKH, tenKH, soDienThoai, diaChi, gioiTinh, ngaySinh);
				kh.add(kh1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kh;
	}

	// Tìm khách hàng theo ten
	public ArrayList<KhachHang> getTKH(String ten) {
		ArrayList<KhachHang> kh = new ArrayList<KhachHang>();
		ConnectDB.getInstance();
		java.sql.Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from KhachHang where TenKhachHang = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ten);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String maKH = rs.getString("MaKhachHang");
				String tenKH = rs.getString("TenKhachHang");
				String soDienThoai = rs.getString("SoDienThoai");
				String diaChi = rs.getString("DiaChi");
				String gioiTinh = rs.getString("GioiTinh");
				LocalDate ngaySinh = rs.getDate("NgaySinh").toLocalDate();
				KhachHang kh1 = new KhachHang(maKH, tenKH, soDienThoai, diaChi, gioiTinh, ngaySinh);
				kh.add(kh1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kh;
	}

	// Tìm khách hàng theo ten
	public ArrayList<KhachHang> getMKH(String ma) {
		ArrayList<KhachHang> kh = new ArrayList<KhachHang>();
		ConnectDB.getInstance();
		java.sql.Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from KhachHang where MaKhachHang = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ma);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String maKH = rs.getString("MaKhachHang");
				String tenKH = rs.getString("TenKhachHang");
				String soDienThoai = rs.getString("SoDienThoai");
				String diaChi = rs.getString("DiaChi");
				String gioiTinh = rs.getString("GioiTinh");
				LocalDate ngaySinh = rs.getDate("NgaySinh").toLocalDate();
				KhachHang kh1 = new KhachHang(maKH, tenKH, soDienThoai, diaChi, gioiTinh, ngaySinh);
				kh.add(kh1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kh;
	}

	// lay tat ca cac khách hàng
	public ArrayList<KhachHang> getDSKH() {
		ArrayList<KhachHang> kh = new ArrayList<KhachHang>();
		ConnectDB.getInstance();
		java.sql.Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from KhachHang";
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String maKH = rs.getString("MaKhachHang");
				String tenKH = rs.getString("TenKhachHang");
				String soDienThoai = rs.getString("SoDienThoai");
				String diaChi = rs.getString("DiaChi");
				String gioiTinh = rs.getString("GioiTinh");
				LocalDate ngaySinh = rs.getDate("NgaySinh").toLocalDate();
				KhachHang kh1 = new KhachHang(maKH, tenKH, soDienThoai, diaChi, gioiTinh, ngaySinh);
				kh.add(kh1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kh;
	}

	// thêm khách hàng
	public boolean create(KhachHang kh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into KhachHang values(?,?,?,?,?,?)");
			stmt.setString(1, kh.getMaKhachHang());
			stmt.setString(2, kh.getTenKhachHang());
			stmt.setString(5, kh.getSoDienThoai());
			stmt.setString(6, kh.getDiaChi());
			stmt.setString(4, kh.getGioiTinh());
			LocalDate ngay = kh.getNgaySinh();
			Date ngayS = Date.valueOf(ngay);
			stmt.setDate(3, ngayS);
			n = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean delete(String maKH) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from KhachHang where MaKhachHang = ?");
			stmt.setString(1, maKH);
			// hdBH_Dao.deleteMKH(maKH);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;

	}

	public boolean update(KhachHang kh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(
					"update KhachHang set TenKhachHang = ?,DiaChi = ?,SoDienThoai=?,GioiTinh = ?,NgaySinh = ? where MaKhachHang = ?");
			stmt.setString(1, kh.getTenKhachHang());
			stmt.setString(2, kh.getDiaChi());
			stmt.setString(3, kh.getSoDienThoai());
			stmt.setString(4, kh.getGioiTinh());
			String ngay = kh.getNgaySinh().toString();
			Date ngayS = Date.valueOf(ngay);
			stmt.setDate(5, ngayS);
			stmt.setString(6, kh.getMaKhachHang());
			n = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public int makh() {
		int mkh = 0;
		try {
			ConnectDB.getInstance();
			java.sql.Connection con = ConnectDB.getConnection();
			String sql = "select count(*) from KhachHang";
			java.sql.Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				mkh = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mkh;
	}
}
