package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComboBox;

import connection.KetNoiKaraoke;
import controllers.TruyVanKaraoke;

public class FormCapNhatNhanVien extends JFrame {

	TruyVanKaraoke adapterMd = new TruyVanKaraoke();
	KetNoiKaraoke adapterCtr = new KetNoiKaraoke();
	private JPanel contentPane;
	private JTextField txtTenNv;
	private JTextField txtChucvu;
	private JTextField txtLuong;
	private JTextField txtNamsinh;
	private JTable tblNv;
	private JTextField txtChuthich;
	private JComboBox comboBox;
	String IdNv = "";
	String chonGioitinh = new String();
	private JTextField txtMaCV;

	/**
	 * Create the frame.
	 */
	public FormCapNhatNhanVien() {
		initComponents();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		setTitle("Nhân Viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				adapterMd = new TruyVanKaraoke();
				tblNv.setModel(adapterMd.loadAllNv());
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1940, 1445);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.decode("#B9FFF8"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Thông tin nhân viên:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel_2.setBounds(10, 82, 1900, 986);
		panel_2.setBackground(SystemColor.decode("#87A2FB"));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã CV :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(64, 88, 97, 26);
		panel_2.add(lblNewLabel);

		txtMaCV = new JTextField();
		txtMaCV.setBounds(195, 84, 171, 42);
		panel_2.add(txtMaCV);
		txtMaCV.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Tên NV :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(64, 216, 97, 26);
		panel_2.add(lblNewLabel_1);

		txtTenNv = new JTextField();
		txtTenNv.setBounds(195, 212, 171, 42);
		panel_2.add(txtTenNv);
		txtTenNv.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Chức vụ :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(64, 335, 97, 28);
		panel_2.add(lblNewLabel_2);

		txtChucvu = new JTextField();
		txtChucvu.setBounds(195, 332, 171, 42);
		panel_2.add(txtChucvu);
		txtChucvu.setColumns(10);

		txtLuong = new JTextField();
		txtLuong.setBounds(611, 82, 171, 44);
		panel_2.add(txtLuong);
		txtLuong.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Lương :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(470, 84, 97, 26);
		panel_2.add(lblNewLabel_3);

		txtNamsinh = new JTextField();
		txtNamsinh.setBounds(611, 214, 171, 39);
		panel_2.add(txtNamsinh);
		txtNamsinh.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Năm sinh :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(470, 214, 97, 28);
		panel_2.add(lblNewLabel_4);
		// JComboBox
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setBounds(1024, 210, 171, 36);
		panel_2.add(comboBox);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (comboBox.getSelectedIndex() == 0)
					chonGioitinh = "chÆ°a rÃµ";
				else if (comboBox.getSelectedIndex() == 1)
					chonGioitinh = "1";
				else if (comboBox.getSelectedIndex() == 2)
					chonGioitinh = "0";
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "--Chọn--", "Nam", "Nữ" }));

		JLabel lblNewLabel_5 = new JLabel("Giới tính :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(888, 214, 112, 28);
		panel_2.add(lblNewLabel_5);

		txtChuthich = new JTextField();
		txtChuthich.setBounds(611, 334, 171, 39);
		panel_2.add(txtChuthich);
		txtChuthich.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Chú thích :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(470, 337, 112, 25);
		panel_2.add(lblNewLabel_6);
		// JButton Xoa
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBounds(919, 424, 208, 64);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete.png")));
		btnXoa.setText("Xóa");
		btnXoa.setBackground(new Color(255, 246, 143));
		panel_2.add(btnXoa);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (IdNv.equals("")) {
					JOptionPane.showMessageDialog(null, "Chưa chọn nhân viên");
				} else {
					adapterMd.XoaId("tb_nhanvien", "ma_nv", IdNv);
					tblNv.setModel(adapterMd.loadAllNv());
					txtMaCV.setText("");
					txtTenNv.setText("");
					txtChucvu.setText("");
					txtChuthich.setText("");
					txtLuong.setText("");
					txtNamsinh.setText("");
					IdNv = "";
					comboBox.setModel(new DefaultComboBoxModel(new String[] { "--Chọn--", "Nam", "Nữ" }));
				}
			}
		});
		// JButton Them
		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(333, 424, 208, 64);
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plus.png")));
		btnThem.setText("Thêm");
		btnThem.setBackground(new Color(255, 246, 143));
		panel_2.add(btnThem);
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtTenNv.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Kiểm tra lại tên");
				else if (chonGioitinh.equals("1") || chonGioitinh.equals("0")) {
					adapterMd.ThemNhanVien(txtMaCV.getText(),txtTenNv.getText(), txtChucvu.getText(), txtLuong.getText(),
							txtNamsinh.getText(), chonGioitinh, txtChuthich.getText());
					adapterMd = new TruyVanKaraoke();
					tblNv.setModel(adapterMd.loadAllNv());
					txtMaCV.setText("");
					txtTenNv.setText("");
					txtChucvu.setText("");
					txtChuthich.setText("");
					txtLuong.setText("");
					txtNamsinh.setText("");
					IdNv = "";
					comboBox.setModel(new DefaultComboBoxModel(new String[] { "--Chọn--", "Nam", "Nữ" }));
				} else {
					JOptionPane.showMessageDialog(null, "Chưa chọn giới tính");
				}
			}
		});
		
				
		// JPanel
		JPanel panel = new JPanel();
		panel.setBounds(0, 499, 1900, 490);
		panel_2.add(panel);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh sách Nv:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel.setBackground(SystemColor.decode("#87A2FB"));
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 16, 1884, 463);
		panel.add(scrollPane);
		// JTable
		tblNv = new JTable();
		tblNv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				IdNv = tblNv.getModel().getValueAt(tblNv.getSelectedRow(), 0).toString();
				txtMaCV.setText(tblNv.getModel().getValueAt(tblNv.getSelectedRow(), 1).toString());
				txtTenNv.setText(tblNv.getModel().getValueAt(tblNv.getSelectedRow(), 2).toString());
				txtChucvu.setText(tblNv.getModel().getValueAt(tblNv.getSelectedRow(), 3).toString());
				txtLuong.setText(tblNv.getModel().getValueAt(tblNv.getSelectedRow(), 4).toString());
				txtNamsinh.setText(tblNv.getModel().getValueAt(tblNv.getSelectedRow(), 5).toString());
				txtChuthich.setText(tblNv.getModel().getValueAt(tblNv.getSelectedRow(), 7).toString());
			}
		});
		scrollPane.setViewportView(tblNv);

		
		JLabel lblNewLabel_8 = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8.setBounds(30, 22, 294, 35);
		lblNewLabel_8.setForeground(new Color(210, 105, 30));
		contentPane.add(lblNewLabel_8);

		JButton btnRf = new JButton();
		btnRf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adapterMd = new TruyVanKaraoke();
				tblNv.setModel(adapterMd.loadAllNv());

			}
		});
		btnRf.setBounds(1210, 14, 228, 53);
		btnRf.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/loop2.png")));
		btnRf.setText("Cập nhật");
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
			java.util.logging.Logger.getLogger(FormCapNhatNhanVien.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(FormCapNhatNhanVien.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(FormCapNhatNhanVien.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(FormCapNhatNhanVien.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new FormCapNhatNhanVien().setVisible(true);
			}
		});
	}
}