package Gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
import Dao.NhanVien_DAO;
import Dao.SanPham_DAO;
import Entity.ChiTietHDNH;
import Entity.HoaDonNhapHang;
import Entity.NhaCungCap;
import Entity.NhanVien;
import Entity.SanPham;

public class Gui_CuaSoChiTietHDNH extends JFrame implements ActionListener, WindowFocusListener, WindowListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textMaHD;
	private JTextField textNL;
	private JTextField textMNV;
	private JTextField textTNV;
	private JTextField textMNCC;
	private JTextField textTNCC;
	private JTextField textEmail;
	private JTextField textDC;
	private JLabel lblSDT;
	private JTextField textSDT;
	private DefaultTableModel dtm_1;
	private JTable tableDSSP;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField textCK;
	private JTextField textThue;
	private JTextField textTongTien;
	private JButton btnXN;
	private HoaDonNhapHang_DAO hdNH_Dao;
	private NhanVien_DAO nv_Dao = new NhanVien_DAO();
	private NhaCungCap_DAO ncc_Dao = new NhaCungCap_DAO();
	private SanPham_DAO sp_Dao = new SanPham_DAO();
	private ChiTietHDNH_Dao ctNH_Dao = new ChiTietHDNH_Dao();


	/**
	 * Create the frame.
	 */
	public Gui_CuaSoChiTietHDNH(String maHD) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(270, 70, 1108, 660);
		setResizable(false);
		this.requestFocusInWindow(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("Mã hóa đơn:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(64, 29, 117, 28);
		contentPane.add(lblNewLabel);

		// connect database
		hdNH_Dao = new HoaDonNhapHang_DAO();
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JLabel lblNgyLp = new JLabel("Ngày lập:");
		lblNgyLp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNgyLp.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNgyLp.setBounds(64, 67, 117, 28);
		contentPane.add(lblNgyLp);

		textMaHD = new JTextField();
		textMaHD.setEditable(false);
		textMaHD.setHorizontalAlignment(SwingConstants.CENTER);
		textMaHD.setFont(new Font("Tahoma", Font.BOLD, 14));
		textMaHD.setBounds(191, 31, 162, 28);
		contentPane.add(textMaHD);
		textMaHD.setColumns(10);

		textNL = new JTextField();
		textNL.setEditable(false);
		textNL.setFont(new Font("Tahoma", Font.BOLD, 14));
		textNL.setHorizontalAlignment(SwingConstants.CENTER);
		textNL.setColumns(10);
		textNL.setBounds(191, 69, 162, 28);
		contentPane.add(textNL);

		JLabel lblMNhnVin = new JLabel("Mã nhân viên:");
		lblMNhnVin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMNhnVin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMNhnVin.setBounds(64, 105, 117, 28);
		contentPane.add(lblMNhnVin);

		JLabel lblTnNhnVin = new JLabel("Tên nhân viên:");
		lblTnNhnVin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTnNhnVin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTnNhnVin.setBounds(64, 143, 117, 28);
		contentPane.add(lblTnNhnVin);

		textMNV = new JTextField();
		textMNV.setHorizontalAlignment(SwingConstants.CENTER);
		textMNV.setEditable(false);
		textMNV.setFont(new Font("Tahoma", Font.BOLD, 14));
		textMNV.setColumns(10);
		textMNV.setBounds(191, 107, 162, 28);
		contentPane.add(textMNV);

		textTNV = new JTextField();
		textTNV.setEditable(false);
		textTNV.setHorizontalAlignment(SwingConstants.CENTER);
		textTNV.setFont(new Font("Tahoma", Font.BOLD, 14));
		textTNV.setColumns(10);
		textTNV.setBounds(191, 145, 162, 28);
		contentPane.add(textTNV);

		JLabel lblMNCC = new JLabel("Mã nhà cung cấp:");
		lblMNCC.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMNCC.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMNCC.setBounds(389, 29, 147, 28);
		contentPane.add(lblMNCC);

		JLabel lblTnKhchHng = new JLabel("Tên nhà cung cấp:");
		lblTnKhchHng.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTnKhchHng.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTnKhchHng.setBounds(389, 67, 147, 28);
		contentPane.add(lblTnKhchHng);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setBounds(419, 105, 117, 28);
		contentPane.add(lblEmail);

		JLabel lblaDC = new JLabel("Địa chỉ:");
		lblaDC.setHorizontalAlignment(SwingConstants.RIGHT);
		lblaDC.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblaDC.setBounds(419, 143, 117, 28);
		contentPane.add(lblaDC);

		textMNCC = new JTextField();
		textMNCC.setEditable(false);
		textMNCC.setHorizontalAlignment(SwingConstants.CENTER);
		textMNCC.setFont(new Font("Tahoma", Font.BOLD, 14));
		textMNCC.setColumns(10);
		textMNCC.setBounds(546, 31, 162, 28);
		contentPane.add(textMNCC);

		textTNCC = new JTextField();
		textTNCC.setEditable(false);
		textTNCC.setHorizontalAlignment(SwingConstants.CENTER);
		textTNCC.setFont(new Font("Tahoma", Font.BOLD, 14));
		textTNCC.setColumns(10);
		textTNCC.setBounds(546, 69, 162, 28);
		contentPane.add(textTNCC);

		textEmail = new JTextField();
		textEmail.setHorizontalAlignment(SwingConstants.CENTER);
		textEmail.setEditable(false);
		textEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		textEmail.setColumns(10);
		textEmail.setBounds(546, 107, 162, 28);
		contentPane.add(textEmail);

		textDC = new JTextField();
		textDC.setHorizontalAlignment(SwingConstants.CENTER);
		textDC.setFont(new Font("Tahoma", Font.BOLD, 14));
		textDC.setEditable(false);
		textDC.setColumns(10);
		textDC.setBounds(546, 149, 461, 28);
		contentPane.add(textDC);

		lblSDT = new JLabel("Số điện thoại:");
		lblSDT.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSDT.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSDT.setBounds(718, 67, 117, 28);
		contentPane.add(lblSDT);

		textSDT = new JTextField();
		textSDT.setEditable(false);
		textSDT.setFont(new Font("Tahoma", Font.BOLD, 14));
		textSDT.setHorizontalAlignment(SwingConstants.CENTER);
		textSDT.setColumns(10);
		textSDT.setBounds(845, 69, 162, 28);
		contentPane.add(textSDT);

		String[] cols_1 = { "STT", "Mã sản phẩm", "Tên sản phẩm", "Màu", "Size", "Số lượng", "Lô hàng", "Đơn giá",
				"Thành tiền" };
		dtm_1 = new DefaultTableModel(cols_1, 10);
		tableDSSP = new JTable(dtm_1);
		tableDSSP.setEnabled(false);
		JScrollPane scrollDSSP = new JScrollPane(tableDSSP);
		scrollDSSP.setBounds(10, 274, 1074, 181);
		contentPane.add(scrollDSSP);
		tableDSSP.getColumnModel().getColumn(0).setPreferredWidth(27);

		lblNewLabel_1 = new JLabel("Danh Sách Sản Phẩm ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(434, 206, 332, 58);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Chiết khấu (%):");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(240, 494, 139, 28);
		contentPane.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Thuế (%):");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(587, 494, 100, 28);
		contentPane.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Tổng thành tiền (VND):");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_4.setBounds(64, 555, 312, 42);
		contentPane.add(lblNewLabel_4);

		textCK = new JTextField();
		textCK.setFont(new Font("Tahoma", Font.BOLD, 14));
		textCK.setHorizontalAlignment(SwingConstants.CENTER);
		textCK.setEditable(false);
		textCK.setColumns(10);
		textCK.setBounds(389, 494, 96, 31);
		contentPane.add(textCK);

		textThue = new JTextField();
		textThue.setHorizontalAlignment(SwingConstants.CENTER);
		textThue.setEditable(false);
		textThue.setFont(new Font("Tahoma", Font.BOLD, 14));
		textThue.setColumns(10);
		textThue.setBounds(697, 494, 96, 31);
		contentPane.add(textThue);

		textTongTien = new JTextField();
		textTongTien.setHorizontalAlignment(SwingConstants.CENTER);
		textTongTien.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		textTongTien.setEditable(false);
		textTongTien.setColumns(10);
		textTongTien.setBounds(386, 554, 407, 58);
		contentPane.add(textTongTien);

		btnXN = new JButton("Xác nhận");
		btnXN.setBackground(Color.GREEN);
		btnXN.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXN.setBounds(925, 542, 117, 36);
		contentPane.add(btnXN);

		// Lấy data
		ArrayList<HoaDonNhapHang> hdBH1 = new ArrayList<HoaDonNhapHang>();
		hdBH1 = hdNH_Dao.dsMHD(maHD);
		ArrayList<NhanVien> nv = new ArrayList<NhanVien>();
		ArrayList<NhaCungCap> ncc = new ArrayList<NhaCungCap>();
		ArrayList<SanPham> sp = new ArrayList<SanPham>();
		ArrayList<ChiTietHDNH> ctNH = new ArrayList<ChiTietHDNH>();
		String maHD1 = null;
		String maSP = null;
		int sL;
		String ngayL = null;
		String tenNV = null;
		String maNV = null;
		String maNCC = null;
		String tenNCC = null;
		String email = null;
		String diaC = null;
		String sdt = null;
		DefaultTableModel tableSP1 = (DefaultTableModel) tableDSSP.getModel();
		tableSP1.setRowCount(0);
		for (HoaDonNhapHang hoaDonNhapHang : hdBH1) {
			maHD1 = hoaDonNhapHang.getMaHD();
			ngayL = hoaDonNhapHang.getNgayL().toString();
			maNV = hoaDonNhapHang.getMaNV().getMaNhanVien();
			nv = nv_Dao.getMNV(maNV);
			for (NhanVien nhanVien : nv) {
				tenNV = nhanVien.getTenNhanVien();
			}
			maNCC = hoaDonNhapHang.getMaNCC().getMaNhaCungCap();
			ncc = ncc_Dao.timMNCC(maNCC);
			for (NhaCungCap nhaCungCap : ncc) {
				tenNCC = nhaCungCap.getTenNhaCungCap();
				email = nhaCungCap.getEmail();
				diaC = nhaCungCap.getDiaChi();
				sdt = nhaCungCap.getSoDienThoai();
			}
			int n = tableDSSP.getRowCount();
			ctNH = ctNH_Dao.getMHD(maHD1);
			for (ChiTietHDNH chiTietHDNH : ctNH) {
				maSP = chiTietHDNH.getMaSP().getMaSanPham();
				sL = chiTietHDNH.getsL();
				sp = sp_Dao.timMSP(maSP);
				for (SanPham sanPham : sp) {
					tableSP1.addRow(new Object[] { n + 1, sanPham.getMaSanPham(), sanPham.getTenSanPham(),
							sanPham.getMau(), sanPham.getSize(), sL, sanPham.getLoHang(), sanPham.getGiaNhap(),
							sanPham.getGiaBan() });
				}
			}

			double tongTien = 0;
			for (int i = 0; i < n + 1; i++) {
				String tongTien2 = dtm_1.getValueAt(i, 8).toString();
				tongTien = tongTien + Double.parseDouble(tongTien2);
				String thue = "10";
				String chietKhau = "1";
				tongTien = tongTien + (tongTien * 0.1) - (tongTien * 0.01);
				String s = String.valueOf(tongTien);
				textCK.setText(chietKhau);
				textThue.setText(thue);
				textTongTien.setText(s);
			}
		}
		textMaHD.setText(maHD1);
		textNL.setText(ngayL);
		textMNV.setText(maNV);
		textTNV.setText(tenNV);
		textMNCC.setText(maNCC);
		textTNCC.setText(tenNCC);
		textEmail.setText(email);
		textDC.setText(diaC);
		textSDT.setText(sdt);

		// Đăng ký event
		this.addWindowFocusListener(this);
		this.addWindowListener(this);
		btnXN.addActionListener(this);

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowGainedFocus(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowLostFocus(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnXN)) {
			dispose();
		}

	}

}
