package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BUS.BNhapKhoCT;
import BUS.BXuatKhoCT;
import DTO.NhapKhoCT;
import DTO.XuatKhoCT;

public class ChiTietXuatKho {

	private JFrame frmchitietxuatkho;
	private JTable table;
	private List<XuatKhoCT> xkct;
	private DefaultTableModel model;
	public static int max;
	BXuatKhoCT Bnkct = new BXuatKhoCT();
	/**
	 * Launch the application.
	 */
	public static void frmchitietxuatkho() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChiTietXuatKho window = new ChiTietXuatKho();
					window.frmchitietxuatkho.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChiTietXuatKho() {
		initialize();
		load();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmchitietxuatkho = new JFrame();
		frmchitietxuatkho.setBounds(100, 100, 970, 564);
		frmchitietxuatkho.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmchitietxuatkho.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		frmchitietxuatkho.getContentPane().add(panel, BorderLayout.CENTER);
		
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 58, 934, 456);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"MaXKCT","MaXK", "Tên Hàng", "Mã Hàng", "Số Lượng", "Tiền"}){
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
		max = QuanLyXuatKho.xemchitiet;
		xkct = Bnkct.getListHangXuat(max);
		model.setRowCount(0);
		for(XuatKhoCT xkcts : xkct) {
			model.addRow(new Object[] { xkcts.getMaXKCT(),xkcts.getMaXK() ,xkcts.getTenHang(),xkcts.getLoaiHang(),xkcts.getSoLuong(),xkcts.getTien()});
		}
	}

}
