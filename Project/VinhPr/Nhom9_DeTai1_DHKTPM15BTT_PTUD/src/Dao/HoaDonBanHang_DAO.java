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
import Entity.HoaDonBanHang;
import Entity.KhachHang;
import Entity.NhanVien;

public class HoaDonBanHang_DAO {
	// tìm kiếm theo mã kh
	public ArrayList<HoaDonBanHang> dsMHD(String maHD) {
		ArrayList<HoaDonBanHang> dsHD = new ArrayList<HoaDonBanHang>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from HoaDonBanHang where MaHoaDon = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maHD);
			rs = stmt.executeQuery();
			if (rs.next()) {
				String maHD1 = rs.getString("MaHoaDon");
				LocalDate ngayLap = rs.getDate("NgayLap").toLocalDate();
				NhanVien maNV = new NhanVien(rs.getString("MaNhanVien"));
				KhachHang maKH = new KhachHang(rs.getString("MaKhachHang"));
				HoaDonBanHang hd = new HoaDonBanHang(ngayLap, maHD1, maKH, maNV);
				dsHD.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHD;
	}

	// tìm kiếm theo mã kh
	public ArrayList<HoaDonBanHang> timMKH(String maKH1) {
		ArrayList<HoaDonBanHang> dsHD = new ArrayList<HoaDonBanHang>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from HoaDonBanHang where MaKhachHang = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maKH1);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String maHD1 = rs.getString("MaHoaDon");
				LocalDate ngayLap = rs.getDate("NgayLap").toLocalDate();
				NhanVien maNV = new NhanVien(rs.getString("MaNhanVien"));
				KhachHang maKH = new KhachHang(rs.getString("MaKhachHang"));
				HoaDonBanHang hd = new HoaDonBanHang(ngayLap, maHD1, maKH, maNV);
				dsHD.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHD;
	}

	// tìm kiếm theo mã kh
	public ArrayList<HoaDonBanHang> timNgay(LocalDate ngay) {
		ArrayList<HoaDonBanHang> dsHD = new ArrayList<HoaDonBanHang>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from HoaDonBanHang where NgayLap = ?";
		try {
			stmt = con.prepareStatement(sql);
			Date a = Date.valueOf(ngay);
			stmt.setDate(1, a);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String maHD1 = rs.getString("MaHoaDon");
				LocalDate ngayLap = rs.getDate("NgayLap").toLocalDate();
				NhanVien maNV = new NhanVien(rs.getString("MaNhanVien"));
				KhachHang maKH = new KhachHang(rs.getString("MaKhachHang"));
				HoaDonBanHang hd = new HoaDonBanHang(ngayLap, maHD1, maKH, maNV);
				dsHD.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHD;
	}

	// tao hd new
	public boolean create(HoaDonBanHang hdBH) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into HoaDonBanHang values(?, ?, ?, ?)");
			LocalDate ngayL = hdBH.getNgayL();
			Date ngay = Date.valueOf(ngayL);
			stmt.setString(1, hdBH.getMaHD());
			stmt.setDate(2, ngay);
			stmt.setString(3, hdBH.getMaKH().getSoDienThoai());
			stmt.setString(4, hdBH.getMaNV().getMaNhanVien());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	// Lấy tất cả hóa đơn BH
	public ArrayList<HoaDonBanHang> dsHD() {
		ArrayList<HoaDonBanHang> dsHD = new ArrayList<HoaDonBanHang>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from HoaDonBanHang";
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String maHD1 = rs.getString("MaHoaDon");
				LocalDate ngayLap = rs.getDate("NgayLap").toLocalDate();
				NhanVien maNV = new NhanVien(rs.getString("MaNhanVien"));
				KhachHang maKH = new KhachHang(rs.getString("MaKhachHang"));
				HoaDonBanHang hd = new HoaDonBanHang(ngayLap, maHD1, maKH, maNV);
				dsHD.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHD;
	}

	// Xóa hóa đơn theo mã
	public boolean deleteMHD(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from HoaDonBanHang where MaHoaDon = ?");
			stmt.setString(1, ma);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	// Xóa hóa đơn theo mã KH
	public boolean deleteMKH(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from HoaDonBanHang where MaKhachHang = ?");
			stmt.setString(1, ma);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public int maHD() {
		int mHD = 0;
		try {
			ConnectDB.getInstance();
			java.sql.Connection con = ConnectDB.getConnection();
			String sql = "select count(*) from HoaDonBanHang";
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
