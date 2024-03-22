package Gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConnectDB.ConnectDB;
import Dao.NhanVien_DAO;
import Dao.TaiKhoan_DAO;
import Entity.NhanVien;
import Entity.TaiKhoan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import javax.swing.border.LineBorder;

public class Gui_CuaSoAddNV extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textMNV;
	private JTextField textTNV;
	private JTextField textSDT;
	private JTextField textNS;
	private JTextField textNVL;
	private JTextField textCMND;
	private JTextField textDC;
	private JButton btnHuy;
	private JButton btnXN;
	private NhanVien_DAO nv_Dao = new NhanVien_DAO();
	private TaiKhoan_DAO tk_Dao = new TaiKhoan_DAO();
	private JRadioButton rdbtnNam;
	private JRadioButton rdbtnNu;
	private JComboBox<String> comboBoxTT;


	/**
	 * Create the frame.
	 */
	public Gui_CuaSoAddNV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(290, 100, 1020, 600);
		setResizable(false);
		this.requestFocusInWindow(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// connect data
		nv_Dao = new NhanVien_DAO();
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

		JLabel lblGiiTnh = new JLabel("Giới tính:");
		lblGiiTnh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGiiTnh.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGiiTnh.setBounds(131, 213, 109, 25);
		contentPane.add(lblGiiTnh);

		rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnNu.setSelected(true);
		rdbtnNu.setBounds(250, 216, 55, 22);
		contentPane.add(rdbtnNu);

		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnNam.setBounds(328, 216, 55, 22);
		contentPane.add(rdbtnNam);
		ButtonGroup gender = new ButtonGroup();
		gender.add(rdbtnNu);
		gender.add(rdbtnNam);

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

		JLabel lblNewLabel_1 = new JLabel("Thêm nhân viên mới");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(298, 30, 449, 53);
		contentPane.add(lblNewLabel_1);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(68, 92, 892, 275);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblTnhTrng = new JLabel("Trạng thái:");
		lblTnhTrng.setBounds(65, 211, 109, 25);
		panel.add(lblTnhTrng);
		lblTnhTrng.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTnhTrng.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel lblMTnVin = new JLabel("Tên nhân viên:");
		lblMTnVin.setBounds(65, 88, 109, 25);
		panel.add(lblMTnVin);
		lblMTnVin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMTnVin.setFont(new Font("Tahoma", Font.BOLD, 13));

		comboBoxTT = new JComboBox<String>();
		comboBoxTT.setBounds(184, 210, 159, 25);
		panel.add(comboBoxTT);
		comboBoxTT.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxTT.setModel(new DefaultComboBoxModel<String>(new String[] { "Đang làm việc", "Đã nghỉ việc" }));

		textTNV = new JTextField();
		textTNV.setBounds(184, 88, 159, 25);
		panel.add(textTNV);
		textTNV.setHorizontalAlignment(SwingConstants.CENTER);
		textTNV.setFont(new Font("Tahoma", Font.BOLD, 13));
		textTNV.setColumns(10);

		textSDT = new JTextField();
		textSDT.setBounds(184, 160, 159, 25);
		panel.add(textSDT);
		textSDT.setHorizontalAlignment(SwingConstants.CENTER);
		textSDT.setFont(new Font("Tahoma", Font.BOLD, 13));
		textSDT.setColumns(10);

		textMNV = new JTextField();
		textMNV.setEditable(false);
		textMNV.setBounds(184, 53, 159, 25);
		panel.add(textMNV);
		textMNV.setFont(new Font("Tahoma", Font.BOLD, 13));
		textMNV.setHorizontalAlignment(SwingConstants.CENTER);
		textMNV.setColumns(10);

		createMNV();

		// Đăng ký sự kiện
		btnHuy.addActionListener(this);
		btnXN.addActionListener(this);
	}

	// Tạo mã nhân viên auto
	public String createMNV() {
		String maNV1 = null;
		ArrayList<NhanVien> dsNV = nv_Dao.getDSNV();
		if (dsNV.size() >= 0) {
			int ma = nv_Dao.maNV() + 1;
			if (ma < 10) {
				maNV1 = "NVBH00" + ma;
			} else if (ma >= 10 && ma <= 99) {
				maNV1 = "NVBH0" + ma;
			} else {
				maNV1 = "NVBH" + ma;
			}
		}
		textMNV.setText(maNV1);
		return maNV1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		// event hủy
		if (obj.equals(btnHuy)) {
			int confirm = JOptionPane.showConfirmDialog(this, "Ban co muon ket thuc?", "Thông báo",
					JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				new Gui_QLNhanVien().setVisible(true);
				dispose();
			}
		}
		// event xác nhận
		else if (obj.equals(btnXN)) {
			int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm nhân viên này?", "Thông báo",
					JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				String maNV = textMNV.getText();
				String ten = textTNV.getText();
				String sdt = textSDT.getText();
				String gt;
				if (rdbtnNam.isSelected()) {
					gt = "Nam";
				} else {
					gt = "Nữ";
				}
				String ngayS1 = textNS.getText();
				String ngayVL1 = textNVL.getText();
				String dc = textDC.getText();
				String cmnd = textCMND.getText();
				String tt = comboBoxTT.getSelectedItem().toString();
				NhanVien nv1 = new NhanVien(maNV);
				String id = maNV;
				String pass = maNV;
				if (maNV.equals("") || ten.equals("") || sdt.equals("") || ngayS1.equals("") || ngayVL1.equals("")
						|| dc.equals("") || cmnd.equals("")) {
					JOptionPane.showMessageDialog(this, "Thông tin không được để trống !!");
				} else {
					LocalDate ngayS = LocalDate.parse(ngayS1);
					LocalDate ngayVL = LocalDate.parse(ngayVL1);
					TaiKhoan tk = new TaiKhoan(nv1, id, pass);
					tk_Dao.create(tk);
					NhanVien nv = new NhanVien(maNV, ten, ngayS, ngayVL, gt, cmnd, dc, sdt, tt);
					nv_Dao.create(nv);
				}
				dispose();
				new Gui_QLNhanVien().setVisible(true);
			}
		}

	}
}
