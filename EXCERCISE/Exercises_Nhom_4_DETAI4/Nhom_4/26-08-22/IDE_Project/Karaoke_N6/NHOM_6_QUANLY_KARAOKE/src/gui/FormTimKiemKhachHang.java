package gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

import connection.KetNoiKaraoke;
import controllers.TruyVanKaraoke;

import java.util.*;

public class FormTimKiemKhachHang extends javax.swing.JFrame {

	TruyVanKaraoke adapterMd = new TruyVanKaraoke();
	KetNoiKaraoke adapterCtr = new KetNoiKaraoke();
	private JPanel contentPane;
	private JTextField txtTen;
	private JTextField txtCmnd;
	private JTextField txtLienlac;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel txtlienlac;
	private JTable tblKh;
	private JComboBox cmbGioitinh;
	private String chonGioitinh = "1";
	private String chonPhong = "";
	private String idKh = "";
	private JLabel lblNewLabel_5;
	private JPanel panel_3;
	private JPanel panel_4;
	private JTable tblTimKh;
	private JScrollPane scrollPane_2;
	private JComboBox cmbPhong;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;

	public FormTimKiemKhachHang() {
		initComponents();

		setTitle("Khách Hàng");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			// Handle List
			@Override
			public void windowOpened(WindowEvent arg0) {
				adapterMd = new TruyVanKaraoke();
				tblKh.setModel(adapterMd.loadAllKh());
				adapterMd = new TruyVanKaraoke();
				adapterMd = new TruyVanKaraoke();
				adapterMd = new TruyVanKaraoke();
				cmbPhong.setModel(adapterMd.loadPhongList());

			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1988, 1100);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.decode("#B9FFF8"));
		contentPane.setForeground(new Color(83, 134, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh sách khách hàng:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel.setBounds(10, 658, 1904, 392);
		panel.setBackground(SystemColor.decode("#87A2FB"));
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		// JTable
		tblKh = new JTable();
		tblKh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				idKh = tblKh.getModel().getValueAt(tblKh.getSelectedRow(), 0).toString();
				txtTen.setText(tblKh.getModel().getValueAt(tblKh.getSelectedRow(), 1).toString());
				txtCmnd.setText(tblKh.getModel().getValueAt(tblKh.getSelectedRow(), 2).toString());
				if (tblKh.getModel().getValueAt(tblKh.getSelectedRow(), 3).toString().equals("1"))
					chonGioitinh = "1";
				else
					chonGioitinh = "0";
				txtLienlac.setText(tblKh.getModel().getValueAt(tblKh.getSelectedRow(), 4).toString());
			}
		});
		scrollPane.setViewportView(tblKh);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Thông tin khách hàng:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel_1.setBounds(10, 140, 1904, 507);
		panel_1.setBackground(SystemColor.decode("#87A2FB"));
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton btnSua = new JButton();
		btnSua.addActionListener(new ActionListener() {
			// Update customer
			public void actionPerformed(ActionEvent e) {
				adapterMd.updateAllKh(idKh, txtTen.getText(), txtCmnd.getText(), chonGioitinh, txtLienlac.getText());
				adapterMd = new TruyVanKaraoke();
				tblKh.setModel(adapterMd.loadAllKh());
			}
		});
		btnSua.setBounds(333, 420, 155, 54);
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/timkiem(1).png")));
		btnSua.setText("Tìm kiếm");
		btnSua.setBackground(new Color(255, 246, 143));
		panel_1.add(btnSua);

		JButton btnXoa = new JButton();
		btnXoa.addActionListener(new ActionListener() {
			// Delete customer
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa!", "Kiểm tra lại",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					if (idKh.equals(""))
						JOptionPane.showMessageDialog(null, "Chưa chọn KH!");
					else {
						adapterMd.XoaId("tb_khachhang", "ma_kh", idKh);
						adapterMd = new TruyVanKaraoke();
						tblKh.setModel(adapterMd.loadAllKh());
					}
				}
			}
		});
		btnXoa.setBounds(746, 420, 155, 54);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/tailai.png")));
		btnXoa.setText("Tải lại");
		btnXoa.setBackground(new Color(255, 246, 143));
		panel_1.add(btnXoa);

		lblNewLabel = new JLabel("Tên KH:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(57, 123, 85, 20);
		panel_1.add(lblNewLabel);

		txtTen = new JTextField();
		txtTen.setBounds(242, 116, 178, 42);
		panel_1.add(txtTen);
		txtTen.setColumns(10);

		lblNewLabel_1 = new JLabel("CMND KH:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(57, 221, 120, 26);
		panel_1.add(lblNewLabel_1);

		txtCmnd = new JTextField();
		txtCmnd.setBounds(242, 217, 178, 42);
		panel_1.add(txtCmnd);
		txtCmnd.setColumns(10);

		txtlienlac = new JLabel("Liên Lạc KH:");
		txtlienlac.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtlienlac.setBounds(713, 119, 120, 29);

		panel_1.add(txtlienlac);
		txtLienlac = new JTextField();
		txtLienlac.setBounds(960, 116, 178, 42);
		panel_1.add(txtLienlac);
		txtLienlac.setColumns(10);

		lblNewLabel_3 = new JLabel("Giới Tính KH:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(713, 223, 120, 23);
		panel_1.add(lblNewLabel_3);

		cmbGioitinh = new JComboBox();
		cmbGioitinh.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (cmbGioitinh.getSelectedIndex() == 0)
					chonGioitinh = "1";
				else if (cmbGioitinh.getSelectedIndex() == 1)
					chonGioitinh = "0";
			}
		});
		cmbGioitinh.setModel(new DefaultComboBoxModel(new String[] { "Nam", "Nữ" }));
		cmbGioitinh.setBounds(960, 217, 178, 42);
		panel_1.add(cmbGioitinh);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tìm khách theo phòng:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel_3.setBounds(960, 323, 178, 65);
		panel_3.setBackground(SystemColor.decode("#87A2FB"));
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));

		cmbPhong = new JComboBox();
		cmbPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmbPhong.addItemListener(new ItemListener() {
			// Filter customer by select room
			public void itemStateChanged(ItemEvent arg0) {
				adapterMd = new TruyVanKaraoke();
				if (cmbPhong.getSelectedIndex() == 0)
					tblKh.setModel(adapterMd.loadAllKh());
				else
					tblKh.setModel(adapterMd.loadTimPhong(cmbPhong.getSelectedItem().toString()));
			}
		});
		cmbPhong.setBounds(10, 290, 148, 20);
		panel_3.add(cmbPhong);

		lblNewLabel_10 = new JLabel("DANH SÁCH KHÁCH HÀNG");
		lblNewLabel_10.setForeground(new Color(210, 105, 30));
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_10.setBounds(10, 54, 294, 35);
		contentPane.add(lblNewLabel_10);

		JButton btnRf = new JButton("refresh");
		btnRf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adapterMd = new TruyVanKaraoke();
				tblKh.setModel(adapterMd.loadAllKh());
				adapterMd = new TruyVanKaraoke();
				adapterMd = new TruyVanKaraoke();
				adapterMd = new TruyVanKaraoke();
				cmbPhong.setModel(adapterMd.loadPhongList());

			}
		});

		btnRf.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/loop2.png")));
		btnRf.setText("CẬP NHẬT");
		btnRf.setBackground(new Color(255, 246, 143));
		btnRf.setBounds(1076, 44, 214, 57);
		contentPane.add(btnRf);
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
			java.util.logging.Logger.getLogger(FormCapNhatKhachHang.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(FormCapNhatKhachHang.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(FormCapNhatKhachHang.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(FormCapNhatKhachHang.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new FormCapNhatKhachHang().setVisible(true);
			}
		});
	}

}

