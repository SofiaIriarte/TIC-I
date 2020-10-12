package edu.um.database.examples;

public class CreditCardPayment extends AuthorizablePayment {
	private String bin;
	private String bank;

	public CreditCardPayment(double amount, String currencyId, String bin,
			String authorizationCode, String bank) {
		super(amount, currencyId);
		this.bin = bin;
		this.bank = bank;
	}

	public CreditCardPayment() {
		super();
	}
	
	public String getBin() {
		return bin;
	}

	public void setBin(String bin) {
		this.bin = bin;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

}
