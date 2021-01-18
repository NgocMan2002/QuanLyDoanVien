package vn.ngocman;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import vn.ngocman.database.ChiDoan;
import vn.ngocman.database.ChiDoanTableModdel;
import vn.ngocman.database.DoanVienDao;

public class DanhSachChiDoan {
	JFrame f;
	 
	DanhSachChiDoan() {
        f = new JFrame();
    	f.setTitle("Danh sach chi doan");
        List<ChiDoan> chiDoans = DoanVienDao.layDanhSachChiDoan();
 
        JTable jt = new JTable();
        jt.setModel(new ChiDoanTableModdel(chiDoans));
        jt.setBounds(30, 40, 200, 300);
 
        JScrollPane sp = new JScrollPane(jt);
        f.add(sp);
 
        f.setSize(500, 300);
        f.setVisible(true);
    }
	
	public static void hienThiDanhSachChiDoan() {
		new DanhSachChiDoan();
	}
}
