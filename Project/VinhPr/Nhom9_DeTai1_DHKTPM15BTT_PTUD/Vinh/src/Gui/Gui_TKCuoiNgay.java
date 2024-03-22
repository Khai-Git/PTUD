package Gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ConnectDB.ConnectDB;
import Dao.ChiTietHDBH_Dao;
import Dao.HoaDonBanHang_DAO;
import Dao.NhanVien_DAO;
import Dao.SanPham_DAO;
import Entity.ChiTietHDBH;
import Entity.HoaDonBanHang;
import Entity.NhanVien;
import Entity.SanPham;

import java.awt.Color;
import javax.swing.border.LineBorder;

public class Gui_TKCuoiNgay extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textMNV;
	private JTextField textTNV;
	private JTextField textNgayTK;
	private JTextField textTSHD;
	private JTextField textTSSPB;
	private JTextField textTSSPT;
	private JTable tableDSSPB;
	private DefaultTableModel dtm;
	private DefaultTableModel dtm1;
	private JTable tableDSSPT;
	private JTextField textMSPLN;
	private JTextField textTSPLN;
	private JTextField textSLLN;
	private LocalDate a = LocalDate.now();
	private HoaDonBanHang_DAO hd_Dao;
	private NhanVien_DAO nv_Dao = new NhanVien_DAO();
	private ChiTietHDBH_Dao ct_Dao = new ChiTietHDBH_Dao();
	private SanPham_DAO sp_Dao = new SanPham_DAO();
	private JButton btnXN;
	private JButton btnBack;


	/**
	 * Create the frame.
	 */
	public Gui_TKCuoiNgay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setSize(1920, 1080);
		setBounds(100, 100, 1611, 882);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// connect database
		hd_Dao = new HoaDonBanHang_DAO();
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		btnBack = new JButton("Trở lại");
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(Color.RED);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.setBounds(33, 25, 103, 37);
		contentPane.add(btnBack);

		JLabel lblNewLabel = new JLabel("Mã nhân viên thống kê :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(72, 617, 179, 30);
		contentPane.add(lblNewLabel);

		JLabel lblTnNhnVin = new JLabel("Tên nhân viên thống kê:");
		lblTnNhnVin.setHorizontalAlignment(SwingConstants.CENTER);
		lblTnNhnVin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTnNhnVin.setBounds(72, 657, 179, 30);
		contentPane.add(lblTnNhnVin);

		textMNV = new JTextField();
		textMNV.setHorizontalAlignment(SwingConstants.CENTER);
		textMNV.setEditable(false);
		textMNV.setFont(new Font("Tahoma", Font.BOLD, 13));
		textMNV.setBounds(261, 617, 195, 30);
		contentPane.add(textMNV);
		textMNV.setColumns(10);

		textTNV = new JTextField();
		textTNV.setHorizontalAlignment(SwingConstants.CENTER);
		textTNV.setEditable(false);
		textTNV.setFont(new Font("Tahoma", Font.BOLD, 13));
		textTNV.setColumns(10);
		textTNV.setBounds(261, 657, 195, 30);
		contentPane.add(textTNV);

		JLabel lblNgyThngK = new JLabel("Ngày thống kê :");
		lblNgyThngK.setHorizontalAlignment(SwingConstants.CENTER);
		lblNgyThngK.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNgyThngK.setBounds(130, 577, 121, 30);
		contentPane.add(lblNgyThngK);

		textNgayTK = new JTextField();
		textNgayTK.setHorizontalAlignment(SwingConstants.CENTER);
		textNgayTK.setEditable(false);
		textNgayTK.setFont(new Font("Tahoma", Font.BOLD, 13));
		textNgayTK.setColumns(10);
		textNgayTK.setBounds(261, 577, 195, 30);
		contentPane.add(textNgayTK);
		// Ngày thống kê
		textNgayTK.setText(a.toString());

		JLabel lblTngSHa = new JLabel("Tồng số hóa đơn đã lập :");
		lblTngSHa.setHorizontalAlignment(SwingConstants.CENTER);
		lblTngSHa.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTngSHa.setBounds(610, 577, 160, 30);
		contentPane.add(lblTngSHa);

		JLabel lblTngSSn = new JLabel("Tồng số sản phẩm đã bán :");
		lblTngSSn.setHorizontalAlignment(SwingConstants.CENTER);
		lblTngSSn.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTngSSn.setBounds(589, 617, 184, 30);
		contentPane.add(lblTngSSn);

		JLabel lblTngSSn_1 = new JLabel("Tồng số sản phẩm tồn :");
		lblTngSSn_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTngSSn_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTngSSn_1.setBounds(610, 657, 160, 30);
		contentPane.add(lblTngSSn_1);

		textTSHD = new JTextField();
		textTSHD.setHorizontalAlignment(SwingConstants.CENTER);
		textTSHD.setEditable(false);
		textTSHD.setFont(new Font("Tahoma", Font.BOLD, 13));
		textTSHD.setColumns(10);
		textTSHD.setBounds(780, 579, 211, 30);
		contentPane.add(textTSHD);

		textTSSPB = new JTextField();
		textTSSPB.setHorizontalAlignment(SwingConstants.CENTER);
		textTSSPB.setEditable(false);
		textTSSPB.setFont(new Font("Tahoma", Font.BOLD, 13));
		textTSSPB.setColumns(10);
		textTSSPB.setBounds(780, 619, 211, 30);
		contentPane.add(textTSSPB);

		textTSSPT = new JTextField();
		textTSSPT.setHorizontalAlignment(SwingConstants.CENTER);
		textTSSPT.setEditable(false);
		textTSSPT.setFont(new Font("Tahoma", Font.BOLD, 13));
		textTSSPT.setColumns(10);
		textTSSPT.setBounds(780, 659, 211, 30);
		contentPane.add(textTSSPT);

		new JPanel();
		String[] cols = { "STT", "Mã sản phẩm", "Tên sản phẩm", "Màu", "Loại", "Size", "Lô hàng", "Số lượng", "�?ơn giá",
				"Thành Ti�?n" };
		dtm = new DefaultTableModel(cols, 0);
		tableDSSPB = new JTable(dtm);
		tableDSSPB.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JScrollPane scrollSP = new JScrollPane(tableDSSPB);
		scrollSP.setBounds(23, 96, 1507, 184);
		contentPane.add(scrollSP);

		String[] cols1 = { "STT", "Mã sản phẩm", "Tên sản phẩm", "Màu", "Loại", "Size", "Lô hàng", "Số lượng tồn" };
		dtm1 = new DefaultTableModel(cols1, 0);
		tableDSSPT = new JTable(dtm1);
		tableDSSPT.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JScrollPane scrollSP_1 = new JScrollPane(tableDSSPT);
		scrollSP_1.setBounds(23, 357, 1507, 184);
		contentPane.add(scrollSP_1);

		JLabel lblNewLabel_1 = new JLabel("Danh Sách Sản Phẩm �?ã Bán");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(577, 37, 329, 46);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Danh Sách Sản Phẩm Tồn Kho");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(579, 290, 343, 46);
		contentPane.add(lblNewLabel_1_1);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(23, 559, 1507, 167);
		contentPane.add(panel);
		panel.setLayout(null);

		textMSPLN = new JTextField();
		textMSPLN.setEditable(false);
		textMSPLN.setHorizontalAlignment(SwingConstants.CENTER);
		textMSPLN.setBounds(1182, 22, 211, 30);
		panel.add(textMSPLN);
		textMSPLN.setFont(new Font("Tahoma", Font.BOLD, 13));
		textMSPLN.setColumns(10);

		JLabel lblTngSChit = new JLabel("Sản phẩm bán nhi�?u nhất :");
		lblTngSChit.setBounds(990, 22, 184, 30);
		panel.add(lblTngSChit);
		lblTngSChit.setHorizontalAlignment(SwingConstants.CENTER);
		lblTngSChit.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel lblTnSnPhm = new JLabel("       Tên sản phẩm:");
		lblTnSnPhm.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTnSnPhm.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTnSnPhm.setBounds(1028, 62, 146, 30);
		panel.add(lblTnSnPhm);

		JLabel lblLHng = new JLabel("       Số lượng bán:");
		lblLHng.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLHng.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLHng.setBounds(1028, 99, 146, 30);
		panel.add(lblLHng);

		textTSPLN = new JTextField();
		textTSPLN.setEditable(false);
		textTSPLN.setHorizontalAlignment(SwingConstants.CENTER);
		textTSPLN.setFont(new Font("Tahoma", Font.BOLD, 13));
		textTSPLN.setColumns(10);
		textTSPLN.setBounds(1182, 62, 211, 30);
		panel.add(textTSPLN);

		textSLLN = new JTextField();
		textSLLN.setEditable(false);
		textSLLN.setHorizontalAlignment(SwingConstants.CENTER);
		textSLLN.setFont(new Font("Tahoma", Font.BOLD, 13));
		textSLLN.setColumns(10);
		textSLLN.setBounds(1182, 106, 211, 30);
		panel.add(textSLLN);

		btnXN = new JButton("Xác nhận");
		btnXN.setBounds(1211, 745, 136, 38);
		contentPane.add(btnXN);
		btnXN.setBackground(Color.GREEN);
		btnXN.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXN.addActionListener(this);

		// �?ăng ký sk
		btnBack.addActionListener(this);
		btnXN.addActionListener(this);

		// Lấy thông tin nv
		getNV();
		//
		getDSSPB();
		//
		getTSHD();
		//
		getSPLN();
		//
		getTSP();
		//
		getDSSPT();
		//
		getTSSPT();
	}

	// Lấy thông tin nhân viên thống kê
	public void getNV() {
		nv_Dao = new NhanVien_DAO();
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String maNV = Gui_DangNhap.getMaTX();
		String tenNV = null;
		ArrayList<NhanVien> nvDN = nv_Dao.getMNV(maNV);
		for (NhanVien nhanVien : nvDN) {
			tenNV = nhanVien.getTenNhanVien();
		}
		textMNV.setText(maNV);
		textTNV.setText(tenNV);
	}

	// Lấy thông tin sản phẩm bán trong ngày
	public void getDSSPB() {
		String maHD;
		String maSP = null;
		String ten = null;
		int soL = 0;
		BigDecimal tt = null;
		String mau = null;
		String loai = null;
		String size = null;
		String lH = null;
		BigDecimal dg = null;
		DefaultTableModel tableSP1 = (DefaultTableModel) tableDSSPB.getModel();
		ArrayList<HoaDonBanHang> hdBH = new ArrayList<HoaDonBanHang>();
		ArrayList<ChiTietHDBH> ct = new ArrayList<ChiTietHDBH>();
		ArrayList<SanPham> sp = new ArrayList<SanPham>();
		hdBH = hd_Dao.timNgay(a);
		int n = 0;
		for (HoaDonBanHang hoaDonBanHang : hdBH) {
			maHD = hoaDonBanHang.getMaHD();
			ct = ct_Dao.getMHD(maHD);
			for (ChiTietHDBH chiTietHDBH : ct) {
				maSP = chiTietHDBH.getMaSP().getMaSanPham();
				soL = chiTietHDBH.getSoL();
				if (check(maSP, soL) == true) {
					break;
				} else {
					tt = chiTietHDBH.gettT();
					sp = sp_Dao.timMSP(maSP);
					for (SanPham sanPham : sp) {
						ten = sanPham.getTenSanPham();
						mau = sanPham.getMau();
						loai = sanPham.getLoai();
						size = sanPham.getSize();
						lH = sanPham.getLoHang();
						dg = sanPham.getGiaBan();
						n++;
					}
					tableSP1.addRow(new Object[] { n, maSP, ten, mau, loai, size, lH, soL, dg, tt });
					tableSP1.fireTableDataChanged();
				}

			}

		}

	}

	// check sp
	public boolean check(String ma, int a) {
		int n = tableDSSPB.getRowCount();
		for (int i = 0; i < n; i++) {
			String ma1 = tableDSSPB.getValueAt(i, 1).toString();
			if (ma1.equals(ma)) {
				int b = Integer.parseInt(tableDSSPB.getValueAt(i, 7).toString()) + a;
				dtm.setValueAt(b, i, 7);
				return true;
			}
		}
		return false;
	}

	// Lấy tổng số hóa đơn đã lập
	public void getTSHD() {
		int c = 0;
		ArrayList<HoaDonBanHang> hdBH = new ArrayList<HoaDonBanHang>();
		hdBH = hd_Dao.timNgay(a);
		for (int i = 0; i < hdBH.size(); i++) {
			c++;
		}
		String b = String.valueOf(c);
		textTSHD.setText(b);
	}

	// Lấy thông tin sp bán nhi�?u nhất
	public void getSPLN() {
		int a = 0;
		int b = 0;
		int c = 0;
		String ma = null;
		String ten = null;
		int n = tableDSSPB.getRowCount();
		for (int i = 0; i < n; i++) {
			a = Integer.parseInt(tableDSSPB.getValueAt(i, 7).toString());
			ma = tableDSSPB.getValueAt(i, 1).toString();
			ten = tableDSSPB.getValueAt(i, 2).toString();
			c = a;
			for (int j = i + 1; j < n - 1; j++) {
				b = Integer.parseInt(tableDSSPB.getValueAt(j, 7).toString());
				if (b > a) {
					ma = tableDSSPB.getValueAt(j, 1).toString();
					ten = tableDSSPB.getValueAt(j, 2).toString();
					c = b;
				}
			}
		}
		String d = String.valueOf(c);
		textMSPLN.setText(ma);
		textTSPLN.setText(ten);
		textSLLN.setText(d);
	}

	// Tính tổng số sp đã bán
	public void getTSP() {
		int a = 0;
		int n = tableDSSPB.getRowCount();
		for (int i = 0; i < n; i++) {
			a = a + Integer.parseInt(tableDSSPB.getValueAt(i, 7).toString());
		}
		String b = String.valueOf(a);
		textTSSPB.setText(b);
	}

	// Tính tổng số SP tồn
	public void getTSSPT() {
		int a = 0;
		int n = tableDSSPT.getRowCount();
		for (int i = 0; i < n; i++) {
			a = a + Integer.parseInt(tableDSSPT.getValueAt(i, 7).toString());
		}
		String b = String.valueOf(a);
		textTSSPT.setText(b);
	}

	// Lấy ds SP tồn
	public void getDSSPT() {
		ArrayList<SanPham> sp = new ArrayList<SanPham>();
		DefaultTableModel tableSPT = (DefaultTableModel) tableDSSPT.getModel();
		sp = sp_Dao.dsSP();
		for (SanPham sanPham : sp) {
			int a = sanPham.getSoLuongTon();
			if (a <= 0) {
				break;
			} else {
				String ma = sanPham.getMaSanPham();
				String mau = sanPham.getMau();
				String ten = sanPham.getTenSanPham();
				String loai = sanPham.getLoai();
				String size = sanPham.getSize();
				String lH = sanPham.getLoHang();
				int n = tableDSSPT.getRowCount();
				tableSPT.addRow(new Object[] { n + 1, ma, ten, mau, loai, size, lH, a });
				tableSPT.fireTableDataChanged();

			}
		}
	}

	// Tính tổng ti�?n đã thu
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
			cell.setCellValue("Thống kê cuối ngày " + a);

			row = sheet.createRow((short) 3);
			row.setHeight((short) 400);
			cell = row.createCell(6, CellType.STRING);
			String ngay = textNgayTK.getText();
			cell.setCellValue("Ngày thống kê: " + ngay);
			cell = row.createCell(10, CellType.STRING);
			String tshd = textTSHD.getText();
			cell.setCellValue("Tổng số hóa đơn: " + tshd);
			cell = row.createCell(14, CellType.STRING);
			String spbn = textMSPLN.getText();
			cell.setCellValue("Ngày thống kê: " + spbn);

			row = sheet.createRow((short) 4);
			row.setHeight((short) 400);
			cell = row.createCell(6, CellType.STRING);
			String maNV = textMNV.getText();
			cell.setCellValue("Mã nhân viên thống kê: " + maNV);
			cell = row.createCell(10, CellType.STRING);
			String tsspb = textTSSPB.getText();
			cell.setCellValue("Tổng sô sản phẩm đã bán: " + tsspb);
			cell = row.createCell(14, CellType.STRING);
			String tenSP = textTSPLN.getText();
			cell.setCellValue("Ngày thống kê: " + tenSP);

			row = sheet.createRow((short) 5);
			row.setHeight((short) 400);
			cell = row.createCell(6, CellType.STRING);
			String tenNV = textTNV.getText();
			cell.setCellValue("Tên nhân viên thống kê: " + tenNV);
			cell = row.createCell(10, CellType.STRING);
			String tsspt = textTSSPT.getText();
			cell.setCellValue("Tổng số sản phẩm tồn: " + tsspt);
			cell = row.createCell(14, CellType.STRING);
			String slb = textMSPLN.getText();
			cell.setCellValue("Số lượng bán: " + slb);

			row = sheet.createRow((short) 7);
			row.setHeight((short) 500);
			cell = row.createCell(9, CellType.STRING);
			cell.setCellValue("Danh sách sản phẩm bán");

			row = sheet.createRow((short) 8);
			row.setHeight((short) 500);
			cell = row.createCell(5, CellType.STRING);
			cell.setCellValue("STT");
			cell = row.createCell(6, CellType.STRING);
			cell.setCellValue("Mã sản phẩm");
			cell = row.createCell(8, CellType.STRING);
			cell.setCellValue("Tên sản phẩm");
			cell = row.createCell(10, CellType.STRING);
			cell.setCellValue("Màu");
			cell = row.createCell(11, CellType.STRING);
			cell.setCellValue("Loại");
			cell = row.createCell(12, CellType.STRING);
			cell.setCellValue("Size");
			cell = row.createCell(13, CellType.STRING);
			cell.setCellValue("Lô Hàng");
			cell = row.createCell(14, CellType.STRING);
			cell.setCellValue("Số lượng");
			cell = row.createCell(15, CellType.STRING);
			cell.setCellValue("�?ơn giá");
			cell = row.createCell(17, CellType.STRING);
			cell.setCellValue("Thành Ti�?n");

			int n = tableDSSPB.getRowCount();
			for (int i = 0; i < n; i++) {
				row = sheet.createRow((short) 9 + i + 1);
				row.setHeight((short) 500);
				cell = row.createCell(5, CellType.STRING);
				String stt = tableDSSPB.getValueAt(i, 0).toString();
				cell.setCellValue(stt);
				cell = row.createCell(6, CellType.STRING);
				String ma1 = tableDSSPB.getValueAt(i, 1).toString();
				cell.setCellValue(ma1);
				cell = row.createCell(8, CellType.STRING);
				String ten1 = tableDSSPB.getValueAt(i, 2).toString();
				cell.setCellValue(ten1);
				cell = row.createCell(10, CellType.STRING);
				String mau1 = tableDSSPB.getValueAt(i, 3).toString();
				cell.setCellValue(mau1);
				cell = row.createCell(11, CellType.STRING);
				String loai1 = tableDSSPB.getValueAt(i, 4).toString();
				cell.setCellValue(loai1);
				cell = row.createCell(12, CellType.STRING);
				String size1 = tableDSSPB.getValueAt(i, 5).toString();
				cell.setCellValue(size1);
				cell = row.createCell(13, CellType.STRING);
				String lH1 = tableDSSPB.getValueAt(i, 6).toString();
				cell.setCellValue(lH1);
				cell = row.createCell(14, CellType.STRING);
				String sl1 = tableDSSPB.getValueAt(i, 7).toString();
				cell.setCellValue(sl1);
				cell = row.createCell(15, CellType.STRING);
				String dg = tableDSSPB.getValueAt(i, 8).toString();
				cell.setCellValue(dg);
				cell = row.createCell(17, CellType.STRING);
				String tt = tableDSSPB.getValueAt(i, 9).toString();
				cell.setCellValue(tt);
			}
			row = sheet.createRow((short) 10 + n);
			row.setHeight((short) 400);
			cell = row.createCell(4, CellType.STRING);
			cell.setCellValue("----------------------------------------------------------------"
					+ "----------------------------------------------------------------"
					+ "------------------------------------------------------------------------------------------");
			row = sheet.createRow((short) 10 + n + 1);
			row.setHeight((short) 500);
			cell = row.createCell(9, CellType.STRING);
			cell.setCellValue("Danh sách sản phẩm tồn");

			row = sheet.createRow((short) 10 + n + 2);
			row.setHeight((short) 500);
			cell = row.createCell(5, CellType.STRING);
			cell.setCellValue("STT");
			cell = row.createCell(6, CellType.STRING);
			cell.setCellValue("Mã sản phẩm");
			cell = row.createCell(8, CellType.STRING);
			cell.setCellValue("Tên sản phẩm");
			cell = row.createCell(10, CellType.STRING);
			cell.setCellValue("Màu");
			cell = row.createCell(11, CellType.STRING);
			cell.setCellValue("Loại");
			cell = row.createCell(12, CellType.STRING);
			cell.setCellValue("Size");
			cell = row.createCell(13, CellType.STRING);
			cell.setCellValue("Lô Hàng");
			cell = row.createCell(14, CellType.STRING);
			cell.setCellValue("Số lượng tồn");

			int m = tableDSSPT.getRowCount();
			for (int i = 0; i < m; i++) {
				row = sheet.createRow((short) 10 + n + 3 + i);
				row.setHeight((short) 500);
				cell = row.createCell(5, CellType.STRING);
				String stt = tableDSSPT.getValueAt(i, 0).toString();
				cell.setCellValue(stt);
				cell = row.createCell(6, CellType.STRING);
				String ma1 = tableDSSPT.getValueAt(i, 1).toString();
				cell.setCellValue(ma1);
				cell = row.createCell(8, CellType.STRING);
				String ten1 = tableDSSPT.getValueAt(i, 2).toString();
				cell.setCellValue(ten1);
				cell = row.createCell(10, CellType.STRING);
				String mau1 = tableDSSPT.getValueAt(i, 3).toString();
				cell.setCellValue(mau1);
				cell = row.createCell(11, CellType.STRING);
				String loai1 = tableDSSPT.getValueAt(i, 4).toString();
				cell.setCellValue(loai1);
				cell = row.createCell(12, CellType.STRING);
				String size1 = tableDSSPT.getValueAt(i, 5).toString();
				cell.setCellValue(size1);
				cell = row.createCell(13, CellType.STRING);
				String lH1 = tableDSSPT.getValueAt(i, 6).toString();
				cell.setCellValue(lH1);
				cell = row.createCell(14, CellType.STRING);
				String sl1 = tableDSSPT.getValueAt(i, 7).toString();
				cell.setCellValue(sl1);
			}

			FileOutputStream out = new FileOutputStream(new File("V:/TKCN-" + a + ".xlsx"));
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
			new Gui_NhanVien().setVisible(true);
			dispose();
		}
		if (obj.equals(btnXN)) {
			xuatfile();
			JOptionPane.showMessageDialog(this, "�?ã in báo cáo!!");
		}

	}
}
