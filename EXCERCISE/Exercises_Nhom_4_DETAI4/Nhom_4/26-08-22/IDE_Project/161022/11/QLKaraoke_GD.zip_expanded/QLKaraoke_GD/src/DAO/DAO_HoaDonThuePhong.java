package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import ConnectDB.ConnectDB;
import Entity.Entity_ChiTietHoaDonDatPhong;
import Entity.Entity_HoaDonDatPhong;
import Entity.Entity_KhachHang;
import Entity.Entity_NhanVien;
import Entity.Entity_Phong;


public class DAO_HoaDonThuePhong {
	ArrayList<Entity_HoaDonDatPhong> dstp;
	Entity_HoaDonDatPhong hddp;
	
	ArrayList<Entity_HoaDonDatPhong> dstp1;
	Entity_HoaDonDatPhong hddp1;
	
	DateFormat ngay = new SimpleDateFormat("dd-MM-yyyy");
	DateFormat gio = new SimpleDateFormat("HH:mm");
	Calendar cal = Calendar.getInstance();
	
	public DAO_HoaDonThuePhong() {
		// TODO Auto-generated constructor stub
		dstp = new ArrayList<Entity_HoaDonDatPhong>();
		hddp = new Entity_HoaDonDatPhong();
		
		dstp1 = new ArrayList<Entity_HoaDonDatPhong>();
		hddp1 = new Entity_HoaDonDatPhong();

	}
	public ArrayList<Entity_HoaDonDatPhong> getallThuePhong(){
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT HoaDonDatPhong.maHD, KhachHang.tenKH, KhachHang.sdt, Phong.tenPhong,HoaDonDatPhong.ngayDat, HoaDonDatPhong.gioVao, HoaDonDatPhong.gioRa, HoaDonDatPhong.tongGioDatPhong, HoaDonDatPhong.tongTien, NhanVien.tenNV, Phong.maPhong \r\n"
					+ "FROM HoaDonDatPhong\r\n"
					+ "JOIN ChiTietHoaDonDatPhong ON HoaDonDatPhong.chiTietHoaDonDatPhong = ChiTietHoaDonDatPhong.maCTHDDP\r\n"
					+ "JOIN NhanVien ON HoaDonDatPhong.nhanVien = NhanVien.maNv\r\n"
					+ "JOIN KhachHang ON HoaDonDatPhong.khachHang = KhachHang.maKH\r\n"
					+ "JOIN Phong ON ChiTietHoaDonDatPhong.maPhong = Phong.maPhong";
			java.sql.Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maHD = rs.getString(1);
				Entity_KhachHang khachHang = new Entity_KhachHang("",rs.getString(2),rs.getString(3),"","");
				Entity_Phong phong = new Entity_Phong(rs.getString(11),rs.getString(4),0,"",0.0,"");
				Entity_ChiTietHoaDonDatPhong chiTietHoaDonDatPhong = new Entity_ChiTietHoaDonDatPhong("",phong,0,0);
				String ngayDat = rs.getString(5);
				Entity_NhanVien nhanVien = null;
				String gioVao = null;
				String gioRa= null;
				int tongGiodat = 0;
				int tongTien= 0;
				
				Entity_HoaDonDatPhong hd = new Entity_HoaDonDatPhong(maHD,nhanVien,khachHang,chiTietHoaDonDatPhong,ngayDat,gioVao,gioRa,tongGiodat,tongTien);
				dstp.add(hd);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dstp;
	}
	
	public boolean checkGiora(String mahd) {
		int i = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			   stmt = con.prepareStatement("ALTER TABLE HoaDonDatPhong NOCHECK CONSTRAINT df_HDDP_NV, df_HDDP_KH, df_HDDP_CTHDDP\r\n"
			    			+ "update HoaDonDatPhong set gioRa = N'" + gio.format(cal.getTime()) +"' where maHD = '"+ mahd +"'\r\n"
			    			+ "ALTER TABLE HoaDonDatPhong CHECK CONSTRAINT df_HDDP_NV, df_HDDP_KH, df_HDDP_CTHDDP");
			 i = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return i > 0;
	}
	
