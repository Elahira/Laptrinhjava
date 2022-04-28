package View;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Controller.*;

public class Main {

	private JFrame frmMainMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmMainMenu.setVisible(true);
					new ConnectDB().connectDB(); //kết nối database
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
		frmMainMenu = new JFrame();
		frmMainMenu.setTitle("Main menu");
		frmMainMenu.setBounds(100, 100, 850, 328);
		frmMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainMenu.getContentPane().setLayout(new BorderLayout(0, 0));
		frmMainMenu.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(51, 0, 204));
		frmMainMenu.getContentPane().add(panel, BorderLayout.CENTER);

		JButton btnHanghoa = new JButton("Thông tin hàng hóa");
		btnHanghoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyHangHoa qlHangHoa = new QuanLyHangHoa();
				qlHangHoa.formqlhang();
				frmMainMenu.dispose();
			}
		});
		btnHanghoa.setBounds(102, 63, 209, 31);
		btnHanghoa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHanghoa.setBackground(Color.WHITE);

		JButton btnNhacc = new JButton("Nhà cung cấp");
		btnNhacc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyNhaCungCap qlncc = new QuanLyNhaCungCap();
				qlncc.frmqlncc();
				frmMainMenu.dispose();
			}
		});
		btnNhacc.setBounds(102, 157, 171, 31);
		btnNhacc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNhacc.setBackground(Color.WHITE);

		JButton btnKH = new JButton("Khách Hàng");
		btnKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyKhachHang qlkh = new QuanLyKhachHang();
				qlkh.frmqlkh();
				frmMainMenu.dispose();
			}
		});
		btnKH.setBounds(393, 157, 161, 31);
		btnKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnKH.setBackground(Color.WHITE);

		JButton btnNK = new JButton("Nhập kho");
		btnNK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNK.setBounds(613, 157, 132, 31);
		btnNK.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNK.setBackground(Color.WHITE);

		JButton btnXK = new JButton("Xuất kho");
		btnXK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXK.setBounds(613, 63, 118, 31);
		btnXK.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnXK.setBackground(Color.WHITE);
		panel.setLayout(null);
		panel.add(btnHanghoa);
		panel.add(btnNhacc);
		panel.add(btnKH);
		panel.add(btnNK);
		panel.add(btnXK);

		JButton btnKho = new JButton("Kho hàng");
		btnKho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyKhoHang qlkho = new QuanLyKhoHang();
				qlkho.frmqlkho();
				frmMainMenu.dispose();
			}
		});
		btnKho.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnKho.setBackground(Color.WHITE);
		btnKho.setBounds(393, 63, 118, 31);
		panel.add(btnKho);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 153, 255));
		frmMainMenu.getContentPane().add(panel_1, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Phần mềm quản lý kho hàng");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Roboto Bk", Font.BOLD, 22));
		lblNewLabel.setBackground(new Color(51, 153, 255));
		panel_1.add(lblNewLabel);

	}
}
