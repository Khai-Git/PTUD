package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import Entity.Entity_KhachHang;

public class DAO_QLKhachHang {
	ArrayList<Entity_KhachHang> dskh = new ArrayList<Entity_KhachHang>();
	Entity_KhachHang kh = new Entity_KhachHang();
	
	public ArrayList<Entity_KhachHang> getAllTableKH(){
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from KhachHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				String maKH = rs.getString(1);
				String tenKH = rs.getString(2);
				String diaChi = rs.getString(3);
				String sdt = rs.getString(4);
				String cmnd = rs.getString(5);
				
				Entity_KhachHang kh = new Entity_KhachHang(maKH, tenKH, diaChi, sdt, cmnd);
				
				dskh.add(kh);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return dskh;
	}
	
	public boolean themKH(Entity_KhachHang kh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into KhachHang values(?,?,?,?,?)");
			stmt.setString(1, kh.getMaKH());
			stmt.setString(2, kh.getTenKH());
			stmt.setString(3, kh.getSoDienThoai());
			stmt.setString(4, kh.getDiaChi());
			stmt.setString(5, kh.getCMND());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean xoaKH(String maKH) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from KhachHang where maKH = ?");
			stmt.setString(1, maKH);
			n = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean capNhatKH(Entity_KhachHang kh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update KhachHang set tenKH=?, sdt=?, diaChi=?, cmnd=? where maKH=?");
			stmt.setString(1, kh.getTenKH());
			stmt.setString(2, kh.getSoDienThoai());
			stmt.setString(3, kh.getDiaChi());
			stmt.setString(4, kh.getCMND());
			stmt.setString(5, kh.getMaKH());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public ArrayList<Entity_KhachHang> timKH(String sdtFind, String cmndFind){
		ArrayList<Entity_KhachHang> dskh = new ArrayList<Entity_KhachHang>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Select * from KhachHang where sdt = ? and cmnd = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, sdtFind);
			statement.setString(2, cmndFind);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				String maKH = rs.getString(1);
				String tenKH = rs.getString(2);
				String diaChi = rs.getString(3);
				String sdt = rs.getString(4);
				String cmnd = rs.getString(5);
				
				Entity_KhachHang kh = new Entity_KhachHang(maKH, tenKH, diaChi, sdt, cmnd);
				
				dskh.add(kh);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dskh;
	}
}