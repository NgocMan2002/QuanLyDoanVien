package vn.ngocman;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import vn.ngocman.database.DoanVien;
import vn.ngocman.database.DoanVienDao;
import vn.ngocman.database.DoanVienTableModel;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;

public class DoanVienForm {

	private JFrame frame;
	private JTextField txtTen;
	private JFormattedTextField txtDienThoai;
	private JFormattedTextField txtNgaySinh;
	private JTable table;
	private JButton btnDanhSchChi;
	private JButton btnDanhSchChc;
	private JButton btnDanhSchKhoa;
	private JButton btnDanhSchon;
	private JButton btnNewButton;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton radioNam;
	private JRadioButton radioNu;
	private JTextField txtMaDoanVien;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoanVienForm window = new DoanVienForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DoanVienForm() {
		initialize();
		hienThiDoanVien();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 727);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("CH\u01AF\u01A0NG TR\u00CCNH QU\u1EA2N L\u00DD \u0110O\u00C0N VI\u00CAN");
		lblNewLabel.setBounds(153, 0, 634, 38);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EAn");
		lblNewLabel_1.setBounds(38, 101, 72, 29);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtTen = new JTextField();
		txtTen.setBounds(120, 101, 347, 29);
		frame.getContentPane().add(txtTen);
		txtTen.setColumns(2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ng\u00E0y Sinh");
		lblNewLabel_1_1.setBounds(38, 134, 72, 38);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Gi\u1EDBi T\u00EDnh");
		lblNewLabel_1_2.setBounds(38, 164, 72, 46);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("\u0110i\u1EC7n Tho\u1EA1i");
		lblNewLabel_1_3.setBounds(38, 206, 72, 38);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		btnNewButton = new JButton("Th\u00EAm \u0110o\u00E0n Vi\u00EAn");
		btnNewButton.setBounds(120, 245, 347, 42);
		frame.getContentPane().add(btnNewButton);
		
		txtNgaySinh = new JFormattedTextField();
		txtNgaySinh.setBounds(120, 141, 347, 29);
		frame.getContentPane().add(txtNgaySinh);
		
		radioNam = new JRadioButton("Nam");
		buttonGroup.add(radioNam);
		radioNam.setBounds(117, 176, 57, 23);
		frame.getContentPane().add(radioNam);
		
		radioNu = new JRadioButton("N\u1EEF");
		buttonGroup.add(radioNu);
		radioNu.setBounds(188, 176, 109, 23);
		frame.getContentPane().add(radioNu);
		
		txtDienThoai = new JFormattedTextField();
		txtDienThoai.setBounds(120, 206, 347, 29);
		frame.getContentPane().add(txtDienThoai);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 352, 998, 336);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		
		btnDanhSchChi = new JButton("Danh S\u00E1ch Chi \u0110o\u00E0n");
		btnDanhSchChi.setBounds(651, 22, 347, 42);
		frame.getContentPane().add(btnDanhSchChi);
		
		btnDanhSchChc = new JButton("Danh S\u00E1ch Ch\u1EE9c V\u1EE5");
		btnDanhSchChc.setBounds(651, 72, 347, 42);
		frame.getContentPane().add(btnDanhSchChc);
		
		btnDanhSchKhoa = new JButton("Danh S\u00E1ch Khoa");
		btnDanhSchKhoa.setBounds(651, 125, 347, 42);
		frame.getContentPane().add(btnDanhSchKhoa);
		
		btnDanhSchon = new JButton("Danh S\u00E1ch \u0110o\u00E0n Ph\u00ED");
		btnDanhSchon.setBounds(651, 172, 347, 42);
		frame.getContentPane().add(btnDanhSchon);
		
		JLabel lblNewLabel_1_4 = new JLabel("Mã Đoàn Viên");
		lblNewLabel_1_4.setBounds(38, 61, 72, 29);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		txtMaDoanVien = new JTextField();
		txtMaDoanVien.setColumns(2);
		txtMaDoanVien.setBounds(120, 61, 347, 29);
		frame.getContentPane().add(txtMaDoanVien);
		
	}
	
	private void hienThiDoanVien() {
		List<DoanVien> doanViens = DoanVienDao.layDanhSachDoanVien();
		table.setModel(new DoanVienTableModel(doanViens));
		
		btnDanhSchChi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DanhSachChiDoan.hienThiDanhSachChiDoan();
			}
		});
		btnDanhSchChc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DanhSachChucVu.hienThiDanhSachChucVu();
			}
		});
		btnDanhSchKhoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DanhSachKhoa.hienThiDanhSachKhoa();
			}
		});
		btnDanhSchon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DanhSachDoanPhi.hienThiDanhSachDoanPhi();
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoanVien doanVien = new DoanVien();
				doanVien.setMaDoanVien(txtMaDoanVien.getText());
				doanVien.setMaChiDoan("IT001");
				doanVien.setMaChucVu("IT_1");
				doanVien.setTenDoanVien(txtTen.getText());
				doanVien.setNgaySinh(txtNgaySinh.getText());
				doanVien.setGioiTinh(radioNam.isSelected() ? "Nam" : "Nữ");
				doanVien.setDienThoai(txtDienThoai.getText());
				DoanVienDao.themDoanVien(doanVien);
				List<DoanVien> doanViens = DoanVienDao.layDanhSachDoanVien();
				table.setModel(new DoanVienTableModel(doanViens));
			}
		});
	}
}
