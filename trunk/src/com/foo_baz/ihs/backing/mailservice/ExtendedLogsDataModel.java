package com.foo_baz.ihs.backing.mailservice;

import java.util.Arrays;
import java.util.Comparator;
import javax.faces.model.DataModel;
import javax.faces.model.DataModelListener;

import com.foo_baz.ihs.mailservice.ExtendedLogEntry;

/**
 * @author $Author$
 * @version $Id$
 */
public class ExtendedLogsDataModel extends DataModel {
	private DataModel model;
	private Row[] rows;
	
	private static Comparator byTime = new
	Comparator() {
		public int compare(Object o1, Object o2) {
			Row r1 = (Row) o1;
			Row r2 = (Row) o2;
			ExtendedLogEntry n1 = (ExtendedLogEntry) r1.getData();
			ExtendedLogEntry n2 = (ExtendedLogEntry) r2.getData();
			return n1.getTime().compareTo(n2.getTime());
		}
	};
	
	private static Comparator byService = new
	Comparator() {
		public int compare(Object o1, Object o2) {
			Row r1 = (Row) o1;
			Row r2 = (Row) o2;
			ExtendedLogEntry n1 = (ExtendedLogEntry) r1.getData();
			ExtendedLogEntry n2 = (ExtendedLogEntry) r2.getData();
			return n1.getServiceAsString().compareTo(n2.getServiceAsString());
		}
	};
	
	private static Comparator byMessage = new
	Comparator() {
		public int compare(Object o1, Object o2) {
			Row r1 = (Row) o1;
			Row r2 = (Row) o2;
			ExtendedLogEntry n1 = (ExtendedLogEntry) r1.getData();
			ExtendedLogEntry n2 = (ExtendedLogEntry) r2.getData();
			return n1.getMessage().compareTo(n2.getMessage());
		}
	};
	
	private static Comparator byLogin = new
	Comparator() {
		public int compare(Object o1, Object o2) {
			Row r1 = (Row) o1;
			Row r2 = (Row) o2;
			ExtendedLogEntry n1 = (ExtendedLogEntry) r1.getData();
			ExtendedLogEntry n2 = (ExtendedLogEntry) r2.getData();
			return n1.getLogin().compareTo(n2.getLogin());
		}
	};
	
	private static Comparator byDomain = new
	Comparator() {
		public int compare(Object o1, Object o2) {
			Row r1 = (Row) o1;
			Row r2 = (Row) o2;
			ExtendedLogEntry n1 = (ExtendedLogEntry) r1.getData();
			ExtendedLogEntry n2 = (ExtendedLogEntry) r2.getData();
			return n1.getDomain().compareTo(n2.getDomain());
		}
	};
	
	private static Comparator byResult = new
	Comparator() {
		public int compare(Object o1, Object o2) {
			Row r1 = (Row) o1;
			Row r2 = (Row) o2;
			ExtendedLogEntry n1 = (ExtendedLogEntry) r1.getData();
			ExtendedLogEntry n2 = (ExtendedLogEntry) r2.getData();
			return n1.getResultAsString().compareTo(n2.getResultAsString());
		}
	};
	
	private static Comparator byIp = new
	Comparator() {
		public int compare(Object o1, Object o2) {
			Row r1 = (Row) o1;
			Row r2 = (Row) o2;
			ExtendedLogEntry n1 = (ExtendedLogEntry) r1.getData();
			ExtendedLogEntry n2 = (ExtendedLogEntry) r2.getData();
			return n1.getIp().compareTo(n2.getIp());
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
	
	public ExtendedLogsDataModel(DataModel model) {
		this.model = model;
		int rowCnt = model.getRowCount();
		if(rowCnt != -1) {
			rows = new Row[rowCnt];
			for(int i=0; i < rowCnt; ++i) {
				rows[i] = new Row(i);
			}
		}
	}
	
	public String sortByTime() {
		Arrays.sort(rows, byTime);
		return null;
	}
	
	public String sortByService() {
		Arrays.sort(rows, byService);
		return null;
	}
	
	public String sortByMessage() {
		Arrays.sort(rows, byMessage);
		return null;
	}
	
	public String sortByLogin() {
		Arrays.sort(rows, byLogin);
		return null;
	}
	
	public String sortByDomain() {
		Arrays.sort(rows, byDomain);
		return null;
	}
	
	public String sortByIp() {
		Arrays.sort(rows, byIp);
		return null;
	}
	
	public String sortByResult() {
		Arrays.sort(rows, byResult);
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
