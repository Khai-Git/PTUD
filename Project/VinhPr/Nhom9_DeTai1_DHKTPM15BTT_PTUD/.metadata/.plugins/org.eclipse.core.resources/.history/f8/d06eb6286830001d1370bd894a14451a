package Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import ConnectDB.ConnectDB;
import Dao.NhaCungCap_DAO;
import Entity.NhaCungCap;

import java.awt.Color;
import javax.swing.JButton;

public class Gui_CuaSoUpDateNCC extends JFrame implements ActionListener, WindowFocusListener, WindowListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textMNCC;
	private JTextField textTNCC;
	private JTextField textEmail;
	private JTextField textSDT;
	private JTextField textDC;
	private JLabel lblNewLabel_1;
	private JPanel panel;
	private JButton btnHuy;
	private JButton btnXN;
	private NhaCungCap_DAO ncc_Dao;


	/**
	 * Create the frame.
	 */
	public Gui_CuaSoUpDateNCC(String ma) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(270, 70, 1024, 544);
		setResizable(false);
		this.requestFocusInWindow(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// connect data
		ncc_Dao = new NhaCungCap_DAO();
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JLabel lblNewLabel = new JLabel("Mã nhà cung cấp:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(179, 151, 129, 25);
		contentPane.add(lblNewLabel);

		textMNCC = new JTextField();
		textMNCC.setEditable(false);
		textMNCC.setHorizontalAlignment(SwingConstants.CENTER);
		textMNCC.setFont(new Font("Tahoma", Font.BOLD, 14));
		textMNCC.setBounds(318, 153, 168, 25);
		contentPane.add(textMNCC);
		textMNCC.setColumns(10);

		JLabel lblTnNhCung = new JLabel("Tên nhà cung cấp:");
		lblTnNhCung.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTnNhCung.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTnNhCung.setBounds(162, 186, 146, 25);
		contentPane.add(lblTnNhCung);

		textTNCC = new JTextField();
		textTNCC.setHorizontalAlignment(SwingConstants.CENTER);
		textTNCC.setFont(new Font("Tahoma", Font.BOLD, 14));
		textTNCC.setColumns(10);
		textTNCC.setBounds(318, 188, 168, 25);
		contentPane.add(textTNCC);

		textEmail = new JTextField();
		textEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		textEmail.setHorizontalAlignment(SwingConstants.CENTER);
		textEmail.setColumns(10);
		textEmail.setBounds(680, 153, 168, 25);
		contentPane.add(textEmail);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(541, 151, 129, 25);
		contentPane.add(lblEmail);

		JLabel lblaCh = new JLabel("Địa chỉ:");
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
		textDC.setHorizontalAlignment(SwingConstants.CENTER);
		textDC.setFont(new Font("Tahoma", Font.BOLD, 14));
		textDC.setColumns(10);
		textDC.setBounds(680, 188, 168, 25);
		contentPane.add(textDC);

		lblNewLabel_1 = new JLabel("Cập nhật thông tin nhà cung cấp");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(293, 35, 513, 42);
		contentPane.add(lblNewLabel_1);

		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(92, 117, 848, 173);
		contentPane.add(panel);

		btnHuy = new JButton("Hủy");
		btnHuy.setBackground(Color.RED);
		btnHuy.setForeground(Color.WHITE);
		btnHuy.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnHuy.setBounds(617, 351, 103, 35);
		contentPane.add(btnHuy);

		btnXN = new JButton("Xác nhận");
		btnXN.setBackground(Color.GREEN);
		btnXN.setForeground(Color.WHITE);
		btnXN.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXN.setBounds(762, 351, 114, 35);
		contentPane.add(btnXN);

		// lay thong tin ncc
		ArrayList<NhaCungCap> ncc = new ArrayList<NhaCungCap>();
		ncc = ncc_Dao.timMNCC(ma);
		for (NhaCungCap nhaCungCap : ncc) {
			textMNCC.setText(nhaCungCap.getMaNhaCungCap());
			textTNCC.setText(nhaCungCap.getTenNhaCungCap());
			textEmail.setText(nhaCungCap.getEmail());
			textSDT.setText(nhaCungCap.getSoDienThoai());
			textDC.setText(nhaCungCap.getDiaChi());
		}

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
				updateNCC();
				dispose();
			}
		}
	}

	// update nhà cung cấp
	public void updateNCC() {
		String tenNCC = textTNCC.getText();
		String dc = textDC.getText();
		String sdt = textSDT.getText();
		String email = textEmail.getText();
		String ma = textMNCC.getText();
		NhaCungCap ncc = new NhaCungCap(ma, tenNCC, dc, sdt, email);
		ncc_Dao.update(ncc);
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
