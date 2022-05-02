package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import Controller.DNhapKho;
import Model.NhapKho;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuanLyNhapKho {

	private JFrame frmqlnkho;
	private JTable tbNhapkho;
	private List<NhapKho> nhapkho;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void frmqlnkho() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyNhapKho window = new QuanLyNhapKho();
					window.frmqlnkho.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public QuanLyNhapKho() {
		initialize();
		load();
	}	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmqlnkho = new JFrame();
		frmqlnkho.setBounds(100, 100, 832, 556);
		frmqlnkho.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		JPanel panel = new JPanel();
		frmqlnkho.getContentPane().add(panel, BorderLayout.CENTER);
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
				frmqlnkho.dispose();
			}
		});
		btnQuayLai.setBounds(36, 22, 71, 23);
		panel.add(btnQuayLai);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 99, 746, 345);
		panel.add(scrollPane);
		
		tbNhapkho = new JTable();
		tbNhapkho.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã Nhập Kho", "Ngày Nhập", "Tổng tiền", "Mã Kho"
			}
		));
		tbNhapkho.setFont(new Font("Dialog", Font.PLAIN, 14));
		model = (DefaultTableModel)tbNhapkho.getModel();
		scrollPane.setViewportView(tbNhapkho);
	}
	
	private void load() {
		// TODO Auto-generated method stub
		nhapkho = new DNhapKho().getListNK();
		model.setRowCount(0);
		for(NhapKho nk: nhapkho) {
			model.addRow(
				new Object[] {nk.getMaNK(),nk.getNgayNhap(),nk.getTongTien(),nk.getMaKho()});
		}
	}
}
