package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import DAO.DHangHoa;
import DAO.DNhaCungCap;
import DTO.HangHoa;
import DTO.NhaCungCap;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QuanLyNhaCungCap {

	private JFrame frmQunLNh;
	private JTextField txtTenncc;
	private JTextField txtSdt;
	private JTextField txtDiachi;
	private JTextField txtEmail;
	private JTable tbNhacc;
	private List<NhaCungCap> nhaCungCap;
	private DefaultTableModel model;
	int selectedIndex;
	DNhaCungCap Dncc = new DNhaCungCap();

	/**
	 * Launch the application.
	 */
	public static void frmqlncc() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyNhaCungCap window = new QuanLyNhaCungCap();
					window.frmQunLNh.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public QuanLyNhaCungCap() {
		initialize();
		load();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmQunLNh = new JFrame();
		frmQunLNh.setResizable(false);
		frmQunLNh.setTitle("Quản lý nhà cung cấp");
		frmQunLNh.setBounds(100, 100, 826, 596);
		frmQunLNh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmQunLNh.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		frmQunLNh.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản lý nhà cung cấp");
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 18));
		lblNewLabel.setBounds(312, 18, 171, 22);
		panel.add(lblNewLabel);

		JButton btnQuaylai = new JButton("Quay lại");
		btnQuaylai.setForeground(new Color(255, 255, 255));
		btnQuaylai.setBackground(new Color(255, 153, 51));
		btnQuaylai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main manMain = new Main();
				Main.main(null);
				frmQunLNh.dispose();
			}
		});
		btnQuaylai.setFont(new Font("Roboto", Font.BOLD, 16));
		btnQuaylai.setBounds(10, 13, 113, 41);
		panel.add(btnQuaylai);

		JPanel panelThongtin = new JPanel();
		panelThongtin.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelThongtin.setBounds(10, 73, 790, 153);
		panel.add(panelThongtin);
		panelThongtin.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Tên nhà cung cấp:");
		lblNewLabel_1.setBounds(10, 32, 131, 19);
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 16));
		panelThongtin.add(lblNewLabel_1);

		txtTenncc = new JTextField();
		txtTenncc.setBounds(151, 29, 220, 25);
		txtTenncc.setFont(new Font("Roboto", Font.PLAIN, 16));
		panelThongtin.add(txtTenncc);
		txtTenncc.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Số điện thoại:");
		lblNewLabel_2.setBounds(413, 32, 99, 19);
		lblNewLabel_2.setFont(new Font("Roboto", Font.BOLD, 16));
		panelThongtin.add(lblNewLabel_2);

		txtSdt = new JTextField();
		txtSdt.setBounds(517, 29, 140, 25);
		txtSdt.setFont(new Font("Roboto", Font.PLAIN, 16));
		panelThongtin.add(txtSdt);
		txtSdt.setColumns(10);
		// chỉ có thể nhập số
		txtSdt.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume(); // if it's not a number, ignore the event
				}
			}
		});

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

		JLabel lblNewLabel_3 = new JLabel("Danh sách nhà cung cấp");
		lblNewLabel_3.setFont(new Font("Roboto", Font.BOLD, 16));
		lblNewLabel_3.setBounds(10, 301, 176, 19);
		panel.add(lblNewLabel_3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 331, 790, 215);
		panel.add(scrollPane);

		tbNhacc = new JTable();
		tbNhacc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cellClick();
			}
		});
		tbNhacc.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã nhà cung cấp", "Tên nhà cung cấp", "số điện thoại", "Email", "�?ịa chỉ" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		tbNhacc.setFont(new Font("Roboto", Font.PLAIN, 12));
		scrollPane.setViewportView(tbNhacc);

		model = (DefaultTableModel) tbNhacc.getModel();

		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themNCC();
			}
		});
		btnThem.setForeground(Color.WHITE);
		btnThem.setBackground(new Color(0, 255, 0));
		btnThem.setFont(new Font("Roboto", Font.BOLD, 16));
		btnThem.setBounds(117, 237, 113, 41);
		panel.add(btnThem);

		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suaNCC();
			}
		});
		btnSua.setForeground(new Color(255, 255, 255));
		btnSua.setBackground(new Color(0, 153, 255));
		btnSua.setFont(new Font("Roboto", Font.BOLD, 16));
		btnSua.setBounds(347, 237, 113, 41);
		panel.add(btnSua);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaNCC();
			}
		});
		btnXoa.setForeground(new Color(255, 255, 255));
		btnXoa.setBackground(new Color(255, 51, 51));
		btnXoa.setFont(new Font("Roboto", Font.BOLD, 16));
		btnXoa.setBounds(577, 237, 113, 41);
		panel.add(btnXoa);

	}

	// load table
	public void load() {
		nhaCungCap = new DNhaCungCap().getListNCC();
		model.setRowCount(0);
		for (NhaCungCap ncc : nhaCungCap) {
			model.addRow(
					new Object[] { ncc.getMaNCC(), ncc.getTenNhaCC(), ncc.getSDT(), ncc.getEmail(), ncc.getDiaChi() });
		}
	}

	// thêm nhà cung cấp
	public void themNCC() {
		if (txtTenncc.getText().length() != 0 && txtSdt.getText().length() != 0 && txtDiachi.getText().length() != 0
				&& txtEmail.getText().length() != 0) {
			NhaCungCap ncc = new NhaCungCap();
			ncc.setTenNhaCC(txtTenncc.getText());
			ncc.setSDT(txtSdt.getText());
			ncc.setEmail(txtEmail.getText());
			ncc.setDiaChi(txtDiachi.getText());
			if (Dncc.themNCC(ncc)) {
				JOptionPane.showMessageDialog(null, "�?ã thêm nhà cung cấp thành công");
			} else {
				JOptionPane.showMessageDialog(null, "Thêm không thành công");
			}
			load();
		} else {
			JOptionPane.showMessageDialog(null, "xin hãy nhập đầy đủ thông tin");
		}
	}

	// xóa nhà cung cấp
	public void xoaNCC() {
		if (JOptionPane.showConfirmDialog(frmQunLNh, "Bạn có chắc muốn xóa") == JOptionPane.YES_OPTION) {
			selectedIndex = tbNhacc.getSelectedRow();
			NhaCungCap ncc = nhaCungCap.get(selectedIndex);
			if (Dncc.xoaNCC(ncc.getMaNCC())) {
				JOptionPane.showMessageDialog(null, "�?ã xóa nhà cung cấp thành công");
			} else {
				JOptionPane.showMessageDialog(null, "Xóa không thành công");
			}
			load();
		}
	}

	// sửa nhà cung cấp
	public void suaNCC() {
		if (txtTenncc.getText().length() != 0 && txtSdt.getText().length() != 0 && txtDiachi.getText().length() != 0
				&& txtEmail.getText().length() != 0) {
			selectedIndex = tbNhacc.getSelectedRow();
			NhaCungCap ncc = nhaCungCap.get(selectedIndex);
			ncc.setMaNCC(ncc.getMaNCC());
			ncc.setTenNhaCC(txtTenncc.getText());
			ncc.setSDT(txtSdt.getText());
			ncc.setEmail(txtEmail.getText());
			ncc.setDiaChi(txtDiachi.getText());
			if (Dncc.suaNCC(ncc)) {
				JOptionPane.showMessageDialog(null, "�?ã sửa nhà cung cấp thành công");
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
		selectedIndex = tbNhacc.getSelectedRow(); // lấy vị trí của dòng hiện đang được ch�?n trong table
		NhaCungCap ncc = nhaCungCap.get(selectedIndex); // lấy giá trị tại vị trí đó
		txtTenncc.setText(ncc.getTenNhaCC());
		txtSdt.setText(ncc.getSDT());
		txtEmail.setText(ncc.getEmail());
		txtDiachi.setText(ncc.getDiaChi());
	}
}
