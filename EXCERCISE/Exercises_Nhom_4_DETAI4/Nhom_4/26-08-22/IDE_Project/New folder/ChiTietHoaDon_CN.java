package ChucNang;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;

import ConnectDB.ConnectDB;
import Entity.ChiTietHoaDon;
import Entity.NhanVien;

public class ChiTietHoaDon_CN {
	ArrayList<ChiTietHoaDon> dscthd;
	ChiTietHoaDon cthd;
	public ChiTietHoaDon_CN() {
		dscthd =new ArrayList<ChiTietHoaDon>();
		cthd = new ChiTietHoaDon();
	}
	public boolean createCTHD(ChiTietHoaDon cthd) {

		ConnectDB.getInstance();
		Connection conDB = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = conDB.prepareStatement("insert into ChiTietHoaDon values(?,?,?,?,?,?)");
			stmt.setString(1, cthd.getHoaDon().getMaHD());
			stmt.setString(2, cthd.getSanPham().getMaSP());
			stmt.setString(3, cthd.getSanPham().getTenSP());
			stmt.setInt(4, cthd.getSoLuong());
			stmt.setDouble(5, cthd.getSanPham().getGiaSP());
			stmt.setDouble(6, cthd.getThanhTien());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n>0;
	}
	public boolean delete(String maSP2) {
		Connection conDB = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = conDB.prepareStatement("delete from ChiTietHoaDon where maSP = ?");
			stmt.setString (0,maSP2);
			n = stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
}
