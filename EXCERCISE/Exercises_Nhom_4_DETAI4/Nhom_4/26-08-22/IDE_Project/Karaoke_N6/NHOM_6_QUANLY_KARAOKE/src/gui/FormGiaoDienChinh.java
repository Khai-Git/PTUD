package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import connection.KetNoiKaraoke;
import controllers.TruyVanKaraoke;
import main.FormDangNhap;

import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class FormGiaoDienChinh extends javax.swing.JFrame {
	TruyVanKaraoke adapterMd;
	KetNoiKaraoke adapterCtr;
	String chonGioitinh = "1";
	String chonPhong = new String();
	String chonNhanvien = new String();
	String chonKhachhang = "";

	/**
	 * Create the application.
	 */
	public FormGiaoDienChinh() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		initComponents();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		setTitle("Quản lý Karaoke Nice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// JMenuBar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		// JMenu
		JMenu mnNewMenu = new JMenu("Nhân viên");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 35));
		mnNewMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/nhanvien.png")));
		menuBar.add(mnNewMenu);
		// JMenuItem
		JMenuItem mntmNewMenuItem = new JMenuItem("Cập nhật nhân viên");
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmNewMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/capnhat.png")));
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FormCapNhatNhanVien cnnv = new FormCapNhatNhanVien();
				cnnv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				cnnv.setVisible(true);
				cnnv.setLocationRelativeTo(null);
				dispose();
			}
		});
		// JMenuItem
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Tìm kiếm");
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmNewMenuItem_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/timkiem.png")));
		mnNewMenu.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FormTimKiemNhanVien tknv = new FormTimKiemNhanVien();
				tknv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				tknv.setVisible(true);
				tknv.setLocationRelativeTo(null);
				dispose();
			}
		});
		
		// JMenuItem
				JMenuItem mntmNewMenuItem_3 = new JMenuItem("Tài khoản");
				mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
				mntmNewMenuItem_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/capnhat.png")));
				mnNewMenu.add(mntmNewMenuItem_3);
				mntmNewMenuItem_3.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						FormTaiKhoanNhanVien tknv = new FormTaiKhoanNhanVien();
						tknv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						tknv.setVisible(true);
						tknv.setLocationRelativeTo(null);
						dispose();
					}
				});
		// JMenu
		JMenu mnNewMenu_1 = new JMenu("Khách hàng");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 35));
		mnNewMenu_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/khachhang.png")));
		menuBar.add(mnNewMenu_1);
		// JMenuItem
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Cập nhật khách hàng");
		mntmNewMenuItem_4.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmNewMenuItem_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/capnhat.png")));
		mnNewMenu_1.add(mntmNewMenuItem_4);
		mntmNewMenuItem_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FormCapNhatKhachHang tknv = new FormCapNhatKhachHang();
				tknv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				tknv.setVisible(true);
				tknv.setLocationRelativeTo(null);
				dispose();
			}
		});
		// JMenuItem
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Tìm kiếm");
		mntmNewMenuItem_5.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmNewMenuItem_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/timkiem.png")));
		mnNewMenu_1.add(mntmNewMenuItem_5);
		mntmNewMenuItem_5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FormTimKiemKhachHang tknv = new FormTimKiemKhachHang();
				tknv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				tknv.setVisible(true);
				tknv.setLocationRelativeTo(null);
				dispose();
			}
		});
		// JMenu
		JMenu mnNewMenu_2 = new JMenu("Dịch vụ");
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.BOLD, 35));
		mnNewMenu_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dichvu.png")));
		menuBar.add(mnNewMenu_2);
		// JMenuItem
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Cập nhật dịch vụ");
		mntmNewMenuItem_6.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmNewMenuItem_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/capnhat.png")));
		mnNewMenu_2.add(mntmNewMenuItem_6);
		mntmNewMenuItem_6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FormCapNhatDichVu tknv = new FormCapNhatDichVu();
				tknv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				tknv.setVisible(true);
				tknv.setLocationRelativeTo(null);
				dispose();
			}
		});
		// JMenuItem
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Tìm kiếm");
		mntmNewMenuItem_7.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmNewMenuItem_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/timkiem.png")));
		mnNewMenu_2.add(mntmNewMenuItem_7);
		
		
		/*
		// JMenuItem
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Loại dịch vụ");
		mntmNewMenuItem_7.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmNewMenuItem_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/capnhat.png")));
		mnNewMenu_2.add(mntmNewMenuItem_7);
		*/
		
		
		// JMenu
		JMenu mnNewMenu_3 = new JMenu("Phòng");
		mnNewMenu_3.setFont(new Font("Segoe UI", Font.BOLD, 35));
		mnNewMenu_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/phong.png")));
		menuBar.add(mnNewMenu_3);
		// JMenuItem
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Thêm đặt phòng");
		mntmNewMenuItem_8.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmNewMenuItem_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/them.png")));
		mnNewMenu_3.add(mntmNewMenuItem_8);
		mntmNewMenuItem_8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FormDatPhong tknv = new FormDatPhong();
				tknv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				tknv.setVisible(true);
				tknv.setLocationRelativeTo(null);
				dispose();
			}
		});
		// JMenuItem
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Cập nhật phòng");
		mntmNewMenuItem_9.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmNewMenuItem_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/capnhat.png")));
		mnNewMenu_3.add(mntmNewMenuItem_9);
		mntmNewMenuItem_9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FormCapNhatPhong tknv = new FormCapNhatPhong();
				tknv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				tknv.setVisible(true);
				tknv.setLocationRelativeTo(null);
				dispose();
			}
		});
		// JMenuItem
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Tìm kiếm");
		mntmNewMenuItem_10.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmNewMenuItem_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/timkiem.png")));
		mnNewMenu_3.add(mntmNewMenuItem_10);
		// JMenuItem
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Thêm đơn đặt phòng");
		mntmNewMenuItem_11.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmNewMenuItem_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/them.png")));
		mnNewMenu_3.add(mntmNewMenuItem_11);

		// JMenu
		JMenu mnNewMenu_4 = new JMenu("Hóa đơn");
		mnNewMenu_4.setFont(new Font("Segoe UI", Font.BOLD, 35));
		mnNewMenu_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/hoadon.png")));
		menuBar.add(mnNewMenu_4);
		// JMenuItem
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Lập hóa đơn");
		mntmNewMenuItem_12.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmNewMenuItem_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/them.png")));
		mnNewMenu_4.add(mntmNewMenuItem_12);
		mntmNewMenuItem_12.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FormHoaDon tknv = new FormHoaDon();
				tknv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				tknv.setVisible(true);
				tknv.setLocationRelativeTo(null);
				dispose();
			}
		});
		// JMenuItem
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("Thanh toán");
		mntmNewMenuItem_13.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmNewMenuItem_13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/thanhtoan.png")));
		mnNewMenu_4.add(mntmNewMenuItem_13);

		// JMenu
		JMenu mnNewMenu_5 = new JMenu("Thống kê");
		mnNewMenu_5.setFont(new Font("Segoe UI", Font.BOLD, 35));
		mnNewMenu_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/thongke.png")));
		menuBar.add(mnNewMenu_5);
		// JMenuItem
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("Thống kê doanh thu");
		mntmNewMenuItem_14.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmNewMenuItem_14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/thongkedoanhthu.png")));
		mnNewMenu_5.add(mntmNewMenuItem_14);
		mntmNewMenuItem_14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FormThongKeDoanhThu tknv = new FormThongKeDoanhThu();
				tknv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				tknv.setVisible(true);
				tknv.setLocationRelativeTo(null);
				dispose();
			}
		});
		// JMenuItem
		JMenuItem mntmNewMenuItem_15 = new JMenuItem("Thống kê khách hàng");
		mntmNewMenuItem_15.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmNewMenuItem_15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/thongkekhachhang.png")));
		mnNewMenu_5.add(mntmNewMenuItem_15);
		// JMenuItem
		JMenuItem mntmNewMenuItem_16 = new JMenuItem("Thống kê nhân viên");
		mntmNewMenuItem_16.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmNewMenuItem_16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/thongkenhanvien.png")));
		mnNewMenu_5.add(mntmNewMenuItem_16);
		mntmNewMenuItem_16.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FormThongKeNhanVien tknv = new FormThongKeNhanVien();
				tknv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				tknv.setVisible(true);
				tknv.setLocationRelativeTo(null);
				dispose();
			}
		});
	}

	private void initComponents() {

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setIconImages(null);

		JLabel lblNewLabel = new JLabel("WELCOME TO KARAOKE NICE");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 65));
		lblNewLabel.setForeground(new Color(255, 0, 255));
		lblNewLabel.setBackground(new Color(135, 206, 235));
		
		JButton btnNewButton = new JButton("Đăng xuất");
		btnNewButton.setBackground(new Color(255, 204, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dangxuat.png")));
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất!", null,
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					FormDangNhap lg = new FormDangNhap();
					lg.setVisible(true);
					lg.setLocationRelativeTo(null);
					dispose();
				}
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addGap(620))
				.addGroup(layout.createSequentialGroup()
					.addGap(508)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(556))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(558, Short.MAX_VALUE))
		);
		getContentPane().setLayout(layout);

		

	}

	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(FormGiaoDienChinh.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(FormGiaoDienChinh.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(FormGiaoDienChinh.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(FormGiaoDienChinh.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new FormGiaoDienChinh().setVisible(true);
			}
		});
	}
}
