package Gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui_QuanLy extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnDX;
	private JButton btnQLHD;
	private JButton btnQLSP;
	private JButton btnQLKH;
	private JButton btnNV;
	private JButton btnQLNCC;
	private JButton btnTKDT;


	/**
	 * Create the frame.
	 */
	public Gui_QuanLy() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setSize(1600, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnDX = new JButton("Đăng xuất");
		btnDX.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDX.setBackground(Color.RED);
		btnDX.setForeground(Color.WHITE);
		btnDX.setBounds(10, 10, 114, 34);
		contentPane.add(btnDX);
		JLabel lblNewLabel_2 = new JLabel("VTTM ");
		lblNewLabel_2.setForeground(new Color(0, 191, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Freestyle Script", Font.BOLD | Font.ITALIC, 99));
		lblNewLabel_2.setBounds(539, 106, 469, 108);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Store Management ");
		lblNewLabel_3.setForeground(new Color(0, 191, 255));
		lblNewLabel_3.setFont(new Font("Freestyle Script", Font.BOLD | Font.ITALIC, 90));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(537, 224, 508, 138);
		contentPane.add(lblNewLabel_3);

		btnQLHD = new JButton("Quản lý hóa đơn");
		btnQLHD.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnQLHD.setBounds(378, 466, 246, 108);
		contentPane.add(btnQLHD);

		btnQLSP = new JButton("Quản sản phẩm");
		btnQLSP.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnQLSP.setBounds(698, 466, 214, 108);
		contentPane.add(btnQLSP);

		btnQLKH = new JButton("Quản lý khách hàng");
		btnQLKH.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnQLKH.setBounds(378, 606, 246, 113);
		contentPane.add(btnQLKH);

		btnNV = new JButton("Quản lý nhân viên");
		btnNV.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNV.setBounds(970, 466, 240, 108);
		contentPane.add(btnNV);

		btnQLNCC = new JButton("Quản lý nhà cung cấp");
		btnQLNCC.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnQLNCC.setBounds(698, 606, 214, 113);
		contentPane.add(btnQLNCC);

		btnTKDT = new JButton("Thống kê doanh thu");
		btnTKDT.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTKDT.setBounds(970, 606, 240, 113);
		contentPane.add(btnTKDT);

		// đăng ký sự kiện
		btnDX.addActionListener(this);
		btnNV.addActionListener(this);
		btnQLHD.addActionListener(this);
		btnQLKH.addActionListener(this);
		btnQLNCC.addActionListener(this);
		btnQLSP.addActionListener(this);
		btnTKDT.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		// event đăng xuất
		if (obj.equals(btnDX)) {
			int confirm = JOptionPane.showConfirmDialog(this, "Bạn muốn đăng xuất ?", "Thông báo",
					JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				new Gui_DangNhap().setVisible(true);
				dispose();
			}
		}

		// event quản lý hóa đơn
		else if (obj.equals(btnQLHD)) {
			new Gui_CuaSoQLHD().setVisible(true);
			dispose();
		}

		// event quản lý sản phẩm
		else if (obj.equals(btnQLSP)) {
			new Gui_QLSanPham().setVisible(true);
			dispose();
		}

		// event quản lý nhân viên
		else if (obj.equals(btnNV)) {
			new Gui_QLNhanVien().setVisible(true);
			dispose();
		}

		// event quan ly khach hang
		else if (obj.equals(btnQLKH)) {
			new Gui_QLKhachHang().setVisible(true);
			dispose();
		}

		// event quản lý nhà cung cấp
		else if (obj.equals(btnQLNCC)) {
			new Gui_QLNhaCungCap().setVisible(true);
			dispose();
		}

		// event quản lý thống kê
		else if (obj.equals(btnTKDT)) {
			JOptionPane.showMessageDialog(this, "chức năng này nhóm đang nghiên cứu !!");

		}

	}

}
