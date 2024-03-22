package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import Entity.Entity_ChiTietHoaDonSanPham;
import Entity.Entity_HoaDonSanPham;
import Entity.Entity_SanPham;

public class DAO_QLDichVu {
	ArrayList<Entity_ChiTietHoaDonSanPham> dscthdsp;
	Entity_ChiTietHoaDonSanPham cthdsp;
	
	ArrayList<Entity_SanPham> dssp = new ArrayList<Entity_SanPham>();
	Entity_SanPham sp = new Entity_SanPham();
	
	public DAO_QLDichVu() {
		// TODO Auto-generated constructor stub
		dscthdsp = new ArrayList<Entity_ChiTietHoaDonSanPham>();
		cthdsp = new Entity_ChiTietHoaDonSanPham();
		
		dssp = new ArrayList<Entity_SanPham>();
		sp = new Entity_SanPham();
	}
	
	public ArrayList<Entity_SanPham> getAllTableSP(){
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "SELECT * FROM SanPham";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				String maSP = rs.getString(1);
				String tenSP = rs.getString(2);
				int sl = rs.getInt(3);
				int donGia = rs.getInt(4);
				
				Entity_SanPham sp = new Entity_SanPham(maSP, tenSP, sl, donGia);
				
				dssp.add(sp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return dssp;
	}
	
	public boolean themHDSP(Entity_HoaDonSanPham hdsp) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("INSERT INTO HoaDonSanPham values(?,?,?,?,?,?)");
			stmt.setString(1, hdsp.getMaCTHDSP().getMaCTHDSP());
			stmt.setString(2, hdsp.getNhanVien().getMaNV());
			stmt.setString(3, hdsp.getSanPham().getMaSP());
			stmt.setInt(4, hdsp.getSoLuong());
			stmt.setDouble(5, hdsp.getDonGia());
			stmt.setDouble(6, hdsp.getTongTienHD());
			n = stmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean themCTHDSP(Entity_ChiTietHoaDonSanPham cthdsp) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("INSERT INTO ChiTietHoaDonSanPham values(?,?,?,?)");
			stmt.setString(1, cthdsp.getMaCTHDSP());
			stmt.setString(2, cthdsp.getPhong().getMaPhong());
			stmt.setString(3, cthdsp.getKh().getMaKH());
			stmt.setString(4, cthdsp.getNgayLap());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return n > 0;
	}
	
	public boolean xoaHDSP(String maCTHDSP) {
		Connection con  = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("DELETE FROM ChiTietHoaDonSanPham where maCTHDSP = ?");
			stmt.setString(1, maCTHDSP);
			n = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}
}