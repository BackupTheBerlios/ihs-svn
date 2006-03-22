package com.foo_baz.ihs.backing.mailservice;

import java.util.Arrays;
import java.util.Comparator;
import javax.faces.model.DataModel;
import javax.faces.model.DataModelListener;

import com.foo_baz.ihs.mailservice.User;

public class UsersDataModel extends DataModel {
	private DataModel model;
	private Row[] rows;
	
	private static Comparator byLogin = new
	Comparator() {
		public int compare(Object o1, Object o2) {
			Row r1 = (Row) o1;
			Row r2 = (Row) o2;
			User n1 = (User) r1.getData();
			User n2 = (User) r2.getData();
			return n1.getLogin().compareTo(n2.getLogin());
		}
	};
	
	private static Comparator byPassword = new
	Comparator() {
		public int compare(Object o1, Object o2) {
			Row r1 = (Row) o1;
			Row r2 = (Row) o2;
			User n1 = (User) r1.getData();
			User n2 = (User) r2.getData();
			return n1.getPassword().compareTo(n2.getPassword());
		}
	};
	
	private static Comparator byDir = new
	Comparator() {
		public int compare(Object o1, Object o2) {
			Row r1 = (Row) o1;
			Row r2 = (Row) o2;
			User n1 = (User) r1.getData();
			User n2 = (User) r2.getData();
			return n1.getDir().compareTo(n2.getDir());
		}
	};
	
	private static Comparator byFlags = new
	Comparator() {
		public int compare(Object o1, Object o2) {
			Row r1 = (Row) o1;
			Row r2 = (Row) o2;
			User n1 = (User) r1.getData();
			User n2 = (User) r2.getData();
			if( n1.getFlags() < n2.getFlags() ) return -1;
			return n1.getFlags() == n2.getFlags() ? 0 : 1;
		}
	};

	private static Comparator byUid = new
	Comparator() {
		public int compare(Object o1, Object o2) {
			Row r1 = (Row) o1;
			Row r2 = (Row) o2;
			User n1 = (User) r1.getData();
			User n2 = (User) r2.getData();
			if( n1.getUid() < n2.getUid() ) return -1;
			return n1.getUid() == n2.getUid() ? 0 : 1;
		}
	};
	
	private static Comparator byGid = new
	Comparator() {
		public int compare(Object o1, Object o2) {
			Row r1 = (Row) o1;
			Row r2 = (Row) o2;
			User n1 = (User) r1.getData();
			User n2 = (User) r2.getData();
			if( n1.getGid() < n2.getGid() ) return -1;
			return n1.getGid() == n2.getGid() ? 0 : 1;
		}
	};

	private class Row {
		private int row;
		public Row(int row) {
			this.row = row;
		}
		public Object getData() {
			int originalIndex = model.getRowIndex();
			model.setRowIndex(row);
			Object thisRowData = model.getRowData();
			model.setRowIndex(originalIndex);
			return thisRowData;
		}
	}
	
	public UsersDataModel(DataModel model) {
		this.model = model;
		int rowCnt = model.getRowCount();
		if(rowCnt != -1) {
			rows = new Row[rowCnt];
			for(int i=0; i < rowCnt; ++i) {
				rows[i] = new Row(i);
			}
		}
	}
	
	public String sortByLogin() {
		Arrays.sort(rows, byLogin);
		return null;
	}
	
	public String sortByPassword() {
		Arrays.sort(rows, byPassword);
		return null;
	}
	
	public String sortByDir() {
		Arrays.sort(rows, byDir);
		return null;
	}
	
	public String sortByFlags() {
		Arrays.sort(rows, byFlags);
		return null;
	}

	public String sortByUid() {
		Arrays.sort(rows, byUid);
		return null;
	}
	
	public String sortByGid() {
		Arrays.sort(rows, byGid);
		return null;
	}
	
	public void setRowIndex(int rowIndex) {
		if(rowIndex == -1 || rowIndex >= model.getRowCount()) {
			model.setRowIndex(rowIndex);
		}
		else {
			model.setRowIndex(rows[rowIndex].row);
		}
	}
	
	// The following methods delegate directly to the 
	// decorated model
	
	public boolean isRowAvailable() {
		return model.isRowAvailable();
	}
	public int getRowCount() {
		return model.getRowCount();
	}
	public Object getRowData() {
		return model.getRowData();
	}
	public int getRowIndex() {
		return model.getRowIndex();
	}
	public Object getWrappedData() {
		return model.getWrappedData();
	}
	public void setWrappedData(Object data) {
		model.setWrappedData(data);
	}
	public void addDataModelListener(DataModelListener listener) {
		model.addDataModelListener(listener);
	}
	public DataModelListener[] getDataModelListeners() {
		return model.getDataModelListeners();
	}
	public void removeDataModelListener(DataModelListener listener) {
		model.removeDataModelListener(listener);
	}
}
