package Gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import ConnectDB.ConnectDB;
import Dao.KhachHang_DAO;
import Entity.KhachHang;

import javax.swing.JRadioButton;

public class Gui_CuaSoAddKH extends JFrame implements ActionListener, WindowFocusListener, WindowListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnHuy;
	private JButton btnXN;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JTextField textDC;
	private JTextField textSDT;
	private JTextField textTKH;
	private JTextField textNS;
	private JTextField textMKH;
	private JLabel lblGiiTnh;
	private KhachHang_DAO kh_Dao;
	private JRadioButton rdbtnNam;
	private JRadioButton rdbtnNu;


	/**
	 * Create the frame.
	 */
	public Gui_CuaSoAddKH() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(270, 70, 1024, 544);
		setResizable(false);
		this.requestFocusInWindow(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//
		kh_Dao = new KhachHang_DAO();
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JLabel lblNewLabel = new JLabel("Mã khách hàng:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(162, 151, 146, 25);
		contentPane.add(lblNewLabel);

		textMKH = new JTextField();
		textMKH.setEditable(false);
		textMKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		textMKH.setHorizontalAlignment(SwingConstants.CENTER);
		textMKH.setBounds(318, 153, 168, 25);
		contentPane.add(textMKH);
		textMKH.setColumns(10);

		JLabel lblTnNhCung = new JLabel("Tên khách hàng:");
		lblTnNhCung.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTnNhCung.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTnNhCung.setBounds(162, 186, 146, 25);
		contentPane.add(lblTnNhCung);

		textTKH = new JTextField();
		textTKH.setHorizontalAlignment(SwingConstants.CENTER);
		textTKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		textTKH.setColumns(10);
		textTKH.setBounds(318, 188, 168, 25);
		contentPane.add(textTKH);

		textNS = new JTextField();
		textNS.setHorizontalAlignment(SwingConstants.CENTER);
		textNS.setFont(new Font("Tahoma", Font.BOLD, 14));
		textNS.setColumns(10);
		textNS.setBounds(680, 153, 168, 25);
		contentPane.add(textNS);

		JLabel lblEmail = new JLabel("Ngày sinh:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(541, 151, 129, 25);
		contentPane.add(lblEmail);

		JLabel lblaCh = new JLabel("�?ịa chỉ:");
		lblaCh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblaCh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblaCh.setBounds(541, 186, 129, 25);
		contentPane.add(lblaCh);

		JLabel lblSinThoi = new JLabel("Số điện thoại:");
		lblSinThoi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSinThoi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSinThoi.setBounds(162, 221, 146, 25);
		contentPane.add(lblSinThoi);

		textSDT = new JTextField();
		textSDT.setHorizontalAlignment(SwingConstants.CENTER);
		textSDT.setFont(new Font("Tahoma", Font.BOLD, 14));
		textSDT.setColumns(10);
		textSDT.setBounds(318, 226, 168, 25);
		contentPane.add(textSDT);

		textDC = new JTextField();
		textDC.setFont(new Font("Tahoma", Font.BOLD, 14));
		textDC.setHorizontalAlignment(SwingConstants.CENTER);
		textDC.setColumns(10);
		textDC.setBounds(680, 188, 168, 25);
		contentPane.add(textDC);

		lblNewLabel_1 = new JLabel("Thêm khách hàng mới");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(293, 35, 513, 42);
		contentPane.add(lblNewLabel_1);

		btnHuy = new JButton("Hủy");
		btnHuy.setBackground(Color.RED);
		btnHuy.setForeground(Color.WHITE);
		btnHuy.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnHuy.setBounds(605, 351, 115, 35);
		contentPane.add(btnHuy);

		btnXN = new JButton("Xác nhận");
		btnXN.setBackground(Color.GREEN);
		btnXN.setForeground(Color.WHITE);
		btnXN.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXN.setBounds(762, 351, 115, 35);
		contentPane.add(btnXN);

		lblGiiTnh = new JLabel("Giới tính:");
		lblGiiTnh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGiiTnh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGiiTnh.setBounds(541, 221, 129, 25);
		contentPane.add(lblGiiTnh);

		rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setSelected(true);
		rdbtnNu.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnNu.setBounds(680, 221, 60, 25);
		contentPane.add(rdbtnNu);

		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnNam.setBounds(742, 221, 76, 27);
		contentPane.add(rdbtnNam);
		ButtonGroup gender = new ButtonGroup();
		gender.add(rdbtnNu);
		gender.add(rdbtnNam);

		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(92, 117, 848, 173);
		contentPane.add(panel);

		//
		createMHD();

		// dang ky su kien
		btnHuy.addActionListener(this);
		btnXN.addActionListener(this);
		this.addWindowFocusListener(this);
		this.addWindowListener(this);
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
				kh_Dao.create(crateKH());
				new Gui_QLKhachHang().setVisible(true);
				dispose();
			}
		}

	}

	// Hàm lấy giới tính kh
	public String gt() {
		String gt;
		if (rdbtnNu.getSelectedIcon() != null) {
			gt = "Nam";
		} else {
			gt = "Nu";
		}
		return gt;
	}

	// Hàm tạo mã hóa đơn bán hàng auto
	public void createMHD() {
		String maHD = null;
		ArrayList<KhachHang> dsHD = kh_Dao.getDSKH();
		if (dsHD.size() > 0) {
			int ma = kh_Dao.makh() + 1;
			if (ma < 10) {
				maHD = "KH00" + ma;
			} else if (ma >= 10 && ma <= 99) {
				maHD = "KH0" + ma;
			} else {
				maHD = "KH" + ma;
			}
		}
		textMKH.setText(maHD);
	}

	public KhachHang crateKH() {
		String maKH = textMKH.getText();
		String tenKH = textTKH.getText();
		String sdt = textSDT.getText();
		String dc = textDC.getText();
		String gt = gt();
		String ngay = textNS.getText();
		LocalDate ngayS = LocalDate.parse(ngay);
		KhachHang kh = new KhachHang(maKH, tenKH, sdt, dc, gt, ngayS);
		return kh;

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
