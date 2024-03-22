package Dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import Entity.ChiTietHDNH;
import Entity.HoaDonNhapHang;
import Entity.SanPham;

public class ChiTietHDNH_Dao {
	// tìm theo ma hoa don
	public ArrayList<ChiTietHDNH> getMHD(String ma) {
		ArrayList<ChiTietHDNH> cthd = new ArrayList<ChiTietHDNH>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from ChiTieTHoaDonNH where MaHoaDon = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ma);
			rs = stmt.executeQuery();
			while (rs.next()) {
				HoaDonNhapHang maHD = new HoaDonNhapHang(rs.getString("MaHoaDon"));
				SanPham maSP = new SanPham(rs.getString("MaSanPham"));
				String lH = rs.getString("LoHang");
				int soL = rs.getInt("SoLuong");
				BigDecimal tt = rs.getBigDecimal("ThanhTien");
				ChiTietHDNH dsCTHD = new ChiTietHDNH(maHD, maSP, lH, soL, tt);
				cthd.add(dsCTHD);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cthd;
	}

	// tìm theo ma hoa don
		public ArrayList<ChiTietHDNH> getMSP(String ma) {
			ArrayList<ChiTietHDNH> cthd = new ArrayList<ChiTietHDNH>();
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			String sql = "select * from ChiTieTHoaDonNH where MaSanPham = ?";
			try {
				stmt = con.prepareStatement(sql);
				stmt.setString(1, ma);
				rs = stmt.executeQuery();
				while (rs.next()) {
					HoaDonNhapHang maHD = new HoaDonNhapHang(rs.getString("MaHoaDon"));
					SanPham maSP = new SanPham(rs.getString("MaSanPham"));
					String lH = rs.getString("LoHang");
					int soL = rs.getInt("SoLuong");
					BigDecimal tt = rs.getBigDecimal("ThanhTien");
					ChiTietHDNH dsCTHD = new ChiTietHDNH(maHD, maSP, lH, soL, tt);
					cthd.add(dsCTHD);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return cthd;
		}
	
	// Tạo hd mới
	public boolean create(ChiTietHDNH hdNH) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into ChiTieTHoaDonNH values(?,?,?,?,?)");
			stmt.setString(1, hdNH.getMaHD().getMaHD());
			stmt.setString(2, hdNH.getMaSP().getMaSanPham());
			stmt.setInt(3, hdNH.getsL());
			stmt.setString(4, hdNH.getlH());
			stmt.setBigDecimal(5, hdNH.getTt());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	} 
	
	//xoa cthd
	public boolean deleteMHD(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from ChiTietHoaDonNH where MaHoaDon = ?");
			stmt.setString(1, ma);
			n = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
}
