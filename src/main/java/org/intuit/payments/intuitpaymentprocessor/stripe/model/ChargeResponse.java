package org.intuit.payments.intuitpaymentprocessor.stripe.model;

public class ChargeResponse {
	
	String id;
	String object;
	int amount;
	int amount_refunded;
	String application_fee;
	String balance_transcation;
	boolean captured;
	String created;
	String currency;
	String customer;
	String description;
	String destination;
	String failure_code;
	String failure_message;
	String invoice;
	boolean livemode;
	String order;
	boolean paid;
	String receipt_number;
	String receipt_email;
	boolean refunded;
	String source_transfer;
	String statement_description;
	String status;
	String transfer;
	
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
	public String getBalance_transcation() {
		return balance_transcation;
	}
	public void setBalance_transcation(String balance_transcation) {
		this.balance_transcation = balance_transcation;
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
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getFailure_code() {
		return failure_code;
	}
	public void setFailure_code(String failure_code) {
		this.failure_code = failure_code;
	}
	public String getFailure_message() {
		return failure_message;
	}
	public void setFailure_message(String failure_message) {
		this.failure_message = failure_message;
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
	public String getReceipt_number() {
		return receipt_number;
	}
	public void setReceipt_number(String receipt_number) {
		this.receipt_number = receipt_number;
	}
	public String getReceipt_email() {
		return receipt_email;
	}
	public void setReceipt_email(String receipt_email) {
		this.receipt_email = receipt_email;
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
	public String getStatement_description() {
		return statement_description;
	}
	public void setStatement_description(String statement_description) {
		this.statement_description = statement_description;
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
