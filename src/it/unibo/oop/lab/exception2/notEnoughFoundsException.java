package it.unibo.oop.lab.exception2;

public class notEnoughFoundsException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;

	private final double arg;
	
	public notEnoughFoundsException(double amount) {
		this.arg = amount;
	}
	
	public String toString() {
		return "Impossible to withdraw" + this.arg + "$";
	}
	
}
