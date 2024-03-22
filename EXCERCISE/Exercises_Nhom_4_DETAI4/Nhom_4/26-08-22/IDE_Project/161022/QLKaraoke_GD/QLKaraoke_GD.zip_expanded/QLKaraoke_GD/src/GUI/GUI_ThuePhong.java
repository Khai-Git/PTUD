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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import Entity.Entity_ChiTietHoaDonDatPhong;
import Entity.Entity_HoaDonDatPhong;
import Entity.Entity_KhachHang;
import Entity.Entity_NhanVien;
import Entity.Entity_Phong;
import Entity.Entity_TaiKhoan;

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

public class GUI_ThuePhong extends JFrame implements ActionListener,MouseListener {

	private JPanel contentPane;
	private JTextField textField_Nsdt;
	private JTextField textField_NCmnd;
	private JTable table;
	private JPanel panel_ThuePhong, panel_TimKiem, panel_KhachHang, panel_TTPhong;
	private JButton btnManHinhChinh,btnDatPhong, btnHoaDon, btnDichVu,btnNhanVien, btnQLPhong, btnKhachHang,btnThongKe,btnTroVe, btnTimKiem, btnThemVao, btnDangXuat;
	private DefaultTableModel tableModel;
	private JLabel lblNewLabel, lblNhanVien, lblSDTKH, lbltimkiemCMND, lblTenKH, lblSDT, lblCMND, lblDiaChi, lblNmaKH, lblNtenKH;
	private JLabel lblNsdt, lblNcmnd, lblNdiachi, lblMaKH,lblTenNhanVien;
	private JLabel lblHinh;
	private JTextField textFieldMaPhong;
	
