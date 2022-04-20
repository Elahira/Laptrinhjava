package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Controller.DHangHoa;
import Model.HangHoa;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class QuanLyHangHoa {

	private JFrame frmQunLKho;
	private JTextField txtTenhang;
	private JTextField txtLoai;
	private JTextField txtGia;
	private JTextField txtTenncc;
	private JTextField txtSoluong;
	private JTable tbHang;
	private List<HangHoa> hangHoa;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void formqlkho() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyHangHoa window = new QuanLyHangHoa();
					window.frmQunLKho.setVisible(true);
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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmQunLKho = new JFrame();
		frmQunLKho.setTitle("Quản lý kho hàng");
		frmQunLKho.setBounds(100, 100, 886, 570);
		frmQunLKho.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("CheckBox.background"));
		frmQunLKho.getContentPane().add(panel, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("Danh sách hàng hóa");
		lblNewLabel.setBounds(30, 239, 162, 22);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnThem = new JButton("Thêm");
		btnThem.setForeground(Color.WHITE);
		btnThem.setBackground(new Color(0, 204, 51));
		btnThem.setBounds(240, 192, 95, 37);
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 16));

		JButton btnSua = new JButton("Sửa");
		btnSua.setForeground(Color.WHITE);
		btnSua.setBackground(new Color(0, 153, 204));
		btnSua.setBounds(391, 192, 95, 37);
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 16));

		JButton btnXoa = new JButton("Xóa");
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setBackground(new Color(204, 0, 0));
		btnXoa.setBounds(530, 192, 95, 37);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 16));

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 54, 850, 120);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));

		JLabel lblNewLabel_6 = new JLabel("Quản lý kho hàng");
		lblNewLabel_6.setBounds(349, 11, 177, 25);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.setLayout(null);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Tên hàng:");
		lblNewLabel_1.setBounds(10, 24, 82, 20);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNewLabel_1);

		txtTenhang = new JTextField();
		txtTenhang.setBounds(102, 21, 222, 26);
		txtTenhang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenhang.setColumns(10);
		panel_1.add(txtTenhang);

		JLabel lblNewLabel_2 = new JLabel("Nhà cung cấp:");
		lblNewLabel_2.setBounds(10, 76, 114, 20);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNewLabel_2);

		txtLoai = new JTextField();
		txtLoai.setBounds(400, 21, 146, 26);
		txtLoai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtLoai.setColumns(10);
		panel_1.add(txtLoai);

		JLabel lblNewLabel_5 = new JLabel("Loại:");
		lblNewLabel_5.setBounds(350, 24, 40, 20);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNewLabel_5);

		txtGia = new JTextField();
		txtGia.setBounds(400, 73, 146, 26);
		txtGia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtGia.setColumns(10);
		panel_1.add(txtGia);

		JLabel lblNewLabel_3 = new JLabel("Giá:");
		lblNewLabel_3.setBounds(350, 76, 33, 20);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNewLabel_3);

		txtTenncc = new JTextField();
		txtTenncc.setBounds(134, 73, 190, 26);
		txtTenncc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenncc.setColumns(10);
		panel_1.add(txtTenncc);

		JLabel lblNewLabel_4 = new JLabel("Số lượng:");
		lblNewLabel_4.setBounds(557, 24, 77, 20);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNewLabel_4);

		txtSoluong = new JTextField();
		txtSoluong.setBounds(644, 21, 70, 26);
		txtSoluong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSoluong.setColumns(10);
		panel_1.add(txtSoluong);
		panel.add(panel_1);
		panel.add(lblNewLabel_6);
		panel.add(lblNewLabel);
		panel.add(btnThem);
		panel.add(btnSua);
		panel.add(btnXoa);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 277, 850, 243);
		panel.add(scrollPane);

		tbHang = new JTable();
		
		tbHang.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã hàng", "Tên hàng", "Loại hàng", "Nhà cung cấp", "Giá" , "Số lượng"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tbHang);
		
		model = (DefaultTableModel)tbHang.getModel();
		
		JButton btnBack = new JButton("Quay lại");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main main = new Main();
				main.main(null);
				frmQunLKho.dispose();
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(new Color(255, 102, 0));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBack.setBounds(10, 16, 109, 29);
		panel.add(btnBack);
	}

	private void load() {
		hangHoa = new DHangHoa().getListHH();
		model.setRowCount(0);
		for(HangHoa hh:hangHoa) {
			model.addRow(new Object[] {
					hh.getMaHang(),hh.getTenHang(),hh.getLoaiHang(),hh.getTenNhaCC(),hh.getGia(),hh.getSoLuong()
			});
		}
	}
}
