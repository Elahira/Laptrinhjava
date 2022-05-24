package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import BUS.BHangHoa;
import BUS.BKhoHang;
import BUS.BKhoHangCT;
import BUS.BNhapKho;
import BUS.BNhapKhoCT;
import DAO.DKhoHangCT;
import DAO.DNhapKho;
import DTO.HangHoa;
import DTO.KhoHang;
import DTO.KhoHangCT;
import DTO.NhapKho;
import DTO.NhapKhoCT;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class QuanLyNhapKho {

	private JFrame frmqlnkho;
	private JTable tbNhapkho;
	private List<NhapKho> nhapkho;
	private List<HangHoa> hangHoa;
	private List<KhoHang> kho;
	private DefaultTableModel model;
	private DefaultTableModel model1;
	private JTable tbHang;
	private JTable tbHangNhap;
	private JComboBox<String> cbKho;
	private JTextField txtTong;
	BNhapKho Bnkho = new BNhapKho();
	BHangHoa Bhh = new BHangHoa();
	BKhoHang Bkho = new BKhoHang();
	BNhapKhoCT Bnkct = new BNhapKhoCT();
	DKhoHangCT dk=new DKhoHangCT();
	BKhoHangCT Bkhoct = new BKhoHangCT();
	private DefaultTableModel model2;
	int selectedIndex;
	int s = 0;
	private JTextField txtTimKiem;
	public static int xemchitiet;
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
		loadcombobox();
	}	

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmqlnkho = new JFrame();
		frmqlnkho.setTitle("Quản lý nhập kho");
		frmqlnkho.setBounds(100, 100, 870, 607);
		frmqlnkho.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmqlnkho.setLocationRelativeTo(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmqlnkho.getContentPane().add(tabbedPane, BorderLayout.CENTER);
//TabThongTin=====================================================================================================================================================================================				
		JPanel ThongTinNhapKho = new JPanel();
		tabbedPane.addTab("Thông tin Nhập kho", null, ThongTinNhapKho, null);
		ThongTinNhapKho.setLayout(null);
		
		JLabel lblQuanLyKho = new JLabel("Quản lý nhập kho");
		lblQuanLyKho.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblQuanLyKho.setBounds(336, 11, 177, 25);
		ThongTinNhapKho.add(lblQuanLyKho);
		
		JLabel lblDanhSach = new JLabel("Danh sách nhập kho");
		lblDanhSach.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDanhSach.setBounds(10, 74, 163, 20);
		ThongTinNhapKho.add(lblDanhSach);
		
		JButton btnQuayLai = new JButton("Quay lại");
		btnQuayLai.setForeground(Color.WHITE);
		btnQuayLai.setBackground(new Color(255, 102, 0));
		btnQuayLai.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnQuayLai.setBounds(10, 34, 113, 29);
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main manMain = new Main();
				manMain.main(null);
				frmqlnkho.dispose();
			}
		});
		ThongTinNhapKho.add(btnQuayLai);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 105, 831, 345);
		ThongTinNhapKho.add(scrollPane);
		
		tbNhapkho = new JTable();
		tbNhapkho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ClickCell();
			}

			private void ClickCell() {
				// TODO Auto-generated method stub
				selectedIndex = tbNhapkho.getSelectedRow();
				NhapKho nkho = nhapkho.get(selectedIndex);
				xemchitiet = nkho.getMaNK();
			}
		});
		tbNhapkho.setRowHeight(30);
		tbNhapkho.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã Nhập Kho", "Ngày Nhập", "Tổng tiền", "Tên Kho"
			}
		));
		tbNhapkho.setFont(new Font("Dialog", Font.PLAIN, 16));
		model = (DefaultTableModel)tbNhapkho.getModel();
		scrollPane.setViewportView(tbNhapkho);
		
		JButton btnXemChiTiet = new JButton("Xem Chi Tiết");
		btnXemChiTiet.setForeground(Color.WHITE);
		btnXemChiTiet.setBackground(new Color(51, 0, 204));
		btnXemChiTiet.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnXemChiTiet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xemChiTietNhap();
			}

			private void xemChiTietNhap() {
				// TODO Auto-generated method stub
				if(tbNhapkho.getSelectedRow()!=-1) {
					ChiTietNhapKho ctnk = new ChiTietNhapKho();
					ctnk.frmchitietnhapkho();
				}
				else {
					JOptionPane.showMessageDialog(null, "Xin hãy chọn một kho để xem");
				}
			}
		});
		btnXemChiTiet.setBounds(631, 39, 163, 41);
		ThongTinNhapKho.add(btnXemChiTiet);
