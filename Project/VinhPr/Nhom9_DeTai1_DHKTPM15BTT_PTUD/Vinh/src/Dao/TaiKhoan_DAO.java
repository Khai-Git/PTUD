package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ConnectDB.ConnectDB;
import Entity.NhanVien;
import Entity.TaiKhoan;

public class TaiKhoan_DAO {

	// tìm tài khoản theo ma
	public ArrayList<TaiKhoan> getID(String ma) {
		ArrayList<TaiKhoan> tkID = new ArrayList<TaiKhoan>();
		ConnectDB.getInstance();
		java.sql.Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from TaiKhoan where MaNhanVien = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ma);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String idTK = rs.getString("ID");
				String pass = rs.getString("Pass");
				NhanVien maNV = new NhanVien(rs.getString("MaNhanVien"));
				TaiKhoan dsTK = new TaiKhoan(maNV, idTK, pass);
				tkID.add(dsTK);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tkID;
	}

	// tạo tài khoản mới
	public boolean create(TaiKhoan tk) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into TaiKhoan values(?,?,?)");
			stmt.setString(1, tk.getMaNV().getMaNhanVien());
			stmt.setString(2, tk.getTaiKhoan());
			stmt.setString(3, tk.getPass());
			n = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	// xóa nhân viên
	public boolean deleteNV(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from TaiKhoan where MaNhanVien = ?");
			stmt.setString(1, ma);
			n = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
}
