package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import DAO.DKhachHang;
import DAO.DKhoHang;
import DAO.DNhaCungCap;
import DTO.KhoHang;
import DTO.NhaCungCap;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class QuanLyKhoHang {

	private JFrame frmqlkho;
	private JTextField txtTenkho;
	private JTextField txtStt;
	private JTable tbKhohang;
	private List<KhoHang> khoHang;
	private DefaultTableModel model;
	int selectedIndex;
	DKhoHang Dkho = new DKhoHang();

	/**
	 * Launch the application.
	 */
	public static void frmqlkho() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyKhoHang window = new QuanLyKhoHang();
					window.frmqlkho.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public QuanLyKhoHang() {
		initialize();
		load();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmqlkho = new JFrame();
		frmqlkho.setTitle("Quản lý kho hàng");
		frmqlkho.setResizable(false);
		frmqlkho.setBounds(100, 100, 748, 566);
		frmqlkho.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmqlkho.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		frmqlkho.getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel lblQunLKho = new JLabel("Quản lý kho hàng");
		lblQunLKho.setFont(new Font("Roboto", Font.BOLD, 18));
		lblQunLKho.setBounds(296, 22, 139, 22);
		panel.add(lblQunLKho);
		
		JButton btnQuaylai = new JButton("Quay lại");
		btnQuaylai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main manMain = new Main();
				Main.main(null);
				frmqlkho.dispose();
			}
		});
		btnQuaylai.setForeground(Color.WHITE);
		btnQuaylai.setFont(new Font("Roboto", Font.BOLD, 16));
		btnQuaylai.setBackground(new Color(255, 153, 51));
		btnQuaylai.setBounds(10, 13, 113, 41);
		panel.add(btnQuaylai);
		
		JPanel panelThongtin = new JPanel();
		panelThongtin.setLayout(null);
		panelThongtin.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelThongtin.setBounds(10, 73, 716, 73);
		panel.add(panelThongtin);
		
		JLabel lblNewLabel_1 = new JLabel("Tên kho hàng:");
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 16));
		lblNewLabel_1.setBounds(65, 32, 102, 19);
		panelThongtin.add(lblNewLabel_1);
		
		txtTenkho = new JTextField();
		txtTenkho.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtTenkho.setColumns(10);
		txtTenkho.setBounds(178, 29, 182, 25);
		panelThongtin.add(txtTenkho);
		
		JLabel lblNewLabel_2 = new JLabel("Số thứ tự:");
		lblNewLabel_2.setFont(new Font("Roboto", Font.BOLD, 16));
		lblNewLabel_2.setBounds(408, 32, 71, 19);
		panelThongtin.add(lblNewLabel_2);
		
		txtStt = new JTextField();
		txtStt.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtStt.setColumns(10);
		txtStt.setBounds(489, 29, 71, 25);
		txtStt.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume(); // if it's not a number, ignore the event
				}
			}
		});
		panelThongtin.add(txtStt);
		
		JLabel lblNewLabel_3 = new JLabel("Danh sách kho hàng");
		lblNewLabel_3.setFont(new Font("Roboto", Font.BOLD, 16));
		lblNewLabel_3.setBounds(10, 255, 147, 19);
		panel.add(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 285, 716, 231);
		panel.add(scrollPane);
		
		tbKhohang = new JTable();
		tbKhohang.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã kho", "Tên kho", "Số thứ tự kho"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbKhohang.setFont(new Font("Roboto", Font.PLAIN, 14));
		tbKhohang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cellClick();
			}
		});
		
		model = (DefaultTableModel)tbKhohang.getModel();
		scrollPane.setViewportView(tbKhohang);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themKho();
			}
		});
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Roboto", Font.BOLD, 16));
		btnThem.setBackground(Color.GREEN);
		btnThem.setBounds(98, 157, 113, 41);
		panel.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suaKho();
			}
		});
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Roboto", Font.BOLD, 16));
		btnSua.setBackground(new Color(0, 153, 255));
		btnSua.setBounds(309, 157, 113, 41);
		panel.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaKho();
			}
		});
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Roboto", Font.BOLD, 16));
		btnXoa.setBackground(new Color(255, 51, 51));
		btnXoa.setBounds(520, 157, 113, 41);
		panel.add(btnXoa);
	}
	
	// load table
		public void load() {
			khoHang = new DKhoHang().getListKho();
			model.setRowCount(0);
			for (KhoHang kho: khoHang) {
				model.addRow(
						new Object[] { kho.getMaKho(), kho.getTenKho(), kho.getSTT() });
			}
		}

		// thêm kho hàng
		public void themKho() {
			if (txtTenkho.getText().length() != 0 && txtStt.getText().length() != 0 ) {
				KhoHang kho = new KhoHang();
				kho.setTenKho(txtTenkho.getText());
				kho.setSTT(Integer.parseInt(txtStt.getText()));
				if (Dkho.themKho(kho)) {
					JOptionPane.showMessageDialog(null, "�?ã thêm kho hàng thành công");
				} else {
					JOptionPane.showMessageDialog(null, "Thêm không thành công");
				}
				load();
			} else {
				JOptionPane.showMessageDialog(null, "xin hãy nhập đầy đủ thông tin");
			}
		}

		// xóa kho hàng
		public void xoaKho() {
			if (JOptionPane.showConfirmDialog(frmqlkho, "Bạn có chắc muốn xóa") == JOptionPane.YES_OPTION) {
				selectedIndex = tbKhohang.getSelectedRow();
				KhoHang kho = khoHang.get(selectedIndex);
				if (Dkho.xoaKho(kho.getMaKho())) {
					JOptionPane.showMessageDialog(null, "�?ã xóa kho hàng thành công");
				} else {
					JOptionPane.showMessageDialog(null, "Xóa không thành công");
				}
				load();
			}
		}

		// sửa kho hàng
		public void suaKho() {
			if (txtTenkho.getText().length() != 0 && txtStt.getText().length() != 0) {
				selectedIndex = tbKhohang.getSelectedRow();
				KhoHang kho = khoHang.get(selectedIndex);
				kho.setMaKho(kho.getMaKho());
				kho.setTenKho(txtTenkho.getText());
				kho.setSTT(Integer.parseInt(txtStt.getText()));
				if (Dkho.suaKho(kho)) {
					JOptionPane.showMessageDialog(null, "�?ã sửa kho hàng thành công");
				} else {
					JOptionPane.showMessageDialog(null, "Sửa không thành công");
				}
				load();
			} else {
				JOptionPane.showMessageDialog(null, "không có hoặc đủ dữ liệu để sửa");
			}
		}

		// ch�?n dòng trong table rồi hiển thị lên các textfield
		public void cellClick() {
			selectedIndex = tbKhohang.getSelectedRow(); // lấy vị trí của dòng hiện đang được ch�?n trong table
			KhoHang kho = khoHang.get(selectedIndex); // lấy giá trị tại vị trí đó
			txtTenkho.setText(kho.getTenKho());
			txtStt.setText(String.valueOf(kho.getSTT()));
		}
}
