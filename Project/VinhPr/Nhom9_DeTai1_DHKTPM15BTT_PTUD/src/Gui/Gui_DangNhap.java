package Gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import ConnectDB.ConnectDB;
import Dao.NhanVien_DAO;
import Dao.TaiKhoan_DAO;
import Entity.NhanVien;
import Entity.TaiKhoan;

public class Gui_DangNhap extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_tenDangNhap;
	private JPasswordField txt_passWord;
	private JButton btnDangNhap;
	private TaiKhoan_DAO tk_Dao;
	private NhanVien_DAO nv_Dao = new NhanVien_DAO();
	private JButton btnExit;
	private static String maTX;

	public static String getMaTX() {
		return maTX;
	}

	public static void setMaTX(String maTX) {
		Gui_DangNhap.maTX = maTX;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_DangNhap frame = new Gui_DangNhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gui_DangNhap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(270, 70, 1108, 660);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// connect database
		tk_Dao = new TaiKhoan_DAO();
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JLabel lblNewLabel_2 = new JLabel("VTTM ");
		lblNewLabel_2.setForeground(new Color(0, 191, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Freestyle Script", Font.BOLD | Font.ITALIC, 90));
		lblNewLabel_2.setBounds(349, 40, 469, 108);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Store Management ");
		lblNewLabel_3.setForeground(new Color(0, 191, 255));
		lblNewLabel_3.setFont(new Font("Freestyle Script", Font.BOLD | Font.ITALIC, 80));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(310, 130, 508, 138);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel = new JLabel("Tên đăng nhập:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(261, 278, 123, 34);
		contentPane.add(lblNewLabel);

		txt_tenDangNhap = new JTextField();
		txt_tenDangNhap.setHorizontalAlignment(SwingConstants.CENTER);
		txt_tenDangNhap.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_tenDangNhap.setBounds(394, 281, 320, 34);
		contentPane.add(txt_tenDangNhap);
		txt_tenDangNhap.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Mật  khẩu:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(269, 339, 115, 35);
		contentPane.add(lblNewLabel_1);

		txt_passWord = new JPasswordField();
		txt_passWord.setHorizontalAlignment(SwingConstants.CENTER);
		txt_passWord.setBounds(394, 342, 320, 34);
		contentPane.add(txt_passWord);

		btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setBackground(new Color(192, 192, 192));
		btnDangNhap.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDangNhap.setBounds(489, 398, 177, 54);
		contentPane.add(btnDangNhap);

		btnExit = new JButton("Thoát");
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBounds(867, 523, 177, 54);
		contentPane.add(btnExit);

		// Đăng ký sự kiện
		btnDangNhap.addActionListener(this);
		btnExit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnDangNhap)) {
			String id = txt_tenDangNhap.getText();
			String pass = new String(txt_passWord.getPassword());
			String id2 = null;
			String pass2 = null;
			ArrayList<NhanVien> nv = new ArrayList<NhanVien>();
			ArrayList<TaiKhoan> tk = new ArrayList<TaiKhoan>();
			nv = nv_Dao.getMNV(id);
			for (NhanVien nhanVien : nv) {
				String ma = nhanVien.getMaNhanVien();
				String tt = nhanVien.getTt();
				if (tt.equals("1")) {
					tk = tk_Dao.getID(ma);
					for (TaiKhoan taiKhoan : tk) {
						id2 = taiKhoan.getTaiKhoan();
						pass2 = taiKhoan.getPass();
					}
					if (tk.isEmpty()) {
						JOptionPane.showMessageDialog(this, "Tài khoản sai hoặc không tồn tại !!");
					} else {
						if (id2.equals(ma) && pass2.equals(pass)) {
							if (id2.codePointBefore(4) == 72) {
								setMaTX(id2);
								new Gui_NhanVien().setVisible(true);
								dispose();
							} else {
								new Gui_QuanLy().setVisible(true);
								dispose();
							}

						} else {
							JOptionPane.showMessageDialog(this, "Thông tin mật khẩu không chính xác!!");
						}
					}

				} else {
					JOptionPane.showMessageDialog(this, "Tài khoản sai hoặc không tồn tại !!");
				}
			}

		} else if (obj.equals(btnExit)) {
			int confirm = JOptionPane.showConfirmDialog(this, "Ban co muon ket thuc?", "Thông báo",
					JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
	}
}
