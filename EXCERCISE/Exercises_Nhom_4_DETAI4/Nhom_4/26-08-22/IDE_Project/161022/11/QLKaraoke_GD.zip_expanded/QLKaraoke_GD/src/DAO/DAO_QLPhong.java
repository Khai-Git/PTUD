package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entity.Entity_Phong;
import ConnectDB.ConnectDB;
import Entity.Entity_LoaiPhong;


public class DAO_QLPhong {
	ArrayList<Entity_Phong> dsp;
	Entity_Phong phong;
	
	ArrayList<Entity_LoaiPhong> dslp;
	Entity_LoaiPhong loaiphong;
	
	public DAO_QLPhong() {
		// TODO Auto-generated constructor stub
		dsp = new ArrayList<Entity_Phong>();
		phong = new Entity_Phong();
		dslp = new ArrayList<Entity_LoaiPhong>();
		loaiphong = new Entity_LoaiPhong();
	}
	public ArrayList<Entity_Phong> getallPhongDangSuDung(){
		ArrayList<Entity_Phong> dsphong = new ArrayList<Entity_Phong>();
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from Phong p where p.trangThai like N'Đang sử dụng'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				//Phong
				String maPhong = rs.getString(1);
				String tenPhong = rs.getString(2);
				String trangThai = rs.getString(3);
				int sucChua = rs.getInt(4);
				String tenLoai = rs.getString(5);
				int donGia = rs.getInt(6);
				
				Entity_Phong p = new Entity_Phong(maPhong, tenPhong, sucChua, tenLoai, donGia, trangThai);
				
				dsphong.add(p);  
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsphong;
	}
	public ArrayList<Entity_Phong> getallPhong(){
		ArrayList<Entity_Phong> dsphong = new ArrayList<Entity_Phong>();
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from Phong";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				//Phong
				String maPhong = rs.getString(1);
				String tenPhong = rs.getString(2);
				String trangThai = rs.getString(3);
				int sucChua = rs.getInt(4);
				String tenLoai = rs.getString(5);
				int donGia = rs.getInt(6);
				
				Entity_Phong p = new Entity_Phong(maPhong, tenPhong, sucChua, tenLoai, donGia, trangThai);
				
				dsphong.add(p);  
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsphong;
	}
	public ArrayList<Entity_Phong> getallPhongTrong(){
		ArrayList<Entity_Phong> dsphong = new ArrayList<Entity_Phong>();
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from Phong p where p.trangThai like N'Trống'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				//Phong
				String maPhong = rs.getString(1);
				String tenPhong = rs.getString(2);
				String trangThai = rs.getString(3);
				int sucChua = rs.getInt(4);
				String tenLoai = rs.getString(5);
				int donGia = rs.getInt(6);
				
				Entity_Phong p = new Entity_Phong(maPhong, tenPhong, sucChua, tenLoai, donGia, trangThai);
				
				dsphong.add(p);  
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsphong;
	}
	public boolean createPhong(Entity_Phong p) {
		ConnectDB.getConnection();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into Phong values(?,?,?,?,?,?)");
			stmt.setString(1, p.getMaPhong());
			stmt.setString(2, p.getTenPhong());
			stmt.setDouble(6, p.getDonGia());
			stmt.setString(5, p.getTenLoai());
			stmt.setInt(4, p.getSucChua());
			stmt.setString(3, p.getTrangThai());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean delete(String maPhong) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from Phong where maPhong = ?");
			stmt.setString(1, maPhong);
			n = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}
	// update
	public boolean update(Entity_Phong p) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update Phong set tenPhong = ?, trangThai = ?, sucChua = ?, tenLoai = ?, donGia=? where maPhong = ?");
			stmt.setString(1, p.getTenPhong());
			stmt.setString(2, p.getTrangThai());
			stmt.setInt(3, p.getSucChua());
			stmt.setString(4, p.getTenLoai());
			stmt.setDouble(5, p.getDonGia());
			stmt.setString(6, p.getMaPhong());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean updateTinhTrangPhongTrong(String maPhong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update Phong set trangThai = N'Trống' where maPhong = '"+maPhong+"'");
			n = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean updateTinhTrangPhongSD(String maPhong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update Phong set trangThai = N'Đang sử dụng' where maPhong = '"+maPhong+"'");
			n = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}
}