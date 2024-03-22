package Gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;

public class Gui_CuaSoHD extends JFrame implements ActionListener, WindowFocusListener, WindowListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnBack;
	private JButton btnTHDBH;
	private JButton btnTHDNH;
	private JButton btnXHDNH;
	private JButton btnXHDBH;

	/**
	 * Create the frame.
	 */
	public Gui_CuaSoHD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(270, 70, 1024, 544);
		setResizable(false);
		this.requestFocusInWindow(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("VTTM ");
		lblNewLabel_2.setForeground(new Color(0, 191, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Freestyle Script", Font.BOLD | Font.ITALIC, 100));
		lblNewLabel_2.setBounds(311, 10, 469, 108);
		contentPane.add(lblNewLabel_2);
		JLabel lblNewLabel_3 = new JLabel("Store Management ");
		lblNewLabel_3.setForeground(new Color(0, 191, 255));
		lblNewLabel_3.setFont(new Font("Freestyle Script", Font.BOLD | Font.ITALIC, 80));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(272, 92, 508, 138);
		contentPane.add(lblNewLabel_3);

		btnBack = new JButton("Trở v�?");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBackground(Color.RED);
		btnBack.setForeground(Color.WHITE);
		btnBack.setBounds(41, 23, 101, 35);
		contentPane.add(btnBack);

		btnTHDBH = new JButton("Tạo hóa đơn bán hàng");
		btnTHDBH.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnTHDBH.setBounds(108, 242, 306, 106);
		contentPane.add(btnTHDBH);

		btnTHDNH = new JButton("Tạo hóa đơn nhập hàng");
		btnTHDNH.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnTHDNH.setBounds(108, 358, 306, 106);
		contentPane.add(btnTHDNH);

		btnXHDNH = new JButton("Xem các hóa đơn nhập hàng");
		btnXHDNH.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnXHDNH.setBounds(604, 358, 306, 106);
		contentPane.add(btnXHDNH);

		btnXHDBH = new JButton("Xem các hóa đơn bán hàng");
		btnXHDBH.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnXHDBH.setBounds(604, 242, 306, 106);
		contentPane.add(btnXHDBH);

		// �?ăng ký event
		this.addWindowFocusListener(this);
		this.addWindowListener(this);
		btnBack.addActionListener(this);
		btnTHDNH.addActionListener(this);
		btnTHDBH.addActionListener(this);
		btnXHDBH.addActionListener(this);
		btnXHDNH.addActionListener(this);

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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnBack)) {
			new Gui_NhanVien().setVisible(true);
			dispose();
		} else if (obj.equals(btnTHDBH)) {
			new Gui_HoaDonBanHang().setVisible(true);
			dispose();
		} else if (obj.equals(btnTHDNH)) {
			new Gui_HoaDonNhapHang().setVisible(true);
			dispose();
		} else if (obj.equals(btnXHDBH)) {
			new Gui_XemHDBH().setVisible(true);
			dispose();
		} else if (obj.equals(btnXHDNH)) {
			new Gui_XemHDNH().setVisible(true);
			dispose();
		}
	}

}