//TabNhapHang======================================================================================================================================================================================
		JPanel NhapHang = new JPanel();
		tabbedPane.addTab("Nhập hàng vào kho", null, NhapHang, null);
		NhapHang.setLayout(null);
		
		JScrollPane scrollPaneTren = new JScrollPane();
		scrollPaneTren.setBounds(10, 42, 830, 158);
		NhapHang.add(scrollPaneTren);		
		tbHang = new JTable();
		tbHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ClickAdd();
			}			
		});
		tbHang.setRowHeight(30);
		tbHang.setFont(new Font("Dialog", Font.PLAIN, 16));
		tbHang.setModel(new DefaultTableModel(new Object[][] {},
			new String[] {"Mã hàng", "Tên hàng", "Loại hàng", "Nhà cung cấp", "Giá"}));
		model1 = (DefaultTableModel)tbHang.getModel();
		scrollPaneTren.setViewportView(tbHang);
		
		JScrollPane scrollPaneDuoi = new JScrollPane();
		scrollPaneDuoi.setBounds(10, 277, 830, 177);
		NhapHang.add(scrollPaneDuoi);		
		tbHangNhap = new JTable();
		tbHangNhap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ClickReturn();
			}			
		});
		tbHangNhap.setRowHeight(30);
		tbHangNhap.setFont(new Font("Dialog", Font.PLAIN, 16));
		tbHangNhap.setModel(new DefaultTableModel(new Object[][] {},
			new String[] {"Mã hàng", "Tên hàng", "Loại hàng", "Nhà cung cấp", "Giá", "Số lượng"}));
		model2 = (DefaultTableModel)tbHangNhap.getModel();
		scrollPaneDuoi.setViewportView(tbHangNhap);
		
		cbKho = new JComboBox<String>();
		cbKho.setBounds(692, 235, 148, 31);
		NhapHang.add(cbKho);
		
		JLabel lblDanhSachHangHoa = new JLabel("Danh sách hàng hóa");
		lblDanhSachHangHoa.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDanhSachHangHoa.setBounds(10, 11, 190, 20);
		NhapHang.add(lblDanhSachHangHoa);
		
		JLabel lblDanhSachHangHoaDuocNhap = new JLabel("Danh sách hàng hóa được nhập");
		lblDanhSachHangHoaDuocNhap.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDanhSachHangHoaDuocNhap.setBounds(10, 238, 252, 20);
		NhapHang.add(lblDanhSachHangHoaDuocNhap);
		
		JButton btnThem = new JButton("¯\\_( ͡° ͜ʖ ͡°)_/¯");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThem.setBounds(344, 211, 140, 29);
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				try {
					selectedIndex = tbHangNhap.getSelectedRow();
					s=s-(int) model2.getValueAt(selectedIndex, 4)* Integer.parseInt((String) model2.getValueAt(selectedIndex, 5));
					txtTong.setText(String.valueOf(s));
					model2.removeRow(selectedIndex);
//				} catch (Exception e1) {
//					JOptionPane.showMessageDialog(null, "Không có gì để trả hàng cả");
//				}
				
			}});		
		NhapHang.add(btnThem);
		
		JButton btnXacNhan = new JButton("Xác Nhận");
		btnXacNhan.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnXacNhan.setBounds(363, 500, 109, 29);
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemNKho();
			}});
		NhapHang.add(btnXacNhan);
		
		txtTong = new JTextField();
		txtTong.setBackground(Color.WHITE);
		txtTong.setDisabledTextColor(Color.WHITE);
		txtTong.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txtTong.setForeground(Color.BLACK);
		txtTong.setHorizontalAlignment(SwingConstants.CENTER);
		txtTong.setEditable(false);
		txtTong.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtTong.setBounds(692, 465, 147, 31);
		txtTong.setColumns(10);
		NhapHang.add(txtTong);
		
		JLabel lblTimKiem = new JLabel("Tìm Kiếm:");
		lblTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTimKiem.setBounds(231, 11, 85, 20);
		NhapHang.add(lblTimKiem);
		
		txtTimKiem = new JTextField();
		txtTimKiem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				filter(txtTimKiem.getText());
			}			
		});
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTimKiem.setBounds(311, 8, 217, 26);		
		txtTimKiem.setColumns(10);
		NhapHang.add(txtTimKiem);
	}
	
	private void load() {
		// TODO Auto-generated method stub
		nhapkho = Bnkho.listNhapKho();
		model.setRowCount(0);
		for(NhapKho nk: nhapkho) {
			model.addRow(
				new Object[] {nk.getMaNK(),nk.getNgayNhap(),nk.getTongTien(),nk.getTenKho()});
		}
		hangHoa = Bhh.listHangHoa();
		model1.setRowCount(0);
		for (HangHoa hh : hangHoa) {
			model1.addRow(new Object[] { hh.getMaHang(), hh.getTenHang(), hh.getLoaiHang(), hh.getTenNhaCC(), hh.getGia() });
		}
	}
	private void loadcombobox() {
		// TODO Auto-generated method stub
		kho = Bkho.listKho();
		for(KhoHang khoh: kho ) {
			cbKho.addItem(khoh.getTenKho());
		}
	}
	private void filter(String search) {
		// TODO Auto-generated method stub
		TableRowSorter<DefaultTableModel> tRowSorter = new TableRowSorter<DefaultTableModel>(model1);
		tbHang.setRowSorter(tRowSorter);
		tRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + search));
	}
	private void ClickAdd() {
		// TODO Auto-generated method stub
		selectedIndex = tbHang.getSelectedRow();	
		String m = JOptionPane.showInputDialog("Nhập số lượng");
		if(m==null||m.equals("")) {
			System.out.print("Lỗi");
		}else {
			HangHoa hh = hangHoa.get(selectedIndex);
//			int a = (int) model1.getValueAt(selectedIndex, 0);
//			System.out.print(a);			
//			if(model1.getValueAt(selectedIndex, 0)!=model2.getValueAt(0, 0)) {
				model2.addRow(new Object[] { hh.getMaHang(), hh.getTenHang(), hh.getLoaiHang(), hh.getTenNhaCC(), hh.getGia() , m});
				s=s+(int) model1.getValueAt(selectedIndex, 4)*Integer.parseInt(m);
				txtTong.setText(String.valueOf(s));
				
//			}else {
//				model2.setValueAt(m, 0, 5);
//			}
		}
	}
	private void ClickReturn() {
		// TODO Auto-generated method stub
		
	}
	private void ThemNKho() {		
		int rows= model2.getRowCount();

		if(rows !=-1) {
		NhapKho nk = new NhapKho();
		nk.setMaKho(Bkho.getMaKho(cbKho.getSelectedItem().toString()));
		nk.setTongTien(Integer.parseInt(txtTong.getText()));
		nk.setNgayNhap(java.time.LocalDate.now().toString());
		Bnkho.NhapKho(nk);
		load();
		NhapKhoCT nkct=new NhapKhoCT();
		nkct.setMaNK(DNhapKho.temp);
		KhoHangCT khct = new KhoHangCT();
		khct.setMaKho(nk.getMaKho());
			int row= 0;
			for(; row < rows; row++) {				
				nkct.setMaHang(Integer.parseInt( model2.getValueAt(row, 0).toString()));
				nkct.setSoLuong(Integer.parseInt( model2.getValueAt(row, 5).toString()));
				nkct.setTien(Integer.parseInt( model2.getValueAt(row, 4).toString()));			
				Bnkct.nhapKhoChiTiet(nkct);
				int n,m;
				n=Integer.parseInt( model2.getValueAt(row, 0).toString());
				m=Bkho.getMaKho(cbKho.getSelectedItem().toString());
				khct.setMaHang(nkct.getMaHang());
				if(Bkhoct.isChecked(m,n)) {
					int s = DKhoHangCT.temp + Integer.parseInt( model2.getValueAt(row, 5).toString());
					khct.setSoLuong(s);
					Bkhoct.nhapSL(khct);
					System.out.print("Oke");
				}else {
					khct.setSoLuong(nkct.getSoLuong());
					Bkhoct.nhapKhoHang(khct);
					System.out.print("Ko");
				}
				
			}
			JOptionPane.showMessageDialog(null, "Thêm thành công");
		}else {
			JOptionPane.showMessageDialog(null, "Chưa có gì để thêm");
		}
	}
}
