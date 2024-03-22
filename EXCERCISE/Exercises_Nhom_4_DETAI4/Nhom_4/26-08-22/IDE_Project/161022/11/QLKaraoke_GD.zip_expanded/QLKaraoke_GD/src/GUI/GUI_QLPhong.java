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
import java.util.List;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import DAO.DAO_QLPhong;
import Entity.Entity_Phong;
import Entity.Entity_LoaiPhong;

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
import javax.security.auth.RefreshFailedException;
import javax.security.auth.Refreshable;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;


public class GUI_QLPhong extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JTextField textField_NmaP;
	private JTextField textField_NtenP;
	private JTextField textField_NloaiP;
	private JTextField textField_NdonGia;
	private JTable table;
	private JButton btnManHinhChinh,btnDatPhong, btnHoaDon, btnDichVu,btnNhanVien, btnQLPhong, btnKhachHang,btnThongKe, btnLmMiBng;
	private JComboBox comboBox_SucChua, comboBox_TH, comboBox_LP;
	private JButton btnThem, btnXoa, btnSua, btnDangXuat;
	private DAO_QLPhong dao_qlphong;
	private DefaultTableModel tableModel;
	private JLabel lblHinh, lblTenNhanVien;
	private JButton btnLmTrng;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_QLPhong frame = new GUI_QLPhong();
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
	public GUI_QLPhong() {
		setTitle("Quản lý KARAOKE_NICE");
		
		ConnectDB.getInstance().connect();
		dao_qlphong = new DAO_QLPhong();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("PHẦN MỀM QUẢN LÍ KARAOKE");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblTitle.setBounds(-7, 0, 1483, 86);
		contentPane.add(lblTitle);
		
		btnHoaDon = new JButton("Hóa Đơn\r\n");
		btnHoaDon.setHorizontalAlignment(SwingConstants.LEFT);
		btnHoaDon.setIcon(new ImageIcon(GUI_QLPhong.class.getResource("/img/bill_icon1.png")));
		btnHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHoaDon.setBounds(0, 244, 221, 78);
		contentPane.add(btnHoaDon);
		
		btnDichVu = new JButton("Dịch Vụ\r\n");
		btnDichVu.setHorizontalAlignment(SwingConstants.LEFT);
		btnDichVu.setIcon(new ImageIcon(GUI_QLPhong.class.getResource("/img/menu2.png")));
		btnDichVu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDichVu.setBounds(0, 321, 221, 78);
		contentPane.add(btnDichVu);
		
		JButton btnQLPhong = new JButton("Quản Lí Phòng\r\n");
		btnQLPhong.setBackground(Color.YELLOW);
		btnQLPhong.setHorizontalAlignment(SwingConstants.LEFT);
		btnQLPhong.setIcon(new ImageIcon(GUI_QLPhong.class.getResource("/img/Science-Plus-Math-icon.png")));
		btnQLPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnQLPhong.setBounds(0, 472, 221, 78);
		contentPane.add(btnQLPhong);
		
		btnNhanVien = new JButton("Nhân Viên\r\n");
		btnNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhanVien.setIcon(new ImageIcon(GUI_QLPhong.class.getResource("/img/black-man-icon.png")));
		btnNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNhanVien.setBounds(0, 396, 221, 78);
		contentPane.add(btnNhanVien);
		
		btnKhachHang = new JButton("Khách Hàng\r\n");
		btnKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		btnKhachHang.setIcon(new ImageIcon(GUI_QLPhong.class.getResource("/img/users-icon.png")));
		btnKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnKhachHang.setBounds(0, 548, 221, 78);
		contentPane.add(btnKhachHang);
		
		btnManHinhChinh = new JButton("M\u00E0n h\u00ECnh ch\u00EDnh");
		btnManHinhChinh.setHorizontalAlignment(SwingConstants.LEFT);
		btnManHinhChinh.setIcon(new ImageIcon(GUI_QLPhong.class.getResource("/img/home-icon.png")));
		btnManHinhChinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnManHinhChinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnManHinhChinh.setBounds(0, 96, 221, 78);
		contentPane.add(btnManHinhChinh);
		
		btnThongKe = new JButton("Thống Kê");
		btnThongKe.setHorizontalAlignment(SwingConstants.LEFT);
		btnThongKe.setIcon(new ImageIcon(GUI_QLPhong.class.getResource("/img/Dollar-Sign-icon.png")));
		btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThongKe.setBounds(0, 624, 221, 78);
		contentPane.add(btnThongKe);
		
		 btnDangXuat = new JButton("\u0110\u0103ng xu\u1EA5t");
		 btnDangXuat.setBackground(new Color(255, 155, 157));
		btnDangXuat.setBounds(1377, 63, 99, 23);
		contentPane.add(btnDangXuat);
		
		btnDatPhong = new JButton("Đặt Phòng\r\n");
		btnDatPhong.setIcon(new ImageIcon(GUI_QLPhong.class.getResource("/img/Household-Living-Room-icon.png")));
		btnDatPhong.setHorizontalAlignment(SwingConstants.LEFT);
		btnDatPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDatPhong.setBounds(0, 172, 221, 78);
		contentPane.add(btnDatPhong);
		
		JLabel lblNhanVien = new JLabel("Nhân Viên : \r\n\r\n");
		lblNhanVien.setBounds(1046, 63, 80, 23);
		contentPane.add(lblNhanVien);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(224, 97, 1252, 641);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTitle2 = new JLabel("Quản lí phòng");
		lblTitle2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitle2.setBounds(300, 11, 443, 31);
		panel.add(lblTitle2);
		
		JPanel panel_TTPhong = new JPanel();
		panel_TTPhong.setBackground(SystemColor.activeCaption);
		panel_TTPhong.setBorder(new TitledBorder(null, "Th\u00F4ng tin ph\u00F2ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_TTPhong.setBounds(10, 69, 1116, 177);
		panel.add(panel_TTPhong);
		panel_TTPhong.setLayout(null);
		
		JLabel lblMaPHong = new JLabel("Mã phòng\r\n");
		lblMaPHong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaPHong.setBounds(83, 26, 100, 30);
		panel_TTPhong.add(lblMaPHong);
		
		JLabel lblTenPhong = new JLabel("Tên phòng");
		lblTenPhong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTenPhong.setBounds(83, 67, 100, 30);
		panel_TTPhong.add(lblTenPhong);
		
		JLabel lblLoaiPHong = new JLabel("Loại phòng");
		lblLoaiPHong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLoaiPHong.setBounds(83, 110, 100, 30);
		panel_TTPhong.add(lblLoaiPHong);
		
		JLabel lblDonGia = new JLabel("Đơn Giá");
		lblDonGia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDonGia.setBounds(630, 26, 100, 30);
		panel_TTPhong.add(lblDonGia);
		
		JLabel lblSucChua = new JLabel("Sức chứa");
		lblSucChua.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSucChua.setBounds(630, 67, 100, 30);
		panel_TTPhong.add(lblSucChua);
		
		textField_NmaP = new JTextField();
		textField_NmaP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_NmaP.setBounds(170, 29, 330, 25);
		panel_TTPhong.add(textField_NmaP);
		textField_NmaP.setColumns(10);
		
		textField_NtenP = new JTextField();
		textField_NtenP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_NtenP.setColumns(10);
		textField_NtenP.setBounds(170, 70, 330, 25);
		panel_TTPhong.add(textField_NtenP);
		
		textField_NdonGia = new JTextField();
		textField_NdonGia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_NdonGia.setColumns(10);
		textField_NdonGia.setBounds(710, 29, 330, 25);
		panel_TTPhong.add(textField_NdonGia);
		
		comboBox_SucChua = new JComboBox<Integer>();
		comboBox_SucChua.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox_SucChua.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50"}));
		comboBox_SucChua.setBounds(710, 70, 50, 25);
		panel_TTPhong.add(comboBox_SucChua);
		
		JLabel lblTrangThai = new JLabel("Trạng thái");
		lblTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTrangThai.setBounds(627, 113, 61, 25);
		panel_TTPhong.add(lblTrangThai);
		
		 comboBox_TH = new JComboBox();
		comboBox_TH.setModel(new DefaultComboBoxModel(new String[] {"Trống", "Đang sử dụng"}));
		comboBox_TH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox_TH.setBounds(710, 115, 127, 25);
		panel_TTPhong.add(comboBox_TH);

		 comboBox_LP = new JComboBox();
		comboBox_LP.setModel(new DefaultComboBoxModel(new String[] {"Vip", "Thường"}));
		comboBox_LP.setBounds(170, 115, 73, 25);
		panel_TTPhong.add(comboBox_LP);
		
		btnThem = new JButton("Thêm phòng");
		btnThem.setIcon(new ImageIcon(GUI_QLPhong.class.getResource("/img/add-icon_room.png")));
		btnThem.setForeground(Color.BLACK);
		btnThem.setBackground(Color.GREEN);
		btnThem.setBounds(610, 257, 150, 40);
		panel.add(btnThem);
		
		 btnXoa = new JButton("Xóa phòng");
		btnXoa.setIcon(new ImageIcon(GUI_QLPhong.class.getResource("/img/Remove-icon_room.png")));
		btnXoa.setForeground(Color.BLACK);
		btnXoa.setBackground(new Color(220, 20, 60));
		btnXoa.setBounds(770, 257, 150, 40);
		panel.add(btnXoa);

		 btnSua = new JButton("Sửa thông tin");
		btnSua.setIcon(new ImageIcon(GUI_QLPhong.class.getResource("/img/cog-edit-icon.png")));
		btnSua.setForeground(Color.BLACK);
		btnSua.setBackground(new Color(255, 140, 0));
		btnSua.setBounds(930, 257, 150, 40);
		panel.add(btnSua);
		
		JPanel panel_DSPhong = new JPanel();
		panel_DSPhong.setBackground(SystemColor.activeCaption);
		panel_DSPhong.setBorder(new TitledBorder(null, "Danh s\u00E1ch ph\u00F2ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_DSPhong.setBounds(10, 316, 1232, 314);
		panel.add(panel_DSPhong);
		panel_DSPhong.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 1212, 283);
		panel_DSPhong.add(scrollPane);
		
		String header [] = {"Mã Phòng", "Tên phòng", "Loại phòng", "Đơn giá", "Sức chứa", "Trạng thái"};
		tableModel = new DefaultTableModel(header, 0);
		JScrollPane scroll = new JScrollPane(table = new JTable(tableModel));
		table.setRowHeight(35);
		scrollPane.setViewportView(table);
		
		btnLmMiBng = new JButton("Làm mới bảng");
		btnLmMiBng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLmMiBng.setForeground(Color.BLACK);
		btnLmMiBng.setBackground(new Color(255, 140, 0));
		btnLmMiBng.setBounds(20, 257, 150, 40);
		panel.add(btnLmMiBng);
		
		btnLmTrng = new JButton("Làm trống");
		btnLmTrng.setForeground(Color.BLACK);
		btnLmTrng.setBackground(new Color(171, 211, 211));
		btnLmTrng.setBounds(431, 257, 150, 40);
		panel.add(btnLmTrng);
		
		lblTenNhanVien = new JLabel("");
		lblTenNhanVien.setBounds(1113, 60, 221, 29);
		contentPane.add(lblTenNhanVien);
		
		lblHinh = new JLabel("");
		lblHinh.setIcon(new ImageIcon(GUI_QLPhong.class.getResource("/img/kara_page-0001.jpg")));
		lblHinh.setBounds(10, 8, 170, 78);
		contentPane.add(lblHinh);
		table.getColumnModel().getColumn(0).setPreferredWidth(90);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
		//btn.Event
		btnManHinhChinh.addActionListener(this);
		btnDatPhong.addActionListener(this);
		btnKhachHang.addActionListener(this);
		btnDichVu.addActionListener(this);
		btnNhanVien.addActionListener(this);	
		btnHoaDon.addActionListener(this);
		btnThem.addActionListener(this);
		btnDangXuat.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnLmMiBng.addActionListener(this);
		btnLmTrng.addActionListener(this);
		table.addMouseListener(this);
		comboBox_LP.addActionListener(this);
		
		nv_HienTai();
		docDuLieuVaoTable();
		
		int countPT = 0;
		int countPV = 0;

		if (comboBox_LP.getSelectedItem() == "Vip") {
			for (int i = 0; i < table.getRowCount(); i++) {
				String maP = table.getValueAt(i, 0).toString(); 
				if (maP.matches("^(PV)\\d{3}$")) {
					countPV++;
				}
			}
			
			countPV++;
			textField_NmaP.setText("PV0" + countPV);
		}
		if (comboBox_LP.getSelectedItem() != "Vip") {
			for (int i = 0; i < table.getRowCount(); i++) {
				String maP = table.getValueAt(i, 0).toString(); 
				if (maP.matches("^(PT)\\d{3}$")) {
					countPT++;
				}
			}
			
			countPT++;
			textField_NmaP.setText("PT0" + countPT);
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
				ResultSet rs = stmt.executeQuery(sql);
					
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
						QLPhong_to_NhanVien();
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
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();		
		
		if (o.equals(table)) {
			int row = table.getSelectedRow();
			
			textField_NmaP.setText(tableModel.getValueAt(row, 0).toString());
			textField_NtenP.setText(tableModel.getValueAt(row, 1).toString());
			comboBox_LP.setSelectedItem(tableModel.getValueAt(row, 2).toString());
			textField_NdonGia.setText(tableModel.getValueAt(row, 3).toString());
			comboBox_SucChua.setSelectedItem(tableModel.getValueAt(row, 4).toString());
			comboBox_TH.setSelectedItem(tableModel.getValueAt(row, 5).toString());
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if (o.equals(btnManHinhChinh)) {
			QLPhong_to_ManHinh();
		}
		if (o.equals(btnDichVu)) {
			QLPhong_to_DichVu();
		}
		if (o.equals(btnNhanVien)) {
			checkChucVu();
		}
		if (o.equals(btnQLPhong)) {
			QLPhong_to_Phong();
		}
		if (o.equals(btnKhachHang)) {
			QLPhong_to_KhachHang();
		}
		if (o.equals(btnThongKe)) {
			QLPhong_to_ThongKe();
		}
		if (o.equals(btnHoaDon)) {
			QLPhong_to_HoaDon();
		}
		if (o.equals(btnDatPhong)) {
			QLPhong_to_QLDatPhong();
		}
		if(o.equals(btnThem)) {
			if(validData()) {
				Entity_Phong qlphong = revertFromTextField();
				int hoiNhac = JOptionPane.showConfirmDialog(this,"Có chắc muốn thêm vào danh sách phòng không?","Thông báo",JOptionPane.YES_NO_OPTION);
				try {
					if(hoiNhac==JOptionPane.YES_OPTION) {
						dao_qlphong.createPhong(qlphong);
						tableModel.addRow(new Object[] {qlphong.getMaPhong(), qlphong.getTenPhong(), qlphong.getTenLoai(), qlphong.getDonGia(), qlphong.getSucChua(), qlphong.getTrangThai()});
						JOptionPane.showMessageDialog(this, "Thêm phòng thành công !!!");
					}
				}catch (Exception e1) {
					// TODO: handle exception
						JOptionPane.showMessageDialog(this,"Trùng mã phòng, Xác nhận");
				}
			}	
		}
		if(o.equals(btnXoa)) {
			deletePhong();
		}
		if(o.equals(btnSua)) {
			suaThongTin();
		}
		if(o.equals(btnDangXuat)) {
			try {
				DN_GUI();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (o.equals(btnLmMiBng)) {
			docDuLieuVaoTable();
		}
		if (o.equals(btnLmTrng)) {
			xoaTrangAction();
		}
	}
	
	private void xoaTrangAction() {
		// TODO Auto-generated method stub
		textField_NmaP.setText("");
		textField_NmaP.setEditable(true);
		textField_NtenP.setText("");
		textField_NdonGia.setText("");
		comboBox_SucChua.setSelectedIndex(0);
		comboBox_LP.setSelectedIndex(0);
		comboBox_TH.setSelectedIndex(0);
	}

	public void docDuLieuVaoTable() {
		//Xóa dữ liệu bảng tạm thời
		DefaultTableModel dTableModel = (DefaultTableModel) table.getModel();
		dTableModel.getDataVector().removeAllElements();
		
		DAO_QLPhong p = new DAO_QLPhong();
		List<Entity_Phong> list = p.getallPhong();
		
		for (Entity_Phong l : list) {		
			String []  rowData = {l.getMaPhong(), l.getTenPhong(), l.getTenLoai(), l.getDonGia()+"", l.getSucChua()+"", l.getTrangThai()};
			tableModel.addRow(rowData);
		}
		table.setModel(tableModel);
	}
	
	private void deletePhong() {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		if(row >= 0) {
			String maPhong = (String) table.getValueAt(row, 0);
			if(dao_qlphong.delete(maPhong)) {
				tableModel.removeRow(row);
				clearAction();
				JOptionPane.showMessageDialog(this, "Xóa phòng thành công !!!");
			}
		}
	}

	private void suaThongTin() {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		String maPhong = textField_NmaP.getText().toString();
		String tenPhong = textField_NtenP.getText().toString();
		String tenLoai = comboBox_LP.getSelectedItem().toString();
		double donGia = Double.parseDouble(textField_NdonGia.getText());
		int sucChua = Integer.parseInt(comboBox_SucChua.getSelectedItem().toString());
		String trangThai = comboBox_TH.getSelectedItem().toString();
		Entity_Phong p = new  Entity_Phong(maPhong,tenPhong,sucChua,tenLoai,donGia,trangThai);
		if(row >= 0) {
			if(dao_qlphong.update(p)) {
				table.setValueAt(textField_NmaP.getText(), row, 0);
				table.setValueAt(textField_NtenP.getText(), row, 1);
				table.setValueAt(comboBox_LP.getSelectedItem().toString(), row, 2);
				table.setValueAt(textField_NdonGia.getText(), row, 3);
				table.setValueAt(comboBox_SucChua.getSelectedItem().toString(), row, 4);
				table.setValueAt(comboBox_TH.getSelectedItem().toString(), row, 5);
				clearAction();
				JOptionPane.showMessageDialog(this, "Cập nhật phòng thành công !!!");
			}
		}
	}
	
	public void clearAction() {
		textField_NmaP.setText("");
		textField_NtenP.setText("");
		textField_NdonGia.setText("");
		textField_NmaP.setEditable(true);
	}

	private Entity_Phong revertFromTextField() {
		// TODO Auto-generated method stub
		String maPhong = textField_NmaP.getText();
		String tenPhong = textField_NtenP.getText();
		String tenLoai = comboBox_LP.getSelectedItem().toString();
		int donGia = Integer.parseInt(textField_NdonGia.getText());
		int sucChua = Integer.parseInt(comboBox_SucChua.getSelectedItem().toString());
		String trangThai = comboBox_TH.getSelectedItem().toString();
		
		return new Entity_Phong(maPhong,tenPhong,sucChua,tenLoai,donGia,trangThai);
	}

	private boolean validData() {
		String maPhong = textField_NmaP.getText().trim();
		String tenPhong = textField_NtenP.getText().trim();
		double donGia = Double.parseDouble(textField_NdonGia.getText().trim());
		String tenLoai = (String) comboBox_LP.getSelectedItem();
		
		if(!(maPhong.length() > 0 && maPhong.matches("^(PT|PV)\\d{3}$"))) {
			JOptionPane.showMessageDialog(this, "Nhập sai định dạng! Mã bắt đầu bằng PT hoặc PV + 3 số");
			textField_NmaP.requestFocus();
			return false;
		}
		
		if(maPhong.matches("PT\\d{3}") && !(tenLoai.compareTo("Thường") == 0)) {
				JOptionPane.showMessageDialog(this, "Lỗi! Mã phòng là 'PT' thì loại phòng là 'Thường'");
				textField_NmaP.requestFocus();
				return false;
		} else if(maPhong.matches("PV\\d{3}") && !(tenLoai.compareTo("Vip") == 0)) {
				JOptionPane.showMessageDialog(this, "Lỗi! Mã phòng là 'PV' thì loại phòng là 'Vip'");
				textField_NmaP.requestFocus();
				return false;
		}
		
				
		if(!(tenPhong.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Không được để trống!");
			textField_NtenP.requestFocus();
			return false;
		}
		
		return true;
	}
	private void DN_GUI() throws IOException {
		ConnectDB.getInstance().disconnect();
		this.setVisible(false);
		GUI_DangNhap dangNhap = new GUI_DangNhap();
		dangNhap.setVisible(true);
		dangNhap.setLocationRelativeTo(null);
	}
	private void QLPhong_to_QLDatPhong() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_ThuePhong qldatphong = new GUI_ThuePhong();
		qldatphong.setVisible(true);
		qldatphong.setLocationRelativeTo(null);
	}

	private void QLPhong_to_DichVu() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_QLDichVu dichvu = new GUI_QLDichVu();
		dichvu.setVisible(true);
		dichvu.setLocationRelativeTo(null);
	}

	private void QLPhong_to_HoaDon() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_HoaDon hoadon = new GUI_HoaDon();
		hoadon.setVisible(true);
		hoadon.setLocationRelativeTo(null);
	}
	private void QLPhong_to_ThongKe() {
		// TODO Auto-generated method stub
		
	}
	private void QLPhong_to_KhachHang() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_QLKhachHang khachhanh = new GUI_QLKhachHang();
		khachhanh.setVisible(true);
		khachhanh.setLocationRelativeTo(null);
		
	}
	private void QLPhong_to_Phong() {
		// TODO Auto-generated method stub
		
	}
	private void QLPhong_to_NhanVien() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_QLNhanVien nhanvien = new GUI_QLNhanVien();
		nhanvien.setVisible(true);
		nhanvien.setLocationRelativeTo(null);
	}
	
	private void QLPhong_to_ManHinh() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_ManHinhChinh manhinhchinh = new GUI_ManHinhChinh();
		manhinhchinh.setVisible(true);
		manhinhchinh.setLocationRelativeTo(null);
	}
}