	public boolean updateTongTien(String mahd) {
		int i = 0;
		try {	
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		
		Connection con1 = ConnectDB.getConnection();
		String sql = "SELECT HoaDonDatPhong.maHD, KhachHang.tenKH, KhachHang.sdt, Phong.tenPhong,HoaDonDatPhong.ngayDat, HoaDonDatPhong.gioVao, HoaDonDatPhong.gioRa, HoaDonDatPhong.tongGioDatPhong, HoaDonDatPhong.tongTien, NhanVien.tenNV, Phong.maPhong, Phong.tenLoai \r\n"
				+ "FROM HoaDonDatPhong\r\n"
				+ "JOIN ChiTietHoaDonDatPhong ON HoaDonDatPhong.chiTietHoaDonDatPhong = ChiTietHoaDonDatPhong.maCTHDDP\r\n"
				+ "JOIN NhanVien ON HoaDonDatPhong.nhanVien = NhanVien.maNv\r\n"
				+ "JOIN KhachHang ON HoaDonDatPhong.khachHang = KhachHang.maKH\r\n"
				+ "JOIN Phong ON ChiTietHoaDonDatPhong.maPhong = Phong.maPhong";
		java.sql.Statement statement = con1.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			String maHD = rs.getString(1);
			Entity_KhachHang khachHang = new Entity_KhachHang("",rs.getString(2),rs.getString(3),"","");
			Entity_Phong phong = new Entity_Phong(rs.getString(11),rs.getString(4),0,rs.getString(12),0.0,"");
			Entity_ChiTietHoaDonDatPhong chiTietHoaDonDatPhong = new Entity_ChiTietHoaDonDatPhong("",phong,0,0);
			String ngayDat = rs.getString(5);
			String tenLoai = rs.getString(12);
			Entity_NhanVien nhanVien = null;
			String gioVao = rs.getString(6);
			String gioRa= rs.getString(7);
			System.out.println(gioVao);
			System.out.println(gioRa);
		
		 SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

		 Date date1 = (Date) format.parse(gioVao);

		 Date date2 = (Date) format.parse(gioRa);

		 long difference = date2.getTime() - date1.getTime(); 

		 long diffSeconds = difference / 1000 % 60;
		 long diffMinutes = difference / (60 * 1000) % 60;
		 long diffHours = difference / (60 * 60 * 1000) % 24;
		 long diffDays = difference / (24 * 60 * 60 * 1000);
		 
		 boolean compareLoaiPhong = rs.getString(12).equals("Vip");
		 double giatiengio = 0.0;
		 double giatienphut = 0.0;
		 if(compareLoaiPhong) {
			 giatiengio = 300000;
			 giatienphut = 5000;
		 } else  {
			 giatiengio = 150000;
			 giatienphut = 2500;
		 }
	
		 Double tongtien = (double) (((diffHours * giatiengio) + (diffMinutes * giatienphut)) + (((diffHours * giatiengio) + (diffMinutes * giatienphut))*10/100));
		 
		 System.out.println("___________Start DeBug 1___________");
		 System.out.println(date1);
		 System.out.println(date2);
		 System.out.print(diffDays + " days, ");
		 System.out.print(diffHours + " hours, ");
		 System.out.print(diffMinutes + " minutes, ");
		 System.out.print(diffSeconds + " seconds.");
		 System.out.println(tongtien);
		 System.out.println("___________End DeBug 1___________");

			   stmt = con.prepareStatement("ALTER TABLE HoaDonDatPhong NOCHECK CONSTRAINT df_HDDP_NV, df_HDDP_KH, df_HDDP_CTHDDP\r\n"
			    			+ "update HoaDonDatPhong set tongTien = " + tongtien +" where maHD = '"+ mahd +"'\r\n"
			    			+ "ALTER TABLE HoaDonDatPhong CHECK CONSTRAINT df_HDDP_NV, df_HDDP_KH, df_HDDP_CTHDDP");
			 i = stmt.executeUpdate();
		}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return i > 0;
	}
	
	
	public ArrayList<Entity_HoaDonDatPhong> getallChiTietThuePhong(String mahd){
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT HoaDonDatPhong.maHD, KhachHang.sdt, KhachHang.tenKH, Phong.tenPhong,HoaDonDatPhong.ngayDat, HoaDonDatPhong.gioVao, HoaDonDatPhong.gioRa, HoaDonDatPhong.tongGioDatPhong, HoaDonDatPhong.tongTien, NhanVien.tenNV, Phong.tenLoai  \r\n"
					+ "FROM HoaDonDatPhong \r\n"
					+ "JOIN ChiTietHoaDonDatPhong ON HoaDonDatPhong.chiTietHoaDonDatPhong = ChiTietHoaDonDatPhong.maCTHDDP\r\n"
					+ "JOIN NhanVien ON HoaDonDatPhong.nhanVien = NhanVien.maNv \r\n"
					+ "JOIN Phong ON ChiTietHoaDonDatPhong.maPhong = Phong.maPhong\r\n"
					+ "left JOIN KhachHang ON HoaDonDatPhong.khachHang = KhachHang.maKH where HoaDonDatPhong.maHD = '"+mahd+"'";
			java.sql.Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maHD = rs.getString(1);
				Entity_KhachHang khachHang = new Entity_KhachHang("",rs.getString(3),rs.getString(2),"","");
				Entity_Phong phong = new Entity_Phong("",rs.getString(4),0,rs.getString(11),0.0,"");
				Entity_ChiTietHoaDonDatPhong chiTietHoaDonDatPhong = new Entity_ChiTietHoaDonDatPhong("",phong,0,0);
				String ngayLap = rs.getString(5);
				String gioVao = rs.getString(6).substring(0,5);
				String gioRa = rs.getString(7).substring(0,5);	
				int tongTien= rs.getInt(9);
				Entity_NhanVien nhanVien = null;
				int tongGiodat = 0;
				
				Entity_HoaDonDatPhong hd = new Entity_HoaDonDatPhong(maHD,nhanVien,khachHang,chiTietHoaDonDatPhong,ngayLap,gioVao,gioRa,tongGiodat,tongTien);
				dstp1.add(hd);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dstp1;
	}
	
