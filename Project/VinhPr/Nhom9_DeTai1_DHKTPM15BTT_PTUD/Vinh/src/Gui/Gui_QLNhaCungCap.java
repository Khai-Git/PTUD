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
import Dao.ChiTietHDNH_Dao;
import Dao.HoaDonNhapHang_DAO;
import Dao.NhaCungCap_DAO;
import Entity.HoaDonNhapHang;
import Entity.NhaCungCap;

import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

public class Gui_QLNhaCungCap extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel dtm;
	private JTable tableDSNCC;
	private JLabel lblTk;
	private JButton btnXoa;
	private JTextField textData;
	private JButton btnUpdate;
	private JButton btnTrV;
	private JButton btnAdd;
	private JButton btnTK;
	private JButton btnLM;
	private JComboBox<String> comboBox;
	private JPanel panel;
	private NhaCungCap_DAO ncc_Dao;
	private HoaDonNhapHang_DAO hd_Dao = new HoaDonNhapHang_DAO();
	private ChiTietHDNH_Dao cthd_Dao = new ChiTietHDNH_Dao();


	/**
	 * Create the frame.
	 */
	public Gui_QLNhaCungCap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setSize(1600, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// connect data
		ncc_Dao = new NhaCungCap_DAO();
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JLabel lblNewLabel = new JLabel("Danh Sách Nhà Cung Cấp");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(619, 70, 511, 53);
		contentPane.add(lblNewLabel);

		String[] cols = { "STT", "Mã nhà cung cấp", "Tên nhà cung cấp", "Email", "Số điện thoại", "�?ịa chỉ" };
		dtm = new DefaultTableModel(cols, 50);
		tableDSNCC = new JTable(dtm);
		tableDSNCC.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JScrollPane scrollSP = new JScrollPane(tableDSNCC);
		scrollSP.setBounds(10, 152, 1520, 388);
		contentPane.add(scrollSP, BorderLayout.NORTH);

		lblTk = new JLabel("Tìm kiếm theo:");
		lblTk.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTk.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTk.setBounds(95, 597, 142, 31);
		contentPane.add(lblTk);

		textData = new JTextField();
		textData.setHorizontalAlignment(SwingConstants.CENTER);
		textData.setFont(new Font("Tahoma", Font.BOLD, 15));
		textData.setColumns(10);
		textData.setBounds(416, 597, 159, 31);
		contentPane.add(textData);

		btnUpdate = new JButton("Cập nhật thông tin ");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(863, 594, 183, 37);
		contentPane.add(btnUpdate);

		btnXoa = new JButton("Xóa nhà cung cấp");
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoa.setBounds(1255, 594, 164, 34);
		contentPane.add(btnXoa);

		btnTrV = new JButton("Trở v�?");
		btnTrV.setForeground(Color.WHITE);
		btnTrV.setBackground(Color.RED);
		btnTrV.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTrV.setBounds(10, 10, 101, 31);
		contentPane.add(btnTrV);

		btnAdd = new JButton("Thêm nhà cung cấp");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdd.setBounds(1056, 594, 189, 37);
		contentPane.add(btnAdd);

		btnTK = new JButton("Tìm kiếm");
		btnTK.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTK.setBounds(585, 594, 129, 37);
		contentPane.add(btnTK);

		btnLM = new JButton("Làm mới");
		btnLM.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLM.setBounds(724, 594, 129, 37);
		contentPane.add(btnLM);

		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "tên nhà cung cấp", "số điện thoại" }));
		comboBox.setBounds(247, 597, 159, 31);
		contentPane.add(comboBox);

		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(39, 568, 1453, 93);
		contentPane.add(panel);

		// get data
		ArrayList<NhaCungCap> ncc = new ArrayList<NhaCungCap>();
		ncc = ncc_Dao.getDSNCC();
		getData(ncc);

		// đăng ký sự kiện
		btnTrV.addActionListener(this);
		btnLM.addActionListener(this);
		btnAdd.addActionListener(this);
		btnTK.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnXoa.addActionListener(this);
	}

	// get data from sql add in table
	public void getData(ArrayList<NhaCungCap> ncc) {
		DefaultTableModel tableSP1 = (DefaultTableModel) tableDSNCC.getModel();
		tableSP1.setRowCount(0);
		for (NhaCungCap nhaCungCap : ncc) {
			int n = tableDSNCC.getRowCount();
			tableSP1.addRow(new Object[] { n + 1, nhaCungCap.getMaNhaCungCap(), nhaCungCap.getTenNhaCungCap(),
					nhaCungCap.getEmail(), nhaCungCap.getSoDienThoai(), nhaCungCap.getDiaChi() });
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		// event back
		if (obj.equals(btnTrV)) {
			new Gui_QuanLy().setVisible(true);
			dispose();
		}

		// event làm mới
		else if (obj.equals(btnLM)) {
			textData.setText("");
			comboBox.setSelectedItem("tên nhà cung cấp");
			ArrayList<NhaCungCap> ncc = new ArrayList<NhaCungCap>();
			ncc = ncc_Dao.getDSNCC();
			getData(ncc);
		}

		// event tìm kiếm
		else if (obj.equals(btnTK)) {
			String data = textData.getText();
			if (data.equals("")) {
				JOptionPane.showMessageDialog(this, "Nhập thông tin nhà cung cấp cần tìm");
			} else {
				if (comboBox.getSelectedItem().equals("tên nhà cung cấp")) {
					ArrayList<NhaCungCap> ncc = new ArrayList<NhaCungCap>();
					ncc = ncc_Dao.timTNCC(data);
					getData(ncc);
				} else {
					ArrayList<NhaCungCap> ncc = new ArrayList<NhaCungCap>();
					ncc = ncc_Dao.timSDT(data);
					getData(ncc);
				}
			}
		}

		// event xoa nha cung cap
		else if (obj.equals(btnXoa)) {
			int row = tableDSNCC.getSelectedRow();
			String maNCC = dtm.getValueAt(row, 1).toString();
			ArrayList<HoaDonNhapHang> hd = new ArrayList<HoaDonNhapHang>();
			hd = hd_Dao.getMNCC(maNCC);
			for (HoaDonNhapHang hoaDonNhapHang : hd) {
				String maHD = hoaDonNhapHang.getMaHD();
				cthd_Dao.deleteMHD(maHD);
				hd_Dao.delete(maHD);
			}
			ncc_Dao.deleteMNCC(maNCC);
			textData.setText("");
			comboBox.setSelectedItem("tên nhà cung cấp");
			ArrayList<NhaCungCap> ncc = new ArrayList<NhaCungCap>();
			ncc = ncc_Dao.getDSNCC();
			getData(ncc);
		}

		// event update
		else if (obj.equals(btnUpdate)) {
			int row = tableDSNCC.getSelectedRow();
			String ma = dtm.getValueAt(row, 1).toString();
			new Gui_CuaSoUpDateNCC(ma).setVisible(true);
		}

		// event add
		else if (obj.equals(btnAdd)) {
			new Gui_CuaSoAddNCC().setVisible(true);
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
