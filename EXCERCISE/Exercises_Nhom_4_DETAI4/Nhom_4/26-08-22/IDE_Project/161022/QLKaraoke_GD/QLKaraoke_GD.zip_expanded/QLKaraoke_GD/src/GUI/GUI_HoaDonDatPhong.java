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
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ConnectDB.ConnectDB;

import javax.swing.JScrollPane;
import java.awt.TextField;
import javax.swing.border.EtchedBorder;

public class GUI_HoaDonDatPhong extends JFrame implements ActionListener,MouseListener {

	private JPanel contentPane;
	private JTextField txtNhpTnPhng;
	private JTable table_1;
	private JTable table;
	private JButton btnManHinhChinh, btnDatPhong, btnHoaDon, btnDichVu,btnNhanVien, btnQLPhong, btnKhachHang,btnThongKe, btnTroVe, btnDangXuat;
	private JLabel lblTenNhanVien;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_HoaDonDatPhong frame = new GUI_HoaDonDatPhong();
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
	public GUI_HoaDonDatPhong() {
		setTitle("Quản lý KARAOKE_NICE");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnManHinhChinh = new JButton("Màn hình chính");
		btnManHinhChinh.setIcon(new ImageIcon(GUI_HoaDonDatPhong.class.getResource("/img/home-icon.png")));
		btnManHinhChinh.setHorizontalAlignment(SwingConstants.LEFT);
		btnManHinhChinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnManHinhChinh.setBounds(0, 97, 225, 78);
		contentPane.add(btnManHinhChinh);
		
		btnDatPhong = new JButton(" Đặt phòng");
		btnDatPhong.setIcon(new ImageIcon(GUI_HoaDonDatPhong.class.getResource("/img/Book_room.jpg")));
		btnDatPhong.setHorizontalAlignment(SwingConstants.LEFT);
		btnDatPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDatPhong.setBounds(0, 173, 225, 78);
		contentPane.add(btnDatPhong);
		
		btnHoaDon = new JButton(" Hóa đơn");
		btnHoaDon.setBackground(Color.YELLOW);
		btnHoaDon.setIcon(new ImageIcon(GUI_HoaDonDatPhong.class.getResource("/img/bill_icon1.png")));
		btnHoaDon.setHorizontalAlignment(SwingConstants.LEFT);
		btnHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHoaDon.setBounds(0, 245, 225, 78);
		contentPane.add(btnHoaDon);
		
		btnDichVu = new JButton(" Dịch vụ");
		btnDichVu.setIcon(new ImageIcon(GUI_HoaDonDatPhong.class.getResource("/img/menu2.png")));
		btnDichVu.setHorizontalAlignment(SwingConstants.LEFT);
		btnDichVu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDichVu.setBounds(0, 322, 225, 78);
		contentPane.add(btnDichVu);
		
		btnNhanVien = new JButton(" Nhân viên");
		btnNhanVien.setIcon(new ImageIcon(GUI_HoaDonDatPhong.class.getResource("/img/black-man-icon.png")));
		btnNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNhanVien.setBounds(0, 397, 225, 78);
		contentPane.add(btnNhanVien);
		
		JButton btnQLyPhong = new JButton(" Quản lý phòng");
		btnQLyPhong.setIcon(new ImageIcon(GUI_HoaDonDatPhong.class.getResource("/img/Science-Plus-Math-icon.png")));
		btnQLyPhong.setHorizontalAlignment(SwingConstants.LEFT);
		btnQLyPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnQLyPhong.setBounds(0, 473, 225, 78);
		contentPane.add(btnQLyPhong);
		
		btnKhachHang = new JButton("  Khách hàng");
		btnKhachHang.setIcon(new ImageIcon(GUI_HoaDonDatPhong.class.getResource("/img/users-icon.png")));
		btnKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		btnKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnKhachHang.setBounds(0, 549, 225, 78);
		contentPane.add(btnKhachHang);
		
		btnThongKe = new JButton("Thống kê số liệu");
		btnThongKe.setIcon(new ImageIcon(GUI_HoaDonDatPhong.class.getResource("/img/Dollar-Sign-icon.png")));
		btnThongKe.setHorizontalAlignment(SwingConstants.LEFT);
		btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThongKe.setBounds(0, 625, 225, 78);
		contentPane.add(btnThongKe);
		
		JLabel lblTitle = new JLabel("PHẦN MỀM QUẢN LÝ KARAOKE");
		lblTitle.setForeground(new Color(0, 0, 0));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblTitle.setBackground(SystemColor.activeCaption);
		lblTitle.setBounds(0, 11, 1474, 86);
		contentPane.add(lblTitle);
		
		JLabel lblNhanVien = new JLabel("Nhân viên : ");
		lblNhanVien.setBounds(1135, 74, 79, 23);
		contentPane.add(lblNhanVien);
		
		btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setBackground(new Color(255, 155, 157));
		btnDangXuat.setBounds(1354, 74, 120, 23);
		contentPane.add(btnDangXuat);
		
		JPanel panelHoaDonTP = new JPanel();
		panelHoaDonTP.setBackground(SystemColor.activeCaption);
		panelHoaDonTP.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "H\u00F3a \u0111\u01A1n \u0111\u1EB7t ph\u00F2ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelHoaDonTP.setToolTipText("");
		panelHoaDonTP.setBounds(237, 97, 1237, 606);
		contentPane.add(panelHoaDonTP);
		panelHoaDonTP.setLayout(null);
		
		btnTroVe = new JButton("Trở về");
		btnTroVe.setHorizontalAlignment(SwingConstants.LEFT);
		btnTroVe.setIcon(new ImageIcon(GUI_HoaDonDatPhong.class.getResource("/img/back-icon1.png")));
		btnTroVe.setBackground(Color.ORANGE);
		btnTroVe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTroVe.setBounds(10, 21, 96, 32);
		panelHoaDonTP.add(btnTroVe);
		
		txtNhpTnPhng = new JTextField();
		txtNhpTnPhng.setToolTipText("Nhập tên phòng");
		txtNhpTnPhng.setForeground(Color.LIGHT_GRAY);
		txtNhpTnPhng.setText("Phòng");
		txtNhpTnPhng.setBounds(115, 95, 235, 20);
		panelHoaDonTP.add(txtNhpTnPhng);
		txtNhpTnPhng.setColumns(10);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBackground(Color.YELLOW);
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTimKiem.setBounds(380, 86, 117, 32);
		panelHoaDonTP.add(btnTimKiem);
		
		JPanel panel_DSThuePhong = new JPanel();
		panel_DSThuePhong.setBackground(SystemColor.activeCaption);
		panel_DSThuePhong.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch \u0111\u1EB7t ph\u00F2ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_DSThuePhong.setBounds(10, 129, 574, 466);
		panelHoaDonTP.add(panel_DSThuePhong);
		panel_DSThuePhong.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 31, 535, 365);
		panel_DSThuePhong.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setBorder(null);
		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 phi\u1EBFu thu\u00EA", "T\u00EAn kh\u00E1ch h\u00E0ng", "S\u0110T", "T\u00EAn ph\u00F2ng", "Ng\u00E0y l\u1EADp"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JButton btnSuaPhieu = new JButton("Sửa phiếu đặt\r\n\r\n");
		btnSuaPhieu.setIcon(new ImageIcon(GUI_HoaDonDatPhong.class.getResource("/img/cog-edit-icon.png")));
		btnSuaPhieu.setBackground(new Color(255, 165, 0));
		btnSuaPhieu.setBounds(310, 412, 154, 30);
		panel_DSThuePhong.add(btnSuaPhieu);
		
