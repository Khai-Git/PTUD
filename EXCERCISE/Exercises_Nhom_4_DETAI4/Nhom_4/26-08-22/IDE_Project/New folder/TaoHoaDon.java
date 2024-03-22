package GUI;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.JobAttributes;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import com.ibm.icu.impl.UResource.Value;
import com.ibm.icu.util.Calendar;
import com.toedter.calendar.JDateChooser;


import ChucNang.ChiTietHoaDon_CN;
import ChucNang.HoaDon_CN;
import ChucNang.KhachHang_CN;
import ChucNang.NhanVienBanHang_CN;
import ChucNang.SanPham_CN;
import ConnectDB.ConnectDB;
import Entity.ChiTietHoaDon;
import Entity.HoaDon;
import Entity.KhachHang;
import Entity.NhanVien;
import Entity.SanPham;

public class TaoHoaDon extends JPanel implements ActionListener,MouseListener{
	private JTextField txtTenNV;
	private JTextField txtMaNV;
	private JTextField txtTienNhan;
	private JTextField txtVAT;
	private JTextField txtTongTien;
	private JTextField txtTienThua;
	private JLabel lblTitleTTNV;
	private JLabel lblTenNV;
	private JLabel lblMaNV;
	private JLabel lblTitleTTHD;
	private JPanel panelTitXuatHoaDon;
	private JLabel lblTitHDBH;
	private JPanel panelNhapTT2XuatHoaDon;
	private JPanel panelTableXuatHoaDon;
	private JLabel lblTienNhan;
	private JComponent lblVAT;
	private JLabel lblTongTien;
	private JComponent lblTienThua;
	private JButton btnCatHD;
	private JButton btnInHD;
	private JPanel panelNhapTTXuatHoaDon;
	private JTextField txtMaHD;
	private JLabel lblChonKH;
	private JLabel lblChonSP;
	private  JTextField txtChonKHHD;
	private JTextField txtChonSPHD;
	private JTextField txtSoLuongHD;
	private JButton btnXoaSPHD;
	private JButton btnThemSPHD;
	private JButton btnChonSPHD;
	private JButton btnChonKHHD;
	private JTable tableHD;
	private JLabel lblnGi;
	private JTextField txtDonGiaSPHD;
	private DefaultTableModel tableModelHD;
	
	
	private ChiTietHoaDon_CN cthd_dao;
	private HoaDon hoadon;


	//ChonKH
	private JPanel contentPaneKH;
	public JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtSDTKH;
	private JTextField txtEmailKH;
	private JTextField txtDiaChiKH;
	private JButton btnTimKH;
	private JLabel lblDiaChiKH;
	private JPanel panelNhapTTKHTimKH;
	private JLabel lblMaKH;
	private JLabel lblTenKH;
	private JLabel lblSDTKH;
	private JLabel lblEmailKH;
	private JPanel panelTitTimKH;
	private JLabel lblTitTimKH;
	private JPanel panelTableTimKH;
	private JButton btnChonKH;
	private  JTable tableKH;
	private  JFrame mainFrameKH;
	private  DefaultTableModel tableModelKH;
	private String StrNameKH;

	private  KhachHang_CN kh_dao;
	private  KhachHang khachhang;
	
	//ChonSP
	private JPanel contentPane;
	private JTextField txtMaSP;
	private JTextField txtTenSP;
	private JPanel panelNhapTTKHTim;
	private JLabel lblMaSP;
	private JLabel lblTimTenSP;
	private JLabel lblTimLoaiSP;
	private JLabel lblTimKichCoSP;
	private JLabel lblTimMauSacSP;
	private JButton btnTimSP;
	private JComboBox cbBoxKichCoSP;
	private JComboBox cbBoxMauSacSP;
	private JPanel panelTitTimSP;
	private JLabel lblTitTimSP;
	private JPanel panelTableTimSP;
	private JButton btnChonSP;
	private JScrollPane scrollPane;
	private JTable tableSP;
	private  JFrame mainFrameSP;
	private JTextField txtSoLuongSP;
	private JTextField txtDonGiaSP;
	private DefaultTableModel tableModelSP;
	
	private String maSP;
	private String StrNameSP;
	
	
	
