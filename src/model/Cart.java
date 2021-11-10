package model;

import java.io.Serializable;

public class Cart implements Serializable {
	private int id, customerID;
	private boolean paymentStatus;

	
	public boolean isPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Cart(int id, int customerID, boolean paymentStatus) {
		super();
		this.id = id;
		this.customerID = customerID;
		this.paymentStatus = paymentStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
}