		JButton btnHuy = new JButton("Hủy\r\n");
		btnHuy.setIcon(new ImageIcon(GUI_HoaDonDatPhong.class.getResource("/img/x-icon.png")));
		btnHuy.setBackground(Color.RED);
		btnHuy.setBounds(474, 412, 86, 30);
		panel_DSThuePhong.add(btnHuy);
		
		JPanel panel_CTHoaDon = new JPanel();
		panel_CTHoaDon.setBackground(SystemColor.activeCaption);
		panel_CTHoaDon.setBorder(new TitledBorder(null, "Chi ti\u1EBFt h\u00F3a \u0111\u01A1n ph\u00F2ng h\u00E1t", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_CTHoaDon.setBounds(640, 21, 587, 574);
		panelHoaDonTP.add(panel_CTHoaDon);
		panel_CTHoaDon.setLayout(null);
		
		JLabel lblTitle_2 = new JLabel("Hóa đơn đặt phòng");
		lblTitle_2.setForeground(new Color(0, 0, 0));
		lblTitle_2.setBackground(SystemColor.activeCaption);
		lblTitle_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitle_2.setBounds(85, 21, 443, 31);
		panel_CTHoaDon.add(lblTitle_2);
		
		JLabel lblTenKH = new JLabel("Tên KH : ");
		lblTenKH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenKH.setBounds(85, 107, 54, 23);
		panel_CTHoaDon.add(lblTenKH);
		
		JLabel lblSDT = new JLabel("SĐT:\r\n");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSDT.setBounds(358, 107, 35, 23);
		panel_CTHoaDon.add(lblSDT);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 151, 577, 371);
		panel_CTHoaDon.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 H\u0110", "T\u00EAn h\u00F3a \u0111\u01A1n", "Lo\u1EA1i ph\u00F2ng", "Gi\u1EDD v\u00E0o", "Gi\u1EDD ra", "Gi\u00E1 ti\u1EC1n", "VAT", "Ng\u00E0y l\u1EADp"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Object.class, Double.class, Double.class, Double.class, Float.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JButton btnXuat = new JButton("Xuất hóa đơn\r\n");
		btnXuat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXuat.setIcon(new ImageIcon(GUI_HoaDonDatPhong.class.getResource("/img/Invoice-icon.png")));
		btnXuat.setBackground(new Color(0, 255, 0));
		btnXuat.setBounds(242, 533, 164, 30);
		panel_CTHoaDon.add(btnXuat);
		
		JLabel lblNtenKH = new JLabel("");
		lblNtenKH.setBounds(152, 107, 178, 23);
		panel_CTHoaDon.add(lblNtenKH);
		
		JLabel lblNsdt = new JLabel("");
		lblNsdt.setBounds(418, 107, 148, 23);
		panel_CTHoaDon.add(lblNsdt);
		
		JButton btnIcon = new JButton("Icon");
		btnIcon.setIcon(new ImageIcon(GUI_HoaDonDatPhong.class.getResource("/img/Next-2-icon.png")));
		btnIcon.setBounds(591, 255, 51, 109);
		panelHoaDonTP.add(btnIcon);
		
		lblTenNhanVien = new JLabel("");
		lblTenNhanVien.setBounds(1203, 72, 145, 25);
		contentPane.add(lblTenNhanVien);
		
		JLabel lblHinh = new JLabel("");
		lblHinh.setIcon(new ImageIcon(GUI_HoaDonDatPhong.class.getResource("/img/kara_page-0001.jpg")));
		lblHinh.setBounds(10, 9, 170, 78);
		contentPane.add(lblHinh);
		table_1.getColumnModel().getColumn(0).setPreferredWidth(83);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(68);
		
		//btn.Event
		btnManHinhChinh.addActionListener(this);
		btnDatPhong.addActionListener(this);
		btnKhachHang.addActionListener(this);
		btnNhanVien.addActionListener(this);
		btnDichVu.addActionListener(this);
		btnThongKe.addActionListener(this);
		btnTroVe.addActionListener(this);
		btnDangXuat.addActionListener(this);
		
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
						HDDP_to_NhanVien();
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnManHinhChinh)) {
			HDDP_to_ManHinhChinh();
		}// btnManHinhChinh, btnDatPhong, btnHoaDon, btnDichVu,btnNhanVien, btnQLPhong, btnKhachHang,btnThongKe
		if (o.equals(btnDatPhong)) {
			HDDP_to_DatPhong();
		}
		if (o.equals(btnDichVu)) {
			HDDP_to_DichVu();
		}
		if (o.equals(btnNhanVien)) {
			checkChucVu();
		}
		if (o.equals(btnQLPhong)) {
			HDDP_to_Phong();
		}
		if (o.equals(btnKhachHang)) {
			HDDP_to_KhachHang();
		}
		if (o.equals(btnThongKe)) {
			HDDP_to_ThongKe();
		}
		if(o.equals(btnHoaDon)) {
			HDDP_to_HoaDon();
		}
		if (o.equals(btnTroVe)) {
			HDDP_back();
		}
	}

	private void HDDP_to_HoaDon() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_HoaDon hoadon = new GUI_HoaDon();
		hoadon.setVisible(true);
		hoadon.setLocationRelativeTo(null);
	}

	private void HDDP_back() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_HoaDon hoadon = new GUI_HoaDon();
		hoadon.setVisible(true);
		hoadon.setLocationRelativeTo(null);
	}

	private void HDDP_to_ThongKe() {
		// TODO Auto-generated method stub

	}

	private void HDDP_to_KhachHang() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_QLKhachHang khachhanh = new GUI_QLKhachHang();
		khachhanh.setVisible(true);
		khachhanh.setLocationRelativeTo(null);
	}

	private void HDDP_to_Phong() {
		// TODO Auto-generated method stub
		GUI_QLPhong phong = new GUI_QLPhong();
		this.setVisible(false);
		phong.setVisible(true);
		phong.setLocationRelativeTo(null);
	}

	private void HDDP_to_NhanVien() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_QLNhanVien nhanvien = new GUI_QLNhanVien();
		nhanvien.setVisible(true);
		nhanvien.setLocationRelativeTo(null);
	}

	private void HDDP_to_DichVu() {
		// TODO Auto-generated method stub
		
	}

	private void HDDP_to_DatPhong() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_ThuePhong qldatphong = new GUI_ThuePhong();
		qldatphong.setVisible(true);
		qldatphong.setLocationRelativeTo(null);
	}
	private void HDDP_to_ManHinhChinh() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_ManHinhChinh manhinhchinh = new GUI_ManHinhChinh();
		manhinhchinh.setVisible(true);
		manhinhchinh.setLocationRelativeTo(null);
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