	private SanPham_CN sp_dao;
    private SanPham sanpham;
	/**
	 * Create the panel.
	 */
//	private String maKH ="";
//	private String tenSP ="";
//	private double donGiaSP = 0;
	
	
    private int  i = 0;
	public TaoHoaDon() {
		
		ConnectDB.getInstance().connect();
//		cthd_dao = new ChiTietHoaDon_CN();
		
//		maKH += makh;
//		tenSP += tensp;
//		donGiaSP +=dongiasp;
		setBackground(new Color(136, 136, 136));
		setLayout(null);

		panelNhapTTXuatHoaDon = new JPanel();
		panelNhapTTXuatHoaDon.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "NH\u1EACP TH\u00D4NG TIN", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(136, 136, 136)));
		panelNhapTTXuatHoaDon.setLayout(null);
		panelNhapTTXuatHoaDon.setBounds(10, 10, 268, 716);
		add(panelNhapTTXuatHoaDon);

		lblTitleTTNV = new JLabel("Thông tin nhân viên\r\n");
		lblTitleTTNV.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleTTNV.setForeground(new Color(136, 136, 136));
		lblTitleTTNV.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitleTTNV.setBounds(10, 46, 248, 36);
		panelNhapTTXuatHoaDon.add(lblTitleTTNV);

		lblTenNV = new JLabel("Tên nhân viên\r\n");
		lblTenNV.setHorizontalAlignment(SwingConstants.LEFT);
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTenNV.setBounds(10, 165, 248, 36);
		panelNhapTTXuatHoaDon.add(lblTenNV);

		txtTenNV = new JTextField();
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(10, 204, 248, 36);
		panelNhapTTXuatHoaDon.add(txtTenNV);

		txtMaNV = new JTextField();
		txtMaNV.setBounds(10, 131, 248, 36);
		panelNhapTTXuatHoaDon.add(txtMaNV);
		txtMaNV.setColumns(10);

		lblMaNV = new JLabel("Mã nhân viên\r\n");
		lblMaNV.setBounds(10, 92, 248, 36);
		panelNhapTTXuatHoaDon.add(lblMaNV);
		lblMaNV.setHorizontalAlignment(SwingConstants.LEFT);
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 18));

		lblTitleTTHD = new JLabel("Thông tin hóa đơn\r\n");
		lblTitleTTHD.setBounds(10, 344, 248, 36);
		panelNhapTTXuatHoaDon.add(lblTitleTTHD);
		lblTitleTTHD.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleTTHD.setForeground(new Color(136, 136, 136));
		lblTitleTTHD.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblMaHD = new JLabel("Mã hóa đơn\r\n");
		lblMaHD.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaHD.setBounds(10, 390, 122, 39);
		panelNhapTTXuatHoaDon.add(lblMaHD);

		txtMaHD = new JTextField();
		txtMaHD.setColumns(10);
		txtMaHD.setBounds(10, 426, 248, 31);
		panelNhapTTXuatHoaDon.add(txtMaHD);

		panelTitXuatHoaDon = new JPanel();
		panelTitXuatHoaDon.setLayout(null);
		panelTitXuatHoaDon.setBounds(288, 10, 1237, 60);
		add(panelTitXuatHoaDon);

		lblTitHDBH = new JLabel("Hóa đơn bán hàng\r\n");
		lblTitHDBH.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitHDBH.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTitHDBH.setBounds(10, 10, 1217, 45);
		panelTitXuatHoaDon.add(lblTitHDBH);

		panelNhapTT2XuatHoaDon = new JPanel();
		panelNhapTT2XuatHoaDon.setBorder(new TitledBorder(null, "B\u1EA2NG HI\u1EC2N TH\u1ECA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(136, 136, 136)));
		panelNhapTT2XuatHoaDon.setLayout(null);
		panelNhapTT2XuatHoaDon.setBounds(288, 80, 1237, 417);
		add(panelNhapTT2XuatHoaDon);

		lblChonKH = new JLabel("Chọn khách hàng");
		lblChonKH.setHorizontalAlignment(SwingConstants.LEFT);
		lblChonKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblChonKH.setBounds(10, 10, 199, 36);
		panelNhapTT2XuatHoaDon.add(lblChonKH);

		lblChonSP = new JLabel("Chọn sản phẩm");
		lblChonSP.setHorizontalAlignment(SwingConstants.LEFT);
		lblChonSP.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblChonSP.setBounds(10, 78, 199, 36);
		panelNhapTT2XuatHoaDon.add(lblChonSP);

		txtChonKHHD = new JTextField();
		txtChonKHHD.setBounds(168, 10, 199, 36);
		panelNhapTT2XuatHoaDon.add(txtChonKHHD);
		txtChonKHHD.setColumns(10);

		txtChonSPHD = new JTextField();
		txtChonSPHD.setColumns(10);
		txtChonSPHD.setBounds(168, 78, 199, 36);
		panelNhapTT2XuatHoaDon.add(txtChonSPHD);

		btnChonKHHD = new JButton("");
		btnChonKHHD.setBounds(366, 10, 46, 36);
		btnChonKHHD.addActionListener(this);
		panelNhapTT2XuatHoaDon.add(btnChonKHHD);
		btnChonKHHD.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(TaoHoaDon.class.getResource("them_icon.png"))));


		btnChonSPHD = new JButton("");
		btnChonSPHD.setBounds(366, 78, 46, 36);
		btnChonSPHD.addActionListener(this);
		panelNhapTT2XuatHoaDon.add(btnChonSPHD);
		btnChonSPHD.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(TaoHoaDon.class.getResource("them_icon.png"))));

		btnThemSPHD = new JButton("Thêm sản phẩm");
		btnThemSPHD.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThemSPHD.setBounds(121, 365, 210, 42);
		panelNhapTT2XuatHoaDon.add(btnThemSPHD);
		btnThemSPHD.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(TaoHoaDon.class.getResource("them_icon.png"))));

		btnXoaSPHD = new JButton("Xóa sản phẩm");
		btnXoaSPHD.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnXoaSPHD.setBounds(661, 365, 216, 42);
		panelNhapTT2XuatHoaDon.add(btnXoaSPHD);
		btnXoaSPHD.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(TaoHoaDon.class.getResource("xoa_icon.png"))));

		JLabel lblSoLuongSP = new JLabel("Số lượng");
		lblSoLuongSP.setHorizontalAlignment(SwingConstants.LEFT);
		lblSoLuongSP.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSoLuongSP.setBounds(427, 78, 98, 36);
		panelNhapTT2XuatHoaDon.add(lblSoLuongSP);

		txtSoLuongHD = new JTextField();
		txtSoLuongHD.setColumns(10);
		txtSoLuongHD.setBounds(502, 82, 61, 32);
		panelNhapTT2XuatHoaDon.add(txtSoLuongHD);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 124, 1217, 234);
		panelNhapTT2XuatHoaDon.add(scrollPane);

		tableHD = new JTable();
		tableHD.setFont(new Font("Tahoma", Font.ITALIC, 15));
		String [] header ={"Mã sản phẩm","Tên sản phẩm","Số lượng","Đơn giá","Thành tiền"};
		tableModelHD = new DefaultTableModel(header,0);
		scrollPane.setViewportView(tableHD = new JTable(tableModelHD));

		lblnGi = new JLabel("Đơn giá");
		lblnGi.setHorizontalAlignment(SwingConstants.LEFT);
		lblnGi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblnGi.setBounds(580, 78, 88, 36);
		panelNhapTT2XuatHoaDon.add(lblnGi);

		txtDonGiaSPHD = new JTextField();
		txtDonGiaSPHD.setColumns(10);
		txtDonGiaSPHD.setBounds(647, 82, 156, 32);
		panelNhapTT2XuatHoaDon.add(txtDonGiaSPHD);
		
		

		panelTableXuatHoaDon = new JPanel();
		panelTableXuatHoaDon.setBorder(new TitledBorder(null, "CH\u1EE8C N\u0102NG", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(136, 136, 136)));
		panelTableXuatHoaDon.setLayout(null);
		panelTableXuatHoaDon.setBounds(288, 506, 1237, 220);
		add(panelTableXuatHoaDon);

		lblTienNhan = new JLabel("Tiền nhận");
		lblTienNhan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTienNhan.setBounds(128, 10, 186, 35);
		panelTableXuatHoaDon.add(lblTienNhan);

		txtTienNhan = new JTextField();
		txtTienNhan.setColumns(10);
		txtTienNhan.setBounds(128, 40, 186, 35);
		panelTableXuatHoaDon.add(txtTienNhan);

		lblVAT = new JLabel("VAT");
		lblVAT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVAT.setBounds(366, 10, 186, 35);
		panelTableXuatHoaDon.add(lblVAT);

		txtVAT = new JTextField();
		txtVAT.setColumns(10);
		txtVAT.setBounds(366, 40, 186, 35);
		panelTableXuatHoaDon.add(txtVAT);

		lblTongTien = new JLabel("Tổng tiền");
		lblTongTien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTongTien.setBounds(366, 69, 186, 35);
		panelTableXuatHoaDon.add(lblTongTien);

		txtTongTien = new JTextField();
		txtTongTien.setColumns(10);
		txtTongTien.setBounds(366, 99, 186, 35);
		panelTableXuatHoaDon.add(txtTongTien);

		lblTienThua = new JLabel("Tiền thừa");
		lblTienThua.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTienThua.setBounds(128, 69, 186, 35);
		panelTableXuatHoaDon.add(lblTienThua);

		txtTienThua = new JTextField();
		txtTienThua.setColumns(10);
		txtTienThua.setBounds(128, 99, 186, 35);
		panelTableXuatHoaDon.add(txtTienThua);

		btnCatHD = new JButton("Thanh toán");
		btnCatHD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCatHD.setBounds(698, 171, 167, 40);
		panelTableXuatHoaDon.add(btnCatHD);
		btnCatHD.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(TaoHoaDon.class.getResource("cat_icon.png"))));

		btnInHD = new JButton("In hóa đơn");
		btnInHD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnInHD.setBounds(876, 171, 167, 40);
		panelTableXuatHoaDon.add(btnInHD);
		btnInHD.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(TaoHoaDon.class.getResource("in_icon.png"))));
	
	    btnCatHD.addActionListener(this);
	    btnXoaSPHD.addActionListener(this);
	    btnThemSPHD.addActionListener(this);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnChonKHHD)) {
			createGuiKH();
		} else
		if(o.equals(btnChonSPHD)) {
			createGuiSP();
		} else if(o.equals(btnChonKH)) {
			
			String a = txtMaKH.getText();
			txtChonKHHD.setText(a);
			mainFrameKH.dispose();
		} else if(o.equals(btnChonSP)) {
			
			String b = txtTenSP.getText();
			txtChonSPHD.setText(b);
			txtDonGiaSPHD.setText(txtDonGiaSP.getText());
			
			mainFrameSP.dispose();
		}else if(o.equals(btnTimKH)) {   
			timKiemTheoTenKH();
		}else if(o.equals(btnTimSP)) {
			timKiemTheoTenSP();
		}else if(o.equals(btnThemSPHD)) {
			
			themChiTietHoaDon();
			tongtien();

		}else if(o.equals(btnCatHD)) {
			tienThoi();
			themHoaDon();
		}else if(o.equals(btnXoaSPHD)) {
			xoaChiTietHoaDon();
			tongtien();
		}
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

	//timKH
	public  void createGuiKH() {

		mainFrameKH = new JFrame("Khach hang");
		mainFrameKH.setBounds(125, 25, 1400, 750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		mainFrameKH.setContentPane(contentPane);
		contentPane.setLayout(null);

		mainFrameKH.getContentPane().add (panelNhapTTKHTim = new JPanel());
		panelNhapTTKHTim.setBounds(10, 10, 268, 693);
		contentPane.add(panelNhapTTKHTim);
		panelNhapTTKHTim.setLayout(null);

		lblMaKH = new JLabel("Mã khách hàng\r\n\r\n");
		lblMaKH.setHorizontalAlignment(SwingConstants.LEFT);
		lblMaKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaKH.setBounds(10, 95, 128, 27);
		panelNhapTTKHTim.add(lblMaKH);

		txtMaKH = new JTextField();
        
		txtMaKH.setColumns(10);
		txtMaKH.setBounds(10, 122, 197, 27);
		panelNhapTTKHTim.add(txtMaKH);

		lblTenKH = new JLabel("Tên khách hàng");
		lblTenKH.setHorizontalAlignment(SwingConstants.LEFT);
		lblTenKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTenKH.setBounds(10, 175, 140, 27);
		panelNhapTTKHTim.add(lblTenKH);

		txtTenKH = new JTextField();
		txtTenKH.setText("Nhập tên để tìm kiếm");
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(10, 206, 197, 27);
		panelNhapTTKHTim.add(txtTenKH);

		lblSDTKH = new JLabel("Số điện thoại\r\n");
		lblSDTKH.setHorizontalAlignment(SwingConstants.LEFT);
		lblSDTKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSDTKH.setBounds(10, 257, 128, 27);
		panelNhapTTKHTim.add(lblSDTKH);

		txtSDTKH = new JTextField();
		txtSDTKH.setColumns(10);
		txtSDTKH.setBounds(10, 284, 197, 27);
		panelNhapTTKHTim.add(txtSDTKH);

		lblEmailKH = new JLabel("Email");
		lblEmailKH.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmailKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmailKH.setBounds(10, 336, 128, 27);
		panelNhapTTKHTim.add(lblEmailKH);

		txtEmailKH = new JTextField();
		txtEmailKH.setColumns(10);
		txtEmailKH.setBounds(10, 360, 197, 27);
		panelNhapTTKHTim.add(txtEmailKH);

		lblDiaChiKH = new JLabel("Địa chỉ\r\n");
		lblDiaChiKH.setHorizontalAlignment(SwingConstants.LEFT);
		lblDiaChiKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDiaChiKH.setBounds(10, 412, 128, 27);
		panelNhapTTKHTim.add(lblDiaChiKH);

		txtDiaChiKH = new JTextField();
		txtDiaChiKH.setColumns(10);
		txtDiaChiKH.setBounds(10, 439, 197, 27);
		panelNhapTTKHTim.add(txtDiaChiKH);

		btnTimKH = new JButton("Tìm kiếm");
		btnTimKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTimKH.setBounds(65, 544, 142, 49);
		panelNhapTTKHTim.add(btnTimKH);

		panelTitTimKH = new JPanel();
		panelTitTimKH.setBounds(288, 10, 1088, 85);
		contentPane.add(panelTitTimKH);
		panelTitTimKH.setLayout(null);

		lblTitTimKH = new JLabel("Tìm kiếm khách hàng");
		lblTitTimKH.setBounds(10, 10, 1068, 59);
		lblTitTimKH.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitTimKH.setFont(new Font("Tahoma", Font.BOLD, 25));
		panelTitTimKH.add(lblTitTimKH);

		panelTableTimKH = new JPanel();
		panelTableTimKH.setBounds(288, 105, 1088, 598);
		contentPane.add(panelTableTimKH);
		panelTableTimKH.setLayout(null);

		btnChonKH = new JButton("Chọn");
		btnChonKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnChonKH.setBounds(507, 501, 142, 49);
		panelTableTimKH.add(btnChonKH);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1068, 462);
		panelTableTimKH.add(scrollPane);

		tableKH = new JTable();
		tableKH.setFont(new Font("Tahoma", Font.ITALIC, 15));
		String [] headerKH ="Mã khách hàng;Tên khách hàng;Địa chỉ;Số điện thoại;Email".split(";");
		tableModelKH = new DefaultTableModel(headerKH,0);
		scrollPane.setViewportView(tableKH=new JTable(tableModelKH));

		btnChonKH.addActionListener(this);
		btnTimKH.addActionListener(this);
        tableKH.addMouseListener(this);
		mainFrameKH.setVisible(true);
		
		docDuLieuVaoTableKH();
      
	}
	public void createGuiSP() {

		
		mainFrameSP = new JFrame("San Pham");
		mainFrameSP.setBounds(125, 25, 1400, 750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(136, 136, 136));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		mainFrameSP.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		mainFrameSP.getContentPane().add(panelNhapTTKHTim = new JPanel());
		panelNhapTTKHTim.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "NH\u1EACP TH\u00D4NG TIN", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(136, 136, 136)));
		panelNhapTTKHTim.setLayout(null);
		panelNhapTTKHTim.setBounds(10, 10, 268, 693);
		contentPane.add(panelNhapTTKHTim);
		
		
		
		lblMaSP = new JLabel("Mã sản phẩm");
		lblMaSP.setHorizontalAlignment(SwingConstants.LEFT);
		lblMaSP.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaSP.setBounds(10, 104, 128, 27);
		panelNhapTTKHTim.add(lblMaSP);
		
		txtMaSP = new JTextField();
		txtMaSP.setColumns(10);
		txtMaSP.setBounds(10, 131, 197, 27);
		panelNhapTTKHTim.add(txtMaSP);
		
		lblTimTenSP = new JLabel("Tên sản phẩm");
		lblTimTenSP.setHorizontalAlignment(SwingConstants.LEFT);
		lblTimTenSP.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTimTenSP.setBounds(10, 184, 140, 27);
		panelNhapTTKHTim.add(lblTimTenSP);
		
		txtTenSP = new JTextField();
		txtTenSP.setText("Nhập tên để tìm kiếm...");
		txtTenSP.setColumns(10);
		txtTenSP.setBounds(10, 215, 197, 27);
		panelNhapTTKHTim.add(txtTenSP);
		
		lblTimLoaiSP = new JLabel("Số lượng");
		lblTimLoaiSP.setHorizontalAlignment(SwingConstants.LEFT);
		lblTimLoaiSP.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTimLoaiSP.setBounds(10, 266, 128, 27);
		panelNhapTTKHTim.add(lblTimLoaiSP);
		
		lblTimKichCoSP = new JLabel("Kích cỡ");
		lblTimKichCoSP.setHorizontalAlignment(SwingConstants.LEFT);
		lblTimKichCoSP.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTimKichCoSP.setBounds(10, 345, 128, 27);
		panelNhapTTKHTim.add(lblTimKichCoSP);
		
		lblTimMauSacSP = new JLabel("Màu sắc");
		lblTimMauSacSP.setHorizontalAlignment(SwingConstants.LEFT);
		lblTimMauSacSP.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTimMauSacSP.setBounds(10, 421, 128, 27);
		panelNhapTTKHTim.add(lblTimMauSacSP);
		
		btnTimSP = new JButton("Tìm kiếm");
		btnTimSP.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTimSP.setBounds(40, 598, 142, 49);
		panelNhapTTKHTim.add(btnTimSP);
		
		String[] kichco= {"S","M","L","XL"};
		cbBoxKichCoSP = new JComboBox(kichco);
		cbBoxKichCoSP.setFont(new Font("Tahoma", Font.ITALIC, 15));
		cbBoxKichCoSP.setBounds(10, 372, 197, 27);
		panelNhapTTKHTim.add(cbBoxKichCoSP);
		
		String[] mausac= {"Trang","Den","Do","Vang","Luc","Lam","Hong","Tim","Nau"};
		cbBoxMauSacSP = new JComboBox(mausac);
		cbBoxMauSacSP.setFont(new Font("Tahoma", Font.ITALIC, 15));
		cbBoxMauSacSP.setBounds(10, 447, 197, 27);
		panelNhapTTKHTim.add(cbBoxMauSacSP);
		
		txtSoLuongSP = new JTextField();
		txtSoLuongSP.setBounds(10, 303, 197, 32);
		panelNhapTTKHTim.add(txtSoLuongSP);
		txtSoLuongSP.setColumns(10);
		
		JLabel lblnGi = new JLabel("Đơn giá");
		lblnGi.setHorizontalAlignment(SwingConstants.LEFT);
		lblnGi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblnGi.setBounds(10, 501, 128, 27);
		panelNhapTTKHTim.add(lblnGi);
		
		txtDonGiaSP = new JTextField();
		txtDonGiaSP.setColumns(10);
		txtDonGiaSP.setBounds(10, 538, 197, 27);
		panelNhapTTKHTim.add(txtDonGiaSP);
		
		panelTitTimSP = new JPanel();
		panelTitTimSP.setLayout(null);
		panelTitTimSP.setBounds(288, 10, 1088, 85);
		contentPane.add(panelTitTimSP);
		
		lblTitTimSP = new JLabel("Tìm kiếm sản phẩm");
		lblTitTimSP.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitTimSP.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTitTimSP.setBounds(10, 10, 1068, 59);
		panelTitTimSP.add(lblTitTimSP);
		
		panelTableTimKH = new JPanel();
		panelTableTimKH.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "B\u1EA2NG HI\u1EC2N TH\u1ECA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(136, 136, 136)));
		panelTableTimKH.setLayout(null);
		panelTableTimKH.setBounds(288, 105, 1088, 598);
		contentPane.add(panelTableTimKH);
		
		btnChonSP = new JButton("Chọn");
		btnChonSP.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnChonSP.setBounds(507, 501, 142, 49);
		panelTableTimKH.add(btnChonSP);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 1068, 458);
		panelTableTimKH.add(scrollPane);
		
		tableSP = new JTable();
		tableSP.setFont(new Font("Tahoma", Font.ITALIC, 15));
		//String [] header = "Mã nhân viên";"Tên nhân viên";"Ngày sinh""Số điện thoại","Email","Địa chỉ","Học vấn";"Giới tính".split(;);
		String [] headerSP ="Mã sản phẩm;Tên sản phẩm;Số lượng sản phẩm;Kích cở;Màu sắc;Đơn giá;Mô tả sản phẩm".split(";");
		tableModelSP = new DefaultTableModel(headerSP,0);
		
		scrollPane.setViewportView(tableSP = new JTable(tableModelSP));
		
		tableSP.addMouseListener(this);
	    btnTimSP.addActionListener(this);
	    btnChonSP.addActionListener(this);
	   
	    mainFrameSP.setVisible(true);
		docDuLieuVaoTableSP();
	}

	
	private  void docDuLieuVaoTableKH()
	{
		kh_dao = new KhachHang_CN();
		List<KhachHang> kh = kh_dao.getAllTBKhachHang();
		for (KhachHang khachHang : kh) {
			String rowData [] = {
					khachHang.getMaKH(),khachHang.getTenKH(),khachHang.getDiaChiKH(),khachHang.getSdtKH(),khachHang.getEmailKH()
			};
			tableModelKH.addRow(rowData);
		}
		tableKH.setModel(tableModelKH);
	}
	
	private void docDuLieuVaoTableSP()
	{
		sp_dao = new SanPham_CN();
		ArrayList<SanPham> sp = sp_dao.getAllTBSanPham();
		for (SanPham SanPham : sp) {
			String rowData [] = {
				SanPham.getMaSP(),SanPham.getTenSP(),SanPham.getSoLuong()+"",SanPham.getKichCo(),SanPham.getMauSac(),SanPham.getGiaSP()+"",SanPham.getMoTaSP()
			};
			tableModelSP.addRow(rowData);
		}
	   tableSP.setModel(tableModelSP);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if(o.equals(tableHD)) {
			
		}else if(o.equals(tableKH)) {
			int row = tableKH.getSelectedRow();
			txtMaKH.setText(tableKH.getValueAt(row, 0).toString());
			txtTenKH.setText(tableKH.getValueAt(row,1).toString());
			txtDiaChiKH.setText(tableKH.getValueAt(row, 2).toString());
			txtSDTKH.setText(tableKH.getValueAt(row, 3).toString());
			txtEmailKH.setText(tableKH.getValueAt(row, 4).toString());
		}else if(o.equals(tableSP)) {
			int row = tableSP.getSelectedRow();
			txtMaSP.setText(tableSP.getValueAt(row, 0).toString());
			maSP = txtMaSP.getText();
//			JOptionPane.showMessageDialog(null, maSP);
			txtTenSP.setText(tableSP.getValueAt(row,1).toString());
			txtSoLuongSP.setText(tableSP.getValueAt(row, 2).toString());
			cbBoxKichCoSP.setSelectedItem(tableSP.getValueAt(row, 3).toString());
			cbBoxMauSacSP.setSelectedItem(tableSP.getValueAt(row, 4).toString());
			txtDonGiaSP.setText(tableSP.getValueAt(row, 5).toString());
		}
		// TODO Auto-generated method stub
		
	}
	public void timKiemTheoTenSP()
	{
		    SanPham_CN sp_dao1 = new SanPham_CN();
			DefaultTableModel tbModel = (DefaultTableModel) tableSP.getModel();
			tbModel.setRowCount(0);
			StrNameSP = txtTenSP.getText();
			for (SanPham sp : sp_dao1.timKiemSanPhamTheoTen(StrNameSP))
			{
				Object dataRow [] = new Object [6];
				dataRow[0] = sp.getMaSP();
				dataRow[1] = sp.getTenSP();
				dataRow[2] = sp.getSoLuong();
				dataRow[3] = sp.getKichCo();
				dataRow[4] = sp.getMauSac();
				dataRow[5] = sp.getGiaSP();
				tableModelSP.addRow(dataRow);
				
			}
			tableSP.setModel(tableModelSP);
		}
	private void timKiemTheoTenKH()
	{ 
		     KhachHang_CN kh_dao1 =  new KhachHang_CN();
			  tableModelKH.setRowCount(0);
			   StrNameKH = txtTenKH.getText();
				
				for (KhachHang kh : kh_dao1.timKiemKhachHangTheoTen(StrNameKH))
				{
					Object dataRow [] = new Object [5];
					dataRow[0] = kh.getMaKH();
					dataRow[1] = kh.getTenKH();
					dataRow[2] = kh.getDiaChiKH();
					dataRow[3] = kh.getSdtKH();
					dataRow[4] = kh.getEmailKH();
					
					tableModelKH.addRow(dataRow);
				}
				
				tableKH.setModel(tableModelKH);
				
		   
			
		}
