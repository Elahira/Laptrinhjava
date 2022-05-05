package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import DAO.DKhachHang;
import DAO.DNhaCungCap;
import DTO.KhachHang;
import DTO.NhaCungCap;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QuanLyKhachHang {

	private JFrame frmqlkh;
	private JTextField txtTenKh;
	private JTextField txtSdt;
	private JTextField txtDiachi;
	private JTextField txtEmail;
	private JTable tbKH;
	private List<KhachHang> khachHang;
	private DefaultTableModel model;
	int selectedIndex;
	DKhachHang Dkh = new DKhachHang();

	/**
	 * Launch the application.
	 */
	public static void frmqlkh() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					QuanLyKhachHang window = new QuanLyKhachHang();
					window.frmqlkh.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public QuanLyKhachHang() {
		initialize();
		load();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmqlkh = new JFrame();
		frmqlkh.setResizable(false);
		frmqlkh.setTitle("Quản lý khách hàng");
		frmqlkh.setBounds(100, 100, 826, 588);
		frmqlkh.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frmqlkh.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		frmqlkh.getContentPane().add(panel, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("Quản lý khách hàng");
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 18));
		lblNewLabel.setBounds(312, 18, 171, 22);
		panel.add(lblNewLabel);

		JButton btnQuaylai = new JButton("Quay lại");
		btnQuaylai.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main manMain = new Main();
				Main.main(null);
				frmqlkh.dispose();
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
		panelThongtin.setBounds(10, 73, 790, 153);
		panel.add(panelThongtin);

		JLabel lblNewLabel_1 = new JLabel("Tên Khách hàng:");
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 32, 131, 19);
		panelThongtin.add(lblNewLabel_1);

		txtTenKh = new JTextField();
		txtTenKh.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtTenKh.setColumns(10);
		txtTenKh.setBounds(135, 29, 220, 25);
		panelThongtin.add(txtTenKh);

		JLabel lblNewLabel_2 = new JLabel("Số điện thoại:");
		lblNewLabel_2.setFont(new Font("Roboto", Font.BOLD, 16));
		lblNewLabel_2.setBounds(413, 32, 99, 19);
		panelThongtin.add(lblNewLabel_2);

		txtSdt = new JTextField();
		txtSdt.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtSdt.setColumns(10);
		txtSdt.setBounds(517, 29, 140, 25);
		panelThongtin.add(txtSdt);

		JLabel lblNewLabel_1_1 = new JLabel("�?ịa chỉ:");
		lblNewLabel_1_1.setFont(new Font("Roboto", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(10, 94, 131, 19);
		panelThongtin.add(lblNewLabel_1_1);

		txtDiachi = new JTextField();
		txtDiachi.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtDiachi.setColumns(10);
		txtDiachi.setBounds(71, 91, 220, 25);
		panelThongtin.add(txtDiachi);

		JLabel lblNewLabel_1_2 = new JLabel("Email:");
		lblNewLabel_1_2.setFont(new Font("Roboto", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(413, 94, 131, 19);
		panelThongtin.add(lblNewLabel_1_2);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtEmail.setColumns(10);
		txtEmail.setBounds(468, 91, 189, 25);
		panelThongtin.add(txtEmail);

		JLabel lblNewLabel_3 = new JLabel("Danh sách khách hàng");
		lblNewLabel_3.setFont(new Font("Roboto", Font.BOLD, 16));
		lblNewLabel_3.setBounds(10, 301, 176, 19);
		panel.add(lblNewLabel_3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 331, 790, 215);
		panel.add(scrollPane);

		tbKH = new JTable();
		tbKH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cellClick();
			}
		});
		tbKH.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Email", "�?ịa chỉ" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbKH.setFont(new Font("Roboto", Font.PLAIN, 12));
		model = (DefaultTableModel) tbKH.getModel();

		scrollPane.setViewportView(tbKH);

		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				themKH();
			}
		});
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Roboto", Font.BOLD, 16));
		btnThem.setBackground(Color.GREEN);
		btnThem.setBounds(117, 237, 113, 41);
		panel.add(btnThem);

		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				suaKH();
			}
		});
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Roboto", Font.BOLD, 16));
		btnSua.setBackground(new Color(0, 153, 255));
		btnSua.setBounds(347, 237, 113, 41);
		panel.add(btnSua);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				xoaKH();
			}
		});
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Roboto", Font.BOLD, 16));
		btnXoa.setBackground(new Color(255, 51, 51));
		btnXoa.setBounds(577, 237, 113, 41);
		panel.add(btnXoa);
	}

	// load data
	public void load() {
		khachHang = new DKhachHang().getListKH();
		model.setRowCount(0);
		for (KhachHang kh : khachHang) {
			model.addRow(new Object[] { kh.getMaKH(), kh.getTenKH(), kh.getSDT(), kh.getEmail(), kh.getDiaChi() });
		}
	}

	// thêm khách hàng
	public void themKH() {
		if (txtTenKh.getText().length() != 0 && txtSdt.getText().length() != 0 && txtDiachi.getText().length() != 0
				&& txtEmail.getText().length() != 0) {
			KhachHang kh = new KhachHang();
			kh.setTenKH(txtTenKh.getText());
			kh.setSDT(txtSdt.getText());
			kh.setEmail(txtEmail.getText());
			kh.setDiaChi(txtDiachi.getText());
			if (Dkh.themKH(kh)) {
				JOptionPane.showMessageDialog(null, "�?ã thêm khách hàng thành công");
			} else {
				JOptionPane.showMessageDialog(null, "Thêm không thành công");
			}
			load();
		} else {
			JOptionPane.showMessageDialog(null, "xin hãy nhập đầy đủ thông tin");
		}
	}

	// xóa khách hàng
	public void xoaKH() {
		if (JOptionPane.showConfirmDialog(frmqlkh, "Bạn có chắc muốn xóa") == JOptionPane.YES_OPTION) {
			selectedIndex = tbKH.getSelectedRow();
			KhachHang kh = khachHang.get(selectedIndex);
			if (Dkh.xoaKH(kh.getMaKH())) {
				JOptionPane.showMessageDialog(null, "�?ã xóa khách hàng thành công");
			} else {
				JOptionPane.showMessageDialog(null, "Xóa không thành công");
			}
			load();
		}
	}

	// sửa khách hàng
	public void suaKH() {
		if (txtTenKh.getText().length() != 0 && txtSdt.getText().length() != 0 && txtDiachi.getText().length() != 0
				&& txtEmail.getText().length() != 0) {
			selectedIndex = tbKH.getSelectedRow();
			KhachHang kh = khachHang.get(selectedIndex);
			kh.setMaKH(kh.getMaKH());
			kh.setTenKH(txtTenKh.getText());
			kh.setSDT(txtSdt.getText());
			kh.setEmail(txtEmail.getText());
			kh.setDiaChi(txtDiachi.getText());
			if (Dkh.suaKH(kh)) {
				JOptionPane.showMessageDialog(null, "�?ã sửa khách hàng thành công");
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
		selectedIndex = tbKH.getSelectedRow(); // lấy vị trí của dòng hiện đang được ch�?n trong table
		KhachHang kh = khachHang.get(selectedIndex); // lấy giá trị tại vị trí đó
		txtTenKh.setText(kh.getTenKH());
		txtSdt.setText(kh.getSDT());
		txtEmail.setText(kh.getEmail());
		txtDiachi.setText(kh.getDiaChi());
	}
}
