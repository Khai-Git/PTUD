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
import DAO.DAO_QLKhachHang;
import Entity.Entity_KhachHang;

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
import javax.swing.JEditorPane;

public class GUI_QLKhachHang extends JFrame implements ActionListener, MouseListener{

	private JPanel contentPane, panel, panel_2, panel_KhachHang, panel_TTKhachHang, panel_DSKhachHang;
	private JTextField textNmaKH, textNtenKH, textNsdt, txtTimKiemSDT, textNcmnd;
	private JEditorPane editorPane_DiaChi;
	private JTable table;
	private JTextField txtTimKiemCmnd;
	private JButton btnCapNhat,btnDangXuat,btnDatPhong,btnDichVu,btnHoaDon,btnKhachHang,btnManHinhChinh,btnNhanVien,btnQLPhong,btnThem,btnThongKe,btnTimKiem,btnXoa, btnLmTrng;
	private DefaultTableModel tableModel;
	private JLabel lblTenNhanVien;
	
	private DAO_QLKhachHang kh_list;
	private JLabel lblHinh;
	private JButton btnLamMoi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_QLKhachHang frame = new GUI_QLKhachHang();
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
	public GUI_QLKhachHang() {
		setTitle("Quản lý KARAOKE_NICE");
		
		Box dsKH;
		
		ConnectDB.getInstance().connect();
		
		kh_list = new DAO_QLKhachHang();
		
		setTitle("Quản lý khách hàng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("PHẦN MỀM QUẢN LÍ  KARAOKE");
		lblTitle.setBackground(new Color(153, 180, 209));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblTitle.setBounds(-7, 0, 1367, 86);
		contentPane.add(lblTitle);
		
		btnHoaDon = new JButton(" Hóa đơn");
		btnHoaDon.setHorizontalAlignment(SwingConstants.LEFT);
		btnHoaDon.setIcon(new ImageIcon(GUI_QLKhachHang.class.getResource("/img/bill_icon1.png")));
		btnHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHoaDon.setBounds(0, 244, 221, 78);
		contentPane.add(btnHoaDon);
		
		btnDichVu = new JButton(" Dịch vụ");
		btnDichVu.setHorizontalAlignment(SwingConstants.LEFT);
		btnDichVu.setIcon(new ImageIcon(GUI_QLKhachHang.class.getResource("/img/menu2.png")));
		btnDichVu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDichVu.setBounds(0, 321, 221, 78);
		contentPane.add(btnDichVu);
		
		btnQLPhong = new JButton(" Quản lý phòng");
		btnQLPhong.setHorizontalAlignment(SwingConstants.LEFT);
		btnQLPhong.setIcon(new ImageIcon(GUI_QLKhachHang.class.getResource("/img/Science-Plus-Math-icon.png")));
		btnQLPhong.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnQLPhong.setBounds(0, 472, 221, 78);
		contentPane.add(btnQLPhong);
		
		btnNhanVien = new JButton(" Nhân viên");
		btnNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhanVien.setIcon(new ImageIcon(GUI_QLKhachHang.class.getResource("/img/black-man-icon.png")));
		btnNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNhanVien.setBounds(0, 396, 221, 78);
		contentPane.add(btnNhanVien);
		
		btnKhachHang = new JButton("  Khách hàng");
		btnKhachHang.setBackground(Color.YELLOW);
		btnKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		btnKhachHang.setIcon(new ImageIcon(GUI_QLKhachHang.class.getResource("/img/users-icon.png")));
		btnKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnKhachHang.setBounds(0, 548, 221, 78);
		contentPane.add(btnKhachHang);
		
		btnManHinhChinh = new JButton("M\u00E0n h\u00ECnh ch\u00EDnh");
		btnManHinhChinh.setHorizontalAlignment(SwingConstants.LEFT);
		btnManHinhChinh.setIcon(new ImageIcon(GUI_QLKhachHang.class.getResource("/img/home-icon.png")));
		btnManHinhChinh.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnManHinhChinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnManHinhChinh.setBounds(0, 96, 221, 78);
		contentPane.add(btnManHinhChinh);
		
		btnThongKe = new JButton("Thống kê số liệu");
		btnThongKe.setHorizontalAlignment(SwingConstants.LEFT);
		btnThongKe.setIcon(new ImageIcon(GUI_QLKhachHang.class.getResource("/img/Dollar-Sign-icon.png")));
		btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThongKe.setBounds(0, 624, 221, 78);
		contentPane.add(btnThongKe);
		
		btnDatPhong = new JButton("Đặt phòng");
		btnDatPhong.setIcon(new ImageIcon(GUI_QLKhachHang.class.getResource("/img/Household-Living-Room-icon.png")));
		btnDatPhong.setHorizontalAlignment(SwingConstants.LEFT);
		btnDatPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDatPhong.setBounds(0, 172, 221, 78);
		contentPane.add(btnDatPhong);
		
		panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 10, 10);
		contentPane.add(panel_2);
		
		JLabel lblNhanVien = new JLabel("Nhân viên:");
		lblNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNhanVien.setBounds(1021, 63, 54, 23);
		contentPane.add(lblNhanVien);
		
		btnDangXuat = new JButton("Đăng Xuất");
		btnDangXuat.setBackground(new Color(255, 155, 157));
		btnDangXuat.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnDangXuat.setBounds(1225, 63, 120, 23);
		contentPane.add(btnDangXuat);
		
		panel = new JPanel();
		panel.setToolTipText("");
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Quản lý khách hàng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(224, 97, 1252, 644);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTitle2 = new JLabel("Quản lí khách hàng");
		lblTitle2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitle2.setBounds(300, 11, 443, 31);
		panel.add(lblTitle2);
		
		panel_KhachHang = new JPanel();
		panel_KhachHang.setBackground(SystemColor.activeCaption);
		panel_KhachHang.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_KhachHang.setBounds(10, 76, 454, 558);
		panel.add(panel_KhachHang);
		panel_KhachHang.setLayout(null);
		
		panel_TTKhachHang = new JPanel();
		panel_TTKhachHang.setBackground(SystemColor.activeCaption);
		panel_TTKhachHang.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_TTKhachHang.setBounds(10, 35, 434, 368);
		panel_KhachHang.add(panel_TTKhachHang);
		panel_TTKhachHang.setLayout(null);
		
		JLabel lblMaKH = new JLabel("Mã khách hàng:");
		lblMaKH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaKH.setBounds(49, 55, 100, 26);
		panel_TTKhachHang.add(lblMaKH);
		
		JLabel lblSDT = new JLabel("Số điện thoại:");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSDT.setBounds(49, 129, 100, 26);
		panel_TTKhachHang.add(lblSDT);
		
		JLabel lblTenKhachHang = new JLabel("Tên khách hàng:");
		lblTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTenKhachHang.setBounds(49, 92, 100, 26);
		panel_TTKhachHang.add(lblTenKhachHang);
		
		JLabel lblCMND = new JLabel("CMND:");
		lblCMND.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCMND.setBounds(50, 169, 100, 26);
		panel_TTKhachHang.add(lblCMND);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDiaChi.setBounds(49, 206, 100, 26);
		panel_TTKhachHang.add(lblDiaChi);
		
		textNmaKH = new JTextField();
		textNmaKH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNmaKH.setBounds(159, 55, 215, 26);
		panel_TTKhachHang.add(textNmaKH);
		textNmaKH.setColumns(10);
		
		textNtenKH = new JTextField();
		textNtenKH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNtenKH.setColumns(10);
		textNtenKH.setBounds(159, 95, 215, 26);
		panel_TTKhachHang.add(textNtenKH);
		
		textNsdt = new JTextField();
		textNsdt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNsdt.setColumns(10);
		textNsdt.setBounds(159, 132, 215, 26);
		panel_TTKhachHang.add(textNsdt);
		
		textNcmnd = new JTextField();
		textNcmnd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNcmnd.setBounds(159, 172, 215, 23);
		panel_TTKhachHang.add(textNcmnd);
		textNcmnd.setColumns(10);
		
		editorPane_DiaChi = new JEditorPane();
		editorPane_DiaChi.setBounds(159, 203, 215, 87);
		panel_TTKhachHang.add(editorPane_DiaChi);
		
		btnLmTrng = new JButton("Làm trống");
		btnLmTrng.setForeground(Color.BLACK);
		btnLmTrng.setBackground(Color.PINK);
		btnLmTrng.setBounds(191, 301, 145, 40);
		panel_TTKhachHang.add(btnLmTrng);
		
		btnThem = new JButton("Thêm khách hàng\r\n");
		btnThem.setForeground(new Color(0, 0, 0));
		btnThem.setBackground(Color.GREEN);
		btnThem.setIcon(new ImageIcon(GUI_QLKhachHang.class.getResource("/img/user2-add-icon.png")));
		btnThem.setBounds(10, 414, 145, 40);
		panel_KhachHang.add(btnThem);
		
		btnXoa = new JButton("Xóa khách hàng");
		btnXoa.setBackground(Color.RED);
		btnXoa.setIcon(new ImageIcon(GUI_QLKhachHang.class.getResource("/img/user2-remove-icon.png")));
		btnXoa.setBounds(164, 414, 149, 40);
		panel_KhachHang.add(btnXoa);
		
		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setBackground(Color.ORANGE);
		btnCapNhat.setIcon(new ImageIcon(GUI_QLKhachHang.class.getResource("/img/user2-edit-icon (16).png")));
		btnCapNhat.setBounds(323, 414, 121, 40);
		panel_KhachHang.add(btnCapNhat);
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setForeground(Color.BLACK);
		btnTimKiem.setBackground(Color.WHITE);
		btnTimKiem.setIcon(new ImageIcon(GUI_QLKhachHang.class.getResource("/img/user2-search-icon.png")));
		btnTimKiem.setBounds(10, 465, 130, 55);
		panel_KhachHang.add(btnTimKiem);
		
		txtTimKiemSDT = new JTextField();
		txtTimKiemSDT.setToolTipText("Nhập số điện thoại");
		txtTimKiemSDT.setForeground(Color.LIGHT_GRAY);
		txtTimKiemSDT.setBounds(150, 465, 294, 25);
		panel_KhachHang.add(txtTimKiemSDT);
		txtTimKiemSDT.setColumns(10);
		
		txtTimKiemCmnd = new JTextField();
		txtTimKiemCmnd.setToolTipText("Nhập số CMND");
		txtTimKiemCmnd.setForeground(new Color(192, 192, 192));
		txtTimKiemCmnd.setBounds(150, 495, 294, 25);
		panel_KhachHang.add(txtTimKiemCmnd);
		txtTimKiemCmnd.setColumns(10);
		
		panel_DSKhachHang = new JPanel();
		panel_DSKhachHang.setBackground(SystemColor.activeCaption);
		panel_DSKhachHang.setLayout(null);
		panel_DSKhachHang.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh S\u00E1ch kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_DSKhachHang.setBounds(474, 53, 768, 581);
		panel.add(panel_DSKhachHang);
		
		panel_DSKhachHang.add(dsKH = Box.createHorizontalBox());
		panel_DSKhachHang.add(Box.createVerticalStrut(10));
		String [] headers = "Mã khách hàng; Tên khách hàng; Số điện thoại; Địa chỉ; CMND".split(";");
		tableModel = new DefaultTableModel(headers,0);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table = new JTable(tableModel));
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPane.setBounds(10, 27, 748, 496);
		table.setRowHeight(35);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		panel_DSKhachHang.add(scrollPane);
		
