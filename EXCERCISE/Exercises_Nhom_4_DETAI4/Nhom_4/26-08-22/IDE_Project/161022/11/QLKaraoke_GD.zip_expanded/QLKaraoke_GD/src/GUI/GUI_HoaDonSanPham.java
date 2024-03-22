package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import ConnectDB.ConnectDB;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import DAO.DAO_QLHoaDonSanPham;
import Entity.Entity_ChiTietHoaDonSanPham;
import Entity.Entity_HoaDonSanPham;
import other.PDF_IText;

import javax.swing.JScrollPane;
import java.awt.TextField;
import javax.swing.border.EtchedBorder;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;

public class GUI_HoaDonSanPham extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JTextField txtNhpTnPhng;
	private JTable table ;
	private JLabel lblTitle, lblNhanVien, lblTenKH,lblSDT,lblNtenKH,lblNsdt,lblTenNhanVien, lblTitle_2;
	private JButton btnManHinhChinh, btnDatPhong, btnHoaDon, btnDichVu,btnNhanVien, btnQLPhong, btnKhachHang,btnThongKe, btnTroVe;
	private JButton btnDangXuat, btnTimKiem, btnSuaPhieu, btnHuy, btnXuat;
	private JPanel panel,panel_2;
	private DefaultTableModel tableModel;
	private DAO_QLHoaDonSanPham dao_qlhdsp;
	private Entity_ChiTietHoaDonSanPham ctsp;
	private Entity_HoaDonSanPham hdsp;
	private JLabel lblPhong;
	private JTextField txtTest;
	private PDF_IText pdfItext;
	private JLabel lblTenphong;
	private JLabel lblNTenphong;
	private JLabel lblTongTien;
	private JLabel lblNTongTien;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_HoaDonSanPham frame = new GUI_HoaDonSanPham();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_HoaDonSanPham() {
		setTitle("Quản lý KARAOKE_NICE");
		
		ConnectDB.getInstance().connect();
		dao_qlhdsp = new DAO_QLHoaDonSanPham();
		ctsp = new Entity_ChiTietHoaDonSanPham();
		hdsp = new Entity_HoaDonSanPham();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnManHinhChinh = new JButton("Màn hình chính");
		btnManHinhChinh.setIcon(new ImageIcon(GUI_HoaDonSanPham.class.getResource("/img/home-icon.png")));
		btnManHinhChinh.setHorizontalAlignment(SwingConstants.LEFT);
		btnManHinhChinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnManHinhChinh.setBounds(0, 97, 225, 78);
		contentPane.add(btnManHinhChinh);
		
		btnDatPhong = new JButton("Đặt phòng");
		btnDatPhong.setIcon(new ImageIcon(GUI_HoaDonSanPham.class.getResource("/img/Book_room.jpg")));
		btnDatPhong.setHorizontalAlignment(SwingConstants.LEFT);
		btnDatPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDatPhong.setBounds(0, 173, 225, 78);
		contentPane.add(btnDatPhong);
		
		btnHoaDon = new JButton(" Hóa đơn");
		btnHoaDon.setBackground(Color.YELLOW);
		btnHoaDon.setIcon(new ImageIcon(GUI_HoaDonSanPham.class.getResource("/img/bill_icon1.png")));
		btnHoaDon.setHorizontalAlignment(SwingConstants.LEFT);
		btnHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHoaDon.setBounds(0, 245, 225, 78);
		contentPane.add(btnHoaDon);
		
		btnDichVu = new JButton(" Dịch vụ");
		btnDichVu.setIcon(new ImageIcon(GUI_HoaDonSanPham.class.getResource("/img/menu2.png")));
		btnDichVu.setHorizontalAlignment(SwingConstants.LEFT);
		btnDichVu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDichVu.setBounds(0, 322, 225, 78);
		contentPane.add(btnDichVu);
		
		btnNhanVien = new JButton(" Nhân viên");
		btnNhanVien.setIcon(new ImageIcon(GUI_HoaDonSanPham.class.getResource("/img/black-man-icon.png")));
		btnNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNhanVien.setBounds(0, 397, 225, 78);
		contentPane.add(btnNhanVien);
		
		btnQLPhong = new JButton(" Quản lý phòng");
		btnQLPhong.setIcon(new ImageIcon(GUI_HoaDonSanPham.class.getResource("/img/Science-Plus-Math-icon.png")));
		btnQLPhong.setHorizontalAlignment(SwingConstants.LEFT);
		btnQLPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnQLPhong.setBounds(0, 473, 225, 78);
		contentPane.add(btnQLPhong);
		
		btnKhachHang = new JButton("  Khách hàng");
		btnKhachHang.setIcon(new ImageIcon(GUI_HoaDonSanPham.class.getResource("/img/users-icon.png")));
		btnKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		btnKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnKhachHang.setBounds(0, 549, 225, 78);
		contentPane.add(btnKhachHang);
		
		btnThongKe = new JButton("Thống kê số liệu");
		btnThongKe.setIcon(new ImageIcon(GUI_HoaDonSanPham.class.getResource("/img/Dollar-Sign-icon.png")));
		btnThongKe.setHorizontalAlignment(SwingConstants.LEFT);
		btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThongKe.setBounds(0, 625, 225, 78);
		contentPane.add(btnThongKe);
		
		lblTitle = new JLabel("PHẦN MỀM QUẢN LÝ KARAOKE");
		lblTitle.setForeground(new Color(0, 0, 0));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblTitle.setBackground(SystemColor.activeCaption);
		lblTitle.setBounds(0, 11, 1474, 86);
		contentPane.add(lblTitle);
		
		lblNhanVien = new JLabel("Nhân viên :");
		lblNhanVien.setBounds(1093, 74, 72, 23);
		contentPane.add(lblNhanVien);
		
		btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setBackground(new Color(255, 0, 0));
		btnDangXuat.setBounds(1337, 74, 120, 23);
		contentPane.add(btnDangXuat);
		
		panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "H\u00F3a \u0111\u01A1n ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setToolTipText("");
		panel.setBounds(237, 97, 1237, 653);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblTitle_2 = new JLabel("Hóa đơn sản phẩm");
		lblTitle_2.setForeground(new Color(0, 0, 0));
		lblTitle_2.setBackground(SystemColor.activeCaption);
		lblTitle_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitle_2.setBounds(358, 11, 443, 31);
		panel.add(lblTitle_2);
		
		lblTenKH = new JLabel("Tên KH:");
		lblTenKH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenKH.setBounds(116, 98, 53, 23);
		panel.add(lblTenKH);
		
		lblSDT = new JLabel("SĐT: ");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSDT.setBounds(389, 98, 34, 23);
		panel.add(lblSDT);
		
		lblTenphong = new JLabel("Phòng: ");
		lblTenphong.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenphong.setBounds(635, 98, 61, 23);
		panel.add(lblTenphong);
		
//		lblPhong = new JLabel("Phòng: ");
//		lblPhong.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		lblPhong.setBounds(389, 98, 34, 23);
//		panel.add(lblPhong);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 141, 1197, 428);
		panel.add(scrollPane_1);
		
		
		table = new JTable();
		table.setBorder(null);
		scrollPane_1.setViewportView(table);
		String header [] = {"Mã sản phẩm","Tên sản phẩm", "Giá tiền", "Số lượng", "Thành tiền"};
		tableModel = new DefaultTableModel(header, 0);
		JScrollPane scroll = new JScrollPane(table = new JTable(tableModel));
		scrollPane_1.setViewportView(table);
		
		table.getColumnModel().getColumn(1).setPreferredWidth(105);
		btnXuat = new JButton("Xuất hóa đơn\r\n");
		btnXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXuat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXuat.setIcon(new ImageIcon(GUI_HoaDonSanPham.class.getResource("/img/Invoice-icon.png")));
		btnXuat.setBackground(new Color(0, 255, 0));
		btnXuat.setBounds(947, 580, 164, 30);
		panel.add(btnXuat);
		
		lblNtenKH = new JLabel();
		lblNtenKH.setText("");
		lblNtenKH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNtenKH.setBounds(179, 98, 182, 23);
		panel.add(lblNtenKH);
		
		lblNsdt = new JLabel();
		lblNsdt.setText("");
		lblNsdt.setBounds(433, 98, 158, 23);
		panel.add(lblNsdt);
		
		lblNTenphong = new JLabel();
		lblNTenphong.setText("");
		lblNTenphong.setBounds(687, 98, 158, 23);
		panel.add(lblNTenphong);
		
//		lblTongTien = new JLabel();
//		lblTongTien.setText("Tong tien: ");
//		lblTongTien.setBounds(10, 581, 158, 23);
//		panel.add(lblTongTien);
		
		lblNTongTien = new JLabel();
		lblNTongTien.setText("");
		lblNTongTien.setBounds(15, 581, 450, 23);
		panel.add(lblNTongTien);
		
		btnHuy = new JButton("Xóa\r\n");
		btnHuy.setBounds(1121, 581, 86, 30);
		panel.add(btnHuy);
		btnHuy.setIcon(new ImageIcon(GUI_HoaDonSanPham.class.getResource("/img/x-icon.png")));
		btnHuy.setBackground(Color.RED);
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBounds(1090, 92, 117, 32);
		panel.add(btnTimKiem);
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtNhpTnPhng = new JTextField();
		txtNhpTnPhng.setBounds(845, 100, 235, 20);
		panel.add(txtNhpTnPhng);
		txtNhpTnPhng.setForeground(Color.LIGHT_GRAY);
		txtNhpTnPhng.setText("Phòng ");
		txtNhpTnPhng.setColumns(10);
		
		txtTest = new JTextField();
		txtTest.setText("");
		panel.add(txtTest);
		txtTest.setBounds(845, 50, 100, 20);
		txtTest.setVisible(false);
		
				btnSuaPhieu = new JButton("Sửa phiếu \r\n");
				btnSuaPhieu.setBounds(783, 581, 154, 30);
				panel.add(btnSuaPhieu);
				btnSuaPhieu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnSuaPhieu.setIcon(new ImageIcon(GUI_HoaDonSanPham.class.getResource("/img/cog-edit-icon.png")));
				btnSuaPhieu.setBackground(new Color(255, 165, 0));
				
				btnTroVe = new JButton("Trở về\r\n");
				btnTroVe.setBounds(10, 15, 96, 32);
				panel.add(btnTroVe);
				btnTroVe.setHorizontalAlignment(SwingConstants.LEFT);
				btnTroVe.setIcon(new ImageIcon(GUI_HoaDonSanPham.class.getResource("/img/back-icon1.png")));
				btnTroVe.setBackground(Color.ORANGE);
				btnTroVe.setFont(new Font("Tahoma", Font.PLAIN, 13));
				btnTroVe.addActionListener(this);
		
		lblTenNhanVien = new JLabel("");
		lblTenNhanVien.setBounds(1162, 74, 143, 18);
		contentPane.add(lblTenNhanVien);
		
		JLabel lblHinh = new JLabel("");
		lblHinh.setIcon(new ImageIcon(GUI_HoaDonSanPham.class.getResource("/img/kara_page-0001.jpg")));
		lblHinh.setBounds(10, 11, 170, 78);
		contentPane.add(lblHinh);
		
		//btn.Event
		btnManHinhChinh.addActionListener(this);
		btnDatPhong.addActionListener(this);
		btnKhachHang.addActionListener(this);
		btnNhanVien.addActionListener(this);
		btnDichVu.addActionListener(this);
		btnThongKe.addActionListener(this);
		btnHuy.addActionListener(this);
		btnTimKiem.addActionListener(this);
		btnXuat.addActionListener(this);
		
		nv_HienTai();
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		
		if(o.equals(btnTimKiem)) {
			tableModel.setRowCount(0);
			seachHoaDonDichVu();
		}
		
		if(o.equals(btnHuy)) {
			deleteOrder();
		}
		
		if(o.equals(btnXuat)) {
			JFrame parentComponent = new JFrame();
		    JFileChooser fileChooser= new JFileChooser();
		    // Some init code, if you need one, like setting title
		    int returnValue = fileChooser.showOpenDialog(parentComponent);
		    if ( returnValue == JFileChooser.APPROVE_OPTION) {
		        File fileToSave = fileChooser.getSelectedFile();
			 try {
		            Document doc = new Document();
//		            String FILE = "C:\\Users\\hp\\OneDrive\\Máy tính\\PTUD\\demo1.pdf";
		            try {
						PdfWriter.getInstance(doc, new FileOutputStream(fileToSave));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		            
		            Date today = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm");
					String ngaylap = sdf.format(today);
					String tenNV = "huu nha";
					String tenKh = lblNtenKH.getText().toString();
					String tenPhong = lblNTenphong.getText().toString();
					String tongTien = lblNTongTien.getText().toString();
					String VAT = "10%";
		            doc.open();
		            addHeader(doc);
		            addOrderInfo(doc,ngaylap,tenNV,tenKh,tenPhong);
		            getTableToPDF(doc);
		            addPurchaseInfo(doc, tongTien);
		            addFooter(doc);
		            doc.close();
		            System.out.println("done");
		        } catch (DocumentException ex) {
		           
		        }
		    }
		}
		
		if (o.equals(btnManHinhChinh)) {
			HDSP_to_ManHinhChinh();
		}
		if (o.equals(btnDatPhong)) {
			HDSP_to_DatPhong();
		}
		if (o.equals(btnDichVu)) {
			HDSP_to_DichVu();
		}
		if (o.equals(btnNhanVien)) {
			checkChucVu();
		}
		if (o.equals(btnQLPhong)) {
			HDSP_to_Phong();
		}
		if (o.equals(btnKhachHang)) {
			HDSP_to_KhachHang();
		}
		if (o.equals(btnThongKe)) {
			HDSP_to_ThongKe();
		}
		if (o.equals(btnTroVe)) {
			HDSP_back();
		}
		if(o.equals(btnHoaDon)) {
			HDSP_to_HoaDon();
		}
		if (o.equals(btnDangXuat)) {
			try {
				DangXuat();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public void nv_HienTai() {
		// TODO Auto-generated method stub
		String taikhoanNhap = GUI_DangNhap.txtNhapTaiKhoan.getText();
		
		if(GUI_DangNhap.txtNhapTaiKhoan.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập tài khoản!");
		} else {
			try {
				Connection con= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=KARAOKE_Nice","sa","sapassword");
				String sql = " select * \r\n" 
							+ " from TaiKhoan tk, NhanVien nv \r\n"
							+ " where tk.taiKhoan like N'%" + taikhoanNhap + "%' \r\n"
							+ " and nv.taiKhoan like N'%" + taikhoanNhap + "%' ";
				
				Statement stmt = con.createStatement();
				ResultSet rs=stmt.executeQuery(sql);
					
				if(rs.next()) {
					lblTenNhanVien.setText(rs.getString(4));
				} else {
					JOptionPane.showMessageDialog(this, "Blank");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	private void checkChucVu() {
		// TODO Auto-generated method stub
		String taikhoanNhap = GUI_DangNhap.txtNhapTaiKhoan.getText();

		if(GUI_DangNhap.txtNhapTaiKhoan.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập tài khoản!");
		} else {
			try {
				Connection con= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=KARAOKE_Nice","sa","sapassword");
				String sql = " select * \r\n" 
							+ " from TaiKhoan tk, NhanVien nv \r\n"
							+ " where tk.taiKhoan like N'%" + taikhoanNhap + "%' \r\n"
							+ " and nv.taiKhoan like N'%" + taikhoanNhap + "%' ";
				
				Statement stmt = con.createStatement();
				ResultSet rs=stmt.executeQuery(sql);
					
				if(rs.next()) {
					String nv_chucVu = rs.getString(7);
					
					int count = 0;
					for (int i = 0; i < nv_chucVu.length(); i++) {count++;}
					
					if(nv_chucVu.length() == 6) {
						JOptionPane.showMessageDialog(this, "Nhân viên lễ tân không được phép vào !!!");
						return;
					} else {
						HDSP_to_NhanVien();
					}
				} else {
					JOptionPane.showMessageDialog(this, "Blank");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	private void DangXuat() throws IOException {
		int hoiNhac = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát ?", "Thông báo",JOptionPane.YES_NO_OPTION);
		if(hoiNhac == JOptionPane.YES_OPTION) {
			ConnectDB.getInstance().disconnect();
			this.setVisible(false);
			GUI_DangNhap dangNhap = new GUI_DangNhap();
			dangNhap.setVisible(true);
			dangNhap.setLocationRelativeTo(null);
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
		
		Paragraph pTitle = new Paragraph("HOA DON DICH VU");
		pTitle.setAlignment(Element.ALIGN_CENTER);
		doc.add(pTitle);
		
		addEmptyLine(doc, 1);
	}
	
	public void addOrderInfo(Document doc, String ngayTaoHoaDon, String tenNhanVien, String tenKh, String tenPhong) throws DocumentException {
		// TODO Auto-generated method stub
		PdfPTable tblOrderInfo = new PdfPTable(4);
		
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
		
		doc.add(tblOrderInfo);
	}
	
	public void addPurchaseInfo(Document doc, String tongTien) throws DocumentException {
		// TODO Auto-generated method stub

		PdfPTable tblPurchaseInfo = new PdfPTable(2);

		PdfPCell cellTongTienContent = new PdfPCell();
		addCellBorderAlign(cellTongTienContent, tongTien + " ", "l");
		cellTongTienContent.setBorderWidthTop(1);
		tblPurchaseInfo.addCell(cellTongTienContent);

		PdfPCell cellNotice = new PdfPCell();
		cellNotice.setColspan(2);
		addCellBorderAlign(cellNotice, "(Gia Da Bao Gom Thue GTGT)", "c");
		tblPurchaseInfo.addCell(cellNotice);
		
		doc.add (tblPurchaseInfo);
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
	
	private void getTableToPDF(Document doc) {
		PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
        //adding table headers
        for (int i = 0; i < table.getColumnCount(); i++) {
            pdfTable.addCell(table.getColumnName(i));
        }
        //extracting data from the JTable and inserting it to PdfPTable
        for (int rows = 0; rows < table.getRowCount(); rows++) {
            for (int cols = 0; cols < table.getColumnCount(); cols++) {
                pdfTable.addCell(table.getModel().getValueAt(rows, cols).toString());

            }
        }
        try {
			doc.add(pdfTable);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addEmptyLine(Document doc, int line) throws DocumentException {
		// TODO Auto-generated method stub
		for(int i = 0; i < line; i++) {
			doc.add(new Paragraph(" "));
		}
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
	
	private void deleteOrder() {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		if(row >= 0) {
			String maOrder = (String) table.getValueAt(row, 0);
			if(dao_qlhdsp.deleteOrder(maOrder)) {
				tableModel.removeRow(row);
				tableModel.fireTableDataChanged();
				table.repaint();
				clearAction();
			}
		}
	}

	private void seachHoaDonDichVu() {
		// TODO Auto-generated method stub
		String tenPhong = txtNhpTnPhng.getText().toString();
		String tenKH = "";
		String sdt = "";
		String tenphong = "";
		double tongtien = 0.0;
		double sum = 0.0;
		DAO_QLHoaDonSanPham hdsp = new DAO_QLHoaDonSanPham();
		List<Entity_HoaDonSanPham> list = hdsp.getAllHoaDonDichVu(tenPhong);
		for(Entity_HoaDonSanPham l : list) {
			String [] rowData = {l.getSanPham().getMaSP(), l.getSanPham().getTenSP(), l.getSanPham().getDonGia()+""+" VND",l.getSoLuong()+"",l.getDonGia()+""+" VND"};
			tableModel.addRow(rowData);
			tenKH = l.getMaCTHDSP().getKh().getTenKH();
			sdt = l.getMaCTHDSP().getKh().getSoDienThoai();
			tenphong = l.getMaCTHDSP().getPhong().getTenPhong();
			tongtien = l.getDonGia();
			sum += tongtien;
		}
		lblNtenKH.setText(tenKH);
		lblNsdt.setText(sdt);
		lblNTenphong.setText(tenphong);
		lblNTongTien.setText("Tong thanh tien: " + sum + " VND");
		table.setModel(tableModel);
		clearAction();
	}

	private void clearAction() {
		// TODO Auto-generated method stub
		txtNhpTnPhng.setText("Phòng ");
	}

	private void HDSP_to_HoaDon() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_HoaDon hoadon = new GUI_HoaDon();
		hoadon.setVisible(true);
		hoadon.setLocationRelativeTo(null);
	}
	private void HDSP_back() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_HoaDon hoadon = new GUI_HoaDon();
		hoadon.setVisible(true);
		hoadon.setLocationRelativeTo(null);
		}

	private void HDSP_to_ThongKe() {
		// TODO Auto-generated method stub
		
	}

	private void HDSP_to_KhachHang() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_QLKhachHang khachhanh = new GUI_QLKhachHang();
		khachhanh.setVisible(true);
		khachhanh.setLocationRelativeTo(null);
	}

	private void HDSP_to_Phong() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_QLPhong phong = new GUI_QLPhong();
		phong.setVisible(true);
		phong.setLocationRelativeTo(null);
	}

	private void HDSP_to_NhanVien() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_QLNhanVien nhanvien = new GUI_QLNhanVien();
		nhanvien.setVisible(true);
		nhanvien.setLocationRelativeTo(null);
	}

	private void HDSP_to_DichVu() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_QLDichVu dichvu = new GUI_QLDichVu();
		dichvu.setVisible(true);
		dichvu.setLocationRelativeTo(null);
	}

	private void HDSP_to_DatPhong() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_ThuePhong qldatphong = new GUI_ThuePhong();
		qldatphong.setVisible(true);
		qldatphong.setLocationRelativeTo(null);
	}

	private void HDSP_to_ManHinhChinh() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_ManHinhChinh manhinhchinh = new GUI_ManHinhChinh();
		manhinhchinh.setVisible(true);
		manhinhchinh.setLocationRelativeTo(null);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		txtTest.setText(tableModel.getValueAt(row, 0).toString());
		String rs = tableModel.getValueAt(row, 0).toString();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
