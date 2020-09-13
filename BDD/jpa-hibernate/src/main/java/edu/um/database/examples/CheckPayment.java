package edu.um.database.examples;

import java.util.Date;

public class CheckPayment extends AuthorizablePayment {
	private Date toDate;
	private String account;
	private String bank;
	private String number;
	
	public CheckPayment(double amount, String currencyId) {
		super(amount, currencyId);
	}

	public CheckPayment() {
		super();
	}
	
	public AuthorizablePayment toDate(Date date) {
		setToDate(date);
		return this;
	}

	public CheckPayment account(String account) {
		setAccount(account);
		return this;
	}

	public CheckPayment bank(String bank) {
		setBank(bank);
		return this;
	}
	
	public CheckPayment number(String number) {
		setNumber(number);
		return this;
	}
	
	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
