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
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ConnectDB.ConnectDB;
import DAO.DAO_NhanVien;
import Entity.Entity_NhanVien;

import javax.swing.JScrollPane;
import java.awt.TextField;
import javax.swing.border.EtchedBorder;



public class GUI_ManHinhChinh extends JFrame implements ActionListener {

	private JPanel panelManHinhChinh, contentPane;
	private JButton btnManHinhChinh,btnDatPhong, btnHoaDon, btnDichVu,btnNhanVien, btnQLPhong, btnKhachHang,btnThongKe, btnDangXuat;
	private JLabel lblTenNhanVien, lblNhanVien, lblNewLabel;
	private JLabel lblHinh;
	private JLabel lblThanhVien;
	private JLabel lblThanhVien1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_ManHinhChinh frame = new GUI_ManHinhChinh();
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
	public GUI_ManHinhChinh() {
		setTitle("Quản lý KARAOKE_NICE");
		ConnectDB.getInstance().connect();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnManHinhChinh = new JButton("Màn hình chính");
		btnManHinhChinh.setBackground(Color.YELLOW);
		btnManHinhChinh.setIcon(new ImageIcon(GUI_ManHinhChinh.class.getResource("/img/home-icon.png")));
		btnManHinhChinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnManHinhChinh.setHorizontalAlignment(SwingConstants.LEFT);
		btnManHinhChinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnManHinhChinh.setBounds(0, 97, 225, 78);
		contentPane.add(btnManHinhChinh);
		
		btnDatPhong = new JButton(" Đặt phòng");
		btnDatPhong.setIcon(new ImageIcon(GUI_ManHinhChinh.class.getResource("/img/Book_room.jpg")));
		btnDatPhong.setHorizontalAlignment(SwingConstants.LEFT);
		btnDatPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDatPhong.setBounds(0, 173, 225, 78);
		contentPane.add(btnDatPhong);
		
		btnHoaDon = new JButton(" Hóa đơn");
		btnHoaDon.setIcon(new ImageIcon(GUI_ManHinhChinh.class.getResource("/img/bill_icon1.png")));
		btnHoaDon.setHorizontalAlignment(SwingConstants.LEFT);
		btnHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHoaDon.setBounds(0, 245, 225, 78);
		contentPane.add(btnHoaDon);
		
		btnDichVu = new JButton(" Dịch vụ");
		btnDichVu.setIcon(new ImageIcon(GUI_ManHinhChinh.class.getResource("/img/menu2.png")));
		btnDichVu.setHorizontalAlignment(SwingConstants.LEFT);
		btnDichVu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDichVu.setBounds(0, 322, 225, 78);
		contentPane.add(btnDichVu);
		
		btnNhanVien = new JButton(" Nhân viên");
		btnNhanVien.setIcon(new ImageIcon(GUI_ManHinhChinh.class.getResource("/img/black-man-icon.png")));
		btnNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNhanVien.setBounds(0, 397, 225, 78);
		contentPane.add(btnNhanVien);
		
		btnQLPhong = new JButton(" Quản lý phòng");
		btnQLPhong.setIcon(new ImageIcon(GUI_ManHinhChinh.class.getResource("/img/Science-Plus-Math-icon.png")));
		btnQLPhong.setHorizontalAlignment(SwingConstants.LEFT);
		btnQLPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnQLPhong.setBounds(0, 473, 225, 78);
		contentPane.add(btnQLPhong);
		
		btnKhachHang = new JButton("  Khách hàng");
		btnKhachHang.setIcon(new ImageIcon(GUI_ManHinhChinh.class.getResource("/img/users-icon.png")));
		btnKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		btnKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnKhachHang.setBounds(0, 549, 225, 78);
		contentPane.add(btnKhachHang);
		
		btnThongKe = new JButton("Thống kê số liệu");
		btnThongKe.setIcon(new ImageIcon(GUI_ManHinhChinh.class.getResource("/img/Dollar-Sign-icon.png")));
		btnThongKe.setHorizontalAlignment(SwingConstants.LEFT);
		btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThongKe.setBounds(0, 625, 225, 78);
		contentPane.add(btnThongKe);
		
		lblNewLabel = new JLabel("PHẦN MỀM QUẢN LÝ KARAOKE");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setBackground(SystemColor.activeCaption);
		lblNewLabel.setBounds(0, 11, 1474, 86);
		contentPane.add(lblNewLabel);
		
		lblNhanVien = new JLabel("Nhân viên:");
		lblNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNhanVien.setBounds(1139, 74, 59, 23);
		contentPane.add(lblNhanVien);
		
		btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setBackground(new Color(255, 155, 157));
		btnDangXuat.setBounds(1354, 74, 120, 23);
		contentPane.add(btnDangXuat);
		
		panelManHinhChinh = new JPanel();
		panelManHinhChinh.setBackground(SystemColor.activeCaption);
		panelManHinhChinh.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Màn hình chính", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelManHinhChinh.setToolTipText("");
		panelManHinhChinh.setBounds(237, 97, 1237, 606);
		contentPane.add(panelManHinhChinh);
		panelManHinhChinh.setLayout(null);
		
		JLabel lblHinh_1 = new JLabel("");
		lblHinh_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHinh_1.setIcon(new ImageIcon(GUI_ManHinhChinh.class.getResource("/img/1215_435.jpg")));
		lblHinh_1.setBounds(10, 22, 1217, 435);
		panelManHinhChinh.add(lblHinh_1);
		
		lblThanhVien = new JLabel("Thành viên nhóm:");
		lblThanhVien.setHorizontalAlignment(SwingConstants.CENTER);
		lblThanhVien.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblThanhVien.setBounds(484, 468, 202, 23);
		panelManHinhChinh.add(lblThanhVien);
		
		lblThanhVien1 = new JLabel("1. Đặng Phạm Thiên Khải");
		lblThanhVien1.setHorizontalAlignment(SwingConstants.LEFT);
		lblThanhVien1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblThanhVien1.setBounds(484, 496, 202, 23);
		panelManHinhChinh.add(lblThanhVien1);
		
		JLabel lblThanhVien2 = new JLabel("2. Trần Hữu Nhã");
		lblThanhVien2.setHorizontalAlignment(SwingConstants.LEFT);
		lblThanhVien2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblThanhVien2.setBounds(484, 520, 202, 23);
		panelManHinhChinh.add(lblThanhVien2);
		
		JLabel lblThanhVien3 = new JLabel("3. Trần Nguyễn Hoàng Nam");
		lblThanhVien3.setHorizontalAlignment(SwingConstants.LEFT);
		lblThanhVien3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblThanhVien3.setBounds(484, 545, 202, 23);
		panelManHinhChinh.add(lblThanhVien3);
		
		JLabel lblThanhVien4 = new JLabel("4. Đinh Lê Hậu Nghĩa");
		lblThanhVien4.setHorizontalAlignment(SwingConstants.LEFT);
		lblThanhVien4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblThanhVien4.setBounds(484, 569, 202, 23);
		panelManHinhChinh.add(lblThanhVien4);
		
		lblTenNhanVien = new JLabel("");
		lblTenNhanVien.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTenNhanVien.setBounds(1195, 74, 149, 23);
		contentPane.add(lblTenNhanVien);
		
		lblHinh = new JLabel("");
		lblHinh.setIcon(new ImageIcon(GUI_ManHinhChinh.class.getResource("/img/kara_page-0001.jpg")));
		lblHinh.setBounds(10, 9, 170, 78);
		contentPane.add(lblHinh);		
		
		//btn.Event
		btnManHinhChinh.addActionListener(this);
		btnDatPhong.addActionListener(this);
		btnKhachHang.addActionListener(this);
		btnNhanVien.addActionListener(this);
		btnHoaDon.addActionListener(this);
		btnQLPhong.addActionListener(this);
		btnDichVu.addActionListener(this);
		btnThongKe.addActionListener(this);
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
		// btnManHinhChinh, btnDatPhong, btnHoaDon, btnDichVu,btnNhanVien, btnQLPhong, btnKhachHang,btnThongKe
		if (o.equals(btnManHinhChinh)) {
			ManHinhChinh_to_ManHinhChinh();
		}
		if (o.equals(btnDatPhong)) {
			ManHinhChinh_to_QLDatPhong();
		}
		if (o.equals(btnHoaDon)) {
			ManHinhChinh_to_HoaDon();
		}
		if (o.equals(btnDichVu)) {
			ManHinhChinh_to_DichVu();
		}
		if (o.equals(btnNhanVien)) {
			checkChucVu();	
		}
		if (o.equals(btnQLPhong)) {
			ManHinhChinh_to_Phong();
		}
		if (o.equals(btnKhachHang)) {
			ManHinhChinh_to_KhachHang();
		}
		if (o.equals(btnThongKe)) {
			ManHinhChinh_to_ThongKe();
		}
		if(o.equals(btnDangXuat)) {
			try {
				DangXuat();
			} catch (Exception e2) {
				// TODO: handle exception
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
						ManHinhChinh_to_NhanVien();
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
	
	private void ManHinhChinh_to_ManHinhChinh() {
		// TODO Auto-generated method stub

	}

	private void ManHinhChinh_to_QLDatPhong() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_ThuePhong qldatphong = new GUI_ThuePhong();
		qldatphong.setVisible(true);
		qldatphong.setLocationRelativeTo(null);
	}
	private void ManHinhChinh_to_HoaDon() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_HoaDon hoadon = new GUI_HoaDon();
		hoadon.setVisible(true);
		hoadon.setLocationRelativeTo(null);
	}
	private void ManHinhChinh_to_DichVu() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_QLDichVu dichVu = new GUI_QLDichVu();
		dichVu.setVisible(true);
		dichVu.setLocationRelativeTo(null);
	}
	private void ManHinhChinh_to_NhanVien() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_QLNhanVien nhanvien = new GUI_QLNhanVien();
		nhanvien.setVisible(true);
		nhanvien.setLocationRelativeTo(null);
	}
	private void ManHinhChinh_to_Phong() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_QLPhong qlphong = new GUI_QLPhong();
		qlphong.setVisible(true);
		qlphong.setLocationRelativeTo(null);
	}
	private void ManHinhChinh_to_KhachHang() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_QLKhachHang khachhang = new GUI_QLKhachHang();
		khachhang.setVisible(true);
		khachhang.setLocationRelativeTo(null);
	}
	private void ManHinhChinh_to_ThongKe() {
		// TODO Auto-generated method stub
		
	}
}