		btnLamMoi = new JButton("Làm mới bảng");
		btnLamMoi.setForeground(new Color(255, 255, 255));
		btnLamMoi.setBackground(new Color(128, 0, 255));
		btnLamMoi.setBounds(319, 532, 130, 38);
		panel_DSKhachHang.add(btnLamMoi);
		
		lblTenNhanVien = new JLabel("");
		lblTenNhanVien.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTenNhanVien.setBounds(1077, 63, 138, 23);
		contentPane.add(lblTenNhanVien);
		
		lblHinh = new JLabel("");
		lblHinh.setIcon(new ImageIcon(GUI_QLKhachHang.class.getResource("/img/kara_page-0001.jpg")));
		lblHinh.setBounds(10, 8, 170, 78);
		contentPane.add(lblHinh);
		
		//Action Quan Ly
		btnDatPhong.addActionListener(this);
		btnDichVu.addActionListener(this);
		btnHoaDon.addActionListener(this);
		btnKhachHang.addActionListener(this);
		btnManHinhChinh.addActionListener(this);
		btnNhanVien.addActionListener(this);
		btnQLPhong.addActionListener(this);
		btnThongKe.addActionListener(this);
		
		//Action Event
		btnThem.addActionListener(this);
		btnTimKiem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnCapNhat.addActionListener(this);
		btnDangXuat.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnLmTrng.addActionListener(this);
		
