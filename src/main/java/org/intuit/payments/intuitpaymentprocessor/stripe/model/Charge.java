package org.intuit.payments.intuitpaymentprocessor.stripe.model;

import java.util.HashMap;

import org.intuit.payments.intuitpaymentprocessor.model.IntuitCard;

public class Charge {
	
	String id;
	String object;	
	int amount;
	int amount_refunded;
	String application_fee;
	String balance_transaction;
	boolean captured;
	String created;
	String currency;
	String customer;
	String source;	
	String description;
	String failure_code;
	String invoice;
	boolean livemode;
	HashMap<String, String> metadeta;
	String order;
	boolean paid;
	String receipt_email;
	String receipt_number;
	boolean refunded;
	String source_transfer;
	String statement_descriptor;
	String status;
	String transfer;
	
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getAmount_refunded() {
		return amount_refunded;
	}
	public void setAmount_refunded(int amount_refunded) {
		this.amount_refunded = amount_refunded;
	}
	public String getApplication_fee() {
		return application_fee;
	}
	public void setApplication_fee(String application_fee) {
		this.application_fee = application_fee;
	}
	public String getBalance_transaction() {
		return balance_transaction;
	}
	public void setBalance_transaction(String balance_transaction) {
		this.balance_transaction = balance_transaction;
	}
	public boolean isCaptured() {
		return captured;
	}
	public void setCaptured(boolean captured) {
		this.captured = captured;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFailure_code() {
		return failure_code;
	}
	public void setFailure_code(String failure_code) {
		this.failure_code = failure_code;
	}
	public String getInvoice() {
		return invoice;
	}
	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}
	public boolean isLivemode() {
		return livemode;
	}
	public void setLivemode(boolean livemode) {
		this.livemode = livemode;
	}
	public HashMap<String, String> getMetadeta() {
		return metadeta;
	}
	public void setMetadeta(HashMap<String, String> metadeta) {
		this.metadeta = metadeta;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	public String getReceipt_email() {
		return receipt_email;
	}
	public void setReceipt_email(String receipt_email) {
		this.receipt_email = receipt_email;
	}
	public String getReceipt_number() {
		return receipt_number;
	}
	public void setReceipt_number(String receipt_number) {
		this.receipt_number = receipt_number;
	}
	public boolean isRefunded() {
		return refunded;
	}
	public void setRefunded(boolean refunded) {
		this.refunded = refunded;
	}
	public String getSource_transfer() {
		return source_transfer;
	}
	public void setSource_transfer(String source_transfer) {
		this.source_transfer = source_transfer;
	}
	public String getStatement_descriptor() {
		return statement_descriptor;
	}
	public void setStatement_descriptor(String statement_descriptor) {
		this.statement_descriptor = statement_descriptor;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTransfer() {
		return transfer;
	}
	public void setTransfer(String transfer) {
		this.transfer = transfer;
	}
	
	

}
