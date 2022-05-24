package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BUS.BNhapKhoCT;
import DTO.NhapKhoCT;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class ChiTietNhapKho {

	private JFrame frmchitietnhapkho;
	private JTable table;
	private List<NhapKhoCT> nkct;
	private DefaultTableModel model;
	public static int max;
	BNhapKhoCT Bnkct = new BNhapKhoCT();

	/**
	 * Launch the application.
	 */
	public static void frmchitietnhapkho() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChiTietNhapKho window = new ChiTietNhapKho();
					window.frmchitietnhapkho.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChiTietNhapKho() {
		initialize();
		load();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmchitietnhapkho = new JFrame();
		frmchitietnhapkho.setBounds(100, 100, 970, 564);
		frmchitietnhapkho.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmchitietnhapkho.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		frmchitietnhapkho.getContentPane().add(panel, BorderLayout.CENTER);
		
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 58, 934, 456);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"MaNKCT","MaNK", "Tên Hàng", "Mã Hàng", "Số Lượng", "Tiền"}){
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setRowHeight(30);
		model = (DefaultTableModel)table.getModel();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Danh sach");
		lblNewLabel.setBounds(109, 11, 487, 27);
		panel.add(lblNewLabel);
	}
	private void load() {
		// TODO Auto-generated method stub
		max = QuanLyNhapKho.xemchitiet;
		nkct = Bnkct.getListHangNhap(max);
		model.setRowCount(0);
		for(NhapKhoCT nkcts : nkct) {
			model.addRow(new Object[] { nkcts.getMaNKCT(),nkcts.getMaNK() ,nkcts.getTenHang(),nkcts.getLoaiHang(),nkcts.getSoLuong(),nkcts.getTien()});
		}
	}
}
