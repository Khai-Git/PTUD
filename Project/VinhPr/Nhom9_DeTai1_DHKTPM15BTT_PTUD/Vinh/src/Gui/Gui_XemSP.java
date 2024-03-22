package Gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import ConnectDB.ConnectDB;
import Dao.SanPham_DAO;
import Entity.SanPham;

import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

public class Gui_XemSP extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textData;
	private DefaultTableModel dtm;
	private JTable tableDSSP;
	private JButton btnTKiem;

	private SanPham_DAO sp_DAO;
	private JButton btnLM;
	private JButton btnBack;
	private JComboBox<String> comboBox;
	private JPanel panel;


	/**
	 * Create the frame.
	 */
	public Gui_XemSP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setSize(1920, 1080);
		setBounds(100, 100, 1611, 882);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// connect database
		sp_DAO = new SanPham_DAO();
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		btnBack = new JButton("Trở lại");
		btnBack.setBackground(Color.RED);
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.setBounds(33, 23, 94, 28);
		contentPane.add(btnBack);

		JLabel lblTKT = new JLabel("Tìm kiếm theo:");
		lblTKT.setHorizontalAlignment(SwingConstants.CENTER);
		lblTKT.setForeground(Color.BLACK);
		lblTKT.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTKT.setBounds(395, 154, 109, 28);
		contentPane.add(lblTKT);

		textData = new JTextField();
		textData.setHorizontalAlignment(SwingConstants.CENTER);
		textData.setFont(new Font("Tahoma", Font.BOLD, 13));
		textData.setColumns(10);
		textData.setBounds(664, 154, 170, 28);
		contentPane.add(textData);

		btnTKiem = new JButton("Tìm kiếm");
		btnTKiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTKiem.setBounds(844, 146, 131, 43);
		contentPane.add(btnTKiem);

		JLabel lblNewLabel_3 = new JLabel("Danh Sách Sản Phẩm");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(575, 237, 382, 76);
		contentPane.add(lblNewLabel_3);

		new JPanel();
		String[] cols = { "Mã sản phẩm", "Tên sản phẩm", "Màu", "Size", "Loại", "Số lượng tồn", "Lô hàng", "Ngày nhập",
				"Mã nhà cung cấp", "Tên nhà cung cấp", "Giá nhập", "Giá bán" };
		dtm = new DefaultTableModel(cols, 20);
		tableDSSP = new JTable(dtm);
		tableDSSP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JScrollPane scrollSP = new JScrollPane(tableDSSP);
		scrollSP.setBounds(10, 322, 1520, 330);
		contentPane.add(scrollSP);

		btnLM = new JButton("Làm mới");
		btnLM.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLM.setBounds(985, 146, 131, 43);
		contentPane.add(btnLM);

		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setModel(
				new DefaultComboBoxModel<String>(new String[] { "mã sản phẩm", "tên sản phẩm", "nhà cung cấp" }));
		comboBox.setBounds(514, 155, 140, 28);
		contentPane.add(comboBox);

		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(311, 121, 873, 94);
		contentPane.add(panel);

		// Lấy danh sách sản phẩm lên table
		ArrayList<SanPham> dssp = new ArrayList<SanPham>();
		dssp = sp_DAO.dsSP();
		getData(dssp);

		// �?ăng ký sự kiện
		btnTKiem.addActionListener(this);
		btnLM.addActionListener(this);
		btnBack.addActionListener(this);
	}

	// Lấy sản phẩm vào table
	public void getData(ArrayList<SanPham> dssp) {
		DefaultTableModel tableSP1 = (DefaultTableModel) tableDSSP.getModel();
		tableSP1.setRowCount(0);
		for (SanPham sanPham : dssp) {
			tableSP1.addRow(new Object[] { sanPham.getMaSanPham(), sanPham.getTenSanPham(), sanPham.getMau(),
					sanPham.getSize(), sanPham.getLoai(), sanPham.getSoLuongTon(), sanPham.getLoHang(),
					sanPham.getNgayNhap(), sanPham.getMaNCC().getMaNhaCungCap(), sanPham.getTenNCC().getMaNhaCungCap(),
					sanPham.getGiaNhap(), sanPham.getGiaBan() });

		}
		tableSP1.fireTableDataChanged();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		// event tìm kiếm
		if (obj.equals(btnTKiem)) {
			String data = textData.getText();
			if (data.equals("")) {
				JOptionPane.showMessageDialog(this, "Nhập thông tin sản phẩm cần tìm!!");
			} else {
				if (comboBox.getSelectedItem().equals("mã sản phẩm")) {
					ArrayList<SanPham> dssp = new ArrayList<SanPham>();
					dssp = sp_DAO.timMSP(data);
					getData(dssp);
				}
				if (comboBox.getSelectedItem().equals("tên sản phẩm")) {
					ArrayList<SanPham> dssp = new ArrayList<SanPham>();
					dssp = sp_DAO.timTSP(data);
					getData(dssp);
				} else {
					ArrayList<SanPham> dssp = new ArrayList<SanPham>();
					dssp = sp_DAO.timTNCC(data);
					getData(dssp);
				}
			}
		}

		// event làm mới
		else if (obj.equals(btnLM)) {
			textData.setText("");
			comboBox.setSelectedItem("tên sản phẩm");
			ArrayList<SanPham> dssp = new ArrayList<SanPham>();
			dssp = sp_DAO.dsSP();
			getData(dssp);
		}

		// event trở v�?
		else if (obj.equals(btnBack)) {
			new Gui_NhanVien().setVisible(true);
			dispose();
		}

	}
}
