package vn.ngocman.database;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ChucVuTableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ChucVu> li = new ArrayList<ChucVu>();
	private String[] columnNames = { "Ma_Chuc_Vu", "Ten_Chuc_Vu" };

	public ChucVuTableModel(List<ChucVu> list){
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
		ChucVu si = li.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return si.getMaChucVu();
		case 1:
			return si.getTenChucVu();
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
		}
		return null;
	}
}
