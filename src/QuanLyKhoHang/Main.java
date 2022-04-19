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
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

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
		frame.setBounds(100, 100, 850, 328);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(51, 0, 204));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JButton btnKho = new JButton("Kho hàng");
		btnKho.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnKho.setBackground(Color.WHITE);
		
		JButton btnNhacc = new JButton("Nhà cung cấp");
		btnNhacc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNhacc.setBackground(Color.WHITE);
		
		JButton btnKH = new JButton("Khách Hàng");
		btnKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnKH.setBackground(Color.WHITE);
		
		JButton btnNK = new JButton("Nhập kho");
		btnNK.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNK.setBackground(Color.WHITE);
		
		JButton btnXK = new JButton("Xuất kho");
		btnXK.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnXK.setBackground(Color.WHITE);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(32)
					.addComponent(btnKho)
					.addGap(33)
					.addComponent(btnNhacc)
					.addGap(40)
					.addComponent(btnKH)
					.addGap(44)
					.addComponent(btnNK)
					.addGap(48)
					.addComponent(btnXK)
					.addGap(48))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(106)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnXK)
						.addComponent(btnNK)
						.addComponent(btnKH)
						.addComponent(btnNhacc)
						.addComponent(btnKho)))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 153, 255));
		frame.getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Phần mềm quản lý kho hàng");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBackground(new Color(51, 153, 255));
		panel_1.add(lblNewLabel);
	}
}
