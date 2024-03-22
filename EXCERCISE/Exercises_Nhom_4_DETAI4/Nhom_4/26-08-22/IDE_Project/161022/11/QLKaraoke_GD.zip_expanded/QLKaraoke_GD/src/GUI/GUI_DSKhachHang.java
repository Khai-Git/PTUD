package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import GUI.GUI_ThuePhong;
import ConnectDB.ConnectDB;
import DAO.DAO_QLKhachHang;
import Entity.Entity_KhachHang;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;

public class GUI_DSKhachHang extends JFrame implements ActionListener, MouseListener{

	private JPanel contentPane, panel_DSKH;
	private JPanel panel_DSKH_1;
	private JTable table;
	private DefaultTableModel tableModel;
	private JButton btnChon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_DSKhachHang frame = new GUI_DSKhachHang();
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
	public GUI_DSKhachHang() {
		ConnectDB.getInstance().connect();
		
		setTitle("Danh sách khách hàng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_DSKH = new JPanel();
		panel_DSKH.setBounds(10, 11, 660, 472);
		
		panel_DSKH_1 = new JPanel();
		panel_DSKH_1.setBackground(SystemColor.inactiveCaption);
		panel_DSKH_1.setLayout(null);
		panel_DSKH_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh S\u00E1ch kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_DSKH_1.setBounds(10, 11, 660, 472);
		contentPane.add(panel_DSKH_1);
		
		Box dsKH;
		
		panel_DSKH_1.add(dsKH = Box.createHorizontalBox());
		panel_DSKH_1.add(Box.createVerticalStrut(10));
		String [] headers = "Mã khách hàng; Tên khách hàng; Số điện thoại; Địa chỉ; CMND".split(";");
		tableModel = new DefaultTableModel(headers,0);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table = new JTable(tableModel));
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPane.setBounds(10, 27, 640, 395);
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		panel_DSKH_1.add(scrollPane);
		
		btnChon = new JButton("Chọn");
		btnChon.setBackground(Color.PINK);
		btnChon.setBounds(268, 433, 89, 23);
		panel_DSKH_1.add(btnChon);
		
		btnChon.addActionListener(this);
		table.addMouseListener(this);
		DB_To_Table();
	}
	
	private void DB_To_Table() {
		DefaultTableModel dTableModel = (DefaultTableModel) table.getModel();
		dTableModel.getDataVector().removeAllElements();
		
		DAO_QLKhachHang ds = new DAO_QLKhachHang();
		List<Entity_KhachHang> list = ds.getAllTableKH();
		for(Entity_KhachHang kh : list) {
			String [] rowData = {kh.getMaKH(), kh.getTenKH(), kh.getSoDienThoai(), kh.getDiaChi(), kh.getCMND()};
			tableModel.addRow(rowData);
		}
		table.setModel(tableModel);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		GUI_ThuePhong tp = new GUI_ThuePhong();
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnChon)) {
			Chon_Action();
		}
	}

	private void Chon_Action() {
		// TODO Auto-generated method stub
		
	}
}
