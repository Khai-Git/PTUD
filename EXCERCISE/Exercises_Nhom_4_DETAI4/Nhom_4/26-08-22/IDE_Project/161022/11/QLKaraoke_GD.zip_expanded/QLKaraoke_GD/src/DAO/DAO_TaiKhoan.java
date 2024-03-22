package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.ConnectDB;
import Entity.Entity_TaiKhoan;



public class DAO_TaiKhoan {
	ArrayList<Entity_TaiKhoan> dstk;
	Entity_TaiKhoan taikhoan;
	
	public DAO_TaiKhoan() {
		// TODO Auto-generated constructor stub
		dstk = new ArrayList<Entity_TaiKhoan>();
		taikhoan = new Entity_TaiKhoan();

	}
	public ArrayList<Entity_TaiKhoan> getallTaiKhoan(){
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select *from TaiKhoan";
			java.sql.Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String taikhoanNv = rs.getString(1);
				String matkhau = rs.getString(2);
				Entity_TaiKhoan tk = new Entity_TaiKhoan(taikhoanNv, matkhau);
				dstk.add(tk);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dstk;
	}
	public boolean createTaiKhoan(Entity_TaiKhoan tk) {
		ConnectDB.getConnection();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into TaiKhoan values(N'?',N'?')");
			stmt.setString(1, tk.getTaikhoanNv());
			stmt.setString(2, tk.getMatKhau());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean delete(String taiKhoan) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from TaiKhoan where taiKhoan = N'?'");
			stmt.setString(1, taiKhoan);
			n = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}
	// update
	public boolean update(Entity_TaiKhoan tk) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update TaiKhoan set matKhau = N'?' where taiKhoan = N'?'");
			stmt.setString(1, tk.getTaikhoanNv());
			stmt.setString(2, tk.getMatKhau());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}
}
