package it.unibo.oop.lab.exception2;

/**
 * Class modeling a BankAccount with strict policies: getting money is allowed
 * only with enough founds, and there are also a limited number of free ATM
 * transaction (this number is provided as a input in the constructor).
 * 
 */
public class StrictBankAccount implements BankAccount {

    private final int usrID;
    private double balance;
    private int totalTransactionCount;
    private final int maximumAllowedATMTransactions;
    private static final double ATM_TRANSACTION_FEE = 1;
    private static final double MANAGEMENT_FEE = 5;
    private static final double TRANSACTION_FEE = 0.1;

    /**
     * 
     * @param usrID
     *            user id
     * @param balance
     *            initial balance
     * @param maximumAllowedAtmTransactions
     *            max no of ATM transactions allowed
     */
    public StrictBankAccount(final int usrID, final double balance, final int maximumAllowedAtmTransactions) {
        this.usrID = usrID;
        this.balance = balance;
        this.maximumAllowedATMTransactions = maximumAllowedAtmTransactions;
    }

    /**
     * 
     * {@inheritDoc}
     */
    public void deposit(final int usrID, final double amount) {
        
    	this.checkUser(usrID);
        this.balance += amount;
        increaseTransactionsCount();
        
    }

    /**
     * 
     * {@inheritDoc}
     */
    public void withdraw(final int usrID, final double amount) {
        this.isWithdrawAllowed(amount);
    	this.checkUser(usrID);
        this.balance -= amount;
        increaseTransactionsCount();
    }

    /**
     * 
     * {@inheritDoc}
     */
    public void depositFromATM(final int usrID, final double amount) {
        this.checkATMTransactions();
        this.deposit(usrID, amount - StrictBankAccount.ATM_TRANSACTION_FEE);
        increaseTransactionsCount();
        
    }

    /**
     * 
     * {@inheritDoc}
     */
    public void withdrawFromATM(final int usrID, final double amount) {
        this.checkATMTransactions();
        this.withdraw(usrID, amount + StrictBankAccount.ATM_TRANSACTION_FEE);
    }
    
    private void checkATMTransactions() {
    	if(this.totalTransactionCount >= this.maximumAllowedATMTransactions) {
    		new transactionsOverQuotaExceptio();
    	}
    }

    /**
     * 
     * {@inheritDoc}
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * 
     * {@inheritDoc}
     */
    public int getTransactionCount() {
        return totalTransactionCount;
    }

    /**
     * 
     * @param usrID
     *            id of the user related to these fees
     */
    public void computeManagementFees(final int usrID) {
        final double feeAmount = MANAGEMENT_FEE + (totalTransactionCount * StrictBankAccount.TRANSACTION_FEE);
        this.isWithdrawAllowed(feeAmount);
    	this.checkUser(usrID);
        balance -= MANAGEMENT_FEE + totalTransactionCount * StrictBankAccount.TRANSACTION_FEE;
        totalTransactionCount = 0;
    }

    void checkUser(final int id) {
    	if(this.usrID != id) {
    		new WrongAccountHolderException(id);
    	}
    }

    private void isWithdrawAllowed(final double amount) {
        if(amount > this.balance) {
        	new notEnoughFoundsException(amount);
        }
    }

    private void increaseTransactionsCount() {
        totalTransactionCount++;
    }
}
