package edu.um.database.examples;

public class Payment {
	private Long id;
	private double amount;
	private String currencyId;

	public Payment(double amount, String currencyId) {
		super();
		this.amount = amount;
		this.currencyId = currencyId;
	}

	public Payment() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}

}
