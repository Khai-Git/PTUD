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
import Dao.ChiTietHDNH_Dao;
import Dao.HoaDonNhapHang_DAO;
import Dao.NhaCungCap_DAO;
import Entity.HoaDonNhapHang;
import Entity.NhaCungCap;

import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

public class Gui_QLHoaDonNH extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableDSHDNH;
	private DefaultTableModel dtm;
	private JLabel lblNewLabel_2;
	private JTextField textData;
	private JButton btnTK;
	private JButton btnBack;
	private JComboBox<String> comboBox;
	private JButton btnLM;
	private JButton btnCTHD;
	private JPanel panel;
	private HoaDonNhapHang_DAO hdNH_Dao;
	private JButton btnAddHD;
	private JButton btnXoahd;
	private NhaCungCap_DAO ncc_Dao = new NhaCungCap_DAO();
	private ChiTietHDNH_Dao cthd_Dao = new ChiTietHDNH_Dao();


	/**
	 * Create the frame.
	 */
	public Gui_QLHoaDonNH() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setSize(1600, 1000);
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

		JLabel lblNewLabel = new JLabel("Danh Sách Hóa �?ơn Nhập Hàng");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(619, 70, 511, 53);
		contentPane.add(lblNewLabel);

		String[] cols = { "STT", "Mã hóa đơn", "Ngày lâp", "Mã nhà cung cấp", "Tên nhà cung cấp", "Email",
				"Số điện thoại", "�?ịa chỉ" };
		dtm = new DefaultTableModel(cols, 50);
		tableDSHDNH = new JTable(dtm);
		tableDSHDNH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JScrollPane scrollSP = new JScrollPane(tableDSHDNH);
		scrollSP.setBounds(10, 144, 1520, 388);
		contentPane.add(scrollSP, BorderLayout.NORTH);

		lblNewLabel_2 = new JLabel("Tìm kiếm theo:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(28, 591, 143, 31);
		contentPane.add(lblNewLabel_2);

		textData = new JTextField();
		textData.setHorizontalAlignment(SwingConstants.CENTER);
		textData.setFont(new Font("Tahoma", Font.BOLD, 15));
		textData.setColumns(10);
		textData.setBounds(414, 591, 183, 31);
		contentPane.add(textData);

		btnTK = new JButton("Tìm kiếm");
		btnTK.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTK.setBounds(607, 591, 101, 31);
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
				new String[] { "mã hóa đơn", "ngày lập hóa đơn", "số điện thoại nhà cung cấp", "tên nhà cung cấp" }));
		comboBox.setBounds(181, 591, 223, 31);
		contentPane.add(comboBox);

		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(38, 565, 1431, 86);
		contentPane.add(panel);
		panel.setLayout(null);

		btnAddHD = new JButton("Thêm hóa đơn");
		btnAddHD.setBounds(1040, 28, 143, 31);
		panel.add(btnAddHD);
		btnAddHD.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnCTHD = new JButton("Chi tiết hóa đơn");
		btnCTHD.setBounds(859, 28, 148, 31);
		panel.add(btnCTHD);
		btnCTHD.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnLM = new JButton("Làm mới");
		btnLM.setBounds(709, 28, 101, 31);
		panel.add(btnLM);
		btnLM.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnXoahd = new JButton("Xóa hóa đơn");
		btnXoahd.setBounds(1234, 28, 143, 31);
		panel.add(btnXoahd);
		btnXoahd.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoahd.addActionListener(this);
		btnLM.addActionListener(this);
		btnCTHD.addActionListener(this);
		btnAddHD.addActionListener(this);

		// Lấy danh sách các hóa đơn
		ArrayList<HoaDonNhapHang> hdNH1 = new ArrayList<HoaDonNhapHang>();
		hdNH1 = hdNH_Dao.dsHD();
		addData(hdNH1);

		// đăng ký sự kiện
		btnBack.addActionListener(this);
		btnTK.addActionListener(this);
	}

	// Hàm add date vào table
	public void addData(ArrayList<HoaDonNhapHang> hd) {
		DefaultTableModel tableSP1 = (DefaultTableModel) tableDSHDNH.getModel();
		ArrayList<NhaCungCap> ncc = new ArrayList<NhaCungCap>();
		tableSP1.setRowCount(0);
		String maHD;
		String ngayL;
		String maNCC;
		String ten = null;
		String email = null;
		String sdt = null;
		String dc = null;
		for (HoaDonNhapHang hoaDonNhapHang : hd) {
			maHD = hoaDonNhapHang.getMaHD();
			ngayL = hoaDonNhapHang.getNgayL().toString();
			maNCC = hoaDonNhapHang.getMaNCC().getMaNhaCungCap();
			ncc = ncc_Dao.timMNCC(maNCC);
			for (NhaCungCap nhaCungCap : ncc) {
				ten = nhaCungCap.getTenNhaCungCap();
				email = nhaCungCap.getEmail();
				sdt = nhaCungCap.getSoDienThoai();
				dc = nhaCungCap.getDiaChi();
			}
			int n = tableDSHDNH.getRowCount();
			tableSP1.addRow(new Object[] { n + 1, maHD, ngayL, maNCC, ten, email, sdt, dc });
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

		// event search
		else if (obj.equals(btnTK)) {
			String data = textData.getText();
			if (data.equals("")) {
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
				if (comboBox.getSelectedItem().equals("tên nhà cung cấp")) {
					ArrayList<HoaDonNhapHang> hdNH1 = new ArrayList<HoaDonNhapHang>();
					ArrayList<NhaCungCap> ncc = new ArrayList<NhaCungCap>();
					ncc = ncc_Dao.timTNCC(data);
					for (NhaCungCap nhaCungCap : ncc) {
						String ma = nhaCungCap.getMaNhaCungCap();
						hdNH1 = hdNH_Dao.getMNCC(ma);
						addData(hdNH1);
					}

				} else {
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

		// event add hóa đơn
		else if (obj.equals(btnAddHD)) {
			new Gui_HoaDonNhapHang().setVisible(true);
			dispose();
		}

		// event xem chi tiết hóa đơn
		else if (obj.equals(btnCTHD)) {
			int row = tableDSHDNH.getSelectedRow();
			String maHD = dtm.getValueAt(row, 1).toString();
			new Gui_CuaSoChiTietHDNH(maHD).setVisible(true);
		}

		// event xóa hóa đơn
		else if (obj.equals(btnXoahd)) {
			int confirm = JOptionPane.showConfirmDialog(this, "Ban co muon ket thuc?", "Thông báo",
					JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				int row = tableDSHDNH.getSelectedRow();
				String maHD = dtm.getValueAt(row, 1).toString();
				cthd_Dao.deleteMHD(maHD);
				hdNH_Dao.delete(maHD);
				ArrayList<HoaDonNhapHang> hdNH1 = new ArrayList<HoaDonNhapHang>();
				hdNH1 = hdNH_Dao.dsHD();
				addData(hdNH1);
				comboBox.setSelectedItem("mã hóa đơn");
				textData.setText("");
			}
		}

		// event làm mới
		else if (obj.equals(btnLM)) {
			ArrayList<HoaDonNhapHang> hdNH1 = new ArrayList<HoaDonNhapHang>();
			hdNH1 = hdNH_Dao.dsHD();
			addData(hdNH1);
			comboBox.setSelectedItem("mã hóa đơn");
			textData.setText("");
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
