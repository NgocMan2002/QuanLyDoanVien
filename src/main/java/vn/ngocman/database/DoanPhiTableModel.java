package vn.ngocman.database;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class DoanPhiTableModel extends AbstractTableModel {
	private List<DoanPhi> li = new ArrayList();
	private String[] columnNames = {  "Ma_Doan_Vien", "Ma_Phieu", "Ngay_Nop",
			"So_Tien","Li_Do_Nop" };

	public DoanPhiTableModel(List<DoanPhi> list){
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
		DoanPhi si = li.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return si.getMaDoanVien();
		case 1:
			return si.getMaPhieu();
		case 2:
			return si.getNgayNop();
		case 3:
			return si.getSoTien();
		case 4:
			return si.getLiDoNop();
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
		}
		return null;
	}

}



