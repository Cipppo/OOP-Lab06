package it.unibo.oop.lab.exception2;



public class WrongAccountHolderException extends IllegalArgumentException{

	private static final long serialVersionUID = 1L;
	
	private final int args;
	
	public WrongAccountHolderException(final int args) {
		super();
		this.args = args;
	}

	@Override
	public String toString() {
		return "BankException, il valore " + args + "non e' corretto";
	}
	
	
	
}
