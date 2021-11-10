package it.unibo.oop.lab.exception2;

public class notEnoughFoundsException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;

	private final int arg;
	
	public notEnoughFoundsException(int arg) {
		this.arg = arg;
	}
	
	public String toString() {
		return "Impossible to withdraw" + this.arg + "$";
	}
	
}
