package vn.ngocman.database;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ChiDoanTableModdel extends AbstractTableModel {
	private List<ChiDoan> li = new ArrayList();
	private String[] columnNames = { "Ma_Doan_Vien", "Ma_Chi_Doan", "Ma_Chuc_Vu", "Ten_Doan_Vien" };

	public ChiDoanTableModdel(List<ChiDoan> list) {
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
		ChiDoan ai = li.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return ai.getMaChiDoan();
		case 1:
			return ai.getMaKhoa();
		case 2:
			return ai.getTenChiDoan();
		case 3:
			return ai.getDienThoai();
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
		}
		return null;
	}
}
