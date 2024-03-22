package gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

import controllers.TruyVanKaraoke;

public class FormNguoiDung extends javax.swing.JFrame {
	private JPanel contentPane;
	private JTextField txtten;
	private JTextField txttaikhoan;
	private JTextField txtmatkhau;
	private JTable table;
	private String chonuser = "";
	TruyVanKaraoke adapterMd = new TruyVanKaraoke();

	public FormNguoiDung() {
		initComponents();
		setTitle("Quản Lý Tài Khoản ");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		setLocationRelativeTo(null);
		setSize(2130, 1100);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				table.setModel(adapterMd.loadUser());
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(SystemColor.decode("#B9FFF8"));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "Danh sách người dùng :", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 79, 525, 611);
		panel.setBackground(SystemColor.decode("#87A2FB"));
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				chonuser = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
			}
		});
		scrollPane.setViewportView(table);

		txtten = new JTextField();
		txtten.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtten.setBounds(760, 131, 285, 50);
		contentPane.add(txtten);
		txtten.setColumns(10);

		txttaikhoan = new JTextField();
		txttaikhoan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txttaikhoan.setBounds(760, 320, 285, 50);
		contentPane.add(txttaikhoan);
		txttaikhoan.setColumns(10);

		txtmatkhau = new JTextField();
		txtmatkhau.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtmatkhau.setBounds(760, 509, 285, 50);
		contentPane.add(txtmatkhau);
		txtmatkhau.setColumns(10);

		JLabel lblNewLabel = new JLabel("Tên tài khoản:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(558, 326, 152, 31);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Mật Khẩu:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(600, 514, 110, 32);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Họ Tên:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(600, 137, 88, 31);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Thêm / Xóa tài khoản");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_3.setBounds(606, 32, 285, 27);
		contentPane.add(lblNewLabel_3);

		JButton btnthem = new JButton("Thêm");
		btnthem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txttaikhoan.getText().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "Kiểm tra tên tài khoản");
				} else if (txtten.getText().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "Kiểm tra tên ");
				} else if (txtmatkhau.getText().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "Kiểm tra mật khẩu ");
				}

				else
					adapterMd.ThemUser(txttaikhoan.getText(), txtmatkhau.getText(), txtten.getText());
				table.setModel(adapterMd.loadUser());
			}
		});
		btnthem.setBounds(669, 626, 190, 73);
		btnthem.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnthem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/login.png")));
		btnthem.setText("Thêm");
		btnthem.setBackground(new Color(255, 246, 143));
		contentPane.add(btnthem);

		JButton btnxoa = new JButton("Xóa");
		btnxoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chonuser.equals("")) {
					JOptionPane.showMessageDialog(null, "Chưa chọn người dùng");
				}

				else

				if (JOptionPane.showConfirmDialog(null,
						"Bạn có muốn xóa " + table.getModel().getValueAt(table.getSelectedRow(), 1).toString() + "",
						"Kiểm tra lại", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					adapterMd.XoaId("tb_login", "ma_tk", chonuser);
					table.setModel(adapterMd.loadUser());
				}
			}
		});
		btnxoa.setBounds(947, 626, 190, 73);
		btnxoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnxoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete.png")));
		btnxoa.setText("Xóa");
		btnxoa.setBackground(new Color(255, 246, 143));
		contentPane.add(btnxoa);
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
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 679, Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 311, Short.MAX_VALUE));

		
	}

	private void formWindowClosing(java.awt.event.WindowEvent evt) {

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
			java.util.logging.Logger.getLogger(FormNguoiDung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(FormNguoiDung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(FormNguoiDung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(FormNguoiDung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new FormNguoiDung().setVisible(true);
			}
		});
	}

}

