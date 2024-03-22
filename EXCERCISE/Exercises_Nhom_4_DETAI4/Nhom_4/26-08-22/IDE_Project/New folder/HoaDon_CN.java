package ChucNang;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ConnectDB.ConnectDB;
import Entity.HoaDon;
import Entity.KhachHang;
import Entity.NhanVien;

public class HoaDon_CN {
	   ArrayList<HoaDon> dshd;
	   HoaDon hd;
	public HoaDon_CN() {
		dshd=new ArrayList<HoaDon>();
		hd = new HoaDon();
	}
//	public ArrayList<HoaDon> getAllTBHoaDon() {
//		try {
//			   Connection conDB = ConnectDB.getInstance().getConnection();
//				String sql = "SELECT * FROM HoaDon";
//				Statement statement = conDB.createStatement();
//				ResultSet rs = statement.executeQuery(sql);
//				while(rs.next()) {
//					String maHD =rs.getString(1);
//					Date ngayLapHD=rs.getDate(2);
//					String maNV=rs.getString(3);
//					String tenNV=rs.getString(4);
//					String maKH=rs.getString(5);
//					String VAT=rs.getString(6);
//					Double tongTien=rs.getDouble(7);
//					Double tienNhan=rs.getDouble(8);
//					Double tienThua=rs.getDouble(9);
//					
//					HoaDon s = new HoaDon(maHD, ngayLapHD,new NhanVien(maNV, tenNV),new KhachHang(maKH),VAT,tongTien,tienNhan,tienThua);
//			        dshd.add(s);
//				}
//		}catch (SQLException e ) {
//			   e.printStackTrace();
//		}
//		return dshd;
//		}
	public boolean createHD(HoaDon hd) {
		JOptionPane.showMessageDialog(null, hd);
		  ConnectDB.getInstance();
		  Connection conDB = ConnectDB.getConnection();
		  PreparedStatement stmt = null;
		  int n = 0;
		  try {
			stmt = conDB.prepareStatement("insert into HoaDon values(?,?,?,?,?,?,?,?,?)");
			stmt.setString(1,hd.getMaHD());
			stmt.setDate(2,hd.getNgayLapHD());
			stmt.setString(3,hd.getNhanVien().getMaNV());
			stmt.setString(4,hd.getNhanVien().getTenNV());
			stmt.setString(5,hd.getKhachHang().getMaKH());
			stmt.setDouble(6,hd.getVAT());
			stmt.setDouble(7,hd.getTongTien());
			stmt.setDouble(8,hd.getTienNhan());
			stmt.setDouble(9,hd.getTienthoi());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		  return n>0;
	}
	public boolean delete(String maHD) {
		  Connection conDB = ConnectDB.getInstance().getConnection();
		  PreparedStatement stmt = null;
		  int n = 0;
		  try {
			  stmt = conDB.prepareStatement("delete from HoaDon where maHD = ?");
			  stmt.setString (1,maHD);
			  n = stmt.executeUpdate();
		  }catch(SQLException e) {
			  e.printStackTrace();
		  }
		  return n > 0;
	}
}
