package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import BUS.BHangHoa;
import BUS.BKhachHang;
import BUS.BKhoHang;
import BUS.BKhoHangCT;
import BUS.BNhapKho;
import BUS.BNhapKhoCT;
import BUS.BXuatKho;
import BUS.BXuatKhoCT;
import DAO.DKhoHangCT;
import DAO.DXuatKho;
import DTO.HangHoa;
import DTO.KhachHang;
import DTO.KhoHang;
import DTO.KhoHangCT;
import DTO.NhapKho;
import DTO.XuatKho;
import DTO.XuatKhoCT;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class QuanLyXuatKho {

	private JFrame frmqlxkho;
	private JTable tbXuatkho;
	private List<XuatKho> xuatkho;
	private DefaultTableModel model;
	private DefaultTableModel model1;
	private DefaultTableModel model2;
	private List<KhoHangCT> khoct;
	private List<KhoHang> kho;	
	private List<KhachHang> kh;
	private JTable tbHang;
	private JTable tbHangXuat;
	private JComboBox<String> cbKho;
	private JComboBox<String> cbH;
	private JTextField txtTong;
	BNhapKho Bnkho = new BNhapKho();
	BXuatKho Bxkho = new BXuatKho();
	BHangHoa Bhh = new BHangHoa();
	BKhoHang Bkho = new BKhoHang();
	BNhapKhoCT Bnkct = new BNhapKhoCT();
	BXuatKhoCT Bxkct = new BXuatKhoCT();
	DKhoHangCT dk=new DKhoHangCT();
	BKhoHangCT Bkhoct = new BKhoHangCT();
	BKhachHang Bkh = new BKhachHang();
	public static int xemchitiet;
	int selectedIndex;
	int s = 0;
	private JTextField txtTimKiem;
	/**
	 * Launch the application.
	 */
	public static void frmqlxkho() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyXuatKho window = new QuanLyXuatKho();
					window.frmqlxkho.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public QuanLyXuatKho() {
		initialize();
		load();
		loadcombobox();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmqlxkho = new JFrame();
		frmqlxkho.setBounds(100, 100, 870, 607);
		frmqlxkho.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmqlxkho.setLocationRelativeTo(null);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmqlxkho.getContentPane().add(tabbedPane, BorderLayout.CENTER);
//TabThongTin=====================================================================================================================================================================================				
		JPanel ThongTinXuatKho = new JPanel();
		tabbedPane.addTab("Thông tin Xuất kho", null, ThongTinXuatKho, null);
		ThongTinXuatKho.setLayout(null);
		
		JLabel lblQuanLyKho = new JLabel("Quản lý xuất kho");
		lblQuanLyKho.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblQuanLyKho.setBounds(336, 11, 177, 25);
		ThongTinXuatKho.add(lblQuanLyKho);
		
		JLabel lblDanhSach = new JLabel("Danh sách xuất kho");
		lblDanhSach.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDanhSach.setBounds(10, 74, 163, 20);
		ThongTinXuatKho.add(lblDanhSach);
		
		JButton btnQuayLai = new JButton("Quay lại");
		btnQuayLai.setForeground(Color.WHITE);
		btnQuayLai.setBackground(new Color(255, 102, 0));
		btnQuayLai.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnQuayLai.setBounds(10, 34, 113, 29);
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main manMain = new Main();
				manMain.main(null);
				frmqlxkho.dispose();
			}
		});
		ThongTinXuatKho.add(btnQuayLai);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 105, 831, 345);
		ThongTinXuatKho.add(scrollPane);
		
		tbXuatkho = new JTable();
		tbXuatkho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ClickCell();
			}
			private void ClickCell() {
				// TODO Auto-generated method stub
				selectedIndex = tbXuatkho.getSelectedRow();
				XuatKho nkho = xuatkho.get(selectedIndex);
				xemchitiet = nkho.getMaXK();
			}
		});
		tbXuatkho.setRowHeight(30);
		tbXuatkho.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã Xuất Kho", "Ngày Xuất", "Tổng tiền","Tên Khách Hàng", "Tên Kho"
			}
		));
		tbXuatkho.setFont(new Font("Dialog", Font.PLAIN, 16));
		model = (DefaultTableModel)tbXuatkho.getModel();
		scrollPane.setViewportView(tbXuatkho);
		
		JButton btnXemChiTiet = new JButton("Xem Chi Tiết");
		btnXemChiTiet.setForeground(Color.WHITE);
		btnXemChiTiet.setBackground(new Color(51, 0, 204));
		btnXemChiTiet.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnXemChiTiet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xemChiTietXuat();
			}

			private void xemChiTietXuat() {
				// TODO Auto-generated method stub
				if(tbXuatkho.getSelectedRow()!=-1) {
					ChiTietXuatKho ctnk = new ChiTietXuatKho();
					ctnk.frmchitietxuatkho();
				}
				else {
					JOptionPane.showMessageDialog(null, "Xin hãy chọn một kho để xem");
				}
			}
		});
		btnXemChiTiet.setBounds(631, 39, 163, 41);
		ThongTinXuatKho.add(btnXemChiTiet);
