package vn.ngocman.database;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class DoanVienTableModel extends AbstractTableModel {
	private List<DoanVien> li = new ArrayList();
	private String[] columnNames = { "Mã Đoàn Viên", "Chi Đoàn", "Chức Vụ", "Tên Đoàn Viên", "Ngày Sinh", "Giới Tính",
			"Điện Thoại" };

	public DoanVienTableModel(List<DoanVien> list){
         this.li = list;
    }

	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	public int getRowCount() {
		return li.size();
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		DoanVien si = li.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return si.getMaDoanVien();
		case 1:
			return si.getTenChiDoan();
		case 2:
			return si.getTenChucVu();
		case 3:
			return si.getTenDoanVien();
		case 4:
			return si.getNgaySinh();
		case 5:
			return si.getGioiTinh();
		case 6:
			return si.getDienThoai();
		}
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return String.class;
		case 1:
			return String.class;
		case 2:
			return String.class;
		case 3:
			return String.class;
		case 4:
			return String.class;
		case 5:
			return String.class;
		case 6:
			return String.class;
		}
		return null;
	}

}
