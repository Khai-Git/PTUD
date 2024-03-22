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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import ConnectDB.ConnectDB;
import Dao.NhanVien_DAO;
import Entity.NhanVien;

import javax.swing.border.LineBorder;
import javax.swing.JComboBox;

public class Gui_CuaSoUpDateNV extends JFrame implements ActionListener, WindowFocusListener, WindowListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private NhanVien_DAO nv_Dao = new NhanVien_DAO();
	private JTextField textMNV;
	private JTextField textTNV;
	private JRadioButton rdbtnNu;
	private JRadioButton rdbtnNam;
	private JTextField textSDT;
	private JTextField textNS;
	private JTextField textNVL;
	private JTextField textCMND;
	private JTextField textDC;
	private JButton btnHuy;
	private JButton btnXN;
	private JComboBox<String> comboBoxTT;


	/**
	 * Create the frame.
	 */
	public Gui_CuaSoUpDateNV(String maNV) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(270, 70, 1024, 544);
		setResizable(false);
		this.requestFocusInWindow(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// connect data
		// nv_Dao = new NhanVien_DAO();
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JLabel lblNewLabel = new JLabel("Mã nhân viên:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(131, 143, 109, 25);
		contentPane.add(lblNewLabel);

		JLabel lblMTnVin = new JLabel("Tên nhân viên:");
		lblMTnVin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMTnVin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMTnVin.setBounds(131, 178, 109, 25);
		contentPane.add(lblMTnVin);

		JLabel lblGiiTnh = new JLabel("Giới tính:");
		lblGiiTnh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGiiTnh.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGiiTnh.setBounds(131, 213, 109, 25);
		contentPane.add(lblGiiTnh);
		ButtonGroup gender = new ButtonGroup();

		JLabel lblSinThoi = new JLabel("Số điện thoại:");
		lblSinThoi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSinThoi.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSinThoi.setBounds(131, 248, 109, 25);
		contentPane.add(lblSinThoi);

		JLabel lblNgySinh = new JLabel("Ngày sinh:");
		lblNgySinh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNgySinh.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNgySinh.setBounds(578, 147, 109, 25);
		contentPane.add(lblNgySinh);

		textNS = new JTextField();
		textNS.setHorizontalAlignment(SwingConstants.CENTER);
		textNS.setFont(new Font("Tahoma", Font.BOLD, 13));
		textNS.setColumns(10);
		textNS.setBounds(697, 147, 177, 25);
		contentPane.add(textNS);

		JLabel lblNgyVoLm = new JLabel("Ngày vào làm:");
		lblNgyVoLm.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNgyVoLm.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNgyVoLm.setBounds(578, 182, 109, 25);
		contentPane.add(lblNgyVoLm);

		textNVL = new JTextField();
		textNVL.setHorizontalAlignment(SwingConstants.CENTER);
		textNVL.setFont(new Font("Tahoma", Font.BOLD, 13));
		textNVL.setColumns(10);
		textNVL.setBounds(697, 182, 177, 25);
		contentPane.add(textNVL);

		JLabel lblS = new JLabel("Số CMND:");
		lblS.setHorizontalAlignment(SwingConstants.RIGHT);
		lblS.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblS.setBounds(578, 217, 109, 25);
		contentPane.add(lblS);

		textCMND = new JTextField();
		textCMND.setHorizontalAlignment(SwingConstants.CENTER);
		textCMND.setFont(new Font("Tahoma", Font.BOLD, 13));
		textCMND.setColumns(10);
		textCMND.setBounds(697, 217, 177, 25);
		contentPane.add(textCMND);

		JLabel lblaCh = new JLabel("Địa chỉ:");
		lblaCh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblaCh.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblaCh.setBounds(578, 252, 109, 25);
		contentPane.add(lblaCh);

		textDC = new JTextField();
		textDC.setHorizontalAlignment(SwingConstants.CENTER);
		textDC.setFont(new Font("Tahoma", Font.BOLD, 13));
		textDC.setColumns(10);
		textDC.setBounds(697, 252, 177, 25);
		contentPane.add(textDC);

		btnHuy = new JButton("Hủy");
		btnHuy.setForeground(Color.WHITE);
		btnHuy.setBackground(Color.RED);
		btnHuy.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnHuy.setBounds(606, 419, 102, 35);
		contentPane.add(btnHuy);

		btnXN = new JButton("Xác nhận");
		btnXN.setForeground(Color.WHITE);
		btnXN.setBackground(Color.GREEN);
		btnXN.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXN.setBounds(752, 419, 102, 35);
		contentPane.add(btnXN);

		JLabel lblNewLabel_1 = new JLabel("Cập nhật thông tin nhân viên");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(298, 30, 449, 53);
		contentPane.add(lblNewLabel_1);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(86, 111, 873, 215);
		contentPane.add(panel);
		panel.setLayout(null);

		textSDT = new JTextField();
		textSDT.setBounds(167, 138, 159, 25);
		panel.add(textSDT);
		textSDT.setHorizontalAlignment(SwingConstants.CENTER);
		textSDT.setFont(new Font("Tahoma", Font.BOLD, 13));
		textSDT.setColumns(10);

		JLabel lblTnhTrng = new JLabel("Trạng thái:");
		lblTnhTrng.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTnhTrng.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTnhTrng.setBounds(43, 180, 109, 25);
		panel.add(lblTnhTrng);

		comboBoxTT = new JComboBox<String>();
		comboBoxTT.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxTT.setModel(new DefaultComboBoxModel<String>(new String[] { "Đang làm việc", "Đã nghỉ việc" }));
		comboBoxTT.setBounds(167, 181, 159, 25);
		panel.add(comboBoxTT);

		textTNV = new JTextField();
		textTNV.setBounds(167, 71, 159, 25);
		panel.add(textTNV);
		textTNV.setHorizontalAlignment(SwingConstants.CENTER);
		textTNV.setFont(new Font("Tahoma", Font.BOLD, 13));
		textTNV.setColumns(10);

		textMNV = new JTextField();
		textMNV.setBounds(167, 32, 159, 25);
		panel.add(textMNV);
		textMNV.setEditable(false);
		textMNV.setFont(new Font("Tahoma", Font.BOLD, 13));
		textMNV.setHorizontalAlignment(SwingConstants.CENTER);
		textMNV.setColumns(10);

		rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setBounds(176, 110, 55, 22);
		panel.add(rdbtnNu);
		rdbtnNu.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnNu.setSelected(true);
		gender.add(rdbtnNu);

		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setBounds(254, 110, 55, 22);
		panel.add(rdbtnNam);
		rdbtnNam.setFont(new Font("Tahoma", Font.BOLD, 13));
		gender.add(rdbtnNam);

		// Lấy thông tin nv
		ArrayList<NhanVien> nv = new ArrayList<NhanVien>();
		nv = nv_Dao.getMNV(maNV);
		for (NhanVien nhanVien : nv) {
			textMNV.setText(maNV);
			textTNV.setText(nhanVien.getTenNhanVien());
			textCMND.setText(nhanVien.getSoCMND());
			textDC.setText(nhanVien.getDiaChi());
			textSDT.setText(nhanVien.getSoDienThoai());
			String ngayS = String.valueOf(nhanVien.getNgaySinh());
			textNS.setText(ngayS);
			String ngayVL = String.valueOf(nhanVien.getNgayVaoLam());
			textNVL.setText(ngayVL);
			String gt = nhanVien.getGioiTinh();
			if (gt.equals("Nam")) {
				rdbtnNam.setSelected(true);
			}
			String tt = nhanVien.getTt();
			if (tt.equals("0")) {
				comboBoxTT.setSelectedItem("Đã nghỉ việc");
			} else {
				comboBoxTT.setSelectedItem("Đang làm việc");
			}
		}

		// Đăng ký sk
		btnHuy.addActionListener(this);
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

	//
	public void updateNV() {
		String maNV = textMNV.getText();
		String tenNV = textTNV.getText();
		String dc = textDC.getText();
		String gt;
		if (rdbtnNu.isSelected()) {
			gt = "Nu";
		} else {
			gt = "Nam";
		}
		String sdt = textSDT.getText();
		String tt = comboBoxTT.getSelectedItem().toString();
		String tt2;
		if (tt.equals("Đang làm việc")) {
			tt2 = "1";
		} else {
			tt2 = "0";
		}
		String cmnd = textCMND.getText();
		LocalDate a = LocalDate.parse(textNS.getText());
		LocalDate b = LocalDate.parse(textNVL.getText());

		NhanVien nv = new NhanVien(maNV, tenNV, a, b, gt, cmnd, dc, sdt, tt2);
		nv_Dao.updateNV(nv);

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

		// event xác nhận update
		else if (obj.equals(btnXN)) {
			int confirm = JOptionPane.showConfirmDialog(this, "Xác nhận cập nhật thông tin ?", "Thông báo",
					JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				updateNV();
				JOptionPane.showMessageDialog(this, "Thành công!!");
				dispose();
			}
		}
	}
}
