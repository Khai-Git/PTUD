package Dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import Entity.ChiTietHDBH;
import Entity.HoaDonBanHang;
import Entity.SanPham;

public class ChiTietHDBH_Dao {

	// tìm theo ma hoa don
	public ArrayList<ChiTietHDBH> getMHD(String ma) {
		ArrayList<ChiTietHDBH> cthd = new ArrayList<ChiTietHDBH>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from ChiTietHoaDonBH where MaHoaDon = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ma);
			rs = stmt.executeQuery();
			while (rs.next()) {
				HoaDonBanHang maHD = new HoaDonBanHang(rs.getString("MaHoaDon"));
				SanPham maSP = new SanPham(rs.getString("MaSanPham"));
				int soL = rs.getInt("SoLuong");
				BigDecimal tt = rs.getBigDecimal("ThanhTien");
				ChiTietHDBH dsCTHD = new ChiTietHDBH(maHD, maSP, soL, tt);
				cthd.add(dsCTHD);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cthd;
	}

	// tìm theo ma hoa don
		public ArrayList<ChiTietHDBH> getMSP(String ma) {
			ArrayList<ChiTietHDBH> cthd = new ArrayList<ChiTietHDBH>();
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			String sql = "select * from ChiTietHoaDonBH where MaSanPham = ?";
			try {
				stmt = con.prepareStatement(sql);
				stmt.setString(1, ma);
				rs = stmt.executeQuery();
				while (rs.next()) {
					HoaDonBanHang maHD = new HoaDonBanHang(rs.getString("MaHoaDon"));
					SanPham maSP = new SanPham(rs.getString("MaSanPham"));
					int soL = rs.getInt("SoLuong");
					BigDecimal tt = rs.getBigDecimal("ThanhTien");
					ChiTietHDBH dsCTHD = new ChiTietHDBH(maHD, maSP, soL, tt);
					cthd.add(dsCTHD);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return cthd;
		}

	
	//
	public boolean create(ChiTietHDBH hdBH) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into ChiTietHoaDonBH values(?, ?, ?, ?)");
			stmt.setString(1, hdBH.getMaHD().getMaHD());
			stmt.setString(2, hdBH.getMaSP().getMaSanPham());
			stmt.setInt(3, hdBH.getSoL());
			stmt.setBigDecimal(4, hdBH.gettT());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	//
	public boolean deleteMHD(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from ChiTietHoaDonBH where MaHoaDon = ?");
			stmt.setString(1, ma);
			n = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
}
