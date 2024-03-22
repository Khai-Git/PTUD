package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import Entity.Entity_ChiTietPhieuDatPhong;
import Entity.Entity_KhachHang;
import Entity.Entity_PhieuDatPhong;

public class DAO_PhieuDatPhong {
	public ArrayList<Entity_PhieuDatPhong> DB_To_Table() {
		ArrayList<Entity_PhieuDatPhong> dsPhong = new ArrayList<Entity_PhieuDatPhong>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "select * from PhieuDatPhong";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				String maPhong = rs.getString(1);
				String maKH = rs.getString(2);
				String maCTPDP = rs.getString(3);
				Entity_KhachHang kh = new Entity_KhachHang(maKH);
				Entity_ChiTietPhieuDatPhong ctpdp = new Entity_ChiTietPhieuDatPhong(maCTPDP);
				
				Entity_PhieuDatPhong p = new Entity_PhieuDatPhong(maCTPDP, kh, ctpdp);
				
				dsPhong.add(p);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsPhong;
	}
}