package other;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import ConnectDB.ConnectDB;
import Entity.Entity_ChiTietHoaDonSanPham;
import Entity.Entity_HoaDonSanPham;
import Entity.Entity_KhachHang;
import Entity.Entity_NhanVien;
import Entity.Entity_Phong;
import Entity.Entity_SanPham;

public class PDF_IText {


		// TODO Auto-generated method stub
		public static void main(String[] args) throws DocumentException, FileNotFoundException {
			ArrayList<Entity_HoaDonSanPham> dshd = new ArrayList<Entity_HoaDonSanPham>();
			Entity_HoaDonSanPham hd = new Entity_HoaDonSanPham();
			
			Date today = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm");
			
		}

		public PDF_IText(String ngayTaoHoaDon, String tenNhanVien,
				String tenSP, String macthdsp, int soLuong, int donGia, double thanhTien,
				double tongTien, String VAT) {
				String FILE = "C:\\Users\\hp\\OneDrive\\Máy tính\\PTUD\\demo1.pdf";
			
			try {
				Document doc = new Document(PageSize.A4);
				PdfWriter.getInstance(doc, new FileOutputStream(FILE));
				doc.open();
				addHeader(doc);
				addOrderInfo(doc, ngayTaoHoaDon, tenNhanVien);
				doc.add(addHeaderOrderDetail( macthdsp,  tenSP,  soLuong,  donGia, thanhTien));
				addHeaderOrderDetail( macthdsp,  tenSP,  soLuong,  donGia, thanhTien);
				addPurchaseInfo(doc, tongTien, VAT);
				addFooter(doc);
				doc.close();
				System.out.println("pdf");
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		private void addHeader(Document doc) throws DocumentException {
			// TODO Auto-generated method stub
			Paragraph pNameStore = new Paragraph("KRAOKE NICE");
			pNameStore.setAlignment(Element.ALIGN_CENTER);
			doc.add(pNameStore);

			addEmptyLine(doc, 1);

			Paragraph pAddress = new Paragraph("12 Le Van Bao, Phuong 5, Quan Go Vap, TP Ho Chi Minh");
			pAddress.setAlignment(Element.ALIGN_CENTER);
			doc.add(pAddress);
			
			Paragraph pTitle = new Paragraph("HOA DON DICH VU");
			pTitle.setAlignment(Element.ALIGN_CENTER);
			doc.add(pTitle);
			
			addEmptyLine(doc, 1);
		}
		
		public void addOrderInfo(Document doc, String ngayTaoHoaDon, String tenNhanVien) throws DocumentException {
			// TODO Auto-generated method stub
			PdfPTable tblOrderInfo = new PdfPTable(4);
			
			PdfPCell cellNgayLap = new PdfPCell();
			addCellBorderAlign(cellNgayLap, "Ngay lap", "l");
			tblOrderInfo.addCell(cellNgayLap);

			PdfPCell cellNgayBanContent = new PdfPCell();
			addCellBorderAlign(cellNgayBanContent, ngayTaoHoaDon+" ", "r");
			tblOrderInfo.addCell(cellNgayBanContent);

			addCellNull(tblOrderInfo);
			addCellNull(tblOrderInfo);

			PdfPCell cellHoaDon = new PdfPCell();
			addCellBorderAlign(cellHoaDon, "Hoa Don", "l");
			tblOrderInfo.addCell(cellHoaDon);

			PdfPCell cellNhanVien = new PdfPCell();
			addCellBorderAlign(cellNhanVien, "Nhan Vien", "l");
			tblOrderInfo.addCell(cellNhanVien);

			PdfPCell cellNhanVienContent = new PdfPCell();
			addCellBorderAlign(cellNhanVienContent, tenNhanVien + " ", "r");
			tblOrderInfo.addCell(cellNhanVienContent);
			
			doc.add(tblOrderInfo);
		}
		
//		public void testPDF() {
//			 try {
//		            Document doc = new Document();
//		            PdfWriter.getInstance(doc, new FileOutputStream("table.pdf"));
//		            doc.open();
//		            PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
//		            //adding table headers
//		            for (int i = 0; i < table.getColumnCount(); i++) {
//		                pdfTable.addCell(table.getColumnName(i));
//		            }
//		            //extracting data from the JTable and inserting it to PdfPTable
//		            for (int rows = 0; rows < table.getRowCount() - 1; rows++) {
//		                for (int cols = 0; cols < table.getColumnCount(); cols++) {
//		                    pdfTable.addCell(table.getModel().getValueAt(rows, cols).toString());
//
//		                }
//		            }
//		            doc.add(pdfTable);
//		            doc.close();
//		            System.out.println("done");
//		        } catch (DocumentException ex) {
//		            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
//		        } catch (FileNotFoundException ex) {
//		            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
//		        }
//
//		    }
		
		private PdfPTable addHeaderOrderDetail(String macthdsp, String tenSP, int soLuong, int donGia, double thanhTien) throws DocumentException {
			// TODO Auto-generated method stub

			PdfPTable tbl = new PdfPTable(5);
			
			PdfPCell cellTenSp = new PdfPCell();
			addCellBorderAlign(cellTenSp, "Ten SP", "l");
			tbl.addCell(cellTenSp);

			PdfPCell celldonGia = new PdfPCell();
			addCellBorderAlign(celldonGia, "Gia tien", "r");
			tbl.addCell(celldonGia);

			PdfPCell cellSoluong = new PdfPCell();
			addCellBorderAlign(cellSoluong, "So luong", "r");
			tbl.addCell(cellSoluong);

			PdfPCell cellThanhtien = new PdfPCell();
			addCellBorderAlign(cellThanhtien, "Thanh Tien", "r");
			tbl.addCell(cellThanhtien);

			PdfPCell cellNull = new PdfPCell();
			cellNull.setColspan(4);
			addCellBorderAlign(cellNull, " ", "l");
			tbl.addCell(cellNull);

			PdfPCell cellMaSP = new PdfPCell();
			addCellBorderAlign(cellMaSP, tenSP + " ", "l");
			tbl.addCell(cellMaSP);

			PdfPCell cellDonGiaSP = new PdfPCell();
			addCellBorderAlign(cellDonGiaSP, donGia + " ", "r");
			tbl.addCell(cellDonGiaSP);
			
			PdfPCell cellSoLuongSP = new PdfPCell();
			addCellBorderAlign(cellSoLuongSP, soLuong + " ", "r");
			tbl.addCell(cellSoLuongSP);

			PdfPCell cellThanhTienSP = new PdfPCell();
			addCellBorderAlign(cellThanhTienSP, thanhTien + " ", "r");
			tbl.addCell(cellThanhTienSP);

			PdfPCell cellNull1 = new PdfPCell();
			cellNull1.setColspan(5);
			addCellBorderAlign(cellNull1, " ", "l");
			tbl.addCell(cellNull1);
			
			return tbl;
		}
		
		public void addPurchaseInfo(Document doc, double tongTien, String VAT) throws DocumentException {
			// TODO Auto-generated method stub

			PdfPTable tblPurchaseInfo = new PdfPTable(2);
			
			PdfPCell cellTongTien = new PdfPCell();
			addCellBorderAlign(cellTongTien, "Tong Tien", "l");
			cellTongTien.setBorderWidthTop(1);
			tblPurchaseInfo.addCell(cellTongTien);

			PdfPCell cellTongTienContent = new PdfPCell();
			addCellBorderAlign(cellTongTienContent, tongTien + " ", "r");
			cellTongTienContent.setBorderWidthTop(1);
			tblPurchaseInfo.addCell(cellTongTienContent);

			PdfPCell cellVAT = new PdfPCell();
			addCellBorderAlign(cellVAT, VAT + " ", "r");
			tblPurchaseInfo.addCell(cellVAT);

			PdfPCell cellNotice = new PdfPCell();
			cellNotice.setColspan(2);
			addCellBorderAlign(cellNotice, "(Gia Da Bao Gom Thue GTGT)", "c");
			tblPurchaseInfo.addCell(cellNotice);
			
			doc.add (tblPurchaseInfo);
		}

		private void addFooter(Document doc) throws DocumentException {
			// TODO Auto-generated method stub
			addEmptyLine(doc, 2);

			Paragraph pCamOn = new Paragraph("CAM ON QUY KHACH VA HEN GAP LAI");
			pCamOn.setAlignment(Element.ALIGN_CENTER);
			doc.add(pCamOn);

			Paragraph pLienHe = new Paragraph("Hotline: 0936343821");
			pLienHe.setAlignment(Element.ALIGN_CENTER);
			doc.add(pLienHe);
		}

		private void addEmptyLine(Document doc, int line) throws DocumentException {
			// TODO Auto-generated method stub
			for(int i = 0; i < line; i++) {
				doc.add(new Paragraph(" "));
			}
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
