package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Color;

public class TableDSSanPham extends JFrame {

	private JPanel contentPane;
	private JTextField txtNhpSLng;
	private JTable table;
	private JButton btnThoat,btniSnPhm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableDSSanPham frame = new TableDSSanPham();
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
	public TableDSSanPham() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 714, 62);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTitle = new JLabel("Danh sách sản phẩm");
		lblTitle.setForeground(new Color(65, 105, 225));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitle.setBounds(0, 0, 714, 62);
		panel.add(lblTitle);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 84, 714, 311);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 714, 311);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "Lo\u1EA1i s\u1EA3n ph\u1EA9m", "Gi\u00E1 ti\u1EC1n"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(3).setPreferredWidth(120);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setBackground(new Color(220, 20, 60));
		btnThoat.setForeground(new Color(255, 255, 255));
		btnThoat.setBounds(65, 416, 89, 34);
		contentPane.add(btnThoat);
	
		btniSnPhm = new JButton("Đổi sản phẩm");
		btniSnPhm.setBackground(new Color(0, 128, 0));
		btniSnPhm.setForeground(new Color(255, 255, 255));
		btniSnPhm.setBounds(576, 426, 132, 24);
		contentPane.add(btniSnPhm);
		
		JLabel lblsoLuong = new JLabel("Số lượng:");
		lblsoLuong.setBounds(353, 426, 69, 24);
		contentPane.add(lblsoLuong);
		
		txtNhpSLng = new JTextField();
		txtNhpSLng.setBackground(new Color(192, 192, 192));
		txtNhpSLng.setText("Nhập số lượng");
		txtNhpSLng.setBounds(416, 426, 150, 24);
		contentPane.add(txtNhpSLng);
		txtNhpSLng.setColumns(10);
	}
}
