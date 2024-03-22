package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import Entity.NhaCungCap;

public class NhaCungCap_DAO {
	// Tìm số điện thoại
	public ArrayList<NhaCungCap> timSDT(String sdt) {
		ArrayList<NhaCungCap> ncc1 = new ArrayList<NhaCungCap>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from NhaCungCap where SoDienThoai = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, sdt);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String maNCC = rs.getString("MaNhaCungCap");
				String tenNCC = rs.getString("TenNhaCungCap");
				String diaChi = rs.getString("DiaChi");
				String soDT = rs.getString("SoDienThoai");
				String email = rs.getString("Email");
				NhaCungCap dsncc = new NhaCungCap(maNCC, tenNCC, diaChi, soDT, email);
				ncc1.add(dsncc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ncc1;
	}

	public ArrayList<NhaCungCap> timMNCC(String ma) {
		ArrayList<NhaCungCap> ncc1 = new ArrayList<NhaCungCap>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from NhaCungCap where MaNhaCungCap = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ma);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String maNCC = rs.getString("MaNhaCungCap");
				String tenNCC = rs.getString("TenNhaCungCap");
				String diaChi = rs.getString("DiaChi");
				String soDT = rs.getString("SoDienThoai");
				String email = rs.getString("Email");
				NhaCungCap dsncc = new NhaCungCap(maNCC, tenNCC, diaChi, soDT, email);
				ncc1.add(dsncc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ncc1;
	}

	// Tìm theo tên nhà cung cấp
	public ArrayList<NhaCungCap> timTNCC(String ten) {
		ArrayList<NhaCungCap> ncc1 = new ArrayList<NhaCungCap>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from NhaCungCap where TenNhaCungCap = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ten);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String maNCC = rs.getString("MaNhaCungCap");
				String tenNCC = rs.getString("TenNhaCungCap");
				String diaChi = rs.getString("DiaChi");
				String soDT = rs.getString("SoDienThoai");
				String email = rs.getString("Email");
				NhaCungCap dsncc = new NhaCungCap(maNCC, tenNCC, diaChi, soDT, email);
				ncc1.add(dsncc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ncc1;
	}

	// Lấy ds nha cung cap
	public ArrayList<NhaCungCap> getDSNCC() {
		ArrayList<NhaCungCap> dsNCC = new ArrayList<NhaCungCap>();
		ConnectDB.getInstance();
		java.sql.Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from NhaCungCap";
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String maNCC = rs.getString("MaNhaCungCap");
				String tenNCC = rs.getString("TenNhaCungCap");
				String diaChi = rs.getString("DiaChi");
				String soDT = rs.getString("SoDienThoai");
				String email = rs.getString("Email");
				NhaCungCap dsncc = new NhaCungCap(maNCC, tenNCC, diaChi, soDT, email);
				dsNCC.add(dsncc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsNCC;
	}

	// tạo nhà cung cấp mới
	public boolean create(NhaCungCap ncc) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into NhaCungCap values(?,?,?,?,?)");
			stmt.setString(1, ncc.getMaNhaCungCap());
			stmt.setString(2, ncc.getTenNhaCungCap());
			stmt.setString(3, ncc.getEmail());
			stmt.setString(4, ncc.getSoDienThoai());
			stmt.setString(5, ncc.getDiaChi());
			n = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	// update nhà cung cấp mới
	public boolean update(NhaCungCap ncc) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(
					"update NhaCungCap set TenNhaCungCap = ?, DiaChi = ?, SoDienThoai = ?, Email = ? where MaNhaCungCap = ?");
			stmt.setString(5, ncc.getMaNhaCungCap());
			stmt.setString(1, ncc.getTenNhaCungCap());
			stmt.setString(4, ncc.getEmail());
			stmt.setString(3, ncc.getSoDienThoai());
			stmt.setString(2, ncc.getDiaChi());
			n = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	// xóa nhà cung cấp
	public boolean deleteMNCC(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from NhaCungCap where MaNhaCungCap = ?");
			stmt.setString(1, ma);
			n = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public int mancc() {
		int maNCC = 0;
		try {
			ConnectDB.getInstance();
			java.sql.Connection con = ConnectDB.getConnection();
			String sql = "select count(*) from NhaCungCap";
			java.sql.Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				maNCC = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maNCC;
	}
}
