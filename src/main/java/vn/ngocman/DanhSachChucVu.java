package vn.ngocman;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import vn.ngocman.database.ChucVu;
import vn.ngocman.database.ChucVuTableModel;
import vn.ngocman.database.DoanVienDao;
public class DanhSachChucVu {
	JFrame f;
	 
	DanhSachChucVu() {
        f = new JFrame();
    	f.setTitle("Danh sach chuc vu");
        List<ChucVu> chucVus = DoanVienDao.layDanhSachChucVu();
 
        JTable jt = new JTable();
        jt.setModel(new ChucVuTableModel(chucVus));
        jt.setBounds(30, 40, 200, 300);
 
        JScrollPane sp = new JScrollPane(jt);
        f.add(sp);
 
        f.setSize(400, 600);
        f.setVisible(true);
    }
	
	public static void hienThiDanhSachChucVu() {
		new DanhSachChucVu();
	}
}
