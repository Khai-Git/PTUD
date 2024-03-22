package Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ConnectDB.ConnectDB;
import Dao.ChiTietHDBH_Dao;
import Dao.HoaDonBanHang_DAO;
import Dao.KhachHang_DAO;
import Entity.HoaDonBanHang;
import Entity.KhachHang;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

public class Gui_QLKhachHang extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableDSKH;
	private DefaultTableModel dtm;
	private JLabel lblNewLabel_2;
	private JTextField textData;
	private JButton btnUpdate;
	private JButton btnXoaKH;
	private JButton btnBack;
	private JButton btnTKH;
	private JButton btnTK;
	private JButton btnLM;
	private KhachHang_DAO kh_Dao;
	private HoaDonBanHang_DAO hd_Dao = new HoaDonBanHang_DAO();
	private ChiTietHDBH_Dao cthd_Dao = new ChiTietHDBH_Dao();
	private JComboBox<String> comboBox;
	private JPanel panel;

	/**
	 * Create the frame.
	 */
	public Gui_QLKhachHang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setSize(1600, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// connect database
		kh_Dao = new KhachHang_DAO();
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JLabel lblNewLabel = new JLabel("Danh Sách Khách Hàng");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(619, 70, 511, 53);
		contentPane.add(lblNewLabel);

		String[] cols = { "STT", "Mã khách hàng", "Tên khách hàng", "Ngày sinh", "Giới tính", "Số điện thoại",
				"Địa chỉ" };
		dtm = new DefaultTableModel(cols, 50);
		tableDSKH = new JTable(dtm);
		tableDSKH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JScrollPane scrollSP = new JScrollPane(tableDSKH);
		scrollSP.setBounds(10, 155, 1520, 388);
		contentPane.add(scrollSP, BorderLayout.NORTH);

		lblNewLabel_2 = new JLabel("Tìm kiếm theo:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(84, 641, 142, 31);
		contentPane.add(lblNewLabel_2);

		textData = new JTextField();
		textData.setHorizontalAlignment(SwingConstants.CENTER);
		textData.setFont(new Font("Tahoma", Font.BOLD, 15));
		textData.setColumns(10);
		textData.setBounds(419, 641, 159, 31);
		contentPane.add(textData);

		btnUpdate = new JButton("Cập nhật thông tin ");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(1068, 635, 183, 43);
		contentPane.add(btnUpdate);

		btnXoaKH = new JButton("Xóa khách hàng");
		btnXoaKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoaKH.setBounds(1261, 635, 164, 43);
		contentPane.add(btnXoaKH);

		btnBack = new JButton("Trở về");
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(Color.RED);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(10, 10, 101, 31);
		contentPane.add(btnBack);

		btnTKH = new JButton("Thêm khách hàng");
		btnTKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTKH.setBounds(894, 635, 164, 43);
		contentPane.add(btnTKH);

		btnTK = new JButton("Tìm kiếm");
		btnTK.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTK.setBounds(588, 635, 122, 43);
		contentPane.add(btnTK);

		btnLM = new JButton("Làm mới");
		btnLM.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLM.setBounds(720, 635, 164, 43);
		contentPane.add(btnLM);

		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "tên khách hàng", "số điện thoại" }));
		comboBox.setBounds(236, 641, 173, 31);
		contentPane.add(comboBox);

		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(84, 609, 1387, 97);
		contentPane.add(panel);

		// add data in table
		ArrayList<KhachHang> kh = new ArrayList<KhachHang>();
		kh = kh_Dao.getDSKH();
		getData(kh);

		// Đăng ký sự kiện
		btnXoaKH.addActionListener(this);
		btnBack.addActionListener(this);
		btnLM.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnTKH.addActionListener(this);
		btnTK.addActionListener(this);

	}

	// get data add table from sql
	public void getData(ArrayList<KhachHang> kh) {
		DefaultTableModel tableSP1 = (DefaultTableModel) tableDSKH.getModel();
		tableSP1.setRowCount(0);
		for (KhachHang khachHang : kh) {
			int n = tableDSKH.getRowCount();
			tableSP1.addRow(new Object[] { n + 1, khachHang.getMaKhachHang(), khachHang.getTenKhachHang(),
					khachHang.getNgaySinh(), khachHang.getGioiTinh(), khachHang.getSoDienThoai(),
					khachHang.getDiaChi() });
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		// event back
		if (obj.equals(btnBack)) {
			new Gui_QuanLy().setVisible(true);
			dispose();
		}

		// event lam moi
		else if (obj.equals(btnLM)) {
			textData.setText("");
			comboBox.setSelectedItem("tên khách hàng");
			ArrayList<KhachHang> kh = new ArrayList<KhachHang>();
			kh = kh_Dao.getDSKH();
			getData(kh);
		}

		// event tim kiem
		else if (obj.equals(btnTK)) {
			String data = textData.getText();
			if (data.equals("")) {
				JOptionPane.showMessageDialog(this, "Nhập thông tin khách hàng cần tìm !!");
			} else {
				if (comboBox.getSelectedItem().equals("tên khách hàng")) {
					ArrayList<KhachHang> kh = new ArrayList<KhachHang>();
					kh = kh_Dao.getTKH(data);
					getData(kh);

				} else {
					ArrayList<KhachHang> kh = new ArrayList<KhachHang>();
					kh = kh_Dao.getKHSDT(data);
					getData(kh);
				}
			}
		}

		// event them khach hang
		else if (obj.equals(btnTKH)) {
			new Gui_CuaSoAddKH().setVisible(true);
		}

		// event xoa kh
		else if (obj.equals(btnXoaKH)) {
			int confirm = JOptionPane.showConfirmDialog(this, "Xác nhận thay đổi ?", "Thông báo",
					JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				int row = tableDSKH.getSelectedRow();
				String maKH = dtm.getValueAt(row, 1).toString();
				ArrayList<HoaDonBanHang> hd = new ArrayList<HoaDonBanHang>();
				hd = hd_Dao.timMKH(maKH);
				for (HoaDonBanHang hoaDonBanHang : hd) {
					String maHD = hoaDonBanHang.getMaHD();
					cthd_Dao.deleteMHD(maHD);
					hd_Dao.deleteMHD(maHD);
				}
				kh_Dao.delete(maKH);
				textData.setText("");
				comboBox.setSelectedItem("tên khách hàng");
				ArrayList<KhachHang> kh = new ArrayList<KhachHang>();
				kh = kh_Dao.getDSKH();
				getData(kh);
			}
		}

		// event update kh
		else if (obj.equals(btnUpdate)) {
			int row = tableDSKH.getSelectedRow();
			String ma = dtm.getValueAt(row, 1).toString();
			new Gui_CuaSoUpDateKH(ma).setVisible(true);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
