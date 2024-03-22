package Gui;

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
import Dao.HoaDonNhapHang_DAO;
import Dao.NhaCungCap_DAO;
import Entity.HoaDonNhapHang;
import Entity.NhaCungCap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

public class Gui_XemHDNH extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textData;
	private JButton btnXemChiTiet;
	private DefaultTableModel dtm;
	private JTable tableSP;
	private HoaDonNhapHang_DAO hdNH_Dao;
	private JButton btnLM;
	private JButton btnBack;
	private JButton btnTK;
	private JComboBox<String> comboBox;
	private JPanel panel;
	private NhaCungCap_DAO ncc_Dao = new NhaCungCap_DAO();


	/**
	 * Create the frame.
	 */
	public Gui_XemHDNH() {
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
		hdNH_Dao = new HoaDonNhapHang_DAO();
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JLabel lblNewLabel_2 = new JLabel("Danh Sách Hóa Đơn Nhập Hàng ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(569, 213, 403, 63);
		contentPane.add(lblNewLabel_2);

		btnBack = new JButton("Trở về");
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(Color.RED);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(10, 10, 105, 32);
		contentPane.add(btnBack);

		JLabel lblTKT = new JLabel("Tìm kiếm theo: ");
		lblTKT.setHorizontalAlignment(SwingConstants.CENTER);
		lblTKT.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTKT.setBounds(292, 134, 106, 28);
		contentPane.add(lblTKT);

		textData = new JTextField();
		textData.setHorizontalAlignment(SwingConstants.CENTER);
		textData.setFont(new Font("Tahoma", Font.BOLD, 13));
		textData.setColumns(10);
		textData.setBounds(637, 134, 172, 28);
		contentPane.add(textData);

		btnTK = new JButton("Tìm kiếm");
		btnTK.setBackground(Color.LIGHT_GRAY);
		btnTK.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTK.setBounds(819, 130, 131, 36);
		contentPane.add(btnTK);

		btnXemChiTiet = new JButton("Xem chi tiết");
		btnXemChiTiet.setBackground(Color.LIGHT_GRAY);
		btnXemChiTiet.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXemChiTiet.setBounds(1101, 130, 143, 36);
		contentPane.add(btnXemChiTiet);

		btnLM = new JButton("Làm mới");
		btnLM.setBackground(Color.LIGHT_GRAY);
		btnLM.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLM.setBounds(960, 130, 131, 36);
		contentPane.add(btnLM);

		String[] cols = { "STT", "Mã hóa đơn", "Ngày lập", "Mã nhà cung cấp", "Tên nhà cung cấp", "Số điện thoại",
				"Địa chỉ", "Email" };
		dtm = new DefaultTableModel(cols, 20);
		tableSP = new JTable(dtm);
		tableSP.setBackground(Color.WHITE);
		tableSP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JScrollPane scrollSP = new JScrollPane(tableSP);
		scrollSP.setBounds(69, 315, 1424, 330);
		contentPane.add(scrollSP);
		tableSP.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);

		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "mã hóa đơn", "ngày lập hóa đơn",
				"mã nhà cung cấp", "tên nhà cung cấp", "số điện thoại nhà cung cấp" }));
		comboBox.setBounds(408, 134, 219, 28);
		contentPane.add(comboBox);

		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(253, 92, 1054, 111);
		contentPane.add(panel);

		// Lấy danh sách các hóa đơn
		ArrayList<HoaDonNhapHang> hdNH1 = new ArrayList<HoaDonNhapHang>();
		hdNH1 = hdNH_Dao.dsHD();
		addData(hdNH1);
		// Đăng ký sự kiện
		btnXemChiTiet.addActionListener(this);
		tableSP.addMouseListener(this);
		btnLM.addActionListener(this);
		btnTK.addActionListener(this);
		btnBack.addActionListener(this);
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

	// Hàm add date vào table
	public void addData(ArrayList<HoaDonNhapHang> hd) {
		DefaultTableModel tableSP1 = (DefaultTableModel) tableSP.getModel();
		tableSP1.setRowCount(0);
		for (HoaDonNhapHang hoaDonNhapHang : hd) {
			String maHD = hoaDonNhapHang.getMaHD();
			String ngayL = hoaDonNhapHang.getNgayL().toString();
			String maNCC = hoaDonNhapHang.getMaNCC().getMaNhaCungCap();
			String ten = null;
			String sdt = null;
			String dc = null;
			String email = null;
			ArrayList<NhaCungCap> ncc = ncc_Dao.timMNCC(maNCC);
			for (NhaCungCap nhaCungCap : ncc) {
				ten = nhaCungCap.getTenNhaCungCap();
				sdt = nhaCungCap.getSoDienThoai();
				dc = nhaCungCap.getDiaChi();
				email = nhaCungCap.getEmail();
			}

			int n = tableSP.getRowCount();
			tableSP1.addRow(new Object[] { n + 1, maHD, ngayL, maNCC, ten, sdt, dc, email });
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		// event xem chi tiết hóa đơn
		if (obj.equals(btnXemChiTiet)) {
			int row = tableSP.getSelectedRow();
			String maHD = dtm.getValueAt(row, 1).toString();
			new Gui_CuaSoChiTietHDNH(maHD).setVisible(true);
		}
		// event trở về
		else if (obj.equals(btnBack)) {
			new Gui_NhanVien().setVisible(true);
			dispose();
		}
		// event tìm kiếm
		else if (obj.equals(btnTK)) {
			String data = textData.getText();
			if (textData.getText().equals("")) {

				JOptionPane.showMessageDialog(this, "Nhập thông tin hóa đơn cần tìm!!");

			} else {
				if (comboBox.getSelectedItem().equals("mã hóa đơn")) {
					ArrayList<HoaDonNhapHang> hdNH1 = new ArrayList<HoaDonNhapHang>();
					hdNH1 = hdNH_Dao.dsMHD(data);
					addData(hdNH1);
				}
				if (comboBox.getSelectedItem().equals("ngày lập hóa đơn")) {
					ArrayList<HoaDonNhapHang> hdNH1 = new ArrayList<HoaDonNhapHang>();
					LocalDate a = LocalDate.parse(data);
					hdNH1 = hdNH_Dao.getNL(a);
					addData(hdNH1);
				}
				if (comboBox.getSelectedItem().equals("mã nhà cung cấp")) {
					ArrayList<HoaDonNhapHang> hdNH1 = new ArrayList<HoaDonNhapHang>();
					hdNH1 = hdNH_Dao.getMNCC(data);
					addData(hdNH1);
				}

				if (comboBox.getSelectedItem().equals("tên nhà cung cấp")) {
					ArrayList<HoaDonNhapHang> hdNH1 = new ArrayList<HoaDonNhapHang>();
					ArrayList<NhaCungCap> ncc = new ArrayList<NhaCungCap>();
					ncc = ncc_Dao.timTNCC(data);
					for (NhaCungCap nhaCungCap : ncc) {
						String ma = nhaCungCap.getMaNhaCungCap();
						hdNH1 = hdNH_Dao.getMNCC(ma);
						addData(hdNH1);
					}

				}
				if (comboBox.getSelectedItem().equals("số điện thoại nhà cung cấp")) {
					ArrayList<HoaDonNhapHang> hdNH1 = new ArrayList<HoaDonNhapHang>();
					ArrayList<NhaCungCap> ncc = new ArrayList<NhaCungCap>();
					ncc = ncc_Dao.timSDT(data);
					for (NhaCungCap nhaCungCap : ncc) {
						String ma = nhaCungCap.getMaNhaCungCap();
						hdNH1 = hdNH_Dao.getMNCC(ma);
						addData(hdNH1);
					}
				}

			}
		}

		// event làm mới
		else if (obj.equals(btnLM)) {
			textData.setText("");
			comboBox.setSelectedItem("mã hóa đơn");
			ArrayList<HoaDonNhapHang> hdNH1 = new ArrayList<HoaDonNhapHang>();
			hdNH1 = hdNH_Dao.dsHD();
			addData(hdNH1);
		}

	}
}
