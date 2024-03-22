package GUI;
import java.io.IOException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

public class GUI_Loading {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		JWindow window = new JWindow();
		window.getContentPane().add(
		    new JLabel("", new ImageIcon("C:\\Users\\hp\\OneDrive\\Máy tính\\PTUD\\ProjectFinal\\QLKaraoke_GD.zip_expanded\\QLKaraoke_GD\\src\\img\\giphy.gif"), SwingConstants.CENTER));
		window.setBounds(100, 100,480,278);
		window.setVisible(true);
		window.setLocationRelativeTo(null);
		try {
		    Thread.sleep(2500);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		window.setVisible(false);
		JFrame frame = new GUI_DangNhap();
		frame.setVisible(true);
		window.dispose();

	}

}
