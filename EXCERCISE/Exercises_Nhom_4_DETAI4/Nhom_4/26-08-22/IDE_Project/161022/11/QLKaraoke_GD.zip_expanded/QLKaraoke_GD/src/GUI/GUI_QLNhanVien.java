package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
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
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;

import ConnectDB.ConnectDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import DAO.DAO_QLKhachHang;
import DAO.DAO_QLNhanVien;
import DAO.DAO_TaiKhoan;
import Entity.Entity_KhachHang;
import Entity.Entity_NhanVien;
import Entity.Entity_TaiKhoan;
import other.Regex;

public class GUI_QLNhanVien extends JFrame implements ActionListener, MouseListener{

	private JPanel contentPane;
	public static JTextField textFieldNmaNV, textField_NtenNV, textField_Nsdt, textField_TKNV, textField_MKNV;
	private JTextField textField_NtimKiem;
	private JTable table;
	private JButton btnTimKiem, btnCapNhat, btnXoa, btnThem, btnDatPhong, btnDangXuat, btnThongKe, btnManHinhChinh, btnKhachHang, btnQLPhong, btnNhanVien, btnDichVu, btnHoaDon, btnLamMoi;
	private JLabel lblNewLabel, lblTenNhanVien;
	public static  JComboBox comboBox_ChucVu;
	private DefaultTableModel tableModel;
	private DAO_QLNhanVien dao_nv;
	private DAO_TaiKhoan dao_tk;
	private Entity_NhanVien nv;
	private Entity_TaiKhoan tk;
	public static  JRadioButton rad_Nam, rad_Nu, rad_Khac;
	private JLabel lblTitle;
	private ButtonGroup groupBtn;
	private JLabel lblHinh;
	private JLabel lblNhanVien, lblTitle2, lblMaNV, lblSDT, lblTenNV, lblChucVu, lblGioiTinh, lblTaiKhoanNV, lblMatKhauNV;
	private JButton btnLmTrng;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_QLNhanVien frame = new GUI_QLNhanVien();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_QLNhanVien() {
		setTitle("Quản lý KARAOKE_NICE");
		
		ConnectDB.getInstance().connect();
		dao_nv = new DAO_QLNhanVien();
		dao_tk = new DAO_TaiKhoan();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitle = new JLabel("PHẦN MỀM QUẢN LÍ KARAOKE");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblTitle.setBounds(-7, 0, 1481, 86);
		contentPane.add(lblTitle);
		
		btnHoaDon = new JButton(" Hóa đơn");
		btnHoaDon.setHorizontalAlignment(SwingConstants.LEFT);
		btnHoaDon.setIcon(new ImageIcon(GUI_QLNhanVien.class.getResource("/img/bill_icon1.png")));
		btnHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHoaDon.setBounds(0, 244, 221, 78);
		contentPane.add(btnHoaDon);
		
		btnDichVu = new JButton(" Dịch vụ");
		btnDichVu.setHorizontalAlignment(SwingConstants.LEFT);
		btnDichVu.setIcon(new ImageIcon(GUI_QLNhanVien.class.getResource("/img/menu2.png")));
		btnDichVu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDichVu.setBounds(0, 321, 221, 78);
		contentPane.add(btnDichVu);
		
		btnQLPhong = new JButton(" Quản lý phòng");
		btnQLPhong.setHorizontalAlignment(SwingConstants.LEFT);
		btnQLPhong.setIcon(new ImageIcon(GUI_QLNhanVien.class.getResource("/img/Science-Plus-Math-icon.png")));
		btnQLPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnQLPhong.setBounds(0, 472, 221, 78);
		contentPane.add(btnQLPhong);
		
		btnNhanVien = new JButton(" Nhân viên");
		btnNhanVien.setBackground(Color.YELLOW);
		btnNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhanVien.setIcon(new ImageIcon(GUI_QLNhanVien.class.getResource("/img/black-man-icon.png")));
		btnNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNhanVien.setBounds(0, 396, 221, 78);
		contentPane.add(btnNhanVien);
		
		btnKhachHang = new JButton("  Khách hàng");
		btnKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		btnKhachHang.setIcon(new ImageIcon(GUI_QLNhanVien.class.getResource("/img/users-icon.png")));
		btnKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnKhachHang.setBounds(0, 548, 221, 78);
		contentPane.add(btnKhachHang);
		
		btnManHinhChinh = new JButton("M\u00E0n h\u00ECnh ch\u00EDnh");
		btnManHinhChinh.setHorizontalAlignment(SwingConstants.LEFT);
		btnManHinhChinh.setIcon(new ImageIcon(GUI_QLNhanVien.class.getResource("/img/home-icon.png")));
		btnManHinhChinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnManHinhChinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnManHinhChinh.setBounds(0, 96, 221, 78);
		contentPane.add(btnManHinhChinh);
		
		btnThongKe = new JButton("Thống kê số liệu");
		btnThongKe.setHorizontalAlignment(SwingConstants.LEFT);
		btnThongKe.setIcon(new ImageIcon(GUI_QLNhanVien.class.getResource("/img/Dollar-Sign-icon.png")));
		btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThongKe.setBounds(0, 624, 221, 78);
		contentPane.add(btnThongKe);
		
		btnDangXuat = new JButton("\u0110\u0103ng xu\u1EA5t");
		btnDangXuat.setBackground(new Color(255, 155, 157));
		btnDangXuat.setBounds(1220, 63, 99, 23);
		contentPane.add(btnDangXuat);
		
		btnDatPhong = new JButton(" Đặt phòng");
		btnDatPhong.setIcon(new ImageIcon(GUI_QLNhanVien.class.getResource("/img/Household-Living-Room-icon.png")));
		btnDatPhong.setHorizontalAlignment(SwingConstants.LEFT);
		btnDatPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDatPhong.setBounds(0, 172, 221, 78);
		contentPane.add(btnDatPhong);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 10, 10);
		contentPane.add(panel_2);
		
