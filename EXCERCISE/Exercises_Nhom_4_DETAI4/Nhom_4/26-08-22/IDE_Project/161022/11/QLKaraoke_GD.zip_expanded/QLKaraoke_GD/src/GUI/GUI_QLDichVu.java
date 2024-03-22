package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ConnectDB.ConnectDB;
import DAO.DAO_QLDichVu;
import DAO.DAO_QLPhong;
import Entity.Entity_ChiTietHoaDonSanPham;
import Entity.Entity_HoaDonSanPham;
import Entity.Entity_KhachHang;
import Entity.Entity_NhanVien;
import Entity.Entity_Phong;
import Entity.Entity_SanPham;

import javax.swing.JScrollPane;
import java.awt.TextField;
import javax.swing.border.EtchedBorder;



public class GUI_QLDichVu extends JFrame implements ActionListener,MouseListener {

	private JPanel contentPane;
	private JButton btnManHinhChinh,btnDatPhong, btnHoaDon, btnDichVu,btnNhanVien, btnQLPhong, btnKhachHang,btnThongKe;
	private JButton btnDangXuat,btnTimKiem, btnChonThongTinPhong ,btnLuuHD, btnChonSP, btnLamMoi;
	private JLabel lblTenNhanVien, lblHinh, lblSDTKhachHang, lblTenKhachHang, lblTitle, lblNhanVien, lblNhapSoLuong, lblHoaDonSanPham, lblNTenKhachHang;
	private JTextField txtNhpTnPhng;
	private JTable tableThongTinPhong;
	private JTable tableDSSP;
	private JTextField textField_NhapSL;
	private JTable tableHDSP;
	private JPanel panelHDSP, panelDSSP, panelThongTinPhong, panelDichVu;
	private JScrollPane scrollPaneThongTinPhong, scrollPaneDSSP, scrollPaneHDSP;
	private DefaultTableModel tableModelThongTinPhong, tableModelDSSP, tableModelHDSP;
	private JTextField txtTenPhongHid;
	private JLabel lblNSDTKhachHang;
	private JLabel lblTenPhong;
	private JLabel lblNTenPhong;
	private JTextField txtMaPhongHid;
	private JTextField txtNMaSP;
	private JTextField txtNTenSP;
	private JTextField txtNDonGiaSP;
	private JLabel lblMaChiTietHDSP;
	private JTextField txtCthdsp;
	
