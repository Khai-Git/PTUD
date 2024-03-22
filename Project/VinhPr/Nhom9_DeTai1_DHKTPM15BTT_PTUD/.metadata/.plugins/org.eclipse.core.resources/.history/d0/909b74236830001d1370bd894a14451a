package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import ConnectDB.ConnectDB;
import Entity.NhanVien;

public class NhanVien_DAO {
	// Tìm nhân viên theo mã
	public ArrayList<NhanVien> getMNV(String ma) {
		ArrayList<NhanVien> nvID = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		java.sql.Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from NhanVien where MaNhanVien = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ma);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String maNV = rs.getString("MaNhanVien");
				String tenNV = rs.getString("TenNhanVien");
				LocalDate ngayS = rs.getDate("NgaySinh").toLocalDate();
				LocalDate ngayVL = rs.getDate("NgayVaoLam").toLocalDate();
				String gioi = rs.getString("GioiTinh");
				String soCMND = rs.getString("SCMND");
				String diaC = rs.getString("DiaChi");
				String sdt = rs.getString("SoDienThoai");
				String tt = rs.getString("TinhTrang");
				NhanVien dsNV = new NhanVien(maNV, tenNV, ngayS, ngayVL, gioi, soCMND, diaC, sdt, tt);
				nvID.add(dsNV);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nvID;
	}

	// Tìm nhân viên theo mã
	public ArrayList<NhanVien> getSDT(String sdt) {
		ArrayList<NhanVien> nvID = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		java.sql.Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from NhanVien where SoDienThoai = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, sdt);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String maNV = rs.getString("MaNhanVien");
				String tenNV = rs.getString("TenNhanVien");
				LocalDate ngayS = rs.getDate("NgaySinh").toLocalDate();
				LocalDate ngayVL = rs.getDate("NgayVaoLam").toLocalDate();
				String gioi = rs.getString("GioiTinh");
				String soCMND = rs.getString("SCMND");
				String diaC = rs.getString("DiaChi");
				String sdt1 = rs.getString("SoDienThoai");
				String tt = rs.getString("TinhTrang");
				NhanVien dsNV = new NhanVien(maNV, tenNV, ngayS, ngayVL, gioi, soCMND, diaC, sdt1, tt);
				nvID.add(dsNV);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nvID;
	}

	// Tìm nhân viên theo tên
	public ArrayList<NhanVien> getTNV(String ten) {
		ArrayList<NhanVien> nvID = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		java.sql.Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from NhanVien where TenNhanVien = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ten);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String maNV = rs.getString("MaNhanVien");
				String tenNV = rs.getString("TenNhanVien");
				LocalDate ngayS = rs.getDate("NgaySinh").toLocalDate();
				LocalDate ngayVL = rs.getDate("NgayVaoLam").toLocalDate();
				String gioi = rs.getString("GioiTinh");
				String soCMND = rs.getString("SCMND");
				String diaC = rs.getString("DiaChi");
				String sdt = rs.getString("SoDienThoai");
				String tt = rs.getString("TinhTrang");
				NhanVien dsNV = new NhanVien(maNV, tenNV, ngayS, ngayVL, gioi, soCMND, diaC, sdt, tt);
				nvID.add(dsNV);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nvID;
	}

	// Lấy danh sách tất cả các nhân viên
	public ArrayList<NhanVien> getDSNV() {
		ArrayList<NhanVien> dssnv = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		java.sql.Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from NhanVien";
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String maNV = rs.getString("MaNhanVien");
				String tenNV = rs.getString("TenNhanVien");
				LocalDate ngayS = rs.getDate("NgaySinh").toLocalDate();
				LocalDate ngayVL = rs.getDate("NgayVaoLam").toLocalDate();
				String gioi = rs.getString("GioiTinh");
				String soCMND = rs.getString("SCMND");
				String diaC = rs.getString("DiaChi");
				String sdt = rs.getString("SoDienThoai");
				String tt = rs.getString("TinhTrang");
				NhanVien dsNV = new NhanVien(maNV, tenNV, ngayS, ngayVL, gioi, soCMND, diaC, sdt, tt);
				dssnv.add(dsNV);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dssnv;
	}

	// Thêm nhân viên
	public boolean create(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into NhanVien values(?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, nv.getMaNhanVien());
			stmt.setString(2, nv.getTenNhanVien());
			stmt.setString(3, nv.getGioiTinh());
			String ngayS1 = nv.getNgaySinh().toString();
			Date ngayS = Date.valueOf(ngayS1);
			stmt.setDate(4, ngayS);
			String ngayVL1 = nv.getNgayVaoLam().toString();
			Date ngayVL = Date.valueOf(ngayVL1);
			stmt.setDate(5, ngayVL);
			stmt.setString(6, nv.getSoCMND());
			stmt.setString(7, nv.getDiaChi());
			stmt.setString(8, nv.getSoDienThoai());
			stmt.setString(9, nv.getTt());
			n = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	// xóa nhân viên
	public boolean updateNV(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(
					"update NhanVien set TenNhanVien = ?,GioiTinh = ?,NgaySinh=?,NgayVaoLam = ?,SCMND = ?, DiaChi = ?, SoDienThoai = ?, TinhTrang = ? where MaNhanVien = ?");
			stmt.setString(9, nv.getMaNhanVien());
			stmt.setString(1, nv.getTenNhanVien());
			stmt.setString(2, nv.getGioiTinh());
			String ngayS1 = nv.getNgaySinh().toString();
			Date ngayS = Date.valueOf(ngayS1);
			stmt.setDate(3, ngayS);
			String ngayVL1 = nv.getNgayVaoLam().toString();
			Date ngayVL = Date.valueOf(ngayVL1);
			stmt.setDate(4, ngayVL);
			stmt.setString(5, nv.getSoCMND());
			stmt.setString(6, nv.getDiaChi());
			stmt.setString(7, nv.getSoDienThoai());
			stmt.setString(8, nv.getTt());
			n = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	// xóa nhân viên
	public boolean xoaNV(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update NhanVien set TinhTrang = ? where MaNhanVien = ?");
			stmt.setString(2, nv.getMaNhanVien());
			stmt.setString(1, nv.getTt());
			n = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public int maNV() {
		int mHD = 0;
		try {
			ConnectDB.getInstance();
			java.sql.Connection con = ConnectDB.getConnection();
			String sql = "select count(*) from NhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				mHD = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mHD;
	}
}