		lblNhanVien = new JLabel("Nhân viên : ");
		lblNhanVien.setBounds(994, 63, 73, 23);
		contentPane.add(lblNhanVien);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Qu\u1EA3n l\u00ED nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(224, 97, 1250, 653);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblTitle2 = new JLabel("Quản lí nhân viên");
		lblTitle2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitle2.setBounds(300, 11, 443, 31);
		panel.add(lblTitle2);
		
		JPanel panel_NhanVien = new JPanel();
		panel_NhanVien.setBackground(SystemColor.activeCaption);
		panel_NhanVien.setBorder(new TitledBorder(null, "Nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_NhanVien.setBounds(3, 70, 443, 529);
		panel.add(panel_NhanVien);
		panel_NhanVien.setLayout(null);
		
		JPanel panel_TTNhanVien = new JPanel();
		panel_TTNhanVien.setBackground(SystemColor.activeCaption);
		panel_TTNhanVien.setBorder(new TitledBorder(null, "Th\u00F4ng tin nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_TTNhanVien.setBounds(10, 35, 423, 339);
		panel_NhanVien.add(panel_TTNhanVien);
		panel_TTNhanVien.setLayout(null);
		
		lblMaNV = new JLabel("Mã nhân viên:");
		lblMaNV.setBounds(23, 30, 100, 26);
		panel_TTNhanVien.add(lblMaNV);
		
		lblSDT = new JLabel("Số điện thoại:");
		lblSDT.setBounds(23, 104, 100, 26);
		panel_TTNhanVien.add(lblSDT);
		
		lblTenNV = new JLabel("Tên nhân viên:");
		lblTenNV.setBounds(23, 67, 100, 26);
		panel_TTNhanVien.add(lblTenNV);
		
		lblChucVu = new JLabel("Chức vụ:");
		lblChucVu.setBounds(23, 141, 100, 26);
		panel_TTNhanVien.add(lblChucVu);
		
		lblGioiTinh = new JLabel("Giới tính:");
		lblGioiTinh.setBounds(23, 178, 100, 26);
		panel_TTNhanVien.add(lblGioiTinh);
		
		textFieldNmaNV = new JTextField("NV");
		textFieldNmaNV.setBounds(133, 30, 215, 26);
		panel_TTNhanVien.add(textFieldNmaNV);
		textFieldNmaNV.setColumns(10);
		textFieldNmaNV.setEditable(true);
		
		textField_NtenNV = new JTextField();
		textField_NtenNV.setColumns(10);
		textField_NtenNV.setBounds(133, 70, 215, 26);
		panel_TTNhanVien.add(textField_NtenNV);
		
		textField_Nsdt = new JTextField();
		textField_Nsdt.setColumns(10);
		textField_Nsdt.setBounds(133, 107, 215, 26);
		panel_TTNhanVien.add(textField_Nsdt);
		
		comboBox_ChucVu = new JComboBox();
		comboBox_ChucVu.setModel(new DefaultComboBoxModel(new String[] {"Nhân viên", "Quản lí"}));
		comboBox_ChucVu.setToolTipText("");
		comboBox_ChucVu.setBounds(133, 143, 215, 26);
		panel_TTNhanVien.add(comboBox_ChucVu);
		
		rad_Nam = new JRadioButton("Nam");
		rad_Nam.setBackground(SystemColor.activeCaption);
		rad_Nam.setBounds(133, 180, 55, 23);
		panel_TTNhanVien.add(rad_Nam);
		
		rad_Nu = new JRadioButton("Nữ");
		rad_Nu.setBackground(SystemColor.activeCaption);
		rad_Nu.setBounds(206, 180, 55, 23);
		panel_TTNhanVien.add(rad_Nu);
		
		rad_Khac = new JRadioButton("Khác");
		rad_Khac.setBackground(SystemColor.activeCaption);
		rad_Khac.setBounds(277, 180, 55, 23);
		panel_TTNhanVien.add(rad_Khac);
		
		lblTaiKhoanNV = new JLabel("Tài khoản:");
		lblTaiKhoanNV.setBounds(23, 217, 73, 26);
		panel_TTNhanVien.add(lblTaiKhoanNV);
		
		lblMatKhauNV = new JLabel("Mật khẩu:");
		lblMatKhauNV.setBounds(25, 246, 82, 25);
		panel_TTNhanVien.add(lblMatKhauNV);
		
		textField_TKNV = new JTextField();
		textField_TKNV.setBounds(135, 215, 215, 23);
		panel_TTNhanVien.add(textField_TKNV);
		textField_TKNV.setColumns(10);
		
		textField_MKNV = new JTextField();
		textField_MKNV.setBounds(135, 248, 215, 23);
		panel_TTNhanVien.add(textField_MKNV);
		textField_MKNV.setColumns(10);
		
		textField_NtimKiem = new JTextField();
		textField_NtimKiem.setToolTipText("Nhập số điện thoại để tìm");
		textField_NtimKiem.setBounds(10, 459, 281, 25);
		panel_NhanVien.add(textField_NtimKiem);
		textField_NtimKiem.setColumns(10);
		
		btnThem = new JButton("Thêm nhân viên");
		btnThem.setForeground(Color.BLACK);
		btnThem.setBackground(Color.GREEN);
		btnThem.setBounds(12, 385, 150, 40);
		panel_NhanVien.add(btnThem);
		
		btnXoa = new JButton("Xóa nhân viên");
		btnXoa.setForeground(Color.BLACK);
		btnXoa.setBackground(new Color(220, 20, 60));
		btnXoa.setBounds(172, 385, 141, 40);
		panel_NhanVien.add(btnXoa);
		
		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setForeground(Color.BLACK);
		btnCapNhat.setBackground(Color.ORANGE);
		btnCapNhat.setBounds(323, 385, 110, 40);
		panel_NhanVien.add(btnCapNhat);
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBounds(301, 451, 130, 40);
		panel_NhanVien.add(btnTimKiem);
		btnTimKiem.setForeground(Color.BLACK);
		btnTimKiem.setBackground(new Color(106, 90, 205));
		btnTimKiem.addActionListener(this);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(null, "Danh s\u00E1ch nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBackground(SystemColor.activeCaption);
		panel_4.setBounds(452, 53, 788, 589);
		panel.add(panel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 768, 522);
		panel_4.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);	
		String header [] = {"Mã nhân viên", "Tên nhân viên", "Số điện thoại", "Giới tính", "Chức vụ", "Tài khoản", "Mật khẩu"};
		tableModel = new DefaultTableModel(header, 0);
		JScrollPane scroll = new JScrollPane(table = new JTable(tableModel));
		table.setRowHeight(35);
		scrollPane.setViewportView(table);
		
		btnLamMoi = new JButton("Làm mới bảng");
		btnLamMoi.setBounds(329, 547, 130, 33);
		panel_4.add(btnLamMoi);
		btnLamMoi.setForeground(Color.BLACK);
		btnLamMoi.setBackground(new Color(106, 90, 205));
		btnLamMoi.addActionListener(this);
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		table.getColumnModel().getColumn(4).setPreferredWidth(70);
		
		lblTenNhanVien = new JLabel("");
		lblTenNhanVien.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTenNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenNhanVien.setBounds(1055, 63, 155, 23);
		contentPane.add(lblTenNhanVien);
		
		groupBtn = new ButtonGroup();
		groupBtn.add(rad_Nam);
		groupBtn.add(rad_Nu);
		groupBtn.add(rad_Khac);
		
		btnLmTrng = new JButton("Làm trống");
		btnLmTrng.setForeground(Color.BLACK);
		btnLmTrng.setBackground(Color.ORANGE);
		btnLmTrng.setBounds(174, 288, 110, 40);
		panel_TTNhanVien.add(btnLmTrng);
		
		lblHinh = new JLabel("");
		lblHinh.setIcon(new ImageIcon(GUI_QLNhanVien.class.getResource("/img/kara_page-0001.jpg")));
		lblHinh.setBounds(10, 8, 170, 78);
		contentPane.add(lblHinh);
		rad_Nam.addActionListener(this);
		rad_Nu.addActionListener(this);
		rad_Khac.addActionListener(this);
		
		btnDatPhong.addActionListener(this);
		btnDangXuat.addActionListener(this);
		btnThongKe.addActionListener(this);
		btnManHinhChinh.addActionListener(this);
		btnKhachHang.addActionListener(this);
		btnQLPhong.addActionListener(this);
		btnNhanVien.addActionListener(this);
		btnDichVu.addActionListener(this);
		btnHoaDon.addActionListener(this);
		btnLmTrng.addActionListener(this);
		table.addMouseListener(this);
		
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnCapNhat.addActionListener(this);
		btnTimKiem.addActionListener(this);
		btnDangXuat.addActionListener(this);
		
		docDuLieuVaoTable();
		nv_HienTai();
		countMaNV();
	}

	private void countMaNV() {
		int count = 0;
		for (int i = 0; i < table.getRowCount(); i++) {
			count++;
		}
		count++;
		textFieldNmaNV.setText("NV00" + count);
		textFieldNmaNV.setEditable(false);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnManHinhChinh)) {
			nhanVien_To_ManHinhChinh();
		}
		if (o.equals(btnDatPhong)) {
			nhanVien_To_QLDatPhong();
		}
		if (o.equals(btnHoaDon)) {
			nhanVien_To_HoaDon();
		}
		if (o.equals(btnDichVu)) {
			nhanVien_To_DichVu();
		}
		if (o.equals(btnNhanVien)) {
			checkChucVu();
		}
		if (o.equals(btnQLPhong)) {
			nhanVien_To_QLPhong();
		}
		if (o.equals(btnKhachHang)) {
			nhanVien_To_KhachHang();
		}
		if (o.equals(btnThongKe)) {
			nhanVien_To_Thongke();
		}
		if(o.equals(btnThem)) {
			if(validData()) {
				Entity_NhanVien qlnhanvien = revertFromTextField();
				int hoiNhac = JOptionPane.showConfirmDialog(this,"Có chắc muốn thêm nhân viên không?","Thông báo",JOptionPane.YES_NO_OPTION);
				try {
					if(hoiNhac==JOptionPane.YES_OPTION) {
						dao_nv.createNhanVien(qlnhanvien);
						tableModel.addRow(new Object[] {qlnhanvien.getMaNV(),qlnhanvien.getTenNV(),qlnhanvien.getSoDienThoai(),qlnhanvien.getGioiTinh(),qlnhanvien.getChucVu(),qlnhanvien.getTaiKhoan().getTaikhoanNv(),qlnhanvien.getTaiKhoan().getMatKhau()});
						JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công !!!");
						clearAction();
					}
				}catch (Exception e1) {
					// TODO: handle exception
						JOptionPane.showMessageDialog(this,"Trùng mã nhân viên, Xác nhận");
				}
			}	
		}
		if(o.equals(btnXoa)) {
			deleteNhanVien();
		}
		if(o.equals(btnCapNhat)) {
			suaThongTin();
		}
		if(o.equals(btnTimKiem)) {
			try {
				searchNhanVien();
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
			Lammoi();
		}
		if (o.equals(btnLmTrng)){
			clearAction();
		}
	}
	
	private void Lammoi() {
		// TODO Auto-generated method stub
		docDuLieuVaoTable();
		countMaNV();
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
						nhanVien_To_QLNhanVien();
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
		countMaNV();
	}
	
	private boolean validData() {
		// TODO Auto-generated method stub
			String tenNhanVien = textField_NtenNV.getText().trim();
			String sdt = textField_Nsdt.getText().trim();
			String taikhoan = textField_TKNV.getText().trim();
			String matkhau = textField_MKNV.getText();
			
			if(!(tenNhanVien.length() > 0)) {
				JOptionPane.showMessageDialog(null, "Tên nhân viên không để trống!");
				textField_NtenNV.requestFocus();
				textField_NtenNV.selectAll();
				return false;
			}
//			else {
//				if(!tenNhanVien.matches(Regex.REGEX_TEN)) {
//					JOptionPane.showMessageDialog(null, "Tên nhân viên không chứa kí tự đăc biệt!");
//					textField_NtenNV.requestFocus();
//					textField_NtenNV.selectAll();
//					return false;
//				}
//			}
			if(sdt.length() == 0 ) {
				JOptionPane.showMessageDialog(null, "Số điện thoại không để rỗng!");
				textField_Nsdt.requestFocus();
				textField_Nsdt.selectAll();
				return false;
			} else {
				if(!sdt.matches(Regex.REGEX_SODIENTHOAI)) {
					JOptionPane.showMessageDialog(null, "Số điện thoại bắt đầu là 0 và gồm tất cả 10 số!");
					textField_NtenNV.requestFocus();
					textField_NtenNV.selectAll();
					return false;
				}
			}
			if(taikhoan.length() == 0) {
				JOptionPane.showMessageDialog(null, "Tài khoản không để trống!");
				textField_TKNV.requestFocus();
				textField_TKNV.selectAll();
				return false;
			}else {
				if(!taikhoan.matches(Regex.REGEX_TAIKHOAN)) {
					JOptionPane.showMessageDialog(null, "Tài khoản viết liền, không chứa kí tự đặt biệt!");
					textField_TKNV.requestFocus();
					textField_TKNV.selectAll();
					return false;
				}
			}
			
			if(matkhau.length() == 0) {
				JOptionPane.showMessageDialog(null, "Mật khẩu không để trống!");
				textField_MKNV.requestFocus();
				textField_MKNV.selectAll();
				return false;
			}else {
				if(!matkhau.matches(Regex.REGEX_MATKHAU)) {
					JOptionPane.showMessageDialog(null, "Mật khẩu chứa ít nhất 6 kí tự và không bao gồm kí tự đặc biệt!");
					textField_MKNV.requestFocus();
					textField_MKNV.selectAll();
					return false;
				}
			}
			countMaNV();
			return true;
	}

	private void nhanVien_To_Thongke() {
		// TODO Auto-generated method stub
		
	}

	private void nhanVien_To_KhachHang() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_QLKhachHang khachhang = new GUI_QLKhachHang();
		khachhang.setVisible(true);
		khachhang.setLocationRelativeTo(null);
	}

	private void nhanVien_To_QLPhong() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_QLPhong qlphong = new GUI_QLPhong();
		qlphong.setVisible(true);
		qlphong.setLocationRelativeTo(null);
	}

