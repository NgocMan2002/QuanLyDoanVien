package vn.ngocman;

import java.util.List;

import javax.swing.*;

import vn.ngocman.database.DoanVien;
import vn.ngocman.database.DoanVienDao;
import vn.ngocman.database.DoanVienTableModel;

public class DanhSachDoanVien {
	JFrame f;
	 
	DanhSachDoanVien() {
        f = new JFrame();
    	f.setTitle("Danh sach doan vien");
        List<DoanVien> doanViens = DoanVienDao.layDanhSachDoanVien();
 
        JTable jt = new JTable();
        jt.setModel(new DoanVienTableModel(doanViens));
        jt.setBounds(30, 40, 200, 300);
 
        JScrollPane sp = new JScrollPane(jt);
        f.add(sp);
 
        f.setSize(1000, 700);
        f.setVisible(true);
    }
	
	public static void hienThiDanhSachDoanVien() {
		new DanhSachDoanVien();
	}
}
