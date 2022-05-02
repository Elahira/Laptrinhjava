package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.DXuatKho;
import Model.XuatKho;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuanLyXuatKho {

	private JFrame frmqlxkho;
	private JTable tbXuatkho;
	private List<XuatKho> xuatkho;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void frmqlxkho() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyXuatKho window = new QuanLyXuatKho();
					window.frmqlxkho.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public QuanLyXuatKho() {
		initialize();
		load();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmqlxkho = new JFrame();
		frmqlxkho.setBounds(100, 100, 832, 556);
		frmqlxkho.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmqlxkho.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblQuanLyKho = new JLabel("Quản lý nhập kho");
		lblQuanLyKho.setBounds(320, 26, 84, 14);
		panel.add(lblQuanLyKho);
		
		JLabel lblDanhSach = new JLabel("Danh sách nhập kho");
		lblDanhSach.setBounds(36, 74, 97, 14);
		panel.add(lblDanhSach);
		
		JButton btnQuayLai = new JButton("Quay lại");
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main manMain = new Main();
				Main.main(null);
				frmqlxkho.dispose();
			}
		});
		btnQuayLai.setBounds(36, 22, 71, 23);
		panel.add(btnQuayLai);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 99, 746, 345);
		panel.add(scrollPane);
		
		tbXuatkho = new JTable();
		tbXuatkho.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã Xuất Kho", "Ngày Xuất", "Tổng tiền", "Mã Kho"
			}
		));
		tbXuatkho.setFont(new Font("Dialog", Font.PLAIN, 14));
		model = (DefaultTableModel)tbXuatkho.getModel();
		scrollPane.setViewportView(tbXuatkho);
	}
	
	private void load() {
		// TODO Auto-generated method stub
		xuatkho = new DXuatKho().getListXK();
		model.setRowCount(0);
		for(XuatKho nk: xuatkho) {
			model.addRow(
				new Object[] {nk.getMaXK(),nk.getNgayXuat(),nk.getTongTien(),nk.getMaKho()});
		}
	}
}
