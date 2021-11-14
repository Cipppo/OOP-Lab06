package it.unibo.oop.lab.exception2;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * JUnit test to test
 * {@link StrictBankAccount}.
 * 
 */
public final class TestStrictBankAccount {

    /**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
    @Test
    public void testBankOperations() {
        /*
         * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a
         * scelta, con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
         * 
         * 2) Effetture un numero di operazioni a piacere per verificare che le
         * eccezioni create vengano lanciate soltanto quando opportuno, cioè in
         * presenza di un id utente errato, oppure al superamento del numero di
         * operazioni ATM gratuite.
         */
    	
    	final AccountHolder usr1 = new AccountHolder("Mario", "Rossi", 1);
    	final AccountHolder usr2 = new AccountHolder("Luigi", "Bianchi", 2);
    	
    	final StrictBankAccount acc1 = new StrictBankAccount(usr1.getUserID(), 10_000, 10);
    	final StrictBankAccount acc2 = new StrictBankAccount(usr2.getUserID(), 10_000, 10);
    	
    	
    	try {
    		acc1.deposit(4, 100);
    		fail();
    	}catch(WrongAccountHolderException e) {
    		assertNotNull(e);
    		e.toString();
    	}
    	
    	for(int i = 0; i < 10; i++) {
    		try {
    			acc2.deposit(usr2.getUserID(), 1);
    		}catch(transactionsOverQuotaExceptio | WrongAccountHolderException e) {
    			e.getMessage();
    		}
    	}
    }
}