	private void nhanVien_To_QLNhanVien() {
		// TODO Auto-generated method stub
	}

	private void nhanVien_To_DichVu() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_QLDichVu dichVu = new GUI_QLDichVu();
		dichVu.setVisible(true);
		dichVu.setLocationRelativeTo(null);
	}

	private void nhanVien_To_HoaDon() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_HoaDon hoadon = new GUI_HoaDon();
		hoadon.setVisible(true);
		hoadon.setLocationRelativeTo(null);
	}

	private void nhanVien_To_QLDatPhong() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_ThuePhong qldatphong = new GUI_ThuePhong();
		qldatphong.setVisible(true);
		qldatphong.setLocationRelativeTo(null);
	}

	private void nhanVien_To_ManHinhChinh() {
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
		textFieldNmaNV.setText(tableModel.getValueAt(row, 0).toString());
		textField_NtenNV.setText(tableModel.getValueAt(row, 1).toString());
		textField_Nsdt.setText(tableModel.getValueAt(row, 2).toString());
		if (tableModel.getValueAt(row, 3).toString().equals("Nam")) {
			  rad_Nam.setSelected(true);
			}
			else if (tableModel.getValueAt(row, 3).toString().equals("Nữ")) {
			  rad_Nu.setSelected(true);
			} 
			else if (tableModel.getValueAt(row, 3).toString().equals("Khác")) {
				 rad_Khac.setSelected(true);
			}
		comboBox_ChucVu.setSelectedItem(tableModel.getValueAt(row, 4).toString());
		textField_TKNV.setText(tableModel.getValueAt(row, 5).toString());
		textField_MKNV.setText(tableModel.getValueAt(row, 6).toString());
		textFieldNmaNV.setEditable(false);
		textField_TKNV.setEditable(false);
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
	
	private void docTenNhanVien() {
		DAO_QLNhanVien nv = new DAO_QLNhanVien();
		List<Entity_NhanVien> list = nv.getallNhanVien();
		
	}
	
	private void docDuLieuVaoTable() {
		// TODO Auto-generated method stub
		DefaultTableModel dTableModel = (DefaultTableModel) table.getModel();
		dTableModel.getDataVector().removeAllElements();
		
		DAO_QLNhanVien nv = new DAO_QLNhanVien();
		List<Entity_NhanVien> list = nv.getallNhanVien();
		for (Entity_NhanVien l : list) {	
			String []  rowData = {l.getMaNV(), l.getTenNV(), l.getSoDienThoai(), l.getGioiTinh(),l.getChucVu(), l.getTaiKhoan().getTaikhoanNv(), l.getTaiKhoan().getMatKhau()};
			tableModel.addRow(rowData);
		}
		countMaNV();
		table.setModel(tableModel);
	}
	
	private Entity_NhanVien revertFromTextField() {
		// TODO Auto-generated method stub
		String maNV = textFieldNmaNV.getText();
		String tenNV = textField_NtenNV.getText();
		String sdt = textField_Nsdt.getText();
		String chucVu = comboBox_ChucVu.getSelectedItem().toString();
		String taiKhoan = textField_TKNV.getText();
		String matKhau = textField_MKNV.getText();
		String gioiTinh = null;
		if(rad_Nam.isSelected()) {
			gioiTinh = "Nam";
		} else if(rad_Nu.isSelected()) {
			gioiTinh = "Nữ";
		} else if(rad_Khac.isSelected()) {
			gioiTinh = "Khác";
		}
		Entity_TaiKhoan tk = new Entity_TaiKhoan(taiKhoan,matKhau);
		countMaNV();
		return new  Entity_NhanVien(maNV, tenNV, sdt, gioiTinh, chucVu, tk);
	}
	
	private void deleteNhanVien() {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		if(row >= 0) {
			String maNV = (String) table.getValueAt(row, 0);
			if(dao_nv.delete(maNV)) {
				tableModel.removeRow(row);
				clearAction();
				JOptionPane.showMessageDialog(this, "Xóa nhân viên thành công !!!");
			}
		}
		countMaNV();
	}

	private void suaThongTin() {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		String maNV = textFieldNmaNV.getText().toString();
		String tenNV = textField_NtenNV.getText().toString();
		String sdt = textField_Nsdt.getText().toString();
		String chucVu = comboBox_ChucVu.getSelectedItem().toString();
		String taiKhoan = textField_TKNV.getText().toString();
		String matKhau = textField_MKNV.getText().toString();
		String gioiTinh = null;
		if(rad_Nam.isSelected()) {
			gioiTinh = "Nam";
		} else if(rad_Nu.isSelected()) {
			gioiTinh = "Nữ";
		} else if(rad_Khac.isSelected()) {
			gioiTinh = "Khác";
		}
		Entity_TaiKhoan tk = new Entity_TaiKhoan(taiKhoan,matKhau);
		Entity_NhanVien nv = new  Entity_NhanVien(maNV, tenNV, sdt, gioiTinh, chucVu,tk);
		if(row >= 0) {
			if(dao_nv.update(nv)) {
				table.setValueAt(textFieldNmaNV.getText().toString(), row, 0);
				table.setValueAt(textField_NtenNV.getText().toString(), row, 1);
				table.setValueAt(textField_Nsdt.getText().toString(), row, 2);
				table.setValueAt(gioiTinh,row,3);
				table.setValueAt(comboBox_ChucVu.getSelectedItem().toString(), row, 4);
				table.setValueAt(textField_TKNV.getText().toString(), row, 5);
				table.setValueAt(textField_MKNV.getText().toString(), row, 6);
				clearAction();
				JOptionPane.showMessageDialog(this, "Cập nhật thành công !!!");
			}
		}
		countMaNV();
	}
	
	public void clearAction() {
		textFieldNmaNV.setText("");
		textField_NtenNV.setText("");
		textField_Nsdt.setText("");
		textField_TKNV.setText("");
		textField_MKNV.setText("");
		rad_Nam.setSelected(true);
		rad_Nu.setSelected(false);
		rad_Khac.setSelected(false);
		textFieldNmaNV.setEditable(true);
		textField_TKNV.setEditable(true);
		countMaNV();
	}

	private void searchNhanVien() throws SQLException {
		// TODO Auto-generated method stub
		String timkiemSDT = textField_NtimKiem.getText() == null ? "" : textField_NtimKiem.getText().toString().trim();
		
		Connection con= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=KARAOKE_Nice","sa","sapassword");
		String sql= "select nv.maNv, nv.tenNV, nv.sdt, nv.gioiTinh, nv.chucVu, nv.taiKhoan, tk.matKhau \r\n"
				+ " from NhanVien nv, TaiKhoan tk \r\n"
				+ " where nv.sdt like N'%"+ timkiemSDT +"%' \r\n"
				+ " and nv.taiKhoan like tk.taiKhoan \r\n";
		
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
					rs.getString(5),
					rs.getString(6),
					rs.getString(7)
			};
			
			tableModel.addRow(rowData);
		}
		
		table.setModel(tableModel);
		textFieldNmaNV.setText("");
		textFieldNmaNV.setEditable(false);
		textField_NtenNV.setText("");
		textField_Nsdt.setText("");
		textField_TKNV.setText("");
		textField_MKNV.setText("");
		rad_Nam.setSelected(true);
		rad_Nu.setSelected(false);
		rad_Khac.setSelected(false);
		textFieldNmaNV.setEditable(true);
		textField_TKNV.setEditable(true);
	}
}
