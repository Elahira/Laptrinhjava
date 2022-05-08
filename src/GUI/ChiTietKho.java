package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BUS.BKhoHangCT;
import DTO.KhoHang;
import DTO.KhoHangCT;

public class ChiTietKho {

	private JFrame frmkhohang;
	private JTable tbKhoct;
	private List<KhoHangCT> khoHangCTs;
	private DefaultTableModel model;
	BKhoHangCT Bkhoct = new BKhoHangCT();
	public static int maxemkho;

	/**
	 * Launch the application.
	 */
	public static void fromkhoct() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChiTietKho window = new ChiTietKho();
					window.frmkhohang.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChiTietKho() {
		initialize();
		load();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmkhohang = new JFrame();
		frmkhohang.setBounds(100, 100, 970, 564);
		frmkhohang.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmkhohang.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		frmkhohang.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Danh sách hàng hóa trong kho:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 316, 25);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 934, 457);
		panel.add(scrollPane);
		
		tbKhoct = new JTable();
		tbKhoct.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã", "Tên hàng", "Loại hàng", "Kho", "Giá tiền", "Số lượng", "Tổng tiền hàng"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbKhoct.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tbKhoct.setRowHeight(30);
		model = (DefaultTableModel)tbKhoct.getModel();
		scrollPane.setViewportView(tbKhoct);
	}
	
	private void load() {
		maxemkho = QuanLyKhoHang.xemkho;
		khoHangCTs = Bkhoct.listkhoct(maxemkho);
		model.setRowCount(0);
		for (KhoHangCT khoct: khoHangCTs) {
			int tongtien = khoct.getGia()*khoct.getSoLuong();
			model.addRow(
					new Object[] { khoct.getMaKhoCT(), khoct.getTenHang(), khoct.getLoaiHang(), khoct.getTenKho(), khoct.getGia(), khoct.getSoLuong(), tongtien });
		}
	}
}