//TabNhapHang======================================================================================================================================================================================
		JPanel XuatHang = new JPanel();
		tabbedPane.addTab("Xuất hàng ra kho", null, XuatHang, null);
		XuatHang.setLayout(null);
		
		JScrollPane scrollPaneTren = new JScrollPane();
		scrollPaneTren.setBounds(10, 42, 830, 158);
		XuatHang.add(scrollPaneTren);		
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
			new String[] {"Tên Kho", "Mã Hàng","Tên Hàng","Loại Hàng","Giá", "Số Lượng"}));
		model1 = (DefaultTableModel)tbHang.getModel();
		scrollPaneTren.setViewportView(tbHang);
		
		JScrollPane scrollPaneDuoi = new JScrollPane();
		scrollPaneDuoi.setBounds(10, 277, 830, 177);
		XuatHang.add(scrollPaneDuoi);		
		tbHangXuat = new JTable();
		tbHangXuat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ClickReturn();
			}			
		});
		tbHangXuat.setRowHeight(30);
		tbHangXuat.setFont(new Font("Dialog", Font.PLAIN, 16));
		tbHangXuat.setModel(new DefaultTableModel(new Object[][] {},
			new String[] {"Tên Kho","Mã Hàng", "Tên hàng", "Loại hàng", "Giá", "Số lượng"}));
		model2 = (DefaultTableModel)tbHangXuat.getModel();
		scrollPaneDuoi.setViewportView(tbHangXuat);
		
		cbKho = new JComboBox<String>();
