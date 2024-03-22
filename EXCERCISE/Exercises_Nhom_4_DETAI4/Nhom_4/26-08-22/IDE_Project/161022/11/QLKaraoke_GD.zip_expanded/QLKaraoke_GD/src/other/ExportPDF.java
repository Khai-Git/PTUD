package other;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;

import ConnectDB.ConnectDB;
import DAO.DAO_HoaDonThuePhong;
import DAO.DAO_QLPhong;
import DAO.DAO_NhanVien;
import DAO.DAO_QLKhachHang;
import DAO.DAO_QLHoaDonSanPham;

import Entity.Entity_HoaDonDatPhong;
import Entity.Entity_Phong;
import Entity.Entity_ChiTietHoaDonDatPhong;
import Entity.Entity_KhachHang;
import Entity.Entity_NhanVien;

public class ExportPDF {
	private DAO_QLPhong dao_phong;
	private Entity_HoaDonDatPhong hddp;
	private DAO_HoaDonThuePhong dao_hdthuephong;
	private DAO_QLKhachHang dao_khachang;
	private DAO_NhanVien dao_nhanvien;
	private DAO_QLHoaDonSanPham dao_hdsp;
	
	ArrayList<Entity_HoaDonDatPhong> dstp;
	
	DateFormat ngay = new SimpleDateFormat("dd-MM-yyyy");
	DateFormat gio = new SimpleDateFormat("HH:mm");
	Calendar cal = Calendar.getInstance();
	
	public ExportPDF() {
		dao_hdthuephong = new DAO_HoaDonThuePhong();
		dstp = new ArrayList<Entity_HoaDonDatPhong>();
		hddp = new Entity_HoaDonDatPhong();
	}
	
