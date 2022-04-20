package View;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Controller.*;

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
		btnKho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyHangHoa qlHangHoa = new QuanLyHangHoa();
				qlHangHoa.formqlkho();
				frame.dispose();
			}
		});
		btnKho.setBounds(32, 106, 132, 31);
		btnKho.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnKho.setBackground(Color.WHITE);

		JButton btnNhacc = new JButton("Nhà cung cấp");
		btnNhacc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNhacc.setBounds(174, 106, 171, 31);
		btnNhacc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNhacc.setBackground(Color.WHITE);

		JButton btnKH = new JButton("Khách Hàng");
		btnKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnKH.setBounds(355, 106, 161, 31);
		btnKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnKH.setBackground(Color.WHITE);

		JButton btnNK = new JButton("Nhập kho");
		btnNK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNK.setBounds(526, 106, 132, 31);
		btnNK.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNK.setBackground(Color.WHITE);

		JButton btnXK = new JButton("Xuất kho");
		btnXK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXK.setBounds(668, 106, 118, 31);
		btnXK.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnXK.setBackground(Color.WHITE);
		panel.setLayout(null);
		panel.add(btnKho);
		panel.add(btnNhacc);
		panel.add(btnKH);
		panel.add(btnNK);
		panel.add(btnXK);

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