	private DAO_QLDichVu ds_hdsp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_QLDichVu frame = new GUI_QLDichVu();
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
	public GUI_QLDichVu() {
		setTitle("Quản lý KARAOKE_NICE");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnManHinhChinh = new JButton("Màn hình chính");
		btnManHinhChinh.setIcon(new ImageIcon(GUI_QLDichVu.class.getResource("/img/home-icon.png")));
		btnManHinhChinh.setHorizontalAlignment(SwingConstants.LEFT);
		btnManHinhChinh.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnManHinhChinh.setBounds(0, 97, 225, 78);
		contentPane.add(btnManHinhChinh);
		
		btnDatPhong = new JButton(" Đặt phòng");
		btnDatPhong.setIcon(new ImageIcon(GUI_QLDichVu.class.getResource("/img/Book_room.jpg")));
		btnDatPhong.setHorizontalAlignment(SwingConstants.LEFT);
		btnDatPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDatPhong.setBounds(0, 173, 225, 78);
		contentPane.add(btnDatPhong);
		
		btnHoaDon = new JButton(" Hóa đơn");
		btnHoaDon.setIcon(new ImageIcon(GUI_QLDichVu.class.getResource("/img/bill_icon1.png")));
		btnHoaDon.setHorizontalAlignment(SwingConstants.LEFT);
		btnHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHoaDon.setBounds(0, 245, 225, 78);
		contentPane.add(btnHoaDon);
		
		btnDichVu = new JButton(" Dịch vụ");
		btnDichVu.setBackground(new Color(255, 255, 0));
		btnDichVu.setIcon(new ImageIcon(GUI_QLDichVu.class.getResource("/img/menu2.png")));
		btnDichVu.setHorizontalAlignment(SwingConstants.LEFT);
		btnDichVu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDichVu.setBounds(0, 322, 225, 78);
		contentPane.add(btnDichVu);
		
		btnNhanVien = new JButton(" Nhân viên");
		btnNhanVien.setIcon(new ImageIcon(GUI_QLDichVu.class.getResource("/img/black-man-icon.png")));
		btnNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNhanVien.setBounds(0, 397, 225, 78);
		contentPane.add(btnNhanVien);
		
		btnQLPhong = new JButton(" Quản lý phòng");
		btnQLPhong.setIcon(new ImageIcon(GUI_QLDichVu.class.getResource("/img/Science-Plus-Math-icon.png")));
		btnQLPhong.setHorizontalAlignment(SwingConstants.LEFT);
		btnQLPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnQLPhong.setBounds(0, 473, 225, 78);
		contentPane.add(btnQLPhong);
		
		btnKhachHang = new JButton("  Khách hàng");
		btnKhachHang.setIcon(new ImageIcon(GUI_QLDichVu.class.getResource("/img/users-icon.png")));
		btnKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		btnKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnKhachHang.setBounds(0, 549, 225, 78);
		contentPane.add(btnKhachHang);
		
		btnThongKe = new JButton("Thống kê số liệu");
		btnThongKe.setIcon(new ImageIcon(GUI_HoaDon.class.getResource("/img/Dollar-Sign-icon.png")));
		btnThongKe.setHorizontalAlignment(SwingConstants.LEFT);
		btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThongKe.setBounds(0, 625, 225, 78);
		contentPane.add(btnThongKe);
		
		lblTitle = new JLabel("PHẦN MỀM QUẢN LÍ KARAOKE");
		lblTitle.setForeground(new Color(0, 0, 0));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblTitle.setBackground(SystemColor.activeCaption);
		lblTitle.setBounds(20, 11, 1474, 86);
		contentPane.add(lblTitle);
		
		lblNhanVien = new JLabel("Nhân viên : ");
		lblNhanVien.setBounds(1090, 74, 75, 23);
		contentPane.add(lblNhanVien);
		
		btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setBackground(new Color(255, 155, 157));
		btnDangXuat.setBounds(1377, 74, 97, 23);
		contentPane.add(btnDangXuat);
		
		panelDichVu = new JPanel();
		panelDichVu.setBackground(SystemColor.activeCaption);
		panelDichVu.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "D\u1ECBch v\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDichVu.setToolTipText("");
		panelDichVu.setBounds(237, 97, 1237, 653);
		contentPane.add(panelDichVu);
		panelDichVu.setLayout(null);
		
		panelThongTinPhong = new JPanel();
		panelThongTinPhong.setBackground(SystemColor.activeCaption);
		panelThongTinPhong.setBorder(new TitledBorder(null, "Th\u00F4ng tin ph\u00F2ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelThongTinPhong.setBounds(10, 21, 1217, 216);
		panelDichVu.add(panelThongTinPhong);
		panelThongTinPhong.setLayout(null);
		
		txtNhpTnPhng = new JTextField();
		txtNhpTnPhng.setText("Phòng ");
		txtNhpTnPhng.setToolTipText("Nhập tên phòng");
		txtNhpTnPhng.setBackground(SystemColor.activeCaptionBorder);
		txtNhpTnPhng.setHorizontalAlignment(SwingConstants.LEFT);
		txtNhpTnPhng.setBounds(442, 12, 126, 20);
		panelThongTinPhong.add(txtNhpTnPhng);
		txtNhpTnPhng.setColumns(10);
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setForeground(new Color(255, 255, 255));
		btnTimKiem.setBackground(new Color(47, 79, 79));
		btnTimKiem.setBounds(591, 11, 89, 23);
		panelThongTinPhong.add(btnTimKiem);
		
		Box dsP;
		
		panelThongTinPhong.add(dsP = Box.createHorizontalBox());
		panelThongTinPhong.add(Box.createVerticalStrut(10));
		String [] headersTTP = "Mã phòng; Tên phòng; Loại phòng; Giá tiền; Sức chứa;Tình trạng".split(";");
		tableModelThongTinPhong = new DefaultTableModel(headersTTP,0);
		scrollPaneThongTinPhong = new JScrollPane();
		scrollPaneThongTinPhong.setViewportView(tableThongTinPhong = new JTable(tableModelThongTinPhong));
		tableThongTinPhong.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPaneThongTinPhong.setBounds(10, 37, 1197, 134);
		tableThongTinPhong.setRowHeight(25);
		tableThongTinPhong.setAutoCreateRowSorter(true);
		tableThongTinPhong.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		panelThongTinPhong.add(scrollPaneThongTinPhong);
		
		btnChonThongTinPhong = new JButton("Chọn");
		btnChonThongTinPhong.setForeground(new Color(255, 255, 255));
		btnChonThongTinPhong.setBackground(new Color(50, 205, 50));
		btnChonThongTinPhong.setBounds(591, 182, 110, 23);
		panelThongTinPhong.add(btnChonThongTinPhong );
		
		txtTenPhongHid = new JTextField();
		txtTenPhongHid.setEditable(false);
		txtTenPhongHid.setColumns(10);
		txtTenPhongHid.setBackground(new Color(255, 255, 255));
		txtTenPhongHid.setBounds(20, 183, 44, 20);
		txtTenPhongHid.setVisible(false);
		panelThongTinPhong.add(txtTenPhongHid);
		
		btnLamMoi = new JButton("Làm mới bảng");
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setBackground(new Color(136, 134, 55));
		btnLamMoi.setBounds(442, 182, 126, 23);
		panelThongTinPhong.add(btnLamMoi);
		
		txtMaPhongHid = new JTextField();
		txtMaPhongHid.setToolTipText("");
		txtMaPhongHid.setHorizontalAlignment(SwingConstants.LEFT);
		txtMaPhongHid.setColumns(10);
		txtMaPhongHid.setBackground(new Color(255, 255, 255));
		txtMaPhongHid.setBounds(74, 182, 44, 20);
		txtMaPhongHid.setVisible(false);
		panelThongTinPhong.add(txtMaPhongHid);
		
		panelDSSP = new JPanel();
		panelDSSP.setBackground(SystemColor.activeCaption);
		panelDSSP.setBorder(new TitledBorder(null, "Danh s\u00E1ch s\u1EA3n ph\u1EA7m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDSSP.setBounds(10, 248, 616, 394);
		panelDichVu.add(panelDSSP);
		panelDSSP.setLayout(null);
		 
		Box dsSP;
		
		panelDSSP.add(dsSP = Box.createHorizontalBox());
		panelDSSP.add(Box.createVerticalStrut(10));
		String [] headersDSSP = "Mã sản phẩm; Tên sản phẩm; Đơn giá".split(";");
		tableModelDSSP = new DefaultTableModel(headersDSSP,0);
		scrollPaneDSSP = new JScrollPane();
		scrollPaneDSSP.setViewportView(tableDSSP = new JTable(tableModelDSSP));
		tableDSSP.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPaneDSSP.setBounds(10, 64, 596, 286);
		tableDSSP.setRowHeight(25);
		tableDSSP.setAutoCreateRowSorter(true);
		tableDSSP.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		panelDSSP.add(scrollPaneDSSP);	
		
		lblNhapSoLuong = new JLabel("Nhập số lượng:");
		lblNhapSoLuong.setBounds(52, 360, 94, 23);
		panelDSSP.add(lblNhapSoLuong);
		
		textField_NhapSL = new JTextField();
		textField_NhapSL.setBounds(156, 361, 100, 20);
		panelDSSP.add(textField_NhapSL);
		textField_NhapSL.setColumns(10);
	
		btnChonSP = new JButton("Chọn");
		btnChonSP.setForeground(new Color(255, 255, 255));
		btnChonSP.setBackground(new Color(50, 205, 50));
		btnChonSP.setBounds(367, 360, 89, 23);
		panelDSSP.add(btnChonSP);
		
		txtNMaSP = new JTextField();
		txtNMaSP.setToolTipText("");
		txtNMaSP.setHorizontalAlignment(SwingConstants.LEFT);
		txtNMaSP.setColumns(10);
		txtNMaSP.setBackground(SystemColor.activeCaptionBorder);
		txtNMaSP.setBounds(319, 11, 89, 20);
		txtNMaSP.setVisible(false);
		panelDSSP.add(txtNMaSP);
		
		txtNTenSP = new JTextField();
		txtNTenSP.setToolTipText("");
		txtNTenSP.setHorizontalAlignment(SwingConstants.LEFT);
		txtNTenSP.setColumns(10);
		txtNTenSP.setBackground(SystemColor.activeCaptionBorder);
		txtNTenSP.setBounds(418, 11, 89, 20);
		txtNTenSP.setVisible(false);
		panelDSSP.add(txtNTenSP);
		
		txtNDonGiaSP = new JTextField();
		txtNDonGiaSP.setToolTipText("");
		txtNDonGiaSP.setHorizontalAlignment(SwingConstants.LEFT);
		txtNDonGiaSP.setColumns(10);
		txtNDonGiaSP.setBackground(SystemColor.activeCaptionBorder);
		txtNDonGiaSP.setBounds(517, 11, 89, 20);
		txtNDonGiaSP.setVisible(false);
		panelDSSP.add(txtNDonGiaSP);
		
		txtCthdsp = new JTextField();
		txtCthdsp.setText("HD");
		txtCthdsp.setBounds(159, 28, 97, 20);
		panelDSSP.add(txtCthdsp);
		txtCthdsp.setToolTipText("Vd: HD001");
		txtCthdsp.setHorizontalAlignment(SwingConstants.LEFT);
		txtCthdsp.setColumns(10);
		txtCthdsp.setBackground(new Color(255, 255, 255));
		
		lblMaChiTietHDSP = new JLabel("Nhập mã HD: ");
		lblMaChiTietHDSP.setBounds(52, 28, 97, 25);
		panelDSSP.add(lblMaChiTietHDSP);
		 
		panelHDSP = new JPanel();
		panelHDSP.setBackground(SystemColor.activeCaption);
		panelHDSP.setBorder(new TitledBorder(null, "Hóa đơn sản phẩm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelHDSP.setBounds(636, 248, 591, 394);
		panelDichVu.add(panelHDSP);
		panelHDSP.setLayout(null);
		 
		lblHoaDonSanPham = new JLabel("Hóa đơn sản phẩm");
		lblHoaDonSanPham.setForeground(new Color(0, 0, 255));
		lblHoaDonSanPham.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblHoaDonSanPham.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoaDonSanPham.setBounds(63, 12, 433, 35);
		panelHDSP.add(lblHoaDonSanPham);
		
		lblTenKhachHang = new JLabel("Tên KH:");
		lblTenKhachHang.setBounds(20, 51, 48, 25);
		panelHDSP.add(lblTenKhachHang);
		
		lblSDTKhachHang = new JLabel("SĐT:");
		lblSDTKhachHang.setBounds(205, 51, 38, 25);
		panelHDSP.add(lblSDTKhachHang);
		 
		Box dsHDSP;
		
		panelHDSP.add(dsHDSP = Box.createHorizontalBox());
		panelHDSP.add(Box.createVerticalStrut(10));
		String [] headersHDSP = "Mã sản phẩm; Tên sản phẩm; Giá tiền; Số lượng; Thành tiền".split(";");
		tableModelHDSP = new DefaultTableModel(headersHDSP,0);
		scrollPaneHDSP = new JScrollPane();
		scrollPaneHDSP.setViewportView(tableHDSP = new JTable(tableModelHDSP));
		tableHDSP.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPaneHDSP.setBounds(10, 87, 571, 263);
		tableHDSP.setRowHeight(25);
		tableHDSP.setAutoCreateRowSorter(true);
		tableHDSP.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		panelHDSP.add(scrollPaneHDSP);
		
		btnLuuHD = new JButton("Lưu hóa đơn");
		btnLuuHD.setForeground(new Color(255, 255, 255));
		btnLuuHD.setBackground(new Color(50, 205, 50));
		btnLuuHD.setBounds(196, 360, 161, 23);
		panelHDSP.add(btnLuuHD);
		
		lblNTenKhachHang = new JLabel("");
		lblNTenKhachHang.setBounds(69, 51, 145, 25);
		panelHDSP.add(lblNTenKhachHang);
		
		lblNSDTKhachHang = new JLabel("");
		lblNSDTKhachHang.setBounds(235, 51, 145, 25);
		panelHDSP.add(lblNSDTKhachHang);
		
		lblTenPhong = new JLabel("Phòng:");
		lblTenPhong.setBounds(385, 51, 58, 25);
		panelHDSP.add(lblTenPhong);
		
		lblNTenPhong = new JLabel("");
		lblNTenPhong.setBounds(432, 51, 131, 25);
		panelHDSP.add(lblNTenPhong);
		
		lblTenNhanVien = new JLabel("");
		lblTenNhanVien.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTenNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		lblTenNhanVien.setBounds(1156, 77, 193, 20);
		contentPane.add(lblTenNhanVien);
		
		lblHinh = new JLabel("");
		lblHinh.setIcon(new ImageIcon(GUI_QLDichVu.class.getResource("/img/kara_page-0001.jpg")));
		lblHinh.setBounds(10, 11, 170, 78);
		contentPane.add(lblHinh);
		
		//btn.Event
		btnManHinhChinh.addActionListener(this);
		btnDatPhong.addActionListener(this);
		btnKhachHang.addActionListener(this);
		btnNhanVien.addActionListener(this);
		btnHoaDon.addActionListener(this);
		btnDichVu.addActionListener(this);
		btnThongKe.addActionListener(this);
		btnQLPhong.addActionListener(this);
		
		btnDangXuat.addActionListener(this);
		btnTimKiem.addActionListener(this);
		btnChonThongTinPhong.addActionListener(this);
		btnChonSP.addActionListener(this);
		btnLuuHD.addActionListener(this);
		btnLamMoi.addActionListener(this);
		
		tableThongTinPhong.addMouseListener(this);
		tableDSSP.addMouseListener(this);
		tableHDSP.addMouseListener(this);
		
		docDuLieuVaoTableDSSP();
		docDuLieuVaoTableThongTinPhong();
		NV_HienTai();
	}
	
	private void docDuLieuVaoTableDSSP() {
		// TODO Auto-generated method stub
		DefaultTableModel dTableModel = (DefaultTableModel) tableDSSP.getModel();
		dTableModel.getDataVector().removeAllElements();
		
		DAO_QLDichVu dv = new DAO_QLDichVu();
		List<Entity_SanPham> list = dv.getAllTableSP();
		
		for (Entity_SanPham sp : list) {		
			String []  rowData = {sp.getMaSP(), sp.getTenSP(), sp.getDonGia()+""};
			tableModelDSSP.addRow(rowData);
		}
		tableDSSP.setModel(tableModelDSSP);
	}
	public void docDuLieuVaoTableThongTinPhong() {
		//Xóa dữ liệu bảng tạm thời
		DefaultTableModel dTableModel = (DefaultTableModel) tableThongTinPhong.getModel();
		dTableModel.getDataVector().removeAllElements();
		
		DAO_QLPhong p = new DAO_QLPhong();
		List<Entity_Phong> list = p.getallPhongDangSuDung();
		
		for (Entity_Phong l : list) {		
			String []  rowData = {l.getMaPhong(), l.getTenPhong(), l.getTenLoai(), l.getDonGia()+"", l.getSucChua()+"", l.getTrangThai()};
			tableModelThongTinPhong.addRow(rowData);
		}
		tableThongTinPhong.setModel(tableModelThongTinPhong);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnManHinhChinh)) {
			QLDichVu_to_ManHinhChinh();
		}
		if (o.equals(btnDatPhong)) {
			QLDichVu_to_DatPhong();
		}
		if (o.equals(btnHoaDon)) {
			QLDichVu_to_HoaDon();
		}
		if (o.equals(btnDichVu)) {
			QLDichVu_to_DichVu();
		}
		if (o.equals(btnNhanVien)) {
			checkChucVu();
		}
		if (o.equals(btnQLPhong)) {
			QLDichVu_to_Phong();
		}
		if (o.equals(btnKhachHang)) {
			QLDichVu_to_KhachHang();
		}
		if (o.equals(btnThongKe)) {
			QLDichVu_to_ThongKe();
		}
		
		if (o.equals(btnDangXuat)) {
			try {
				DangXuat();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		if (o.equals(btnTimKiem)) {
			try {
				TimKiemPhong();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (o.equals(btnChonThongTinPhong)) {
			try {
				ChonPhongAction();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (o.equals(btnChonSP)) {
			ChonSanPham();
		}
		if (o.equals(btnLuuHD)) {
			try {
				LuuHoaDon();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(o.equals(btnLamMoi)) {
			docDuLieuVaoTableThongTinPhong();
		}
	}
	
	private void LuuHoaDon() throws SQLException {
		// TODO Auto-generated method stub
		ds_hdsp = new DAO_QLDichVu();
		String taikhoanNhap = GUI_DangNhap.txtNhapTaiKhoan.getText();
		//HDSP_1 & CTHDSP_1
		String maHD = txtCthdsp.getText().toString();
		Entity_ChiTietHoaDonSanPham maCTHDSP = new Entity_ChiTietHoaDonSanPham(maHD);
		//CTHDSP_2
		String maPhong = txtMaPhongHid.getText().toString().trim();
		Entity_Phong p = new Entity_Phong(maPhong);
		String timPhong =  txtMaPhongHid.getText() == null ? "" : txtMaPhongHid.getText().toString().trim();
		
		Connection con= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=KARAOKE_Nice","sa","sapassword");
		String sql= "select * \r\n"
				+ "from ChiTietPhieuDatPhong p \r\n"
				+ "where p.phong like '%"+ timPhong +"%'";
		
		Statement stmt = con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		
//		System.out.println(maHD);
//		System.out.println(maPhong);
		
		while(rs.next()) {
			String maCTHDDP = rs.getString(1).toString();

			String sql1 = "select * \r\n"
					+ " from PhieuDatPhong pdp \r\n"
					+ " where pdp.chiTietPhieuDatPhong like '%" + maCTHDDP + "%' \r\n";
			rs = stmt.executeQuery(sql1);
			
//			System.out.println(maCTHDDP);

			if(rs.next()) {
				String maKH = rs.getString(2).toString();

				//CTHDSP_3
				Entity_KhachHang kh = new Entity_KhachHang(maKH);
				Date today = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm");
				//CTHDSP_3
				String ngaylap = sdf.format(today);
				
				Entity_ChiTietHoaDonSanPham cthdsp = new Entity_ChiTietHoaDonSanPham(maHD,p,kh,ngaylap);
				
//				System.out.println(maKH);
//				System.out.println(cthdsp);
				
				ds_hdsp.themCTHDSP(cthdsp);
				
				String sql3 = " select * \r\n" 
						+ " from TaiKhoan tk, NhanVien nv \r\n"
						+ " where tk.taiKhoan like N'%" + taikhoanNhap + "%' "
						+ " and nv.taiKhoan like N'%" + taikhoanNhap + "%' ";
			rs=stmt.executeQuery(sql3);
			
				while(rs.next()) {
					String maNV = rs.getString(3);
//					System.out.println(maNV);
					Entity_NhanVien nv = new Entity_NhanVien(maNV);
//					System.out.println(nv);
					
					for (int i = 0; i < tableHDSP.getRowCount(); i++) {
						String maSP = tableHDSP.getValueAt(i, 0).toString();
						Entity_SanPham sp = new Entity_SanPham(maSP);
//						System.out.println(maSP);
						int soLuong = Integer.parseInt(tableHDSP.getValueAt(i, 3).toString());
//						System.out.println(soLuong);
						double donGia = Double.parseDouble(tableHDSP.getValueAt(i, 2).toString());
//						System.out.println(donGia);
//						double thanhTien = Double.parseDouble(tableHDSP.getValueAt(i, 4).toString());
						double tongTien = 0;
						
						Entity_HoaDonSanPham hdsp = new Entity_HoaDonSanPham(maCTHDSP, nv, sp, soLuong, donGia, tongTien);
//						System.out.println(hdsp);
						ds_hdsp.themHDSP(hdsp);
					}
					JOptionPane.showMessageDialog(this, "Thêm hóa đơn thành công !!!");
				}
			}
		}
	}
	private void ChonSanPham() {
		// TODO Auto-generated method stub
		int spRow = tableDSSP.getSelectedRow();
		
		String maSP = tableDSSP.getValueAt(spRow, 0).toString();
		String tenSP = tableDSSP.getValueAt(spRow, 1).toString();
		int soLuong  = Integer.parseInt(textField_NhapSL.getText().toString());
		double donGia = Double.parseDouble(tableDSSP.getValueAt(spRow, 2).toString());
		
		double thanhTien = soLuong * donGia;
		Entity_SanPham sp = new Entity_SanPham(maSP, tenSP, soLuong, donGia);
		
		System.out.println(maSP + " \n" + tenSP + " \n" + soLuong + " \n" + donGia + " \n" + thanhTien);
		if(spRow >= 0) {
			String [] row = {sp.getMaSP(),sp.getTenSP(),sp.getDonGia()+"",sp.getSoLuong()+"",thanhTien+""};
			tableModelHDSP.addRow(row);
			xoaTrang();
		}
	}
	private void ChonPhongAction() throws SQLException {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, txtTenPhongHid.getText().toString() + " đã được chọn.");
		lblNTenPhong.setText(txtTenPhongHid.getText().toString());
		
		String timPhong =  txtMaPhongHid.getText() == null ? "" : txtMaPhongHid.getText().toString().trim();
		
		Connection con= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=KARAOKE_Nice","sa","sapassword");
		String sql= "select * \r\n"
				+ "from ChiTietPhieuDatPhong p \r\n"
				+ "where p.phong like '%"+ timPhong +"%'";
		
		Statement stmt = con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		
//		System.out.println(timPhong);

		while(rs.next()) {
			String maCTHDDP = rs.getString(1).toString();

			String sql1 = "select * \r\n"
					+ " from PhieuDatPhong pdp \r\n"
					+ " where pdp.chiTietPhieuDatPhong like '%" + maCTHDDP + "%' \r\n";
			Statement stmt1 = con.createStatement();
			ResultSet rs1 = stmt1.executeQuery(sql1);
		
//			System.out.println(maCTHDDP);
			if(rs1.next()) {
				String maKH = rs1.getString(2).toString();
				
				String sql2 = "select * \r\n"
						+ " from KhachHang kh \r\n"
						+ " where kh.maKH like '%" + maKH + "%' \r\n";
				
				Statement stmt2 = con.createStatement();
				ResultSet rs2 = stmt1.executeQuery(sql2);
//				System.out.println(maKH);
				while(rs2.next()) {
					lblNTenKhachHang.setText(rs2.getString(2).toString());
					lblNSDTKhachHang.setText(rs2.getString(3).toString());
//					System.out.println("TenKH: "+ rs2.getString(2).toString() + "\n SDT: " + rs2.getString(3).toString());
				}
			}
		}
	}
	private void TimKiemPhong() throws SQLException {
		// TODO Auto-generated method stub
		String PhongHid = txtTenPhongHid.getText() == null ? "" : txtTenPhongHid.getText().toString().trim();
		String Phong = txtNhpTnPhng.getText() == null ? "" : txtNhpTnPhng.getText().toString().trim();
		
		Connection con= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=KARAOKE_Nice","sa","sapassword");
		String sql= "select * \r\n"
				+ "from Phong p \r\n"
				+ "where p.tenPhong like '%"+ PhongHid +"%'"
				+ " and p.tenPhong like '%"+ Phong +"%'";
		
		Statement stmt = con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		tableModelThongTinPhong.setRowCount(0);
		
		if(rs.isBeforeFirst() == false) {
			JOptionPane.showMessageDialog(this, "Không tìm thấy");
			return;
		}
		while(rs.next()) {
			String[] rowData = {
					rs.getString(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5),
					rs.getString(6)
			};
			
			tableModelThongTinPhong.addRow(rowData);
		}
		tableThongTinPhong.setModel(tableModelThongTinPhong);
		xoaTrangNhapTimKiemPhong();
	}
	private void xoaTrang() {
		txtNMaSP.setText("");
		txtNTenSP.setText("");
		txtNDonGiaSP.setText("");
		textField_NhapSL.setText("");
	}
	private void xoaTrangNhapTimKiemPhong() {
		// TODO Auto-generated method stub
		txtNhpTnPhng.setText("Phòng ");
	}
	private void DangXuat() throws IOException {
		ConnectDB.getInstance().disconnect();
		this.setVisible(false);
		GUI_DangNhap dangNhap = new GUI_DangNhap();
		dangNhap.setVisible(true);
		dangNhap.setLocationRelativeTo(null);
	}
	
	private void NV_HienTai() {
		String taikhoanNhap = GUI_DangNhap.txtNhapTaiKhoan.getText();
		
		if(GUI_DangNhap.txtNhapTaiKhoan.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập tài khoản!");
		} else {
			try {
				Connection con= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=KARAOKE_Nice","sa","sapassword");
				String sql = " select * \r\n" 
							+ " from TaiKhoan tk, NhanVien nv \r\n"
							+ " where tk.taiKhoan like N'%" + taikhoanNhap + "%' "
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
						QLDichVu_to_NhanVien();
					}
				} else {
					JOptionPane.showMessageDialog(this, "Blank");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	private void QLDichVu_to_HoaDon() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_HoaDon hoadon = new GUI_HoaDon();
		hoadon.setVisible(true);
		hoadon.setLocationRelativeTo(null);
	}
	private void QLDichVu_to_ManHinhChinh() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_ManHinhChinh manhinhchinh = new GUI_ManHinhChinh();
		manhinhchinh.setVisible(true);
		manhinhchinh.setLocationRelativeTo(null);

	}
	private void QLDichVu_to_ThongKe() {
		// TODO Auto-generated method stub
		
	}
	private void QLDichVu_to_KhachHang() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_QLKhachHang khachhang = new GUI_QLKhachHang();
		khachhang.setLocationRelativeTo(null);
		khachhang.setVisible(true);
		
	}
	private void QLDichVu_to_Phong() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_QLPhong phong = new GUI_QLPhong();
		phong.setVisible(true);
		phong.setLocationRelativeTo(null);

	}
	private void QLDichVu_to_NhanVien() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_QLNhanVien nhanvien = new GUI_QLNhanVien();
		nhanvien.setVisible(true);
		nhanvien.setLocationRelativeTo(null);
	}
	private void QLDichVu_to_DichVu() {
		// TODO Auto-generated method stub
		
	}
	private void QLDichVu_to_DatPhong() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_ThuePhong qldatphong = new GUI_ThuePhong();
		qldatphong.setVisible(true);
		qldatphong.setLocationRelativeTo(null);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o =e.getSource();
		if(o.equals(tableThongTinPhong)) {
			int row = tableThongTinPhong.getSelectedRow();
			txtMaPhongHid.setText(tableModelThongTinPhong.getValueAt(row, 0).toString());
			txtTenPhongHid.setText(tableModelThongTinPhong.getValueAt(row, 1).toString());
			txtNhpTnPhng.setText(tableModelThongTinPhong.getValueAt(row, 1).toString());
		}
		if(o.equals(tableDSSP)) {
			int row1 = tableDSSP.getSelectedRow();
			
			txtNMaSP.setText(tableModelDSSP.getValueAt(row1, 0).toString());
			txtNTenSP.setText(tableModelDSSP.getValueAt(row1, 1).toString());
			txtNDonGiaSP.setText(tableModelDSSP.getValueAt(row1, 2).toString());
		}
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
