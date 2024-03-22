package Gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.ArrayList;

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
import Dao.NhaCungCap_DAO;
import Entity.NhaCungCap;

public class Gui_CuaSoAddNCC extends JFrame implements ActionListener, WindowFocusListener, WindowListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textMNCC;
	private JTextField textTNCC;
	private JTextField textE;
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
	public Gui_CuaSoAddNCC() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(270, 70, 1024, 544);
		setResizable(false);
		this.requestFocusInWindow(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//
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
		textTNCC.setFont(new Font("Tahoma", Font.BOLD, 14));
		textTNCC.setHorizontalAlignment(SwingConstants.CENTER);
		textTNCC.setColumns(10);
		textTNCC.setBounds(318, 188, 168, 25);
		contentPane.add(textTNCC);

		textE = new JTextField();
		textE.setHorizontalAlignment(SwingConstants.CENTER);
		textE.setFont(new Font("Tahoma", Font.BOLD, 14));
		textE.setColumns(10);
		textE.setBounds(680, 153, 168, 25);
		contentPane.add(textE);

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
		textSDT.setFont(new Font("Tahoma", Font.BOLD, 14));
		textSDT.setHorizontalAlignment(SwingConstants.CENTER);
		textSDT.setColumns(10);
		textSDT.setBounds(318, 226, 168, 25);
		contentPane.add(textSDT);

		textDC = new JTextField();
		textDC.setFont(new Font("Tahoma", Font.BOLD, 14));
		textDC.setHorizontalAlignment(SwingConstants.CENTER);
		textDC.setColumns(10);
		textDC.setBounds(680, 188, 168, 25);
		contentPane.add(textDC);

		lblNewLabel_1 = new JLabel("Thêm nhà cung cấp mới");
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
		btnXN.setBounds(762, 351, 113, 35);
		contentPane.add(btnXN);

		// Tao ma NCC
		createNCC();

		// dang ky su kien
		btnHuy.addActionListener(this);
		btnXN.addActionListener(this);
		this.addWindowFocusListener(this);
		this.addWindowListener(this);

	}

	// Hàm tạo mã ncc auto
	public void createNCC() {
		String maNCC = null;
		ArrayList<NhaCungCap> dsNCC = new ArrayList<NhaCungCap>();
		dsNCC = ncc_Dao.getDSNCC();
		if (dsNCC.size() >= 0) {
			int ma = ncc_Dao.mancc() + 1;
			if (ma < 10) {
				maNCC = "NCC00" + ma;
			} else if (ma >= 10 && ma <= 99) {
				maNCC = "NCC0" + ma;
			} else {
				maNCC = "NCC" + ma;
			}
			dsNCC = ncc_Dao.timMNCC(maNCC);
			for (NhaCungCap nhacungcap : dsNCC) {
				String maC = nhacungcap.getMaNhaCungCap();
				if (maC.equals(maNCC)) {
					int ma1 = ncc_Dao.mancc() + 2;
					if (ma1 < 10) {
						maNCC = "NCC00" + ma1;
					} else if (ma1 >= 10 && ma1 <= 99) {
						maNCC = "NCC0" + ma1;
					} else {
						maNCC = "NCC" + ma1;
					}
				}
			}
		}
		textMNCC.setText(maNCC);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		// event hủy
		if (obj.equals(btnHuy)) {
			int confirm = JOptionPane.showConfirmDialog(this, "Hủy cập nhật ?", "Thông báo", JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				dispose();
			}
		}

		// event xac nhan
		else if (obj.equals(btnXN)) {
			int confirm = JOptionPane.showConfirmDialog(this, "Xác nhận thay đổi ?", "Thông báo",
					JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				addNCC();
				dispose();
			}
		}

	}

	// Tạo nhà cung cấp mới
	public void addNCC() {
		String ma = textMNCC.getText();
		String ten = textTNCC.getText();
		String dc = textDC.getText();
		String email = textE.getText();
		String sdt = textSDT.getText();
		NhaCungCap ncc = new NhaCungCap(ma, ten, dc, sdt, email);
		ncc_Dao.create(ncc);
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
