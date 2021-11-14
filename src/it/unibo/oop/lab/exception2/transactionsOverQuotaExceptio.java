package it.unibo.oop.lab.exception2;

public class transactionsOverQuotaExceptio extends IllegalStateException {


	private static final long serialVersionUID = 1L;
	
	public String toString() {
		return "The number of ATM transactions gets over the maximum allowed";
	}

}
