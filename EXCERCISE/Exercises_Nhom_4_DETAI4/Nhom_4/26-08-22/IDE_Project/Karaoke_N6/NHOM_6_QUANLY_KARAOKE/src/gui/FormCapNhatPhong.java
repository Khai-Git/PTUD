package gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

import connection.KetNoiKaraoke;
import controllers.TruyVanKaraoke;

import java.util.*;

public class FormCapNhatPhong extends javax.swing.JFrame {

	TruyVanKaraoke adapterMd = new TruyVanKaraoke();
	KetNoiKaraoke adapterCtr = new KetNoiKaraoke();
	private JPanel contentPane;
	private JTextField txtTen;
	private JTextField txtGia;
	private JTextField txtId;
	private JTable tblPhong;
	private JComboBox cmbLp;
	private JComboBox comboBox;
	private String chonloaiphong;
	private String id;
	String namephong = "";

	public FormCapNhatPhong() {
		initComponents();
		setTitle("Phòng Hát");
		setResizable(false);
		setLocationRelativeTo(null);
		setSize(590, 520);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				adapterCtr = new KetNoiKaraoke();
				tblPhong.setModel(adapterCtr.timKiemPhong(6));
			}
		});

		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.decode("#B9FFF8"));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Thông tin phòng:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel_1.setBounds(10, 52, 570, 430);
		panel_1.setBackground(SystemColor.decode("#87A2FB"));
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton btnXoa = new JButton();
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String quyen = adapterCtr.cellTb("tinhtrang", adapterCtr.itemLogin(adapterCtr.Id("id_1", "id")));
				if (!quyen.equals("1")) {
					JOptionPane.showMessageDialog(null, "Bạn không được sử dụng chức năng này!");
					return;
				}
				// Trường hợp phòng đang có người dùng mà chúng ta xóa thì không được
				if (namephong.equals("Phòng đã đặt")) {
					JOptionPane.showMessageDialog(null, "xin lỗi phòng này đang dùng");
					return;
				}
				if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa!", "Kiểm tra lại",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					if (id.equals(""))
						JOptionPane.showMessageDialog(null, "Chưa chọn phòng!");
					else {
						adapterMd.XoaId("tb_phong", "ma_phong", id);
						adapterCtr = new KetNoiKaraoke();
						tblPhong.setModel(adapterCtr.timKiemPhong(6));
					}
				}
			}
		});
		btnXoa.setBounds(145, 105, 120, 42);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete.png")));
		btnXoa.setText("Xóa");
		btnXoa.setBackground(new Color(255, 246, 143));
		panel_1.add(btnXoa);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh sách phòng:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel_2.setBounds(10, 160, 550, 255);
		panel_2.setBackground(SystemColor.decode("#87A2FB"));
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane);

		tblPhong = new JTable();
		tblPhong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				namephong = tblPhong.getValueAt(tblPhong.getSelectedRow(), 4).toString();
				id = tblPhong.getModel().getValueAt(tblPhong.getSelectedRow(), 0).toString();
				txtTen.setText(tblPhong.getModel().getValueAt(tblPhong.getSelectedRow(), 1).toString());
				txtId.setText(id);
				txtGia.setText(tblPhong.getModel().getValueAt(tblPhong.getSelectedRow(), 3).toString());
			}
		});
		scrollPane.setViewportView(tblPhong);

		JButton btnThem = new JButton();
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String quyen = adapterCtr.cellTb("tinhtrang", adapterCtr.itemLogin(adapterCtr.Id("id_1", "id")));
				if (!quyen.equals("1"))
					JOptionPane.showMessageDialog(null, "Bạn không được sử dụng chức năng này!");
				else if (txtTen.getText().toString().equals("") || chonloaiphong.equals("--selected--")
						|| txtGia.getText().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "Kiểm tra lại!");
				} else {
					adapterMd.ThemPhong(txtTen.getText().toString(), chonloaiphong, txtGia.getText().toString());
					adapterCtr = new KetNoiKaraoke();
					// load lên tất cả dữ liêu phòng
					tblPhong.setModel(adapterCtr.timKiemPhong(6));
					// setText lên label thông báo
				}
			}
		});
		btnThem.setBounds(21, 105, 120, 42);
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plus.png")));
		btnThem.setText("Thêm");
		btnThem.setBackground(new Color(255, 246, 143));
		panel_1.add(btnThem);

		txtTen = new JTextField();
		txtTen.setBounds(86, 26, 140, 30);
		panel_1.add(txtTen);
		txtTen.setColumns(10);

		JLabel lblNewLabel = new JLabel("Tên Phòng :");
		lblNewLabel.setBounds(10, 34, 67, 14);
		panel_1.add(lblNewLabel);

		cmbLp = new JComboBox();
		cmbLp.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (cmbLp.getSelectedItem().toString().equals("phòng Thường"))
					chonloaiphong = "1";
				else if (cmbLp.getSelectedItem().toString().equals("phòng Vip"))
					chonloaiphong = "2";
			}
		});
		cmbLp.setModel(new DefaultComboBoxModel(new String[] { "--selected--", "phòng Thường", "phòng Vip" }));
		cmbLp.setBounds(361, 26, 161, 30);
		panel_1.add(cmbLp);

		JLabel lblNewLabel_2 = new JLabel("Loại phòng :");
		lblNewLabel_2.setBounds(252, 34, 99, 14);
		panel_1.add(lblNewLabel_2);

		txtId = new JTextField();
		txtId.setBounds(86, 62, 140, 30);
		panel_1.add(txtId);
		txtId.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Mã phòng :");
		lblNewLabel_4.setBounds(10, 67, 67, 14);
		panel_1.add(lblNewLabel_4);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tìm kiếm phòng:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel.setBounds(340, 100, 182, 63);
		panel.setBackground(SystemColor.decode("#87A2FB"));
		panel_1.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				// load tất cả
				if (comboBox.getSelectedIndex() == 0)
					tblPhong.setModel(adapterCtr.timKiemPhong(6));
				// load phong tình trạng =0
				else if (comboBox.getSelectedIndex() == 1)
					tblPhong.setModel(adapterCtr.timKiemPhong(0));
				// load phòng tìnhtrang=1
				else if (comboBox.getSelectedIndex() == 2)
					tblPhong.setModel(adapterCtr.timKiemPhong(1));
				// load phòng loại phòng = phòng thường
				else if (comboBox.getSelectedIndex() == 3)
					tblPhong.setModel(adapterCtr.timKiemPhong(2));
				// load phòng loại phòng = phòng vip
				else if (comboBox.getSelectedIndex() == 4)
					tblPhong.setModel(adapterCtr.timKiemPhong(3));

			}
		});
		comboBox.setBounds(0, 0, 170, 33);
		panel.add(comboBox);

		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "---Phòng---", "Phòng trống", "Phòng đã đặt", "Phòng Thường", "Phòng vip" }));

		txtGia = new JTextField();
		txtGia.setBounds(361, 62, 161, 30);
		panel_1.add(txtGia);
		txtGia.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Giá Phòng/1h :");
		lblNewLabel_1.setBounds(252, 67, 99, 14);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("DANH SÁCH PHÒNG HÁT");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_3.setForeground(new Color(210, 105, 30));
		lblNewLabel_3.setBounds(10, 11, 260, 31);
		contentPane.add(lblNewLabel_3);

		JButton btnRf = new JButton("Refresh");
		btnRf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adapterCtr = new KetNoiKaraoke();
				tblPhong.setModel(adapterCtr.timKiemPhong(6));
			}
		});
		btnRf.setBounds(425, 9, 150, 43);
		btnRf.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/loop2.png")));
		btnRf.setText("CẬP NHẬT");
		btnRf.setBackground(new Color(255, 246, 143));
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

	private void formWindowClosing(java.awt.event.WindowEvent evt) {
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
			java.util.logging.Logger.getLogger(FormCapNhatPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(FormCapNhatPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(FormCapNhatPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(FormCapNhatPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new FormCapNhatPhong().setVisible(true);
			}
		});
	}

}