		table.addMouseListener(this);
		
		nv_HienTai();
		DB_To_Table();
		countMaKH();
	}
	
	private void countMaKH() {
		int count = 0;
		for (int i = 0; i < table.getRowCount(); i++) {
			count++;
		}
		count++;
		textNmaKH.setText("KH0" + count);
		textNmaKH.setEditable(false);
	}
	
	private void DB_To_Table() {
		DefaultTableModel dTableModel = (DefaultTableModel) table.getModel();
		dTableModel.getDataVector().removeAllElements();
		
		DAO_QLKhachHang ds = new DAO_QLKhachHang();
		List<Entity_KhachHang> list = ds.getAllTableKH();
		for(Entity_KhachHang kh : list) {
			String [] rowData = {kh.getMaKH(), kh.getTenKH(), kh.getSoDienThoai(), kh.getDiaChi(), kh.getCMND()};
			tableModel.addRow(rowData);
		}
		table.setModel(tableModel);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		// Main Action
		if (o.equals(btnManHinhChinh)) {
			KhachHang_to_ManHinhChinh();
		}
		if (o.equals(btnDichVu)) {
			KhachHang_to_DichVu();
		}
		if (o.equals(btnNhanVien)) {
			checkChucVu();
		}
		if (o.equals(btnQLPhong)) {
			KhachHang_to_Phong();
		}
		if (o.equals(btnDatPhong)) {
			KhachHang_to_QLDatPhong();
		}
		if (o.equals(btnThongKe)) {
			KhachHang_to_ThongKe();
		}
		if (o.equals(btnHoaDon)) {
			KhachHang_to_HoaDon();
		}
		
		//Action 
		if (o.equals(btnThem)) {
			ThemAction();
		}
		if (o.equals(btnXoa)) {
			XoaAction();
		}
		if (o.equals(btnCapNhat)) {
			CapNhatAction();
		}
		if (o.equals(btnTimKiem)) {
			try {
				TimKiemAction();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(o.equals(btnDangXuat)) {
			try {
				DangXuat();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(o.equals(btnLamMoi)) {
			DB_To_Table();
		}
		if (o.equals(btnLmTrng)) {
			xoaTrangAction();
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
					
					if(nv_chucVu.length() == 6) {
						JOptionPane.showMessageDialog(this, "Nhân viên lễ tân không được phép vào !!!");
						return;
					} else {
						KhachHang_to_NhanVien();
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
		countMaKH();
	}
	
	private void TimKiemAction() throws SQLException {
		// TODO Auto-generated method stub
		String timKHSDT = txtTimKiemSDT.getText() == null ? "" : txtTimKiemSDT.getText().toString().trim();
		String timKHCMND = txtTimKiemCmnd.getText() == null ? "" : txtTimKiemCmnd.getText().toString().trim();
		
		Connection con= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=KARAOKE_Nice","sa","sapassword");
		String sql= "select * \r\n"
				+ "from KhachHang kh \r\n"
				+ "where kh.sdt like '%"+ timKHSDT +"%'"
				+ " and kh.cmnd like '%"+ timKHCMND +"%'";
		
		Statement stmt = con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		tableModel.setRowCount(0);
		
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
					rs.getString(5)
			};
			
			tableModel.addRow(rowData);
			JOptionPane.showMessageDialog(this, "Tìm kiếm thành công !!!");
			txtTimKiemSDT.setText("");
			txtTimKiemCmnd.setText("");
		}
		
		table.setModel(tableModel);
		xoaTrangAction();
		countMaKH();
	}

	private void CapNhatAction() {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		
		String maKH = textNmaKH.getText();
		String tenKH = textNtenKH.getText();
		String sdt = textNsdt.getText();
		String diaChi = editorPane_DiaChi.getText();
		String cmnd = textNcmnd.getText();
		
		Entity_KhachHang kh = new Entity_KhachHang(maKH, tenKH, sdt, diaChi, cmnd);
		if (row >= 0) {
			if (kh_list.capNhatKH(kh)) {
				table.setValueAt(textNmaKH.getText(), row, 0);
				table.setValueAt(textNtenKH.getText(), row, 1);
				table.setValueAt(textNsdt.getText(), row, 2);
				table.setValueAt(editorPane_DiaChi.getText(), row, 3);
				table.setValueAt(textNcmnd.getText(), row, 4);
				xoaTrangAction();
				JOptionPane.showMessageDialog(this, "Cập nhật thành công !!!");
			}
		}
		countMaKH();
	}

	private void XoaAction() {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		if(row >= 0) {
			String maKH = (String) table.getValueAt(row, 0);
			if(kh_list.xoaKH(maKH)) {
				tableModel.removeRow(row);
				xoaTrangAction();
				JOptionPane.showMessageDialog(this, "Xóa khách hàng thành công !!!");
			}
		}
		countMaKH();
	}
	private void xoaTrangAction() {
		// TODO Auto-generated method stub
		textNmaKH.setText("");
    	textNtenKH.setText("");
    	textNsdt.setText("");
    	textNcmnd.setText("");
    	editorPane_DiaChi.setText("");
    	countMaKH();
	}

	private void ThemAction() {
		// TODO Auto-generated method stub
		String maKH = textNmaKH.getText();
		String tenKH = textNtenKH.getText();
		String sdt = textNsdt.getText();
		String diaChi = editorPane_DiaChi.getText();
		String cmnd = textNcmnd.getText();
		
		Entity_KhachHang kh = new Entity_KhachHang(maKH, tenKH, sdt, diaChi, cmnd);
		
		if(!(maKH.length() > 0 && maKH.matches("^(KH)\\d{3}$"))) {
			JOptionPane.showMessageDialog(this, "Nhập sai định dạng! Mã bắt đầu bằng KH + 3 số");
			textNmaKH.requestFocus();
			return ;
		}
		if(!((cmnd.length() == 9 || cmnd.length() == 12))) {
			JOptionPane.showMessageDialog(this, "Nhập sai định dạng! CMND chỉ chấp nhận 9 hoặc 12 ký tự số");
			textNcmnd.requestFocus();
			return ;
		}
		if (!(tenKH.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Tên khách hàng không được để trống !");
			textNtenKH.requestFocus();
			return ;
		}
		
		if (kh_list.themKH(kh)) {
			String [] row = {kh.getMaKH(), kh.getTenKH(), kh.getSoDienThoai(),
					kh.getDiaChi(), kh.getCMND()};
			tableModel.addRow(row);
			xoaTrangAction();
			JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công !!");
		} else {
			JOptionPane.showMessageDialog(null, "Trùng mã khách hàng đã được nhập !!");
			textNmaKH.requestFocus();
		}
		countMaKH();
	}

	private void KhachHang_to_HoaDon() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_HoaDon hoadon = new GUI_HoaDon();
		hoadon.setVisible(true);
		hoadon.setLocationRelativeTo(null);
	}

	private void KhachHang_to_ThongKe() {
		// TODO Auto-generated method stub
		
	}

	private void KhachHang_to_QLDatPhong() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_ThuePhong qldatphong = new GUI_ThuePhong();
		qldatphong.setVisible(true);
		qldatphong.setLocationRelativeTo(null);
	}

	private void KhachHang_to_Phong() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_QLPhong qlphong = new GUI_QLPhong();
		qlphong.setVisible(true);
		qlphong.setLocationRelativeTo(null);
	}

	private void KhachHang_to_NhanVien() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_QLNhanVien nhanvien = new GUI_QLNhanVien();
		nhanvien.setVisible(true);
		nhanvien.setLocationRelativeTo(null);
	}

	private void KhachHang_to_DichVu() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_QLDichVu dichvu = new GUI_QLDichVu();
		dichvu.setVisible(true);
		dichvu.setLocationRelativeTo(null);
	}

	private void KhachHang_to_ManHinhChinh() {
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
		textNmaKH.setText(tableModel.getValueAt(row, 0).toString());
		textNtenKH.setText(tableModel.getValueAt(row, 1).toString());
		textNsdt.setText(tableModel.getValueAt(row, 2).toString());
		editorPane_DiaChi.setText(tableModel.getValueAt(row, 3).toString());
		textNcmnd.setText(tableModel.getValueAt(row, 4).toString());
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