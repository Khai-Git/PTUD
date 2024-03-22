package Gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import ConnectDB.ConnectDB;
import Dao.HoaDonBanHang_DAO;
import Dao.KhachHang_DAO;
import Entity.HoaDonBanHang;
import Entity.KhachHang;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

public class Gui_XemHDBH extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textData;
	private DefaultTableModel dtm;
	private JTable tableSP;
	private HoaDonBanHang_DAO hdBH_Dao;
	private JButton btnXemCT;
	private JButton btnLM;
	private JButton btnTK;
	private JButton btnBack;
	private JComboBox<String> comboBox;
	private JPanel panel;
	private KhachHang_DAO kh_Dao = new KhachHang_DAO();


	/**
	 * Create the frame.
	 */
	public Gui_XemHDBH() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setSize(1920, 1080);
		setBounds(100, 100, 1611, 882);
		this.requestFocusInWindow(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// connect database
		hdBH_Dao = new HoaDonBanHang_DAO();
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		btnBack = new JButton("Trở lại");
		btnBack.setBackground(Color.RED);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setForeground(Color.WHITE);
		btnBack.setBounds(10, 10, 106, 36);
		contentPane.add(btnBack);

		JLabel lblTKT = new JLabel("Tìm kiếm theo: ");
		lblTKT.setHorizontalAlignment(SwingConstants.CENTER);
		lblTKT.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTKT.setBounds(309, 147, 106, 28);
		contentPane.add(lblTKT);

		textData = new JTextField();
		textData.setHorizontalAlignment(SwingConstants.CENTER);
		textData.setFont(new Font("Tahoma", Font.BOLD, 13));
		textData.setColumns(10);
		textData.setBounds(607, 147, 172, 28);
		contentPane.add(textData);

		btnTK = new JButton("Tìm kiếm");
		btnTK.setBackground(Color.LIGHT_GRAY);
		btnTK.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTK.setBounds(789, 143, 142, 36);
		contentPane.add(btnTK);

		btnLM = new JButton("Làm mới");
		btnLM.setBackground(Color.LIGHT_GRAY);
		btnLM.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLM.setBounds(941, 143, 142, 36);
		contentPane.add(btnLM);

		btnXemCT = new JButton("Xem chi tiết");
		btnXemCT.setBackground(Color.LIGHT_GRAY);
		btnXemCT.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXemCT.setBounds(1093, 143, 142, 36);
		contentPane.add(btnXemCT);

		JLabel lblNewLabel_2 = new JLabel("Danh Sách Hóa Đơn Bán Hàng ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(565, 242, 403, 63);
		contentPane.add(lblNewLabel_2);

		String[] cols = { "STT", "Mã hóa đơn", "Ngày lập", "Mã khách hàng", "Tên khách hàng", "Ngày sinh",
				"Số điện thoại", "Địa chỉ" };
		dtm = new DefaultTableModel(cols, 0);
		tableSP = new JTable(dtm);
		tableSP.setBackground(Color.WHITE);
		tableSP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JScrollPane scrollSP = new JScrollPane(tableSP);
		scrollSP.setBounds(69, 315, 1424, 330);
		contentPane.add(scrollSP);
		tableSP.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);

		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setModel(
				new DefaultComboBoxModel<String>(new String[] { "mã hóa đơn", "mã khách hàng", "số điện thoại" }));
		comboBox.setBounds(425, 148, 172, 28);
		contentPane.add(comboBox);

		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(264, 108, 1026, 103);
		contentPane.add(panel);

		// Lấy danh sách các hóa đơn
		ArrayList<HoaDonBanHang> hdBH1 = new ArrayList<HoaDonBanHang>();
		hdBH1 = hdBH_Dao.dsHD();
		getData(hdBH1);

		// Đăng ký envent
		btnXemCT.addActionListener(this);
		tableSP.addMouseListener(this);
		btnLM.addActionListener(this);
		btnTK.addActionListener(this);
		btnBack.addActionListener(this);

	}

	// get Data add table
	public void getData(ArrayList<HoaDonBanHang> hd) {
		DefaultTableModel tableSP1 = (DefaultTableModel) tableSP.getModel();
		String maHD;
		String maKH;
		String ngayL;
		String tenKH = null;
		String sdt = null;
		String ngayS = null;
		String dc = null;
		int n = 0;
		tableSP1.setRowCount(0);
		for (HoaDonBanHang hoaDonBanHang : hd) {
			maHD = hoaDonBanHang.getMaHD();
			ngayL = hoaDonBanHang.getNgayL().toString();
			maKH = hoaDonBanHang.getMaKH().getSoDienThoai();
			n++;
			ArrayList<KhachHang> kh = new ArrayList<KhachHang>();
			kh = kh_Dao.getMKH(maKH);
			for (KhachHang kh2 : kh) {
				tenKH = kh2.getTenKhachHang();
				ngayS = kh2.getNgaySinh().toString();
				dc = kh2.getDiaChi();
				sdt = kh2.getSoDienThoai();

			}
			tableSP1.addRow(new Object[] { n, maHD, ngayL, maKH, tenKH, ngayS, sdt, dc });
			tableSP1.fireTableDataChanged();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		// event xem chi tiết hóa đơn
		if (obj.equals(btnXemCT)) {
			int row = tableSP.getSelectedRow();
			String maHD = dtm.getValueAt(row, 1).toString();
			new Gui_CuaSoChiTietHDBH(maHD).setVisible(true);
		}

		// event làm mới
		else if (obj.equals(btnLM)) {
			textData.setText("");
			comboBox.setSelectedItem("mã hóa đơn");
			ArrayList<HoaDonBanHang> hdBH1 = new ArrayList<HoaDonBanHang>();
			hdBH1 = hdBH_Dao.dsHD();
			getData(hdBH1);
		}

		// event tìm kiếm
		else if (obj.equals(btnTK)) {
			String data = textData.getText();
			if (data.equals("")) {
				JOptionPane.showMessageDialog(this, "Nhập thông tin hóa đơn cần tìm!!");
			} else {
				if (comboBox.getSelectedItem().equals("mã hóa đơn")) {
					ArrayList<HoaDonBanHang> hdBH1 = new ArrayList<HoaDonBanHang>();
					hdBH1 = hdBH_Dao.dsMHD(data);
					getData(hdBH1);
				}
				if (comboBox.getSelectedItem().equals("mã khách hàng")) {
					ArrayList<HoaDonBanHang> hdBH1 = new ArrayList<HoaDonBanHang>();
					hdBH1 = hdBH_Dao.timMKH(data);
					getData(hdBH1);
				}
				if (comboBox.getSelectedItem().equals("số điện thoại")) {
					ArrayList<HoaDonBanHang> hdBH1 = new ArrayList<HoaDonBanHang>();
					ArrayList<KhachHang> kh = new ArrayList<KhachHang>();
					kh = kh_Dao.getKHSDT(data);
					for (KhachHang khachHang : kh) {
						String maKH = khachHang.getMaKhachHang();
						hdBH1 = hdBH_Dao.timMKH(maKH);
						getData(hdBH1);
					}
				}

			}
		}

		// event trở về
		else if (obj.equals(btnBack)) {
			new Gui_NhanVien().setVisible(true);
			dispose();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {

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
