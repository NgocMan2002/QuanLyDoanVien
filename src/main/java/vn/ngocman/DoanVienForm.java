package vn.ngocman;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import vn.ngocman.database.ChiDoan;
import vn.ngocman.database.ChiDoanTableModdel;
import vn.ngocman.database.ChucVu;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.management.loading.PrivateClassLoader;
import javax.swing.ButtonGroup;
import javax.swing.JList;
import javax.swing.JComboBox;

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
	private JTextField txtMaChiDoan;
	private JTextField txtMaChucVu;
	private JComboBox cbxChiDoan;
	private JComboBox cbxChucVu;
	private JButton btnUpdate;
	private JButton btnDelete;

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
		lblNewLabel_1.setBounds(38, 189, 72, 29);
		frame.getContentPane().add(lblNewLabel_1);

		txtTen = new JTextField();
		txtTen.setBounds(120, 189, 347, 29);
		frame.getContentPane().add(txtTen);
		txtTen.setColumns(2);

		JLabel lblNewLabel_1_1 = new JLabel("Ng\u00E0y Sinh");
		lblNewLabel_1_1.setBounds(38, 222, 72, 38);
		frame.getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Gi\u1EDBi T\u00EDnh");
		lblNewLabel_1_2.setBounds(38, 252, 72, 46);
		frame.getContentPane().add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("\u0110i\u1EC7n Tho\u1EA1i");
		lblNewLabel_1_3.setBounds(38, 294, 72, 38);
		frame.getContentPane().add(lblNewLabel_1_3);

		btnNewButton = new JButton("Th\u00EAm \u0110o\u00E0n Vi\u00EAn");
		btnNewButton.setBounds(120, 333, 109, 42);
		frame.getContentPane().add(btnNewButton);

		txtNgaySinh = new JFormattedTextField();
		txtNgaySinh.setBounds(120, 229, 347, 29);
		frame.getContentPane().add(txtNgaySinh);

		radioNam = new JRadioButton("Nam");
		buttonGroup.add(radioNam);
		radioNam.setBounds(117, 264, 57, 23);
		frame.getContentPane().add(radioNam);

		radioNu = new JRadioButton("N\u1EEF");
		buttonGroup.add(radioNu);
		radioNu.setBounds(188, 264, 109, 23);
		frame.getContentPane().add(radioNu);

		txtDienThoai = new JFormattedTextField();
		txtDienThoai.setBounds(120, 294, 347, 29);
		frame.getContentPane().add(txtDienThoai);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 387, 998, 301);
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

		cbxChiDoan = new JComboBox();
		cbxChiDoan.setBounds(120, 149, 274, 29);
		frame.getContentPane().add(cbxChiDoan);

		JLabel lblNewLabel_1_4_1 = new JLabel("Chi Đoàn");
		lblNewLabel_1_4_1.setBounds(38, 149, 72, 29);
		frame.getContentPane().add(lblNewLabel_1_4_1);

		JLabel lblNewLabel_1_4_1_1 = new JLabel("Chức Vụ");
		lblNewLabel_1_4_1_1.setBounds(38, 101, 72, 29);
		frame.getContentPane().add(lblNewLabel_1_4_1_1);

		cbxChucVu = new JComboBox();
		cbxChucVu.setBounds(120, 101, 274, 29);
		frame.getContentPane().add(cbxChucVu);
		
		btnUpdate = new JButton("Sửa Đoàn Viên");
		btnUpdate.setEnabled(false);
		btnUpdate.setBounds(251, 333, 103, 42);
		frame.getContentPane().add(btnUpdate);
		
		btnDelete = new JButton("Xóa Đoàn Viên");
		btnDelete.setEnabled(false);
		btnDelete.setBounds(364, 333, 103, 42);
		frame.getContentPane().add(btnDelete);

	}

	private void hienThiDoanVien() {
		List<DoanVien> doanViens = DoanVienDao.layDanhSachDoanVien();
		List<ChiDoan> chiDoans = DoanVienDao.layDanhSachChiDoan();
		for (ChiDoan chiDoan : chiDoans) {
			cbxChiDoan.addItem(chiDoan);
		}
		List<ChucVu> chucVus = DoanVienDao.layDanhSachChucVu();
		for (ChucVu chucVu : chucVus) {
			cbxChucVu.addItem(chucVu);
		}
		table.setModel(new DoanVienTableModel(doanViens));
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (table.getSelectedRow() < 0) {
					return;
				}
				btnUpdate.setEnabled(true);
				btnDelete.setEnabled(true);
				txtMaDoanVien.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
				txtTen.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
				txtNgaySinh.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
				txtDienThoai.setText(table.getValueAt(table.getSelectedRow(), 6).toString());
				if (table.getValueAt(table.getSelectedRow(), 5).toString().equals("Nam")) {
					radioNam.setSelected(true);
				} else {
					radioNu.setSelected(true);
				}
				for (int i = 0; i < cbxChucVu.getItemCount(); i++) {
					if (cbxChucVu.getItemAt(i).toString().equals(table.getValueAt(table.getSelectedRow(), 2).toString())) {
						cbxChucVu.setSelectedIndex(i);
						break;
					}
				}
				for (int i = 0; i < cbxChiDoan.getItemCount(); i++) {
					if (cbxChiDoan.getItemAt(i).toString().equals(table.getValueAt(table.getSelectedRow(), 1).toString())) {
						cbxChiDoan.setSelectedIndex(i);
						break;
					}
				}
//				txtMaDoanVien.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
//				txtMaDoanVien.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
//				txtMaDoanVien.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
			}
		});

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
				doanVien.setMaChiDoan(((ChiDoan) cbxChiDoan.getSelectedItem()).getMaChiDoan());
				doanVien.setMaChucVu(((ChucVu) cbxChucVu.getSelectedItem()).getMaChucVu());
				DoanVienDao.themDoanVien(doanVien);
				List<DoanVien> doanViens = DoanVienDao.layDanhSachDoanVien();
				table.setModel(new DoanVienTableModel(doanViens));
			}
		});
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoanVien doanVien = new DoanVien();
				doanVien.setMaDoanVien(txtMaDoanVien.getText());
				doanVien.setMaChiDoan("IT001");
				doanVien.setMaChucVu("IT_1");
				doanVien.setTenDoanVien(txtTen.getText());
				doanVien.setNgaySinh(txtNgaySinh.getText());
				doanVien.setGioiTinh(radioNam.isSelected() ? "Nam" : "Nữ");
				doanVien.setDienThoai(txtDienThoai.getText());
				doanVien.setMaChiDoan(((ChiDoan) cbxChiDoan.getSelectedItem()).getMaChiDoan());
				doanVien.setMaChucVu(((ChucVu) cbxChucVu.getSelectedItem()).getMaChucVu());
				DoanVienDao.suaDoanVien(doanVien);
				List<DoanVien> doanViens = DoanVienDao.layDanhSachDoanVien();
				table.setModel(new DoanVienTableModel(doanViens));
				
				btnUpdate.setEnabled(false);
				btnDelete.setEnabled(false);
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoanVienDao.xoaDoanVien(txtMaDoanVien.getText());
				List<DoanVien> doanViens = DoanVienDao.layDanhSachDoanVien();
				table.setModel(new DoanVienTableModel(doanViens));
				
				btnUpdate.setEnabled(false);
				btnDelete.setEnabled(false);
			}
		});

	}
}
