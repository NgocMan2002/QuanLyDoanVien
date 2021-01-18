package vn.ngocman.database;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class KhoaTableModel extends AbstractTableModel {
	private List<Khoa> li = new ArrayList();
	private String[] columnNames = { "Ma_Khoa", "Ten_Khoa", "Dien_Thoai" };

	public KhoaTableModel(List<Khoa> list){
         this.li = list;
    }

	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	public int getRowCount() {
		return li.size();
	}

	public int getColumnCount() {
		return 7;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Khoa si = li.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return si.getMaKhoa();
		case 1:
			return si.getTenKhoa();
		case 2:
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
		}
		return null;
	}	
}
