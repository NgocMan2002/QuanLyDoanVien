package vn.ngocman;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import vn.ngocman.database.DoanVienDao;
import vn.ngocman.database.Khoa;
import vn.ngocman.database.KhoaTableModel;

public class DanhSachKhoa {
	JFrame f;
	 
	DanhSachKhoa() {
        f = new JFrame();
    	f.setTitle("Danh sach khoa");
        List<Khoa> Khoas = DoanVienDao.layDanhSachKhoa();
 
        JTable jt = new JTable();
        jt.setModel(new KhoaTableModel(Khoas));
        jt.setBounds(30, 40, 200, 300);
 
        JScrollPane sp = new JScrollPane(jt);
        f.add(sp);
 
        f.setSize(1000, 700);
        f.setVisible(true);
    }
	
	public static void hienThiDanhSachKhoa() {
		new DanhSachKhoa();
	}
}


