package vn.ngocman;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import vn.ngocman.database.DoanPhi;
import vn.ngocman.database.DoanPhiTableModel;
import vn.ngocman.database.DoanVienDao;

public class DanhSachDoanPhi {
	JFrame f;
	 
	DanhSachDoanPhi() {
        f = new JFrame();
    	f.setTitle("Danh sach doan phi");
        List<DoanPhi> doanPhis = DoanVienDao.layDanhSachDoanPhi();
 
        JTable jt = new JTable();
        jt.setModel(new DoanPhiTableModel(doanPhis));
        jt.setBounds(30, 40, 200, 300);
 
        JScrollPane sp = new JScrollPane(jt);
        f.add(sp);
 
        f.setSize(1000, 700);
        f.setVisible(true);
    }
	
	public static void hienThiDanhSachDoanPhi() {
		new DanhSachDoanPhi();
	}

}
