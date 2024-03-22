package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import ConnectDB.ConnectDB;
import Entity.Entity_ChiTietHoaDonSanPham;
import Entity.Entity_HoaDonSanPham;
import Entity.Entity_KhachHang;
import Entity.Entity_NhanVien;
import Entity.Entity_Phong;
import Entity.Entity_SanPham;
import other.PDF_IText;

public class DAO_QLHoaDonSanPham {
	ArrayList<Entity_HoaDonSanPham> dshd = new ArrayList<Entity_HoaDonSanPham>();
	Entity_HoaDonSanPham hd = new Entity_HoaDonSanPham();
	
	
	
	ArrayList<Entity_ChiTietHoaDonSanPham> dscthd = new ArrayList<Entity_ChiTietHoaDonSanPham>();
	Entity_ChiTietHoaDonSanPham cthd = new Entity_ChiTietHoaDonSanPham();
	
	
	public ArrayList<Entity_HoaDonSanPham> getAllHoaDonDichVu(String tenPhong){
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT ChiTietHoaDonSanPham.maCTHDSP, HoaDonSanPham.soLuong, HoaDonSanPham.donGia, ChiTietHoaDonSanPham.ngayLap,\r\n"
					+ "SanPham.maSP, SanPham.tenSP, SanPham.donGia, Phong.maPhong, Phong.tenPhong, KhachHang.maKH, KhachHang.tenKH, KhachHang.sdt,\r\n"
					+ "NhanVien.maNv, NhanVien.tenNV, HoaDonSanPham.chiTietHoaDonSanPham, HoaDonSanPham.tongTien\r\n"
					+ "FROM HoaDonSanPham \r\n"
					+ "JOIN ChiTietHoaDonSanPham ON HoaDonSanPham.chiTietHoaDonSanPham = ChiTietHoaDonSanPham.maCTHDSP\r\n"
					+ "JOIN NhanVien ON HoaDonSanPham.nhanVien = NhanVien.maNv \r\n"
					+ "JOIN SanPham ON HoaDonSanPham.sanPham = SanPham.maSP\r\n"
					+ "JOIN KhachHang ON ChiTietHoaDonSanPham.khachHang = KhachHang.maKH  \r\n"
					+ "LEFT JOIN Phong ON ChiTietHoaDonSanPham.phong = Phong.maPhong where Phong.tenPhong = N'"+tenPhong+"'";
			java.sql.Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			Date today = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm");
			while (rs.next()) {
				String maHDSP = rs.getString(15);
				String maSp = rs.getString(5);
				String tenSP = rs.getString(6);
				int donGia = rs.getInt(7);
				int soLuongmua = rs.getInt(2);
				String maKh = rs.getString(10);
				String tenKh = rs.getString(11);
				String sdt = rs.getString(12);
				String maCTHDSP = rs.getString(1);
				String ngayLap = sdf.format(today);
				String maPhong = rs.getString(8);
				String tenP = rs.getString(9);
				String maNv = rs.getString(13);
				String tenNv = rs.getString(14);
				double thanhTien;
				thanhTien = (soLuongmua * donGia) + (soLuongmua * donGia)*10/100;	
				double tongTien = 0.0;
				
				Entity_NhanVien nhanVien = new Entity_NhanVien(maNv, tenNv, "", "", "", null);
				Entity_SanPham sanpham = new Entity_SanPham(maSp, tenSP, 0, donGia);
				Entity_Phong phong = new Entity_Phong(maPhong, tenP,0 ,"" ,0.0 , "");
				Entity_KhachHang khachhang = new Entity_KhachHang(maKh, tenKh, sdt, "", "");
				Entity_ChiTietHoaDonSanPham chitiet = new Entity_ChiTietHoaDonSanPham(maCTHDSP, phong, khachhang, ngayLap);
				Entity_HoaDonSanPham hdsp = new Entity_HoaDonSanPham(chitiet, nhanVien, sanpham, soLuongmua, thanhTien, tongTien);
				
				dshd.add(hdsp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dshd;
	}
	
	public boolean deleteOrder(String maHDSP) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null;
		int n = 0;
		try {
			
			String sql = "SELECT ChiTietHoaDonSanPham.maCTHDSP, HoaDonSanPham.maHDSP\r\n"
					+ "FROM HoaDonSanPham \r\n"
					+ "JOIN NhanVien ON HoaDonSanPham.nhanVien = NhanVien.maNv \r\n"
					+ "JOIN ChiTietHoaDonSanPham ON HoaDonSanPham.chiTietHoaDonSanPham = ChiTietHoaDonSanPham.maCTHDSP\r\n"
					+ "JOIN SanPham ON ChiTietHoaDonSanPham.sanPham = SanPham.maSP\r\n"
					+ "JOIN Phong ON ChiTietHoaDonSanPham.phong = Phong.maPhong\r\n"
					+ "LEFT JOIN KhachHang ON HoaDonSanPham.khachHang = KhachHang.maKH  where HoaDonSanPham.maHDSP = N'"+maHDSP+"'";
			java.sql.Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String mahd = rs.getString(2);
				String macthd = rs.getString(1);
			
			stmt = con.prepareStatement("delete from HoaDonSanPham where maHDSP = '"+mahd+"'");
			stmt.executeUpdate();

			stmt1 = con.prepareStatement("delete from ChiTietHoaDonSanPham where maCTHDSP = '"+macthd+"'");
			stmt1.executeUpdate();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean getAllToPDF(String tenPhong){
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT ChiTietHoaDonSanPham.maCTHDSP, HoaDonSanPham.soLuong, HoaDonSanPham.donGia, ChiTietHoaDonSanPham.ngayLap,\r\n"
					+ "SanPham.maSP, SanPham.tenSP, SanPham.donGia, Phong.maPhong, Phong.tenPhong, KhachHang.maKH, KhachHang.tenKH, KhachHang.sdt,\r\n"
					+ "NhanVien.maNv, NhanVien.tenNV, HoaDonSanPham.chiTietHoaDonSanPham, HoaDonSanPham.tongTien\r\n"
					+ "FROM HoaDonSanPham \r\n"
					+ "JOIN ChiTietHoaDonSanPham ON HoaDonSanPham.chiTietHoaDonSanPham = ChiTietHoaDonSanPham.maCTHDSP\r\n"
					+ "JOIN NhanVien ON HoaDonSanPham.nhanVien = NhanVien.maNv \r\n"
					+ "JOIN SanPham ON HoaDonSanPham.sanPham = SanPham.maSP\r\n"
					+ "JOIN KhachHang ON ChiTietHoaDonSanPham.khachHang = KhachHang.maKH  \r\n"
					+ "LEFT JOIN Phong ON ChiTietHoaDonSanPham.phong = Phong.maPhong where Phong.tenPhong = N'"+tenPhong+"'";
			java.sql.Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String maHDSP = rs.getString(15);
				String maSp = rs.getString(5);
				String tenSP = rs.getString(6);
				int donGia = rs.getInt(7);
				int soLuongmua = rs.getInt(2);
				String maKh = rs.getString(10);
				String tenKh = rs.getString(11);
				String sdt = rs.getString(12);
				String maCTHDSP = rs.getString(1);
				String ngayLap = rs.getString(4);
				String maPhong = rs.getString(8);
				String tenP = rs.getString(9);
				String maNv = rs.getString(13);
				String tenNv = rs.getString(14);
				double thanhTien = 0.0;
				thanhTien = (soLuongmua * donGia) + (soLuongmua * donGia)*10/100;	
				double tongTien = 0.0;
				String vat = "10%";
				Entity_NhanVien nhanVien = new Entity_NhanVien(maNv, tenNv, "", "", "", null);
				Entity_SanPham sanpham = new Entity_SanPham(maSp, tenSP, 0, donGia);
				Entity_Phong phong = new Entity_Phong(maPhong, tenP,0 ,"" ,0.0 , "");
//				Entity_NhanVien nv = new Entity_NhanVien(maNv, tenNv, soDienThoai, gioiTinh, chucVu, taiKhoan)
				Entity_KhachHang khachhang = new Entity_KhachHang(maKh, tenKh, sdt, "", "");
				Entity_ChiTietHoaDonSanPham chitiet = new Entity_ChiTietHoaDonSanPham(maCTHDSP, phong, khachhang, ngayLap);
				Entity_HoaDonSanPham hdsp = new Entity_HoaDonSanPham(chitiet, nhanVien, sanpham, soLuongmua, thanhTien, tongTien);
				PDF_IText pdfItext = new PDF_IText(ngayLap, tenNv, tenSP, maCTHDSP, soLuongmua, donGia, thanhTien, tongTien, vat);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}
}