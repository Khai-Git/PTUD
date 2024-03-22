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



public class GUI_QLDatPhong extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnManHinhChinh,btnDatPhong, btnHoaDon, btnDichVu,btnNhanVien, btnQLPhong, btnKhachHang,btnThongKe,btnNDatPhong,btnNThuePhong, btnDangXuat;
	private JLabel lblTenNhanVien;
	private JLabel lblHinh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_QLDatPhong frame = new GUI_QLDatPhong();
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
	public GUI_QLDatPhong() {
		setTitle("Quản lý KARAOKE_NICE");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnManHinhChinh = new JButton("Màn hình chính");
		btnManHinhChinh.setIcon(new ImageIcon(GUI_QLDatPhong.class.getResource("/img/home-icon.png")));
		btnManHinhChinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnManHinhChinh.setHorizontalAlignment(SwingConstants.LEFT);
		btnManHinhChinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnManHinhChinh.setBounds(0, 97, 225, 78);
		contentPane.add(btnManHinhChinh);
		
		btnDatPhong = new JButton(" Đặt phòng");
		btnDatPhong.setBackground(Color.YELLOW);
		btnDatPhong.setIcon(new ImageIcon(GUI_QLDatPhong.class.getResource("/img/Book_room.jpg")));
		btnDatPhong.setHorizontalAlignment(SwingConstants.LEFT);
		btnDatPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDatPhong.setBounds(0, 173, 225, 78);
		contentPane.add(btnDatPhong);
		
		btnHoaDon = new JButton(" Hóa đơn");
		btnHoaDon.setIcon(new ImageIcon(GUI_QLDatPhong.class.getResource("/img/bill_icon1.png")));
		btnHoaDon.setHorizontalAlignment(SwingConstants.LEFT);
		btnHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHoaDon.setBounds(0, 245, 225, 78);
		contentPane.add(btnHoaDon);
		
		btnDichVu = new JButton(" Dịch vụ");
		btnDichVu.setIcon(new ImageIcon(GUI_QLDatPhong.class.getResource("/img/menu2.png")));
		btnDichVu.setHorizontalAlignment(SwingConstants.LEFT);
		btnDichVu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDichVu.setBounds(0, 322, 225, 78);
		contentPane.add(btnDichVu);
		
		btnNhanVien = new JButton(" Nhân viên");
		btnNhanVien.setIcon(new ImageIcon(GUI_QLDatPhong.class.getResource("/img/black-man-icon.png")));
		btnNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNhanVien.setBounds(0, 397, 225, 78);
		contentPane.add(btnNhanVien);
		
		btnQLPhong = new JButton(" Quản lý phòng");
		btnQLPhong.setIcon(new ImageIcon(GUI_QLDatPhong.class.getResource("/img/Science-Plus-Math-icon.png")));
		btnQLPhong.setHorizontalAlignment(SwingConstants.LEFT);
		btnQLPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnQLPhong.setBounds(0, 473, 225, 78);
		contentPane.add(btnQLPhong);
		
		btnKhachHang = new JButton("  Khách hàng");
		btnKhachHang.setIcon(new ImageIcon(GUI_QLDatPhong.class.getResource("/img/users-icon.png")));
		btnKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		btnKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnKhachHang.setBounds(0, 549, 225, 78);
		contentPane.add(btnKhachHang);
		
		btnThongKe = new JButton("Thống kê số liệu");
		btnThongKe.setIcon(new ImageIcon(GUI_QLDatPhong.class.getResource("/img/Dollar-Sign-icon.png")));
		btnThongKe.setHorizontalAlignment(SwingConstants.LEFT);
		btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThongKe.setBounds(0, 625, 225, 78);
		contentPane.add(btnThongKe);
		
		JLabel lblTitle = new JLabel("PHẦN MỀM QUẢN LÍ KARAOKE");
		lblTitle.setForeground(new Color(0, 0, 0));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblTitle.setBackground(SystemColor.activeCaption);
		lblTitle.setBounds(0, 11, 1474, 86);
		contentPane.add(lblTitle);
		
		JLabel lblNhanVien = new JLabel("Nhân viên : ");
		lblNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNhanVien.setBounds(1123, 74, 59, 23);
		contentPane.add(lblNhanVien);
		
		btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setBackground(new Color(255, 155, 157));
		btnDangXuat.setBounds(1354, 74, 120, 23);
		contentPane.add(btnDangXuat);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Menu Đặt Phòng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setToolTipText("");
		panel.setBounds(237, 97, 1237, 606);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnNDatPhong= new JButton("Đặt Phòng");
		btnNDatPhong.setBounds(118, 377, 243, 68);
		panel.add(btnNDatPhong);
		
		btnNThuePhong = new JButton("Thuê Phòng");
		btnNThuePhong.setBounds(822, 377, 243, 68);
		panel.add(btnNThuePhong);
		
		lblTenNhanVien = new JLabel("");
		lblTenNhanVien.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTenNhanVien.setBounds(1183, 74, 161, 23);
		contentPane.add(lblTenNhanVien);
		
		lblHinh = new JLabel("");
		lblHinh.setIcon(new ImageIcon(GUI_QLDatPhong.class.getResource("/img/kara_page-0001.jpg")));
		lblHinh.setBounds(10, 11, 170, 78);
		contentPane.add(lblHinh);
		
		//btn.Event
		btnManHinhChinh.addActionListener(this);
		btnDatPhong.addActionListener(this);
		btnKhachHang.addActionListener(this);
		btnNhanVien.addActionListener(this);
		btnHoaDon.addActionListener(this);
		btnNDatPhong.addActionListener(this);
		btnNThuePhong.addActionListener(this);
		btnQLPhong.addActionListener(this);
		btnDichVu.addActionListener(this);
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnManHinhChinh)) {
			QLDatPhong_to_ManHinhChinh();
		}
		if (o.equals(btnDatPhong)) {
			QLDatPhong_to_QLDatPhong();
		}
		if (o.equals(btnDichVu)) {
			QLDatPhong_to_DichVu();
		}
		if (o.equals(btnNhanVien)) {
			checkChucVu();
		}
		if (o.equals(btnHoaDon)) {
			QLDatPhong_to_HoaDon();
		}
		if (o.equals(btnQLPhong)) {
			QLDatPhong_to_Phong();
		}
		if (o.equals(btnKhachHang)) {
			QLDatPhong_to_KhachHang();
		}
		if (o.equals(btnThongKe)) {
			QLDatPhong_to_ThongKe();
		}
		if (o.equals(btnNThuePhong)) {
			QLDatPhong_to_ThuePhong();
		}
		if (o.equals(btnNDatPhong)) {
			QLDatPhong_to_NDatPhong();
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
						QLDatPhong_to_NhanVien();
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
	
	private void QLDatPhong_to_QLDatPhong() {
		// TODO Auto-generated method stub
	}
	private void QLDatPhong_to_HoaDon() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_HoaDon hoadon = new GUI_HoaDon();
		hoadon.setVisible(true);
		hoadon.setLocationRelativeTo(null);
	}
	private void QLDatPhong_to_ThuePhong() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_ThuePhong thuePhong = new GUI_ThuePhong();
		thuePhong.setVisible(true);
		thuePhong.setLocationRelativeTo(null);
	}
	private void QLDatPhong_to_NDatPhong() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_DatPhong datphong = new GUI_DatPhong();
		datphong.setVisible(true);
		datphong.setLocationRelativeTo(null);
	}
	private void QLDatPhong_to_ManHinhChinh() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_ManHinhChinh manhinhchinh = new GUI_ManHinhChinh();
		manhinhchinh.setVisible(true);
		manhinhchinh.setLocationRelativeTo(null);
	}
	private void QLDatPhong_to_ThongKe() {
		// TODO Auto-generated method stub
		
	}
	private void QLDatPhong_to_KhachHang() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_QLKhachHang khachhanh = new GUI_QLKhachHang();
		khachhanh.setVisible(true);
		khachhanh.setLocationRelativeTo(null);
	}
	private void QLDatPhong_to_Phong() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_QLPhong phong = new GUI_QLPhong();
		phong.setVisible(true);
		phong.setLocationRelativeTo(null);
		
	}
	private void QLDatPhong_to_NhanVien() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_QLNhanVien nhanvien = new GUI_QLNhanVien();
		nhanvien.setVisible(true);
		nhanvien.setLocationRelativeTo(null);
	}
	private void QLDatPhong_to_DichVu() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_QLDichVu dichVu = new GUI_QLDichVu();
		dichVu.setVisible(true);
		dichVu.setLocationRelativeTo(null);
	}
	
}
