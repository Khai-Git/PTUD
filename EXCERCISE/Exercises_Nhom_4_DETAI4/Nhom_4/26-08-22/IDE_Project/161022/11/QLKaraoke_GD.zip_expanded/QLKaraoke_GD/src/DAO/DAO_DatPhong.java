package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import ConnectDB.ConnectDB;
import Entity.Entity_ChiTietHoaDonDatPhong;
import Entity.Entity_ChiTietPhieuDatPhong;
import Entity.Entity_HoaDonDatPhong;
import Entity.Entity_KhachHang;
import Entity.Entity_NhanVien;
import Entity.Entity_PhieuDatPhong;
import Entity.Entity_Phong;
import GUI.GUI_DatPhong;
import DAO.DAO_QLPhong;

public class DAO_DatPhong {	
	DateFormat ngay = new SimpleDateFormat("dd-MM-yyyy");
	DateFormat gio = new SimpleDateFormat("HH:mm");
	Calendar cal = Calendar.getInstance();
	
	public boolean themPhieu(Entity_HoaDonDatPhong hddp) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null;
		int n = 0;
		int n1 = 0;
		try {
			stmt = con.prepareStatement("INSERT INTO ChiTietHoaDonDatPhong values (?,?,?,?)");
			stmt1 = con.prepareStatement("INSERT INTO HoaDonDatPhong values (?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, hddp.getChiTietHoaDon().getMaCTHDDP());
			stmt.setString(2, hddp.getChiTietHoaDon().getPhong().getMaPhong());
			stmt.setInt(3, hddp.getChiTietHoaDon().getSoLuong());
			stmt.setInt(4, hddp.getChiTietHoaDon().getDonGiaDatPhong());
			stmt1.setString(1, hddp.getMaHD());
			stmt1.setString(2, hddp.getNhanVien().getMaNV());
			stmt1.setString(3, hddp.getKhachHang().getMaKH());
			stmt1.setString(4, hddp.getChiTietHoaDon().getMaCTHDDP());
			stmt1.setString(5, hddp.getNgayDatPhong());
			stmt1.setString(6, hddp.getGioVao());
			stmt1.setString(7, hddp.getGioRa());
			stmt1.setDouble(8, hddp.TongGioDatPhong());
			stmt1.setDouble(9, hddp.getTongTien());
			n = stmt.executeUpdate();
			n1 = stmt1.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0 && n1 >0;
	}
	
	public boolean themKH(Entity_PhieuDatPhong p) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into PhieuDatPhong values(N'?', N'?', N'?')");
			
			n = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}
}