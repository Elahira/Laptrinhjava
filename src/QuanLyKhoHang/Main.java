package QuanLyKhoHang;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;
import javax.swing.JTextArea;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 850, 556);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 0, 204));
		panel.setBounds(0, 0, 196, 517);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnKho = new JButton("Kho hàng");
		btnKho.setBackground(Color.WHITE);
		btnKho.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnKho.setBounds(0, 109, 196, 39);
		panel.add(btnKho);
		
		JButton btnNhacc = new JButton("Nhà cung cấp");
		btnNhacc.setBackground(Color.WHITE);
		btnNhacc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNhacc.setBounds(0, 159, 196, 39);
		panel.add(btnNhacc);
		
		JButton btnKH = new JButton("Khách Hàng");
		btnKH.setBackground(Color.WHITE);
		btnKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnKH.setBounds(0, 209, 196, 39);
		panel.add(btnKH);
		
		JButton btnNK = new JButton("Nhập kho");
		btnNK.setBackground(Color.WHITE);
		btnNK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNK.setBounds(0, 259, 196, 39);
		panel.add(btnNK);
		
		JButton btnXK = new JButton("Xuất kho");
		btnXK.setBackground(Color.WHITE);
		btnXK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXK.setBounds(0, 309, 196, 39);
		panel.add(btnXK);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(195, 0, 639, 517);
		frame.getContentPane().add(panel_1);
	}
}
