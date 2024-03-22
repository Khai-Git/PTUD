package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import ConnectDB.ConnectDB;
import DAO.DAO_DatPhong;
import DAO.DAO_QLPhong;
import Entity.Entity_HoaDonDatPhong;
import Entity.Entity_PhieuDatPhong;
import Entity.Entity_Phong;

import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class GUI_DatPhong extends JFrame implements ActionListener,MouseListener {

	private JPanel contentPane, panel_TimKiem, panel_KhachHang, panel_Thongtinphong, panelDatPhong;
	private JTextField textSDT;
	private JTextField textCMND;
	private JTable table;
	private DefaultTableModel tableModel;
	private JButton btnManHinhChinh, btnDatPhong, btnHoaDon, btnDichVu, btnNhanVien, btnQLPhong, btnKhachHang, btnThongKe;
	private JButton btnTroVe, btnDangXuat, btnTimKiem, btnThemPhieu;
	private JLabel lblTitle, lblNhanVien, lblSDT, lblMaKH, lblTenKH, lblSDT_KH, lblCMND_KH, lblDiaChi_KH, lblNsdtKH, lblNmaKH, lblNtenKH;
	private JLabel lblNCMND_KH, lblNdiachi, lblCMND, lblTenNhanVien, lblNgayThue, lblGioThue;
	private JScrollPane scrollPane;
	private JComboBox comboBoxGio, comboBoxPhut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_DatPhong frame = new GUI_DatPhong();
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
	public GUI_DatPhong() {
		setTitle("Quản lý KARAOKE_NICE");
		ConnectDB.getInstance().connect();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitle = new JLabel("PHẦN MỀM QUẢN LÝ KARAOKE");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblTitle.setBounds(-7, 0, 1483, 86);
		contentPane.add(lblTitle);
		
		btnHoaDon = new JButton(" Hóa đơn");
		btnHoaDon.setHorizontalAlignment(SwingConstants.LEFT);
		btnHoaDon.setIcon(new ImageIcon(GUI_DatPhong.class.getResource("/img/bill_icon1.png")));
		btnHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHoaDon.setBounds(0, 244, 221, 78);
		contentPane.add(btnHoaDon);
		
		btnDichVu = new JButton(" Dịch vụ");
		btnDichVu.setHorizontalAlignment(SwingConstants.LEFT);
		btnDichVu.setIcon(new ImageIcon(GUI_DatPhong.class.getResource("/img/menu2.png")));
		btnDichVu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDichVu.setBounds(0, 321, 221, 78);
		contentPane.add(btnDichVu);
		
		btnQLPhong = new JButton(" Quản lý phòng");
		btnQLPhong.setHorizontalAlignment(SwingConstants.LEFT);
		btnQLPhong.setIcon(new ImageIcon(GUI_DatPhong.class.getResource("/img/Science-Plus-Math-icon.png")));
		btnQLPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnQLPhong.setBounds(0, 472, 221, 78);
		contentPane.add(btnQLPhong);
		
		btnNhanVien = new JButton(" Nhân viên");
		btnNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhanVien.setIcon(new ImageIcon(GUI_DatPhong.class.getResource("/img/black-man-icon.png")));
		btnNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNhanVien.setBounds(0, 396, 221, 78);
		contentPane.add(btnNhanVien);
		
		btnKhachHang = new JButton("  Khách hàng");
		btnKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		btnKhachHang.setIcon(new ImageIcon(GUI_DatPhong.class.getResource("/img/users-icon.png")));
		btnKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnKhachHang.setBounds(0, 548, 221, 78);
		contentPane.add(btnKhachHang);
		
		btnManHinhChinh = new JButton("M\u00E0n h\u00ECnh ch\u00EDnh");
		btnManHinhChinh.setHorizontalAlignment(SwingConstants.LEFT);
		btnManHinhChinh.setIcon(new ImageIcon(GUI_DatPhong.class.getResource("/img/home-icon.png")));
		btnManHinhChinh.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnManHinhChinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnManHinhChinh.setBounds(0, 96, 221, 78);
		contentPane.add(btnManHinhChinh);
		
		btnThongKe = new JButton("Thống kê số liệu");
		btnThongKe.setHorizontalAlignment(SwingConstants.LEFT);
		btnThongKe.setIcon(new ImageIcon(GUI_DatPhong.class.getResource("/img/Dollar-Sign-icon.png")));
		btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThongKe.setBounds(0, 624, 221, 78);
		contentPane.add(btnThongKe);
		
		btnDatPhong = new JButton("Đặt phòng");
		btnDatPhong.setBackground(Color.YELLOW);
		btnDatPhong.setIcon(new ImageIcon(GUI_DatPhong.class.getResource("/img/Household-Living-Room-icon.png")));
		btnDatPhong.setHorizontalAlignment(SwingConstants.LEFT);
		btnDatPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDatPhong.setBounds(0, 172, 221, 78);
		contentPane.add(btnDatPhong);
		
		lblNhanVien = new JLabel("Nhân viên : ");
		lblNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNhanVien.setBounds(1098, 62, 69, 23);
		contentPane.add(lblNhanVien);
		
		btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setBackground(new Color(255, 155, 157));
		btnDangXuat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDangXuat.setBounds(1356, 63, 120, 23);
		contentPane.add(btnDangXuat);
		
		panelDatPhong = new JPanel();
		panelDatPhong.setBackground(SystemColor.activeCaption);
		panelDatPhong.setBorder(new TitledBorder(null, "\u0110\u1EB7t ph\u00F2ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDatPhong.setBounds(224, 97, 1252, 656);
		contentPane.add(panelDatPhong);
		panelDatPhong.setLayout(null);
		
		panel_TimKiem = new JPanel();
		panel_TimKiem.setBackground(SystemColor.activeCaption);
		panel_TimKiem.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_TimKiem.setBounds(10, 71, 367, 146);
		panelDatPhong.add(panel_TimKiem);
		panel_TimKiem.setLayout(null);
		
		lblSDT = new JLabel("Số điện thoại:");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSDT.setBounds(20, 25, 87, 25);
		panel_TimKiem.add(lblSDT);
		
		lblCMND = new JLabel("CMND:");
		lblCMND.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCMND.setBounds(20, 64, 87, 25);
		panel_TimKiem.add(lblCMND);
		
		textSDT = new JTextField();
		textSDT.setText("0980213712");
		textSDT.setBounds(117, 27, 240, 23);
		panel_TimKiem.add(textSDT);
		textSDT.setColumns(10);
		
		textCMND = new JTextField();
		textCMND.setText("09089287911");
		textCMND.setColumns(10);
		textCMND.setBounds(117, 65, 240, 23);
		panel_TimKiem.add(textCMND);
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnTimKiem.setBackground(new Color(152, 251, 152));
		btnTimKiem.setBounds(222, 98, 135, 38);
		panel_TimKiem.add(btnTimKiem);
		
		panel_KhachHang = new JPanel();
		panel_KhachHang.setBackground(SystemColor.activeCaption);
		panel_KhachHang.setBorder(new TitledBorder(null, "Kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_KhachHang.setBounds(387, 22, 855, 195);
		panelDatPhong.add(panel_KhachHang);
		panel_KhachHang.setLayout(null);
		
		lblMaKH = new JLabel("Mã khách hàng:");
		lblMaKH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaKH.setBounds(52, 38, 97, 27);
		panel_KhachHang.add(lblMaKH);
		
		lblTenKH = new JLabel("Tên khách hàng:");
		lblTenKH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTenKH.setBounds(52, 94, 97, 25);
		panel_KhachHang.add(lblTenKH);
		
		lblSDT_KH = new JLabel("Số điện thoại:");
		lblSDT_KH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSDT_KH.setBounds(52, 143, 97, 25);
		panel_KhachHang.add(lblSDT_KH);
		
		lblCMND_KH = new JLabel("CMND:");
		lblCMND_KH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCMND_KH.setBounds(403, 38, 80, 27);
		panel_KhachHang.add(lblCMND_KH);
		
		lblDiaChi_KH = new JLabel("Địa chỉ:");
		lblDiaChi_KH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDiaChi_KH.setBounds(403, 93, 80, 27);
		panel_KhachHang.add(lblDiaChi_KH);
		
		lblNsdtKH = new JLabel("");
		lblNsdtKH.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNsdtKH.setBounds(159, 141, 180, 27);
		panel_KhachHang.add(lblNsdtKH);
		
		lblNmaKH = new JLabel("");
		lblNmaKH.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNmaKH.setBounds(159, 38, 180, 27);
		panel_KhachHang.add(lblNmaKH);
		
		lblNtenKH = new JLabel("");
		lblNtenKH.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNtenKH.setBounds(156, 92, 180, 27);
		panel_KhachHang.add(lblNtenKH);
		
		lblNCMND_KH = new JLabel("");
		lblNCMND_KH.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNCMND_KH.setBounds(462, 38, 180, 27);
		panel_KhachHang.add(lblNCMND_KH);
		
		lblNdiachi = new JLabel("");
		lblNdiachi.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNdiachi.setBounds(462, 94, 251, 19);
		panel_KhachHang.add(lblNdiachi);
		
		panel_Thongtinphong = new JPanel();
		panel_Thongtinphong.setBackground(SystemColor.activeCaption);
		panel_Thongtinphong.setBorder(new TitledBorder(null, "Th\u00F4ng tin ph\u00F2ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Thongtinphong.setBounds(10, 227, 1232, 419);
		panelDatPhong.add(panel_Thongtinphong);
		panel_Thongtinphong.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 28, 1212, 326);
		panel_Thongtinphong.add(scrollPane);
		
		Box dsP;
		
		panel_Thongtinphong.add(dsP = Box.createHorizontalBox());
		panel_Thongtinphong.add(Box.createVerticalStrut(10));
		String [] headers = "Mã phòng; Tên phòng; Loại phòng; Giá phòng; Tình trạng; Sức chứa".split(";");
		tableModel = new DefaultTableModel(headers,0);
		scrollPane.setViewportView(table = new JTable(tableModel));
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPane.setBounds(10, 27, 1210, 330);
		table.setRowHeight(35);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		panel_Thongtinphong.add(scrollPane);
		
		lblNgayThue = new JLabel("Ngày thuê phòng:");
		lblNgayThue.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNgayThue.setBounds(41, 373, 100, 25);
		panel_Thongtinphong.add(lblNgayThue);
		
		lblGioThue = new JLabel("Giờ thuê:");
		lblGioThue.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGioThue.setBounds(307, 373, 79, 25);
		panel_Thongtinphong.add(lblGioThue);
		
		comboBoxGio = new JComboBox();
		comboBoxGio.setModel(new DefaultComboBoxModel(new String[] {"Giờ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"}));
		comboBoxGio.setBounds(394, 374, 55, 22);
		panel_Thongtinphong.add(comboBoxGio);
		
		comboBoxPhut = new JComboBox();
		comboBoxPhut.setModel(new DefaultComboBoxModel(new String[] {"Phút", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60"}));
		comboBoxPhut.setBounds(472, 374, 55, 22);
		panel_Thongtinphong.add(comboBoxPhut);
		
		btnThemPhieu = new JButton("Thêm vào phiếu đặt phòng");
		btnThemPhieu.setForeground(new Color(255, 255, 255));
		btnThemPhieu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnThemPhieu.setBackground(new Color(0, 128, 0));
		btnThemPhieu.setBounds(895, 361, 272, 49);
		panel_Thongtinphong.add(btnThemPhieu);
		
		JLabel lblGioThue_1 = new JLabel(":");
		lblGioThue_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblGioThue_1.setBounds(456, 371, 29, 25);
		panel_Thongtinphong.add(lblGioThue_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(151, 378, 145, 20);
		panel_Thongtinphong.add(dateChooser);
		
		btnTroVe = new JButton("Trở về");
		btnTroVe.setBackground(new Color(255, 255, 0));
		btnTroVe.setForeground(new Color(0, 0, 0));
		btnTroVe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnTroVe.setIcon(new ImageIcon(GUI_DatPhong.class.getResource("/img/Back-icon.png")));
		btnTroVe.setBounds(20, 22, 115, 39);
		panelDatPhong.add(btnTroVe);
		
		lblTenNhanVien = new JLabel("");
		lblTenNhanVien.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenNhanVien.setBounds(1168, 62, 178, 23);
		contentPane.add(lblTenNhanVien);
		
		JLabel lblHinh = new JLabel("");
		lblHinh.setIcon(new ImageIcon(GUI_DatPhong.class.getResource("/img/kara_page-0001.jpg")));
		lblHinh.setBounds(10, 8, 170, 78);
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
		
		btnTroVe.addActionListener(this);
		btnDangXuat.addActionListener(this);
		btnTimKiem.addActionListener(this);
		btnThemPhieu.addActionListener(this);
		
		table.addMouseListener(this);
		
		DB_To_Table();
		nv_HienTai();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		DB_To_Table();
		
		if (o.equals(btnManHinhChinh)) {
			DatPhong_to_ManHinhChinh();
		}
		if (o.equals(btnDichVu)) {
			DatPhong_to_DichVu();
		}
		if (o.equals(btnNhanVien)) {
			checkChucVu();
		}
		if (o.equals(btnQLPhong)) {
			DatPhong_to_Phong();
		}
		if (o.equals(btnKhachHang)) {
			DatPhong_to_KhachHang();
		}
		if (o.equals(btnThongKe)) {
			DatPhong_to_ThongKe();
		}
		if (o.equals(btnHoaDon)) {
			DatPhong_to_HoaDon();
		}
		if(o.equals(btnDatPhong)) {
			datphong_to_QlDatPhong();
		}
		if(o.equals(btnDangXuat)) {
			try {
				DangXuat();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(o.equals(btnTimKiem)) {
			try {
				TimKiem_Action();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(o.equals(btnThemPhieu)) {
			ThemPhieu_Action();
		}
		if (o.equals(btnTroVe)) {
			back_QLDatPhong();
		}
	}
	
	private void ThemPhieu_Action() {
		// TODO Auto-generated method stub
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
						DatPhong_to_NhanVien();
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
		ConnectDB.getInstance().disconnect();
		this.setVisible(false);
		GUI_DangNhap dangNhap = new GUI_DangNhap();
		dangNhap.setVisible(true);
		dangNhap.setLocationRelativeTo(null);
	}
	
	private void TimKiem_Action() throws SQLException {
		// TODO Auto-generated method stub
		String timKHSDT = textSDT.getText() == null ? "" : textSDT.getText().toString().trim();
		String timKHCMND = textCMND.getText() == null ? "" : textCMND.getText().toString().trim();
		
		Connection con= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=KARAOKE_Nice","sa","sapassword");
		String sql= "select * \r\n"
				+ "from KhachHang kh \r\n"
				+ "where kh.sdt like '%"+ timKHSDT +"%'"
				+ " and kh.cmnd like '%"+ timKHCMND +"%'";
		
		Statement stmt = con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		
		if(rs.isBeforeFirst() == false) {
			JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng trong danh sách");
			return;
		}
		while(rs.next()) {
			lblNmaKH.setText(rs.getString(1));
			lblNtenKH.setText(rs.getString(2));
			lblNsdtKH.setText(rs.getString(3));
			lblNCMND_KH.setText(rs.getString(5));
			lblNdiachi.setText(rs.getString(4));
		}
		xoaTrangAction();
	}
	
	private void xoaTrangAction() {
		// TODO Auto-generated method stub
		textSDT.setText("");
		textCMND.setText("");
	}

	private void DB_To_Table() {
		// TODO Auto-generated method stub
		DefaultTableModel dTableModel = (DefaultTableModel) table.getModel();
		dTableModel.getDataVector().removeAllElements();
		
		DAO_QLPhong dsphong = new DAO_QLPhong();
		List<Entity_Phong> list = dsphong.getallPhongTrong();
		for(Entity_Phong p: list) {
			String [] rowData = {p.getMaPhong(), p.getTenPhong(),p.getTenLoai(),p.getDonGia()+"",p.getTrangThai(),p.getSucChua()+""};
			tableModel.addRow(rowData);
		}
		table.setModel(tableModel);
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
	
	private void DatPhong_to_ManHinhChinh() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_ManHinhChinh manhinhchinh = new GUI_ManHinhChinh();
		manhinhchinh.setVisible(true);
		manhinhchinh.setLocationRelativeTo(null);
	}
	private void DatPhong_to_HoaDon() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_HoaDon hoadon = new GUI_HoaDon();
		hoadon.setVisible(true);
		hoadon.setLocationRelativeTo(null);
	}
	private void DatPhong_to_DichVu() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_QLDichVu dichVu = new GUI_QLDichVu();
		dichVu.setVisible(true);
		dichVu.setLocationRelativeTo(null);
	}
	private void DatPhong_to_NhanVien() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_QLNhanVien nhanvien = new GUI_QLNhanVien();
		nhanvien.setVisible(true);
		nhanvien.setLocationRelativeTo(null);
	}
	private void DatPhong_to_Phong() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_QLPhong phong = new GUI_QLPhong();
		phong.setVisible(true);
		phong.setLocationRelativeTo(null);
	}
	private void DatPhong_to_KhachHang() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_QLKhachHang khachhang = new GUI_QLKhachHang();
		khachhang.setVisible(true);
		khachhang.setLocationRelativeTo(null);
	}
	private void DatPhong_to_ThongKe() {
		// TODO Auto-generated method stub
		
	}
	private void datphong_to_QlDatPhong() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_QLDatPhong qldatphong = new GUI_QLDatPhong();
		qldatphong.setVisible(true);
		qldatphong.setLocationRelativeTo(null);
	}
	private void back_QLDatPhong() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_QLDatPhong qldatphong = new GUI_QLDatPhong();
		qldatphong.setVisible(true);
		qldatphong.setLocationRelativeTo(null);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
