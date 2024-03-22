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
import Entity.HoaDonNhapHang;
import Entity.NhaCungCap;
import Entity.NhanVien;

public class HoaDonNhapHang_DAO {

	// tim theo ma hoa don
	public ArrayList<HoaDonNhapHang> dsMHD(String maHD) {
		ArrayList<HoaDonNhapHang> dsHD = new ArrayList<HoaDonNhapHang>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from HoaDonNhapHang where MaHoaDon = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maHD);
			rs = stmt.executeQuery();
			if (rs.next()) {
				String maHD1 = rs.getString("MaHoaDon");
				LocalDate ngayLap = rs.getDate("NgayLap").toLocalDate();
				NhanVien maNV = new NhanVien(rs.getString("MaNhanVien"));
				NhaCungCap maNCC = new NhaCungCap(rs.getString("MaNhaCungCap"));
				HoaDonNhapHang hdNH = new HoaDonNhapHang(maHD1, ngayLap, maNV, maNCC);
				dsHD.add(hdNH);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHD;
	}

	// tim theo ma nha cung cap
	public ArrayList<HoaDonNhapHang> getMNCC(String maNCC1) {
		ArrayList<HoaDonNhapHang> dsHD = new ArrayList<HoaDonNhapHang>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from HoaDonNhapHang where MaNhaCungCap = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maNCC1);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String maHD1 = rs.getString("MaHoaDon");
				LocalDate ngayLap = rs.getDate("NgayLap").toLocalDate();
				NhanVien maNV = new NhanVien(rs.getString("MaNhanVien"));
				NhaCungCap maNCC = new NhaCungCap(rs.getString("MaNhaCungCap"));
				HoaDonNhapHang hdNH = new HoaDonNhapHang(maHD1, ngayLap, maNV, maNCC);
				dsHD.add(hdNH);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHD;
	}

	// tim theo ngay
	public ArrayList<HoaDonNhapHang> getNL(LocalDate ngay) {
		ArrayList<HoaDonNhapHang> dsHD = new ArrayList<HoaDonNhapHang>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from HoaDonNhapHang where NgayLap = ?";
		try {
			stmt = con.prepareStatement(sql);
			Date a = Date.valueOf(ngay);
			stmt.setDate(1, a);
			rs = stmt.executeQuery();
			if (rs.next()) {
				String maHD1 = rs.getString("MaHoaDon");
				LocalDate ngayLap = rs.getDate("NgayLapHoaDon").toLocalDate();
				NhanVien maNV = new NhanVien(rs.getString("MaNhanVien"));
				NhaCungCap maNCC = new NhaCungCap(rs.getString("MaNhaCungCap"));
				HoaDonNhapHang hdNH = new HoaDonNhapHang(maHD1, ngayLap, maNV, maNCC);
				dsHD.add(hdNH);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHD;
	}

	public ArrayList<HoaDonNhapHang> dsHD() {
		ArrayList<HoaDonNhapHang> dsHD = new ArrayList<HoaDonNhapHang>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from HoaDonNhapHang";
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String maHD1 = rs.getString("MaHoaDon");
				LocalDate ngayLap = rs.getDate("NgayLap").toLocalDate();
				NhanVien maNV = new NhanVien(rs.getString("MaNhanVien"));
				NhaCungCap maNCC = new NhaCungCap(rs.getString("MaNhaCungCap"));
				HoaDonNhapHang hdNH = new HoaDonNhapHang(maHD1, ngayLap, maNV, maNCC);
				dsHD.add(hdNH);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHD;
	}

	// tao hd new
	public boolean create(HoaDonNhapHang hdNH) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into HoaDonNhapHang values(?, ?, ?, ?)");
			LocalDate ngayL = hdNH.getNgayL();
			Date ngay = Date.valueOf(ngayL);
			stmt.setString(1, hdNH.getMaHD());
			stmt.setDate(2, ngay);
			stmt.setString(3, hdNH.getMaNCC().getMaNhaCungCap());
			stmt.setString(4, hdNH.getMaNV().getMaNhanVien());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	// xoa theo ma
	public boolean delete(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from HoaDonNhapHang where MaHoaDon = ?");
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
