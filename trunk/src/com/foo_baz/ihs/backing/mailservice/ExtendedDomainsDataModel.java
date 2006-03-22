package com.foo_baz.ihs.backing.mailservice;

import java.util.Arrays;
import java.util.Comparator;
import javax.faces.model.DataModel;
import javax.faces.model.DataModelListener;

import com.foo_baz.ihs.mailservice.ExtendedDomain;

public class ExtendedDomainsDataModel extends DataModel {
	private DataModel model;
	private Row[] rows;
	
	private static Comparator byDomain = new
	Comparator() {
		public int compare(Object o1, Object o2) {
			Row r1 = (Row) o1;
			Row r2 = (Row) o2;
			ExtendedDomain n1 = (ExtendedDomain) r1.getData();
			ExtendedDomain n2 = (ExtendedDomain) r2.getData();
			return n1.getDomain().compareTo(n2.getDomain());
		}
	};
	
	private static Comparator byNumberOfUsers = new
	Comparator() {
		public int compare(Object o1, Object o2) {
			Row r1 = (Row) o1;
			Row r2 = (Row) o2;
			ExtendedDomain n1 = (ExtendedDomain) r1.getData();
			ExtendedDomain n2 = (ExtendedDomain) r2.getData();
			if(n1.getNumberOfUsers() < n2.getNumberOfUsers()) return -1;
			return n1.getNumberOfUsers() == n2.getNumberOfUsers() ? 0 : 1;
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
	
	public ExtendedDomainsDataModel(DataModel model) {
		this.model = model;
		int rowCnt = model.getRowCount();
		if(rowCnt != -1) {
			rows = new Row[rowCnt];
			for(int i=0; i < rowCnt; ++i) {
				rows[i] = new Row(i);
			}
		}
	}
	
	public String sortByDomain() {
		Arrays.sort(rows, byDomain);
		return null;
	}
	
	public String sortByNumberOfUsers() {
		Arrays.sort(rows, byNumberOfUsers);
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