	private DAO_DatPhong dao_thuephong;
	private DAO_QLPhong dao_qlphong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_ThuePhong frame = new GUI_ThuePhong();
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
	public GUI_ThuePhong() {
		setTitle("Quản lý KARAOKE_NICE");
		
		ConnectDB.getInstance().connect();
		dao_thuephong = new DAO_DatPhong();
		dao_qlphong = new DAO_QLPhong();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("PHẦN MỀM QUẢN LÝ KARAOKE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setBounds(-7, 0, 1367, 86);
		contentPane.add(lblNewLabel);
		
		btnHoaDon = new JButton(" Hóa đơn");
		btnHoaDon.setHorizontalAlignment(SwingConstants.LEFT);
		btnHoaDon.setIcon(new ImageIcon(GUI_ThuePhong.class.getResource("/img/bill_icon1.png")));
		btnHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHoaDon.setBounds(0, 244, 221, 78);
		contentPane.add(btnHoaDon);
		
		btnDichVu = new JButton(" Dịch vụ");
		btnDichVu.setHorizontalAlignment(SwingConstants.LEFT);
		btnDichVu.setIcon(new ImageIcon(GUI_ThuePhong.class.getResource("/img/menu2.png")));
		btnDichVu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDichVu.setBounds(0, 321, 221, 78);
		contentPane.add(btnDichVu);
		
		btnQLPhong = new JButton(" Quản lý phòng");
		btnQLPhong.setHorizontalAlignment(SwingConstants.LEFT);
		btnQLPhong.setIcon(new ImageIcon(GUI_ThuePhong.class.getResource("/img/Science-Plus-Math-icon.png")));
		btnQLPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnQLPhong.setBounds(0, 472, 221, 78);
		contentPane.add(btnQLPhong);
		
		btnNhanVien = new JButton(" Nhân viên");
		btnNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhanVien.setIcon(new ImageIcon(GUI_ThuePhong.class.getResource("/img/black-man-icon.png")));
		btnNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNhanVien.setBounds(0, 396, 221, 78);
		contentPane.add(btnNhanVien);
		
		btnKhachHang = new JButton("  Khách hàng");
		btnKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		btnKhachHang.setIcon(new ImageIcon(GUI_ThuePhong.class.getResource("/img/users-icon.png")));
		btnKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnKhachHang.setBounds(0, 548, 221, 78);
		contentPane.add(btnKhachHang);
		
		btnManHinhChinh = new JButton("M\u00E0n h\u00ECnh ch\u00EDnh");
		btnManHinhChinh.setHorizontalAlignment(SwingConstants.LEFT);
		btnManHinhChinh.setIcon(new ImageIcon(GUI_ThuePhong.class.getResource("/img/home-icon.png")));
		btnManHinhChinh.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnManHinhChinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnManHinhChinh.setBounds(0, 96, 221, 78);
		contentPane.add(btnManHinhChinh);
		
		btnThongKe = new JButton("Thống kê số liệu");
		btnThongKe.setHorizontalAlignment(SwingConstants.LEFT);
		btnThongKe.setIcon(new ImageIcon(GUI_ThuePhong.class.getResource("/img/Dollar-Sign-icon.png")));
		btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThongKe.setBounds(0, 624, 221, 78);
		contentPane.add(btnThongKe);
		
		btnDatPhong = new JButton("Đặt phòng");
		btnDatPhong.setBackground(Color.YELLOW);
		btnDatPhong.setIcon(new ImageIcon(GUI_ThuePhong.class.getResource("/img/Household-Living-Room-icon.png")));
		btnDatPhong.setHorizontalAlignment(SwingConstants.LEFT);
		btnDatPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDatPhong.setBounds(0, 172, 221, 78);
		contentPane.add(btnDatPhong);
		
		lblNhanVien = new JLabel("Nhân viên:");
		lblNhanVien.setBounds(998, 63, 69, 23);
		contentPane.add(lblNhanVien);
		
		btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setBackground(new Color(255, 155, 157));
		btnDangXuat.setBounds(1225, 63, 120, 23);
		contentPane.add(btnDangXuat);
		
		panel_ThuePhong = new JPanel();
		panel_ThuePhong.setBackground(SystemColor.activeCaption);
		panel_ThuePhong.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Thu\u00EA  ph\u00F2ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_ThuePhong.setBounds(224, 97, 1252, 656);
		contentPane.add(panel_ThuePhong);
		panel_ThuePhong.setLayout(null);
		
		panel_TimKiem = new JPanel();
		panel_TimKiem.setBackground(SystemColor.activeCaption);
		panel_TimKiem.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_TimKiem.setBounds(10, 24, 367, 177);
		panel_ThuePhong.add(panel_TimKiem);
		panel_TimKiem.setLayout(null);
		
		lblSDTKH = new JLabel("Số điện thoại:");
		lblSDTKH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSDTKH.setBounds(20, 40, 87, 25);
		panel_TimKiem.add(lblSDTKH);
		
		lbltimkiemCMND = new JLabel("CMND:");
		lbltimkiemCMND.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbltimkiemCMND.setBounds(20, 79, 87, 25);
		panel_TimKiem.add(lbltimkiemCMND);
		
		textField_Nsdt = new JTextField();
		textField_Nsdt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_Nsdt.setBounds(117, 42, 240, 23);
		panel_TimKiem.add(textField_Nsdt);
		textField_Nsdt.setColumns(10);
		
		textField_NCmnd = new JTextField();
		textField_NCmnd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_NCmnd.setColumns(10);
		textField_NCmnd.setBounds(117, 80, 240, 23);
		panel_TimKiem.add(textField_NCmnd);
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBackground(new Color(255, 140, 0));
		btnTimKiem.setBounds(117, 125, 135, 23);
		panel_TimKiem.add(btnTimKiem);
		
		panel_KhachHang = new JPanel();
		panel_KhachHang.setBackground(SystemColor.activeCaption);
		panel_KhachHang.setBorder(new TitledBorder(null, "Kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_KhachHang.setBounds(387, 24, 855, 182);
		panel_ThuePhong.add(panel_KhachHang);
		panel_KhachHang.setLayout(null);
		
		lblMaKH = new JLabel("Mã khách hàng:");
		lblMaKH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaKH.setBounds(74, 27, 97, 27);
		panel_KhachHang.add(lblMaKH);
		
		lblTenKH = new JLabel("Tên khách hàng:");
		lblTenKH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTenKH.setBounds(74, 75, 97, 25);
		panel_KhachHang.add(lblTenKH);
		
		lblSDT = new JLabel("Số điện thoại:");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSDT.setBounds(74, 124, 97, 25);
		panel_KhachHang.add(lblSDT);
		
		lblCMND = new JLabel("CMND:");
		lblCMND.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCMND.setBounds(425, 27, 44, 27);
		panel_KhachHang.add(lblCMND);
		
		lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDiaChi.setBounds(425, 75, 44, 27);
		panel_KhachHang.add(lblDiaChi);
		
		lblNmaKH = new JLabel("");
		lblNmaKH.setBounds(181, 27, 180, 27);
		panel_KhachHang.add(lblNmaKH);
		
		lblNtenKH = new JLabel("");
		lblNtenKH.setBounds(181, 74, 180, 27);
		panel_KhachHang.add(lblNtenKH);
		
		lblNsdt = new JLabel("");
		lblNsdt.setBounds(181, 123, 180, 27);
		panel_KhachHang.add(lblNsdt);
		
		lblNcmnd = new JLabel("");
		lblNcmnd.setBounds(478, 27, 180, 27);
		panel_KhachHang.add(lblNcmnd);
		
		lblNdiachi = new JLabel("");
		lblNdiachi.setBounds(478, 75, 295, 27);
		panel_KhachHang.add(lblNdiachi);
		
		panel_TTPhong = new JPanel();
		panel_TTPhong.setBackground(SystemColor.activeCaption);
		panel_TTPhong.setBorder(new TitledBorder(null, "Th\u00F4ng tin ph\u00F2ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_TTPhong.setBounds(10, 211, 1232, 435);
		panel_ThuePhong.add(panel_TTPhong);
		panel_TTPhong.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 27, 748, 400);
		Box dsP;
		
		panel_TTPhong.add(dsP = Box.createHorizontalBox());
		panel_TTPhong.add(Box.createVerticalStrut(10));
		String [] headers = "Mã phòng; Tên phòng; Loại phòng; Giá phòng; Tình trạng; Sức chứa".split(";");
		tableModel = new DefaultTableModel(headers,0);
		scrollPane.setViewportView(table = new JTable(tableModel));
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPane.setBounds(10, 27, 1210, 330);
		table.setRowHeight(35);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		panel_TTPhong.add(scrollPane);
		
		btnThemVao = new JButton("Thêm vào phiếu thuê phòng");
		btnThemVao.setForeground(new Color(255, 255, 255));
		btnThemVao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnThemVao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThemVao.setBackground(new Color(0, 128, 0));
		btnThemVao.setBounds(903, 368, 257, 50);
		panel_TTPhong.add(btnThemVao);
		
		textFieldMaPhong = new JTextField();
		textFieldMaPhong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldMaPhong.setColumns(10);
		textFieldMaPhong.setBounds(20, 368, 23, 23);
		panel_TTPhong.add(textFieldMaPhong);
		textFieldMaPhong.setVisible(false);
		 
		lblTenNhanVien = new JLabel("");
		lblTenNhanVien.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTenNhanVien.setBounds(1067, 63, 148, 23);
		contentPane.add(lblTenNhanVien);
		
		lblHinh = new JLabel("");
		lblHinh.setIcon(new ImageIcon(GUI_ThuePhong.class.getResource("/img/kara_page-0001.jpg")));
		lblHinh.setBounds(10, 10, 170, 78);
		contentPane.add(lblHinh);
		
		btnTroVe = new JButton("Trở về");
		btnTroVe.setBounds(211, 10, 82, 23);
		contentPane.add(btnTroVe);
		btnTroVe.setForeground(Color.BLACK);
		btnTroVe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnTroVe.setBackground(Color.YELLOW);
		btnTroVe.setVisible(false);
		btnTroVe.addActionListener(this);
		
		//btn.Event
		btnManHinhChinh.addActionListener(this);
		btnDatPhong.addActionListener(this);
		btnKhachHang.addActionListener(this);
		btnNhanVien.addActionListener(this);	
		btnHoaDon.addActionListener(this);
		btnDichVu.addActionListener(this);
		btnThongKe.addActionListener(this);
		btnQLPhong.addActionListener(this);
		btnTimKiem.addActionListener(this);
		btnThemVao.addActionListener(this);
		btnDangXuat.addActionListener(this);
		
		table.addMouseListener(this);
		
		DB_To_Table();
		nv_HienTai();
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnManHinhChinh)) {
			ThuePhong_to_ManHinh();
		}
		if (o.equals(btnDichVu)) {
			ThuePhong_to_DichVu();
		}
		if (o.equals(btnNhanVien)) {
			checkChucVu();
		}
		if (o.equals(btnQLPhong)) {
			ThuePhong_to_Phong();
		}
		if (o.equals(btnKhachHang)) {
			ThuePhong_to_KhachHang();
		}
		if (o.equals(btnThongKe)) {
			ThuePhong_to_ThongKe();
		}
		if (o.equals(btnHoaDon)) {
			ThuePhong_to_HoaDon();
		}
		if (o.equals(btnDatPhong)) {
			ThuePhong_to_QLDatPhong();
		}
		if(o.equals(btnDangXuat)) {
			try {
				DangXuat_Action();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(o.equals(btnThemVao)) {	
				Entity_HoaDonDatPhong thuephong = Them_Action();
				String maP = textFieldMaPhong.getText().toString();
				int hoiNhac = JOptionPane.showConfirmDialog(this,"Có chắc muốn thêm phiếu thuê phòng không?","Thông báo",JOptionPane.YES_NO_OPTION);
				try {
					if(hoiNhac==JOptionPane.YES_OPTION) {
						dao_thuephong.themPhieu(thuephong);
						dao_qlphong.updateTinhTrangPhongSD(maP);
						JOptionPane.showMessageDialog(this, "Thêm phiếu thuê phòng thành công!");
					}
				}catch (Exception e1) {
					// TODO: handle exception
						JOptionPane.showMessageDialog(this,"Error!");
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
		if (o.equals(btnTroVe)) {
			ThuePhong_back();
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
						ThuePhong_to_NhanVien();
					}
				} else {
					JOptionPane.showMessageDialog(this, "Blank");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	private Entity_HoaDonDatPhong Them_Action() {
		String mahd = "HD006";
		String maNv = "NV001";
		String maKh = lblNmaKH.getText().toString();
		String maCthd = "CTHD006";
		String maPhong = textFieldMaPhong.getText().toString();
		int sl = 1;
		int dongiatp = 1;
		DateFormat ngay = new SimpleDateFormat("dd-MM-yyyy");
		DateFormat gio = new SimpleDateFormat("HH:mm");
		Calendar cal = Calendar.getInstance();
		String ngaythue = ngay.format(cal.getTime());
		String gioVao = gio.format(cal.getTime());
		String giora = "";
		double tongGio = 0.0;
		double tongtien = 0.0;		
		
		Entity_Phong phong = new Entity_Phong(maPhong);
		Entity_NhanVien nv = new Entity_NhanVien(maNv);
		Entity_ChiTietHoaDonDatPhong chitiet = new Entity_ChiTietHoaDonDatPhong(maCthd, phong, sl, dongiatp);
		Entity_KhachHang kh = new Entity_KhachHang(maKh);
		
		return new Entity_HoaDonDatPhong(mahd, nv, kh, chitiet, ngaythue, gioVao, giora, tongGio, tongtien);
	}

	private void DangXuat_Action() throws IOException {
		// TODO Auto-generated method stub
		ConnectDB.getInstance().disconnect();
		this.setVisible(false);
		GUI_DangNhap dangNhap = new GUI_DangNhap();
		dangNhap.setVisible(true);
		dangNhap.setLocationRelativeTo(null);
	}

	private void xoaTrangAction() {
		// TODO Auto-generated method stub
    	textField_NCmnd.setText("");
    	textField_Nsdt.setText("");
	}
	
	private void TimKiem_Action() throws SQLException {
		// TODO Auto-generated method stub
		String timKHSDT = textField_Nsdt.getText() == null ? "" : textField_Nsdt.getText().toString().trim();
		String timKHCMND = textField_NCmnd.getText() == null ? "" : textField_NCmnd.getText().toString().trim();
		
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
			lblNsdt.setText(rs.getString(3));
			lblNcmnd.setText(rs.getString(5));
			lblNdiachi.setText(rs.getString(4));
		}
		xoaTrangAction();
	}

	private void ThuePhong_back() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_ThuePhong qldatphong = new GUI_ThuePhong();
		qldatphong.setVisible(true);
		qldatphong.setLocationRelativeTo(null);
	}

	private void ThuePhong_to_QLDatPhong() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_ThuePhong qldatphong = new GUI_ThuePhong();
		qldatphong.setVisible(true);
		qldatphong.setLocationRelativeTo(null);
	}

	private void ThuePhong_to_DichVu() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_QLDichVu dichVu = new GUI_QLDichVu();
		dichVu.setVisible(true);
		dichVu.setLocationRelativeTo(null);
	}

	private void ThuePhong_to_HoaDon() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_HoaDon hoadon = new GUI_HoaDon();
		hoadon.setVisible(true);
		hoadon.setLocationRelativeTo(null);

	}
	private void ThuePhong_to_ThongKe() {
		// TODO Auto-generated method stub
		
	}
	private void ThuePhong_to_KhachHang() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_QLKhachHang khachhanh = new GUI_QLKhachHang();
		khachhanh.setVisible(true);
		khachhanh.setLocationRelativeTo(null);
	}
	private void ThuePhong_to_Phong() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_QLPhong phong = new GUI_QLPhong();
		phong.setVisible(true);
		phong.setLocationRelativeTo(null);
	}
	private void ThuePhong_to_NhanVien() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_QLNhanVien nhanvien = new GUI_QLNhanVien();
		nhanvien.setVisible(true);
		nhanvien.setLocationRelativeTo(null);
	}

	private void ThuePhong_to_ManHinh() {
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
		textFieldMaPhong.setText(tableModel.getValueAt(row, 0).toString());
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