	public ArrayList<Entity_HoaDonDatPhong> getValueToPrintPDF(String maPhong){
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT HoaDonDatPhong.maHD, KhachHang.sdt, KhachHang.tenKH, Phong.tenPhong,HoaDonDatPhong.ngayDat, HoaDonDatPhong.gioVao,\r\n"
					+ "HoaDonDatPhong.gioRa, HoaDonDatPhong.tongGioDatPhong, HoaDonDatPhong.tongTien, NhanVien.tenNV, Phong.tenLoai, Phong.maPhong   \r\n"
					+ "FROM HoaDonDatPhong \r\n"
					+ "JOIN ChiTietHoaDonDatPhong ON HoaDonDatPhong.chiTietHoaDonDatPhong = ChiTietHoaDonDatPhong.maCTHDDP\r\n"
					+ "JOIN NhanVien ON HoaDonDatPhong.nhanVien = NhanVien.maNv \r\n"
					+ "JOIN KhachHang ON HoaDonDatPhong.khachHang = KhachHang.maKH\r\n"
					+ "LEFT JOIN Phong ON ChiTietHoaDonDatPhong.maPhong = Phong.maPhong where ChiTietHoaDonDatPhong.maPhong = N'"+maPhong+"'";
			java.sql.Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maHD = rs.getString(1);
				Entity_KhachHang khachHang = new Entity_KhachHang("",rs.getString(2),rs.getString(3),"","");
				Entity_Phong phong = new Entity_Phong(rs.getString(11),rs.getString(4),0,"",0.0,"");
				Entity_ChiTietHoaDonDatPhong chiTietHoaDonDatPhong = new Entity_ChiTietHoaDonDatPhong("",phong,0,0);
				String ngayDat = rs.getString(5);
				String tenNhanvien = rs.getString(10);
				String gioVao = rs.getString(6).substring(0,5);
				String gioRa= rs.getString(7).substring(0,5);
				Double tongTien= rs.getDouble(9);
				String tenPhong = rs.getString(4);
				String loaiPhong = rs.getString(11);
				String tenKh = rs.getString(3);
				
				
				System.out.println("\t\tKARAOKE NICE\n");
				System.out.println("\tHóa đơn thuê phòng\n");
				System.out.println("\tMã HĐ:"+ " "+ maHD);
				System.out.println("\tNgày lập:"+ " "+ ngayDat);
				System.out.println("\tKhách hàng:"+ " "+ tenKh+"\n");
				System.out.println("\tGiờ vào:"+ " "+ gioVao);
				System.out.println("\tGiờ ra:"+ " "+ gioRa+"\n");
				System.out.println("\tSố phòng:"+ " "+ tenPhong);
				System.out.println("\tLoại phòng:"+ " "+ loaiPhong+"\n");
				System.out.println("\tVAT: 10%");
				System.out.println("\tTổng thành tiền:"+ " "+ tongTien+"\n");
				System.out.println("\tThank You, see you again!");
				
				
				  JFrame parentComponent = new JFrame();
				    JFileChooser fileChooser= new JFileChooser();
				    // Some init code, if you need one, like setting title
				    int returnValue = fileChooser.showOpenDialog(parentComponent);
				    if ( returnValue == JFileChooser.APPROVE_OPTION) {
				        File fileToSave = fileChooser.getSelectedFile();
				        
				        try{
				        	Document doc = new Document();
//					            String FILE = "C:\\Users\\hp\\OneDrive\\Máy tính\\PTUD\\demo1.pdf";
					            try {
									PdfWriter.getInstance((com.itextpdf.text.Document) doc, new FileOutputStream(fileToSave));
								} catch (FileNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
				        	
				        	
				        	
				        	String mahd =  maHD;
				        	String ngaydat =  ngayDat;
							String tennv = tenNhanvien;
							String giovao = gioVao;
							String giora= gioRa;
							String tenphong = tenPhong;
							String loaiphong = loaiPhong;
							String tenkh = tenKh;
							String tongthanhtien = tongTien+"";
				        	 doc.open();
					            addHeader(doc);
					            addOrderInfo(doc,mahd, ngaydat,tennv,tenKh,tenPhong, loaiphong, giovao, giora, tongthanhtien);					            
					            addFooter(doc);
					            doc.close();
					            System.out.println("done");
				            JOptionPane.showMessageDialog(null, "PDF Saved");
				        }
				        catch(Exception e){
				            JOptionPane.showMessageDialog(null, e);
				        }
				    }
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dstp;
	}

	private void addFooter(Document doc) {
		// TODO Auto-generated method stub
		
	}

	private void addPurchaseInfo(Document doc, Double tongTien, String thueVAT) {
		// TODO Auto-generated method stub
		
	}

	public void addOrderInfo(Document doc,String maHD, String ngayTaoHoaDon, String tenNhanVien, String tenKh, String tenPhong, String loaiPhong, String gioVao, String gioRa, String tongTien) throws DocumentException {
		// TODO Auto-generated method stub
		PdfPTable tblOrderInfo = new PdfPTable(4);
		
		PdfPCell cellMaHd = new PdfPCell();
		addCellBorderAlign(cellMaHd, "Ma HD: ", "l");
		tblOrderInfo.addCell(cellMaHd);

		PdfPCell cellMaHdcontent = new PdfPCell();
		addCellBorderAlign(cellMaHdcontent, maHD+" ", "r");
		
		tblOrderInfo.addCell(cellMaHdcontent);

		addCellNull(tblOrderInfo);
		addCellNull(tblOrderInfo);
		
		PdfPCell cellNgayLap = new PdfPCell();
		addCellBorderAlign(cellNgayLap, "Ngay lap: ", "l");
		tblOrderInfo.addCell(cellNgayLap);

		PdfPCell cellNgayBanContent = new PdfPCell();
		addCellBorderAlign(cellNgayBanContent, ngayTaoHoaDon+" ", "r");
		
		tblOrderInfo.addCell(cellNgayBanContent);

		addCellNull(tblOrderInfo);
		addCellNull(tblOrderInfo);

		PdfPCell cellNhanVien = new PdfPCell();
		addCellBorderAlign(cellNhanVien, "Nhan Vien: ", "l");
		tblOrderInfo.addCell(cellNhanVien);

		PdfPCell cellNhanVienContent = new PdfPCell();
		addCellBorderAlign(cellNhanVienContent, tenNhanVien + " ", "r");
		
		tblOrderInfo.addCell(cellNhanVienContent);
		
		addCellNull(tblOrderInfo);
		addCellNull(tblOrderInfo);
		
		PdfPCell cellKhachHang = new PdfPCell();
		addCellBorderAlign(cellKhachHang, "Khach hang: ", "l");
		tblOrderInfo.addCell(cellKhachHang);

		PdfPCell cellKhachHangcontent = new PdfPCell();
		addCellBorderAlign(cellKhachHangcontent, tenKh + " ", "r");
		
		tblOrderInfo.addCell(cellKhachHangcontent);
		
		addCellNull(tblOrderInfo);
		addCellNull(tblOrderInfo);
		
		PdfPCell cellPhong = new PdfPCell();
		addCellBorderAlign(cellPhong, "Phong: ", "l");
		tblOrderInfo.addCell(cellPhong);

		PdfPCell cellPhongcontent = new PdfPCell();
		addCellBorderAlign(cellPhongcontent, tenPhong + " ", "r");
		
		tblOrderInfo.addCell(cellPhongcontent);
		
		addCellNull(tblOrderInfo);
		addCellNull(tblOrderInfo);
		
		PdfPCell cellLoaiphong = new PdfPCell();
		addCellBorderAlign(cellLoaiphong, "Loai phong: ", "l");
		tblOrderInfo.addCell(cellLoaiphong);

		PdfPCell cellLoaiphongcontent = new PdfPCell();
		addCellBorderAlign(cellLoaiphongcontent, loaiPhong + " ", "r");
		
		tblOrderInfo.addCell(cellLoaiphongcontent);
		
		addCellNull(tblOrderInfo);
		addCellNull(tblOrderInfo);
		
		PdfPCell cellGiovao = new PdfPCell();
		addCellBorderAlign(cellGiovao, "Gio vao: ", "l");
		tblOrderInfo.addCell(cellGiovao);

		PdfPCell cellGiovaocontent = new PdfPCell();
		addCellBorderAlign(cellGiovaocontent,gioVao + " ", "r");
		
		tblOrderInfo.addCell(cellGiovaocontent);
		
		addCellNull(tblOrderInfo);
		addCellNull(tblOrderInfo);
		
		PdfPCell cellGiora = new PdfPCell();
		addCellBorderAlign(cellGiora, "Gio ra: ", "l");
		tblOrderInfo.addCell(cellGiora);

		PdfPCell cellGioracontent = new PdfPCell();
		addCellBorderAlign(cellGioracontent, gioRa + " ", "r");
	
		tblOrderInfo.addCell(cellGioracontent);
		
		addCellNull(tblOrderInfo);
		addCellNull(tblOrderInfo);
		
		PdfPCell cellTongtien = new PdfPCell();
		addCellBorderAlign(cellTongtien, "Tong tien can thanh toan: ", "l");
		
		tblOrderInfo.addCell(cellTongtien);

		PdfPCell cellTongtiencontent = new PdfPCell();
		addCellBorderAlign(cellTongtiencontent, tongTien + " ", "r");
		
		tblOrderInfo.addCell(cellTongtiencontent);
		
		addCellNull(tblOrderInfo);
		addCellNull(tblOrderInfo);
		
		doc.add(tblOrderInfo);
	}
	
	private void addEmptyLine(Document doc, int line) throws DocumentException {
		// TODO Auto-generated method stub
		for(int i = 0; i < line; i++) {
			doc.add(new Paragraph(" "));
		}
	}

	private void addHeader(Document doc) throws DocumentException {
		// TODO Auto-generated method stub
		Paragraph pNameStore = new Paragraph("KARAOKE NICE");
		pNameStore.setAlignment(Element.ALIGN_CENTER);
		doc.add(pNameStore);

		addEmptyLine(doc, 1);

		Paragraph pAddress = new Paragraph("12 Le Van Bao, Phuong 5, Quan Go Vap, TP Ho Chi Minh");
		pAddress.setAlignment(Element.ALIGN_CENTER);
		doc.add(pAddress);
		
		Paragraph pTitle = new Paragraph("HOA DON THUE PHONG");
		pTitle.setAlignment(Element.ALIGN_CENTER);
		doc.add(pTitle);
		
		addEmptyLine(doc, 1);
	}
	
	private  void addCellNull(PdfPTable table) {
		// TODO Auto-generated method stub
		PdfPCell cellNull = new PdfPCell();
		cellNull.setBorder(0);
		table.addCell(cellNull);
	}
	
	private  PdfPCell addCellBorderAlign(PdfPCell cell, String content, String align) {
		// TODO Auto-generated method stub
		Paragraph p = new Paragraph(content + "");
		cell.setBorder(0);
		if(align.equalsIgnoreCase("r")) {
			p.setAlignment(Element.ALIGN_RIGHT);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		} else if(align.equalsIgnoreCase("l")) {
			p.setAlignment(Element.ALIGN_LEFT);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		} else if(align.equalsIgnoreCase("c")) {
			p.setAlignment(Element.ALIGN_CENTER);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		}
		cell.addElement(p);
		return cell;
	}
	

}



































