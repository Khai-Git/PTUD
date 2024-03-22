package main;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

import connection.KetNoiKaraoke;
import gui.FormGiaoDienChinh;

public class FormDangNhap extends javax.swing.JFrame {

	private JPanel contentPane;
	private JTextField txttk;
	KetNoiKaraoke adapterCtr = new KetNoiKaraoke();
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JLabel lblpass;
	private JLabel Lanel;
	private JLabel lblNewLabel_1;
	private JPasswordField pfMk;

	public FormDangNhap() {
		initComponents();
		setTitle("Đăng Nhập");
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1112, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Lanel = new JLabel();
		Lanel.setBackground(new Color(255, 153, 153));
		Lanel.setBounds(0, 0, 681, 629);
		contentPane.add(Lanel);
		Lanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/giaodienlogin.png")));
		Lanel.setLayout(null);

		JButton btnNewButton_2 = new JButton();
		contentPane.add(btnNewButton_2);
		btnNewButton_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close.png")));
		btnNewButton_2.setText("Đóng");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_2.setBounds(959, 418, 100, 43);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setBackground(new Color(127, 255, 212));

		btnNewButton = new JButton();
		contentPane.add(btnNewButton);
		btnNewButton.setBounds(778, 418, 129, 43);
		btnNewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/login.png")));
		btnNewButton.setText("Đăng nhập");
		btnNewButton.setForeground(new Color(0, 0, 153));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBackground(new Color(127, 255, 212));

		pfMk = new JPasswordField();
		contentPane.add(pfMk);
		pfMk.setText("123");
		pfMk.setBounds(824, 342, 190, 30);

		lblpass = new JLabel();
		contentPane.add(lblpass);
		lblpass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/password.png")));
		lblpass.setBounds(750, 340, 50, 32);

		txttk = new JTextField("admin");
		contentPane.add(txttk);
		txttk.setBounds(824, 249, 190, 30);
		txttk.setColumns(10);

		lblNewLabel = new JLabel();
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user.png")));
		lblNewLabel.setBounds(750, 236, 50, 43);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(new Color(102, 204, 153));
		lblNewLabel_2.setBackground(new Color(153, 255, 255));
		lblNewLabel_2.setBounds(680, 0, 416, 621);
		contentPane.add(lblNewLabel_2);

		btnNewButton.addActionListener(new ActionListener() {
			// Handle code login
			public void actionPerformed(ActionEvent e) {
				if (txttk.getText().equals("") || String.valueOf(pfMk.getPassword()).equals("")) {
					if (txttk.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Vui lòng nhập tài khoản");
					else
						JOptionPane.showMessageDialog(null, "Vui lòng nhập mật khẩu");

				} else if (adapterCtr
						.demDong("tb_login",
								adapterCtr.demTaikhoan(txttk.getText(), String.valueOf(pfMk.getPassword())))
						.equals("0"))
					JOptionPane.showMessageDialog(null, "Nhập sai tài khoản hoặc mật khẩu");
				else if (!adapterCtr
						.demDong("tb_login",
								adapterCtr.demTaikhoan(txttk.getText(), String.valueOf(pfMk.getPassword())))
						.equals("0")) {
					String tk = txttk.getText();
					String mk = String.valueOf(pfMk.getPassword());
					String matk = adapterCtr.ma_tk(tk, mk);
					adapterCtr.luuid("*", matk);
					FormGiaoDienChinh main = new FormGiaoDienChinh();
					main.setVisible(true);
					main.setLocationRelativeTo(null);
					JOptionPane.showMessageDialog(null, "Chào "
							+ adapterCtr.cellTb("ten_tk", adapterCtr.itemLogin(adapterCtr.Id("id_1", "id"))) + "!",
							null, JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}
			}
		});
	}

	private void initComponents() {

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400, Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300, Short.MAX_VALUE));

		
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
			java.util.logging.Logger.getLogger(FormDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(FormDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(FormDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(FormDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormDangNhap frame = new FormDangNhap();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