//	private void themChiTietHoaDon()
//	{
//		int row = tableHD.getSelectedRow();
//		
//		String tenSP= tableHD.getValueAt(row, 0).toString();
//		String soLuong = JOptionPane.showInputDialog(null,"Nhập số lượng:");
//		String soLuongSPTrongKho=tableHD.getValueAt(row,1).toString();
//		if(Integer.parseInt(soLuong)> Integer.parseInt(soLuongSPTrongKho)) {
//			JOptionPane.showMessageDialog(null,"Số lượng mua vượt quá số lượng có trong kho");
//		    soLuong = "";
//		}
//		double donGia = Double.parseDouble(tableHD.getValueAt(row,2).toString()) ;
//		String thanhTien = tableHD.getValueAt(row,3).toString();
//		
//		ChiTietHoaDon_CN cthd_dao = new ChiTietHoaDon_CN();
//		ChiTietHoaDon cthd = new ChiTietHoaDon( 
//				tenSP,
//				Integer.parseInt(soLuong),
//				donGia,
//				Double.parseDouble(thanhTien)
//				);
//        
//		try {
//			if(cthd_dao.createCTHD(cthd)) {
//				tableModelHD.addRow(new Object[] {
//					cthd.getSanPham().getTenSP(),cthd.getSoLuong(),cthd.getSanPham().getGiaSP(),cthd.getThanhTien()
//				});
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	
//	} 
	private void themChiTietHoaDon(){
		String maSP1 = txtMaSP.getText();
		String tenSP = txtChonSPHD.getText();
		String soLuong = txtSoLuongHD.getText();
		String donGia = txtDonGiaSPHD.getText();
		 
	
		
		 tableModelHD.addRow(new Object[] {maSP1,tenSP,soLuong,donGia,String.valueOf(Double.parseDouble(soLuong) * Double.parseDouble(donGia))});
	    
	}
	public void xoaChiTietHoaDon ()
	{
		int row = tableHD.getSelectedRow();
		if(row>=0)
		{
			String maSP2 = (String) tableHD.getValueAt(row, 0);
			int hoiNhac = JOptionPane.showConfirmDialog(this,"Bạn có chắc muốn xóa không","Chú ý",JOptionPane.YES_NO_OPTION);
			if(hoiNhac == JOptionPane.YES_OPTION)
			{
					tableModelHD.removeRow(row);
			}
		}
	}
	
	
	private void themHoaDon(){
		String maHD = txtMaHD.getText();
		String maNV = txtMaNV.getText();
		String tenNV = txtTenNV.getText();
		String maKH = txtMaKH.getText();
		double vat = Double.parseDouble(txtVAT.getText());
		double tongTien = Double.parseDouble(txtTongTien.getText());
		double tienNhan = Double.parseDouble(txtTienNhan.getText());
		double tienThua = Double.parseDouble(txtTienThua.getText());
		
		hoadon = new HoaDon(maHD, new Date(Calendar.getInstance().getTime().getTime()), 
				new NhanVien(maNV, tenNV), new KhachHang(maKH), vat, tongTien, tienNhan, tienThua);
	    HoaDon_CN dao_hd = new HoaDon_CN();
	    if(dao_hd.createHD(hoadon)) {
	    	JOptionPane.showMessageDialog(null, "TC");
	    } else {
	    	JOptionPane.showMessageDialog(null, "TB");
	    }
	    
	    ChiTietHoaDon_CN dao_cthd = new ChiTietHoaDon_CN();
	    for(int i = 0; i < tableHD.getRowCount(); i++) {
	    	String ma = tableHD.getValueAt(i, 0).toString();
	    	String t = tableHD.getValueAt(i, 1).toString();
	    	String sl = tableHD.getValueAt(i, 2).toString();
	    	String dg = tableHD.getValueAt(i, 3).toString();
	    	String tt = tableHD.getValueAt(i, 4).toString();
	    	
	    	ChiTietHoaDon cthd = new ChiTietHoaDon(new HoaDon(txtMaHD.getText()), 
					new SanPham(ma, 
							t, 
							Integer.parseInt(sl), 
							Double.parseDouble(dg)), 
					Double.parseDouble(tt));
		    if(dao_cthd.createCTHD(cthd)) {
		    	JOptionPane.showMessageDialog(null, "ThemHD TC");
		    } else {
		    	JOptionPane.showMessageDialog(null, "ThemHD TB");
		    }
		    
	    }  
	}
	
	private void tongtien() {
		double vat = 0;
		double tongTien=0;
		double thanhTien=0;
		for(int i =0;i < tableHD.getRowCount();i++) {
			tongTien += Double.parseDouble(tableHD.getValueAt(i, 4).toString());
	        vat = tongTien/100*10;
	        thanhTien=tongTien+vat;
		}
		txtVAT.setText(""+vat);
		txtTongTien.setText(""+thanhTien);
	}
	private void tienThoi() {
	  double tiennhan = Double.parseDouble(txtTienNhan.getText());
	  double tongtien = Double.parseDouble(txtTongTien.getText());
	  double tienthua=0;
	  if(tiennhan >= tongtien ) {
	       tienthua=tiennhan - tongtien;	
	       txtTienThua.setText(""+String.valueOf(tienthua));
	  } else
		  JOptionPane.showMessageDialog(null,"Không đủ tiền thanh toán");
	}
	
}


