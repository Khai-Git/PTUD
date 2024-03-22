package gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

import connection.KetNoiKaraoke;
import controllers.TruyVanKaraoke;

public class FormDichVuPhong extends javax.swing.JFrame {

	private JPanel contentPane;
	private JTable tblchonphong;
	private String idp = "";
	TruyVanKaraoke adapterMd = new TruyVanKaraoke();
	KetNoiKaraoke adapterCtr = new KetNoiKaraoke();

	public FormDichVuPhong() {
		initComponents();
		setTitle("Chọn Phòng");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				tblchonphong.setModel(adapterMd.loadPhong("1"));
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(SystemColor.decode("#B9FFF8"));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBorder(new TitledBorder(null, "Chọn phòng thanh tóan sau:", TitledBorder.LEADING, TitledBorder.TOP,
				null, new Color(0, 1, 1)));
		panel.setBounds(0, 0, 395, 357);
		panel.setBackground(SystemColor.decode("#87A2FB"));
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);

		tblchonphong = new JTable();
		tblchonphong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (adapterCtr.demDong("tb_hoadondv", "where tinhtrang='0'").equals("0"))
					JOptionPane.showMessageDialog(null, "Không có dịch vụ được đặt!");
				else if (JOptionPane.showConfirmDialog(null,
						"Bạn có muốn thanh toán sau phòng "
								+ tblchonphong.getModel().getValueAt(tblchonphong.getSelectedRow(), 1).toString() + "",
						"Kiểm tra lại", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					idp = tblchonphong.getModel().getValueAt(tblchonphong.getSelectedRow(), 0).toString();
					adapterCtr.dvThanhToanSau(idp);
					JOptionPane.showMessageDialog(null, "Đã chuyển hóa đơn vào phòng "
							+ tblchonphong.getModel().getValueAt(tblchonphong.getSelectedRow(), 1).toString() + "");
				}
			}
		});
		scrollPane.setViewportView(tblchonphong);
	}
	
	

	private void initComponents() {

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400, Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300, Short.MAX_VALUE));

		pack();
	}
	
	

	public static void main(String args[]) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(FormDichVuPhong.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(FormDichVuPhong.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(FormDichVuPhong.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(FormDichVuPhong.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new FormDichVuPhong().setVisible(true);
			}
		});
	}

}

