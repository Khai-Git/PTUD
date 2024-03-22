package Gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ConnectDB.ConnectDB;
import Dao.ChiTietHDBH_Dao;
import Dao.ChiTietHDNH_Dao;
import Dao.HoaDonBanHang_DAO;
import Dao.HoaDonNhapHang_DAO;
import Dao.SanPham_DAO;
import Entity.ChiTietHDBH;
import Entity.ChiTietHDNH;
import Entity.HoaDonBanHang;
import Entity.HoaDonNhapHang;
import Entity.SanPham;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class Gui_TKeTheoThang extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel dtm;
	private DefaultTableModel dtm1;
	private JTable tableTKDTT;
	private JTable tableSPN;
	private JTextField textNgayTK;
	private JTextField textTSPB;
	private JTextField textTSHDB;
	private JTextField textTSHDN;
	private HoaDonBanHang_DAO hdbh_Dao = new HoaDonBanHang_DAO();
	private HoaDonNhapHang_DAO hdnh_Dao = new HoaDonNhapHang_DAO();
	private ChiTietHDBH_Dao ctbh_Dao = new ChiTietHDBH_Dao();
	private ChiTietHDNH_Dao ctnh_Dao = new ChiTietHDNH_Dao();
	private SanPham_DAO sp_Dao = new SanPham_DAO();
	private LocalDate ngay = LocalDate.now();
	private JTextField textTSPN;
	private JButton btnBack;
	private JButton btnXN;


	/**
	 * Create the frame.
	 */
	public Gui_TKeTheoThang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setSize(1600, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// connect database
		hdbh_Dao = new HoaDonBanHang_DAO();
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JLabel lblNewLabel = new JLabel("Thống kê cuối tháng");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(606, 15, 511, 38);
		contentPane.add(lblNewLabel);

		String[] cols = { "STT", "Mã sản phẩm", "Tên sản phẩm", "Màu", "Size", "Loại", "Số lượng", "Lô hàng",
				"Mã nhà cung cấp", "Tên nhà cung cấp", "Giá nhập", "Giá Bán", "Thành Tiền" };
		dtm = new DefaultTableModel(cols, 0);
		tableTKDTT = new JTable(dtm);
		tableTKDTT.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JScrollPane scrollSP = new JScrollPane(tableTKDTT);
		scrollSP.setBounds(18, 258, 1512, 205);
		contentPane.add(scrollSP, BorderLayout.NORTH);

		btnXN = new JButton("Xác nhận");
		btnXN.setBackground(Color.GREEN);
		btnXN.setForeground(Color.WHITE);
		btnXN.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXN.setBounds(1186, 746, 125, 31);
		contentPane.add(btnXN);

		JLabel lblDanhSchSn = new JLabel("Danh Sách Sản Phẩm Đã Bán");
		lblDanhSchSn.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSchSn.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblDanhSchSn.setBounds(606, 216, 511, 38);
		contentPane.add(lblDanhSchSn);

		String[] cols1 = { "STT", "Mã sản phẩm", "Tên sản phẩm", "Màu", "Size", "Loại", "Số lượng", "Lô hàng",
				"Mã nhà cung cấp", "Tên nhà cung cấp", "Giá nhập", "Giá Bán", "Thành Tiền" };
		dtm1 = new DefaultTableModel(cols1, 0);
		tableSPN = new JTable(dtm1);
		tableSPN.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JScrollPane scrollSP1 = new JScrollPane(tableSPN);
		scrollSP1.setBounds(18, 521, 1512, 205);
		contentPane.add(scrollSP1);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(38, 63, 1480, 141);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("Tổng số sản phẩm đã bán:");
		lblNewLabel_1_1.setBounds(45, 72, 201, 38);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblNewLabel_1 = new JLabel("Ngày thống kê:");
		lblNewLabel_1.setBounds(121, 26, 125, 38);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);

		textNgayTK = new JTextField();
		textNgayTK.setHorizontalAlignment(SwingConstants.CENTER);
		textNgayTK.setFont(new Font("Tahoma", Font.BOLD, 18));
		textNgayTK.setBounds(256, 26, 209, 38);
		panel.add(textNgayTK);
		textNgayTK.setColumns(10);

		textTSPB = new JTextField();
		textTSPB.setFont(new Font("Tahoma", Font.BOLD, 18));
		textTSPB.setHorizontalAlignment(SwingConstants.CENTER);
		textTSPB.setBounds(256, 75, 209, 38);
		panel.add(textTSPB);
		textTSPB.setColumns(10);

		JLabel lblNewLabel_1_1_1 = new JLabel("Tổng số hóa đơn bán hàng:");
		lblNewLabel_1_1_1.setBounds(503, 26, 227, 38);
		panel.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));

		textTSHDB = new JTextField();
		textTSHDB.setFont(new Font("Tahoma", Font.BOLD, 18));
		textTSHDB.setHorizontalAlignment(SwingConstants.CENTER);
		textTSHDB.setBounds(740, 29, 209, 38);
		panel.add(textTSHDB);
		textTSHDB.setColumns(10);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Tổng số hóa đơn nhập hàng:");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_1.setBounds(503, 75, 227, 38);
		panel.add(lblNewLabel_1_1_1_1);

		textTSHDN = new JTextField();
		textTSHDN.setHorizontalAlignment(SwingConstants.CENTER);
		textTSHDN.setFont(new Font("Tahoma", Font.BOLD, 18));
		textTSHDN.setColumns(10);
		textTSHDN.setBounds(740, 75, 209, 38);
		panel.add(textTSHDN);

		JLabel lblDanhSchSn_2 = new JLabel("Danh Sách Sản Phẩm Đã Nhập");
		lblDanhSchSn_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSchSn_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblDanhSchSn_2.setBounds(620, 473, 511, 38);
		contentPane.add(lblDanhSchSn_2);

		btnBack = new JButton("Trở về");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBackground(Color.RED);
		btnBack.setBounds(10, 10, 125, 31);
		contentPane.add(btnBack);

		// set ngay tk
		textNgayTK.setText(ngay.toString());

		JLabel lblNewLabel_1_1_2 = new JLabel("Tổng số sản phẩm đã nhập:");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_2.setBounds(990, 26, 219, 38);
		panel.add(lblNewLabel_1_1_2);

		textTSPN = new JTextField();
		textTSPN.setHorizontalAlignment(SwingConstants.CENTER);
		textTSPN.setFont(new Font("Tahoma", Font.BOLD, 18));
		textTSPN.setColumns(10);
		textTSPN.setBounds(1219, 29, 209, 38);
		panel.add(textTSPN);

		// Đăng ký SK
		btnBack.addActionListener(this);
		btnXN.addActionListener(this);

		//
		getSPB();
		//
		getSPN();
		//
		getTSPB();
		//
		getTSPN();
		//
		getTSHDB();
		//
		getTSHDN();
	}

	// lấy sp đã bán trong tháng
	public void getSPB() {
		String thang = ngay.getMonth().toString();
		LocalDate a;
		String thang2;
		String maHD;
		String maSP;
		int soL;
		String ten = null;
		String mau = null;
		String size = null;
		String loai = null;
		String lH = null;
		String maNCC = null;
		String tenNCC = null;
		double giaN = 0;
		double giaB = 0;
		double tt = 0;
		ArrayList<HoaDonBanHang> hdbh = new ArrayList<HoaDonBanHang>();
		ArrayList<ChiTietHDBH> ctbh = new ArrayList<ChiTietHDBH>();
		ArrayList<SanPham> sp = new ArrayList<SanPham>();
		DefaultTableModel tableSPB = (DefaultTableModel) tableTKDTT.getModel();
		hdbh = hdbh_Dao.dsHD();
		int c = 0;
		for (HoaDonBanHang hoaDonBanHang : hdbh) {
			a = hoaDonBanHang.getNgayL();
			thang2 = a.getMonth().toString();
			if (thang2.equals(thang)) {
				maHD = hoaDonBanHang.getMaHD();
				ctbh = ctbh_Dao.getMHD(maHD);
				for (ChiTietHDBH chiTietHDBH : ctbh) {
					maSP = chiTietHDBH.getMaSP().getMaSanPham();
					soL = chiTietHDBH.getSoL();
					if (check(maSP, soL) == true) {
						break;
					} else {
						sp = sp_Dao.timMSP(maSP);
						for (SanPham sanPham : sp) {
							ten = sanPham.getTenSanPham();
							mau = sanPham.getMau();
							size = sanPham.getSize();
							loai = sanPham.getLoai();
							lH = sanPham.getLoai();
							maNCC = sanPham.getMaNCC().getMaNhaCungCap();
							tenNCC = sanPham.getTenNCC().getMaNhaCungCap();
							giaB = sanPham.getGiaBan().doubleValue();
							giaN = sanPham.getGiaNhap().doubleValue();
							tt = giaB * soL;
							c++;
						}
						tableSPB.addRow(
								new Object[] { c, maSP, ten, mau, size, loai, soL, lH, maNCC, tenNCC, giaN, giaB, tt });
						tableSPB.fireTableDataChanged();
					}
				}
			}
		}
	}

	// check sp
	public boolean check(String ma, int a) {
		int n = tableTKDTT.getRowCount();
		for (int i = 0; i < n; i++) {
			String ma1 = tableTKDTT.getValueAt(i, 1).toString();
			if (ma1.equals(ma)) {
				int b = Integer.parseInt(tableTKDTT.getValueAt(i, 6).toString()) + a;
				dtm.setValueAt(b, i, 6);
				return true;
			}
		}
		return false;
	}

	// Lấy sp đã nhập trong tháng
	public void getSPN() {
		String thang = ngay.getMonth().toString();
		LocalDate a;
		String thang2;
		String maHD;
		String maSP;
		int soL;
		String ten = null;
		String mau = null;
		String size = null;
		String loai = null;
		String lH = null;
		String maNCC = null;
		String tenNCC = null;
		double giaN = 0;
		double giaB = 0;
		double tt = 0;
		ArrayList<HoaDonNhapHang> hdnh = new ArrayList<HoaDonNhapHang>();
		ArrayList<ChiTietHDNH> cthdn = new ArrayList<ChiTietHDNH>();
		ArrayList<SanPham> sp = new ArrayList<SanPham>();
		DefaultTableModel tableSPNH = (DefaultTableModel) tableSPN.getModel();
		hdnh = hdnh_Dao.dsHD();
		int c = 0;
		for (HoaDonNhapHang hoaDonNhapHang : hdnh) {
			a = hoaDonNhapHang.getNgayL();
			thang2 = a.getMonth().toString();
			if (thang2.equals(thang)) {
				maHD = hoaDonNhapHang.getMaHD();
				cthdn = ctnh_Dao.getMHD(maHD);
				for (ChiTietHDNH chiTietHDNH : cthdn) {
					maSP = chiTietHDNH.getMaSP().getMaSanPham();
					soL = chiTietHDNH.getsL();
					sp = sp_Dao.timMSP(maSP);
					for (SanPham sanPham : sp) {
						ten = sanPham.getTenSanPham();
						mau = sanPham.getMau();
						size = sanPham.getSize();
						loai = sanPham.getLoai();
						lH = sanPham.getLoai();
						maNCC = sanPham.getMaNCC().getMaNhaCungCap();
						tenNCC = sanPham.getTenNCC().getMaNhaCungCap();
						giaB = sanPham.getGiaBan().doubleValue();
						giaN = sanPham.getGiaNhap().doubleValue();
						tt = giaN * soL;
						c++;
					}
					tableSPNH.addRow(
							new Object[] { c, maSP, ten, mau, size, loai, soL, lH, maNCC, tenNCC, giaN, giaB, tt });
					tableSPNH.fireTableDataChanged();

				}
			}
		}
	}

	// Tính tổng số sp đã bán
	public void getTSPB() {
		int a = 0;
		int n = tableTKDTT.getRowCount();
		for (int i = 0; i < n; i++) {
			a = a + Integer.parseInt(tableTKDTT.getValueAt(i, 6).toString());
		}
		String b = String.valueOf(a);
		textTSPB.setText(b);
	}

	// Tính tổng số sp đã nhập
	public void getTSPN() {
		int a = 0;
		int n = tableSPN.getRowCount();
		for (int i = 0; i < n; i++) {
			a = a + Integer.parseInt(tableSPN.getValueAt(i, 6).toString());
		}
		String b = String.valueOf(a);
		textTSPN.setText(b);
	}

	// Lấy tổng số hóa đơn đã lập
	public void getTSHDB() {
		String thang = ngay.getMonth().toString();
		LocalDate a;
		String thang2;
		int c = 0;
		ArrayList<HoaDonBanHang> hdBH = new ArrayList<HoaDonBanHang>();
		hdBH = hdbh_Dao.dsHD();
		for (HoaDonBanHang hoaDonBanHang : hdBH) {
			a = hoaDonBanHang.getNgayL();
			thang2 = a.getMonth().toString();
			if (thang2.equals(thang)) {
				c++;
			}
		}
		String b = String.valueOf(c);
		textTSHDB.setText(b);
	}

	// Lấy tổng số hóa đơn NH đã lập
	public void getTSHDN() {
		String thang = ngay.getMonth().toString();
		LocalDate a;
		String thang2;
		int c = 0;
		ArrayList<HoaDonNhapHang> hdNH = new ArrayList<HoaDonNhapHang>();
		hdNH = hdnh_Dao.dsHD();
		for (HoaDonNhapHang hoaDonNhapHang : hdNH) {
			a = hoaDonNhapHang.getNgayL();
			thang2 = a.getMonth().toString();
			if (thang2.equals(thang)) {
				c++;
			}
		}
		String b = String.valueOf(c);
		textTSHDN.setText(b);
	}

	// xuất file
	public void xuatfile() {
		try {
			LocalDate a = LocalDate.now();
			@SuppressWarnings("resource")
			XSSFWorkbook f = new XSSFWorkbook();
			XSSFSheet sheet = f.createSheet("Thống kê cuối ngày");

			XSSFRow row = null;
			Cell cell = null;

			row = sheet.createRow((short) 2);
			row.setHeight((short) 500);
			cell = row.createCell(9, CellType.STRING);
			cell.setCellValue("Thống kê cuối tháng " + a.getMonth().toString());

			row = sheet.createRow((short) 3);
			row.setHeight((short) 400);
			cell = row.createCell(6, CellType.STRING);
			cell.setCellValue("Ngày thống kê: " + textNgayTK.getText());
			cell = row.createCell(10, CellType.STRING);
			cell.setCellValue("Tổng số hóa đơn bán hàng: " + textTSHDB.getText());
			cell = row.createCell(14, CellType.STRING);
			cell.setCellValue("Tổng số sản phẩm đã nhập: " + textTSPN.getText());

			row = sheet.createRow((short) 4);
			row.setHeight((short) 400);
			cell = row.createCell(6, CellType.STRING);
			cell.setCellValue("Tổng số sản phẩm bán: " + textTSPB.getText());
			cell = row.createCell(10, CellType.STRING);
			cell.setCellValue("Tổng số hóa đơn nhập: " + textTSHDN.getText());

			row = sheet.createRow((short) 6);
			row.setHeight((short) 500);
			cell = row.createCell(9, CellType.STRING);
			cell.setCellValue("Danh sách sản phẩm bán");

			row = sheet.createRow((short) 7);
			row.setHeight((short) 500);
			cell = row.createCell(7, CellType.STRING);
			cell.setCellValue("STT");
			cell = row.createCell(8, CellType.STRING);
			cell.setCellValue("Mã sản phẩm");
			cell = row.createCell(10, CellType.STRING);
			cell.setCellValue("Tên sản phẩm");
			cell = row.createCell(12, CellType.STRING);
			cell.setCellValue("Màu");
			cell = row.createCell(13, CellType.STRING);
			cell.setCellValue("Size");
			cell = row.createCell(14, CellType.STRING);
			cell.setCellValue("Loại");
			cell = row.createCell(15, CellType.STRING);
			cell.setCellValue("Số lượng");
			cell = row.createCell(16, CellType.STRING);
			cell.setCellValue("Lô hàng");
			cell = row.createCell(17, CellType.STRING);
			cell.setCellValue("Mã nhà cung cấp");
			cell = row.createCell(19, CellType.STRING);
			cell.setCellValue("Tên nhà cung cấp");
			cell = row.createCell(21, CellType.STRING);
			cell.setCellValue("Giá nhập");
			cell = row.createCell(23, CellType.STRING);
			cell.setCellValue("Giá bán");
			cell = row.createCell(25, CellType.STRING);
			cell.setCellValue("Thành tiền");

			int n = tableTKDTT.getRowCount();
			for (int i = 0; i < n; i++) {
				row = sheet.createRow((short) 8 + i + 1);
				row.setHeight((short) 500);
				cell = row.createCell(7, CellType.STRING);
				cell.setCellValue(tableTKDTT.getValueAt(i, 0).toString());
				cell = row.createCell(8, CellType.STRING);
				cell.setCellValue(tableTKDTT.getValueAt(i, 1).toString());
				cell = row.createCell(10, CellType.STRING);
				cell.setCellValue(tableTKDTT.getValueAt(i, 2).toString());
				cell = row.createCell(12, CellType.STRING);
				cell.setCellValue(tableTKDTT.getValueAt(i, 3).toString());
				cell = row.createCell(13, CellType.STRING);
				cell.setCellValue(tableTKDTT.getValueAt(i, 4).toString());
				cell = row.createCell(14, CellType.STRING);
				cell.setCellValue(tableTKDTT.getValueAt(i, 5).toString());
				cell = row.createCell(15, CellType.STRING);
				cell.setCellValue(tableTKDTT.getValueAt(i, 6).toString());
				cell = row.createCell(16, CellType.STRING);
				cell.setCellValue(tableTKDTT.getValueAt(i, 7).toString());
				cell = row.createCell(17, CellType.STRING);
				cell.setCellValue(tableTKDTT.getValueAt(i, 8).toString());
				cell = row.createCell(19, CellType.STRING);
				cell.setCellValue(tableTKDTT.getValueAt(i, 9).toString());
				cell = row.createCell(21, CellType.STRING);
				cell.setCellValue(tableTKDTT.getValueAt(i, 10).toString());
				cell = row.createCell(23, CellType.STRING);
				cell.setCellValue(tableTKDTT.getValueAt(i, 11).toString());
				cell = row.createCell(25, CellType.STRING);
				cell.setCellValue(tableTKDTT.getValueAt(i, 12).toString());
			}

			row = sheet.createRow((short) 9 + n);
			row.setHeight((short) 500);
			cell = row.createCell(5, CellType.STRING);
			cell.setCellValue("-----------------------------------------------------------------------"
					+ "---------------------------------------------------------------------------------"
					+ "-----------------------------------------------------------------------------------"
					+ "----------------------------");

			row = sheet.createRow((short) 9 + n + 1);
			row.setHeight((short) 500);
			cell = row.createCell(9, CellType.STRING);
			cell.setCellValue("Danh sách sản phẩm nhập");

			row = sheet.createRow((short) 9 + n + 2);
			row.setHeight((short) 500);
			cell = row.createCell(7, CellType.STRING);
			cell.setCellValue("STT");
			cell = row.createCell(8, CellType.STRING);
			cell.setCellValue("Mã sản phẩm");
			cell = row.createCell(10, CellType.STRING);
			cell.setCellValue("Tên sản phẩm");
			cell = row.createCell(12, CellType.STRING);
			cell.setCellValue("Màu");
			cell = row.createCell(13, CellType.STRING);
			cell.setCellValue("Size");
			cell = row.createCell(14, CellType.STRING);
			cell.setCellValue("Loại");
			cell = row.createCell(15, CellType.STRING);
			cell.setCellValue("Số lượng");
			cell = row.createCell(16, CellType.STRING);
			cell.setCellValue("Lô hàng");
			cell = row.createCell(17, CellType.STRING);
			cell.setCellValue("Mã nhà cung cấp");
			cell = row.createCell(19, CellType.STRING);
			cell.setCellValue("Tên nhà cung cấp");
			cell = row.createCell(21, CellType.STRING);
			cell.setCellValue("Giá nhập");
			cell = row.createCell(23, CellType.STRING);
			cell.setCellValue("Giá bán");
			cell = row.createCell(25, CellType.STRING);
			cell.setCellValue("Thành tiền");

			int m = tableSPN.getRowCount();
			for (int i = 0; i < m; i++) {
				row = sheet.createRow((short) 9 + n + 1 + i + 1);
				row.setHeight((short) 500);
				cell = row.createCell(7, CellType.STRING);
				cell.setCellValue(tableSPN.getValueAt(i, 0).toString());
				cell = row.createCell(8, CellType.STRING);
				cell.setCellValue(tableSPN.getValueAt(i, 1).toString());
				cell = row.createCell(10, CellType.STRING);
				cell.setCellValue(tableSPN.getValueAt(i, 2).toString());
				cell = row.createCell(12, CellType.STRING);
				cell.setCellValue(tableSPN.getValueAt(i, 3).toString());
				cell = row.createCell(13, CellType.STRING);
				cell.setCellValue(tableSPN.getValueAt(i, 4).toString());
				cell = row.createCell(14, CellType.STRING);
				cell.setCellValue(tableSPN.getValueAt(i, 5).toString());
				cell = row.createCell(15, CellType.STRING);
				cell.setCellValue(tableSPN.getValueAt(i, 6).toString());
				cell = row.createCell(16, CellType.STRING);
				cell.setCellValue(tableSPN.getValueAt(i, 7).toString());
				cell = row.createCell(17, CellType.STRING);
				cell.setCellValue(tableSPN.getValueAt(i, 8).toString());
				cell = row.createCell(19, CellType.STRING);
				cell.setCellValue(tableSPN.getValueAt(i, 9).toString());
				cell = row.createCell(21, CellType.STRING);
				cell.setCellValue(tableSPN.getValueAt(i, 10).toString());
				cell = row.createCell(23, CellType.STRING);
				cell.setCellValue(tableSPN.getValueAt(i, 11).toString());
				cell = row.createCell(25, CellType.STRING);
				cell.setCellValue(tableSPN.getValueAt(i, 12).toString());
			}

			row = sheet.createRow((short) 9 + n + 4 + m + 1);
			row.setHeight((short) 500);
			cell = row.createCell(5, CellType.STRING);
			cell.setCellValue("-----------------------------------------------------------------------"
					+ "---------------------------------------------------------------------------------"
					+ "-----------------------------------------------------------------------------------"
					+ "----------------------------");

			FileOutputStream out = new FileOutputStream(new File("V:/TKCN-" + a.getMonth().toString() + ".xlsx"));
			f.write(out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnBack)) {
			new Gui_QuanLy().setVisible(true);
			dispose();
		}
		if (obj.equals(btnXN)) {
			xuatfile();
			LocalDate a = LocalDate.now();
			JOptionPane.showMessageDialog(this, "Báo cáo " + "TKCT-" + a.getMonth().toString() + "đãn được xuất!!");
		}

	}
}
