package Gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import ConnectDB.ConnectDB;
import Dao.NhanVien_DAO;
import Entity.NhanVien;

import java.awt.Font;
import javax.swing.SwingConstants;

public class Gui_NhanVien extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnTKCN;
	private JButton btnHD;
	private JButton btnSP;
	private NhanVien_DAO nv_Dao;
	private JButton btnDX;


	/**
	 * Create the frame.
	 */
	public Gui_NhanVien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setSize(1600, 1000);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// connect database
		nv_Dao = new NhanVien_DAO();
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		btnDX = new JButton("�?ăng xuất");
		btnDX.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDX.setBackground(Color.RED);
		btnDX.setForeground(Color.WHITE);
		btnDX.setBounds(32, 25, 130, 38);
		contentPane.add(btnDX);

		JLabel lblCa = new JLabel("Ca :");
		lblCa.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCa.setBounds(1205, 54, 104, 33);
		contentPane.add(lblCa);

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(1, 1, 1, 1));

		panel.setBounds(1177, 10, 338, 177);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNgay = new JLabel("");
		lblNgay.setHorizontalAlignment(SwingConstants.CENTER);
		lblNgay.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNgay.setBounds(156, 10, 157, 33);
		panel.add(lblNgay);
		// get today
		String today = LocalDate.now().toString();
		lblNgay.setText(today);

		JLabel lblCaLam = new JLabel("");
		lblCaLam.setHorizontalAlignment(SwingConstants.CENTER);
		lblCaLam.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCaLam.setBounds(156, 43, 157, 33);
		panel.add(lblCaLam);
		// get ca lam hien tai
		String time = LocalTime.now().toString();
		lblCaLam.setText(time);

		JLabel lblMaNV = new JLabel("");
		lblMaNV.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaNV.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMaNV.setBounds(156, 86, 157, 33);
		panel.add(lblMaNV);

		JLabel lblTenNV = new JLabel("");
		lblTenNV.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenNV.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTenNV.setBounds(156, 129, 157, 33);
		panel.add(lblTenNV);

		JLabel lblMNhnVin = new JLabel("Mã nhân viên :");
		lblMNhnVin.setBounds(26, 86, 104, 33);
		panel.add(lblMNhnVin);
		lblMNhnVin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMNhnVin.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblTnNhnVin = new JLabel("Tên nhân viên :");
		lblTnNhnVin.setBounds(26, 129, 104, 33);
		panel.add(lblTnNhnVin);
		lblTnNhnVin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTnNhnVin.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblNewLabel_2 = new JLabel("VTTM ");
		lblNewLabel_2.setForeground(new Color(0, 191, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Freestyle Script", Font.BOLD | Font.ITALIC, 80));
		lblNewLabel_2.setBounds(497, 171, 469, 108);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Store Management ");
		lblNewLabel_3.setForeground(new Color(0, 191, 255));
		lblNewLabel_3.setFont(new Font("Freestyle Script", Font.BOLD | Font.ITALIC, 80));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(478, 273, 508, 138);
		contentPane.add(lblNewLabel_3);

		btnSP = new JButton("Sản Phẩm");
		btnSP.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSP.setBounds(187, 539, 275, 177);
		contentPane.add(btnSP);

		btnHD = new JButton("Hóa �?ơn");
		btnHD.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnHD.setBounds(647, 539, 300, 177);
		contentPane.add(btnHD);

		btnTKCN = new JButton("Thống Kê Cuối Ngày");
		btnTKCN.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnTKCN.setBounds(1093, 539, 300, 177);
		contentPane.add(btnTKCN);
		// Lấy thông tin nhân viên đang sử dụng phần m�?m
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

		JLabel lblNewLabel = new JLabel("Ngày:");
		lblNewLabel.setBounds(26, 10, 104, 33);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		// �?ăng ký sự kiện
		btnHD.addActionListener(this);
		btnDX.addActionListener(this);
		btnSP.addActionListener(this);
		btnTKCN.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		// event hóa đơn
		if (obj.equals(btnHD)) {
			new Gui_CuaSoHD().setVisible(true);
			dispose();
		}

		// event đăng xuất tài khoản
		else if (obj.equals(btnDX)) {
			int confirm = JOptionPane.showConfirmDialog(this, "Bạn muốn đăng xuất ?", "Thông báo",
					JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				new Gui_DangNhap().setVisible(true);
				dispose();
			}
		}

		// event sản phẩm
		else if (obj.equals(btnSP)) {
			new Gui_XemSP().setVisible(true);
			dispose();

		}

		// event thống kê cuối ngày
		else if (obj.equals(btnTKCN)) {
			new Gui_TKCuoiNgay().setVisible(true);
			dispose();
		}
	}
}
