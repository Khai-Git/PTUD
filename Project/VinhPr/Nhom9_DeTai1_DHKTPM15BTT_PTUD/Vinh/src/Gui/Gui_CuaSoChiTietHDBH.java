package Gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ConnectDB.ConnectDB;
import Dao.ChiTietHDBH_Dao;
import Dao.HoaDonBanHang_DAO;
import Dao.KhachHang_DAO;
import Dao.NhanVien_DAO;
import Dao.SanPham_DAO;
import Entity.ChiTietHDBH;
import Entity.HoaDonBanHang;
import Entity.KhachHang;
import Entity.NhanVien;
import Entity.SanPham;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class Gui_CuaSoChiTietHDBH extends JFrame implements ActionListener, WindowFocusListener, WindowListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textMaHD;
	private JTextField textNL;
	private JTextField textMNV;
	private JTextField textTNV;
	private JTextField textMKH;
	private JTextField textTKH;
	private JTextField textNS;
	private JTextField textDC;
	private JLabel lblSinThoi;
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
	private JButton btnNewButton;
	private HoaDonBanHang_DAO hdBH_Dao;
	private JTextField textGioT;
	private KhachHang_DAO kh_Dao = new KhachHang_DAO();
	private NhanVien_DAO nv_Dao = new NhanVien_DAO();
	private ChiTietHDBH_Dao ctHDBH_Dao = new ChiTietHDBH_Dao();
	private SanPham_DAO sp_Dao = new SanPham_DAO();

	/**
	 * Create the frame.
	 */
	public Gui_CuaSoChiTietHDBH(String maHD) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(270, 70, 1108, 660);
		setResizable(false);
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
		JLabel lblNewLabel = new JLabel("Mã hóa đơn:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(64, 29, 117, 28);
		contentPane.add(lblNewLabel);

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

		JLabel lblMKhchHng = new JLabel("Mã khách hàng:");
		lblMKhchHng.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMKhchHng.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMKhchHng.setBounds(419, 29, 117, 28);
		contentPane.add(lblMKhchHng);

		JLabel lblTnKhchHng = new JLabel("Tên khách hàng:");
		lblTnKhchHng.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTnKhchHng.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTnKhchHng.setBounds(419, 67, 117, 28);
		contentPane.add(lblTnKhchHng);

		JLabel lblNgySinh = new JLabel("Ngày sinh:");
		lblNgySinh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNgySinh.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNgySinh.setBounds(419, 105, 117, 28);
		contentPane.add(lblNgySinh);

		JLabel lblaCh = new JLabel("�?ịa chỉ:");
		lblaCh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblaCh.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblaCh.setBounds(419, 143, 117, 28);
		contentPane.add(lblaCh);

		textMKH = new JTextField();
		textMKH.setEditable(false);
		textMKH.setHorizontalAlignment(SwingConstants.CENTER);
		textMKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		textMKH.setColumns(10);
		textMKH.setBounds(546, 31, 162, 28);
		contentPane.add(textMKH);

		textTKH = new JTextField();
		textTKH.setEditable(false);
		textTKH.setHorizontalAlignment(SwingConstants.CENTER);
		textTKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		textTKH.setColumns(10);
		textTKH.setBounds(546, 69, 162, 28);
		contentPane.add(textTKH);

		textNS = new JTextField();
		textNS.setHorizontalAlignment(SwingConstants.CENTER);
		textNS.setEditable(false);
		textNS.setFont(new Font("Tahoma", Font.BOLD, 14));
		textNS.setColumns(10);
		textNS.setBounds(546, 107, 162, 28);
		contentPane.add(textNS);

		textDC = new JTextField();
		textDC.setHorizontalAlignment(SwingConstants.CENTER);
		textDC.setFont(new Font("Tahoma", Font.BOLD, 14));
		textDC.setEditable(false);
		textDC.setColumns(10);
		textDC.setBounds(546, 149, 461, 28);
		contentPane.add(textDC);

		JLabel lblNgySinh_1 = new JLabel("Ngày sinh:");
		lblNgySinh_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNgySinh_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNgySinh_1.setBounds(718, 29, 117, 28);
		contentPane.add(lblNgySinh_1);

		textGioT = new JTextField();
		textGioT.setHorizontalAlignment(SwingConstants.CENTER);
		textGioT.setFont(new Font("Tahoma", Font.BOLD, 14));
		textGioT.setEditable(false);
		textGioT.setColumns(10);
		textGioT.setBounds(845, 29, 162, 28);
		contentPane.add(textGioT);

		lblSinThoi = new JLabel("Số điện thoại:");
		lblSinThoi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSinThoi.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSinThoi.setBounds(718, 67, 117, 28);
		contentPane.add(lblSinThoi);

		textSDT = new JTextField();
		textSDT.setEditable(false);
		textSDT.setFont(new Font("Tahoma", Font.BOLD, 14));
		textSDT.setHorizontalAlignment(SwingConstants.CENTER);
		textSDT.setColumns(10);
		textSDT.setBounds(845, 69, 162, 28);
		contentPane.add(textSDT);

		String[] cols_1 = { "STT", "Mã sản phẩm", "Tên sản phẩm", "Màu", "Size", "Hãng", "Số lượng", "Lô hàng",
				"�?ơn giá", "Thành ti�?n" };
		dtm_1 = new DefaultTableModel(cols_1, 10);
		tableDSSP = new JTable(dtm_1);
		tableDSSP.setEnabled(false);
		JScrollPane scrollDSSP = new JScrollPane(tableDSSP);
		scrollDSSP.setBounds(10, 274, 1074, 181);
		contentPane.add(scrollDSSP);
		tableDSSP.getColumnModel().getColumn(0).setPreferredWidth(27);

		lblNewLabel_1 = new JLabel("Danh Sách Sản Phẩm");
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

		lblNewLabel_4 = new JLabel("Tổng thành ti�?n (VND):");
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

		btnNewButton = new JButton("Xác nhận");
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(925, 542, 117, 36);
		contentPane.add(btnNewButton);
		// Lấy data
		ArrayList<HoaDonBanHang> hdBH1 = new ArrayList<HoaDonBanHang>();
		hdBH1 = hdBH_Dao.dsMHD(maHD);
		String maHD1 = null;
		String ngayL = null;
		String tenNV = null;
		String maNV = null;
		String maKH = null;
		String tenKH = null;
		String ngayS = null;
		String diaC = null;
		String sdt = null;
		String gioiT = null;
		DefaultTableModel tableSP1 = (DefaultTableModel) tableDSSP.getModel();
		tableSP1.setRowCount(0);
		for (HoaDonBanHang hoaDonBanHang : hdBH1) {
			maHD1 = hoaDonBanHang.getMaHD();
			ngayL = hoaDonBanHang.getNgayL().toString();
			maNV = hoaDonBanHang.getMaNV().getMaNhanVien();
			maKH = hoaDonBanHang.getMaKH().getSoDienThoai();
			ArrayList<KhachHang> kh = kh_Dao.getMKH(maKH);
			for (KhachHang kh1 : kh) {
				tenKH = kh1.getTenKhachHang();
				ngayS = kh1.getNgaySinh().toString();
				diaC = kh1.getDiaChi();
				sdt = kh1.getSoDienThoai();
				gioiT = kh1.getGioiTinh();
			}
			ArrayList<NhanVien> nv = nv_Dao.getMNV(maNV);
			for (NhanVien nhanVien : nv) {
				tenNV = nhanVien.getTenNhanVien();
			}
			int n = tableDSSP.getRowCount();
			ArrayList<ChiTietHDBH> cthd = ctHDBH_Dao.getMHD(maHD1);
			for (ChiTietHDBH chiTietHDBH : cthd) {
				String maSP = chiTietHDBH.getMaSP().getMaSanPham();
				String soL = String.valueOf(chiTietHDBH.getSoL());
				String tt = String.valueOf(chiTietHDBH.gettT());
				ArrayList<SanPham> sp = sp_Dao.timMSP(maSP);
				for (SanPham sanPham : sp) {
					String tenSP = sanPham.getTenSanPham();
					String mau = sanPham.getMau();
					String size = sanPham.getSize();
					String hang = sanPham.getHang();
					String lH = sanPham.getLoHang();
					String dg = String.valueOf(sanPham.getGiaBan());
					tableSP1.addRow(new Object[] { n + 1, maSP, tenSP, mau, size, hang, soL, lH, dg, tt });
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
		textMKH.setText(maKH);
		textTKH.setText(tenKH);
		textNS.setText(ngayS);
		textDC.setText(diaC);
		textGioT.setText(gioiT);
		textSDT.setText(sdt);

		// �?ăng ký event
		this.addWindowFocusListener(this);
		this.addWindowListener(this);
		btnNewButton.addActionListener(this);
	}

	public void addData() {

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
		if (obj.equals(btnNewButton)) {
			dispose();
		}

	}
}
