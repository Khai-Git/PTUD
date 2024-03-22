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
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


import ConnectDB.ConnectDB;
import DAO.DAO_HoaDonThuePhong;
import DAO.DAO_QLPhong;
import Entity.Entity_HoaDonDatPhong;
import Entity.Entity_Phong;
import other.ExportPDF;

import javax.swing.JScrollPane;
import java.awt.TextField;

public class GUI_HoaDonThuePhong extends JFrame implements ActionListener,MouseListener {

	private JPanel contentPane;
	private JTextField txtNhpTnPhng;
	private JTable table_1;
	private JTable table;
	private JButton btnManHinhChinh,btnDatPhong,btnHoaDon,btnDichVu,btnNhanVien,btnQLyPhong,btnKhachHang,btnThongKe,btnTroVe,btnTimKiem,btnSuaPhieu,btnHuy,btnXuat, btnLamMoi;
	private DefaultTableModel tableModel;
	private JTable table_dsthue, table_hoadonphong;
	private DefaultTableModel tableModel_dsthue, tableModel_dshd;
	private DAO_HoaDonThuePhong dao_hdthuephong;
	private JTable table_CTHD;
	private JPanel panel_DSThuePhong;
	private JPanel panelHoaDonTP;
	private JScrollPane scrollPane;
	private JPanel panel_CTHoaDon;
	private JLabel lblSDT;
	private JLabel lblTenKH;
	private JTable table_HDTP;
	private JButton btnIcon;
	private Entity_HoaDonDatPhong hddp;
	private JTextField txtTest;
	private DAO_QLPhong dao_phong;
	private JTextField txtTest1;
	private JLabel lblNtenKH, lblNsdt, lblTenNhanVien;
	private JButton btnDangXuat;
	private JTextField txtTest2;
	private String maPhongcu;
	private ExportPDF exportPDF;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_HoaDonThuePhong frame = new GUI_HoaDonThuePhong();
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
	public GUI_HoaDonThuePhong() {
		setTitle("Quản lý KARAOKE_NICE");
		
		ConnectDB.getInstance().connect();
		dao_hdthuephong = new DAO_HoaDonThuePhong();
		dao_phong = new DAO_QLPhong();
		hddp = new Entity_HoaDonDatPhong();
		exportPDF = new ExportPDF();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnManHinhChinh = new JButton("Màn hình chính");
		btnManHinhChinh.setIcon(new ImageIcon(GUI_HoaDonThuePhong.class.getResource("/img/home-icon.png")));
		btnManHinhChinh.setHorizontalAlignment(SwingConstants.LEFT);
		btnManHinhChinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnManHinhChinh.setBounds(0, 97, 225, 78);
		contentPane.add(btnManHinhChinh);
		
		 btnDatPhong = new JButton(" Đặt phòng");
		btnDatPhong.setIcon(new ImageIcon(GUI_HoaDonThuePhong.class.getResource("/img/Book_room.jpg")));
		btnDatPhong.setHorizontalAlignment(SwingConstants.LEFT);
		btnDatPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDatPhong.setBounds(0, 173, 225, 78);
		contentPane.add(btnDatPhong);

		 btnHoaDon = new JButton(" Hóa đơn");
		 btnHoaDon.setBackground(Color.YELLOW);
		btnHoaDon.setIcon(new ImageIcon(GUI_HoaDonThuePhong.class.getResource("/img/bill_icon1.png")));
		btnHoaDon.setHorizontalAlignment(SwingConstants.LEFT);
		btnHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHoaDon.setBounds(0, 245, 225, 78);
		contentPane.add(btnHoaDon);
		
		 btnDichVu = new JButton(" Dịch vụ");
		btnDichVu.setIcon(new ImageIcon(GUI_HoaDonThuePhong.class.getResource("/img/menu2.png")));
		btnDichVu.setHorizontalAlignment(SwingConstants.LEFT);
		btnDichVu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDichVu.setBounds(0, 322, 225, 78);
		contentPane.add(btnDichVu);
		
		 btnNhanVien = new JButton(" Nhân viên");
		btnNhanVien.setIcon(new ImageIcon(GUI_HoaDonThuePhong.class.getResource("/img/black-man-icon.png")));
		btnNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNhanVien.setBounds(0, 397, 225, 78);
		contentPane.add(btnNhanVien);
		
		 btnQLyPhong = new JButton(" Quản lí phòng");
		btnQLyPhong.setIcon(new ImageIcon(GUI_HoaDonThuePhong.class.getResource("/img/Science-Plus-Math-icon.png")));
		btnQLyPhong.setHorizontalAlignment(SwingConstants.LEFT);
		btnQLyPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnQLyPhong.setBounds(0, 473, 225, 78);
		contentPane.add(btnQLyPhong);
		
		 btnKhachHang = new JButton("  Khách hàng");
		btnKhachHang.setIcon(new ImageIcon(GUI_HoaDonThuePhong.class.getResource("/img/users-icon.png")));
		btnKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		btnKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnKhachHang.setBounds(0, 549, 225, 78);
		contentPane.add(btnKhachHang);
		
		 btnThongKe = new JButton("Thống kê");
		btnThongKe.setIcon(new ImageIcon(GUI_HoaDonThuePhong.class.getResource("/img/Dollar-Sign-icon.png")));
		btnThongKe.setHorizontalAlignment(SwingConstants.LEFT);
		btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThongKe.setBounds(0, 625, 225, 78);
		contentPane.add(btnThongKe);

		JLabel lblTitle = new JLabel("Phần mềm quản lí KARAOKE");
		lblTitle.setForeground(new Color(0, 0, 0));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblTitle.setBackground(SystemColor.activeCaption);
		lblTitle.setBounds(0, 11, 1474, 86);
		contentPane.add(lblTitle);
		
		JLabel lblNhanVien = new JLabel("Nhân viên : ");
		lblNhanVien.setBounds(1135, 74, 80, 23);
		contentPane.add(lblNhanVien);
		
		 btnDangXuat = new JButton("Đăng xuất");
		 btnDangXuat.setBackground(new Color(255, 155, 157));
		btnDangXuat.setBounds(1354, 74, 120, 23);
		contentPane.add(btnDangXuat);
		
		 panelHoaDonTP = new JPanel();
		panelHoaDonTP.setBackground(SystemColor.activeCaption);
		panelHoaDonTP.setBorder(new TitledBorder(null, "Hóa đơn thuê phòng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelHoaDonTP.setToolTipText("");
		panelHoaDonTP.setBounds(237, 97, 1237, 606);
		contentPane.add(panelHoaDonTP);
		panelHoaDonTP.setLayout(null);
		
		btnTroVe = new JButton("Trở về");
		btnTroVe.setHorizontalAlignment(SwingConstants.LEFT);
		btnTroVe.setIcon(new ImageIcon(GUI_HoaDonThuePhong.class.getResource("/img/back-icon1.png")));
		btnTroVe.setBackground(Color.ORANGE);
		btnTroVe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTroVe.setBounds(10, 21, 96, 32);
		panelHoaDonTP.add(btnTroVe);
		
		txtNhpTnPhng = new JTextField();
		txtNhpTnPhng.setText("Phòng ");
		txtNhpTnPhng.setToolTipText("Nhập tên phòng");
		txtNhpTnPhng.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNhpTnPhng.setForeground(Color.LIGHT_GRAY);
		txtNhpTnPhng.setBounds(115, 86, 237, 29);
		panelHoaDonTP.add(txtNhpTnPhng);
		txtNhpTnPhng.setColumns(10);
		
		 btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBackground(Color.YELLOW);
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTimKiem.setBounds(380, 86, 117, 32);
		panelHoaDonTP.add(btnTimKiem);
		
		 panel_DSThuePhong = new JPanel();
		panel_DSThuePhong.setBackground(SystemColor.activeCaption);
		panel_DSThuePhong.setBorder(new TitledBorder(null, "Danh s\u00E1ch thu\u00EA ph\u00F2ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_DSThuePhong.setBounds(10, 129, 574, 466);
		panelHoaDonTP.add(panel_DSThuePhong);
		panel_DSThuePhong.setLayout(null);
		
		 scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 31, 535, 365);
		panel_DSThuePhong.add(scrollPane);
		String header [] = {"Mã phiếu thuê", "Tên khách hàng", "SĐT", "Mã phòng", "Tên phòng", "Ngày lập"};
		tableModel = new DefaultTableModel(header, 0);
		JScrollPane scroll = new JScrollPane(table_dsthue = new JTable(tableModel));
		table_dsthue.setRowHeight(35);
		scrollPane.setViewportView(table_dsthue);
			
		table_dsthue.getColumnModel().getColumn(0).setPreferredWidth(83);
		table_dsthue.getColumnModel().getColumn(3).setPreferredWidth(68);
		
		 btnSuaPhieu = new JButton("Sửa phiếu thuê");
		btnSuaPhieu.setIcon(new ImageIcon(GUI_HoaDonThuePhong.class.getResource("/img/cog-edit-icon.png")));
		btnSuaPhieu.setBackground(new Color(255, 165, 0));
		btnSuaPhieu.setBounds(310, 412, 154, 30);
		panel_DSThuePhong.add(btnSuaPhieu);
		
		 btnHuy = new JButton("Hủy\r\n");
		btnHuy.setIcon(new ImageIcon(GUI_HoaDonThuePhong.class.getResource("/img/x-icon.png")));
		btnHuy.setBackground(Color.RED);
		btnHuy.setBounds(474, 412, 86, 30);
		panel_DSThuePhong.add(btnHuy);
		
		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBackground(new Color(128, 255, 128));
		btnLamMoi.setBounds(146, 412, 154, 30);
		panel_DSThuePhong.add(btnLamMoi);
		
		 panel_CTHoaDon = new JPanel();
		panel_CTHoaDon.setBackground(SystemColor.activeCaption);
		panel_CTHoaDon.setBorder(new TitledBorder(null, "Chi ti\u1EBFt h\u00F3a \u0111\u01A1n ph\u00F2ng h\u00E1t", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_CTHoaDon.setBounds(640, 129, 587, 466);
		panel_CTHoaDon.setLayout(null);
		panelHoaDonTP.add(panel_CTHoaDon);
		
		Box dscthd;
		panel_CTHoaDon.add(dscthd = Box.createHorizontalBox());
		panel_CTHoaDon.add(Box.createVerticalStrut(10));
		String [] headers = "Mã hóa đơn; Tên phòng; Loại phòng; Giờ vào; Giờ ra; Tổng tiền; Ngày lập".split(";");
		tableModel_dshd = new DefaultTableModel(headers,0);
		JScrollPane scrollpane_1 = new JScrollPane();
		scrollpane_1.setViewportView(table_CTHD = new JTable(tableModel_dshd));
		table_CTHD.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollpane_1.setBounds(10, 99, 570, 308);
		table_CTHD.setRowHeight(25);
		table_CTHD.setAutoCreateRowSorter(true);
		table_CTHD.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		panel_CTHoaDon.add(scrollpane_1);
		
		JLabel lblTitle_2 = new JLabel("Hóa đơn thuê phòng");
		lblTitle_2.setForeground(new Color(0, 0, 0));
		lblTitle_2.setBackground(SystemColor.activeCaption);
		lblTitle_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitle_2.setBounds(85, 21, 443, 31);
		panel_CTHoaDon.add(lblTitle_2);

		 lblTenKH = new JLabel("Tên KH : ");
		lblTenKH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenKH.setBounds(55, 66, 54, 23);
		panel_CTHoaDon.add(lblTenKH);
		
		 lblSDT = new JLabel("SĐT:\r\n");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSDT.setBounds(358, 66, 35, 23);
		panel_CTHoaDon.add(lblSDT);

		 btnXuat = new JButton("Xuất hóa đơn\r\n");
		btnXuat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXuat.setIcon(new ImageIcon(GUI_HoaDonThuePhong.class.getResource("/img/Invoice-icon.png")));
		btnXuat.setBackground(new Color(0, 255, 0));
		btnXuat.setBounds(214, 417, 164, 30);
		panel_CTHoaDon.add(btnXuat);
		
		 lblNtenKH = new JLabel();
		 lblNtenKH.setText("");
		lblNtenKH.setBounds(122, 66, 178, 23);
		panel_CTHoaDon.add(lblNtenKH);
		
		 lblNsdt = new JLabel();
		 lblNsdt.setText("");
		lblNsdt.setBounds(418, 66, 148, 23);
		panel_CTHoaDon.add(lblNsdt);
		
		 btnIcon = new JButton("Icon");
		btnIcon.setIcon(new ImageIcon(GUI_HoaDonThuePhong.class.getResource("/img/Next-2-icon.png")));
		btnIcon.setBounds(591, 255, 51, 109);
		panelHoaDonTP.add(btnIcon);
		
		 lblTenNhanVien = new JLabel("");
		lblTenNhanVien.setBounds(1203, 72, 145, 25);
		contentPane.add(lblTenNhanVien);
		
		txtTest = new JTextField("");
		txtTest = new JTextField();
		txtTest.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTest.setText("");
		txtTest.setBounds(200, 5,90,20);
		panelHoaDonTP.add(txtTest);
		txtTest.setColumns(10);
		txtTest.setVisible(false);
		
		txtTest1 = new JTextField("");
		txtTest1 = new JTextField();
		txtTest1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTest1.setText("");
		txtTest1.setBounds(300, 5,90,20);
		panelHoaDonTP.add(txtTest1);
		txtTest1.setColumns(10);
		txtTest1.setVisible(false);
		
		txtTest2 = new JTextField("");
		txtTest2 = new JTextField();
		txtTest2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTest2.setText("");
		txtTest2.setBounds(400, 5,90,20);
		panelHoaDonTP.add(txtTest2);
		txtTest2.setColumns(10);
		txtTest2.setVisible(false);
		
		//btn.Event
		btnManHinhChinh.addActionListener(this);
		btnTroVe.addActionListener(this);
		btnDangXuat.addActionListener(this);
		btnIcon.addActionListener(this);
		btnDatPhong.addActionListener(this);
		btnDichVu.addActionListener(this);
		btnHoaDon.addActionListener(this);
		btnHuy.addActionListener(this);
		btnKhachHang.addActionListener(this);
		btnNhanVien.addActionListener(this);
		btnQLyPhong.addActionListener(this);
		btnSuaPhieu.addActionListener(this);
		btnThongKe.addActionListener(this);
		btnTimKiem.addActionListener(this);
		btnXuat.addActionListener(this);
		btnLamMoi.addActionListener(this);
		table_dsthue.addMouseListener(this);
		
		nv_HienTai();
		docDuLieuVaoTable1();
		
	}
	
	private void docDuLieuVaoTable2() {
		// TODO Auto-generated method stub
		DefaultTableModel dTableModel = (DefaultTableModel) table_CTHD.getModel();
		dTableModel.getDataVector().removeAllElements();
		int row = table_dsthue.getSelectedRow();
		String mahd = txtTest.getText().toString();
		DAO_HoaDonThuePhong cthdtp = new DAO_HoaDonThuePhong();
		List<Entity.Entity_HoaDonDatPhong> list = cthdtp.getallChiTietThuePhong(mahd);
		
		for (Entity.Entity_HoaDonDatPhong l : list) {	
			String []  rowData = {l.getMaHD(),l.getChiTietHoaDon().getPhong().getTenPhong(),l.getChiTietHoaDon().getPhong().getTenLoai(),l.getGioVao()+"",l.getGioRa()+"",l.getTongTien()+"",l.getNgayDatPhong()};

			tableModel_dshd.addRow(rowData);
			
			String tenKH = l.getKhachHang().getTenKH().toString();
			String sdt = l.getKhachHang().getSoDienThoai();
			lblNsdt.setText(sdt);
			lblNtenKH.setText(tenKH);
		}
		table_CTHD.setModel(tableModel_dshd);

	}

	private void clearAction() {
		// TODO Auto-generated method stub
		txtNhpTnPhng.setText("");
	}

	public void docDuLieuVaoTable1() {
		DefaultTableModel dTableModel = (DefaultTableModel) table_dsthue.getModel();
		dTableModel.getDataVector().removeAllElements();
		
		DAO_HoaDonThuePhong hdtp = new DAO_HoaDonThuePhong();
		List<Entity.Entity_HoaDonDatPhong> list = hdtp.getallThuePhong();
		
		for (Entity.Entity_HoaDonDatPhong l : list) {	
			String []  rowData = {l.getMaHD(), l.getKhachHang().getTenKH(), l.getKhachHang().getSoDienThoai(), l.getChiTietHoaDon().getPhong().getMaPhong(), l.getChiTietHoaDon().getPhong().getTenPhong(),l.getNgayDatPhong()};
			tableModel.addRow(rowData);
		}
		table_dsthue.setModel(tableModel);
	}
	
	public void searchThuePhong() {
		DefaultTableModel dTableModel = (DefaultTableModel) table_dsthue.getModel();
		dTableModel.getDataVector().removeAllElements();
		
		String maPhong = txtNhpTnPhng.getText().toString();
		DAO_HoaDonThuePhong cthdtp = new DAO_HoaDonThuePhong();
		List<Entity.Entity_HoaDonDatPhong> list = cthdtp.getPhieuThueTheoTenPhong(maPhong);
		
		for (Entity.Entity_HoaDonDatPhong l : list) {	
			String []  rowData = {l.getMaHD(), l.getKhachHang().getTenKH(), l.getKhachHang().getSoDienThoai(), l.getChiTietHoaDon().getPhong().getMaPhong(), l.getChiTietHoaDon().getPhong().getTenPhong(),l.getNgayDatPhong()};
			tableModel_dshd.setRowCount(0);
			tableModel.addRow(rowData);
		}
		table_dsthue.setModel(tableModel);
		clearAction();
	}
	
	public void delete() {
		int row = table_dsthue.getSelectedRow();
		System.out.println(row);
		String mahd = txtTest.getText().toString();
		if(row >= 0) {
			String maHD = (String) table_dsthue.getValueAt(row, 0);
			if(dao_hdthuephong.delete(maHD)) {
				tableModel.removeRow(row);
				tableModel.fireTableDataChanged();
				table_dsthue.repaint();
				clearAction();
			}
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnIcon)) {
			int hoiNhac = JOptionPane.showConfirmDialog(this,"Kết thúc thuê phòng và cập nhật tình trạng phòng?","Thông báo",JOptionPane.YES_NO_OPTION);
			try {
				if(hoiNhac==JOptionPane.YES_OPTION) {
					int row = table_dsthue.getSelectedRow();
					String mahd = txtTest.getText().toString();
					String maPhong = txtTest1.getText().toString();
					dao_hdthuephong.checkGiora(mahd);
					dao_hdthuephong.getallChiTietThuePhong(mahd);
					dao_hdthuephong.updateTongTien(mahd);
					dao_phong.updateTinhTrangPhongTrong(maPhong);
					docDuLieuVaoTable2();		
				}
			}catch (Exception e1) {
				// TODO: handle exception
					JOptionPane.showMessageDialog(this,"Đã xảy ra lỗi!");
			}
		}
		
		if(o.equals(btnSuaPhieu)) {
			try {	
					int row = table_dsthue.getSelectedRow();
					String mahd = txtTest.getText().toString();
					String maCTHD = txtTest2.getText().toString();
					String maPhong = txtTest1.getText().toString();
					
					OpenTableDSPhong();
					
					dao_hdthuephong.getallChiTietThuePhong(mahd);
					dao_phong.updateTinhTrangPhongTrong(maPhong);	
			}catch (Exception e1) {
				// TODO: handle exception
					JOptionPane.showMessageDialog(this,"Đã xảy ra lỗi!");
			}
		}
		
		if(o.equals(btnHuy)) {
			int hoiNhac1 = JOptionPane.showConfirmDialog(this,"Có chắc muốn hủy phiếu thuê phòng không?","Thông báo",JOptionPane.YES_NO_OPTION);
			try {
				if(hoiNhac1==JOptionPane.YES_OPTION) {
					String maPhong = txtTest1.getText().toString();
					delete();
					
					dao_phong.updateTinhTrangPhongTrong(maPhong);
					JOptionPane.showMessageDialog(this,"Hủy hóa đơn thành công");
				}
			}catch (Exception e1) {
				// TODO: handle exception
					JOptionPane.showMessageDialog(this,"Đã xảy ra lỗi!");
			}
		}
		
		if(o.equals(btnXuat)) {
			int hoinhac2 = JOptionPane.showConfirmDialog(this, "Có chắc muốn xuất hóa đơn không?","Thông báo",JOptionPane.YES_NO_OPTION);
			try {
				if(hoinhac2==JOptionPane.YES_OPTION) {
					String maPhong = txtTest1.getText().toString();
					String mahd = txtTest.getText().toString();
					exportPDF.getValueToPrintPDF(maPhong);
					
					tableModel_dshd.getDataVector().removeAllElements();
					tableModel_dshd.fireTableDataChanged();
					delete();
					
				}
			} catch(Exception e2) {
				JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi");
			}
		}
		
		if(o.equals(btnTimKiem)) {
			searchThuePhong();
		}
		if (o.equals(btnManHinhChinh)) {
			HDTP_to_ManHinhChinh();
		}
		if (o.equals(btnDatPhong)) {
			HDTP_to_DatPhong();
		}
		if (o.equals(btnDichVu)) {
			HDTP_to_DichVu();
		}
		if (o.equals(btnNhanVien)) {
			checkChucVu();
		}
		if (o.equals(btnQLyPhong)) {
			HDTP_to_Phong();
		}
		if (o.equals(btnKhachHang)) {
			HDTP_to_KhachHang();
		}
		if (o.equals(btnThongKe)) {
			HDTP_to_ThongKe();
		}
		if (o.equals(btnTroVe)) {
			HDDP_back();
		}
		if(o.equals(btnHoaDon)) {
			HDTP_to_HoaDon();
		}
		if(o.equals(btnLamMoi)) {
			Refresh_Table();
		}
		if(o.equals(btnDangXuat)) {
			try {
				DangXuat();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
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
						HDTP_to_NhanVien();
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
	private void Refresh_Table() {
		// TODO Auto-generated method stub
		docDuLieuVaoTable1();
		txtNhpTnPhng.setText("Phòng ");
	}

	private void OpenTableDSPhong() {
		TableDSPhong dsphong = new TableDSPhong();
		dsphong.setVisible(true);
		dsphong.setLocationRelativeTo(null);
	}

	private void HDTP_to_HoaDon() {
		// TODO Auto-generated method stub
		GUI_HoaDon hoadon = new GUI_HoaDon();
		this.setVisible(false);
		hoadon.setVisible(true);
		hoadon.setLocationRelativeTo(null);
	}
	private void HDDP_back() {
		// TODO Auto-generated method stub
		GUI_HoaDon hoadon = new GUI_HoaDon();
		hoadon.setVisible(true);
		this.setVisible(false);
		hoadon.setLocationRelativeTo(null);
	}

	private void HDTP_to_ThongKe() {
		// TODO Auto-generated method stub

	}

	private void HDTP_to_KhachHang() {
		// TODO Auto-generated method stub
		GUI_QLKhachHang khachhanh = new GUI_QLKhachHang();
		this.setVisible(false);
		khachhanh.setVisible(true);
		khachhanh.setLocationRelativeTo(null);
	}

	private void HDTP_to_Phong() {
		// TODO Auto-generated method stub
		GUI_QLPhong phong = new GUI_QLPhong();
		this.setVisible(false);
		phong.setVisible(true);
		phong.setLocationRelativeTo(null);
	}

	private void HDTP_to_NhanVien() {
		// TODO Auto-generated method stub
		GUI_QLNhanVien nhanvien = new GUI_QLNhanVien();
		this.setVisible(false);
		nhanvien.setVisible(true);
		nhanvien.setLocationRelativeTo(null);
	}

	private void HDTP_to_DichVu() {
		// TODO Auto-generated method stub
		GUI_QLDichVu dichvu = new GUI_QLDichVu();
		this.setVisible(false);
		dichvu.setVisible(true);
		dichvu.setLocationRelativeTo(null);
		
	}

	private void HDTP_to_DatPhong() {
		// TODO Auto-generated method stub
		GUI_ThuePhong qldatphong = new GUI_ThuePhong();
		this.setVisible(false);
		qldatphong.setVisible(true);
		qldatphong.setLocationRelativeTo(null);
	}

	private void HDTP_to_ManHinhChinh() {
		// TODO Auto-generated method stub
		GUI_ManHinhChinh manhinhchinh = new GUI_ManHinhChinh();
		this.setVisible(false);
		manhinhchinh.setVisible(true);
		manhinhchinh.setLocationRelativeTo(null);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table_dsthue.getSelectedRow();
		txtTest.setText(tableModel.getValueAt(row, 0).toString());
		txtTest1.setText(tableModel.getValueAt(row, 3).toString());
		String rs = tableModel.getValueAt(row, 0).toString();
		txtNhpTnPhng.setText(tableModel.getValueAt(row, 4).toString());
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
