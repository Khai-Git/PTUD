package Gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;

import ConnectDB.ConnectDB;
import Dao.SanPham_DAO;
import Entity.NhaCungCap;
import Entity.SanPham;

public class Gui_CuaSoUpDateSP extends JFrame implements ActionListener, WindowFocusListener, WindowListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textMSP;
	private JTextField textTSP;
	private JTextField textMau;
	private JTextField textSize;
	private JTextField textLoai;
	private JTextField textNgay;
	private JTextField textLH;
	private JTextField textSLT;
	private JTextField textGiaN;
	private JTextField textGiaB;
	private JTextField textMNCC;
	private JTextField textTNCC;
	private JButton btnHuy;
	private JButton btnXN;
	private SanPham_DAO sp_Dao;
	private JTextField textHang;
	/**
	 * Create the frame.
	 */
	public Gui_CuaSoUpDateSP(String ma) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(270, 70, 1024, 544);
		setResizable(false);
		this.requestFocusInWindow(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// connect data
		sp_Dao = new SanPham_DAO();
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JLabel lblNewLabel = new JLabel("Mã sản phẩm:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(75, 162, 111, 25);
		contentPane.add(lblNewLabel);

		textMSP = new JTextField();
		textMSP.setEditable(false);
		textMSP.setHorizontalAlignment(SwingConstants.CENTER);
		textMSP.setFont(new Font("Tahoma", Font.BOLD, 14));
		textMSP.setBounds(196, 164, 152, 25);
		contentPane.add(textMSP);
		textMSP.setColumns(10);

		JLabel lblTnSnPhm = new JLabel("Tên sản phẩm:");
		lblTnSnPhm.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTnSnPhm.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTnSnPhm.setBounds(75, 197, 111, 25);
		contentPane.add(lblTnSnPhm);

		textTSP = new JTextField();
		textTSP.setHorizontalAlignment(SwingConstants.CENTER);
		textTSP.setFont(new Font("Tahoma", Font.BOLD, 14));
		textTSP.setColumns(10);
		textTSP.setBounds(196, 197, 152, 25);
		contentPane.add(textTSP);

		JLabel lblMu = new JLabel("Màu:");
		lblMu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMu.setBounds(75, 232, 111, 25);
		contentPane.add(lblMu);

		textMau = new JTextField();
		textMau.setHorizontalAlignment(SwingConstants.CENTER);
		textMau.setFont(new Font("Tahoma", Font.BOLD, 14));
		textMau.setColumns(10);
		textMau.setBounds(196, 232, 152, 25);
		contentPane.add(textMau);

		JLabel lblSize = new JLabel("Size:");
		lblSize.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSize.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSize.setBounds(75, 267, 111, 25);
		contentPane.add(lblSize);

		textSize = new JTextField();
		textSize.setHorizontalAlignment(SwingConstants.CENTER);
		textSize.setFont(new Font("Tahoma", Font.BOLD, 14));
		textSize.setColumns(10);
		textSize.setBounds(196, 267, 152, 25);
		contentPane.add(textSize);

		JLabel lblLoi = new JLabel("Loại:");
		lblLoi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLoi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLoi.setBounds(358, 162, 111, 25);
		contentPane.add(lblLoi);

		textLoai = new JTextField();
		textLoai.setHorizontalAlignment(SwingConstants.CENTER);
		textLoai.setFont(new Font("Tahoma", Font.BOLD, 14));
		textLoai.setColumns(10);
		textLoai.setBounds(479, 162, 152, 25);
		contentPane.add(textLoai);

		JLabel lblNgyNhp = new JLabel("Ngày nhập:");
		lblNgyNhp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNgyNhp.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNgyNhp.setBounds(358, 197, 111, 25);
		contentPane.add(lblNgyNhp);

		textNgay = new JTextField();
		textNgay.setHorizontalAlignment(SwingConstants.CENTER);
		textNgay.setFont(new Font("Tahoma", Font.BOLD, 14));
		textNgay.setColumns(10);
		textNgay.setBounds(479, 202, 152, 25);
		contentPane.add(textNgay);

		JLabel lblLHng = new JLabel("Lô Hàng:");
		lblLHng.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLHng.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLHng.setBounds(358, 232, 111, 25);
		contentPane.add(lblLHng);

		textLH = new JTextField();
		textLH.setHorizontalAlignment(SwingConstants.CENTER);
		textLH.setFont(new Font("Tahoma", Font.BOLD, 14));
		textLH.setColumns(10);
		textLH.setBounds(479, 237, 152, 25);
		contentPane.add(textLH);

		JLabel lblSLngTn = new JLabel("Số lượng tồn:");
		lblSLngTn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSLngTn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSLngTn.setBounds(75, 302, 111, 25);
		contentPane.add(lblSLngTn);

		textSLT = new JTextField();
		textSLT.setHorizontalAlignment(SwingConstants.CENTER);
		textSLT.setFont(new Font("Tahoma", Font.BOLD, 14));
		textSLT.setColumns(10);
		textSLT.setBounds(196, 302, 152, 25);
		contentPane.add(textSLT);

		JLabel lblGiNhp = new JLabel("Giá nhập:");
		lblGiNhp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGiNhp.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGiNhp.setBounds(358, 267, 111, 25);
		contentPane.add(lblGiNhp);

		JLabel lblGiBn = new JLabel("Giá bán:");
		lblGiBn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGiBn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGiBn.setBounds(358, 302, 111, 25);
		contentPane.add(lblGiBn);

		textGiaN = new JTextField();
		textGiaN.setHorizontalAlignment(SwingConstants.CENTER);
		textGiaN.setFont(new Font("Tahoma", Font.BOLD, 14));
		textGiaN.setColumns(10);
		textGiaN.setBounds(479, 272, 152, 25);
		contentPane.add(textGiaN);

		textGiaB = new JTextField();
		textGiaB.setHorizontalAlignment(SwingConstants.CENTER);
		textGiaB.setFont(new Font("Tahoma", Font.BOLD, 14));
		textGiaB.setColumns(10);
		textGiaB.setBounds(479, 307, 152, 25);
		contentPane.add(textGiaB);

		btnHuy = new JButton("Hủy");
		btnHuy.setBackground(Color.RED);
		btnHuy.setForeground(Color.WHITE);
		btnHuy.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnHuy.setBounds(660, 423, 122, 31);
		contentPane.add(btnHuy);

		btnXN = new JButton("Xác nhận");
		btnXN.setForeground(Color.WHITE);
		btnXN.setBackground(Color.GREEN);
		btnXN.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXN.setBounds(819, 423, 122, 31);
		contentPane.add(btnXN);

		JLabel lblNewLabel_1 = new JLabel("Cập nhật thông tin sản phẩm");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(295, 23, 548, 43);
		contentPane.add(lblNewLabel_1);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(37, 122, 952, 253);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblMNhCung = new JLabel("Mã nhà cung cấp:");
		lblMNhCung.setBounds(610, 79, 152, 25);
		panel.add(lblMNhCung);
		lblMNhCung.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMNhCung.setFont(new Font("Tahoma", Font.BOLD, 14));

		textMNCC = new JTextField();
		textMNCC.setBounds(763, 79, 152, 25);
		panel.add(textMNCC);
		textMNCC.setEditable(false);
		textMNCC.setHorizontalAlignment(SwingConstants.CENTER);
		textMNCC.setFont(new Font("Tahoma", Font.BOLD, 14));
		textMNCC.setColumns(10);

		textTNCC = new JTextField();
		textTNCC.setBounds(763, 114, 152, 25);
		panel.add(textTNCC);
		textTNCC.setEditable(false);
		textTNCC.setHorizontalAlignment(SwingConstants.CENTER);
		textTNCC.setFont(new Font("Tahoma", Font.BOLD, 14));
		textTNCC.setColumns(10);

		JLabel lblTnNhCung = new JLabel("Tên nhà cung cấp:");
		lblTnNhCung.setBounds(610, 114, 152, 25);
		panel.add(lblTnNhCung);
		lblTnNhCung.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTnNhCung.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblLoi_1 = new JLabel("Hãng:");
		lblLoi_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLoi_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLoi_1.setBounds(642, 44, 111, 25);
		panel.add(lblLoi_1);

		textHang = new JTextField();
		textHang.setHorizontalAlignment(SwingConstants.CENTER);
		textHang.setFont(new Font("Tahoma", Font.BOLD, 14));
		textHang.setColumns(10);
		textHang.setBounds(763, 44, 152, 25);
		panel.add(textHang);

		// lấy thông tin sp
		ArrayList<SanPham> spMa = new ArrayList<SanPham>();
		spMa = sp_Dao.timMSP(ma);
		for (SanPham sanPham : spMa) {
			textMSP.setText(sanPham.getMaSanPham());
			textTSP.setText(sanPham.getTenSanPham());
			textMau.setText(sanPham.getMau());
			textSize.setText(sanPham.getSize());
			textLoai.setText(sanPham.getLoai());
			textLH.setText(sanPham.getLoHang());
			textHang.setText(sanPham.getHang());
			String sLT = String.valueOf(sanPham.getSoLuongTon());
			textSLT.setText(sLT);
			String ngay = sanPham.getNgayNhap().toString();
			textNgay.setText(ngay);
			String dGN = String.valueOf(sanPham.getGiaNhap());
			textGiaN.setText(dGN);
			String dgB = String.valueOf(sanPham.getGiaBan());
			textGiaB.setText(dgB);
			textMNCC.setText(sanPham.getMaNCC().getMaNhaCungCap());
			textTNCC.setText(sanPham.getTenNCC().getMaNhaCungCap());
		}

		// dang ky su kien
		btnHuy.addActionListener(this);
		btnXN.addActionListener(this);
		this.addWindowFocusListener(this);
		this.addWindowListener(this);

	}

	// update sp
	public void update() {
		String ma = textMSP.getText();
		String ten = textTSP.getText();
		String mau = textMau.getText();
		String loai = textLoai.getText();
		int sl = Integer.parseInt(textSLT.getText());
		String size = textSize.getText();
		String hang = textHang.getText();
		String loHang = textLH.getText();
		LocalDate ngay = LocalDate.parse(textNgay.getText());
		double a = Double.valueOf(textGiaN.getText());
		BigDecimal giaN = BigDecimal.valueOf(a);
		double b = Double.valueOf(textGiaB.getText());
		BigDecimal giaB = BigDecimal.valueOf(b);
		NhaCungCap maNCC = new NhaCungCap(textMNCC.getText());
		NhaCungCap tenNCC = new NhaCungCap(textTNCC.getText());
		SanPham sp = new SanPham(ma, ten, mau, loai, sl, size, hang, loHang, ngay, giaN, giaB, maNCC, tenNCC);
		sp_Dao.update(sp);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		// event hủy update
		if (obj.equals(btnHuy)) {
			int confirm = JOptionPane.showConfirmDialog(this, "Hủy cập nhật ?", "Thông báo", JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				dispose();
			}
		}

		// event xac nhan update
		else if (obj.equals(btnXN)) {
			int confirm = JOptionPane.showConfirmDialog(this, "Xác nhận thay đổi ?", "Thông báo",
					JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				update();
				dispose();
			}
		}

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
}
