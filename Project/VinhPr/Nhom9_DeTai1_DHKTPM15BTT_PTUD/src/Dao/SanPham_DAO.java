package Dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import ConnectDB.ConnectDB;
import Entity.NhaCungCap;
import Entity.SanPham;

public class SanPham_DAO {

	// tìm sản phẩm theo ma
	public ArrayList<SanPham> timMSP(String maSP) {
		ArrayList<SanPham> dsSP1 = new ArrayList<SanPham>();
		ConnectDB.getInstance();
		java.sql.Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from SanPham where MaSanPham = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maSP);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String maSanPham = rs.getString("MaSanPham");
				String tenSanPham = rs.getString("TenSanPham");
				String mau = rs.getString("Mau");
				String loai = rs.getString("Loai");
				int soLuong = rs.getInt("SoLuongTon");
				String size = rs.getString("Size");
				String hang = rs.getString("Hang");
				String loHang = rs.getString("LoHang");
				NhaCungCap maNCC = new NhaCungCap(rs.getString("MaNhaCungCap"));
				NhaCungCap tenNCC = new NhaCungCap(rs.getString("TenNhaCungCap"));
				LocalDate ngayNhap = rs.getDate("NgayNhap").toLocalDate();
				BigDecimal giaNhap = rs.getBigDecimal("GiaNhap");
				BigDecimal donGia = rs.getBigDecimal("GiaBan");

				SanPham dsTSP1 = new SanPham(maSanPham, tenSanPham, mau, loai, soLuong, size, hang, loHang, ngayNhap,
						giaNhap, donGia, maNCC, tenNCC);
				dsSP1.add(dsTSP1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsSP1;
	}

	// tìm sản phẩm theo ten
	public ArrayList<SanPham> timTSP(String tenSP) {
		ArrayList<SanPham> dsSP2 = new ArrayList<SanPham>();
		ConnectDB.getInstance();
		java.sql.Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from SanPham where TenSanPham = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, tenSP);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String maSanPham = rs.getString("MaSanPham");
				String tenSanPham = rs.getString("TenSanPham");
				String mau = rs.getString("Mau");
				String loai = rs.getString("Loai");
				String hang = rs.getString("Hang");
				int soLuong = rs.getInt("SoLuongTon");
				String size = rs.getString("Size");
				String loHang = rs.getString("LoHang");
				NhaCungCap maNCC = new NhaCungCap(rs.getString("MaNhaCungCap"));
				NhaCungCap tenNCC = new NhaCungCap(rs.getString("TenNhaCungCap"));
				LocalDate ngayNhap = rs.getDate("NgayNhap").toLocalDate();
				BigDecimal giaNhap = rs.getBigDecimal("GiaNhap");
				BigDecimal donGia = rs.getBigDecimal("GiaBan");

				SanPham dsTSP1 = new SanPham(maSanPham, tenSanPham, mau, loai, soLuong, size, hang, loHang, ngayNhap,
						giaNhap, donGia, maNCC, tenNCC);
				dsSP2.add(dsTSP1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsSP2;
	}

//  tìm sản phẩm theo mã nhà cung cấp
	public ArrayList<SanPham> timMNCC(String ma) {
		ArrayList<SanPham> dsSP2 = new ArrayList<SanPham>();
		ConnectDB.getInstance();
		java.sql.Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from SanPham where MaNhaCungCap = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ma);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String maSanPham = rs.getString("MaSanPham");
				String tenSanPham = rs.getString("TenSanPham");
				String mau = rs.getString("Mau");
				String loai = rs.getString("Loai");
				int soLuong = rs.getInt("SoLuongTon");
				String hang = rs.getString("Hang");
				String size = rs.getString("Size");
				String loHang = rs.getString("LoHang");
				LocalDate ngayNhap = rs.getDate("NgayNhap").toLocalDate();
				NhaCungCap maNCC = new NhaCungCap(rs.getString("MaNhaCungCap"));
				NhaCungCap tenNCC = new NhaCungCap(rs.getString("TenNhaCungCap"));
				BigDecimal giaNhap = rs.getBigDecimal("GiaNhap");
				BigDecimal donGia = rs.getBigDecimal("GiaBan");
				SanPham dsTSP1 = new SanPham(maSanPham, tenSanPham, mau, loai, soLuong, size, hang, loHang, ngayNhap,
						giaNhap, donGia, maNCC, tenNCC);
				dsSP2.add(dsTSP1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsSP2;
	}

//  tìm sản phẩm theo ten nhà cung cấp
	public ArrayList<SanPham> timTNCC(String ten) {
		ArrayList<SanPham> dsSP2 = new ArrayList<SanPham>();
		ConnectDB.getInstance();
		java.sql.Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from SanPham where TenNhaCungCap = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ten);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String maSanPham = rs.getString("MaSanPham");
				String tenSanPham = rs.getString("TenSanPham");
				String mau = rs.getString("Mau");
				String loai = rs.getString("Loai");
				int soLuong = rs.getInt("SoLuongTon");
				String size = rs.getString("Size");
				String loHang = rs.getString("LoHang");
				LocalDate ngayNhap = rs.getDate("NgayNhap").toLocalDate();
				String hang = rs.getString("Hang");
				NhaCungCap maNCC = new NhaCungCap(rs.getString("MaNhaCungCap"));
				NhaCungCap tenNCC = new NhaCungCap(rs.getString("TenNhaCungCap"));
				BigDecimal giaNhap = rs.getBigDecimal("GiaNhap");
				BigDecimal donGia = rs.getBigDecimal("GiaBan");
				SanPham dsTSP1 = new SanPham(maSanPham, tenSanPham, mau, loai, soLuong, size, hang, loHang, ngayNhap,
						giaNhap, donGia, maNCC, tenNCC);
				dsSP2.add(dsTSP1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsSP2;
	}

