package Gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ConnectDB.ConnectDB;
import Dao.NhanVien_DAO;
import Entity.NhanVien;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

public class Gui_QLNhanVien extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel dtm;
	private JTable tableDSNV;
	private JButton btnTK;
	private JLabel lblNewLabel_2;
	private JTextField textData;
	private JComboBox<String> comboBox;
	private JButton btnLM;
	private JButton btnAdd;
	private JPanel panel;
	private JButton btnXoa;
	private JButton btnUpdate;
	private JButton btnTrV;
	private NhanVien_DAO nv_Dao;

	/**
	 * Create the frame.
	 */
	public Gui_QLNhanVien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setSize(1600, 1000);
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

		JLabel lblNewLabel = new JLabel("Danh Sách Nhân Viên Trong Cửa Hàng");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(619, 70, 511, 53);
		contentPane.add(lblNewLabel);

		String[] cols = { "STT", "Mã nhân viên", "Tên nhân viên", "Ngày sinh", "Ngày vào làm", "SCMND", "Số điện thoại",
				"Địa chỉ", "Tình trạng" };
		dtm = new DefaultTableModel(cols, 20);
		tableDSNV = new JTable(dtm);
		tableDSNV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JScrollPane scrollSP = new JScrollPane(tableDSNV);
		scrollSP.setBounds(10, 156, 1520, 330);
		contentPane.add(scrollSP);

		btnTK = new JButton("Tìm kiếm");
		btnTK.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTK.setBounds(639, 597, 101, 43);
		contentPane.add(btnTK);

		textData = new JTextField();
		textData.setHorizontalAlignment(SwingConstants.CENTER);
		textData.setFont(new Font("Tahoma", Font.BOLD, 15));
		textData.setColumns(10);
		textData.setBounds(470, 603, 159, 31);
		contentPane.add(textData);

		btnUpdate = new JButton("Cập nhật thông tin ");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(1030, 597, 183, 43);
		contentPane.add(btnUpdate);

		btnXoa = new JButton("Xóa nhân viên");
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoa.setBounds(1223, 597, 143, 43);
		contentPane.add(btnXoa);

		btnTrV = new JButton("Trở về");
		btnTrV.setForeground(Color.WHITE);
		btnTrV.setBackground(Color.RED);
		btnTrV.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTrV.setBounds(10, 10, 101, 31);
		contentPane.add(btnTrV);

		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel<String>(
				new String[] { "mã nhân viên", "tên nhân viên", "tất cả các nhân viên", "số điện thoại" }));
		comboBox.setBounds(277, 603, 183, 31);
		contentPane.add(comboBox);

		btnLM = new JButton("Làm mới");
		btnLM.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLM.setBounds(750, 597, 101, 43);
		contentPane.add(btnLM);

		btnAdd = new JButton("Thêm nhân viên");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdd.setBounds(861, 596, 159, 44);
		contentPane.add(btnAdd);

		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(83, 571, 1344, 100);
		contentPane.add(panel);
		panel.setLayout(null);

		lblNewLabel_2 = new JLabel("Tìm kiếm theo:");
		lblNewLabel_2.setBounds(70, 32, 120, 31);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));

		// get data
		ArrayList<NhanVien> nv = new ArrayList<NhanVien>();
		nv = nv_Dao.getDSNV();
		getDataDLLV(nv);

		// Đăng ký sự kiện
		btnTrV.addActionListener(this);
		btnAdd.addActionListener(this);
		btnLM.addActionListener(this);
		btnTK.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnXoa.addActionListener(this);

	}

	// hàm get data add in table
	public void getDataDLLV(ArrayList<NhanVien> nv) {
		DefaultTableModel tableSP1 = (DefaultTableModel) tableDSNV.getModel();
		tableSP1.setRowCount(0);
		int n = 0;
		for (NhanVien nhanVien : nv) {
			String maNV = nhanVien.getMaNhanVien();
			String tenNV = nhanVien.getTenNhanVien();
			String ns = nhanVien.getNgaySinh().toString();
			String nvl = nhanVien.getNgayVaoLam().toString();
			String cmnd = nhanVien.getSoCMND();
			String tt = nhanVien.getTt();
			String tt2;
			if (tt.equals("1")) {
				tt2 = "Đang làm việc";
				String sdt = nhanVien.getSoDienThoai();
				String dc = nhanVien.getDiaChi();
				n++;
				tableSP1.addRow(new Object[] { n, maNV, tenNV, ns, nvl, cmnd, sdt, dc, tt2 });
				tableSP1.fireTableDataChanged();
			} else {
				break;
			}

		}

	}

	// hàm get data add in table
	public void getData(ArrayList<NhanVien> nv) {
		DefaultTableModel tableSP1 = (DefaultTableModel) tableDSNV.getModel();
		tableSP1.setRowCount(0);
		int n = 0;
		for (NhanVien nhanVien : nv) {
			String maNV = nhanVien.getMaNhanVien();
			String tenNV = nhanVien.getTenNhanVien();
			String ns = nhanVien.getNgaySinh().toString();
			String nvl = nhanVien.getNgayVaoLam().toString();
			String cmnd = nhanVien.getSoCMND();
			String tt = nhanVien.getTt();
			String tt2;
			if (tt.equals("1")) {
				tt2 = "Đang làm việc";
			} else {
				tt2 = "Đã nghỉ việc";
			}
			String sdt = nhanVien.getSoDienThoai();
			String dc = nhanVien.getDiaChi();
			n++;
			tableSP1.addRow(new Object[] { n, maNV, tenNV, ns, nvl, cmnd, sdt, dc, tt2 });
		}
		tableSP1.fireTableDataChanged();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		// event back
		if (obj.equals(btnTrV)) {
			new Gui_QuanLy().setVisible(true);
			dispose();
		}

		// event tìm kiếm
		else if (obj.equals(btnTK)) {
			String data = textData.getText();
			if (comboBox.getSelectedItem().equals("tất cả các nhân viên")) {
				ArrayList<NhanVien> nv = new ArrayList<NhanVien>();
				nv = nv_Dao.getDSNV();
				getData(nv);
			} else {
				if (data.equals("")) {
					JOptionPane.showMessageDialog(this, "Nhập thông tin nhân viên cần tìm");
				} else {
					if (comboBox.getSelectedItem().equals("mã nhân viên")) {
						ArrayList<NhanVien> nv = new ArrayList<NhanVien>();
						nv = nv_Dao.getMNV(data);
						getData(nv);
					}
					if (comboBox.getSelectedItem().equals("tên nhân viên")) {
						ArrayList<NhanVien> nv = new ArrayList<NhanVien>();
						nv = nv_Dao.getTNV(data);
						getData(nv);
					} else {
						ArrayList<NhanVien> nv = new ArrayList<NhanVien>();
						nv = nv_Dao.getSDT(data);
						getData(nv);
					}
				}
			}

		}

		// event lam moi
		else if (obj.equals(btnLM)) {
			textData.setText("");
			comboBox.setSelectedItem("mã nhân viên");
			ArrayList<NhanVien> nv = new ArrayList<NhanVien>();
			nv = nv_Dao.getDSNV();
			getDataDLLV(nv);
		}

		// event thêm nhân viên
		else if (obj.equals(btnAdd)) {
			new Gui_CuaSoAddNV().setVisible(true);
			dispose();
		}

		// event xoa nhan vien
		else if (obj.equals(btnXoa)) {
			int confirm = JOptionPane.showConfirmDialog(this, "Bạn chắn sẽ xóa đứa này chứ ?", "Thông báo",
					JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				int row = tableDSNV.getSelectedRow();
				String maNV = tableDSNV.getValueAt(row, 1).toString();
				String tt = "0";
				NhanVien nv = new NhanVien(maNV, tt);
				nv_Dao.xoaNV(nv);
				textData.setText("");
				comboBox.setSelectedItem("mã nhân viên");
				ArrayList<NhanVien> nv1 = new ArrayList<NhanVien>();
				nv1 = nv_Dao.getDSNV();
				getDataDLLV(nv1);
			}
		}

		// event update
		else if (obj.equals(btnUpdate)) {
			int row = tableDSNV.getSelectedRow();
			String maNV = tableDSNV.getValueAt(row, 1).toString();
			new Gui_CuaSoUpDateNV(maNV).setVisible(true);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
