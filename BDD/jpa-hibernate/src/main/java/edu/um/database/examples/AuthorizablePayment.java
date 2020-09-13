package edu.um.database.examples;

public class AuthorizablePayment extends Payment {

	private String authorizationCode;

	public AuthorizablePayment() {
		super();
	}

	public AuthorizablePayment(double amount, String currencyId) {
		super(amount, currencyId);
	}

	public AuthorizablePayment authorizationCode(String authorizationCode) {
		setAuthorizationCode(authorizationCode);
		return this;
	}

	public String getAuthorizationCode() {
		return authorizationCode;
	}

	public void setAuthorizationCode(String authorizationCode) {
		this.authorizationCode = authorizationCode;
	}

}