	// lấy danh sách tất cả các sản phẩm
	public ArrayList<SanPham> dsSP() {
		ArrayList<SanPham> dsSP2 = new ArrayList<SanPham>();
		ConnectDB.getInstance();
		java.sql.Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from SanPham";
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String maSanPham = rs.getString("MaSanPham");
				String tenSanPham = rs.getString("TenSanPham");
				String mau = rs.getString("Mau");
				String loai = rs.getString("Loai");
				int soLuong = rs.getInt("SoLuongTon");
				String size = rs.getString("Size");
				String loHang = rs.getString("LoHang");
				LocalDate ngayNhap = rs.getDate("NgayNhap").toLocalDate();
				String hang = rs.getString("Hang");
				NhaCungCap maNCC = new NhaCungCap(rs.getString("MaNhaCungCap"));
				NhaCungCap tenNCC = new NhaCungCap(rs.getString("TenNhaCungCap"));
				BigDecimal giaNhap = rs.getBigDecimal("GiaNhap");
				BigDecimal donGia = rs.getBigDecimal("GiaBan");

				SanPham dsTSP1 = new SanPham(maSanPham, tenSanPham, mau, loai, soLuong, size, hang, loHang, ngayNhap,
						giaNhap, donGia, maNCC, tenNCC);
				dsSP2.add(dsTSP1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsSP2;

	}

	// Thêm sản phẩm mới
	public boolean create(SanPham sp) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into SanPham values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, sp.getMaSanPham());
			stmt.setString(2, sp.getTenSanPham());
			stmt.setString(3, sp.getHang());
			stmt.setString(4, sp.getLoai());
			stmt.setInt(5, sp.getSoLuongTon());
			stmt.setString(6, sp.getLoHang());
			stmt.setString(7, sp.getSize());
			stmt.setBigDecimal(8, sp.getGiaBan());
			stmt.setBigDecimal(9, sp.getGiaNhap());
			stmt.setString(10, sp.getMau());
			String ngay = sp.getNgayNhap().toString();
			Date ngayN = Date.valueOf(ngay);
			stmt.setDate(11, ngayN);
			String maNCC = sp.getMaNCC().getMaNhaCungCap();
			stmt.setString(12, maNCC);
			String tenNCC = sp.getTenNCC().getMaNhaCungCap();
			stmt.setString(13, tenNCC);
			n = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	// up date sp
	public boolean updateSL(SanPham sp) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update SanPham set SoLuongTon = ? where MaSanPham = ?");

			stmt.setInt(1, sp.getSoLuongTon());
			stmt.setString(2, sp.getMaSanPham());
			n = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	// up date sp
	public boolean update(SanPham sp) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(
					"update SanPham set TenSanPham = ?, Hang = ?, Loai = ?, SoLuongTon = ?, LoHang = ?, Size = ?, GiaBan = ?, GiaNhap = ?, Mau = ?, NgayNhap = ? where MaSanPham = ?");
			stmt.setString(11, sp.getMaSanPham());
			stmt.setString(1, sp.getTenSanPham());
			stmt.setString(2, sp.getHang());
			stmt.setString(3, sp.getLoai());
			stmt.setInt(4, sp.getSoLuongTon());
			stmt.setString(5, sp.getLoHang());
			stmt.setString(6, sp.getSize());
			stmt.setBigDecimal(7, sp.getGiaBan());
			stmt.setBigDecimal(8, sp.getGiaNhap());
			stmt.setString(9, sp.getMau());
			String ngay = sp.getNgayNhap().toString();
			Date ngayN = Date.valueOf(ngay);
			stmt.setDate(10, ngayN);
			n = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	// xoa sp theo ma
	public boolean delete(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from SanPham where MaSanPham = ?");
			stmt.setString(1, ma);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public String maSP() {
		String mSP = null;
		try {
			ConnectDB.getInstance();
			java.sql.Connection con = ConnectDB.getConnection();
			String sql = "select top 1 MaSanPham from SanPham order by MaSanPham desc";
			java.sql.Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				mSP = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mSP;
	}

}
