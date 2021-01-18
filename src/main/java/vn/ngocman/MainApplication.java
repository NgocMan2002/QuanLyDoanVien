package vn.ngocman;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainApplication {
	public static void main(String[] args) {
		JFrame f=new JFrame();//creating instance of JFrame  
        f.setTitle("Chuong trinh quan ly doan vien");
		
        JButton b=new JButton("Danh Sach Doan Vien");//creating instance of JButton  
		b.setBounds(10,50,300, 40);//x axis, y axis, width, height            
		f.add(b);//adding button in JFrame 
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DanhSachDoanVien.hienThiDanhSachDoanVien();
			}
		});
		
		JButton b2=new JButton("Danh Sach Chi Doan");
		b2.setBounds(10,110,300, 40);   
		f.add(b2);
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DanhSachChiDoan.hienThiDanhSachChiDoan();
			}
		});
		JButton b3=new JButton("Danh Sach Chuc Vu"); 
		b3.setBounds(10,180,300, 40);           
		f.add(b3);
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DanhSachChucVu.hienThiDanhSachChucVu();
			}
		});
		JButton b4=new JButton("Danh Sach Khoa"); 
		b4.setBounds(10,250,300, 40);           
		f.add(b4);
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DanhSachKhoa.hienThiDanhSachKhoa();
			}
		});
		JButton b5=new JButton("Danh Sach Doan Phi"); 
		b5.setBounds(10,320,300, 40);           
		f.add(b5);
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DanhSachDoanPhi.hienThiDanhSachDoanPhi();
			}
		});
		
		          
		f.setSize(1000,500);//400 width and 500 height  
		f.setLayout(null);//using no layout managers  
		f.setVisible(true);//making the frame visible  
	}
}
