package com.foo_baz.util;

/**
 * 
 */
public class OperationStatus {
	private final int value;
	private final String description;
	
	public static final OperationStatus SUCCESS = new OperationStatus(0);
	public static final OperationStatus WARNING = new OperationStatus(1);
	public static final OperationStatus FAILURE = new OperationStatus(2);

	protected OperationStatus( int value, String desc ) {
		this.value = value;
		this.description = desc;
	}
	
	protected OperationStatus(int value) {
		this(value, null);
	}
	
	/**
	 * 
	 */
	public OperationStatus(OperationStatus res, String desc) {
		this(res.value, desc);
	}
	
	/**
	 * 
	 */
	public OperationStatus(OperationStatus res) {
		this(res, null);
	}
	
	public boolean equals( Object obj ) {
		try {
			return this.value == ((OperationStatus) obj).value;
		} catch(Exception e) {
			return false;
		}
	}

	public String getDescription() {
		return this.description;
	}
}
