package Gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Gui_CuaSoQLHD extends JFrame implements ActionListener, WindowFocusListener, WindowListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnBack;
	private JButton btnQLHDNH;
	private JButton btnQLHDBH;

	/**
	 * Create the frame.
	 */
	public Gui_CuaSoQLHD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 1024, 544);
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
		lblNewLabel_2.setBounds(350, 27, 469, 108);
		contentPane.add(lblNewLabel_2);
		JLabel lblNewLabel_3 = new JLabel("Store Management ");
		lblNewLabel_3.setForeground(new Color(0, 191, 255));
		lblNewLabel_3.setFont(new Font("Freestyle Script", Font.BOLD | Font.ITALIC, 80));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(311, 109, 508, 138);
		contentPane.add(lblNewLabel_3);

		btnBack = new JButton("Trở v�?");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBackground(Color.RED);
		btnBack.setForeground(Color.WHITE);
		btnBack.setBounds(41, 23, 101, 35);
		contentPane.add(btnBack);

		btnQLHDNH = new JButton("Hóa đơn nhập hàng");
		btnQLHDNH.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnQLHDNH.setBounds(620, 358, 306, 106);
		contentPane.add(btnQLHDNH);

		btnQLHDBH = new JButton("Hóa đơn bán hàng");
		btnQLHDBH.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnQLHDBH.setBounds(116, 358, 306, 106);
		contentPane.add(btnQLHDBH);

		// �?ăng ký sự kiện
		this.addWindowFocusListener(this);
		this.addWindowListener(this);
		btnBack.addActionListener(this);
		btnQLHDBH.addActionListener(this);
		btnQLHDNH.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnBack)) {
			new Gui_QuanLy().setVisible(true);
			dispose();
		} else if (obj.equals(btnQLHDBH)) {
			new Gui_QLHoaDonBH().setVisible(true);
			dispose();
		} else if (obj.equals(btnQLHDNH)) {
			new Gui_QLHoaDonNH().setVisible(true);
			dispose();
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