	public boolean delete(String maHD) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null;
		int n = 0;
		try {
			
			String sql = "SELECT HoaDonDatPhong.maHD, ChiTietHoaDonDatPhong.maCTHDDP \r\n"
					+ "FROM HoaDonDatPhong \r\n"
					+ "JOIN ChiTietHoaDonDatPhong ON HoaDonDatPhong.chiTietHoaDonDatPhong = ChiTietHoaDonDatPhong.maCTHDDP\r\n"
					+ "JOIN NhanVien ON HoaDonDatPhong.nhanVien = NhanVien.maNv \r\n"
					+ "JOIN Phong ON ChiTietHoaDonDatPhong.maPhong = Phong.maPhong\r\n"
					+ "left JOIN KhachHang ON HoaDonDatPhong.khachHang = KhachHang.maKH where HoaDonDatPhong.maHD = '"+maHD+"'";
			java.sql.Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String mahoadon = rs.getString(1);
				String macthddp = rs.getString(2);
			
			stmt = con.prepareStatement("delete from HoaDonDatPhong where maHD = '"+maHD+"'");
			stmt.executeUpdate();

			stmt1 = con.prepareStatement("delete from ChiTietHoaDonDatPhong where maCTHDDP = '"+macthddp+"'");
			stmt1.executeUpdate();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public ArrayList<Entity_HoaDonDatPhong> getPhieuThueTheoTenPhong(String tenPhong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "SELECT HoaDonDatPhong.maHD, KhachHang.sdt, KhachHang.tenKH, Phong.tenPhong,HoaDonDatPhong.ngayDat, HoaDonDatPhong.gioVao, HoaDonDatPhong.gioRa, HoaDonDatPhong.tongGioDatPhong, HoaDonDatPhong.tongTien, NhanVien.tenNV, Phong.tenLoai  \r\n"
					+ "FROM HoaDonDatPhong \r\n"
					+ "JOIN ChiTietHoaDonDatPhong ON HoaDonDatPhong.chiTietHoaDonDatPhong = ChiTietHoaDonDatPhong.maCTHDDP\r\n"
					+ "JOIN NhanVien ON HoaDonDatPhong.nhanVien = NhanVien.maNv \r\n"
					+ "JOIN KhachHang ON HoaDonDatPhong.khachHang = KhachHang.maKH\r\n"
					+ "LEFT JOIN Phong ON ChiTietHoaDonDatPhong.maPhong = Phong.maPhong where Phong.tenPhong = N'"+tenPhong+"'";
			java.sql.Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maHD = rs.getString(1);
				Entity_KhachHang khachHang = new Entity_KhachHang("",rs.getString(2),rs.getString(3),"","");
				Entity_Phong phong = new Entity_Phong(rs.getString(11),rs.getString(4),0,"",0.0,"");
				Entity_ChiTietHoaDonDatPhong chiTietHoaDonDatPhong = new Entity_ChiTietHoaDonDatPhong("",phong,0,0);
				String ngayDat = rs.getString(5);
				Entity_NhanVien nhanVien = null;
				String gioVao = null;
				String gioRa= null;
				int tongGiodat = 0;
				int tongTien= 0;
				
				Entity_HoaDonDatPhong hd = new Entity_HoaDonDatPhong(maHD,nhanVien,khachHang,chiTietHoaDonDatPhong,ngayDat,gioVao,gioRa,tongGiodat,tongTien);
				dstp.add(hd);
			}
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return dstp;
	}
	
