package org.intuit.payments.intuitpaymentprocessor.model;

public class TempCharge {
	
	private String chargeId;
	private boolean status;
	
	public String getChargeId() {
		return chargeId;
	}
	public void setChargeId(String chargeId) {
		this.chargeId = chargeId;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public String toString()
	{
		return getChargeId() + " " + isStatus();
	}

}
