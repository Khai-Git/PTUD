package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import ConnectDB.ConnectDB;
import DAO.DAO_NhanVien;

import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;

public class GUI_DangNhap extends JFrame implements ActionListener{

	private JPanel contentPane;
	public static JTextField txtNhapTaiKhoan;
	private JPasswordField txtNhapMatKhau;
	private JLabel lblMatKhau, lblBG;
	private JButton btnDangNhap, btnReset, btnThoat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_DangNhap frame = new GUI_DangNhap();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public GUI_DangNhap() throws IOException {
		ConnectDB.getInstance().connect();
		
		setTitle("Đăng Nhập");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 650);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTaiKhoan = new JLabel("Tài khoản:");
		lblTaiKhoan.setBounds(258, 431, 412, 25);
		contentPane.add(lblTaiKhoan);
		
		txtNhapTaiKhoan = new JTextField();
		txtNhapTaiKhoan.setColumns(10);
		txtNhapTaiKhoan.setBounds(255, 466, 415, 23);
		contentPane.add(txtNhapTaiKhoan);
		
		txtNhapMatKhau = new JPasswordField();
		txtNhapMatKhau.setColumns(10);
		txtNhapMatKhau.setBounds(255, 527, 415, 23);
		contentPane.add(txtNhapMatKhau);
		
		lblMatKhau = new JLabel("Mật khẩu:");
		lblMatKhau.setBounds(258, 492, 412, 25);
		contentPane.add(lblMatKhau);

		btnDangNhap = new JButton("Đăng Nhập");
		btnDangNhap.setBackground(new Color(0, 215, 0));
		btnDangNhap.setBounds(464, 579, 117, 21);
		contentPane.add(btnDangNhap);
		
		btnReset = new JButton("Xóa Trắng");
		btnReset.setBounds(348, 579, 106, 21);
		contentPane.add(btnReset);
		
		lblBG = new JLabel("");
		lblBG.setIcon(new ImageIcon(GUI_DangNhap.class.getResource("/img/BG_Karaoke.png")));
		lblBG.setBounds(61, 53, 803, 322);
		contentPane.add(lblBG); 
		
		btnThoat = new JButton("Thoát");
		btnThoat.setBackground(new Color(255, 69, 64));
		btnThoat.setBounds(807, 578, 117, 21);
		contentPane.add(btnThoat);
		
		btnDangNhap.addActionListener(this);
		btnReset.addActionListener(this);
		btnThoat.addActionListener(this);

		Login_Account();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnDangNhap)) {
			dangNhapAction();
		}
		if (o.equals(btnReset)) {
			xoaTrangAction();
		}
		if (o.equals(btnThoat)) {
			int hoiNhac = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát chương trình ?", "Thông báo",JOptionPane.YES_NO_OPTION);
			if(hoiNhac == JOptionPane.YES_OPTION) {
				ConnectDB.getInstance().disconnect();
				System.exit(0);
			}
		}
	}
	
	private void xoaTrangAction() {
		// TODO Auto-generated method stub
		txtNhapMatKhau.setText("");
		txtNhapTaiKhoan.setText("");
		
		txtNhapTaiKhoan.requestFocus();
	}

	@SuppressWarnings("deprecation")
	private void dangNhapAction() {
		// TODO Auto-generated method stub
		
		String taiKhoanNhap = txtNhapTaiKhoan.getText();
		String matKhauNhap = txtNhapMatKhau.getText();
		
		if(txtNhapTaiKhoan.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập tài khoản!");
		} else if(txtNhapMatKhau.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập mật khẩu!");
		} else {
			try {
				Connection con= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=KARAOKE_Nice","sa","sapassword");
				String sql = " select * \r\n" 
							+ " from TaiKhoan tk \r\n"
							+ " where tk.taiKhoan like N'" + taiKhoanNhap + "'"
							+ " and tk.matKhau like N'" + matKhauNhap + "'";
				
				Statement stmt = con.createStatement();
				ResultSet rs=stmt.executeQuery(sql);
				
				if(rs.next()) {
					DangNhap_to_ManHinhChinh();
				} else {
					JOptionPane.showMessageDialog(this, "Đăng nhập thất bại! Vui lòng nhập lại tài khoản mật khẩu");
					return ;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	private void Login_Account() {
		// TODO Auto-generated method stub
		//Lễ tân
//		txtNhapTaiKhoan.setText("letanthienkhai");
//		txtNhapMatKhau.setText("letanlontuoi");
		
		//Quản lí
		txtNhapTaiKhoan.setText("quanlihuunha");
		txtNhapMatKhau.setText("quanlideptrai");
	}
	private void DangNhap_to_ManHinhChinh() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI_ManHinhChinh manhinhcinh = new GUI_ManHinhChinh();
		manhinhcinh.setVisible(true);
		manhinhcinh.setLocationRelativeTo(null);
	}
}