//		cbKho.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {				
//				filter(cbKho.getSelectedItem().toString());
//			}
//		});		
		cbKho.setBounds(692, 8, 148, 26);
		XuatHang.add(cbKho);
		
		JLabel lblDanhSachHangHoa = new JLabel("Danh sách hàng hóa");
		lblDanhSachHangHoa.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDanhSachHangHoa.setBounds(10, 11, 211, 20);
		XuatHang.add(lblDanhSachHangHoa);
		
		JLabel lblDanhSachHangHoaDuocNhap = new JLabel("Danh sách hàng hóa được chọn");
		lblDanhSachHangHoaDuocNhap.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDanhSachHangHoaDuocNhap.setBounds(10, 238, 252, 20);
		XuatHang.add(lblDanhSachHangHoaDuocNhap);
		
		JButton btnVe = new JButton("¯\\_( ͡° ͜ʖ ͡°)_/¯");
		btnVe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVe.setBounds(344, 211, 140, 29);
		btnVe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				try {
					selectedIndex = tbHangXuat.getSelectedRow();
					s=s-(int) model2.getValueAt(selectedIndex, 4)* Integer.parseInt((String) model2.getValueAt(selectedIndex, 5));
					txtTong.setText(String.valueOf(s));
					model2.removeRow(selectedIndex);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Không có gì để trả hàng cả");
				}				
			}});		
		XuatHang.add(btnVe);
		
		JButton btnXacNhan = new JButton("Xác Nhận");
		btnXacNhan.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnXacNhan.setBounds(363, 500, 109, 29);
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemNKho();
			}});
		XuatHang.add(btnXacNhan);
		
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
		XuatHang.add(txtTong);
		
		JLabel lblTimKiem = new JLabel("Tìm Kiếm:");
		lblTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTimKiem.setBounds(231, 11, 85, 20);
		XuatHang.add(lblTimKiem);
		
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
		XuatHang.add(txtTimKiem);
		
		cbH = new JComboBox<String>();
		cbH.setBounds(692, 239, 148, 26);
		XuatHang.add(cbH);
	}
	
	private void load() {
		// TODO Auto-generated method stub
		xuatkho = Bxkho.listXuatKho();
		model.setRowCount(0);
		for(XuatKho xk: xuatkho) {
			model.addRow(
				new Object[] {xk.getMaXK(),xk.getNgayXuat(),xk.getTongTien(),xk.getTenKH(),xk.getTenKho()});
		}
		khoct = Bkhoct.listuptable();
		model1.setRowCount(0);
		for(KhoHangCT khoct: khoct) {
			model1.addRow(
					new Object[] {khoct.getTenKho(), khoct.getMaHang(),khoct.getTenHang(),khoct.getLoaiHang(),khoct.getGia(),khoct.getSoLuong()});
		}
		
	}
	private void loadcombobox() {
		// TODO Auto-generated method stub
		kho = Bkho.listKho();
		for(KhoHang khoh: kho ) {
			cbKho.addItem(khoh.getTenKho());
		}
		kh = Bkh.listKhachHang();
		for(KhachHang khachhang: kh) {
			cbH.addItem(khachhang.getTenKH());
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
		int n = Integer.parseInt(m);
		int k = (int) model1.getValueAt(selectedIndex, 5);
		if(n>k) {
			JOptionPane.showMessageDialog(null, "Nhap so luong it hon trong kho");
			ClickAdd();
		}if(m==null||m.equals("")) {
			System.out.print("Lỗi");
		}else {
			KhoHangCT kct = khoct.get(selectedIndex);
				model2.addRow(new Object[] { kct.getTenKho(), kct.getMaHang(), kct.getTenHang(), kct.getLoaiHang(), kct.getGia() , m});
				s=s+(int) model1.getValueAt(selectedIndex, 4)*Integer.parseInt(m);
				txtTong.setText(String.valueOf(s));			
		}
	}
	private void ClickReturn() {
		// TODO Auto-generated method stub
		
	}
	private void ThemNKho() {		
		int rows= model2.getRowCount();
		if(rows !=-1) {
		XuatKho xk = new XuatKho();
		xk.setMaKho(Bkho.getMaKho(cbKho.getSelectedItem().toString()));
		xk.setTongTien(Integer.parseInt(txtTong.getText()));
		xk.setNgayXuat(java.time.LocalDate.now().toString());
		xk.setMaKH(Bkh.getMaHang(cbH.getSelectedItem().toString()));
//		System.out.println(Bkh.getMaHang(cbH.getSelectedItem().toString()));
		Bxkho.XuatKho(xk);
		load();
		XuatKhoCT xkct=new XuatKhoCT();
		xkct.setMaXK(DXuatKho.temp);
		KhoHangCT khct = new KhoHangCT();
		khct.setMaKho(xk.getMaKho());
			int row= 0;
			for(; row < rows; row++) {				
				xkct.setMaHang(Integer.parseInt( model2.getValueAt(row, 1).toString()));
				xkct.setSoLuong(Integer.parseInt( model2.getValueAt(row, 5).toString()));
				xkct.setTien(Integer.parseInt( model2.getValueAt(row, 4).toString()));			
				Bxkct.xuatkhoChiTiet(xkct);
				int n,m,b;
				b=Integer.parseInt( model2.getValueAt(row, 5).toString());					
				n=Integer.parseInt( model2.getValueAt(row, 1).toString());
				m=Bkho.getMaKho(cbKho.getSelectedItem().toString());
				khct.setMaHang(xkct.getMaHang());
				if(Bkhoct.isChecked(m,n)) {					
					if(DKhoHangCT.temp<=b) {
						Bkhoct.xoaHangTrongKho(khct.getMaHang(),khct.getMaKho());
					}else {
						int s = DKhoHangCT.temp - Integer.parseInt( model2.getValueAt(row, 5).toString());
						khct.setSoLuong(s);
						Bkhoct.nhapSL(khct);
					}
				}else {
					
				}
			}
			JOptionPane.showMessageDialog(null, "Thêm thành công");
		}else {
			JOptionPane.showMessageDialog(null, "Chưa có gì để thêm");
		}
	}	
}
