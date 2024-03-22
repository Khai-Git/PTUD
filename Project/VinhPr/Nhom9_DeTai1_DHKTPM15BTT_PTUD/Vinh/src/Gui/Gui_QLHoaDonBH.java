package Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.time.LocalDate;
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

public class Gui_QLHoaDonBH extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel dtm;
	private JTable tableDSHDBH;
	private JLabel lblNewLabel_2;
	private JTextField textData;
	private JButton btnTK;
	private JButton btnBack;
	private JButton btnXoahd;
	private JButton btnAddhd;
	private JButton btnLM;
	private HoaDonBanHang_DAO hdBH_Dao;
	private JComboBox<String> comboBox;
	private JButton btnChiTitHa;
	private JPanel panel;
	private KhachHang_DAO kh_Dao = new KhachHang_DAO();
	private ChiTietHDBH_Dao cthd_Dao = new ChiTietHDBH_Dao();


	/**
	 * Create the frame.
	 */
	public Gui_QLHoaDonBH() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setSize(1600, 1000);
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

		JLabel lblNewLabel = new JLabel("Danh Sách Hóa �?ơn Bán Hàng");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(619, 70, 511, 53);
		contentPane.add(lblNewLabel);

		String[] cols = { "STT", "Mã hóa đơn", "Ngày lâp", "Mã khách hàng", "Tên khách hàng", "Ngày sinh", "Giới Tính",
				"Số điện thoại", "�?ịa chỉ" };
		dtm = new DefaultTableModel(cols, 50);
		tableDSHDBH = new JTable(dtm);
		tableDSHDBH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JScrollPane scrollSP = new JScrollPane(tableDSHDBH);
		scrollSP.setBounds(10, 152, 1520, 388);
		contentPane.add(scrollSP, BorderLayout.NORTH);

		lblNewLabel_2 = new JLabel("Tìm kiếm theo:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(51, 601, 132, 31);
		contentPane.add(lblNewLabel_2);

		textData = new JTextField();
		textData.setHorizontalAlignment(SwingConstants.CENTER);
		textData.setFont(new Font("Tahoma", Font.BOLD, 15));
		textData.setColumns(10);
		textData.setBounds(362, 601, 159, 31);
		contentPane.add(textData);

		btnTK = new JButton("Tìm kiếm");
		btnTK.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTK.setBounds(531, 596, 109, 41);
		contentPane.add(btnTK);

		btnBack = new JButton("Trở v�?");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBackground(Color.RED);
		btnBack.setBounds(10, 10, 101, 31);
		contentPane.add(btnBack);

		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel<String>(
				new String[] { "mã hóa đơn", "ngày lập hóa đơn", "số điện thoại", "tên khách hàng" }));
		comboBox.setBounds(193, 601, 159, 31);
		contentPane.add(comboBox);

		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(51, 566, 1403, 106);
		contentPane.add(panel);
		panel.setLayout(null);

		btnAddhd = new JButton("Thêm hóa đơn");
		btnAddhd.setBounds(970, 31, 164, 41);
		panel.add(btnAddhd);
		btnAddhd.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnChiTitHa = new JButton("Chi tiết hóa đơn");
		btnChiTitHa.setBounds(771, 31, 164, 41);
		panel.add(btnChiTitHa);
		btnChiTitHa.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnLM = new JButton("Làm mới");
		btnLM.setBounds(631, 31, 109, 41);
		panel.add(btnLM);
		btnLM.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnXoahd = new JButton("Xóa hóa đơn");
		btnXoahd.setBounds(1177, 33, 164, 36);
		panel.add(btnXoahd);
		btnXoahd.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoahd.addActionListener(this);
		btnLM.addActionListener(this);
		btnChiTitHa.addActionListener(this);
		btnAddhd.addActionListener(this);

		// get data add table
		ArrayList<HoaDonBanHang> hdBH1 = new ArrayList<HoaDonBanHang>();
		hdBH1 = hdBH_Dao.dsHD();
		getData(hdBH1);

		// �?ăng ký sự kiện
		btnBack.addActionListener(this);
		btnTK.addActionListener(this);

	}

	// add data in table from sql
	public void getData(ArrayList<HoaDonBanHang> hdbh) {
		DefaultTableModel tableSP1 = (DefaultTableModel) tableDSHDBH.getModel();
		ArrayList<KhachHang> kh = new ArrayList<KhachHang>();
		tableSP1.setRowCount(0);
		String maHD;
		String ngayL;
		String maKH;
		String tenKH = null;
		String ngayS = null;
		String gt = null;
		String sdt = null;
		String dc = null;
		for (HoaDonBanHang hoaDonBanHang : hdbh) {
			maHD = hoaDonBanHang.getMaHD();
			ngayL = hoaDonBanHang.getNgayL().toString();
			maKH = hoaDonBanHang.getMaKH().getSoDienThoai();
			kh = kh_Dao.getMKH(maKH);
			for (KhachHang khachHang : kh) {
				tenKH = khachHang.getTenKhachHang();
				ngayS = khachHang.getNgaySinh().toString();
				gt = khachHang.getGioiTinh();
				sdt = khachHang.getSoDienThoai();
				dc = khachHang.getDiaChi();
			}
			int n = tableSP1.getRowCount();
			tableSP1.addRow(new Object[] { n + 1, maHD, ngayL, maKH, tenKH, ngayS, gt, sdt, dc });
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

		// event thêm hóa đơn mới
		else if (obj.equals(btnAddhd)) {
			new Gui_HoaDonBanHang().setVisible(true);
			dispose();
		}

		// event Làm mới table
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
				if (comboBox.getSelectedItem().equals("ngày lập hóa đơn")) {
					ArrayList<HoaDonBanHang> hdBH1 = new ArrayList<HoaDonBanHang>();
					LocalDate a = LocalDate.parse(data);
					hdBH1 = hdBH_Dao.timNgay(a);
					getData(hdBH1);
				}
				if (comboBox.getSelectedItem().equals("tên khách hàng")) {
					ArrayList<HoaDonBanHang> hdBH1 = new ArrayList<HoaDonBanHang>();
					ArrayList<KhachHang> kh = new ArrayList<KhachHang>();
					kh = kh_Dao.getTKH(data);
					for (KhachHang khachHang : kh) {
						String ma = khachHang.getMaKhachHang();
						hdBH1 = hdBH_Dao.timMKH(ma);
						getData(hdBH1);
					}

				}

				else {
					ArrayList<HoaDonBanHang> hdBH1 = new ArrayList<HoaDonBanHang>();
					ArrayList<KhachHang> kh = new ArrayList<KhachHang>();
					kh = kh_Dao.getKHSDT(data);
					for (KhachHang khachHang : kh) {
						String ma = khachHang.getMaKhachHang();
						hdBH1 = hdBH_Dao.timMKH(ma);
						getData(hdBH1);
					}
				}

			}
		}

		// event xoa hoa don
		else if (obj.equals(btnXoahd)) {
			int confirm = JOptionPane.showConfirmDialog(this, "Ban co muon ket thuc?", "Thông báo",
					JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				int row = tableDSHDBH.getSelectedRow();
				String maHD = dtm.getValueAt(row, 1).toString();
				cthd_Dao.deleteMHD(maHD);
				hdBH_Dao.deleteMHD(maHD);
				textData.setText("");
				comboBox.setSelectedItem("mã hóa đơn");
				ArrayList<HoaDonBanHang> hdBH1 = new ArrayList<HoaDonBanHang>();
				hdBH1 = hdBH_Dao.dsHD();
				getData(hdBH1);

			}
		}

		// event chi tiet hoa don
		else if (obj.equals(btnChiTitHa)) {
			int row = tableDSHDBH.getSelectedRow();
			String maHD = dtm.getValueAt(row, 1).toString();
			new Gui_CuaSoChiTietHDBH(maHD).setVisible(true);
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
