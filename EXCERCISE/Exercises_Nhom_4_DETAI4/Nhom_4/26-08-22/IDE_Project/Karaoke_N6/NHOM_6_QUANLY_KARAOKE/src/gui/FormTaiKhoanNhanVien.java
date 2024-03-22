package gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

import connection.KetNoiKaraoke;
import controllers.TruyVanKaraoke;

public class FormTaiKhoanNhanVien extends javax.swing.JFrame {
	TruyVanKaraoke adapterMd = new TruyVanKaraoke();
	KetNoiKaraoke adapterCtr = new KetNoiKaraoke();
	private JPanel contentPane;
	private JTextField txtTentk;
	private JTextField txtQuyen;
	private JPasswordField pfMkm;
	private JPasswordField pfXacnhan;
	private JPasswordField pfMkcu;

	public FormTaiKhoanNhanVien() {
		initComponents();
		setTitle("Thông tin tài khoản");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {

				txtTentk.setText(adapterCtr.cellTb("ten_tk", adapterCtr.itemLogin(adapterCtr.Id("id_1", "id"))));
				String quyen = adapterCtr.cellTb("tinhtrang", adapterCtr.itemLogin(adapterCtr.Id("id_1", "id")));
				if (quyen.equals("1"))
					txtQuyen.setText("Quản trị viên");
				else
					txtQuyen.setText("Thành viên");
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1940, 1452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(SystemColor.decode("#B9FFF8"));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Thông tin tài khoản:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel_2.setBounds(540, 41, 766, 442);
		panel_2.setBackground(SystemColor.decode("#87A2FB"));
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tên USER:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(103, 70, 122, 31);
		panel_2.add(lblNewLabel);

		txtTentk = new JTextField();
		txtTentk.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTentk.setEditable(false);
		txtTentk.setBounds(273, 65, 252, 49);
		panel_2.add(txtTentk);
		txtTentk.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Quyền USER:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(103, 210, 122, 31);
		panel_2.add(lblNewLabel_1);

		txtQuyen = new JTextField();
		txtQuyen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtQuyen.setEditable(false);
		txtQuyen.setBounds(273, 205, 252, 49);
		panel_2.add(txtQuyen);
		txtQuyen.setColumns(10);

		JButton btnNewButton_1 = new JButton();
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String quyen = adapterCtr.cellTb("tinhtrang", adapterCtr.itemLogin(adapterCtr.Id("id_1", "id")));
				if (!quyen.equals("1"))
					JOptionPane.showMessageDialog(null, "Bạn không được sử dụng chức năng này!");
				else {
					FormNguoiDung user = new FormNguoiDung();
					user.setVisible(true);
					user.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					user.setLocationRelativeTo(null);
				}
			}
		});
		btnNewButton_1.setBounds(273, 332, 252, 71);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/login.png")));
		btnNewButton_1.setText("Thêm tài khoản");
		btnNewButton_1.setBackground(new Color(255, 246, 143));

		panel_2.add(btnNewButton_1);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Đổi mật khẩu:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel.setBounds(540, 570, 766, 442);
		panel.setBackground(SystemColor.decode("#87A2FB"));
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String mkc = adapterCtr.cellTb("matkhau", adapterCtr.itemLogin(adapterCtr.Id("id_1", "id")));
				if (!String.valueOf(pfMkcu.getPassword()).equals(mkc))
					JOptionPane.showMessageDialog(null, "Nhập sai mật khẩu cũ!");
				else if (String.valueOf(pfMkm.getPassword()).equals("")
						|| String.valueOf(pfXacnhan.getPassword()).equals(""))
					JOptionPane.showMessageDialog(null, "Nhập đầy đủ, nhập lại!");
				else if (!String.valueOf(pfMkm.getPassword()).equals(String.valueOf(pfXacnhan.getPassword()))) {
					JOptionPane.showMessageDialog(null, "Xác nhận sai!");
					pfMkm.setText("");
					pfXacnhan.setText("");
				} else {
					adapterMd.updateMatkhau(String.valueOf(pfMkm.getPassword()), adapterCtr.Id("id_1", "id"));
				}
			}
		});
		btnNewButton.setBounds(277, 304, 252, 71);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pass.png")));
		btnNewButton.setText("Đổi mật khẩu");
		btnNewButton.setBackground(new Color(255, 246, 143));

		panel.add(btnNewButton);

		pfMkm = new JPasswordField();
		pfMkm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pfMkm.setBounds(277, 124, 252, 53);
		panel.add(pfMkm);

		pfXacnhan = new JPasswordField();
		pfXacnhan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pfXacnhan.setBounds(277, 223, 252, 53);
		panel.add(pfXacnhan);

		pfMkcu = new JPasswordField();
		pfMkcu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pfMkcu.setBounds(277, 34, 252, 53);
		panel.add(pfMkcu);

		JLabel lblNewLabel_4 = new JLabel("Mật khẩu cũ:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(103, 40, 128, 33);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Mật khẩu mới:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(103, 130, 128, 33);
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Xác nhận:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(123, 229, 108, 33);
		panel.add(lblNewLabel_6);
	}

	private void initComponents() {

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				formWindowClosing(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400, Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300, Short.MAX_VALUE));

		
	}

	private void formWindowClosing(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowClosing
		FormGiaoDienChinh vm = new FormGiaoDienChinh();
		vm.setVisible(true);
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
			java.util.logging.Logger.getLogger(FormTaiKhoanNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(FormTaiKhoanNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(FormTaiKhoanNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(FormTaiKhoanNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new FormTaiKhoanNhanVien().setVisible(true);
			}
		});
	}

}