	public ArrayList<Entity_HoaDonDatPhong> updatePhieuThuePhong123(String maPhongcu, String maPhongmoi) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "ALTER TABLE ChiTietHoaDonDatPhong NOCHECK CONSTRAINT df_CTHDDP_Phong\r\n"
					+ "update ChiTietHoaDonDatPhong set maPhong = '"+maPhongmoi+"' where maPhong = '"+maPhongcu+"'\r\n"
					+ "ALTER TABLE ChiTietHoaDonDatPhong CHECK CONSTRAINT df_CTHDDP_Phong";
			java.sql.Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maHD = rs.getString(1);
				Entity_KhachHang khachHang = new Entity_KhachHang("",rs.getString(2),rs.getString(3),"","");
				Entity_Phong phong = new Entity_Phong(rs.getString(11),rs.getString(4),0,"",0.0,"");
				Entity_ChiTietHoaDonDatPhong chiTietHoaDonDatPhong = new Entity_ChiTietHoaDonDatPhong("",phong,0,0);
				String ngayDat = rs.getString(5);
				Entity_NhanVien nhanVien = null;
				String gioVao = null;
				String gioRa= null;
				int tongGiodat = 0;
				int tongTien= 0;
				
				Entity_HoaDonDatPhong hd = new Entity_HoaDonDatPhong(maHD,nhanVien,khachHang,chiTietHoaDonDatPhong,ngayDat,gioVao,gioRa,tongGiodat,tongTien);
				dstp.add(hd);
			}
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return dstp;
	}
	
	public boolean updatePhieuThuePhong(String maPhongmoi, String maPhongcu) {
		int i = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			   stmt = con.prepareStatement("ALTER TABLE ChiTietHoaDonDatPhong NOCHECK CONSTRAINT df_CTHDDP_Phong\r\n"
						+ "update ChiTietHoaDonDatPhong set maPhong = '"+maPhongmoi+"' where maPhong = '"+maPhongcu+"'\r\n"
						+ "ALTER TABLE ChiTietHoaDonDatPhong CHECK CONSTRAINT df_CTHDDP_Phong");
			 i = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return i > 0;
	}
}
