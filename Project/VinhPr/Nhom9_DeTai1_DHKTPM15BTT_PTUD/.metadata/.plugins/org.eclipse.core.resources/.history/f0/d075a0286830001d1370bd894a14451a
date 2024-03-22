package Gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Gui_HoaDonNhapHang extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel dtm;
	private JTable tableSP;
	private JTextField textMaSP;
	private JTextField textTenSP;
	private JTextField textLoHang;
	private JTextField textGiaNhap;
	private JTextField textGiaBan;
	private JTextField textMaHD;
	private JTextField textMaNCC;
	private JTextField textTenNCC;
	private JTextField textEmail;
	private JTextField textNgayLap;
	private JTextField textDC;
	private JTextField textSdt;
	private DefaultTableModel dtmDSSP;
	private JTable tableDSSP;
	private JTextField textThue;
	private JTextField textCK;
	private JTextField textTT;
	private JButton btnKtra;
	private JButton btnXRong1;
	private JButton btnXRong2;
	private NhaCungCap_DAO ncc_Dao = new NhaCungCap_DAO();
	private HoaDonNhapHang_DAO hdNH_DAO = new HoaDonNhapHang_DAO();
	private SanPham_DAO sp_DAO = new SanPham_DAO();
	private ChiTietHDNH_Dao ctHD_Dao = new ChiTietHDNH_Dao();
	private JTextField textSize;
	private JTextField textSluong;
	private JButton btnTm;
	private JComponent btnThmVoDanh;
	private JTextField textMau;
	private JButton btnXoaSP;
	private JButton btnBack;
	private JButton btnHuy;
	private JLabel lblMNV;
	private JLabel lblTNV;
	private NhanVien_DAO nv_Dao;
	private JPanel panel_1;
	private JTextField textHang;
	private JComboBox<String> comboBox;
	private JButton btnXcNhn;


	/**
	 * Create the frame.
	 */
	public Gui_HoaDonNhapHang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setSize(1580, 830);
		setBounds(100, 100, 1579, 882);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// connect database
		hdNH_DAO = new HoaDonNhapHang_DAO();
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		btnBack = new JButton("Trở lại");
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(Color.RED);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.setBounds(10, 0, 95, 33);
		contentPane.add(btnBack);

		JLabel lblNewLabel = new JLabel("Mã nhân viên:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(1236, 6, 111, 27);
		contentPane.add(lblNewLabel);

		lblMNV = new JLabel("NVBH001");
		lblMNV.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMNV.setHorizontalAlignment(SwingConstants.CENTER);
		lblMNV.setBounds(1374, 6, 146, 27);
		contentPane.add(lblMNV);

		JLabel lblTnNhnVin = new JLabel("Tên nhân viên:");
		lblTnNhnVin.setHorizontalAlignment(SwingConstants.CENTER);
		lblTnNhnVin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTnNhnVin.setBounds(1236, 43, 111, 27);
		contentPane.add(lblTnNhnVin);

		lblTNV = new JLabel("Nguyễn Thị Tâm");
		lblTNV.setHorizontalAlignment(SwingConstants.CENTER);
		lblTNV.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTNV.setBounds(1374, 41, 146, 27);
		contentPane.add(lblTNV);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.GRAY, Color.GRAY, null));
		lblMNV.setLabelFor(panel);
		panel.setBounds(1221, 0, 309, 81);
		contentPane.add(panel);

		JLabel lblNewLabel_2 = new JLabel("Hóa Đơn Nhập Hàng");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(602, 15, 309, 52);
		contentPane.add(lblNewLabel_2);

		new JPanel();
		String[] cols = { "Mã sản phẩm", "Tên sản phẩm", "Hãng", "Màu", "Loại", "Size", "Mã nhà cung cấp",
				"Tên nhà cung cấp" };
		dtm = new DefaultTableModel(cols, 7);
		tableSP = new JTable(dtm);
		tableSP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JScrollPane scrollSP = new JScrollPane(tableSP);
		scrollSP.setBounds(31, 131, 792, 133);
		contentPane.add(scrollSP);

		JLabel lblMSnPhm = new JLabel("Mã sản phẩm:");
		lblMSnPhm.setHorizontalAlignment(SwingConstants.CENTER);
		lblMSnPhm.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMSnPhm.setBounds(31, 274, 111, 27);
		contentPane.add(lblMSnPhm);

		textMaSP = new JTextField();
		textMaSP.setEditable(false);
		textMaSP.setHorizontalAlignment(SwingConstants.CENTER);
		textMaSP.setFont(new Font("Tahoma", Font.BOLD, 13));
		textMaSP.setBounds(152, 274, 173, 27);
		contentPane.add(textMaSP);
		textMaSP.setColumns(10);

		JLabel lblTnSnPhm = new JLabel("Tên sản phẩm:");
		lblTnSnPhm.setHorizontalAlignment(SwingConstants.CENTER);
		lblTnSnPhm.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTnSnPhm.setBounds(31, 312, 111, 27);
		contentPane.add(lblTnSnPhm);

		textTenSP = new JTextField();
		textTenSP.setHorizontalAlignment(SwingConstants.CENTER);
		textTenSP.setFont(new Font("Tahoma", Font.BOLD, 13));
		textTenSP.setColumns(10);
		textTenSP.setBounds(152, 310, 173, 27);
		contentPane.add(textTenSP);

		JLabel lblLHngS = new JLabel("Lô hàng số:");
		lblLHngS.setHorizontalAlignment(SwingConstants.CENTER);
		lblLHngS.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLHngS.setBounds(31, 349, 111, 27);
		contentPane.add(lblLHngS);

		textLoHang = new JTextField();
		textLoHang.setFont(new Font("Tahoma", Font.BOLD, 13));
		textLoHang.setHorizontalAlignment(SwingConstants.CENTER);
		textLoHang.setColumns(10);
		textLoHang.setBounds(152, 349, 173, 27);
		contentPane.add(textLoHang);

		JLabel lblSize = new JLabel("Size:");
		lblSize.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSize.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSize.setBounds(664, 312, 79, 27);
		contentPane.add(lblSize);

		btnTm = new JButton("Tìm");
		btnTm.setForeground(Color.WHITE);
		btnTm.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTm.setBackground(Color.RED);
		btnTm.setBounds(335, 313, 71, 25);
		contentPane.add(btnTm);

		textGiaNhap = new JTextField();
		textGiaNhap.setFont(new Font("Tahoma", Font.BOLD, 13));
		textGiaNhap.setHorizontalAlignment(SwingConstants.CENTER);
		textGiaNhap.setColumns(10);
		textGiaNhap.setBounds(503, 274, 159, 27);
		contentPane.add(textGiaNhap);

		textGiaBan = new JTextField();
		textGiaBan.setHorizontalAlignment(SwingConstants.CENTER);
		textGiaBan.setFont(new Font("Tahoma", Font.BOLD, 13));
		textGiaBan.setColumns(10);
		textGiaBan.setBounds(503, 312, 159, 27);
		contentPane.add(textGiaBan);

		btnXRong2 = new JButton("Xóa rỗng");
		btnXRong2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXRong2.setBackground(Color.LIGHT_GRAY);
		btnXRong2.setForeground(Color.BLACK);
		btnXRong2.setBounds(335, 350, 105, 25);
		contentPane.add(btnXRong2);

		JLabel lblMHan = new JLabel("Mã hóa đơn:");
		lblMHan.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMHan.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMHan.setBounds(868, 130, 111, 27);
		contentPane.add(lblMHan);
		textMaHD = new JTextField();
		textMaHD.setEditable(false);
		textMaHD.setHorizontalAlignment(SwingConstants.CENTER);
		;
		textMaHD.setFont(new Font("Tahoma", Font.BOLD, 13));
		textMaHD.setColumns(10);
		textMaHD.setBounds(989, 131, 159, 27);
		contentPane.add(textMaHD);

		JLabel lblMNhCung = new JLabel("Mã nhà cung cấp:");
		lblMNhCung.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMNhCung.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMNhCung.setBounds(833, 167, 146, 27);
		contentPane.add(lblMNhCung);

		JLabel lblNgyLp = new JLabel("Ngày lập:");
		lblNgyLp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNgyLp.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNgyLp.setBounds(1158, 130, 95, 27);
		contentPane.add(lblNgyLp);

		JLabel lblaCh = new JLabel("Địa chỉ:");
		lblaCh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblaCh.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblaCh.setBounds(1142, 167, 111, 27);
		contentPane.add(lblaCh);

		JLabel lblTnnhCungCp = new JLabel("Tên nhà cung cấp:");
		lblTnnhCungCp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTnnhCungCp.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTnnhCungCp.setBounds(833, 204, 146, 27);
		contentPane.add(lblTnnhCungCp);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setBounds(878, 241, 101, 27);
		contentPane.add(lblEmail);

		textMaNCC = new JTextField();
		textMaNCC.setEditable(false);
		textMaNCC.setHorizontalAlignment(SwingConstants.CENTER);
		textMaNCC.setFont(new Font("Tahoma", Font.BOLD, 12));
		textMaNCC.setColumns(10);
		textMaNCC.setBounds(989, 168, 159, 27);
		contentPane.add(textMaNCC);

		textTenNCC = new JTextField();
		textTenNCC.setHorizontalAlignment(SwingConstants.CENTER);
		textTenNCC.setFont(new Font("Tahoma", Font.BOLD, 13));
		textTenNCC.setColumns(10);
		textTenNCC.setBounds(989, 205, 159, 27);
		contentPane.add(textTenNCC);

		textEmail = new JTextField();
		textEmail.setHorizontalAlignment(SwingConstants.CENTER);
		textEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		textEmail.setColumns(10);
		textEmail.setBounds(989, 242, 159, 27);
		contentPane.add(textEmail);

		JLabel lblSinThoi = new JLabel("Số điện thoại:");
		lblSinThoi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSinThoi.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSinThoi.setBounds(1142, 204, 111, 27);
		contentPane.add(lblSinThoi);

		textNgayLap = new JTextField();
		textNgayLap.setForeground(Color.BLACK);
		textNgayLap.setHorizontalAlignment(SwingConstants.CENTER);
		textNgayLap.setFont(new Font("Tahoma", Font.BOLD, 13));
		textNgayLap.setColumns(10);
		textNgayLap.setBounds(1263, 130, 159, 31);
		String today = LocalDate.now().toString();
		textNgayLap.setText(today);
		contentPane.add(textNgayLap);

		textDC = new JTextField();
		textDC.setHorizontalAlignment(SwingConstants.CENTER);
		textDC.setFont(new Font("Tahoma", Font.BOLD, 12));
		textDC.setColumns(10);
		textDC.setBounds(1263, 167, 248, 32);
		contentPane.add(textDC);

		textSdt = new JTextField();
		textSdt.setHorizontalAlignment(SwingConstants.CENTER);
		textSdt.setFont(new Font("Tahoma", Font.BOLD, 13));
		textSdt.setColumns(10);
		textSdt.setBounds(1263, 204, 159, 32);
		contentPane.add(textSdt);

		btnXRong1 = new JButton("Xóa rỗng");
		btnXRong1.setForeground(Color.BLACK);
		btnXRong1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXRong1.setBackground(Color.LIGHT_GRAY);
		btnXRong1.setBounds(1263, 243, 105, 23);
		contentPane.add(btnXRong1);

		btnKtra = new JButton("Kiểm tra");
		btnKtra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnKtra.setForeground(Color.WHITE);
		btnKtra.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnKtra.setBackground(Color.RED);
		btnKtra.setBounds(1378, 243, 95, 23);
		contentPane.add(btnKtra);

		String[] cols_1 = { "STT", "Mã sản phẩm", "Tên sản phẩm", "Hãng", "Màu", "Loại", "Size", "Số lượng", "Lô hàng",
				"Giá bán", "Giá nhập", "Thành tiền" };
		dtmDSSP = new DefaultTableModel(cols_1, 0);
		tableDSSP = new JTable(dtmDSSP);
		JScrollPane scrollDSSP = new JScrollPane(tableDSSP);
		scrollDSSP.setBounds(10, 459, 1520, 217);
		contentPane.add(scrollDSSP);

		JLabel lblNewLabel_2_1 = new JLabel("Danh Sách Sản Phẩm");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_2_1.setBounds(561, 397, 309, 52);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblChitKhu = new JLabel("Chiết khấu:");
		lblChitKhu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblChitKhu.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblChitKhu.setBounds(376, 686, 111, 27);
		contentPane.add(lblChitKhu);

		JLabel lblThu = new JLabel("Thuế:");
		lblThu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblThu.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblThu.setBounds(614, 686, 71, 27);
		contentPane.add(lblThu);

		JLabel lblTngThnhTin = new JLabel("Tổng thành tiền (VND):");
		lblTngThnhTin.setHorizontalAlignment(SwingConstants.CENTER);
		lblTngThnhTin.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTngThnhTin.setBounds(40, 719, 269, 50);
		contentPane.add(lblTngThnhTin);

		textThue = new JTextField();
		textThue.setHorizontalAlignment(SwingConstants.CENTER);
		textThue.setFont(new Font("Tahoma", Font.BOLD, 13));
		textThue.setColumns(10);
		textThue.setBounds(695, 687, 89, 27);
		contentPane.add(textThue);

		textCK = new JTextField();
		textCK.setHorizontalAlignment(SwingConstants.CENTER);
		textCK.setFont(new Font("Tahoma", Font.BOLD, 13));
		textCK.setColumns(10);
		textCK.setBounds(503, 687, 89, 27);
		contentPane.add(textCK);

		textTT = new JTextField();
		textTT.setText("0 VND");
		textTT.setForeground(Color.RED);
		textTT.setHorizontalAlignment(SwingConstants.CENTER);
		textTT.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		textTT.setColumns(10);
		textTT.setBounds(356, 724, 487, 50);
		contentPane.add(textTT);

		btnXcNhn = new JButton("Xác nhận ");
		btnXcNhn.setForeground(Color.BLACK);
		btnXcNhn.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXcNhn.setBackground(Color.GREEN);
		btnXcNhn.setBounds(987, 715, 173, 33);
		contentPane.add(btnXcNhn);

		btnHuy = new JButton("Hủy hóa đơn");
		btnHuy.setForeground(Color.BLACK);
		btnHuy.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHuy.setBackground(Color.LIGHT_GRAY);
		btnHuy.setBounds(1203, 715, 173, 33);
		contentPane.add(btnHuy);

		textSize = new JTextField();
		textSize.setHorizontalAlignment(SwingConstants.CENTER);
		textSize.setFont(new Font("Tahoma", Font.BOLD, 13));
		textSize.setColumns(10);
		textSize.setBounds(753, 312, 71, 27);
		contentPane.add(textSize);

		JLabel lblMu = new JLabel("Màu:");
		lblMu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMu.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMu.setBounds(672, 349, 71, 27);
		contentPane.add(lblMu);

		textMau = new JTextField();
		textMau.setHorizontalAlignment(SwingConstants.CENTER);
		textMau.setFont(new Font("Tahoma", Font.BOLD, 13));
		textMau.setColumns(10);
		textMau.setBounds(753, 349, 71, 27);
		contentPane.add(textMau);

		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 96, 1520, 291);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		btnXoaSP = new JButton("Xóa khỏi danh sách");
		btnXoaSP.setBounds(1249, 248, 173, 33);
		panel_1.add(btnXoaSP);
		btnXoaSP.setForeground(Color.BLACK);
		btnXoaSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXoaSP.setBackground(Color.LIGHT_GRAY);

		btnThmVoDanh = new JButton("Thêm vào danh sách");
		btnThmVoDanh.setBounds(1021, 248, 173, 33);
		panel_1.add(btnThmVoDanh);
		btnThmVoDanh.setForeground(Color.BLACK);
		btnThmVoDanh.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThmVoDanh.setBackground(Color.LIGHT_GRAY);

		JLabel lblSLng = new JLabel("Số lượng:");
		lblSLng.setBounds(643, 177, 89, 27);
		panel_1.add(lblSLng);
		lblSLng.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSLng.setFont(new Font("Tahoma", Font.BOLD, 13));

		textSluong = new JTextField();
		textSluong.setBounds(742, 177, 71, 27);
		panel_1.add(textSluong);
		textSluong.setHorizontalAlignment(SwingConstants.CENTER);
		textSluong.setFont(new Font("Tahoma", Font.BOLD, 13));
		textSluong.setColumns(10);

		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "Áo", "Quần", "Phụ kiện" }));
		comboBox.setBounds(904, 252, 89, 27);
		panel_1.add(comboBox);

		JLabel lblLoi = new JLabel("Loại:");
		lblLoi.setBounds(816, 251, 71, 27);
		panel_1.add(lblLoi);
		lblLoi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLoi.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel lblHng = new JLabel("Hãng:");
		lblHng.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHng.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHng.setBounds(412, 248, 71, 27);
		panel_1.add(lblHng);

		textHang = new JTextField();
		textHang.setHorizontalAlignment(SwingConstants.CENTER);
		textHang.setFont(new Font("Tahoma", Font.BOLD, 13));
		textHang.setColumns(10);
		textHang.setBounds(493, 251, 159, 27);
		panel_1.add(textHang);

		JLabel lblGiBn = new JLabel("Giá bán:");
		lblGiBn.setBounds(372, 216, 111, 27);
		panel_1.add(lblGiBn);
		lblGiBn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGiBn.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel lblnGi = new JLabel("Giá nhập:");
		lblnGi.setBounds(372, 177, 111, 27);
		panel_1.add(lblnGi);
		lblnGi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblnGi.setFont(new Font("Tahoma", Font.BOLD, 13));
		((AbstractButton) btnThmVoDanh).addActionListener(this);
		btnXoaSP.addActionListener(this);

		// Lấy mã nhân viên đang dùng phần mềm
		getNV();

		// tạo mã hóa đơn tự động
		ArrayList<HoaDonNhapHang> dsHD = new ArrayList<HoaDonNhapHang>();
		dsHD = hdNH_DAO.dsHD();
		if (dsHD.size() >= 0) {
			int ma = hdNH_DAO.maHD() + 1;
			String maHD;
			if (ma < 10) {
				maHD = "HDNH00" + ma;
			} else if (ma >= 10 && ma <= 99) {
				maHD = "HDNH0" + ma;
			} else {
				maHD = "HDNH" + ma;
			}
			for (HoaDonNhapHang hoaDonNhapHang : dsHD) {
				String maC = hoaDonNhapHang.getMaHD();
				if (maC.equals(maHD)) {
					int ma1 = hdNH_DAO.maHD() + 2;
					if (ma1 < 10) {
						maHD = "HDNH00" + ma1;
					} else if (ma1 >= 10 && ma1 <= 99) {
						maHD = "HDNH0" + ma1;
					} else {
						maHD = "HDNH" + ma1;
					}
				}
			}

			textMaHD.setText(maHD);
		}
		// Đăng ký sự kiện
		btnKtra.addActionListener(this);
		btnXRong1.addActionListener(this);
		btnXRong2.addActionListener(this);
		btnTm.addActionListener(this);
		tableSP.addMouseListener(this);
		tableDSSP.addMouseListener(this);
		btnBack.addActionListener(this);
		btnHuy.addActionListener(this);
		btnXcNhn.addActionListener(this);
	}

	// Hàm lấy mã nhân viên đang dùng phần mềm
	public void getNV() {
		nv_Dao = new NhanVien_DAO();
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String maNV = Gui_DangNhap.getMaTX();
		String tenNV = null;
		ArrayList<NhanVien> nvDN = nv_Dao.getMNV(maNV);
		for (NhanVien nhanVien : nvDN) {
			tenNV = nhanVien.getTenNhanVien();
		}
		lblMNV.setText(maNV);
		lblTNV.setText(tenNV);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		// event xóa rỗng tt nhà cung cấp
		if (obj.equals(btnXRong1)) {
			textTenNCC.setText("");
			textMaNCC.setText("");
			textEmail.setText("");
			textDC.setText("");
			textSdt.setText("");
		}
		// event xóa rỗng tt sản phẩm
		else if (obj.equals(btnXRong2)) {
			textMaSP.setText("");
			textTenSP.setText("");
			textGiaNhap.setText("");
			textLoHang.setText("");
			textGiaBan.setText("");
			comboBox.setSelectedItem("Áo");
			textSluong.setText("");
			textSize.setText("");
			textMau.setText("");
			textHang.setText("");
		}
		// kiểm tra nhà cung cấp
		else if (obj.equals(btnKtra)) {
			// textSdt.getText();
			ArrayList<NhaCungCap> tncc = ncc_Dao.timSDT(textSdt.getText());
			if (tncc.size() >= 0) {
				int ma = ncc_Dao.mancc() + 1;
				String maNCC1;
				if (ma < 10) {
					maNCC1 = "NCC00" + ma;
				} else if (ma >= 10 && ma <= 99) {
					maNCC1 = "NCC0" + ma;
				} else {
					maNCC1 = "NCC" + ma;
				}
				ArrayList<NhaCungCap> a = new ArrayList<NhaCungCap>();
				a = ncc_Dao.timMNCC(maNCC1);
				for (NhaCungCap nhaCungCap : a) {
					String maNCC2 = nhaCungCap.getMaNhaCungCap();
					if (maNCC2.equals(maNCC1)) {
						ma = ma + 1;
						String maNCC3;
						if (ma < 10) {
							maNCC3 = "NCC00" + ma;
						} else if (ma >= 10 && ma <= 99) {
							maNCC3 = "NCC0" + ma;
						} else {
							maNCC3 = "NCC" + ma;
						}
						textMaNCC.setText(maNCC3);
					} else {
						textMaNCC.setText(maNCC1);
					}
				}

			} else {
				for (NhaCungCap nhaCungCap : tncc) {
					String maNCC = nhaCungCap.getMaNhaCungCap();
					String tenNCC = nhaCungCap.getTenNhaCungCap();
					String email = nhaCungCap.getEmail();
					String dc = nhaCungCap.getDiaChi();
					String sdt1 = nhaCungCap.getSoDienThoai();
					textTenNCC.setText(tenNCC);
					textMaNCC.setText(maNCC);
					textEmail.setText(email);
					textDC.setText(dc);
					textSdt.setText(sdt1);
				}
			}
		}
		// event tìm sản phẩm
		else if (obj.equals(btnTm)) {
			String tenSP = textTenSP.getText();
			ArrayList<SanPham> sp = new ArrayList<SanPham>();
			String a = sp_DAO.maSP();
			String b = a.replaceAll("[^0-9]", "");
			int c = Integer.parseInt(b);
			int n = tableDSSP.getRowCount();
			sp = sp_DAO.dsSP();
			if (sp.size() >= 0) {
				String maSP = null;
				int ma = c + 1 + n;
				if (ma < 10) {
					maSP = "SP00" + ma;
				} else if (ma >= 10 && ma <= 99) {
					maSP = "SP0" + ma;
				} else {
					maSP = "SP" + ma;
				}
				textMaSP.setText(maSP);
//					sp = sp_DAO.timMSP(maSP);
//					for (SanPham sanPham : sp) {
//						String maC = sanPham.getMaSanPham();
//						for (int i = 0; i < n; i++) {
//							String c1 = tableDSSP.getValueAt(i, 1).toString();
//							if (maC.equals(maSP) || c1.equals(maSP)) {
//								String maSP2 = null;
//								int ma1 = c + 2 + n;
//								if (ma1 < 10) {
//									maSP2 = "SP00" + (ma1);
//								} else if (ma1 >= 10 && ma1 <= 99) {
//									maSP2 = "SP0" + (ma1);
//								} else {
//									maSP2 = "SP" + (ma1);
//								}
//								textMaSP.setText(maSP2);
//							} else {
//								textMaSP.setText(maSP);
//							}
//						}
//					}

				if (tenSP.length() > 0) {
					sp = sp_DAO.timTSP(tenSP);
					DefaultTableModel tableSP1 = (DefaultTableModel) tableSP.getModel();
					tableSP1.setRowCount(0);
					for (SanPham sanPham : sp) {

						tableSP1.addRow(new Object[] { sanPham.getMaSanPham(), sanPham.getTenSanPham(),
								sanPham.getHang(), sanPham.getMau(), sanPham.getLoai(), sanPham.getSize() });
					}
					tableSP1.fireTableDataChanged();
				}
			}
		}

		// event thêm sản phẩm vào table danh sách sp
		else if (obj.equals(btnThmVoDanh)) {
			int check = 0;
			int n = tableDSSP.getRowCount();
			String ma2 = textMaSP.getText();
			for (int i = 0; i < n; i++) {
				String ma1 = tableDSSP.getValueAt(i, 1).toString();
				if (ma2.equals(ma1)) {
					String maSP1 = textMaSP.getText();
					String tenSP1 = textTenSP.getText();
					String hang = textHang.getText();
					String mau = textMau.getText();
					String loai = comboBox.getSelectedItem().toString();
					String size = textSize.getText();
					String soL = textSluong.getText();
					String loH = textLoHang.getText();
					String dgb = textGiaBan.getText();
					String dgn = textGiaNhap.getText();
					double tt = Double.parseDouble(dgn) * Double.parseDouble(soL);
					dtmDSSP.setValueAt(maSP1, i, 1);
					dtmDSSP.setValueAt(tenSP1, i, 2);
					dtmDSSP.setValueAt(hang, i, 3);
					dtmDSSP.setValueAt(mau, i, 4);
					dtmDSSP.setValueAt(loai, i, 5);
					dtmDSSP.setValueAt(size, i, 6);
					dtmDSSP.setValueAt(soL, i, 7);
					dtmDSSP.setValueAt(loH, i, 8);
					dtmDSSP.setValueAt(dgb, i, 9);
					dtmDSSP.setValueAt(dgn, i, 10);
					dtmDSSP.setValueAt(tt, i, 11);
					double tongTien = 0;
					for (int j = 0; j < n + 1; j++) {
						String tongTien2 = dtmDSSP.getValueAt(i, 10).toString();
						tongTien = tongTien + Double.parseDouble(tongTien2);
						String thue = "10";
						String chietKhau = "1";
						tongTien = tongTien + (tongTien * 0.1) - (tongTien * 0.01);
						String s = String.valueOf(tongTien);
						textCK.setText(chietKhau);
						textThue.setText(thue);
						textTT.setText(s + "VND");
					}
					check = 1;
				}
			}
			if (check == 1) {
				JOptionPane.showMessageDialog(this, "đã cập nhật thông tin sản phẩm trong danh sách !!");
			} else {
				addSPTable();
			}

		}

		// event xóa sản phẩm trong table dssp
		else if (obj.equals(btnXoaSP)) {
			int row = tableDSSP.getSelectedRow();
			int n = tableDSSP.getRowCount();
			double tongTien = 0;
			if (row >= 0) {
				if (n == 1 && dtmDSSP.getValueAt(row, 0).toString().equals("1")) {
					textCK.setText("");
					textThue.setText("");
					textTT.setText("");
				}
				dtmDSSP.removeRow(row);
				for (int i = 0; i < n + 1; i++) {
					tableDSSP.setValueAt(i + 1, i, 0);
					String tongTien2 = dtmDSSP.getValueAt(i, 10).toString();
					tongTien = tongTien + Double.parseDouble(tongTien2);
					String thue = "10";
					String chietKhau = "1";
					tongTien = tongTien + (tongTien * 0.1) - (tongTien * 0.01);
					String s = String.valueOf(tongTien);
					textCK.setText(chietKhau);
					textThue.setText(thue);
					textTT.setText(s + "VND");
				}

			} else {
				JOptionPane.showMessageDialog(this, "Chọn dòng cần xoá!");
			}
		}
		// event trở về
		else if (obj.equals(btnBack)) {
			String maNV = Gui_DangNhap.getMaTX();
			if (textMaNCC.getText().equals("") && textTenNCC.getText().equals("") && textEmail.getText().equals("")
					&& textDC.getText().equals("") && textSdt.getText().equals("") && textCK.getText().equals("")) {
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
		// event huy
		else if (obj.equals(btnHuy)) {
			int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn hủy hóa đơn ?", "Thông báo",
					JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				dispose();
				new Gui_NhanVien().setVisible(true);
			}
		}
		// event xac nhan
		else if (obj.equals(btnXcNhn)) {
			int confirm = JOptionPane.showConfirmDialog(this, "Xác nhận lưu hóa đơn ?", "Thông báo",
					JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				addNCC();
				addSP();
				addHD();
				addCTHD();
				xuatfile();
				JOptionPane.showMessageDialog(this, "Thanh cong !");
				new Gui_HoaDonNhapHang().setVisible(true);
			}

		}

	}

	// Thêm nhà cung cấp
	public void addNCC() {
		String maNCC1 = null;
		String maNCC = textMaNCC.getText();
		ArrayList<NhaCungCap> ncc = ncc_Dao.timMNCC(maNCC);
		for (NhaCungCap nhaCungCap : ncc) {
			maNCC1 = nhaCungCap.getMaNhaCungCap();
		}
		if (maNCC.equals(maNCC1)) {

		} else {
			String ten = textTenNCC.getText();
			String email = textEmail.getText();
			String dc = textDC.getText();
			String sdt = textSdt.getText();
			NhaCungCap ncc1 = new NhaCungCap(maNCC, ten, dc, sdt, email);
			ncc_Dao.create(ncc1);
		}
	}

	// Tạo chi tiết hóa đơn
	public void addCTHD() {
		HoaDonNhapHang maHD = new HoaDonNhapHang(textMaHD.getText());
		int n = tableDSSP.getRowCount();
		for (int i = 0; i < n; i++) {
			SanPham maSP = new SanPham(dtmDSSP.getValueAt(i, 1).toString());
			int soL = Integer.parseInt(dtmDSSP.getValueAt(i, 7).toString());
			String lH = dtmDSSP.getValueAt(i, 8).toString();
			BigDecimal thanhTien = new BigDecimal(dtmDSSP.getValueAt(i, 11).toString());
			ChiTietHDNH hd = new ChiTietHDNH(maHD, maSP, lH, soL, thanhTien);
			ctHD_Dao.create(hd);
		}
	}

	// tạo hóa đơn mới
	public void addHD() {
		String maHD = textMaHD.getText();
		LocalDate ngay = LocalDate.parse(textNgayLap.getText());
		NhaCungCap maNCC = new NhaCungCap(textMaNCC.getText());
		NhanVien maNV = new NhanVien(lblMNV.getText());
		HoaDonNhapHang hd = new HoaDonNhapHang(maHD, ngay, maNV, maNCC);
		hdNH_DAO.create(hd);
	}

	// thêm sản phẩm mới
	public void addSP() {
		NhaCungCap maNCC = new NhaCungCap(textMaNCC.getText());
		NhaCungCap tenNCC = new NhaCungCap(textTenNCC.getText());
		LocalDate ngay = LocalDate.parse(textNgayLap.getText());
		int n = tableDSSP.getRowCount();
		for (int i = 0; i < n; i++) {
			String maSP = dtmDSSP.getValueAt(i, 1).toString();
			String tenSP = dtmDSSP.getValueAt(i, 2).toString();
			String hang = dtmDSSP.getValueAt(i, 3).toString();
			String mau = dtmDSSP.getValueAt(i, 4).toString();
			String loai = dtmDSSP.getValueAt(i, 5).toString();
			String size = dtmDSSP.getValueAt(i, 6).toString();
			int soL = Integer.parseInt(dtmDSSP.getValueAt(i, 7).toString());
			String lH = dtmDSSP.getValueAt(i, 8).toString();
			BigDecimal gB = new BigDecimal(dtmDSSP.getValueAt(i, 9).toString());
			BigDecimal gN = new BigDecimal(dtmDSSP.getValueAt(i, 10).toString());
			SanPham sp = new SanPham(maSP, tenSP, mau, loai, soL, size, hang, lH, ngay, gN, gB, maNCC, tenNCC);
			sp_DAO.create(sp);

		}
	}

	// add sp vào table dssp
	public void addSPTable() {
		String maSP1 = textMaSP.getText();
		String tenSP1 = textTenSP.getText();
		String hang = textHang.getText();
		String mau = textMau.getText();
		String loai = comboBox.getSelectedItem().toString();
		String size = textSize.getText();
		String soL = textSluong.getText();
		String loH = textLoHang.getText();
		String dgb = textGiaBan.getText();
		String dgn = textGiaNhap.getText();
		DefaultTableModel tableDSSPB = (DefaultTableModel) tableDSSP.getModel();
		int n = tableDSSPB.getRowCount();
		if (n >= 0) {
			double tt = Double.parseDouble(dgn) * Double.parseDouble(soL);
			tableDSSPB.addRow(new Object[] { n + 1, maSP1, tenSP1, hang, mau, loai, size, soL, loH, dgb, dgn, tt });
			tableDSSPB.fireTableDataChanged();
			double tongTien = 0;
			for (int i = 0; i < n + 1; i++) {
				String tongTien2 = dtmDSSP.getValueAt(i, 10).toString();
				tongTien = tongTien + Double.parseDouble(tongTien2);
				String thue = "10";
				String chietKhau = "1";
				tongTien = tongTien + (tongTien * 0.1) - (tongTien * 0.01);
				String s = String.valueOf(tongTien);
				textCK.setText(chietKhau);
				textThue.setText(thue);
				textTT.setText(s + "VND");
			}
		}

	}

	// Hàm click table SP
	public void clickSP() {
		ArrayList<SanPham> timSP = new ArrayList<SanPham>();
		int row = tableSP.getSelectedRow();
		String maSP = tableSP.getValueAt(row, 0).toString();
		timSP = sp_DAO.timMSP(maSP);
		textTenSP.setText(tableSP.getValueAt(row, 1).toString());
		textHang.setText(tableSP.getValueAt(row, 2).toString());
		textSize.setText(tableSP.getValueAt(row, 5).toString());
		textMau.setText(tableSP.getValueAt(row, 3).toString());
		String a = tableSP.getValueAt(row, 4).toString();
		if (a.equals("Áo")) {
			comboBox.setSelectedItem("Áo");
		} else if (a.equals("Quần")) {
			comboBox.setSelectedItem("Quần");
		} else {
			comboBox.setSelectedItem("Phụ kiện");
		}
		for (SanPham sanPham : timSP) {
			String dgb = String.valueOf(sanPham.getGiaBan());
			String dgn = String.valueOf(sanPham.getGiaNhap());
			textGiaBan.setText(dgb);
			textGiaNhap.setText(dgn);
		}
	}

	// Hàm click table ds SP
	public void clickDSSP() {
		int row = tableDSSP.getSelectedRow();
		textMaSP.setText(tableDSSP.getValueAt(row, 1).toString());
		textTenSP.setText(tableDSSP.getValueAt(row, 2).toString());
		textHang.setText(tableDSSP.getValueAt(row, 3).toString());
		textSize.setText(tableDSSP.getValueAt(row, 6).toString());
		textMau.setText(tableDSSP.getValueAt(row, 4).toString());
		String a = tableDSSP.getValueAt(row, 5).toString();
		if (a.equals("Áo")) {
			comboBox.setSelectedItem("Áo");
		} else if (a.equals("Quần")) {
			comboBox.setSelectedItem("Quần");
		} else {
			comboBox.setSelectedItem("Phụ kiện");
		}
		textSluong.setText(tableDSSP.getValueAt(row, 7).toString());
		textLoHang.setText(tableDSSP.getValueAt(row, 8).toString());
		textGiaBan.setText(tableDSSP.getValueAt(row, 9).toString());
		textGiaNhap.setText(tableDSSP.getValueAt(row, 10).toString());
	}

	// xuất file
	public void xuatfile() {
		try {
			LocalDate a = LocalDate.now();
			@SuppressWarnings("resource")
			XSSFWorkbook f = new XSSFWorkbook();
			XSSFSheet sheet = f.createSheet("Hóa đơn nhập hàng");

			XSSFRow row = null;
			Cell cell = null;

			row = sheet.createRow((short) 2);
			row.setHeight((short) 500);
			cell = row.createCell(9, CellType.STRING);
			cell.setCellValue("Hóa đơn nhập hàng ");

			row = sheet.createRow((short) 3);
			row.setHeight((short) 500);
			cell = row.createCell(7, CellType.STRING);
			cell.setCellValue("Mã hóa đơn: " + textMaHD.getText());
			cell = row.createCell(10, CellType.STRING);
			cell.setCellValue("Ngày lập: " + a);

			row = sheet.createRow((short) 4);
			row.setHeight((short) 500);
			cell = row.createCell(7, CellType.STRING);
			cell.setCellValue("Mã nhà cung cấp: " + textMaNCC.getText());
			cell = row.createCell(10, CellType.STRING);
			cell.setCellValue("Địa Chỉ: " + textDC.getText());

			row = sheet.createRow((short) 5);
			row.setHeight((short) 500);
			cell = row.createCell(7, CellType.STRING);
			cell.setCellValue("Tên nhà cung cấp: " + textTenNCC.getText());
			cell = row.createCell(10, CellType.STRING);
			cell.setCellValue("Số điện thoại: " + textSdt.getText());

			row = sheet.createRow((short) 7);
			row.setHeight((short) 500);
			cell = row.createCell(9, CellType.STRING);
			cell.setCellValue("Danh sách sản phẩm nhập ");

			row = sheet.createRow((short) 9);
			row.setHeight((short) 500);
			cell = row.createCell(6, CellType.STRING);
			cell.setCellValue("STT");
			cell = row.createCell(7, CellType.STRING);
			cell.setCellValue("Mã sản phẩm");
			cell = row.createCell(9, CellType.STRING);
			cell.setCellValue("Tên sản phẩm");
			cell = row.createCell(11, CellType.STRING);
			cell.setCellValue("Hãng");
			cell = row.createCell(12, CellType.STRING);
			cell.setCellValue("Mau");
			cell = row.createCell(13, CellType.STRING);
			cell.setCellValue("Loại");
			cell = row.createCell(14, CellType.STRING);
			cell.setCellValue("Size");
			cell = row.createCell(15, CellType.STRING);
			cell.setCellValue("Số Lượng");
			cell = row.createCell(16, CellType.STRING);
			cell.setCellValue("Lô Hàng");
			cell = row.createCell(17, CellType.STRING);
			cell.setCellValue("Giá bán");
			cell = row.createCell(19, CellType.STRING);
			cell.setCellValue("Giá nhập");
			cell = row.createCell(21, CellType.STRING);
			cell.setCellValue("Thành tiền");

			int n = tableDSSP.getRowCount();
			for (int i = 0; i < n; i++) {
				row = sheet.createRow((short) 10 + i + 1);
				row.setHeight((short) 500);
				cell = row.createCell(6, CellType.STRING);
				String stt = tableDSSP.getValueAt(i, 0).toString();
				cell.setCellValue(stt);
				cell = row.createCell(7, CellType.STRING);
				String ma = tableDSSP.getValueAt(i, 1).toString();
				cell.setCellValue(ma);
				cell = row.createCell(9, CellType.STRING);
				String ten = tableDSSP.getValueAt(i, 2).toString();
				cell.setCellValue(ten);
				cell = row.createCell(11, CellType.STRING);
				String hang = tableDSSP.getValueAt(i, 3).toString();
				cell.setCellValue(hang);
				cell = row.createCell(12, CellType.STRING);
				String mau = tableDSSP.getValueAt(i, 4).toString();
				cell.setCellValue(mau);
				cell = row.createCell(13, CellType.STRING);
				String loai = tableDSSP.getValueAt(i, 5).toString();
				cell.setCellValue(loai);
				cell = row.createCell(14, CellType.STRING);
				String size = tableDSSP.getValueAt(i, 6).toString();
				cell.setCellValue(size);
				cell = row.createCell(15, CellType.STRING);
				String sl = tableDSSP.getValueAt(i, 7).toString();
				cell.setCellValue(sl);
				cell = row.createCell(16, CellType.STRING);
				String lh = tableDSSP.getValueAt(i, 8).toString();
				cell.setCellValue(lh);
				cell = row.createCell(17, CellType.STRING);
				String gb = tableDSSP.getValueAt(i, 9).toString();
				cell.setCellValue(gb);
				cell = row.createCell(19, CellType.STRING);
				String gn = tableDSSP.getValueAt(i, 10).toString();
				cell.setCellValue(gn);
				cell = row.createCell(21, CellType.STRING);
				String tt = tableDSSP.getValueAt(i, 11).toString();
				cell.setCellValue(tt);

			}

			row = sheet.createRow((short) 11 + n);
			row.setHeight((short) 200);
			cell = row.createCell(6, CellType.STRING);
			cell.setCellValue("-----------------------------------------------------------"
					+ "------------------------------------------------------------------------------------------------------");

			row = sheet.createRow((short) 11 + n);
			row.setHeight((short) 200);
			cell = row.createCell(7, CellType.STRING);
			cell.setCellValue("Chiết khấu: " + textCK.getText());
			cell = row.createCell(9, CellType.STRING);
			cell.setCellValue("Thuế: " + textThue.getText());

			row = sheet.createRow((short) 11 + n + 1);
			row.setHeight((short) 200);
			cell = row.createCell(7, CellType.STRING);
			cell.setCellValue("Tổng thành tiền: " + textTT.getText());

			FileOutputStream out = new FileOutputStream(new File("V:/" + textMaHD.getText() + ".xlsx"));
			f.write(out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		clickSP();

	}

	@Override
	public void mousePressed(MouseEvent e) {
		clickDSSP();

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
