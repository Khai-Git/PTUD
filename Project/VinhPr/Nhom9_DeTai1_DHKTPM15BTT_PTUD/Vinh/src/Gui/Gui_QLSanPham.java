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
import Dao.ChiTietHDNH_Dao;
import Dao.HoaDonBanHang_DAO;
import Dao.HoaDonNhapHang_DAO;
import Dao.SanPham_DAO;
import Entity.ChiTietHDBH;
import Entity.ChiTietHDNH;
import Entity.SanPham;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;

public class Gui_QLSanPham extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel dtm;
	private JTable tableDSSP;
	private JLabel lblNewLabel_2;
	private JButton btnTK;
	private JButton btnBack;
	private JButton btnXSP;
	private JButton btnAddSP;
	private JButton btnUpdate;
	private JButton btnLM;
	private SanPham_DAO sp_Dao;
	private ChiTietHDBH_Dao ctHDBH_Dao = new ChiTietHDBH_Dao();
	private ChiTietHDNH_Dao ctHDNH_Dao = new ChiTietHDNH_Dao();
	private HoaDonNhapHang_DAO hdNH_Dao = new HoaDonNhapHang_DAO();
	private HoaDonBanHang_DAO hdBH_Dao = new HoaDonBanHang_DAO();
	private JComboBox<String> comboBox;
	private JTextField textData;
	private JPanel panel;


	/**
	 * Create the frame.
	 */
	public Gui_QLSanPham() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setSize(1600, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// connect database
		sp_Dao = new SanPham_DAO();
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JLabel lblNewLabel = new JLabel("Danh Sách Sản Phẩm");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(619, 70, 511, 53);
		contentPane.add(lblNewLabel);

		String[] cols = { "STT", "Mã sản phẩm", "Tên sản phẩm", "Màu", "Hãng", "Size", "Loại", "Số lượng tồn",
				"Lô hàng", "Ngày Nhập", "Giá nhập", "Giá bán", "Mã nhà cung cấp", "Tên nhà cung cấp" };
		dtm = new DefaultTableModel(cols, 20);
		tableDSSP = new JTable(dtm);
		tableDSSP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JScrollPane scrollSP = new JScrollPane(tableDSSP);
		scrollSP.setBounds(10, 156, 1520, 345);
		contentPane.add(scrollSP, BorderLayout.NORTH);

		lblNewLabel_2 = new JLabel("Tìm kiếm theo: ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(46, 613, 159, 31);
		contentPane.add(lblNewLabel_2);

		btnTK = new JButton("Tìm kiếm");
		btnTK.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTK.setBounds(658, 610, 118, 37);
		contentPane.add(btnTK);

		btnUpdate = new JButton("Cập nhật thông tin ");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(1121, 610, 183, 37);
		contentPane.add(btnUpdate);

		btnLM = new JButton("Làm mới");
		btnLM.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLM.setBounds(790, 610, 112, 37);
		contentPane.add(btnLM);

		btnBack = new JButton("Trở v�?");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBackground(Color.RED);
		btnBack.setBounds(10, 10, 101, 31);
		contentPane.add(btnBack);

		btnXSP = new JButton("Xóa sản phẩm");
		btnXSP.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXSP.setBounds(1322, 610, 143, 37);
		contentPane.add(btnXSP);

		btnAddSP = new JButton("Thêm sản phẩm");
		btnAddSP.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddSP.setBounds(923, 610, 183, 37);
		contentPane.add(btnAddSP);

		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setModel(
				new DefaultComboBoxModel<String>(new String[] { "Tìm theo mã sản phẩm", "Tìm theo tên sản phẩm" }));
		comboBox.setBounds(228, 613, 195, 31);
		contentPane.add(comboBox);

		textData = new JTextField();
		textData.setHorizontalAlignment(SwingConstants.CENTER);
		textData.setFont(new Font("Tahoma", Font.BOLD, 14));
		textData.setBounds(446, 613, 195, 31);
		contentPane.add(textData);
		textData.setColumns(10);

		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(46, 578, 1456, 103);
		contentPane.add(panel);

		// get data
		getData();

		// �?ăng ký sự kiện
		btnBack.addActionListener(this);
		btnLM.addActionListener(this);
		btnAddSP.addActionListener(this);
		btnTK.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnXSP.addActionListener(this);

	}

	// Lấy data add table
	public void getData() {
		ArrayList<SanPham> sp = new ArrayList<SanPham>();
		sp = sp_Dao.dsSP();
		DefaultTableModel tableSP1 = (DefaultTableModel) tableDSSP.getModel();
		tableSP1.setRowCount(0);
		for (SanPham sanPham : sp) {
			int n = tableDSSP.getRowCount();
			tableSP1.addRow(new Object[] { n + 1, sanPham.getMaSanPham(), sanPham.getTenSanPham(), sanPham.getMau(),
					sanPham.getHang(), sanPham.getSize(), sanPham.getLoai(), sanPham.getSoLuongTon(),
					sanPham.getLoHang(), sanPham.getNgayNhap(), sanPham.getGiaNhap(), sanPham.getGiaBan(),
					sanPham.getMaNCC().getMaNhaCungCap(), sanPham.getTenNCC().getMaNhaCungCap() });

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

		// event Lam moi
		else if (obj.equals(btnLM)) {
			comboBox.setSelectedItem("Tìm kiếm theo tên sản phẩm");
			textData.setText("");
			getData();

		}

		// event tìm kiếm
		else if (obj.equals(btnTK)) {
			String data = textData.getText();
			if (data.equals("")) {
				JOptionPane.showMessageDialog(this, "Nhập thông tin sản phẩm cần tìm !!");
			} else {
				if (comboBox.getSelectedItem().equals("Tìm theo tên sản phẩm")) {
					ArrayList<SanPham> sp = new ArrayList<SanPham>();
					sp = sp_Dao.timTSP(data);
					DefaultTableModel tableSP1 = (DefaultTableModel) tableDSSP.getModel();
					tableSP1.setRowCount(0);
					for (SanPham sanPham : sp) {
						int n = tableDSSP.getRowCount();
						tableSP1.addRow(new Object[] { n + 1, sanPham.getMaSanPham(), sanPham.getTenSanPham(),
								sanPham.getMau(), sanPham.getSize(), sanPham.getLoai(), sanPham.getSoLuongTon(),
								sanPham.getLoHang(), sanPham.getNgayNhap(), sanPham.getMaNCC().getMaNhaCungCap(),
								sanPham.getTenNCC().getMaNhaCungCap(), sanPham.getGiaNhap(), sanPham.getGiaBan() });

					}
				} else {
					ArrayList<SanPham> sp = new ArrayList<SanPham>();
					sp = sp_Dao.timMSP(data);
					DefaultTableModel tableSP1 = (DefaultTableModel) tableDSSP.getModel();
					tableSP1.setRowCount(0);
					for (SanPham sanPham : sp) {
						int n = tableDSSP.getRowCount();
						tableSP1.addRow(new Object[] { n + 1, sanPham.getMaSanPham(), sanPham.getTenSanPham(),
								sanPham.getMau(), sanPham.getSize(), sanPham.getLoai(), sanPham.getSoLuongTon(),
								sanPham.getLoHang(), sanPham.getNgayNhap(), sanPham.getMaNCC().getMaNhaCungCap(),
								sanPham.getTenNCC().getMaNhaCungCap(), sanPham.getGiaNhap(), sanPham.getGiaBan() });

					}
				}
			}
		}

		// event update sản phẩm
		else if (obj.equals(btnUpdate)) {
			int row = tableDSSP.getSelectedRow();
			String maSP = dtm.getValueAt(row, 1).toString();
			new Gui_CuaSoUpDateSP(maSP).setVisible(true);
		}

		// event thêm sản phẩm
		else if (obj.equals(btnAddSP)) {
			new Gui_HoaDonNhapHang().setVisible(true);
			dispose();
		}

		// event xóa sản phẩm
		else if (obj.equals(btnXSP)) {
			ArrayList<ChiTietHDBH> a = new ArrayList<ChiTietHDBH>();
			ArrayList<ChiTietHDNH> b = new ArrayList<ChiTietHDNH>();
			int row = tableDSSP.getSelectedRow();
			String ma = dtm.getValueAt(row, 1).toString();
			b = ctHDNH_Dao.getMSP(ma);
			for (ChiTietHDNH chiTietHDNH : b) {
				String maHD1 = chiTietHDNH.getMaHD().getMaHD();
				ctHDNH_Dao.deleteMHD(maHD1);
				hdNH_Dao.delete(maHD1);
			}
			a = ctHDBH_Dao.getMSP(ma);
			for (ChiTietHDBH chiTietHDBH : a) {
				String maHD2 = chiTietHDBH.getMaHD().getMaHD();
				ctHDBH_Dao.deleteMHD(maHD2);
				hdBH_Dao.deleteMHD(maHD2);
			}
			sp_Dao.delete(ma);
			comboBox.setSelectedItem("Tìm kiếm theo tên sản phẩm");
			textData.setText("");
			getData();
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
