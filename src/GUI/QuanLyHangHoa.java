package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;

import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.RowFilter;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import BUS.BHangHoa;
import BUS.BNhaCungCap;
import DTO.HangHoa;
import DTO.NhaCungCap;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QuanLyHangHoa {

	private JFrame frmQunlhang;
	private JTextField txtTenhang;
	private JTextField txtLoai;
	private JTextField txtGia;
	private JTable tbHang;
	private List<HangHoa> hangHoa;
	private List<NhaCungCap> nhaCungCap;
	private DefaultTableModel model;
	private JComboBox<String> cbNhacc;
	int selectedIndex;
	BNhaCungCap Bncc = new BNhaCungCap();
	BHangHoa Bhh = new BHangHoa();
	private JTextField txtTimkiem;

	/**
	 * Launch the application.
	 */
	public static void formqlhang() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyHangHoa window = new QuanLyHangHoa();
					window.frmQunlhang.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public QuanLyHangHoa() {
		initialize();
		load();
		loadcombobox();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmQunlhang = new JFrame();
		frmQunlhang.setTitle("Quản lý hang hóa");
		frmQunlhang.setBounds(100, 100, 886, 570);
		frmQunlhang.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmQunlhang.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("CheckBox.background"));
		frmQunlhang.getContentPane().add(panel, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("Danh sách hàng hóa");
		lblNewLabel.setBounds(10, 244, 162, 22);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemHH();
			}
		});
		btnThem.setForeground(Color.WHITE);
		btnThem.setBackground(new Color(0, 204, 51));
		btnThem.setBounds(146, 192, 95, 37);
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 16));

		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suaHH();
			}
		});
		btnSua.setForeground(Color.WHITE);
		btnSua.setBackground(new Color(0, 153, 204));
		btnSua.setBounds(387, 192, 95, 37);
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 16));

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaHH();
			}
		});
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setBackground(new Color(204, 0, 0));
		btnXoa.setBounds(628, 192, 95, 37);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 16));

		JPanel panelThongtin = new JPanel();
		panelThongtin.setBounds(10, 54, 850, 120);
		panelThongtin.setBorder(new LineBorder(new Color(0, 0, 0)));

		JLabel lblNewLabel_6 = new JLabel("Quản lý thông tin hàng hóa");
		lblNewLabel_6.setBounds(287, 11, 275, 25);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.setLayout(null);
		panelThongtin.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Tên hàng:");
		lblNewLabel_1.setBounds(10, 24, 82, 20);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelThongtin.add(lblNewLabel_1);

		txtTenhang = new JTextField();
		txtTenhang.setBounds(102, 21, 222, 26);
		txtTenhang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenhang.setColumns(10);
		panelThongtin.add(txtTenhang);

		JLabel lblNewLabel_2 = new JLabel("Nhà cung cấp:");
		lblNewLabel_2.setBounds(10, 76, 114, 20);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelThongtin.add(lblNewLabel_2);

		txtLoai = new JTextField();
		txtLoai.setBounds(556, 24, 146, 26);
		txtLoai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtLoai.setColumns(10);
		panelThongtin.add(txtLoai);

		JLabel lblNewLabel_5 = new JLabel("Loại:");
		lblNewLabel_5.setBounds(506, 27, 40, 20);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelThongtin.add(lblNewLabel_5);

		txtGia = new JTextField();
		txtGia.setBounds(556, 76, 146, 26);
		txtGia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtGia.setColumns(10);
		panelThongtin.add(txtGia);
		txtGia.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume(); // if it's not a number, ignore the event
				}
			}
		});

		JLabel lblNewLabel_3 = new JLabel("Giá:");
		lblNewLabel_3.setBounds(506, 79, 33, 20);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelThongtin.add(lblNewLabel_3);
		panel.add(panelThongtin);

		cbNhacc = new JComboBox();
		cbNhacc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbNhacc.setBounds(134, 71, 190, 28);

		panelThongtin.add(cbNhacc);
		panel.add(lblNewLabel_6);
		panel.add(lblNewLabel);
		panel.add(btnThem);
		panel.add(btnSua);
		panel.add(btnXoa);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 277, 850, 243);
		panel.add(scrollPane);

		tbHang = new JTable();
		tbHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cellClick();
			}
		});
		tbHang.setFont(new Font("Roboto", Font.PLAIN, 16));

		tbHang.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã hàng", "Tên hàng", "Loại hàng", "Nhà cung cấp", "Giá" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tbHang);

		model = (DefaultTableModel) tbHang.getModel();

		JButton btnBack = new JButton("Quay lại");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main main = new Main();
				main.main(null);
				frmQunlhang.dispose();
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(new Color(255, 102, 0));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBack.setBounds(10, 16, 109, 29);
		panel.add(btnBack);
		
		txtTimkiem = new JTextField();
		txtTimkiem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				filter(txtTimkiem.getText());
			}
		});
		
		txtTimkiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTimkiem.setBounds(317, 244, 245, 24);
		panel.add(txtTimkiem);
		txtTimkiem.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Tìm kiếm:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(228, 244, 79, 22);
		panel.add(lblNewLabel_4);
	}

	// load table
	private void load() {
		hangHoa = Bhh.listHangHoa();
		model.setRowCount(0);
		for (HangHoa hh : hangHoa) {
			model.addRow(
					new Object[] { hh.getMaHang(), hh.getTenHang(), hh.getLoaiHang(), hh.getTenNhaCC(), hh.getGia() });
		}
	}

	// load combobox
	public void loadcombobox() {
		nhaCungCap = Bncc.listNcc();
		for (NhaCungCap ncc : nhaCungCap) {
			cbNhacc.addItem(ncc.getTenNhaCC());
		}
	}
	
	//tìm kiếm, filter
	private void filter(String search) {
		TableRowSorter<DefaultTableModel> tRowSorter = new TableRowSorter<DefaultTableModel>(model);
		tbHang.setRowSorter(tRowSorter);
		tRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + search));
	}

	// thêm hàng hóa
	public void ThemHH() {
		if (txtTenhang.getText().length() != 0 && txtLoai.getText().length() != 0 && txtGia.getText().length() != 0
				&& cbNhacc.getSelectedIndex() != -1) {
			HangHoa hh = new HangHoa();
			hh.setTenHang(txtTenhang.getText());
			hh.setLoaiHang(txtLoai.getText());
			hh.setGia(Integer.parseInt(txtGia.getText()));
			hh.setMaNCC(Bncc.getMancc(cbNhacc.getSelectedItem().toString()));
			if (Bhh.themHanghoa(hh)) {
				JOptionPane.showMessageDialog(null, "Đã thêm hàng hóa thành công");
			} else {
				JOptionPane.showMessageDialog(null, "Thêm không thành công");
			}
			load();
			loadcombobox();
		} else {
			JOptionPane.showMessageDialog(null, "xin hãy nhập đầy đủ thông tin");
		}
	}

	// xóa hàng hóa
	public void xoaHH() {
		if (JOptionPane.showConfirmDialog(frmQunlhang, "Bạn có chắc muốn xóa") == JOptionPane.YES_OPTION) {
			selectedIndex = tbHang.getSelectedRow();
			HangHoa hh = hangHoa.get(selectedIndex);
			if (Bhh.xoaHanghoa(hh.getMaHang())) {
				JOptionPane.showMessageDialog(null, "Đã xóa hàng hóa thành công");
			} else {
				JOptionPane.showMessageDialog(null, "Xóa không thành công");
			}
			load();
			loadcombobox();
		}
	}

	// sửa hàng hóa
	public void suaHH() {
		if (txtTenhang.getText().length() != 0 && txtLoai.getText().length() != 0 && txtGia.getText().length() != 0
				&& cbNhacc.getSelectedIndex() != -1) {
			selectedIndex = tbHang.getSelectedRow();
			HangHoa hh = hangHoa.get(selectedIndex);
			hh.setMaHang(hh.getMaHang());
			hh.setTenHang(txtTenhang.getText());
			hh.setLoaiHang(txtLoai.getText());
			hh.setMaNCC(Bncc.getMancc(cbNhacc.getSelectedItem().toString()));
			hh.setGia(Integer.parseInt(txtGia.getText()));
			if (Bhh.suaHanghoa(hh)) {
				JOptionPane.showMessageDialog(null, "Đã sửa thành công");
			} else {
				JOptionPane.showMessageDialog(null, "Sửa không thành công");
			}
			load();
			loadcombobox();
		} else {
			JOptionPane.showMessageDialog(null, "không có hoặc đủ dữ liệu để sửa");
		}
	}

	// chọn dòng trong table rồi hiển thị lên các textfield
	public void cellClick() {
		selectedIndex = tbHang.getSelectedRow(); // lấy vị trí của dòng hiện đang được chọn trong table
		HangHoa hh = hangHoa.get(selectedIndex); // lấy giá trị tại vị trí đó
		txtTenhang.setText(hh.getTenHang());
		txtLoai.setText(hh.getLoaiHang());
		cbNhacc.setSelectedItem(hh.getTenNhaCC());
		txtGia.setText(String.valueOf(hh.getGia()));
	}
}
