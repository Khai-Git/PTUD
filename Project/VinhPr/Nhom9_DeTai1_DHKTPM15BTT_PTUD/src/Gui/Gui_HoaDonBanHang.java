package Gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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

import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;

public class Gui_HoaDonBanHang extends JFrame implements ActionListener, MouseListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textData;
	private JTable tableSP;
	private JTextField textMHD;
	private JTextField textMKH;
	private JTextField textTKH;
	private JTextField textNL;
	private JTextField textNS;
	private JTextField textDC;
	private JTextField textSDT;
	private JTable tableDSSP;
	private JTextField textChietKhau;
	private JTextField textThue;
	private JTextField texTongThanhTien;
	private JButton btnBack;
	private HoaDonBanHang_DAO hdBH_Dao;
	HoaDonBanHang_DAO hdBH1 = new HoaDonBanHang_DAO();
	private KhachHang_DAO kh_Dao;
	private SanPham_DAO sp_Dao = new SanPham_DAO();
	private JButton btnKtra;
	private JRadioButton rdbtnNu;
	private JRadioButton rdbtnNam;
	private JButton btnXoaRong;
	private JButton btnTim;
	private JButton btnThem;
	private JButton btnXoaSP;
	private DefaultTableModel dtm_1;
	private DefaultTableModel dtm;
	private JTextField textTienKhachDua;
	private JTextField textTienThoi;
	private JButton btnXR;
	private JButton btnLuu;
	private JLabel lblMaNV;
	private JLabel lblTenNV;
	private JButton btnHuy;
	static String ncc;
	private JPanel panel_1;
	private JComboBox<String> comboBoxTSP;
	private ChiTietHDBH_Dao ctHDBH_Dao = new ChiTietHDBH_Dao();
	private NhanVien_DAO nv_Dao = new NhanVien_DAO();
	private JTextField textSL;

	

	/**
	 * Create the frame.
	 */
	public Gui_HoaDonBanHang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setSize(1600, 1000);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
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

		btnBack = new JButton("Trở về");
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnBack.setBackground(new Color(255, 0, 51));
		btnBack.setBounds(21, 17, 106, 29);
		contentPane.add(btnBack);

		JLabel lblNewLabel = new JLabel("Mã nhân viên:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(1248, 17, 90, 34);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Tên nhân viên:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(1248, 54, 90, 33);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("HÓA ĐƠN BÁN HÀNG");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(550, 17, 502, 76);
		contentPane.add(lblNewLabel_2);

		JLabel lblTKT = new JLabel("Tìm kiếm theo:");
		lblTKT.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTKT.setHorizontalAlignment(SwingConstants.CENTER);
		lblTKT.setBounds(33, 173, 117, 29);
		contentPane.add(lblTKT);

		textData = new JTextField();
		textData.setHorizontalAlignment(SwingConstants.CENTER);
		textData.setFont(new Font("Tahoma", Font.BOLD, 14));
		textData.setColumns(10);
		textData.setBounds(297, 174, 186, 29);
		contentPane.add(textData);

		JLabel lblNewLabel_3_1_1 = new JLabel("Số lượng:");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setBounds(37, 335, 90, 29);
		contentPane.add(lblNewLabel_3_1_1);

		String[] cols = { "Mã sản phẩm", "Tên sản phẩm", "Màu", "Size", "Hang", "Số lượng tồn", "Lô hàng", "Đơn giá" };
		dtm = new DefaultTableModel(cols, 0);
		tableSP = new JTable(dtm);
		tableSP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JScrollPane scrollSP = new JScrollPane(tableSP);
		scrollSP.setBounds(33, 213, 691, 114);
		contentPane.add(scrollSP);

		btnTim = new JButton("Tìm Kiếm");
		btnTim.setForeground(Color.BLACK);
		btnTim.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTim.setBackground(Color.LIGHT_GRAY);
		btnTim.setBounds(493, 174, 111, 29);
		contentPane.add(btnTim);

		btnThem = new JButton("Thêm vào hóa đơn");
		btnThem.setBackground(Color.LIGHT_GRAY);
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThem.setBounds(186, 336, 142, 29);
		contentPane.add(btnThem);

		btnXoaSP = new JButton("Xóa khỏi hóa đơn");
		btnXoaSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXoaSP.setBackground(Color.LIGHT_GRAY);
		btnXoaSP.setBounds(342, 336, 136, 29);
		contentPane.add(btnXoaSP);

		JLabel lblNewLabel_4 = new JLabel("Mã hóa đơn:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(874, 148, 106, 28);
		contentPane.add(lblNewLabel_4);

		textMHD = new JTextField();
		textMHD.setEditable(false);
		textMHD.setHorizontalAlignment(SwingConstants.CENTER);
		textMHD.setFont(new Font("Tahoma", Font.BOLD, 14));
		textMHD.setColumns(10);
		textMHD.setBounds(1001, 141, 174, 36);
		contentPane.add(textMHD);

		JLabel lblNewLabel_4_1 = new JLabel("Ngày lập:");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_1.setBounds(1158, 150, 106, 28);
		contentPane.add(lblNewLabel_4_1);

		JLabel lblNewLabel_4_2 = new JLabel("Mã khách hàng:");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_2.setBounds(874, 199, 106, 28);
		contentPane.add(lblNewLabel_4_2);

		JLabel lblNewLabel_4_3 = new JLabel("Tên khách hàng:");
		lblNewLabel_4_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_3.setBounds(874, 250, 106, 28);
		contentPane.add(lblNewLabel_4_3);

		textMKH = new JTextField();
		textMKH.setEditable(false);
		textMKH.setHorizontalAlignment(SwingConstants.CENTER);
		textMKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		textMKH.setColumns(10);
		textMKH.setBounds(1001, 194, 174, 34);
		contentPane.add(textMKH);

		textTKH = new JTextField();
		textTKH.setHorizontalAlignment(SwingConstants.CENTER);
		textTKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		textTKH.setColumns(10);
		textTKH.setBounds(1001, 246, 174, 34);
		contentPane.add(textTKH);

		textNL = new JTextField();
		textNL.setEditable(false);
		textNL.setFont(new Font("Tahoma", Font.BOLD, 14));
		textNL.setHorizontalAlignment(SwingConstants.CENTER);
		textNL.setColumns(10);
		textNL.setBounds(1274, 141, 244, 41);
		String today = LocalDate.now().toString();
		textNL.setText(today);
		contentPane.add(textNL);

		JLabel lblNewLabel_4_3_1 = new JLabel("Ngày sinh:");
		lblNewLabel_4_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_3_1.setBounds(874, 298, 106, 28);
		contentPane.add(lblNewLabel_4_3_1);

		textNS = new JTextField();
		textNS.setFont(new Font("Tahoma", Font.BOLD, 14));
		textNS.setHorizontalAlignment(SwingConstants.CENTER);
		textNS.setColumns(10);
		textNS.setBounds(1001, 294, 174, 32);
		contentPane.add(textNS);

		JLabel lblNewLabel_4_3_2 = new JLabel("Địa chỉ:");
		lblNewLabel_4_3_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_3_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_3_2.setBounds(1158, 201, 106, 28);
		contentPane.add(lblNewLabel_4_3_2);

		JLabel lblNewLabel_4_3_3 = new JLabel("Số điện thoại:");
		lblNewLabel_4_3_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_3_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_3_3.setBounds(1158, 298, 106, 28);
		contentPane.add(lblNewLabel_4_3_3);

		textDC = new JTextField();
		textDC.setFont(new Font("Tahoma", Font.BOLD, 14));
		textDC.setHorizontalAlignment(SwingConstants.CENTER);
		textDC.setColumns(10);
		textDC.setBounds(1274, 199, 244, 34);
		contentPane.add(textDC);

		textSDT = new JTextField();
		textSDT.setFont(new Font("Tahoma", Font.BOLD, 14));
		textSDT.setHorizontalAlignment(SwingConstants.CENTER);
		textSDT.setColumns(10);
		textSDT.setBounds(1274, 294, 244, 32);
		contentPane.add(textSDT);

		JLabel lblNewLabel_2_1 = new JLabel("Danh Sách Sản Phẩm");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_2_1.setBounds(585, 409, 395, 53);
		contentPane.add(lblNewLabel_2_1);

		String[] cols_1 = { "STT", "Mã sản phẩm", "Tên sản phẩm", "Màu", "Size", "Hang", "Số lượng", "Lô hàng",
				"Đơn giá", "Thành tiền" };
		dtm_1 = new DefaultTableModel(cols_1, 0);
		tableDSSP = new JTable(dtm_1);
		JScrollPane scrollDSSP = new JScrollPane(tableDSSP);
		scrollDSSP.setBounds(14, 461, 1516, 194);
		contentPane.add(scrollDSSP);

		JLabel lblNewLabel_5 = new JLabel("Chiết khấu (%) :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(134, 668, 117, 29);
		contentPane.add(lblNewLabel_5);

		textChietKhau = new JTextField();
		textChietKhau.setFont(new Font("Tahoma", Font.BOLD, 14));
		textChietKhau.setHorizontalAlignment(SwingConstants.CENTER);
		textChietKhau.setBounds(261, 665, 90, 34);
		contentPane.add(textChietKhau);
		textChietKhau.setColumns(10);

		JLabel lblNewLabel_5_1 = new JLabel("Thuế (%) :");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setBounds(389, 668, 90, 29);
		contentPane.add(lblNewLabel_5_1);

		textThue = new JTextField();
		textThue.setFont(new Font("Tahoma", Font.BOLD, 14));
		textThue.setHorizontalAlignment(SwingConstants.CENTER);
		textThue.setColumns(10);
		textThue.setBounds(487, 668, 90, 34);
		contentPane.add(textThue);

		JLabel lblNewLabel_5_2 = new JLabel("Tổng thành tiền (VND) :");
		lblNewLabel_5_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_2.setBounds(0, 705, 251, 53);
		contentPane.add(lblNewLabel_5_2);

		texTongThanhTien = new JTextField();
		texTongThanhTien.setEditable(false);
		texTongThanhTien.setForeground(Color.RED);
		texTongThanhTien.setText("");
		texTongThanhTien.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		texTongThanhTien.setHorizontalAlignment(SwingConstants.CENTER);
		texTongThanhTien.setColumns(10);
		texTongThanhTien.setBounds(261, 709, 316, 51);
		contentPane.add(texTongThanhTien);

		btnLuu = new JButton("Lưu và in hóa đơn");
		btnLuu.setForeground(Color.WHITE);
		btnLuu.setBackground(Color.GREEN);
		btnLuu.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnLuu.setBounds(1333, 714, 174, 42);
		contentPane.add(btnLuu);

		btnHuy = new JButton("Hủy hóa hóa đơn");
		btnHuy.setBackground(Color.RED);
		btnHuy.setForeground(Color.WHITE);
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnHuy.setBounds(1132, 714, 174, 42);
		contentPane.add(btnHuy);

		JLabel lblNewLabel_4_3_3_1 = new JLabel("Giới tính:");
		lblNewLabel_4_3_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_3_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_3_3_1.setBounds(1158, 252, 106, 28);
		contentPane.add(lblNewLabel_4_3_3_1);

		rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnNu.setBackground(Color.WHITE);
		rdbtnNu.setSelected(true);
		rdbtnNu.setBounds(1274, 250, 53, 28);
		contentPane.add(rdbtnNu);

		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnNam.setBackground(Color.WHITE);
		rdbtnNam.setBounds(1384, 250, 64, 28);
		contentPane.add(rdbtnNam);
		ButtonGroup gender = new ButtonGroup();
		gender.add(rdbtnNu);
		gender.add(rdbtnNam);

		lblMaNV = new JLabel("NVBH001");
		lblMaNV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaNV.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaNV.setBounds(1348, 21, 145, 28);
		contentPane.add(lblMaNV);

		lblTenNV = new JLabel("Nguyễn Thị Tâm");
		lblTenNV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenNV.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenNV.setBounds(1358, 58, 135, 29);
		contentPane.add(lblTenNV);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		panel.setBounds(1248, 20, 270, 67);
		contentPane.add(panel);

		JPanel panelGT = new JPanel();
		panelGT.setBackground(Color.WHITE);
		panelGT.setBounds(1274, 246, 174, 40);
		contentPane.add(panelGT);

		btnXR = new JButton("Xóa rỗng");
		btnXR.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXR.setBackground(Color.LIGHT_GRAY);
		btnXR.setBounds(488, 336, 111, 29);
		contentPane.add(btnXR);

		JLabel lblNewLabel_5_2_1 = new JLabel("Tiền khách đưa (VND):");
		lblNewLabel_5_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_2_1.setBounds(590, 668, 186, 29);
		contentPane.add(lblNewLabel_5_2_1);

		JLabel lblNewLabel_5_2_1_1 = new JLabel("  Tiền thối lại (VND):");
		lblNewLabel_5_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_2_1_1.setBounds(595, 725, 181, 29);
		contentPane.add(lblNewLabel_5_2_1_1);

		textTienKhachDua = new JTextField();
		textTienKhachDua.setForeground(Color.RED);
		textTienKhachDua.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		textTienKhachDua.setHorizontalAlignment(SwingConstants.CENTER);
		textTienKhachDua.setColumns(10);
		textTienKhachDua.setBounds(782, 661, 270, 39);
		contentPane.add(textTienKhachDua);

		textTienThoi = new JTextField();
		textTienThoi.setForeground(Color.RED);
		textTienThoi.setEditable(false);
		textTienThoi.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		textTienThoi.setHorizontalAlignment(SwingConstants.CENTER);
		textTienThoi.setColumns(10);
		textTienThoi.setBounds(782, 718, 270, 39);
		contentPane.add(textTienThoi);

		comboBoxTSP = new JComboBox<String>();
		comboBoxTSP.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxTSP.setModel(new DefaultComboBoxModel<String>(new String[] { "mã sản phẩm", "tên sản phẩm" }));
		comboBoxTSP.setBounds(160, 173, 127, 29);
		contentPane.add(comboBoxTSP);

		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setForeground(Color.WHITE);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(14, 115, 1516, 284);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		btnKtra = new JButton("Kiểm tra");
		btnKtra.setBounds(1400, 226, 106, 21);
		panel_1.add(btnKtra);
		btnKtra.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnKtra.setBackground(Color.RED);
		btnKtra.setForeground(Color.WHITE);

		btnXoaRong = new JButton("Xóa Rỗng");
		btnXoaRong.setBounds(1260, 226, 106, 21);
		panel_1.add(btnXoaRong);
		btnXoaRong.setForeground(Color.BLACK);
		btnXoaRong.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnXoaRong.setBackground(Color.LIGHT_GRAY);

		textSL = new JTextField();
		textSL.setBounds(106, 221, 56, 28);
		panel_1.add(textSL);
		textSL.setHorizontalAlignment(SwingConstants.CENTER);
		textSL.setFont(new Font("Tahoma", Font.BOLD, 14));
		textSL.setColumns(10);
		btnXoaRong.addActionListener(this);
		btnKtra.addActionListener(this);

		// Lấy mã nhân viên đang dùng phần mềm
		getNV();

		// tạo mã hóa đơn tự động
		createMHD();

		// Đăng ký sự kiện
		btnBack.addActionListener(this);
		btnTim.addActionListener(this);
		btnXR.addActionListener(this);
		btnThem.addActionListener(this);
		tableSP.addMouseListener(this);
		btnXoaSP.addActionListener(this);
		btnLuu.addActionListener(this);
		btnHuy.addActionListener(this);
		textTienKhachDua.addKeyListener(this);
	}

	// Hàm check ca làm
	public void caLam() {
		LocalDate a = LocalDate.now();
		Date b = Date.valueOf(a);
		b.getTime();
		JOptionPane.showMessageDialog(this, b);
	}

	// Lấy mã nhân viên đang dùng phần mềm
	public void getNV() {
		nv_Dao = new NhanVien_DAO();
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String maNV = Gui_DangNhap.getMaTX();
		String tenNV = null;
		String maNV2 = null;
		ArrayList<NhanVien> nvDN = nv_Dao.getMNV(maNV);
		for (NhanVien nhanVien : nvDN) {
			maNV2 = nhanVien.getMaNhanVien();
			tenNV = nhanVien.getTenNhanVien();
		}
		lblMaNV.setText(maNV2);
		lblTenNV.setText(tenNV);
	}

	// Kiểm tra số điện thoại khách hàng
	private boolean ktraSDT() {
		String sDt = textSDT.getText().trim();
		if (!sDt.matches("^[0-9\\-\\+]{9,15}$")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại sai định dạng");
			textSDT.requestFocus();
			return false;
		}
		return true;
	}

	// Hàm tạo mã hóa đơn bán hàng auto
	public void createMHD() {
		String maHD = null;
		ArrayList<HoaDonBanHang> dsHD = hdBH_Dao.dsHD();
		if (dsHD.size() >= 0) {
			int ma = hdBH_Dao.maHD() + 1;
			if (ma < 10) {
				maHD = "HDBH00" + ma;
			} else if (ma >= 10 && ma <= 99) {
				maHD = "HDBH0" + ma;
			} else {
				maHD = "HDBH" + ma;
			}
		}
		textMHD.setText(maHD);
	}

//Hàm lấy giới tính kh
	public String gt() {
		String gT;
		if (rdbtnNu.getSelectedIcon() != null) {
			gT = "Nam";
		} else {
			gT = "Nu";
		}
		return gT;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		// event trở về
		if (obj.equals(btnBack)) {

			String maNV = Gui_DangNhap.getMaTX();
			if (textMKH.getText().equals("") && textTKH.getText().equals("") && textNS.getText().equals("")
					&& textSDT.getText().equals("") && textDC.getText().equals("")
					&& textChietKhau.getText().equals("")) {
				if (maNV.codePointBefore(4) == 72) {
					new Gui_NhanVien().setVisible(true);
					dispose();
				} else {
					new Gui_QuanLy().setVisible(true);
					dispose();
				}

			} else {
				int confirm = JOptionPane.showConfirmDialog(this, "Hóa đơn chưa hoàn thành! Bạn có muốn thoát ?",
						"Thông báo", JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {

					if (maNV.codePointBefore(4) == 72) {
						new Gui_NhanVien().setVisible(true);
						dispose();
					} else {
						new Gui_QuanLy().setVisible(true);
						dispose();
					}
				}
			}

		}
		// event xóa rỗng thông tin khách hànng
		else if (obj.equals(btnXoaRong)) {
			textMKH.setText("");
			textTKH.setText("");
			rdbtnNu.setSelected(true);
			textNS.setText("");
			textDC.setText("");
			textSDT.setText("");
		}
		// event xóa rỗng thông tin tin tkiem sản phẩm
		else if (obj.equals(btnXR)) {
			textData.setText("");
			textSL.setText("");
			comboBoxTSP.setSelectedItem("tên sản phẩm");
		}
		// event kiểm tra khách hàng
		else if (obj.equals(btnKtra)) {
			if (ktraSDT()) {
				kh_Dao = new KhachHang_DAO();
				ArrayList<KhachHang> dskh = kh_Dao.getKHSDT(textSDT.getText());
				if (dskh.size() == 0) {
					int ma = kh_Dao.makh() + 1;
					String makh;
					if (ma < 10) {
						makh = "KH00" + ma;
					} else if (ma >= 10 && ma <= 99) {
						makh = "KH0" + ma;
					} else {
						makh = "KH" + ma;
					}
					textMKH.setText(makh);
				} else {
					for (KhachHang khachHang : dskh) {
						String maKH = khachHang.getMaKhachHang();
						String tenKH = khachHang.getTenKhachHang();
						String ngaySinh = khachHang.getNgaySinh().toString();
						String diaChi = khachHang.getDiaChi();
						String sdt = khachHang.getSoDienThoai();
						textMKH.setText(maKH);
						textTKH.setText(tenKH);
						textDC.setText(diaChi);
						textNS.setText(ngaySinh);
						if (khachHang.getGioiTinh() == "Nu") {
							rdbtnNu.setSelected(true);
						} else {
							rdbtnNam.setSelected(true);
						}
						textSDT.setText(sdt);
					}
				}
			}
		}
		// event tìm sản phẩm
		else if (obj.equals(btnTim)) {
			String data = textData.getText();
			if (data.equals("")) {
				JOptionPane.showMessageDialog(this, "Nhập thông tin sản phẩm cần tìm!!");
			} else {
				ArrayList<SanPham> sp = new ArrayList<SanPham>();
				if (comboBoxTSP.getSelectedItem().equals("mã sản phẩm")) {
					sp = sp_Dao.timMSP(data);
					DefaultTableModel tableSP1 = (DefaultTableModel) tableSP.getModel();
					tableSP1.setRowCount(0);
					for (SanPham sanPham : sp) {
						tableSP1.addRow(new Object[] { sanPham.getMaSanPham(), sanPham.getTenSanPham(),
								sanPham.getMau(), sanPham.getSize(), sanPham.getHang(), sanPham.getSoLuongTon(),
								sanPham.getLoHang(), sanPham.getGiaBan() });
					}
					tableSP1.fireTableDataChanged();
				} else {
					sp = sp_Dao.timTSP(data);
					DefaultTableModel tableSP1 = (DefaultTableModel) tableSP.getModel();
					tableSP1.setRowCount(0);
					for (SanPham sanPham : sp) {
						tableSP1.addRow(new Object[] { sanPham.getMaSanPham(), sanPham.getTenSanPham(),
								sanPham.getMau(), sanPham.getSize(), sanPham.getHang(), sanPham.getSoLuongTon(),
								sanPham.getLoHang(), sanPham.getGiaBan() });
					}
					tableSP1.fireTableDataChanged();
				}
			}

		}
		// event thêm sản phẩm
		else if (obj.equals(btnThem)) {
			int a = updateSL();
			if (a == 1) {
				JOptionPane.showMessageDialog(this, "đã cập nhật số lượng " + textData.getText());
			} else {
				addSP();
			}

		}
		// event xóa sản phẩm ra khỏi danh sách sản phẩm
		else if (obj.equals(btnXoaSP)) {
			xoaSP();
		}
		// Lưu hóa đơn
		else if (obj.equals(btnLuu)) {
			int confirm = JOptionPane.showConfirmDialog(this, "Xác nhận lưu hóa đơn ?", "Thông báo",
					JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				addKH();
				hdBHnew();
				ctHDBH();
				xuatfile();
				JOptionPane.showMessageDialog(this, "Thành công!!, hóa đơn đã đc xuất!!");
				new Gui_HoaDonBanHang().setVisible(true);
				dispose();
			}
		}

		// event hủy hóa đơn
		else if (obj.equals(btnHuy)) {
			int confirm = JOptionPane.showConfirmDialog(this, "Ban co chắc muốn hủy hóa đơn ?", "Thông báo",
					JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				dispose();
				new Gui_NhanVien().setVisible(true);
			}
		}
	}

	// Tạo hóa đơn mới
	public void hdBHnew() {
		NhanVien maNV = new NhanVien(lblMaNV.getText());
		String maHD = textMHD.getText();
		KhachHang maKH = new KhachHang(textMKH.getText());
		String ngayLap = textNL.getText().toString();
		LocalDate ngayL = LocalDate.parse(ngayLap);
		HoaDonBanHang hd = new HoaDonBanHang(ngayL, maHD, maKH, maNV);
		hdBH1.create(hd);
	}

	// tạo chi tiết hóa đơn
	public void ctHDBH() {
		ArrayList<SanPham> sp = new ArrayList<SanPham>();
		HoaDonBanHang maHD = new HoaDonBanHang(textMHD.getText());
		int n = tableDSSP.getRowCount();
		int b = 0;
		for (int i = 0; i < n; i++) {
			SanPham maSP = new SanPham(dtm_1.getValueAt(i, 1).toString());
			String ma = dtm_1.getValueAt(i, 1).toString();
			int soL = Integer.parseInt(dtm_1.getValueAt(i, 6).toString());
			sp = sp_Dao.timMSP(ma);
			for (SanPham sanPham : sp) {
				int a = sanPham.getSoLuongTon();
				b = a - soL;
			}
			SanPham sp1 = new SanPham(ma, b);
			sp_Dao.updateSL(sp1);
			BigDecimal thanhTien = new BigDecimal(dtm_1.getValueAt(i, 9).toString());
			ChiTietHDBH ct = new ChiTietHDBH(maHD, maSP, soL, thanhTien);
			ctHDBH_Dao.create(ct);

		}

	}

	// Tạo khách hàng mới
	public void addKH() {
		String maKh1 = null;
		String maKh = textMKH.getText();
		ArrayList<KhachHang> kh = kh_Dao.getMKH(maKh);
		for (KhachHang khachHang : kh) {
			maKh1 = khachHang.getMaKhachHang();

		}
		if (maKh.equals(maKh1)) {

		} else {
			String ngaySinh = textNS.getText();
			LocalDate ngayS = LocalDate.parse(ngaySinh);
			String tenKH = textTKH.getText();
			String sdt = textSDT.getText();
			String gioiTinh = gt();
			String dc = textDC.getText();
			KhachHang khNew = new KhachHang(maKh, tenKH, sdt, dc, gioiTinh, ngayS);
			kh_Dao.create(khNew);
		}
	}

	// Xoa SP ra khoi tableDSSP
	public void xoaSP() {
		int row = tableDSSP.getSelectedRow();
		int n = tableDSSP.getRowCount();
		double tongTien = 0;
		if (row >= 0) {
			if (n == 1 && dtm_1.getValueAt(row, 0).toString().equals("1")) {
				textChietKhau.setText("");
				textThue.setText("");
				texTongThanhTien.setText("");
			}
			dtm_1.removeRow(row);
			for (int i = 0; i < n + 1; i++) {
				tableDSSP.setValueAt(i + 1, i, 0);
				String tongTien2 = dtm_1.getValueAt(i, 9).toString();
				tongTien = tongTien + Double.parseDouble(tongTien2);
				String thue = "10";
				String chietKhau = "1";
				tongTien = tongTien + (tongTien * 0.1) - (tongTien * 0.01);
				String s = String.valueOf(tongTien);
				textChietKhau.setText(chietKhau);
				textThue.setText(thue);
				texTongThanhTien.setText(s);
			}

		} else {
			JOptionPane.showMessageDialog(this, "Chọn dòng cần xoá!");
		}
	}

	// Thêm sp vào ds
	public void addSP() {
		int row = tableSP.getSelectedRow();
		String soLB = textSL.getText().toString();
		DefaultTableModel tableDSSPB = (DefaultTableModel) tableDSSP.getModel();
		int n = tableDSSPB.getRowCount();
		if (row >= 0) {
			if (soLB.equals("")) {
				JOptionPane.showMessageDialog(this, "Số lượng trống !!");
			} else {
				String maSP1 = dtm.getValueAt(row, 0).toString();
				String tenSP = dtm.getValueAt(row, 1).toString();
				String mau = dtm.getValueAt(row, 2).toString();
				String size = dtm.getValueAt(row, 3).toString();
				String dg = dtm.getValueAt(row, 7).toString();
				String hang = dtm.getValueAt(row, 4).toString();
				String lH = dtm.getValueAt(row, 6).toString();
				double tt = Double.parseDouble(dg) * Double.parseDouble(soLB);
				tableDSSPB.addRow(new Object[] { n + 1, maSP1, tenSP, mau, size, hang, soLB, lH, dg, tt });
				tableDSSPB.fireTableDataChanged();
				double tongTien = 0;
				for (int i = 0; i < n + 1; i++) {
					String tongTien2 = dtm_1.getValueAt(i, 9).toString();
					tongTien = tongTien + Double.parseDouble(tongTien2);
					String thue = "10";
					String chietKhau = "1";
					tongTien = tongTien + (tongTien * 0.1) - (tongTien * 0.01);
					String s = String.valueOf(tongTien);
					textChietKhau.setText(chietKhau);
					textThue.setText(thue);
					texTongThanhTien.setText(s);
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "Chọn sản phẩm cần bán!");
		}

	}

	// Hàm lấy thông tin để sửa sl
	public int updateSL() {
		int check = 0;
		String a = textData.getText();
		String b;
		String c = textSL.getText();
		int n = tableDSSP.getRowCount();
		for (int i = 0; i < n; i++) {
			b = tableDSSP.getValueAt(i, 1).toString();
			String dg = tableDSSP.getValueAt(i, 8).toString();
			if (a.equals(b)) {
				dtm_1.setValueAt(c, i, 6);
				double d = Double.parseDouble(dg) * Double.parseDouble(c);
				dtm_1.setValueAt(d, i, 8);
				double tongTien = 0;
				for (int j = 0; j < n + 1; j++) {
					String tongTien2 = dtm_1.getValueAt(i, 9).toString();
					tongTien = tongTien + Double.parseDouble(tongTien2);
					String thue = "10";
					String chietKhau = "1";
					tongTien = tongTien + (tongTien * 0.1) - (tongTien * 0.01);
					String s = String.valueOf(tongTien);
					textChietKhau.setText(chietKhau);
					textThue.setText(thue);
					texTongThanhTien.setText(s);
				}
				check = 1;
			}
		}
		return check;

	}

	// Tính tiền thối lại cho khách hàng
	public void getTT() {
		String tt = texTongThanhTien.getText();
		double a = Double.valueOf(tt);
		double b = Double.valueOf(textTienKhachDua.getText());
		double c = b - a;
		String x = String.valueOf(c);
		textTienThoi.setText(x);
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

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		Object o = e.getSource();
		if (o.equals(textTienKhachDua)) {
			getTT();
		}

	}

	// Hàm xuất file
	public void xuatfile() {
		try {
			@SuppressWarnings("resource")
			XSSFWorkbook f = new XSSFWorkbook();
			XSSFSheet sheet = f.createSheet("Hóa đơn bán hàng");

			XSSFRow row = null;
			Cell cell = null;

			row = sheet.createRow((short) 2);
			row.setHeight((short) 500);
			cell = row.createCell(10, CellType.STRING);
			cell.setCellValue("Cửa hàng thời trang VTTM");

			row = sheet.createRow((short) 3);
			row.setHeight((short) 500);
			cell = row.createCell(8, CellType.STRING);
			cell.setCellValue("209 Hoang Hoa Thám,P.8,");
			cell = row.createCell(12, CellType.STRING);
			String ngay = textNL.getText();
			cell.setCellValue("Ngày lập:  " + ngay);

			row = sheet.createRow((short) 4);
			row.setHeight((short) 500);
			cell = row.createCell(8, CellType.STRING);
			cell.setCellValue("Q.Tân Bình,TP.HCM");
			cell = row.createCell(12, CellType.STRING);
			String maHD = textMHD.getText();
			cell.setCellValue("MHD: " + maHD);

			row = sheet.createRow((short) 5);
			row.setHeight((short) 300);
			cell = row.createCell(8, CellType.STRING);
			String sdt = textSDT.getText();
			cell.setCellValue("SĐT: " + sdt);
			cell = row.createCell(12, CellType.STRING);
			String maKH = textMKH.getText();
			cell.setCellValue("Mã khách hàng: " + maKH);

			row = sheet.createRow((short) 6);
			row.setHeight((short) 300);
			cell = row.createCell(8, CellType.STRING);
			String maNV = lblMaNV.getText();
			cell.setCellValue("Mã nhân viên: " + maNV);
			cell = row.createCell(12, CellType.STRING);
			cell.setCellValue("Tên khách hàng: " + textMKH.getText());

			row = sheet.createRow((short) 7);
			row.setHeight((short) 300);
			cell = row.createCell(8, CellType.STRING);
			cell.setCellValue("Tên nhân viên: " + lblTenNV.getText());
			cell = row.createCell(12, CellType.STRING);
			cell.setCellValue("Địa Chỉ: " + textDC.getText());

			row = sheet.createRow((short) 9);
			row.setHeight((short) 500);
			cell = row.createCell(10, CellType.STRING);
			cell.setCellValue("Hóa Đơn Bán Hàng");

			row = sheet.createRow((short) 10);
			row.setHeight((short) 500);
			cell = row.createCell(7, CellType.STRING);
			cell.setCellValue("STT");
			cell = row.createCell(8, CellType.STRING);
			cell.setCellValue("Mã sản phẩm");
			cell = row.createCell(9, CellType.STRING);
			cell.setCellValue("Tên sản phẩm");
			cell = row.createCell(10, CellType.STRING);
			cell.setCellValue("Size");
			cell = row.createCell(11, CellType.STRING);
			cell.setCellValue("Mau");
			cell = row.createCell(12, CellType.STRING);
			cell.setCellValue("Hãng");
			cell = row.createCell(13, CellType.STRING);
			cell.setCellValue("Số lượng");
			cell = row.createCell(14, CellType.STRING);
			cell.setCellValue("Đơn giá");
			cell = row.createCell(15, CellType.STRING);
			cell.setCellValue("Thành Tiền");

			int n = tableDSSP.getRowCount();
			for (int i = 0; i < n; i++) {
				row = sheet.createRow((short) 10 + i + 1);
				row.setHeight((short) 500);
				String stt = tableDSSP.getValueAt(i, 0).toString();
				cell = row.createCell(7, CellType.STRING);
				cell.setCellValue(stt);
				String maSP = tableDSSP.getValueAt(i, 1).toString();
				cell = row.createCell(8, CellType.STRING);
				cell.setCellValue(maSP);
				String tenSP = tableDSSP.getValueAt(i, 2).toString();
				cell = row.createCell(9, CellType.STRING);
				cell.setCellValue(tenSP);
				String size = tableDSSP.getValueAt(i, 4).toString();
				cell = row.createCell(10, CellType.STRING);
				cell.setCellValue(size);
				String mau = tableDSSP.getValueAt(i, 3).toString();
				cell = row.createCell(11, CellType.STRING);
				cell.setCellValue(mau);
				String hang = tableDSSP.getValueAt(i, 5).toString();
				cell = row.createCell(12, CellType.STRING);
				cell.setCellValue(hang);
				String sl = tableDSSP.getValueAt(i, 6).toString();
				cell = row.createCell(13, CellType.STRING);
				cell.setCellValue(sl);
				String dg = tableDSSP.getValueAt(i, 8).toString();
				cell = row.createCell(14, CellType.STRING);
				cell.setCellValue(dg);
				String tt = tableDSSP.getValueAt(i, 9).toString();
				cell = row.createCell(15, CellType.STRING);
				cell.setCellValue(tt);
			}

			row = sheet.createRow((short) 11 + n);
			row.setHeight((short) 200);
			cell = row.createCell(6, CellType.STRING);
			cell.setCellValue(
					"-----------------------------------------------------------"
					+ "------------------------------------------------------------------------------------------------------");

			row = sheet.createRow((short) 11 + n + 1);
			row.setHeight((short) 500);
			cell = row.createCell(8, CellType.STRING);
			cell.setCellValue("Thuế: " + textThue.getText() + "%");
			cell = row.createCell(10, CellType.STRING);
			cell.setCellValue("Chiết Khấu: " + textChietKhau.getText() + "%");
			cell = row.createCell(13, CellType.STRING);
			cell.setCellValue("Tiền khách đưa: " + textTienKhachDua.getText() + "VND");

			row = sheet.createRow((short) 11 + n + 2);
			row.setHeight((short) 500);
			cell = row.createCell(8, CellType.STRING);
			cell.setCellValue("Tổng tiền: " + texTongThanhTien.getText() + "VND");
			cell = row.createCell(13, CellType.STRING);
			cell.setCellValue("Tiền thối lại: " + textTienThoi.getText() + "VND");

			row = sheet.createRow((short) 11 + n + 3);
			row.setHeight((short) 500);
			cell = row.createCell(6, CellType.STRING);
			cell.setCellValue(
					"-----------------------------------------------------------------------------------------------------------------------------------------------------------------");

			row = sheet.createRow((short) 11 + n + 4);
			row.setHeight((short) 500);
			cell = row.createCell(11, CellType.STRING);
			cell.setCellValue("Xin Cảm Ơn !!");

			row = sheet.createRow((short) 11 + n + 5);
			row.setHeight((short) 500);
			cell = row.createCell(9, CellType.STRING);
			cell.setCellValue("Lưu ý: Xin giữ lại hóa đơn để được đổi trả hàng khi cần thiết !!");

			String maHD1 = textMHD.getText();
			FileOutputStream out = new FileOutputStream(new File("V:/" + maHD1 + ".xlsx"));
			f.write(out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
