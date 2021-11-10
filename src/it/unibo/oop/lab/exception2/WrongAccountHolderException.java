package it.unibo.oop.lab.exception2;



public class WrongAccountHolderException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private final String args;
	
	public WrongAccountHolderException(final String s, final String args) {
		super(s);
		this.args = args;
	}

	@Override
	public String toString() {
		return "BankException, il valore " + args + "non e' corretto";
	}
	
	
	
}
