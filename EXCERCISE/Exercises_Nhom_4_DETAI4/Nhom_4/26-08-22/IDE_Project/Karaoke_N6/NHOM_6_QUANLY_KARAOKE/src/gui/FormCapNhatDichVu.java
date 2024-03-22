package gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.table.*;

import connection.KetNoiKaraoke;
import controllers.TruyVanKaraoke;

public class FormCapNhatDichVu extends javax.swing.JFrame {

	TruyVanKaraoke adapterMd = new TruyVanKaraoke();
	KetNoiKaraoke adapterCtr = new KetNoiKaraoke();
	private JPanel contentPane;
	private JTextField txtTenKh;
	private JTable tblDv;
	private JTable tblDvDat;
	private JTable tblTt;
	private JTextField txtTenDv;
	private JTextField txtGiaDv;
	private JComboBox cmbNhanvien;
	private JLabel lblNv;
	private JLabel lblSldv;
	private JLabel lblTongtien;
	private String chonDichvu;
	private String chonDvvD;
	private JTextField txtDcKh;
	private JTextField txtTenLoaiDv;

	public FormCapNhatDichVu() {
		initComponents();
		setTitle("Dịch Vụ");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				adapterMd = new TruyVanKaraoke();
				tblDv.setModel(adapterMd.loadDichVu());
				adapterMd = new TruyVanKaraoke();
				tblDvDat.setModel(adapterMd.loadHdDv());
				cmbNhanvien.setModel(adapterMd.loadNhanvienCmb());
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1940, 1445);

		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.decode("#B9FFF8"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Nhập dịch vụ:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel.setBounds(20, 589, 553, 265);
		panel.setBackground(SystemColor.decode("#87A2FB"));
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tên Dv :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(25, 50, 80, 28);
		panel.add(lblNewLabel);

		txtTenDv = new JTextField();
		txtTenDv.setBounds(171, 121, 174, 30);
		panel.add(txtTenDv);
		txtTenDv.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tên loại Dv :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(25, 118, 127, 28);
		panel.add(lblNewLabel_1);

		txtTenLoaiDv = new JTextField();
		txtTenLoaiDv.setBounds(171, 53, 174, 30);
		panel.add(txtTenLoaiDv);
		txtTenLoaiDv.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Giá Dv :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(25, 191, 80, 30);
		panel.add(lblNewLabel_2);

		txtGiaDv = new JTextField();
		txtGiaDv.setBounds(171, 195, 174, 30);
		panel.add(txtGiaDv);
		txtGiaDv.setColumns(10);
		// JPanel 2
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh sách dịch vụ vừa đặt:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel_2.setBounds(639, 122, 673, 203);
		panel_2.setBackground(SystemColor.decode("#87A2FB"));
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));

		JScrollPane scrollPane_2 = new JScrollPane();
		panel_2.add(scrollPane_2);

		tblDvDat = new JTable();
		tblDvDat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				chonDvvD = tblDvDat.getModel().getValueAt(tblDvDat.getSelectedRow(), 0).toString();
			}
		});
		scrollPane_2.setViewportView(tblDvDat);
		// Add Service
		JButton btnThemDv = new JButton("Thêm Dv");
		btnThemDv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtTenDv.getText().equals("") || txtGiaDv.getText().equals("")) {
					if (txtTenDv.getText().equals(""))
						JOptionPane.showMessageDialog(null, "vui lòng nhập tên dịch vụ");
					else
						JOptionPane.showMessageDialog(null, "vui lòng nhập giá dịch vụ");

				} else if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thêm!", "Kiểm tra lại",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					adapterMd.ThemDichVu(txtTenDv.getText().toString(), txtTenLoaiDv.getText().toString(), txtGiaDv.getText().toString());
					adapterMd = new TruyVanKaraoke();
					tblDv.setModel(adapterMd.loadDichVu()); // CHỈNH SỬA TABLE TỪ TRUYVANKARAOKE
				}
			}
		});
		btnThemDv.setBounds(20, 886, 150, 51);
		btnThemDv.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThemDv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plus.png")));
		btnThemDv.setText("Thêm");
		btnThemDv.setBackground(new Color(255, 246, 143));
		contentPane.add(btnThemDv);

		// Delete service
		JButton btnXoaDv = new JButton("Xóa Dv");
		btnXoaDv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				JOptionPane.showConfirmDialog(null, "Kiểm tra lại các mặt hàng chưa thanh toán trc khi xóa!",
						"Cẩn thận!", dialogButton);
				if (dialogButton == JOptionPane.YES_OPTION) {
					adapterMd.XoaId("tb_dichvu", "ma_dv", chonDichvu);
					adapterMd = new TruyVanKaraoke();
					tblDv.setModel(adapterMd.loadDichVu());
				}
			}
		});
		btnXoaDv.setBounds(268, 886, 150, 51);
		btnXoaDv.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoaDv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete.png")));
		btnXoaDv.setText("Xóa");
		btnXoaDv.setBackground(new Color(255, 246, 143));
		contentPane.add(btnXoaDv);

		JList list_1 = new JList();
		list_1.setBounds(369, 221, 1, 1);
		contentPane.add(list_1);
		// JPanel 1
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh sách dịch vụ:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel_1.setBounds(20, 122, 553, 432);
		panel_1.setBackground(SystemColor.decode("#87A2FB"));

		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		// JTable
		tblDv = new JTable();
		tblDv.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));
		tblDv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				chonDichvu = tblDv.getModel().getValueAt(tblDv.getSelectedRow(), 0).toString();
			}
		});
		scrollPane.setViewportView(tblDv);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(Color.GRAY));
		panel_3.setBounds(639, 422, 673, 432);
		panel_3.setBackground(SystemColor.decode("#87A2FB"));
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JLabel label = new JLabel("HÓA ĐƠN DỊCH VỤ");
		label.setBounds(199, 11, 141, 23);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_3.add(label);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(46, 60, 452, 185);
		panel_3.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));

		JScrollPane scrollPane_3 = new JScrollPane();
		panel_4.add(scrollPane_3);
		// JTable
		tblTt = new JTable();
		scrollPane_3.setViewportView(tblTt);

		JLabel newLabel = new JLabel("Tổng tiền:");
		newLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		newLabel.setBounds(360, 353, 111, 23);
		panel_3.add(newLabel);

		lblTongtien = new JLabel("0 VNĐ");
		lblTongtien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTongtien.setBounds(481, 355, 144, 23);
		panel_3.add(lblTongtien);

		JLabel lblkaraoke = new JLabel();
		lblkaraoke.setForeground(new Color(0, 0, 238));
		lblkaraoke.setBounds(160, 25, 300, 34);
		panel_3.add(lblkaraoke);

		JLabel lblNewLabel_3 = new JLabel("Số lượng dv:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(343, 292, 128, 30);
		panel_3.add(lblNewLabel_3);

		lblSldv = new JLabel("0");
		lblSldv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSldv.setBounds(481, 302, 111, 14);
		panel_3.add(lblSldv);

		JLabel lblNewLabel_6 = new JLabel("Người lập phiếu:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(10, 271, 166, 23);
		panel_3.add(lblNewLabel_6);

		cmbNhanvien = new JComboBox();
		cmbNhanvien.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cmbNhanvien.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (cmbNhanvien.getSelectedIndex() == 0)
					lblNv.setText("");
				else
					lblNv.setText(cmbNhanvien.getSelectedItem().toString());
			}
		});
		cmbNhanvien.setBounds(176, 264, 141, 41);
		panel_3.add(cmbNhanvien);

		lblNv = new JLabel("");
		lblNv.setBounds(39, 281, 153, 14);
		panel_3.add(lblNv);

		JButton btnXemHd = new JButton();
		// Watch invoice
		btnXemHd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adapterMd = new TruyVanKaraoke();
				tblTt.setModel(adapterMd.loadTtDv());

				lblSldv.setText(adapterCtr.demDong("tb_hoadondv", adapterCtr.demHddv));
				lblTongtien.setText(adapterCtr.demTien(adapterCtr.demtien1) + " VNĐ");
			}
		});
		btnXemHd.setBounds(1152, 354, 160, 42);
		btnXemHd.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXemHd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/eye.png")));
		btnXemHd.setText("Xem Hóa Đơn");
		btnXemHd.setBackground(new Color(255, 246, 143));
		contentPane.add(btnXemHd);

		JButton btnDatDv = new JButton();
		btnDatDv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adapterMd.ThemHoaDonDv(chonDichvu, adapterCtr.gioHt, adapterCtr.ngayHt);
				adapterMd = new TruyVanKaraoke();
				tblDvDat.setModel(adapterMd.loadHdDv());
			}
		});
		btnDatDv.setBounds(639, 350, 167, 51);
		btnDatDv.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDatDv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/redo2.png")));
		btnDatDv.setText("Đặt Dịch vụ");
		btnDatDv.setBackground(new Color(255, 246, 143));
		contentPane.add(btnDatDv);

		JButton btnNewButton = new JButton();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adapterMd.XoaId("tb_hoadondv", "ma_hddv", chonDvvD);
				adapterMd = new TruyVanKaraoke();
				tblDvDat.setModel(adapterMd.loadHdDv());
			}
		});
		btnNewButton.setBounds(904, 354, 160, 42);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/undo2.png")));
		btnNewButton.setText("Hủy Dịch vụ");
		btnNewButton.setBackground(new Color(255, 246, 143));
		contentPane.add(btnNewButton);
		// JButton ThanhToan
		JButton btnXuat = new JButton("");
		// Direct payment
		btnXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblSldv.setText("");
				lblTongtien.setText("");
				adapterMd.XoaHddv();
				tblDvDat.setModel(adapterMd.loadHdDv());
				JOptionPane.showMessageDialog(null, "Đã in!");
			}
		});
		btnXuat.setBounds(579, 886, 167, 61);
		btnXuat.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/print.png")));
		btnXuat.setText("Thanh Toán");
		btnXuat.setBackground(new Color(255, 246, 143));
		contentPane.add(btnXuat);
		// JButton ChonPhong
		JButton btnthanhtoansau = new JButton("Chọn phòng đặt dịch vụ");
		btnthanhtoansau.addActionListener(new ActionListener() {
			// Select room - services
			public void actionPerformed(ActionEvent arg0) {
				adapterMd = new TruyVanKaraoke();
				tblDvDat.setModel(adapterMd.loadHdDv());
				FormDichVuPhong chonphong = new FormDichVuPhong();
				chonphong.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				chonphong.setVisible(true);
				chonphong.setLocationRelativeTo(null);
			}
		});
		btnthanhtoansau.setBounds(914, 886, 160, 61);
		btnthanhtoansau.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnthanhtoansau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home.png")));
		btnthanhtoansau.setText("Chọn Phòng");
		btnthanhtoansau.setBackground(new Color(255, 246, 143));
		contentPane.add(btnthanhtoansau);

		JLabel lblNewLabel_5 = new JLabel("DỊCH VỤ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setForeground(new Color(210, 105, 30));
		lblNewLabel_5.setBounds(24, 43, 294, 35);
		contentPane.add(lblNewLabel_5);

		JButton btnRf = new JButton("Refresh");
		btnRf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRf.setBounds(914, 40, 150, 43);
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

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(FormCapNhatDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(FormCapNhatDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(FormCapNhatDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(FormCapNhatDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new FormCapNhatDichVu().setVisible(true);
			}
		});
	}
}
